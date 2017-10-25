
public class ConcreteWeatherSubject extends WeatherSubject {

	//"����" "����" "��ѩ"
	//Ŀ������״̬
	private String weatherContent;
	
	@Override
	protected void notifyObservers() {
		//ѭ������ע��Ĺ۲���
		for(Observer observer:observers){
			//������:
			//С����Ů���� ��Ҫ�����ꡱ������֪ͨ��������֪ͨ����Ҫ
			//С����������Ҫ�����ꡱ�͡���ѩ��������֪ͨ,����������֪ͨ
			
			//��������죬ʲô������Ҫ֪ͨ
			
			//�������������
			if("����".equals(this.getWeatherContent())){
				if("С����Ů����".equals(observer.getObserverName())){
					observer.update(this);
				}
				if("С��������".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
			if("��ѩ".equals(this.getWeatherContent())){
				if("С��������".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
		}
	}
	public String getWeatherContent() {
		return weatherContent;
	}
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
	
	
}
