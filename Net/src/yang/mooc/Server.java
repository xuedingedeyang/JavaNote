package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * 
 * ��������
 * @author yang
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.����һ����������socket����ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			System.out.println("***�����������������ȴ��ͻ�������***");
			Socket socket = serverSocket.accept();
			//3.��ȡһ����������������ȡ�ͻ�����Ϣ
			InputStream is = socket.getInputStream();//�ֽ�������
			InputStreamReader isr = new InputStreamReader(is);//���ֽ���ת�����ַ���
			BufferedReader br = new BufferedReader(isr);//�ֽ���ת�����ַ���
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println("���Ƿ��������ͻ���˵:"+line);
			}
			socket.shutdownInput();//�ر�������
			
			//4.��ȡ���������Ӧ�ͻ��˵�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ӭ��½!");
			pw.flush();//����flush(),ˢ�»���
			
			//5.�ر���Դ
			is.close();
			isr.close();
			br.close();
			pw.close();
			os.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
