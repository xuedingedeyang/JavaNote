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
			System.out.println("服务器启动，等待客户端连接...");
			
			while(true){
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				new Thread(serverThread).start();
				count++;
				System.out.println("客户端的数量:"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的地址:"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
