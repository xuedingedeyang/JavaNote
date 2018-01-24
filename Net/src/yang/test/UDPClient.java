package yang.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static final int DEST_PORT = 30000;
	public static final String DEST_IP = "127.0.0.1";
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket = null;
	
	public void init()
	{
		try {
			DatagramSocket socket = new DatagramSocket();
			outPacket = new DatagramPacket(new byte[0], 0,InetAddress.getByName(DEST_IP),DEST_PORT);
			Scanner scan = new Scanner(System.in);
			while(scan.hasNextLine()){
				byte[] buff = scan.nextLine().getBytes();
				outPacket.setData(buff);
				socket.send(outPacket);
				socket.receive(inPacket);
				System.out.println(new String(inBuff,0,inPacket.getLength()));
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UDPClient().init();
	}

}
