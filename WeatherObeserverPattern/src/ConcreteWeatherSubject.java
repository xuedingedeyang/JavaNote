
public class ConcreteWeatherSubject extends WeatherSubject {

	//"晴天" "下雨" "下雪"
	//目标对象的状态
	private String weatherContent;
	
	@Override
	protected void notifyObservers() {
		//循环所有注册的观察者
		for(Observer observer:observers){
			//规则是:
			//小明的女朋友 需要“下雨”条件的通知，其他的通知不需要
			//小明的老妈需要“下雨”和“下雪”条件的通知,其他条件的通知
			
			//如果是晴天，什么都不需要通知
			
			//如果天气是下雨
			if("下雨".equals(this.getWeatherContent())){
				if("小明的女朋友".equals(observer.getObserverName())){
					observer.update(this);
				}
				if("小明的老妈".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
			if("下雪".equals(this.getWeatherContent())){
				if("小明的老妈".equals(observer.getObserverName())){
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
