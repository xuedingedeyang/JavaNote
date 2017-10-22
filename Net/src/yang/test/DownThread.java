package yang.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownThread extends Thread {
	//��ǰ���ص�λ��
	private int startPos;
	//���嵱ǰ�̸߳��������ļ��Ĵ�С
	private int currentPartSize;
	//�����߳���Ҫ���ص��ļ���
	private RandomAccessFile currentPart;
	//�����ļ���·��
	private String path;
	//���������ص��ֽ���
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
			//����startPos���ֽڣ��������߳�ֻ�����Լ�������ǲ����ļ�
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
