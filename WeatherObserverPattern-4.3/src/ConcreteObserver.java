import java.util.Observable;
import java.util.Observer;

//����Ĺ۲��߶���
public class ConcreteObserver implements Observer {

	//�۲�������
	private String observerName;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//��һ������ģʽ
		System.out.println(observerName+"�յ�����Ϣ,Ŀ�����͹�������"+arg1);
		//�ڶ�����ģʽ
		System.out.println(observerName+"�յ�����Ϣ��������Ŀ�������ȥ��������������"
		+((ConcreteWetherSubject)arg0).getContent());
	}
	
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
}
