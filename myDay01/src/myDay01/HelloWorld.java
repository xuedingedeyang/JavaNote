package myDay01;

public class HelloWorld {
	static String hobby = "immoc";
	
	public static void main(String[] args){
		System.out.println("ͨ���������ʱ���hobby��" + HelloWorld.hobby);
		HelloWorld hello = new HelloWorld();
		System.out.println("ͨ�����������ʱ���hobby��" + hello.hobby);
		hello.hobby = "Ľ����";
		System.out.println(hello.hobby);
	}

}
