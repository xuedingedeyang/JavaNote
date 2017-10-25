package coreJava;

import java.io.File;
import java.io.IOException;

import org.omg.CORBA.PUBLIC_MEMBER;

//列出File类的常用操作比如过滤，遍历等操作
public class FileUtils {
/*
 * 列出指定目录下（包括其子目录下）的所有文件
 */
	public static void listDirectory(File dir)throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
		/*String[] fileNames = dir.list();//返回的是字符串数组，直接子的名称，不包含子目录下的内容
		for (String string : fileNames) {
			System.out.println(dir+"\\"+string);
		}*/
		//如果要遍历子目录下的内容就需要构造成File对象做递归操作，File提供了直接返回File对象的API
		File[] files = dir.listFiles();//返回的是直接子目录（文件）的抽象
		if(files!=null&&files.length>0){
			for (File file : files) {
				if(file.isDirectory()){
					//递归
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
		

	}
}
