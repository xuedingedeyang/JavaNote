package classDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		ArrayList<String>list1 = new ArrayList<String>();
		list1.add("hello");
//		list1.add(10);错误的
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1==c2);
		//反射操作都是编译之后的操作
		
		/*
		 * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
		 * java中集合的泛型是防止错误输入的，只在编译阶段有效
		 * 绕过编译就无效了
		 * 验证：我们可以通过方法的反射操作绕过编译
		 */
		try {
			Method m = c2.getMethod("add",Object.class);
			m.invoke(list1, 20);//绕过了编译操作就绕过了泛型
			System.out.println(list1.size());
			System.out.println(list1);
			/*for (String string : list1) {
				System.out.println(string);
			}*///现在不能这样遍历
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
