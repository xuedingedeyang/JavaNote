package genericitytest;

public class Apple<T> {
	//ʹ��T���Ͷ���ʵ�α���
	private T info;
	public Apple(T info){
		this.info = info;
	};
	
	public static void main(String[] args){
		Apple<String> a1 = new Apple<String>("ƻ��");
		Apple<Double> a2 = new Apple<Double>(2.5d);
	}

}
