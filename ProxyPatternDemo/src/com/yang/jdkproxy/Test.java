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
		 * loader 类加载器
		 * interface 实现接口
		 * h InvocationHandler
		 * 
		 * 
		 * 动态代理实现思路
		 * 实现功能：通过Proxy的newInstance返回代理对象
		 * 1.声明一段源码(动态产生代理)
		 * 2.编译源码(JDK Compiler API),所产生的类(代理类)
		 * 3.将这个类load到内存当中，产生一个代理对象(代理对象)
		 * 4.返回代理对象
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		System.out.println("代理名字"+m.getClass().getName());
		m.move();
	}

}
