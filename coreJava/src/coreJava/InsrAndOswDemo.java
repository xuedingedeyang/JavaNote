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
		FileInputStream in = new FileInputStream("e:/javatest/�ռ�1.txt");
		InputStreamReader isr = new InputStreamReader(in,"gbk");//Ĭ����Ŀ�ı���,����ʱ��Ҫд�ļ�����ı����ʽ
		
		FileOutputStream out = new FileOutputStream("e:/javatest/�ռ�2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out,"gbk");
//		int c;
//		while((c = isr.read())!=-1){
//			System.out.print((char)c);
//		}
		char[] buffer = new char[8*1024];
		int c;
		//������ȡ������buffer����ַ����飬�ӵ�0��λ�ÿ�ʼ�ţ�����buffer.length()�������ص��Ƕ������ַ�����
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
