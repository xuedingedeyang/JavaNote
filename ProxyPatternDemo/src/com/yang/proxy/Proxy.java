package com.yang.proxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Proxy {
	@SuppressWarnings("deprecation")
	public static Object newProxyInstance(Class infce) throws Exception
	{
		String rt = "\r\n";
		String methodStr = "";
		for(Method m: infce.getMethods())
		{
			methodStr+="@Override"+ rt +
			"public void "+m.getName()+" (){"+ rt +
			"	long startTime = System.currentTimeMillis();"+ rt +
			"	System.out.println(\"������ʼ��ʻ...\");"+ rt +
			"	m."+m.getName()+"();"+ rt +
			"	long endTime = System.currentTimeMillis();"+ rt +
			"	System.out.println(\"����������ʻ...\");"+ rt +
			"	System.out.println(\"������ʻʱ�䣺\"+(endTime - startTime)+\"����\");"+ rt +
			"}";

		}
		String str =
	"package com.yang.proxy; "+ rt +

	"public class $Proxy0 implements "+ infce.getName()+"{"+ rt +
	"private  "+ infce.getName()+" m;"+ rt +
	
	"public $Proxy0( "+ infce.getName()+" m)"+ rt +
	"{"+ rt +
	"	super();"+ rt +
	"	this.m = m;"+ rt +
	"}"+ rt +
	methodStr+rt+
"}";
		//�����������java�ļ�
		String filename = System.getProperty("user.dir")+"/bin/com/yang/proxy/$Proxy0.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		//����
		//��ȡ������
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//�ļ�������
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//��������
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//���б���
		t.call();
		fileMgr.close();
		return null;
	}
}
