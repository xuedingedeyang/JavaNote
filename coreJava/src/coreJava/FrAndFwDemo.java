package coreJava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("E:\\javatest\\日记1.txt");
		FileWriter fw = new FileWriter("E:\\javatest\\日记2.txt");//如果在里面加一个参数true，则是在文件后面追加，否则是删除原有文件再进行写入
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
