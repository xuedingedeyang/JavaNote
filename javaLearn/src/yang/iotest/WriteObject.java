package yang.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static void main(String[] args) {
//		ObjectOutputStream oos = null;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
//			Person p = new Person("ËïÎò¿Õ",500);
//			oos.writeObject(p);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				oos.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		readObject();
	}

	public static void readObject(){
		ObjectInputStream ooi = null;
		try {
			ooi = new ObjectInputStream(new FileInputStream("object.txt"));
			Person p = (Person) ooi.readObject();
			System.out.println(p.getName()+":"+p.getAge());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ooi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
