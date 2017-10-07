package factorytest;

public class Computer {
	
	private Output out;
	
	public Computer(Output out){
		this.out = out;
	}
	
	//定义一个模拟获取字符串输入的方法
	public void keyIn(String msg){
		out.getData(msg);
	}
	
	public void print(){
		out.out();
	}
}
