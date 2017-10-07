package yang.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
	
	
	public void cutString(String str1,String str2){
		int x1 = 0,x2 = 0;
		int length = str1.length();
		int length2 = str2.length();
		while(true){
			if(x2 >= length || x1 >= length){
				break;
			}
			x1 = str1.indexOf(str2,x1);
			System.out.println(str1.substring(x2, x1)+"\n");
			x1+=length2;
			x2 = x1;
		}
	}
	public void cutString2(String str1,String str2){
		Matcher m = Pattern.compile(str2).matcher(str1);
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str1 = "helloTaghelloWorldTagAndroidTagAndroidLabTag";
//		String str2 = "Tag";
//		StringTest stringTest = new StringTest();
////		stringTest.cutString2(str1, str2);
//		String s1 = "Java";
//		String s2 = "Java";
//		String s3 = new String("Java");
//		String s4 = "JavaJava";
//		String s5 = s1 + s2;
//		String s6 = s3.intern();
//		System.out.println(s1 == s2);
//		System.out.println(s3 == s2);
//		System.out.println(s4 == s5);
//		System.out.println(s6 == s3);
//		System.out.println(s6 == s1);
		A a = new A();
		a.a = 10;
		a.b = 12; 
		StringTest test = new StringTest();
		test.swap(a);
		System.out.println("a.a = " + a.a + "," + "a.b = " + a.b);
	}
	
	public void swap(A a){
		int temp = a.a;
		a.a = a.b;
		a.b = temp;
	}

}

class A{
	int a;
	int b;
}
