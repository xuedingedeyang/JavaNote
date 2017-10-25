
public class Initail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Animal animal = dog;//自动类型提升，向上类型转换
		Dog dog2 =(Dog) animal;//向下类型转换 强制类型转换
		if(animal instanceof Cat){
			
		
		Cat cat = (Cat)animal;
		}else{
			System.out.println("无法进行类型转换，转换成Cat类型");
		}
//		Animal obj1 = new Animal();
//		Animal obj2 = new Dog();//父类对象的引用可以指向本类的对象
//		//Dog obj3 = new Animal();//错误，子类对象的引用不能指向父类的对象
//		obj1.eat();
//		obj2.eat();
//		Animal obj3 = new Cat();
//		obj3.eat();
	}

}
