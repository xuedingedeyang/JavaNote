package coreJava;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//了解构造函数的情况  查帮助
		File  file = new File("E:\\javatest\\imooc");
		//File file1 = new File("e"+File.separator);
		//System.out.println(file.exists());
		if(!file.exists())
			file.mkdir();//file.mkdirs()
		else
			file.delete();
		//是否是一个目录 如果是目录放回true如果不是目录or目录不存在放回false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
		//File file2 = new File("E:\\javatest\\日记1.txt");
		File file2 = new File("E:\\javatest","日记1.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			file2.delete();
		//常用的File对象的API
		System.out.println(file);//file.toString()的内容，即文件的路径
		System.out.println(file.getAbsolutePath());//与上同
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
