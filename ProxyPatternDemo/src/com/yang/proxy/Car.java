package com.yang.proxy;

import java.util.Random;

public class Car implements Moveable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
//		long startTime = System.currentTimeMillis();
//		System.out.println("汽车开始行驶...");
		//实现开车
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车行驶中...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("汽车结束行驶...");
//		System.out.println("汽车行驶时间："+(endTime - startTime)+"毫秒");
	}

}
