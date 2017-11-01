package com.yang.test;

import java.lang.reflect.Method;

//ͨ��ע�����Ŀ���࣬���Ŀ�����з���ʹ����@Testableע�����Σ���ͨ�����������иò��Է���
public class ProcessorTest {
	
	public static void process(String clazz) throws ClassNotFoundException
	{
		int passed=0;
		int failed=0;
		//����clazz��Ӧ��������з���
		for(Method m:Class.forName("MyTest").getMethods())
		{
			if(m.isAnnotationPresent(Testable.class))
			{
				try {
					//����m����
					m.invoke(null);
					//���Գɹ�����������1
					passed++;
				} catch (Exception e) {
					System.out.println("����"+m+"����ʧ�ܣ��쳣:"+e.getCause());
					failed++;
				}
			}	
		}
		System.out.println("��������:"+(passed+failed)+"������������:\n" +
		"ʧ���� " + failed +"��\n" + "�ɹ���" + passed + "��");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ProcessorTest.process("MyTest");
	}

}
