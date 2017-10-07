package yang.iotest;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
			byte[] bbuf = new byte[1024];
			int hasRead = 0;//��������ʵ�ʶ�ȡ���ֽ���
			while ((hasRead = fis.read(bbuf)) > 0){
				System.out.println(new String(bbuf,0,hasRead));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
