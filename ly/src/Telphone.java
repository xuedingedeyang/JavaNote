//����һ����
public class Telphone {
	//���ԣ���Ա������
	float screen;
	float CPU;
	float mem;
	int var;
	//����
	void call(){
		int localVar = 3;
		System.out.println("var"+var);
		System.out.println("localVar"+localVar);
		System.out.println("Telphone �д�绰����");
	}
	void sendMessage(){
		System.out.println("var"+var);
		System.out.println("screen:"+screen+"CPU:"+CPU+"mem"+mem+"Telphone �з����ŵĹ���");
	}
}
