package project;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		dog.age = 15;
		Dog dog2 = new Dog();
		dog2.age = 15;
		if(dog.equals(dog2)){
			System.out.println("������������ͬ��");
		}else{
			System.out.println("���������ǲ�ͬ��");
		}
//		dog.age = 5;
//		dog.name ="xiaoming";
//		dog.eat();
//		dog.method();
//		
	}

}
