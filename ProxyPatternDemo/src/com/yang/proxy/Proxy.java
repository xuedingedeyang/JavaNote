package com.yang.proxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Proxy {
	@SuppressWarnings("deprecation")
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception
	{
		String rt = "\r\n";
		String methodStr = "";
		for(Method m: infce.getMethods())
		{
			methodStr+="@Override"+ rt +
			"public void "+m.getName()+" (){"+ rt +
			"try{"+rt+
			"Method md = "+infce.getName()+".class.getMethod(\""+m.getName()+"\");"+rt+
			"h.invoke(this,md);"+rt+
			"}catch(Exception e){e.printStackTrace();}"+rt+	
			"}";

		}
		String str =
	"package com.yang.proxy;"+ rt +
	"import com.yang.proxy.InvocationHandler;"+rt+
	"import java.lang.reflect.Method;"+
	"public class $Proxy0 implements "+ infce.getName()+"{"+ rt +
	"private InvocationHandler h;"+rt+
	"public $Proxy0(InvocationHandler h)"+ rt +
	"{"+ rt +
	"	this.h = h;"+ rt +
	"}"+ rt +
	methodStr+rt+
"}";
		//产生代理类的java文件
		String filename = System.getProperty("user.dir")+"/bin/com/yang/proxy/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		//编译
		//获取编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理器
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//进行编译
		t.call();
		fileMgr.close();
		//load到内存中
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class c = cl.loadClass("com.yang.proxy.$Proxy0");
		System.out.println(c.getName());
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}
}
