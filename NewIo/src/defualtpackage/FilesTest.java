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
		//�����ļ�
		Files.copy(Paths.get("NIO2.txt"), new FileOutputStream("a.txt"));
		//�ж��ļ��Ƿ��������ļ�
		System.out.println(Files.isHidden(Paths.get("NIO.txt")));
		//һ���Զ�ȡNIO.txt�ļ���������
//		List<String> lines = Files.readAllLines(Paths.get("NIO.txt"));
//		System.out.println(lines);
		
		List<String> poem= new ArrayList<>();
		poem.add("�紨����������");
		poem.add("��������������");
		Files.write(Paths.get("poem.txt"),poem, Charset.forName("GBK"));
		//�г���ǰĿ¼�������ļ�����Ŀ¼
		Files.list(Paths.get(".")).forEach(path->System.out.println(path));
		//��ȡ�ļ�����
		Files.lines(Paths.get("NIO.txt"),Charset.forName("gbk")).forEach(line->System.out.println(line));
		
		
		
		
	}

}
