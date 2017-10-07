package lambdatest;

interface Display{
	//����һ�����󷽷���Ĭ�Ϸ���
	void display();
	default int add(int a,int b){
		return a + b;
	}
}
public class LambdaAndInner {
	private int age = 12;
	private static String name = "Ѧ���̵���";
	public void test(){
		String book = "Lambda���ʽѧϰ";
		Display dis = () -> {
			System.out.println("bool�ֲ�����Ϊ:" + book);
			//�����ⲿ���ʵ�������������
			System.out.println("�ⲿ���ageʵ������Ϊ:" + age);
			System.out.println("�ⲿ���name����Ϊ:" + name);
		};
		dis.display();
		//����dis����ӽӿ��м̳е�add()����
		System.out.println(dis.add(3, 5));
	}
	
	public static void main(String[] args){
		LambdaAndInner lambda = new LambdaAndInner();
		lambda.test(); 
	}
}
