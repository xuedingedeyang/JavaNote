package yang.mooc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

//InetAddress��ļ�ʹ��

public class Test01 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("�������:" + address.getHostName());
		System.out.println("ip��ַ:" + address.getHostAddress());
		byte[] bytes = address.getAddress();//��ȡ�ֽ�������ʽ��ip��ַ
		System.out.println("�ֽ�������ʽ��ip��ַ:" + Arrays.toString(bytes));
		System.out.println(address);
		
		//������������ȡInetAddressʵ��
//		InetAddress address2 = InetAddress.getByName("DESKTOP-JQ9KKCT");
		//����ip��ַ��ȡInetAddressʵ��
		InetAddress address2 = InetAddress.getByName("192.168.75.2");
		System.out.println("���������" + address2.getHostName());
		System.out.println("ip��ַ:" + address2.getHostAddress());
	}
}
