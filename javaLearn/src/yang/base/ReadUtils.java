package yang.base;

public class ReadUtils {
	
	private myListener listener;
	
	public ReadUtils(myListener listener){
		this.listener = listener;
	}
	
	public void read(){
		new Thread(){
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("异步读操作完成！");
				listener.onCallBack();
			};
		}.start();
	}
}
