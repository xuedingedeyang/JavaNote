package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test03 {

	//ʹ��URL��ȡ��ҳ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.baidu.com");
			//ͨ��URL��openStream()������ȡURL�������Դ���ֽ�������
			InputStream is = url.openStream();
			//���ֽ�������ת�����ַ�������
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//Ϊ�ַ���������ӻ�����
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
