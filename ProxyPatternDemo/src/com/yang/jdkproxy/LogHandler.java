package com.yang.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	private Object target;
	
	public LogHandler(Object target)
	{
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("������ʼ��¼��־...");
		method.invoke(target);
		System.out.println("����������¼��־");
		return null;
	}

}
