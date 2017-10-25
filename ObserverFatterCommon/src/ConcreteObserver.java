//具体的观察者对象，实现更新的方法，使自身的状态和目标状态保持一致
public class ConcreteObserver implements Observer {
	//观察者状态
	private String observerState;

	@Override
	public void update(Subject subject) {
		//获取目标类的状态，同步到观察者的状态中
		observerState = ((ConcreteSubject)subject).getSubjectState();
	}
}
