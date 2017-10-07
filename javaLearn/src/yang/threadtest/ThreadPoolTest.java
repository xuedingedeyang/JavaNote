package yang.threadtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		ExecutorService pool2 = Executors.newScheduledThreadPool(5);
		Runnable target = () -> {
			for(int i = 0 ; i < 100 ; i++){
				System.out.println(Thread.currentThread().getName() + "的i的值为：" + i);
			}
		};
		
//		pool2.submit(target);
		
		pool.submit(target);
		pool.submit(target);
		pool.shutdown();

	}

}
