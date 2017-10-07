package genericitytest;

public class Apple<T> {
	//使用T类型定义实参变量
	private T info;
	public Apple(T info){
		this.info = info;
	};
	
	public static void main(String[] args){
		Apple<String> a1 = new Apple<String>("苹果");
		Apple<Double> a2 = new Apple<Double>(2.5d);
	}

}
