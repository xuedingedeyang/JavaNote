
public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest trc = new TryCatchTest();
		int result = trc.test();
		System.out.println(result);
		TryCatchTest trc2 = new TryCatchTest();
		int result2 = trc2.test2();
	}
	/*
	 * divider(除数)
	 * result（结果）
	 * trycatch捕获while循环
	 * 每次循环，divider减一，result=result +100/divider
	 * 如果，捕获异常，打印输出“抛出异常了！！”，返回-1
	 * 否则，返回result
	 */
	public int test(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环抛出异常啦！！！");
			return -1;
		}
	
	}
	public int test2(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环抛出异常啦！！！");
			return result=999;
		}finally{
			System.out.println("这是finally 哈哈！！");
			System.out.println("我是result我的值是："+result);
		}
	}
	public int test3(){
		int divider = 10;
		int result = 100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环抛出异常啦！！！");
			return result=999;
		}finally{
			System.out.println("这是finally 哈哈！！");
			System.out.println("我是result我的值是："+result);
		}
	}
}
