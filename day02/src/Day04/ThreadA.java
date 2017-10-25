package Day04;

public class ThreadA extends Thread{
	public ThreadA(String name){
		super(name);
	}
	
	public void run(){
		for(int i =0;i<100;i++){
			System.out.println(getName()+"-->"+i);
		};
	}
}
