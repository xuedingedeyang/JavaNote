
public class Client {

	public static void main(String[] args) {
		//1.����һ��Ŀ��
		WeatherConcreteSubject weather = new WeatherConcreteSubject();
		//2.�����۲���
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("С����Ů����");
		observerGirl.setRemindThing("�����ǵĵ�һ��Լ��,�ص����ϵط���������ɢ");
		
		ConcreteObserver observerMum = new ConcreteObserver();
		observerMum.setObserverName("����");
		observerMum.setRemindThing("��һ������ĺ����ӣ�ȥ����");
		
		//3��ע��۲���
		weather.attach(observerGirl);
		weather.attach(observerMum);
		
		//4.Ŀ�귢������
		weather.setWeatherContent("���죬�������ʣ�������ƣ�����23��");
	}

}
