
public class Client {

	//������
	public static void main(String[] args) {
		//����һ��������ΪĿ�꣬Ҳ����˵�Ǳ��۲���
		ConcreteWetherSubject subject = new ConcreteWetherSubject();
		//����С����Ů������Ϊ�۲���
		ConcreteObserver girl = new ConcreteObserver();
		girl.setObserverName("С����Ů����");
		//����С����������Ϊ�۲���
		ConcreteObserver mum = new ConcreteObserver();
		mum.setObserverName("С��������");
		
		//ע��۲���
		subject.addObserver(girl);
		subject.addObserver(mum);
		
		//Ŀ������������
		subject.setContent("�����磬����23��");
	}

}
