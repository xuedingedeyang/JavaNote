
//����һ�����µĽӿڷ�������Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ĺ۲��߶������
public interface Observer {
	//���µĽӿ�
	public void update(WeatherSubject subject);

	//���ù۲�������
	public void setObserverName(String name);
	
	//ȡ�ù۲�������
	public String getObserverName();
}
