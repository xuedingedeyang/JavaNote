package day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m2();
	}
	
	//Array.list添加和删除操作
	private static void m1(){
//		ArrayList list = new ArrayList();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("e");
//		list.add("d");
//		for循环遍历数组
//		System.out.println(list);
//		for(int i = 0;i<list.size();i++){
//			if("b".equals(list.get(i))){
//				list.remove(i);
//			}
//		
//		}
//			System.out.println(list);
//			
//			Iterator ite = new Iterator();
//				System.out.println(ite.next());
			
//		//根据索引删除
//		list.remove(0);
//		System.out.println(list);
//		//根据内容删除
//		list.remove("b");
//		System.out.println(list);
//		//修改指定位置元素
//		list.set(2, "r");
//		System.out.println(list);
//		
		
//		Iterator ite = list.iterater(){
//			
//	}

			
		
	}
	public static void m2(){
		HashMap map = new HashMap();
		map.put("a","苹果");
		map.put("b","葡萄");
		map.put("c", "西瓜");
		Set set = map.entrySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			Map.Entry entry = (Entry) ite.next();
			String key = (String)entry.getKey();
			if("b".equals(key)){
				entry.setValue("红葡萄酒");
			}
		}
		System.out.println(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
