package Day03;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.imageio.stream.FileImageOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class Luancher {



//	private static final Exception fisrstException = null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		copyTest();
//		try{
//			m1();
//			System.out.println("�����쳣֮��");
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			System.out.println("finally����");
//		}
//		
//	}
//		public static void m1(){
//			m2();
//		}
//		public static void m2(){
//			int[]arr = new int [2];
//			arr[2] = 1;
//		}
//		String lineSeparator = System.getProperty("line.separator");
//		File file = new File("D:\\��Ӱ+��Ӱ+1");
//		file.mkdir();
	
		
	}
//	public void writertest() throws IOException{
//
//		File file = new File("�ĵ�");
//		FileWriter fw = new FileWriter(file);
//		 file.write("Android");
//	}
//	public static void readTest()throws IOException{		
//		File file = new File("E:\\test\\file");
//	FileInputStream fos = new FileInputStream(file);
//	byte[] bytes = new byte[(int) file.length()];
//	fos.read(bytes);
//	System.out.println(new String(bytes));
//	fos.close();
//	}
//	public static void m(int i) throws MyException{
//		if(i<0){
//			throw new MyException();
//		}
//	}
//	public static void caculate(int a,int b){
//		throws firstException,
//		secendException,
//		thirdException;
//	
//	}
//	public static void copyTest() throws IOException{
//		//ָ��Դ�ļ���Ŀ���ļ�·��
//		File fileSrc = new File("E:\\test\\");
//		File fileDec = new File("E:\\test\\file");
//		//��ȡԴ�ļ����ݵ��ڴ�
//		FileInputStream fis = new FileInputStream(fileSrc);
//		byte[] bytes = new byte[(int)fileSrc.length()];
//		fis.read(bytes);
//		fis.close();
//		//����ȡ��������д��ָ����Ŀ���ļ�
//		//�жϸ�Ŀ¼�Ƿ����
//		File dir = new File("E:\\test\\file\\newfile");
//		if(!dir.exists()){
//			System.out.println("��Ŀ¼�����ڣ�������Ŀ¼");
//			dir.mkdirs();
//		}
//		FileOutputStream fos = new FileOutputStream(fileDes);
//		fos.write(bytes);
//	}
	public static void outputStreamWriterTest() throws IOException{
		File file  = new File("�ĵ�");
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
	}
	
}

