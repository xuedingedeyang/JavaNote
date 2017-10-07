package yang.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Practice3 {

	public static  void copy(String res,String dest) throws IOException{
		File resFile = new File(res);
		File destFile = new File(dest);
		if(resFile.exists()){
			if(!destFile.exists()){
				destFile.createNewFile();
			}
			File[] fileList = resFile.listFiles();
			if(fileList.length == 0){
				System.out.println("文件夹为空");
			}else{
				for (File file : fileList) {
					
				}
			}
		}else{
			System.out.println("文件不存在");
		}
	}
	
	public static void main(String[] args) {
		
	}

}
