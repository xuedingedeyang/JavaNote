package yang.iotest;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class Practice2 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			rece(sc.next());
		}
	}

	private static void rece(String path) {
		File file = new File(path);
		System.out.println(file.list().length);
		
	}

}
