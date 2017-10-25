package myDay02;

public class HelloWorld {
	String name ;
	String sex;
	static int age;
	//构造方法
	public HelloWorld(){
		System.out.println("通过构造方法初始化name：");
		name = "tom";
	}
	
	{
		System.out.println("通过初始化块初始化sex");
		sex="男";
	}
	//静态化初始快
	{
		age = 20;
	}
	public void show(){
		System.out.println("姓名:  "+name+ "  性别:  "+sex+ "  年龄:  "+age);
		
	}
	public static void main(String[]args){
		HelloWorld hello = new HelloWorld();
		hello.show();
	}
	

}
