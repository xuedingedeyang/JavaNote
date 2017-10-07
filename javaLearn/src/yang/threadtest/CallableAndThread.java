package yang.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndThread {

	public static void main(String[] args) {
		CallableAndThread rt = new CallableAndThread();
//		FutureTask<Integer>task = new FutureTask<>(new Callable<Integer>() {
//			@Override
//			public Integer call() throws Exception {
//				return null;
//			}
//		});
		FutureTask<Integer>task = new FutureTask<>((Callable<Integer>)() -> {
			int i = 0;
			for(; i < 100 ; i++){
				System.out.println(Thread.currentThread().getName() + "��ѭ��������ֵ:" + i);
			}
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "ѭ��������ֵ��"+ i);
			if(i == 20){
				new Thread(task,"�з���ֵ���߳�").start();
			}
		}
		try {
			System.out.println("���̵߳ķ���ֵ��"+task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
