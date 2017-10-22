package yang.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownUtil {
	
	private String path;
	
	private String targetFile;
	
	private int threadNum;
	
	private DownThread[] threads;
	
	private int fileSize;
	
	public DownUtil(String path,String targetFile,int threadNum)
	{
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}
	
	public void download() throws MalformedURLException
	{
		URL url = new URL(path);
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/jpeg,"
					+ "application/x-shockwave-flash,application/xaml+xml,"
					+ "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
					+ "application/x-ms-application,application/vnd.ms-excel,"
					+ "application/vnd.ms-powerpoint,application/mswordm,*/*");
			conn.setRequestProperty("Accept-Language", "zh-CN");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Connection", "Keep-Alive");
			
			fileSize = conn.getContentLength();
			conn.disconnect();
			
			int currentPartSize = fileSize/threadNum + 1;
			RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
			
			file.setLength(fileSize + 1);
			file.close();
			for(int i = 0 ; i < threadNum ; i++)
			{
				int startPos = i * currentPartSize;
				RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
				currentPart.seek(startPos);
				threads[i] = new DownThread(startPos, currentPartSize, currentPart, path);
				threads[i].start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double getCompleteRate()
	{
		int sumSize = 0;
		for(int i = 0 ; i < threadNum ; i++)
		{
			sumSize+=threads[i].length;
		}
		
		return sumSize * 1.0 / fileSize;
	}
	
	public static void main(String[] args) throws MalformedURLException {
		final DownUtil downutil = new DownUtil("http://www.crazyit.org/attachements/month"
				+ "_1403/1403202355ff6cc9a4fbf6f14a.png", "ios.png", 4);
		
		downutil.download();
		new Thread(() -> 
		{
			while(downutil.getCompleteRate() < 1)
			{
				System.out.println("ÒÑÍê³É:" + downutil.getCompleteRate());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	
	}

}
