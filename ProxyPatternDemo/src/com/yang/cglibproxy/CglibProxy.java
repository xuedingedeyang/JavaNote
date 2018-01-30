package com.yang.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz)
	{
		//���ô����������
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/**
	 * ��������Ŀ����ķ�������
	 * obj Ŀ�����ʵ��
	 * method Ŀ�귽���ķ������
	 * args �����Ĳ���
	 * methodProxy �������ʵ��
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("��־��ʼ");
		//��������ø���ķ���
		methodProxy.invokeSuper(obj, args);
		System.out.println("��־����");
		return null;
	}

}
