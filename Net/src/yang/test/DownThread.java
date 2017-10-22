package yang.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownThread extends Thread {
	//当前下载的位置
	private int startPos;
	//定义当前线程负责下载文件的大小
	private int currentPartSize;
	//定义线程需要下载的文件块
	private RandomAccessFile currentPart;
	//保存文件的路径
	private String path;
	//定义已下载的字节数
	public int length;
	
	public DownThread(int startPos,int currentPartSize,RandomAccessFile currentPart,String path)
	{
		this.startPos = startPos;
		this.currentPartSize = currentPartSize;
		this.currentPart = currentPart;
		this.path = path;
	}
	
	@Override
	public void run() {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept","image/gif,image/jpeg,image/jpeg,"
					+ "application/x-shockwave-flash,application/xaml+xml,"
					+ "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
					+ "application/x-ms-application,application/vnd.ms-excel,"
					+ "application/vnd.ms-powerpoint,application/mswordm,*/*");
			conn.setRequestProperty("Accept-Language", "UTF-8");
			InputStream inStream = conn.getInputStream();
			//跳过startPos个字节，表明该线程只下载自己负责的那部分文件
			inStream.skip(this.startPos);
			byte[] buffer = new byte[1024];
			int hasread = 0;
			while(length < currentPartSize && (hasread = inStream.read(buffer))!=-1)
			{
				currentPart.write(buffer,0,hasread);
				length+=hasread;
			}
			currentPart.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
