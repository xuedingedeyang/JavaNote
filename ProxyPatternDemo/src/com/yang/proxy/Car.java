package com.yang.proxy;

import java.util.Random;

public class Car implements Moveable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
//		long startTime = System.currentTimeMillis();
//		System.out.println("������ʼ��ʻ...");
		//ʵ�ֿ���
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("������ʻ��...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("����������ʻ...");
//		System.out.println("������ʻʱ�䣺"+(endTime - startTime)+"����");
	}

}
