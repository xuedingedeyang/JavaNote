package com.yang.test;

import java.util.Scanner;

public class Student extends Person {
	private String num;
	
	public void print()
	{
		super.print();
		System.out.println("学号:"+num);
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public static void main(String[] args) {
//		String s1 = "hello";
//		String s2 = "hello";
//		String s3 = "hellohello";
//		String s4 = new String("hello");
//		
//		System.out.println(s1==s2);
//		System.out.println(s3==(s1+s2));
//		System.out.println(s3==("hello" + "hello"));
//		System.out.println(s1 == s4);
//		
//		System.out.println("\n\n");
//		
//		Integer c = 1;
//		Integer d = 1;
//		System.out.println(c == d);
//		
//		Double a = 1.5;
//		Double b = 1.5;
//		System.out.println(a == b);
		
		int[] a = new int[10];
		System.out.println("请输入10个数");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("请输入要查找的数：");
		int b = sc.nextInt();
		
		
	}
}
