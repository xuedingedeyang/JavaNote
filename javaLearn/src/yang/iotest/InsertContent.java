package yang.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	
	public static void insert(String fileName,long pos,String insertContent){
		File tmp;
		RandomAccessFile raf = null;
		FileOutputStream tmpOut = null;
		FileInputStream tmpIn = null;
		try {
			tmp = File.createTempFile("tmp",null);
			raf = new RandomAccessFile(fileName, "rw");
			//ʹ����ʱ�ļ���������������������
			 tmpOut  = new FileOutputStream(tmp);
			 tmpIn = new FileInputStream(tmp);
			 
			 raf.seek(pos);
			 
			 byte[] buf = new byte[64];
			 int hasRead = 0;
			 while((hasRead = raf.read(buf)) > 0){
				 tmpOut.write(buf, 0, hasRead);
			 }
			 
			 raf.seek(pos);
			 raf.write(insertContent.getBytes());
			 //׷����ʱ�ļ�������;
			 while((hasRead = tmpIn.read(buf)) > 0){
				 raf.write(buf, 0, hasRead);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				tmpIn.close();
				tmpOut.close();
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		insert("��ɪ.txt", 46, "���ǲ��������\n");
	}

}
