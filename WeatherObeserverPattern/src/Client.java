
public class Client {

	
	public static void main(String[] args) {
		//1.����Ŀ��
		ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();
		
		//2�������۲���
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("С����Ů����");
		observerGirl.setRemindThing("�����ˣ��������ڼ�");
		
		ConcreteObserver observerMum = new ConcreteObserver();
		observerMum.setObserverName("С��������");
		observerMum.setRemindThing("����������ѩ���Ҷ���������");
		
		//3.ע��۲���
		weatherSubject.attach(observerGirl);
		weatherSubject.attach(observerMum);
		
		//4.Ŀ�귢������
		weatherSubject.setWeatherContent("��ѩ");
	}

}
