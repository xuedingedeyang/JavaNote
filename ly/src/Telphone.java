//定义一个类
public class Telphone {
	//属性（成员变量）
	float screen;
	float CPU;
	float mem;
	int var;
	//方法
	void call(){
		int localVar = 3;
		System.out.println("var"+var);
		System.out.println("localVar"+localVar);
		System.out.println("Telphone 有打电话功能");
	}
	void sendMessage(){
		System.out.println("var"+var);
		System.out.println("screen:"+screen+"CPU:"+CPU+"mem"+mem+"Telphone 有发短信的功能");
	}
}
