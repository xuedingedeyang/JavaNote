package yang.mooc;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	//URL的常用方法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建一个URL实例
			URL url1 = new URL("http://www.imooc.com");
			URL url2 = new URL(url1,"/index.html?username=tom#test");//?后面表示参数，#后面表示锚点
			System.out.println("协议:" + url1.getProtocol());
			System.out.println("主机：" + url1.getHost());
			//如果未指定端口号，则使用默认端口号，此时getPort()方法返回值为-1
			System.out.println("端口:" + url1.getPort());
			System.out.println("文件路径:" + url2.getPath());
			System.out.println("文件名:" + url2.getFile());
			System.out.println("相对路径:" + url2.getRef());
			System.out.println("查询字符串:" + url2.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
