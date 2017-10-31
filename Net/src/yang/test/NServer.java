package yang.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NServer {
	private Selector selector = null;
	static final int PORT = 30000;
	private Charset charset = Charset.forName("utf-8");
	public void init() throws Exception
	{
		selector = Selector.open();
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
		//绑定ServerSocketChannel到指定地址
		server.bind(isa);
		//设置ServerSocket以非阻塞方式工作
		server.configureBlocking(false);
		server.register(selector, SelectionKey.OP_ACCEPT);
		while(selector.select()>0)
		{
			//一次处理selector上的每个已经选择的SelectionKey
			for(SelectionKey sk:selector.selectedKeys())
			{
				//从selector上删除正在处理的SlectionKey
				selector.selectedKeys().remove(sk);
				//如果sk对应Channel包含客户端的连接请求
				if(sk.isAcceptable())
				{
					SocketChannel sc = server.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					sk.interestOps(SelectionKey.OP_ACCEPT);
				}
				//如果sk对应Channel有数据需要读取
				if(sk.isReadable())
				{
					SocketChannel sc = (SocketChannel) sk.channel();
					ByteBuffer buff = ByteBuffer.allocate(1024);
					String content = "";
					try {
						while (sc.read(buff) > 0) {
							buff.flip();
							content += charset.decode(buff);
						}
						System.out.println("读取的数据:" + content);
						sk.interestOps(SelectionKey.OP_READ);
					} catch (Exception e) {
						sk.channel();
						if(sk.channel() != null)
						{
							sk.channel().close();
						}
					}
					if(content.length() > 0)
					{
						for(SelectionKey key:selector.keys())
						{
							Channel targetChannel = key.channel();
							if(targetChannel instanceof SocketChannel)
							{
								SocketChannel dest = (SocketChannel) targetChannel;
								dest.write(charset.encode(content));
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new NServer().init();
	}

}
