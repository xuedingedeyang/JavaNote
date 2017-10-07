package yang.iotest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Practice1 {
	
	public static void printListFile(String path){
		File file = new File(path);
		if(file.exists()){
				File[]list = file.listFiles();
//				for (String string : list) {
//					System.out.println(string+"[");
//					File file2 = new File(string);
//					if(file2.isDirectory()){
//						System.out.println(string+"也是一个目录：子文件如下");
//						printListFile(string);
//					}else{
//						System.out.println("sss");
//					}
//					System.out.println("]");
//				printListFile(file.getAbsolutePath());
//				}
				if(list.length == 0){
					System.out.println("文件夹是空的");
				}
				for(File file2:list){
					if(!file2.isDirectory()){
						System.out.println("文件名："+file.getAbsolutePath());
					}else{
						System.out.println("路径名"+file.getAbsolutePath());
						printListFile(file2.getAbsolutePath());
					}
				}
		}else{
			System.out.println("该文件不存在");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			printListFile(sc.next());
		}
	}

}
