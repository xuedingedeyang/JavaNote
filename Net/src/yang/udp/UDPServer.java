package yang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ����UDP���û���¼
 * 
 * ��������
 * @author yang
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/*
		 * ���������տͻ��˷��͵���Ϣ
		 */
		//1.������������DatagramSocket��ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//2.�������ݱ������ڽ��տͻ��˷��͵�����
		byte[]	data =	new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		//3.���տͻ��˷��͵�����
		System.out.println("���������Ѿ��������ȴ��ͻ�������");
		socket.receive(packet);//�˷����ڽ��յ�����֮ǰ��һֱ��������״̬
		//4.��ȡ����
		String info = new String(data,0,packet.getLength());
		System.out.println("���Ƿ�����,�ͻ���˵��" + info);
		
		/*
		 * ��Ӧ�ͻ���
		 */
		//1.����ͻ��˵ĵ�ַ���˿ںţ�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��½".getBytes();
		//2.�������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length,address,port);
		//3.��Ӧ�ͻ���
		socket.send(packet2);
		//4.�ر���Դ
		socket.close();
	}
}
