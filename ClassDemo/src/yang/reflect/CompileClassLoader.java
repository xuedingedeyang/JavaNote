package yang.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader{

	//读取文件内容
	private byte[] getBytes(String filename){
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int)len];
		try {
			FileInputStream fin = new FileInputStream(file);
			int r = fin.read(raw);
			if(r!=len){
				return raw;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//定义编译指定java文件的方法
	private boolean compile(String javaFile) throws IOException{
		{
			System.out.println("CompileClassLoader：正在编译"+javaFile+"...");
			Process p = Runtime.getRuntime().exec("javac "+javaFile);
			try {
				//其他线程都等待这个线程完成
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int ret = p.exitValue();
			return ret == 0;
		}
	}
	
	//重写ClassLoader的findClass方法
	@Override
	protected Class<?> findClass(String name)
	{
		Class clazz = null;
		String fileStub = name.replace(".", "/");//将路径中的(.)全部换成(/)
		String javaFilename = fileStub + ".java";
		String classFilename = fileStub + ".class";
		File javaFile = new File(javaFilename);
		File classFile = new File(classFilename);
		//当指定Java源文件存在，且Class文件不存在，或者java源文件的修改时间比class文件的修改时间晚时，重新编译
		if(javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified()))
		{
			try {
				if(!compile(javaFilename) || !classFile.exists())
				{
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFilename);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(classFile.exists())
		{
			byte[] raw = getBytes(classFilename);
			clazz = defineClass(name,raw,0,raw.length);
			if(clazz == null)
			{
				try {
					throw new ClassNotFoundException(name);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return clazz;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		if(args.length < 1)
		{
			System.out.println("缺少目标主类，请按如下格式运行java源文件:");
			System.out.println("java CompileClassLoader className");
		}
		//第一个参数是需要运行的类
		String progClass = args[0];
		//剩下的参数将作为运行目标类的参数
		//将这些参数复制到一个新的数组中
		String[] progArgs = new String[args.length - 1];
		System.arraycopy(args,1,progArgs,0,progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		Class<?> clazz = ccl.loadClass(progClass);
		//获取需要运行的类的主方法
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = progArgs;
		main.invoke(null, argsArray);
	}

}
