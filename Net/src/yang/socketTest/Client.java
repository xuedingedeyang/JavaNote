package yang.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",30000);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = null;
			InputStream is = null;
			BufferedReader br = null;
			is = socket.getInputStream();
			Scanner sc = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(is));
			while(sc.hasNextLine()){
				pw = new PrintWriter(os);
				String s = sc.nextLine();
				pw.write(s);
				pw.flush();
				String info = null;
				while((info = br.readLine())!=null){
					System.out.println("我是客户端，服务器说:"+info);
				}
			}
			socket.shutdownInput();
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
