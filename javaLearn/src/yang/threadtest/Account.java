package yang.threadtest;

public class Account {
	private String accountNo;
	private double balance;
	private boolean flag = false;
	public Account(){};
	public Account(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	
	public int hashCode(){
		return accountNo.hashCode();
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(this == arg0){
			return true;
		}
		if(arg0 != null && arg0.getClass() == Account.class){
			Account target = (Account) arg0;
			return target.getAccountNo().equals(accountNo);
		}
		return super.equals(arg0);
	}
	
	public synchronized void draw(double drawAmount){
		try {
			if(!flag){
				wait();
			}else{
				System.out.println(Thread.currentThread().getName() + "»°«Æ £∫ " +drawAmount);
				balance -= drawAmount;
				System.out.println("’Àªß”‡∂Ó£∫" + balance);
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositAmount){
		try {
			if(flag){
				wait();
			}else{
				System.out.println(Thread.currentThread().getName() + "¥Ê«Æ :" + depositAmount);
				balance += depositAmount;
				System.out.println("’Àªß”‡∂Ó£∫" + balance);
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
