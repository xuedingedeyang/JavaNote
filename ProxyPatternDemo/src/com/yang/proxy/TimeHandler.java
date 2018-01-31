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
			System.out.println("汽车行驶开始");
			m.invoke(target);
			long endTime = System.currentTimeMillis();
			System.out.println("汽车结束行驶");
			System.out.println("汽车行驶时间:"+(endTime-startTime)+"毫秒");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
