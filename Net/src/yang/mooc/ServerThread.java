package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * @author yang
 *
 */
public class ServerThread extends Thread {
	//和本线程相关的socket
	Socket socket = null;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	//执行线程操作，响应客户端请求
	@Override
	public void run() {
		//3.获取一个输入流，用来读取客户端信息
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
		is = socket.getInputStream();
		//字节输入流
		isr = new InputStreamReader(is);//将字节流转换成字符流
		br = new BufferedReader(isr);//字节流转换成字符流
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println("我是服务器，客户端说:"+line);
		}
		socket.shutdownInput();//关闭输入流
		
		//4.获取输出流，响应客户端的请求
		os = socket.getOutputStream();
		pw = new PrintWriter(os);
		pw.write("欢迎登陆!");
		pw.flush();//调用flush(),刷新缓存
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.关闭资源
			try {
				is.close();
				isr.close();
				br.close();
				pw.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
