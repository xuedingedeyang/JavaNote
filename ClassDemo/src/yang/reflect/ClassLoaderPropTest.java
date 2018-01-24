package yang.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器:"+systemLoader);
		System.out.println("扩展类加载器的加载路径:"+System.getProperty("java.ext.dirs"));
		Enumeration<URL>eml = systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		
		ClassLoader extentionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器的parent:" + extentionLoader.getParent());
	}

}
