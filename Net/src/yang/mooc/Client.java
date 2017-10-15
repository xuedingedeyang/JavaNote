package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author yang
 *
 */
public class Client {
	public static void main(String[] args) {
		try {
			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost",8888);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			pw.write("�û���: admin , ���� �� 456");
			pw.flush();
			socket.shutdownOutput();//�ر������
			
			//3.��ȡ����������ȡ��������Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println("���ǿͻ��ˣ���������˵:" + line);
			}
			
			//4.�ر���Դ
			pw.close();
			out.close();
			pw.close();
			br.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
