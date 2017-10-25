package Day04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Launcher {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class clazz = Person.class;
		Method m = clazz.getMethod("setName", String.class);
	}
}