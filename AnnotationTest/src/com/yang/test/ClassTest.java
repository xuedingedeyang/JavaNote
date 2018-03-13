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
		System.out.println("ִ���в����Ĺ��췽��");
	}
	
	public void info()
	{
		System.out.println("ִ���޲�����info����");
	}
	
	public void info(String name){
		System.out.println("ִ���в�����info����");
	}
	
	class Inner
	{}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class<ClassTest> clazz = ClassTest.class;
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest���ȫ������������:");
		for(Constructor c : ctors){
			System.out.println(c);
		}
		Constructor[] publicConstructors = clazz.getConstructors();
		System.out.println("ClassTest���ȫ��public����������:");
		for(Constructor c:publicConstructors){
			System.out.println(c);
		}
		
		Method[] methods = clazz.getMethods();
		System.out.println("Class���ȫ���������£�");
		for(Method method:methods){
			System.out.println(method);
		}
		System.out.println("ClassTesr��������һ���ַ���������info����Ϊ:"+clazz.getMethod("info", String.class));
		
		Annotation[] annos = clazz.getAnnotations();
		System.out.println("ClassTest���ȫ��Annotation����:");
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
