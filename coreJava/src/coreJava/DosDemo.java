package coreJava;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String file = "demo/dos.dat";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.999);
		dos.writeUTF("�й�");//����utf-8����д��
		dos.writeChars("�й�");//����utf-16be����д��
		dos.close();
		IOUtil.printHex(file);
	}

}
