package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test03 {

	//使用URL读取网页内容
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.baidu.com");
			//通过URL的openStream()方法获取URL对象的资源的字节输入流
			InputStream is = url.openStream();
			//将字节输入流转换成字符输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲流
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
			br.close();
			isr.close();
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
