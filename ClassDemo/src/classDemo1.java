
public class classDemo1 {

	public static void main(String[] args) {
		//Foo对象的表示方法
		Foo foo1 = new Foo();//foo1表示出来了
		//Foo类也是一个实例对象，Class类的实例对象
		//任何一个类都是Class类的实例对象，这个实例有三种表示方式
		
		
		//第一种表示方式---->任何一个类都有一个隐含的静态成员变量class
		Class c1 = Foo.class;
		
		//第二种表达方式   已知该类的对象，通过getClass方法
		Class c2 = foo1.getClass();
		
		//c1 / c2 	表示了类的类类型(class type) 
		/*
		 *  万事万物皆对象 
		 *  类也是对象
		 *  这个对象我们称为该类的类类型
		 */
		
		//不管c1,c2都代表了Fool类的类类型，一个类只可能是Class类的一个实例对象
		
		System.out.println(c1==c2);
		
		
		//第三种表达方式
		
		Class c3 = null;
		try {
			c3 = Class.forName("com.example.classDemo.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c2==c3);
		
		//我们完全可以通过类的类型创建该类的对象实例 --->通过 c1,c2或c3创建Fool类的实例
		try {
			Foo foo = (Foo)c1.newInstance();//需要有无参数的构造方法
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
