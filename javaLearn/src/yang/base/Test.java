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
//		//��������һ�н�ֻ�ѻس���Ϊ�ָ���
//		sc.useDelimiter("\n");
//		while(sc.hasNext()){
//			System.out.println("��������������ǣ�"+sc.next());
//		}
		
		
//		Runtime rt = Runtime.getRuntime();
//		rt.exec("notepad.exe");
		
		
//		Calendar c = Calendar.getInstance();
//		System.out.println(c.get(0));
		
//		String str = "������һ����android��������̽�������뾡����ϵ��13406587300"
//				+"��������15389076543"
//				+"���۶��ֵ��ԣ���ϰ��ʽ14890837864";
		//����һ��pattern���󣬲���������һ��matcher����
		//ץȡ13x��15x�ε��ֻ�����
//		Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
		//ץȡ�����ֻ���
//		Matcher m = Pattern.compile("\\d{11}").matcher(str);
//		while(m.find()){
//			System.out.println(m.group());
//		}
		
//		Date date = new Date();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyy���е�d��");
//		String dateStr = sdf1.format(date);
//		System.out.println(dateStr);
//		String str = "14###����##21";
//		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
//		System.out.println(sdf2.parse(str));

//		Collection books = new HashSet();
//		books.add("��ľͫ");
//		books.add("������");
//		books.add("�ӳ���");
//		books.add("������");
//		books.forEach(obj -> System.out.println(obj));
//		books.removeIf(ele -> ((String)ele).contains("��"));
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
