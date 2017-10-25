package coreJava;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IOUtil.copyFile(new File("e:/javatest/日记1.txt"),new File("e:/javatest/日记2.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
