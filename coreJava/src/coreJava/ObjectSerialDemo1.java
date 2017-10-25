package coreJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String file = "demo/obj.data";
		//1.对象序列化
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//		Student stu = new Student("10001","张三丰",20);
//		oos.writeObject(stu);
//		oos.flush();
//		oos.close();
		//2.反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu = (Student)ois.readObject();
		System.out.println(stu);
		ois.close();

	}

}
