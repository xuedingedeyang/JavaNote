package yang.threadtest;

public class DrawTest {
	public static void main(String[] args) {
		Account acc = new Account("12345",0);
		new DrawThread("ȡ����",acc,800).start();
		new DepositThread("�����a",acc,800).start();
		new DepositThread("�����b",acc,800).start();
		new DepositThread("�����c",acc,800).start();
	}
}
