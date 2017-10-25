import java.util.Observable;
import java.util.Observer;

//具体的观察者对象
public class ConcreteObserver implements Observer {

	//观察者名称
	private String observerName;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//第一种是推模式
		System.out.println(observerName+"收到了消息,目标推送过来的是"+arg1);
		//第二种拉模式
		System.out.println(observerName+"收到了消息，主动到目标对象中去拉，拉的内容是"
		+((ConcreteWetherSubject)arg0).getContent());
	}
	
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
}
