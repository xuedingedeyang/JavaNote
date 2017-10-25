
public class Client {

	public static void main(String[] args) {
		//1.创建一个目标
		WeatherConcreteSubject weather = new WeatherConcreteSubject();
		//2.创建观察者
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("小明的女朋友");
		observerGirl.setRemindThing("是我们的第一次约会,地点在老地方，不见不散");
		
		ConcreteObserver observerMum = new ConcreteObserver();
		observerMum.setObserverName("老妈");
		observerMum.setRemindThing("是一个购物的好日子，去购物");
		
		//3，注册观察者
		weather.attach(observerGirl);
		weather.attach(observerMum);
		
		//4.目标发布天气
		weather.setWeatherContent("明天，天气晴朗，蓝天白云，气温23度");
	}

}
