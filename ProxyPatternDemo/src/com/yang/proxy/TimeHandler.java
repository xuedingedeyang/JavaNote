package com.yang.proxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		try {
			long startTime = System.currentTimeMillis();
			System.out.println("������ʻ��ʼ");
			m.invoke(target);
			long endTime = System.currentTimeMillis();
			System.out.println("����������ʻ");
			System.out.println("������ʻʱ��:"+(endTime-startTime)+"����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
