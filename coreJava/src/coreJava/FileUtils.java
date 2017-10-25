package coreJava;

import java.io.File;
import java.io.IOException;

import org.omg.CORBA.PUBLIC_MEMBER;

//�г�File��ĳ��ò���������ˣ������Ȳ���
public class FileUtils {
/*
 * �г�ָ��Ŀ¼�£���������Ŀ¼�£��������ļ�
 */
	public static void listDirectory(File dir)throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼������");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"����Ŀ¼");
		}
		/*String[] fileNames = dir.list();//���ص����ַ������飬ֱ���ӵ����ƣ���������Ŀ¼�µ�����
		for (String string : fileNames) {
			System.out.println(dir+"\\"+string);
		}*/
		//���Ҫ������Ŀ¼�µ����ݾ���Ҫ�����File�������ݹ������File�ṩ��ֱ�ӷ���File�����API
		File[] files = dir.listFiles();//���ص���ֱ����Ŀ¼���ļ����ĳ���
		if(files!=null&&files.length>0){
			for (File file : files) {
				if(file.isDirectory()){
					//�ݹ�
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
		

	}
}
