package yang.socketTest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendMessageThread extends Thread {

	private Socket socket = null;

	public SendMessageThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();

		Scanner sc = null;
		OutputStream out = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		try {
			if (socket != null) {
				sc = new Scanner(System.in);
				out = socket.getOutputStream();
				ow = new OutputStreamWriter(out);
				bw = new BufferedWriter(ow);
				String in = "";
				do{
					in = sc.nextLine();
					bw.write(in);
				}while(!in.equals("quit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
