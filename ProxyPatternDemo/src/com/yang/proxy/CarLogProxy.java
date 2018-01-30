package com.yang.proxy;

public class CarLogProxy implements Moveable {
	private Moveable m;
	
	public CarLogProxy(Moveable m)
	{
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("������ʼ��¼��־...");
		m.move();
		System.out.println("����������־...");
	}
	
	/**
	 * ���ְѲ������������ͨ���������÷��������������������ҵ���߼�ʵ�ִ������ַ�ʽ��Ϊ�ۺϵķ�ʽʵ�־�̬����
	 */

}
