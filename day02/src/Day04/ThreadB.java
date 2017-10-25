package Day04;

public class ThreadB extends Thread{


		public ThreadB(String name){
			super(name);
		}
		
		public void run(){
			for(int i =0;i<100;i++){
				System.out.println(getName()+"-->"+i);
			}
		};
}


