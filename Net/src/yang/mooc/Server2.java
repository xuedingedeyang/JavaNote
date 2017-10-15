package yang.mooc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(8888);
			System.out.println("***服务器即将启动，等待客户端连接***");
			Socket socket = null;
			//记录客户端数量
			int count = 0;
			//循环监听等待客户端连接
			while(true){
				//调用accept()方法开始监听，等待客户端连接
				socket = serversocket.accept();
				//创建新线程
				ServerThread serverThread = new ServerThread(socket);
				//启动
				serverThread.start();
				
				count++;//统计客户端数量
				System.out.println("客户端数量:" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端IP地址:" + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
