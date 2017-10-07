package lambdatest;

/**
 * Lambda���ʽ�����ͣ�Ҳ����Ϊ��Ŀ�����͡�,Lambda���ʽ��Ŀ�����ͱ����ǡ�����ʽ�ӿڡ�������ʽ�ӿڴ���һ�����󷽷��Ľӿڡ�
 * ����ʽ�ӿڿ��԰������ĥ�˷������෽������ֻ������һ�����󷽷�
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
	
	//���øö�����ҪEatable����
	public void eat(Eatable eat){
		System.out.println(eat);
		eat.taste();
	}
	
	//���øö�����ҪFlyable����
	public void drive(Flyable f){
		System.out.println("�����ڼ�ʻ��"+f);
		f.fly("�̿���ϴ������");
	}
	
	public void test(Addable add){
		System.out.println("5��3�ĺ�Ϊ��" + add.add(5, 3));
	}
	
	public static void main(String[] args){
		lambdatest test = new lambdatest();
		test.eat(()->System.out.println("ƻ��ζ������!"));
		test.drive(weather -> {
			System.out.println("����������:" + weather);
			System.out.println("ֱ��������ƽ��");
			
		});
		test.test((a,b)->a+b);
		
		Converter c = from -> Integer.valueOf(from);
		System.out.println("99ת����" + c.converter("99"));
		
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
