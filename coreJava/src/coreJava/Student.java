package coreJava;

import java.io.Serializable;

public class Student implements Serializable{
	private String stuNum;
	private String stuName;
	private transient int stuAge;//被transient修饰后不会被虚拟机(jvm)默认的虚拟化，但可以自己完成这个元素的序列化
	
	public Student(){
		
	}
	
	
	
	public Student(String stuName, String stuNum, int stuAge) {
		super();
		this.stuName = stuName;
		this.stuNum = stuNum;
		this.stuAge = stuAge;
	}



	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuNum=" + stuNum + ", stuAge=" + stuAge + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream s)throws java.io.IOException{
		s.defaultWriteObject();//把虚拟机能默认序列化的元素进行序列化操作
		s.writeObject(stuAge);//自己完成stuAge的序列化
	}
	private void readObject(java.io.ObjectInputStream s)throws java.io.IOException,ClassNotFoundException{
		s.defaultReadObject();//把虚拟机默认能反序列化的元素进行反序列化操作
		this.stuAge = s.readInt();//自己完成stuAge的反序列化操作
	}

}
