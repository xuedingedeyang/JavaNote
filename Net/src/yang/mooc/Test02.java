package yang.mooc;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	//URL�ĳ��÷���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//����һ��URLʵ��
			URL url1 = new URL("http://www.imooc.com");
			URL url2 = new URL(url1,"/index.html?username=tom#test");//?�����ʾ������#�����ʾê��
			System.out.println("Э��:" + url1.getProtocol());
			System.out.println("������" + url1.getHost());
			//���δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱgetPort()��������ֵΪ-1
			System.out.println("�˿�:" + url1.getPort());
			System.out.println("�ļ�·��:" + url2.getPath());
			System.out.println("�ļ���:" + url2.getFile());
			System.out.println("���·��:" + url2.getRef());
			System.out.println("��ѯ�ַ���:" + url2.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
