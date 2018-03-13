package com.yang.test;

public class Person {
	private String name;
	private String number;
	private String sex;
	private int age;
	
	public void print()
	{
		System.out.println("姓名:"+name);
		System.out.println("编号:"+number);
		System.out.println("性别:"+sex);
		System.out.println("年龄"+age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
