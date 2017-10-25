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
//			System.out.println("出现异常之后");
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			System.out.println("finally语句块");
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
//		File file = new File("D:\\电影+电影+1");
//		file.mkdir();
	
		
	}
//	public void writertest() throws IOException{
//
//		File file = new File("文档");
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
//		//指定源文件和目标文件路径
//		File fileSrc = new File("E:\\test\\");
//		File fileDec = new File("E:\\test\\file");
//		//读取源文件内容到内存
//		FileInputStream fis = new FileInputStream(fileSrc);
//		byte[] bytes = new byte[(int)fileSrc.length()];
//		fis.read(bytes);
//		fis.close();
//		//将读取到的内容写入指定的目标文件
//		//判断父目录是否存在
//		File dir = new File("E:\\test\\file\\newfile");
//		if(!dir.exists()){
//			System.out.println("父目录不存在，创建此目录");
//			dir.mkdirs();
//		}
//		FileOutputStream fos = new FileOutputStream(fileDes);
//		fos.write(bytes);
//	}
	public static void outputStreamWriterTest() throws IOException{
		File file  = new File("文档");
		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
	}
	
}

