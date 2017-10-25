package myDay01;

public class HelloWorld {
	static String hobby = "immoc";
	
	public static void main(String[] args){
		System.out.println("通过方法访问变量hobby：" + HelloWorld.hobby);
		HelloWorld hello = new HelloWorld();
		System.out.println("通过对象名访问变量hobby：" + hello.hobby);
		hello.hobby = "慕课网";
		System.out.println(hello.hobby);
	}

}
