package project;

public class Dog extends Animal {
	public int age = 20;
	public Dog(){
		
		System.out.println("Dog��ִ����");
	}
	@Override
	public void eat(){
		System.out.println("�����гԹ�ͷ������");
	}
	public void method(){
		System.out.println(super.age);
		System.out.println(age);
		super.eat();
		eat();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		return true;
	}
	

	
	
}
