package com.yang.proxy;

public class Car2 extends Car {
	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ...");
		super.move();
		long endTime = System.currentTimeMillis();
		System.out.println("����������ʻ...");
		System.out.println("������ʻʱ�䣺"+(endTime - startTime)+"����");
	}
	/*
	 * ������ü̳з�ʽ��ʵ�־�̬����Car2��̳���Car�࣬���������е����˸����move()������
	 * �ڸ���move����ǰ������������Ҫ���߼����������¼��ʻʱ�䡣���ַ�ʽΪ�̳з�ʽʵ�־�̬����
	 */
}
