
public class Client {

	//测试类
	public static void main(String[] args) {
		//创建一个天气作为目标，也可以说是被观察者
		ConcreteWetherSubject subject = new ConcreteWetherSubject();
		//创建小明的女朋友作为观察者
		ConcreteObserver girl = new ConcreteObserver();
		girl.setObserverName("小明的女朋友");
		//创建小明的老妈作为观察者
		ConcreteObserver mum = new ConcreteObserver();
		mum.setObserverName("小明的老妈");
		
		//注册观察者
		subject.addObserver(girl);
		subject.addObserver(mum);
		
		//目标更新天气情况
		subject.setContent("天气晴，气温23度");
	}

}
