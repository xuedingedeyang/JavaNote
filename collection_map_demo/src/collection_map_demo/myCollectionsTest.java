package collection_map_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class myCollectionsTest {
	//随机生成长度不等字符串
	public void testSort(){
		List<String>stringList = new ArrayList<String>(); 
		Random random = new Random();
		String array = new String();
		Integer k;
			for(int i = 0;i < 10;i++){
				do{
					k = random.nextInt(10);
				}while(k == 0);
				String temp = testString(k);
				stringList.add(temp);
			}
			System.out.println("------排序前---------");
			for(String string:stringList){
				System.out.println("元素："+string);
			}
			Collections.sort(stringList);
			System.out.println("------排序后-------------");
			for(String string:stringList){
				System.out.println("元素："+string);
			}
			
		}
       //返回长度不等字符串
	private String testString(Integer count) {
		// TODO Auto-generated method stub
		String str = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//利用StringBuffer类创建可变字符串，注意String类字符串具有不可变性
		StringBuffer sb = new StringBuffer();
		//获取str的长度
		int length = str.length();
		Random random = new Random();
		for(int i = 0;i < count;i++){
			//随机生成索引位置
			int num = random.nextInt(length);
			//利用charAt()方法获取索引为num下的字符，并利用append()方法将索引位置的字符追加到sb后面，
			sb.append(str.charAt(num));
		}
		//用toString()方法转换为String对象
		String temp =sb.toString();
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myCollectionsTest cr = new myCollectionsTest();
		cr.testSort();
	}

}
