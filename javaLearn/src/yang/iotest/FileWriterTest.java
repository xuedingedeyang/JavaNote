package yang.iotest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("��ɪ.txt");
			FileOutputStream fos = new FileOutputStream("testt.txt");
			{
				fw.write("��ɪ  --������\r\n");
				fw.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ \n");
				fw.write("ׯ�������Ժ��������۴����жž顣 \n");
				fw.write("�׺����������ᣬ������ů�����̡� \n");
				fw.write("����ɴ���׷�䣬ֻ�ǵ�ʱ���Ȼ�� \n");
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
