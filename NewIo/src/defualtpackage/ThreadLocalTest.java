package defualtpackage;

public class ThreadLocalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account at = new Account("����");
		//��Ȼ�����̹߳���ͬһ���˻�����ֻ��һ���˻������������˻�����ThreadLocal���͵ģ�����ÿ���̶߳���ȫӵ�и����˻��ĸ���
		//�������i==6�󣬽����������̷߳���ͬһ���˻�ʱ���ֲ�ͬ���ֵ����
		new MyTest(at,"�̼߳�").start();;
		new MyTest(at,"�߳���").start();;
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
			//��i == 6ʱ������˻����滻�ɵ�ǰ�߳���
			if(i == 6){
				account.setName(getName());
			}
			System.out.println(account.getName() + "�˻���iֵΪ: " + i);
		}
	}
}
