package yang;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//字节流实现
public class Main {
    public static void main(String[] args)
    {
    	File sourceFile = null,destFile = null;
    	BufferedReader br = null;
    	BufferedWriter bw = null;
    	
    	sourceFile = new File("a.txt");
    	destFile = new File("b.txt");
    	
    	try {
			br = new BufferedReader(new FileReader(sourceFile));
			bw = new BufferedWriter(new FileWriter(destFile));
			String content = "";
			while((content=br.readLine())!=null){
				bw.write(content);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
