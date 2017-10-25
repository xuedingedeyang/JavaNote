import java.util.ArrayList;
import java.util.List;


//Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
public class WetherSubject {
	//��������ע��Ĺ۲��߶���
	private List<Observer>observers = new ArrayList<>();
	
	//attach detach notifyObservers
	//�Ѷ�������������ӵ������б���
	public void attach(Observer observer){
		observers.add(observer);
	}
	//ɾ��������ָ��������ӵ���
	public void detachOberver(Observer observer){
		observers.remove(observer);
	}
	
	//֪ͨ�����Ѿ����Ķ���������
	protected void notifyObservers(String content){
		for (Observer observer:observers){
			observer.update(content);
		}
	}
}
