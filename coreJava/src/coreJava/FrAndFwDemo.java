package coreJava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("E:\\javatest\\�ռ�1.txt");
		FileWriter fw = new FileWriter("E:\\javatest\\�ռ�2.txt");//����������һ������true���������ļ�����׷�ӣ�������ɾ��ԭ���ļ��ٽ���д��
		char buffer[] = new char[2056];
		int c;
		while ((c = fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer,0,c);
			fw.flush();
		}
		fr.close();
		fw.close();

	}

}
