import java.util.ArrayList;
import java.util.List;


//Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
public class Subject {
	//��������ע��Ĺ۲��߶���
	private List<Observer>observers = new ArrayList<>();
	
	//attach detach notifyObservers
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public void detachOberver(Observer observer){
		observers.remove(observer);
	}
	
	//֪ͨ����ע��Ĺ۲��߶���
	protected void notifyObservers(){
		for (Observer observer:observers){
			observer.update(this);
		}
	}
}
