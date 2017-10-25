package coreJava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOException;

public class IOUtil {
	
//	public static void printHexByByteArray(String fileName) throws IOException{
//		FileInputStream in = new FileInputStream(fileName);
//		byte[] buf = new byte[8*1024];
//		//��in��������ȡ�ֽڣ����뵽buf����ֽ������У��ӵ�0��λ�ÿ�ʼ�ţ�����buf.length�������ص��Ƕ������ֽڵĸ���
////		int bytes = in.read(buf,0,buf.length);//һ���Զ��꣬˵���ֽ������㹻��
////		int j=0;
////		for(int i = 0;i < bytes;i++){
////			if(buf[i]<=0xf){
////				System.out.println("0");
////			}
////			System.out.println(Integer.toHexString(buf[i])+" ");
////			if(j++%10==0){
////				System.out.println();
////			}
////		}
//		int bytes = 0;
//		int j = 0;
//		while((bytes = in.read(buf,0,buf.length))!= -1){
//			for(int i = 0;i < bytes;i++){
//				System.out.println(Integer.toHexString(buf[i]&0xff)+" ");
//				if(j++%10==0){
//					System.out.println();
//				}
//			}
//		}
//	}
	
	//��ȡָ���ļ����ݣ�����16�������������̨
	//����ÿ���10��byte����
	public static void printHex(String FileName)throws IOException{
		FileInputStream in = new FileInputStream(FileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			if (b <= 0xf){
				//��λ��ǰ�油0
				System.out.println("0");
			}
			System.out.print(Integer.toHexString(b)+"  ");//������bת��Ϊ16���Ʊ�ʾ���ַ���
			if (i++%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	

	
	public static void printHexByByteArray(String fileName)throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[8*1024];
		//��in��������ȡ�ֽڣ����뵽buf����ֽ������У��ӵ�0����ʼ�ţ�����buf.lenth()�������ص��Ƕ������ֽڵĸ���
//		int bytes = in.read(buf,0,buf.length);//һ���Զ��꣬˵���ֽ������㹻��
//		int j = 1;
//		for(int i = 0 ; i < bytes; i++){
//			if (buf[i] <= 0xf){
//				System.out.print("0");
//			}
//			System.out.print(Integer.toHexString(buf[i]&0xff)+"  ");
//			if (j++%10==0){
//				System.out.println();
//			}
//		}
		
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf,0,buf.length))!=-1){
			for(int i =0 ;i < bytes;i++){
				//byte����8λ��int����32λ��Ϊ�˱�������ת������ͨ��&0xff����24λ����
				System.out.print(Integer.toHexString(buf[i]&0xff)+" ");
				if (j++%10 == 0){
					System.out.println();
				}
			}
		}
	}
	
	//�ļ��������ֽ�������ȡ
	public static void copyFile(File srcFile,File desFile)throws IOException{
		if (!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if (!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(desFile);
		byte[] buf = new byte[8*1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf, 0, b);
			out.flush();//��ü���
		}
		out.close();
		in.close();
	}
	
	//�����ļ����������ô�������ֽ���
	public static void copyFileByBuffer(File srcFile,File desFile) throws IOException{
		if (!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if (!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
		int c;
		while((c = bis.read())!=-1){
			bos.write(c);
			bos.flush();//ˢ�»�����
		}
		bos.close();
		bis.close();
	}

	//���ֽڣ�������������ļ�����
	public static void copyFileByByte(File srcFile,File desFile) throws IOException{
		if (!srcFile.exists()){
			throw new IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if (!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"�����ļ�");
		}
		
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(desFile);
		int c;
		while((c = in.read())!=-1){
			out.write(c);
			out.flush();
		}
		in.close();
		out.close();
	}
}
