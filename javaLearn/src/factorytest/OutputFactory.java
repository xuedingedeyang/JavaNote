package factorytest;

public class OutputFactory {
	public Output getOutput(){
		return new Printer();
	}
	
	public static void main(String[] args){
		OutputFactory factory = new OutputFactory();
		Computer c = new Computer(factory.getOutput());
		c.keyIn("����ģʽѧϰ");
		c.keyIn("2017��10��1��");
		c.print();
	}
	
}
