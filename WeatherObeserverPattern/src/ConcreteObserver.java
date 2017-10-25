
public class ConcreteObserver implements Observer {
	
	//�۲��ߵ�����
	private String observerName;
	
	//�������������
	private String weatherContent;
	
	//���ѵ�����
	private String remindThing;

	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
	}


	@Override
	public String getObserverName() {
		// TODO Auto-generated method stub
		return observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	
	

}
