package project;

 public class Animal {
	public int age = 10;
	public String name;

	public void eat(){
		final int i =10;
			System.out.println("Animal类执行了");
		System.out.println("动物具有吃东西的能力");
	}
	public Animal(){
		System.out.println("Animal类执行了");
	}
	public Animal (int age){
		this.age = 3;
	}

}
