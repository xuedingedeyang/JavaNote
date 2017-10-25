package Day04;

public class ThreadTask implements Runnable{
	private int num = 0;
	private Object lock = new Object();
	public void run(){
		while(num<1000){
			synchronized(lock){
			num++;
			System.out.println(Thread.currentThread().getName()+"-->"+num);
			}
		}
			
	}
}
