package com.yang.test;

import java.lang.reflect.Method;

//通过注解分析目标类，如果目标类中方法使用了@Testable注解修饰，则通过反射来运行该测试方法
public class ProcessorTest {
	
	public static void process(String clazz) throws ClassNotFoundException
	{
		int passed=0;
		int failed=0;
		//遍历clazz对应类里的所有方法
		for(Method m:Class.forName("MyTest").getMethods())
		{
			if(m.isAnnotationPresent(Testable.class))
			{
				try {
					//调用m方法
					m.invoke(null);
					//测试成功，计数器加1
					passed++;
				} catch (Exception e) {
					System.out.println("方法"+m+"运行失败，异常:"+e.getCause());
					failed++;
				}
			}	
		}
		System.out.println("共运行了:"+(passed+failed)+"个方法，其中:\n" +
		"失败了 " + failed +"个\n" + "成功了" + passed + "个");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ProcessorTest.process("MyTest");
	}

}
