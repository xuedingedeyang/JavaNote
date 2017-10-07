package yang.threadtest;

public class JoinThread extends Thread {
	
	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);			
		}
	}
	
	public static void main(String[] args) {
		new JoinThread("新线程").start();
		for(int i = 0; i < 100 ; i++){
			if(i == 20){
				JoinThread jt = new JoinThread("被join的线程");
				jt.start();
				//main线程调用了jt的join方法，main线程必须等jt执行完才会继续执行
				try {
					jt.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
