package yang.socketTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(30000);
			Socket socket = null;
			
			int count = 0;
			System.out.println("�������������ȴ��ͻ�������...");
			
			while(true){
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				new Thread(serverThread).start();
				count++;
				System.out.println("�ͻ��˵�����:"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵ĵ�ַ:"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
