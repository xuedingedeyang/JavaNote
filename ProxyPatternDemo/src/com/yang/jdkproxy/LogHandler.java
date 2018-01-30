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
		System.out.println("汽车开始记录日志...");
		method.invoke(target);
		System.out.println("汽车结束记录日志");
		return null;
	}

}
