import java.util.ArrayList;
import java.util.List;

public abstract  class WeatherSubject {
	//��������ע��Ĺ۲��߶���
	public List<Observer>observers = new ArrayList<>();
	
	//attach detach  abstract noifyobservers
	//�Ѷ�������������ӵ��������б���
	public void attach(Observer observer){
		observers.add(observer);
	}
	//ɾ��������ָ��������������
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	protected abstract void notifyObservers();
}
