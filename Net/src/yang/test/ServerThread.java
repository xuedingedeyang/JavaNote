package yang.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	Socket s = null;
	BufferedReader br = null;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String content = null;
			if((content = readFromContent()) == null)
			{
				System.out.println("获取到内容为空");
			}
			while ((content = readFromContent()) != null) {
				for (Socket s : MyServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String readFromContent() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MyServer.socketList.remove(s);
		}
		return null;
	}
}
