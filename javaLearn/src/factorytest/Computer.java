package factorytest;

public class Computer {
	
	private Output out;
	
	public Computer(Output out){
		this.out = out;
	}
	
	//����һ��ģ���ȡ�ַ�������ķ���
	public void keyIn(String msg){
		out.getData(msg);
	}
	
	public void print(){
		out.out();
	}
}
