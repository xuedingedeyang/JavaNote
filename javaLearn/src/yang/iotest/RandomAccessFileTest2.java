package yang.iotest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			RandomAccessFile raf = new RandomAccessFile("b.txt", "r");
			{
			System.out.println("RandomAcessFile的文件指针初始位置:"+ raf.getFilePointer());
			raf.seek(30);
			byte[] bbuf = new byte[1024];
			int hasread = 0;
			while((hasread = raf.read(bbuf))>0)
			{
				System.out.println(new String(bbuf,0,hasread));
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
