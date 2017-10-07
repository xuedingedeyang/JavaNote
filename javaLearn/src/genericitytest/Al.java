package genericitytest;

/**
 * 当创建了带泛型声明的接口，父类后，可以为该接口创建实现类，或从该父类派生子类，但当使用这些接口、父类时不能再包含类型实参
 * 例如下面代码是错的:
 * public class A extends Apple<T>{}
 * @author yang
 *
 */
public class Al extends Apple<String> {

	public Al(String info) {
		super(info);
		// TODO Auto-generated constructor stub
	}
	
}
