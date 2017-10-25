import java.util.ArrayList;
import java.util.List;


//目标对象，他知道观察他的观察者，并提供注册（添加）和删除观察者的接口
public class WetherSubject {
	//用来保存注册的观察者对象
	private List<Observer>observers = new ArrayList<>();
	
	//attach detach notifyObservers
	//把订阅天气的人添加到订阅列表中
	public void attach(Observer observer){
		observers.add(observer);
	}
	//删除集合中指定订阅添加的人
	public void detachOberver(Observer observer){
		observers.remove(observer);
	}
	
	//通知所有已经订阅额天气的人
	protected void notifyObservers(String content){
		for (Observer observer:observers){
			observer.update(content);
		}
	}
}
