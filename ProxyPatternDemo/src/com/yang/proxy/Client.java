package com.yang.proxy;

public class Client {
	public static void main(String[] args) {
//		Car car = new Car();
//		car.move();
		//使用集成方式
//		Moveable car2= new Car2();
//		car2.move();
		//使用聚合方式
//		Car car = new Car();
//		Moveable m = new Car3(car);
//		m.move();
		
		Car car = new Car();
		CarTimeProxy ctp = new CarTimeProxy(car);
		CarLogProxy clp = new CarLogProxy(ctp);
		clp.move();
	}
}
