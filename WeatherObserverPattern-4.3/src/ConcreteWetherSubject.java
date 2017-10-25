import java.util.Observable;

//天气目标类的具体实现类
public class ConcreteWetherSubject extends Observable {

	//天气情况的内容
	private String content;

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//天气情况有了，就要通知所有观察者
		//注意在通知之前，在用Java中的Observer模式的时候，下面的这行代码必不可少
		this.setChanged();
		//然后主动通知，这里先用推模式的方式
		this.notifyObservers(content);
		//如果是拉模式，就调用无参的方法
//		this.notifyObservers();
	}
}
