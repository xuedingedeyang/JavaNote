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
	
	//Array.list��Ӻ�ɾ������
	private static void m1(){
//		ArrayList list = new ArrayList();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("e");
//		list.add("d");
//		forѭ����������
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
			
//		//��������ɾ��
//		list.remove(0);
//		System.out.println(list);
//		//��������ɾ��
//		list.remove("b");
//		System.out.println(list);
//		//�޸�ָ��λ��Ԫ��
//		list.set(2, "r");
//		System.out.println(list);
//		
		
//		Iterator ite = list.iterater(){
//			
//	}

			
		
	}
	public static void m2(){
		HashMap map = new HashMap();
		map.put("a","ƻ��");
		map.put("b","����");
		map.put("c", "����");
		Set set = map.entrySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()){
			Map.Entry entry = (Entry) ite.next();
			String key = (String)entry.getKey();
			if("b".equals(key)){
				entry.setValue("�����Ѿ�");
			}
		}
		System.out.println(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
