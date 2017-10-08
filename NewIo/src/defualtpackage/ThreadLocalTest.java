package defualtpackage;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account at = new Account("初名");
		//虽然两个线程共享同一个账户，即只有一个账户名，但由于账户名是ThreadLocal类型的，所以每个线程都完全拥有各自账户的副本
		//，因此在i==6后，将看到两个线程访问同一个账户时出现不同名字的情况
		new MyTest(at,"线程甲").start();;
		new MyTest(at,"线程乙").start();;
	}

}

class Account
{
	private ThreadLocal<String> name = new ThreadLocal<>();
	
	public Account(String str)
	{
		this.name.set(str);
		System.out.println("----" + this.name.get());
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
}

class MyTest extends Thread
{
	private Account account;
	public MyTest(Account account,String name)
	{
		super(name);
		this.account = account;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 10 ; i++){
			//当i == 6时输出将账户名替换成当前线程名
			if(i == 6){
				account.setName(getName());
			}
			System.out.println(account.getName() + "账户的i值为: " + i);
		}
	}
}
