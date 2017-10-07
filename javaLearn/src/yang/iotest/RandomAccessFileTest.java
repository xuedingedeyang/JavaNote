package yang.iotest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("��ɪ.txt","rw");
			System.out.println("��ʼλ�ã�"+raf.getFilePointer());
			raf.seek(raf.length());
			raf.write("׷�ӵ�����\n".getBytes());
//			byte[] buf = new byte[1024];
//			int hasRead  = 0;
//			while((hasRead = raf.read(buf))>0){
//				System.out.println(new String(buf,0,hasRead));
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
