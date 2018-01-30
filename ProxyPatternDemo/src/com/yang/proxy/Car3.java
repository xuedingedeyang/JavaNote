package com.yang.proxy;

public class Car3 implements Moveable {
	private Car car;
	
	public Car3(Car car)
	{
		super();
		this.car = car;
	}

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("������ʼ��ʻ...");
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("����������ʻ...");
		System.out.println("������ʻʱ�䣺"+(endTime - startTime)+"����");
	}
	
	/**
	 * ���ְѲ������������ͨ���������÷��������������������ҵ���߼�ʵ�ִ������ַ�ʽ��Ϊ�ۺϵķ�ʽʵ�־�̬����
	 */

}
