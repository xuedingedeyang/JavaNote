
public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPlayGame ip1 = new SmartPhone();
		ip1.playGame();
		IPlayGame ip2 = new Psp();
		ip2.playGame();
		IPlayGame ip3 = new IPlayGame(){

			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("使用匿名内部类的方法实现接口");
			}
			
		};
		ip3.playGame();
		new IPlayGame(){
			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("使用匿名内部类的方法实现接口2");
			}	
		}.playGame();
				
	}
}
