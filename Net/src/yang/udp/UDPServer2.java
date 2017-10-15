package yang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer2 {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(8800);
			System.out.println("**�������������ȴ��ͻ�������**");
			byte[] data = new byte[1024];
			int count = 0;
			while(true){
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				new ServerThread(socket,packet).start();
				count++;
				System.out.println("�ͻ�������:" + count);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
