//����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ��״̬����һ��
public class ConcreteObserver implements Observer {
	//�۲��ߵ�����,��˭�յ������ѶϢ
	private String observerName;

	//�������ݵ�����������Ϣ��Ŀ�괦��ȡ
	private String wetherContent;
	
	//���ѵ�����,��ͬ�Ĺ۲������Ѳ�ͬ������
	private String remindThing;
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	public String getWetherContent() {
		return wetherContent;
	}
	public void setWetherContent(String wetherContent) {
		this.wetherContent = wetherContent;
	}
	public String getRemindThing() {
		return remindThing;
	}
	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
	
	//��ȡĿ�����״̬��ͬ�����۲��ߵ�״̬��
	@Override
	public void update(String content) {
//		wetherContent = ((WeatherConcreteSubject)subject).getWeatherContent();
		wetherContent = content;
		System.out.println("observerName"+"�յ���"+wetherContent+","+remindThing);
	}
}
