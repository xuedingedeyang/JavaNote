//具体的观察者对象，实现更新的方法，使自身的状态和目标状态保持一致
public class ConcreteObserver implements Observer {
	//观察者的名字,是谁收到了这个讯息
	private String observerName;

	//天气内容的情况，这个消息从目标处获取
	private String wetherContent;
	
	//提醒的内容,不同的观察者提醒不同的内容
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
	
	//获取目标类的状态，同步到观察者的状态中
	@Override
	public void update(String content) {
//		wetherContent = ((WeatherConcreteSubject)subject).getWeatherContent();
		wetherContent = content;
		System.out.println("observerName"+"收到了"+wetherContent+","+remindThing);
	}
}
