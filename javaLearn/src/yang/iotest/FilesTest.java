package yang.iotest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) {
		try {
			Files.copy(Paths.get("a.txt"), new FileOutputStream("b.txt"));
			List<String> lines = Files.readAllLines(Paths.get("½õÉª.txt"),Charset.forName("GBK"));
			for (String string : lines) {
				System.out.println(string);
			}
			List<String>pome = new ArrayList<>();
			pome.add("Çç¿ÕÒ»º×ÅÅÔÆÉÏ");
			pome.add("±ãÒıÊ«Çéµ½±ÌÏö");
			Files.write(Paths.get("pome.txt"), pome, Charset.forName("GBK"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
