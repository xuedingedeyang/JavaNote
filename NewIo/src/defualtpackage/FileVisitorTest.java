package defualtpackage;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		Files.walkFileTree(Paths.get("E:","javaProgram","NewIo","src"), new FileVisitor<Path>() {

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				// TODO Auto-generated method stub
				return FileVisitResult.CONTINUE;
			}
			

			//开始访问文件时触发该方法
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("正在访问:" + dir + "路径");
				return FileVisitResult.CONTINUE;
			}

			//开始访问目录时触发该方法
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("正在访问" + file + "文件");
				//找到了FilesTest.java
				if(file.endsWith("FilesTest.java")){
					System.out.println("已找到目标文件");
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				// TODO Auto-generated method stub
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
