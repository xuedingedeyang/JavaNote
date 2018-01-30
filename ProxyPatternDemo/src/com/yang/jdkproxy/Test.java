package com.yang.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.yang.proxy.Car;
import com.yang.proxy.Moveable;

public class Test {

	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?>cls = car.getClass();
		/**
		 * loader �������
		 * interface ʵ�ֽӿ�
		 * h InvocationHandler
		 * 
		 * 
		 * ��̬����ʵ��˼·
		 * ʵ�ֹ��ܣ�ͨ��Proxy��newInstance���ش������
		 * 1.����һ��Դ��(��̬��������)
		 * 2.����Դ��(JDK Compiler API),����������(������)
		 * 3.�������load���ڴ浱�У�����һ���������(�������)
		 * 4.���ش������
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		System.out.println("��������"+m.getClass().getName());
		m.move();
	}

}
