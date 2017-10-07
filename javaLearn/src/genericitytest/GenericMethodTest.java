package genericitytest;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<>();
		fromArrayToCollection(oa,co);
		InputStreamReader isr = new InputStreamReader(System.in);
		
		
		Integer[] ia = new Integer[100];
		Collection<Integer> ai = new ArrayList<>();
		fromArrayToCollection(ia,ai);
		
	}

	static <T>void fromArrayToCollection(T[] a,Collection<T> c){
		for(T o : a){
			c.add(o);
		}
	}
	
//	public static <T>void copy(Collection<T>dest,Collection<? extends T>src){
//		for(T ele : src){
//			dest.add(ele);
//		}
//	}
	
	public static <T> T copy(Collection<? super T> dest,Collection<T> src){
		T last = null;
		for(T ele : src){
			last = ele;
			dest.add(ele);
		}
		return last;
	}
}
