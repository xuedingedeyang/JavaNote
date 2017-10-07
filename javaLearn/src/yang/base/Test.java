package yang.base;

import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DateFormatter;

public class Test {

	public static void main(String[] args) throws Exception{
//		Scanner sc = new Scanner(System.in);
//		//增加下面一行将只把回车作为分隔符
//		sc.useDelimiter("\n");
//		while(sc.hasNext()){
//			System.out.println("键盘输入的内容是："+sc.next());
//		}
		
		
//		Runtime rt = Runtime.getRuntime();
//		rt.exec("notepad.exe");
		
		
//		Calendar c = Calendar.getInstance();
//		System.out.println(c.get(0));
		
//		String str = "我想买一本《android开发艺术探索》，请尽快联系我13406587300"
//				+"交朋友吗15389076543"
//				+"出售二手电脑，练习方式14890837864";
		//创建一个pattern对象，并用它建立一个matcher对象
		//抓取13x和15x段的手机号码
//		Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
		//抓取所有手机号
//		Matcher m = Pattern.compile("\\d{11}").matcher(str);
//		while(m.find()){
//			System.out.println(m.group());
//		}
		
//		Date date = new Date();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyy年中的d天");
//		String dateStr = sdf1.format(date);
//		System.out.println(dateStr);
//		String str = "14###三月##21";
//		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
//		System.out.println(sdf2.parse(str));

//		Collection books = new HashSet();
//		books.add("黑木瞳");
//		books.add("王祖贤");
//		books.add("钟楚红");
//		books.add("张曼玉");
//		books.forEach(obj -> System.out.println(obj));
//		books.removeIf(ele -> ((String)ele).contains("黑"));
//		books.forEach(obj -> System.out.println(obj));
//		WeakHashMap map = new WeakHashMap();
		
		List<Test2>list = new ArrayList<>();
		list.add(new Test2());
		list.add(new Test2());
		list.add(new Test2());
		add(list);
		
		
	}

	public static void add(List<? extends Test2> list){
		list.forEach(obj -> obj.foo());
	}
	
	
}
