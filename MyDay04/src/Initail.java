
public class Initail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Animal animal = dog;//�Զ�������������������ת��
		Dog dog2 =(Dog) animal;//��������ת�� ǿ������ת��
		if(animal instanceof Cat){
			
		
		Cat cat = (Cat)animal;
		}else{
			System.out.println("�޷���������ת����ת����Cat����");
		}
//		Animal obj1 = new Animal();
//		Animal obj2 = new Dog();//�����������ÿ���ָ����Ķ���
//		//Dog obj3 = new Animal();//���������������ò���ָ����Ķ���
//		obj1.eat();
//		obj2.eat();
//		Animal obj3 = new Cat();
//		obj3.eat();
	}

}
