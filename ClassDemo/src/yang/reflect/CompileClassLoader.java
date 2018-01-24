package yang.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader{

	//��ȡ�ļ�����
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
	
	//�������ָ��java�ļ��ķ���
	private boolean compile(String javaFile) throws IOException{
		{
			System.out.println("CompileClassLoader�����ڱ���"+javaFile+"...");
			Process p = Runtime.getRuntime().exec("javac "+javaFile);
			try {
				//�����̶߳��ȴ�����߳����
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int ret = p.exitValue();
			return ret == 0;
		}
	}
	
	//��дClassLoader��findClass����
	@Override
	protected Class<?> findClass(String name)
	{
		Class clazz = null;
		String fileStub = name.replace(".", "/");//��·���е�(.)ȫ������(/)
		String javaFilename = fileStub + ".java";
		String classFilename = fileStub + ".class";
		File javaFile = new File(javaFilename);
		File classFile = new File(classFilename);
		//��ָ��JavaԴ�ļ����ڣ���Class�ļ������ڣ�����javaԴ�ļ����޸�ʱ���class�ļ����޸�ʱ����ʱ�����±���
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
			System.out.println("ȱ��Ŀ�����࣬�밴���¸�ʽ����javaԴ�ļ�:");
			System.out.println("java CompileClassLoader className");
		}
		//��һ����������Ҫ���е���
		String progClass = args[0];
		//ʣ�µĲ�������Ϊ����Ŀ����Ĳ���
		//����Щ�������Ƶ�һ���µ�������
		String[] progArgs = new String[args.length - 1];
		System.arraycopy(args,1,progArgs,0,progArgs.length);
		CompileClassLoader ccl = new CompileClassLoader();
		Class<?> clazz = ccl.loadClass(progClass);
		//��ȡ��Ҫ���е����������
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = progArgs;
		main.invoke(null, argsArray);
	}

}
