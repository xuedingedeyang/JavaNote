package myDay01;

public class initialTelphone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telphone phone = new Telphone();
		phone.screen = 5.0f;
		phone.cpu = 1.8f;
		phone.mem = 2.0f;
		
		Telphone phone2 = new Telphone();
		phone2.screen = 5.0f;
		phone2.cpu = 1.8f;
		phone2.mem =2.0f;
		System.out.println(phone);
		
		
		//Telphone phone2 = new Telphone(1.5f,1.8f,4.0f);
		//phone2.CPU=3.0f;
		
		//phone2.setScreen(8.0f);
		//System.out.println("screen:  "+phone2.getScreen());
		if(phone.equals(phone2)){
			System.out.println("两个对象是相同的");
		}else{
			System.out.println("两个对象是不同的");
		}
	}

}
	