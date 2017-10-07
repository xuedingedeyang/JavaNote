package regularexpressiontest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʹ���ַ���ģ��������ϵĵ�����ҳԴ��
		String str = "����Ũ�Ƴ����磬18406587309��"
				+ "���������ޣ�12345674567"
				+ "�ѽ�������������ɴ������ҹ����͸��13453356578��"
				+ "����Ѿƻƻ���а���ӯ�䡣Ī�������꣬�������磬�˱Ȼƻ��ݡ�12824850542";
		String str2 = "";
		Matcher m = Pattern.compile("((18\\d)|(12\\d)|(13\\d))\\d{8}").matcher(str);
		Matcher m2 = Pattern.compile("\\w{3,20}@\\w+\\.(com.org|cn|net|gov)").matcher(str);
		while(m.find()){
			System.out.println(m.group());
		}
	}

}
