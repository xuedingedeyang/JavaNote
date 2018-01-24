package yang.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	
	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN]; 
	
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket;
	
	String[] books = new String[]{"数字城堡","论语","月亮与六便士","茶花女","倚天屠龙记"};
	
	public void init() throws IOException
	{
		try {
			DatagramSocket socket = new DatagramSocket(PORT);
			{
				for(int i=0;i<1000;i++){
					socket.receive(inPacket);
					System.out.println(inBuff == inPacket.getData());
					System.out.println(new String(inBuff,0,inPacket.getLength()));
					byte[] sendData = books[i%4].getBytes();
					outPacket = new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
					socket.send(outPacket);
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new UDPServer().init();
	}

}
