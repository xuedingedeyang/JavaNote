package yang.mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 
 * 服务器端
 * @author yang
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1.创建一个服务器端socket，即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.调用accept()方法开始监听，等待客户端的连接
			System.out.println("***服务器即将启动，等待客户端连接***");
			Socket socket = serverSocket.accept();
			//3.获取一个输入流，用来读取客户端信息
			InputStream is = socket.getInputStream();//字节输入流
			InputStreamReader isr = new InputStreamReader(is);//将字节流转换成字符流
			BufferedReader br = new BufferedReader(isr);//字节流转换成字符流
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println("我是服务器，客户端说:"+line);
			}
			socket.shutdownInput();//关闭输入流
			
			//4.获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎登陆!");
			pw.flush();//调用flush(),刷新缓存
			
			//5.关闭资源
			is.close();
			isr.close();
			br.close();
			pw.close();
			os.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
