package coreJava;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.copyFile(new File("e:/javatest/�ռ�1.txt"),new File("e:/javatest/�ռ�2.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
