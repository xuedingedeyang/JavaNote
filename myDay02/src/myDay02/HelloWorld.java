package myDay02;

public class HelloWorld {
	String name ;
	String sex;
	static int age;
	//���췽��
	public HelloWorld(){
		System.out.println("ͨ�����췽����ʼ��name��");
		name = "tom";
	}
	
	{
		System.out.println("ͨ����ʼ�����ʼ��sex");
		sex="��";
	}
	//��̬����ʼ��
	{
		age = 20;
	}
	public void show(){
		System.out.println("����:  "+name+ "  �Ա�:  "+sex+ "  ����:  "+age);
		
	}
	public static void main(String[]args){
		HelloWorld hello = new HelloWorld();
		hello.show();
	}
	

}
