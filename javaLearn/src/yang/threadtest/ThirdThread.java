package yang.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdThread tr = new ThirdThread();
		
	
		FutureTask<Integer> task = new FutureTask<>((Callable)()->{
		int i = 0;
		for( ; i < 100 ; i++){
			System.out.println(Thread.currentThread().getName() + "ѭ������i��ֵ��" + i);
		}
			return i;
		});
		
		for(int i = 0 ; i < 100 ; i++)
		{
			if( i == 20){
				new Thread(task,"�з���ֵ���߳�").start();
			}
			try {
				System.out.println("���̵߳ķ���ֵ:" + task.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
