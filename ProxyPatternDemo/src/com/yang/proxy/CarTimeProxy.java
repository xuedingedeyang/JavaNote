package com.yang.proxy;

public class CarTimeProxy implements Moveable {
	private Moveable m;
	
	public CarTimeProxy(Moveable m)
	{
		super();
		this.m = m;
	}

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ...");
		m.move();
		long endTime = System.currentTimeMillis();
		System.out.println("����������ʻ...");
		System.out.println("������ʻʱ�䣺"+(endTime - startTime)+"����");
	}
	
	/**
	 * ���ְѲ������������ͨ���������÷��������������������ҵ���߼�ʵ�ִ������ַ�ʽ��Ϊ�ۺϵķ�ʽʵ�־�̬����
	 */

}
