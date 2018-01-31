package com.yang.proxy;

import java.sql.Time;

public class Client2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}

}
