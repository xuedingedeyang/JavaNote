//����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ��״̬����һ��
public class ConcreteObserver implements Observer {
	//�۲���״̬
	private String observerState;

	@Override
	public void update(Subject subject) {
		//��ȡĿ�����״̬��ͬ�����۲��ߵ�״̬��
		observerState = ((ConcreteSubject)subject).getSubjectState();
	}
}
