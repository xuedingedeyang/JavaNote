
//�����Ŀ����󣬸�����й�״̬���뵽��Ӧ�Ĺ۲��߶�����
public class WeatherConcreteSubject extends WetherSubject {

	//��ȡ�������ݵ���Ϣ
		private String weatherContent;

		public String getWeatherContent() {
			return weatherContent;
		}

		public void setWeatherContent(String weatherContent) {
			this.weatherContent = weatherContent;
			//�������ˣ�˵�����������ˣ�֪ͨ���ж��ĵ���
			this.notifyObservers(weatherContent);
		}
}
