import java.util.Observable;

//����Ŀ����ľ���ʵ����
public class ConcreteWetherSubject extends Observable {

	//�������������
	private String content;

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//����������ˣ���Ҫ֪ͨ���й۲���
		//ע����֪֮ͨǰ������Java�е�Observerģʽ��ʱ����������д���ز�����
		this.setChanged();
		//Ȼ������֪ͨ������������ģʽ�ķ�ʽ
		this.notifyObservers(content);
		//�������ģʽ���͵����޲εķ���
//		this.notifyObservers();
	}
}
