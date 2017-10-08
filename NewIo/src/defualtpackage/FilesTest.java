package defualtpackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//复制文件
		Files.copy(Paths.get("NIO2.txt"), new FileOutputStream("a.txt"));
		//判断文件是否是隐藏文件
		System.out.println(Files.isHidden(Paths.get("NIO.txt")));
		//一次性读取NIO.txt文件的所有行
//		List<String> lines = Files.readAllLines(Paths.get("NIO.txt"));
//		System.out.println(lines);
		
		List<String> poem= new ArrayList<>();
		poem.add("晴川历历汉阳树");
		poem.add("芳草萋萋鹦鹉洲");
		Files.write(Paths.get("poem.txt"),poem, Charset.forName("GBK"));
		//列出当前目录下所有文件和子目录
		Files.list(Paths.get(".")).forEach(path->System.out.println(path));
		//读取文件内容
		Files.lines(Paths.get("NIO.txt"),Charset.forName("gbk")).forEach(line->System.out.println(line));
		
		
		
		
	}

}
