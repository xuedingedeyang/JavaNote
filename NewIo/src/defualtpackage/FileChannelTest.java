package defualtpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("NIO.txt");
		try {
			FileChannel inChannel = new FileInputStream(f).getChannel();
			FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
			
			//��FileChannel�������ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			//ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			//�ٴε���buffer��clear��������ԭlimit��position��λ��
			buffer.clear();
			//��������������
			CharsetDecoder decoder = charset.newDecoder();
			//ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			System.out.println(charBuffer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
