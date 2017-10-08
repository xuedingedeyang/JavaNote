package defualtpackage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path = Paths.get(".");
		System.out.println("path里包含的路径数量是:" + path.getNameCount());
		System.out.println("path的绝对路径:" + path.toAbsolutePath());
		System.out.println("path的根路径:" + path.getRoot());
		Path path2 = Paths.get("E:", "javaProgram","javaLearn");
		System.out.println(path2);
	}

}
