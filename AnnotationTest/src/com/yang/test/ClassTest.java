package com.yang.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
@Anno
public class ClassTest {
	private ClassTest(){}
	
	public ClassTest(String name)
	{
		System.out.println("执行有参数的构造方法");
	}
	
	public void info()
	{
		System.out.println("执行无参数的info方法");
	}
	
	public void info(String name){
		System.out.println("执行有参数的info方法");
	}
	
	class Inner
	{}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class<ClassTest> clazz = ClassTest.class;
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest类的全部构造器如下:");
		for(Constructor c : ctors){
			System.out.println(c);
		}
		Constructor[] publicConstructors = clazz.getConstructors();
		System.out.println("ClassTest类的全部public构造器如下:");
		for(Constructor c:publicConstructors){
			System.out.println(c);
		}
		
		Method[] methods = clazz.getMethods();
		System.out.println("Class类的全部方法如下：");
		for(Method method:methods){
			System.out.println(method);
		}
		System.out.println("ClassTesr类对象里带一个字符串参数的info方法为:"+clazz.getMethod("info", String.class));
		
		Annotation[] annos = clazz.getAnnotations();
		System.out.println("ClassTest类的全部Annotation如下:");
		for(Annotation an:annos)
		{
			System.out.println(an);
		}
		System.out.println();
	}

}

@Repeatable(Annos.class)
@interface Anno{}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos
{
	Anno[] value();
}
