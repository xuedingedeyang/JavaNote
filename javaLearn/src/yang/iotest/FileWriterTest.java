package yang.iotest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("锦瑟.txt");
			FileOutputStream fos = new FileOutputStream("testt.txt");
			{
				fw.write("锦瑟  --李商隐\r\n");
				fw.write("锦瑟无端五十弦，一弦一柱思华年。 \n");
				fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。 \n");
				fw.write("沧海月明珠有泪，蓝田日暖玉生烟。 \n");
				fw.write("此情可待成追忆，只是当时已惘然。 \n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
