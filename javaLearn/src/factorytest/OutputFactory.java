package factorytest;

public class OutputFactory {
	public Output getOutput(){
		return new Printer();
	}
	
	public static void main(String[] args){
		OutputFactory factory = new OutputFactory();
		Computer c = new Computer(factory.getOutput());
		c.keyIn("工厂模式学习");
		c.keyIn("2017年10月1日");
		c.print();
	}
	
}
