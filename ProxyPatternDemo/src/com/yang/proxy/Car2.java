package com.yang.proxy;

public class Car2 extends Car {
	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		super.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车结束行驶...");
		System.out.println("汽车行驶时间："+(endTime - startTime)+"毫秒");
	}
	/*
	 * 这里采用继承方式来实现静态代理，Car2类继承了Car类，并在子类中调用了父类的move()方法，
	 * 在父类move方法前后增加子类需要的逻辑，即代理记录行驶时间。这种方式为继承方式实现静态代理
	 */
}
