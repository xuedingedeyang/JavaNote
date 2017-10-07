package yang.iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File f = new File("��ɪ.txt");
		FileChannel inChannel = null,outChannel = null;
		try {
			inChannel = new FileInputStream(f).getChannel();
			outChannel = new FileOutputStream("a.txt").getChannel();
			//��FileChannel�������ȫ��ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			//ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			buffer.clear();
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charbuffer = decoder.decode(buffer);
			System.out.println(charbuffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

}
