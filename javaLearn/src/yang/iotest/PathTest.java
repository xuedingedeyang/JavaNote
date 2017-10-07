package yang.iotest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println(path.getNameCount());
		System.out.println(path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);

	}

}
