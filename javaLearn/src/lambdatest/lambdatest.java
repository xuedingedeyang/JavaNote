package lambdatest;

/**
 * Lambda表达式的类型，也被称为“目标类型”,Lambda表达式的目标类型必须是“函数式接口”。函数式接口代表一个抽象方法的接口。
 * 函数式接口可以包含多个磨人方法、类方法、但只能声明一个抽象方法
 * @author yang
 *
 */

interface Eatable{
	void taste();
}

interface Flyable{
	void fly(String weather);
}

interface Addable{
	int add(int a,int b);
}

public class lambdatest {
	
	//调用该对象需要Eatable对象
	public void eat(Eatable eat){
		System.out.println(eat);
		eat.taste();
	}
	
	//调用该对象需要Flyable对象
	public void drive(Flyable f){
		System.out.println("我正在驾驶："+f);
		f.fly("碧空如洗的晴天");
	}
	
	public void test(Addable add){
		System.out.println("5与3的和为：" + add.add(5, 3));
	}
	
	public static void main(String[] args){
		lambdatest test = new lambdatest();
		test.eat(()->System.out.println("苹果味道不错!"));
		test.drive(weather -> {
			System.out.println("今天天气是:" + weather);
			System.out.println("直升机飞行平稳");
			
		});
		test.test((a,b)->a+b);
		
		Converter c = from -> Integer.valueOf(from);
		System.out.println("99转换后" + c.converter("99"));
		
		Converter c2 = from -> "fkit.org".indexOf(from);
//		c2 = new Converter() {
//
//			@Override
//			public Integer converter(String from) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
		System.out.println(c2.converter("it"));
	}
	
	
}
