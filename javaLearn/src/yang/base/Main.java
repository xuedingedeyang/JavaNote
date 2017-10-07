package yang.base;

public class Main implements myListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		ReadUtils r = new ReadUtils(m);
		r.read();
	}

	@Override
	public void onCallBack() {
		// TODO Auto-generated method stub
		System.out.println("执行回调方法！");
	}

}
