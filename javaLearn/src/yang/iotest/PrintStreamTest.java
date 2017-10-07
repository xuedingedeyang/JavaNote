package yang.iotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		FileOutputStream fos;
		PrintStream ps;
		try {
			fos = new FileOutputStream("pome.txt");
			ps = new PrintStream(fos);
			ps.println("ÆÕÍ¨×Ö·û´®");
			ps.println(new PrintStreamTest());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
