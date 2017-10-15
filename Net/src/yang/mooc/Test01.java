package yang.mooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

//InetAddress类的简单使用

public class Test01 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("计算机名:" + address.getHostName());
		System.out.println("ip地址:" + address.getHostAddress());
		byte[] bytes = address.getAddress();//获取字节数组形式的ip地址
		System.out.println("字节数组形式的ip地址:" + Arrays.toString(bytes));
		System.out.println(address);
		
		//根据主机名获取InetAddress实例
//		InetAddress address2 = InetAddress.getByName("DESKTOP-JQ9KKCT");
		//根据ip地址获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("192.168.75.2");
		System.out.println("计算机名：" + address2.getHostName());
		System.out.println("ip地址:" + address2.getHostAddress());
	}
}
