package coreJava;

import java.io.Serializable;

public class Student implements Serializable{
	private String stuNum;
	private String stuName;
	private transient int stuAge;//��transient���κ󲻻ᱻ�����(jvm)Ĭ�ϵ����⻯���������Լ�������Ԫ�ص����л�
	
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
		s.defaultWriteObject();//���������Ĭ�����л���Ԫ�ؽ������л�����
		s.writeObject(stuAge);//�Լ����stuAge�����л�
	}
	private void readObject(java.io.ObjectInputStream s)throws java.io.IOException,ClassNotFoundException{
		s.defaultReadObject();//�������Ĭ���ܷ����л���Ԫ�ؽ��з����л�����
		this.stuAge = s.readInt();//�Լ����stuAge�ķ����л�����
	}

}
