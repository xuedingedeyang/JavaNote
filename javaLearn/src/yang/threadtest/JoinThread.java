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
		new JoinThread("���߳�").start();
		for(int i = 0; i < 100 ; i++){
			if(i == 20){
				JoinThread jt = new JoinThread("��join���߳�");
				jt.start();
				//main�̵߳�����jt��join������main�̱߳����jtִ����Ż����ִ��
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
