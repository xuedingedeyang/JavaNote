package yang.mooc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(8888);
			System.out.println("***�����������������ȴ��ͻ�������***");
			Socket socket = null;
			//��¼�ͻ�������
			int count = 0;
			//ѭ�������ȴ��ͻ�������
			while(true){
				//����accept()������ʼ�������ȴ��ͻ�������
				socket = serversocket.accept();
				//�������߳�
				ServerThread serverThread = new ServerThread(socket);
				//����
				serverThread.start();
				
				count++;//ͳ�ƿͻ�������
				System.out.println("�ͻ�������:" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ���IP��ַ:" + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
