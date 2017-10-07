package yang.threadtest;

public class DepositThread extends Thread {
	private Account account;
	private double depositAmount;
	
	public DepositThread(String name,Account account,double amount){
		super(name);
		this.account = account;
		this.depositAmount = amount;
	}
	
	public void run(){
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}
