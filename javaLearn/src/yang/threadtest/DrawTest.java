package yang.threadtest;

public class DrawTest {
	public static void main(String[] args) {
		Account acc = new Account("12345",0);
		new DrawThread("取款者",acc,800).start();
		new DepositThread("存款者a",acc,800).start();
		new DepositThread("存款者b",acc,800).start();
		new DepositThread("存款者c",acc,800).start();
	}
}
