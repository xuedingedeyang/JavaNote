package coreJava;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis();
			//IOUtil.copyFileByByte(new File("E:\\Java����\\coreJava\\src\\coreJava\\IOUtil.java"), new File("e:/javatest/�ռ�2.txt"));
			IOUtil.copyFileByBuffer(new File("E:\\Java����\\coreJava\\src\\coreJava\\IOUtil.java"), new File("e:/javatest/�ռ�3.txt"));
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
