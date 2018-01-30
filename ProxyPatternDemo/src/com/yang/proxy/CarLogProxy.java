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
		System.out.println("汽车开始记录日志...");
		m.move();
		System.out.println("汽车结束日志...");
	}
	
	/**
	 * 这种把参数传入进来，通过参数调用方法，并在这个类中增加业务逻辑实现代理，这种方式称为聚合的方式实现静态代理
	 */

}
