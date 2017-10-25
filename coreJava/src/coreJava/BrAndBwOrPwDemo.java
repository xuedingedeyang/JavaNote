package coreJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {

	public static void main(String[] args) throws IOException{
		//对文件进行读写操作
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:/javatest/日记3.txt")));
		String line ;
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/javatest/日记4.txt")));
		PrintWriter pw = new PrintWriter("E:/javatest/日记4.txt");
//		PrintWriter pw1 = new PrintWriter(out, autoFlush);后面的参数是一个布尔值，是否自动刷新缓冲区
		while ((line = br.readLine())!=null){
			System.out.println(line);//一次读一行，并不能识别换行
//			bw.write(line);
			//单独写出换行操作
//			bw.newLine();//换行操作
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		br.close();
//		bw.close();
		pw.close();

	}

}
