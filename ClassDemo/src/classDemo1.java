
public class classDemo1 {

	public static void main(String[] args) {
		//Foo����ı�ʾ����
		Foo foo1 = new Foo();//foo1��ʾ������
		//Foo��Ҳ��һ��ʵ������Class���ʵ������
		//�κ�һ���඼��Class���ʵ���������ʵ�������ֱ�ʾ��ʽ
		
		
		//��һ�ֱ�ʾ��ʽ---->�κ�һ���඼��һ�������ľ�̬��Ա����class
		Class c1 = Foo.class;
		
		//�ڶ��ֱ�﷽ʽ   ��֪����Ķ���ͨ��getClass����
		Class c2 = foo1.getClass();
		
		//c1 / c2 	��ʾ�����������(class type) 
		/*
		 *  ��������Զ��� 
		 *  ��Ҳ�Ƕ���
		 *  ����������ǳ�Ϊ�����������
		 */
		
		//����c1,c2��������Fool��������ͣ�һ����ֻ������Class���һ��ʵ������
		
		System.out.println(c1==c2);
		
		
		//�����ֱ�﷽ʽ
		
		Class c3 = null;
		try {
			c3 = Class.forName("com.example.classDemo.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c2==c3);
		
		//������ȫ����ͨ��������ʹ�������Ķ���ʵ�� --->ͨ�� c1,c2��c3����Fool���ʵ��
		try {
			Foo foo = (Foo)c1.newInstance();//��Ҫ���޲����Ĺ��췽��
			foo.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
class Foo{
	void print(){
		System.out.println("foo");
	}
}
