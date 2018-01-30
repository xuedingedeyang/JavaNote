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
		System.out.println("汽车开始行驶...");
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车结束行驶...");
		System.out.println("汽车行驶时间："+(endTime - startTime)+"毫秒");
	}
	
	/**
	 * 这种把参数传入进来，通过参数调用方法，并在这个类中增加业务逻辑实现代理，这种方式称为聚合的方式实现静态代理
	 */

}
