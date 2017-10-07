package yang.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			FileOutputStream fos = new FileOutputStream("newFile.txt");
			{
				byte[] bbuf = new byte[32];
				int hasRead = 0;
				while((hasRead = fis.read(bbuf)) > 0){
					fos.write(bbuf,0,hasRead);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
