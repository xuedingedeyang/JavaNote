import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "学习java编程";
		//输出字符串长度
		System.out.println("字符串长度"+str.length());
		
		char c = '编';
		//查找字符'编'的位置
		System.out.println(str.indexOf(c));
		//查找字符串'java'的位置
		System.out.println(str.indexOf("java"));
		//按空格拆分字符成数组，并输出数组
		String[] arr = str.split(" ");
		System.out.println("按空格拆分数组"+Arrays.toString(arr));
		System.out.println();
		//获取索引位置[4,7)之间的子串
		System.out.println(str.substring(3,7));
		}

}
