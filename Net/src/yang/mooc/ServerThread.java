package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * @author yang
 *
 */
public class ServerThread extends Thread {
	//�ͱ��߳���ص�socket
	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//ִ���̲߳�������Ӧ�ͻ�������
	@Override
	public void run() {
		//3.��ȡһ����������������ȡ�ͻ�����Ϣ
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
		is = socket.getInputStream();
		//�ֽ�������
		isr = new InputStreamReader(is);//���ֽ���ת�����ַ���
		br = new BufferedReader(isr);//�ֽ���ת�����ַ���
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println("���Ƿ��������ͻ���˵:"+line);
		}
		socket.shutdownInput();//�ر�������
		
		//4.��ȡ���������Ӧ�ͻ��˵�����
		os = socket.getOutputStream();
		pw = new PrintWriter(os);
		pw.write("��ӭ��½!");
		pw.flush();//����flush(),ˢ�»���
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.�ر���Դ
			try {
				is.close();
				isr.close();
				br.close();
				pw.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
