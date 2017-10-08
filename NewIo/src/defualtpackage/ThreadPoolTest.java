package defualtpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个具有固定线程数的线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		Runnable target = () -> {
			for(int i = 0 ; i < 100 ; i++){
				System.out.println(Thread.currentThread().getName() + ",i的值为:" + i);
			}
		};
		
		//向线程池中添加两个线程
		pool.submit(target);
		pool.submit(target);
		//关闭线程池
		pool.shutdown();
	}

}
