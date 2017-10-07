package yang.iotest;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// 以当前路径来创建一个File对象
		File file = new File(".");
		//直接获取文件名，输出一点
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.getAbsoluteFile().getParent());
		File tempFile = File.createTempFile("aaa", ".txt",file);
		//指定当JVM退出时删除该临时文件
		tempFile.deleteOnExit();
		String[] nameList = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg1.endsWith(".java")||new File(arg1).isDirectory();
			}
		});
		for (String string : nameList) {
			System.out.println(string);
		}
	}

}
