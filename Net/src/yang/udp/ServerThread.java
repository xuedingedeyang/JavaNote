package yang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerThread extends Thread{
	
	DatagramPacket packet = null;
	DatagramSocket socket = null;
	public ServerThread(DatagramSocket socket, DatagramPacket packet){
		this.packet = packet;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			//����
			byte[] data = new byte[1024];
			String info = new String(packet.getData(),0,data.length);
			System.out.println("���Ƿ�����,�ͻ���˵:" +  info);
			
			//��Ӧ
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			byte[] data2 = new byte[1024];
			data2 = "��ӭ��½!".getBytes();
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);
			socket.send(packet2);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
