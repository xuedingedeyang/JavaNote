package coreJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.InflaterInputStream;

public class InsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("e:/javatest/日记1.txt");
		InputStreamReader isr = new InputStreamReader(in,"gbk");//默认项目的编码,操作时，要写文件本身的编码格式
		
		FileOutputStream out = new FileOutputStream("e:/javatest/日记2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out,"gbk");
//		int c;
//		while((c = isr.read())!=-1){
//			System.out.print((char)c);
//		}
		char[] buffer = new char[8*1024];
		int c;
		//批量读取，放入buffer这个字符数组，从第0个位置开始放，最多放buffer.length()个。返回的是读到的字符个数
		while((c = isr.read(buffer,0,buffer.length))!=-1){
			String s = new String(buffer, 0, c);
			System.out.print(s);
			osw.write(buffer,0,c);
			osw.flush();
		}
		osw.close();
		isr.close();
		
	}

}
