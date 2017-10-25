package coreJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSeriaDemo2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("demo/obj1.dat"));
//		Foo2 foo2 = new Foo2();
//		oos.writeObject(foo2);
//		oos.flush();
//		oos.close();
		
		//�����л��Ƿ�ݹ���ø���Ĺ��캯��
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("demo/obj1.dat"));
		Foo2 foo2 = (Foo2) ois.readObject();
		ois.close();
	}

}
//һ����ʵ�������л��ӿڣ������඼����ʵ�����л�
class Foo implements Serializable{
	public Foo(){
		System.out.println("foo...");
	}
}
class Foo1 extends Foo{
	public Foo1(){
		System.out.println("foo1...");
	}
}
class Foo2 extends Foo1{
	public Foo2(){
		System.out.println("foo2...");
	}
}
