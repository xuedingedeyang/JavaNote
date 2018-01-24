package yang.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();
			System.out.println("���ӳɹ�");
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}

}
