package yang.iotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyInTest {

	public static void main(String[] args) {
		InputStreamReader reader = null;
		BufferedReader br = null;
		try {
			//将System.in对象转换成Reader对象
			reader = new InputStreamReader(System.in);
			//将普通的reader包装成BufferdReader
			br = new BufferedReader(reader);
			String line = null;
			while((line = br.readLine()) != null){
				if(line.equals("exit")){
					System.exit(1);
				}
				System.out.println("输入内容："+line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
