package regularexpressiontest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用字符串模拟从网络上的到的网页源码
		String str = "薄雾浓云愁永昼，18406587309，"
				+ "瑞脑消金兽，12345674567"
				+ "佳节又重阳，玉枕纱橱，半夜凉初透。13453356578。"
				+ "东篱把酒黄昏后，有暗香盈袖。莫道不消魂，帘卷西风，人比黄花瘦。12824850542";
		String str2 = "";
		Matcher m = Pattern.compile("((18\\d)|(12\\d)|(13\\d))\\d{8}").matcher(str);
		Matcher m2 = Pattern.compile("\\w{3,20}@\\w+\\.(com.org|cn|net|gov)").matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}

}
