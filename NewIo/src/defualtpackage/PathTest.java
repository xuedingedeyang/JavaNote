package defualtpackage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get(".");
		System.out.println("path�������·��������:" + path.getNameCount());
		System.out.println("path�ľ���·��:" + path.toAbsolutePath());
		System.out.println("path�ĸ�·��:" + path.getRoot());
		Path path2 = Paths.get("E:", "javaProgram","javaLearn");
		System.out.println(path2);
	}

}
