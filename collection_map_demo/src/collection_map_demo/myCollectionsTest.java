package collection_map_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class myCollectionsTest {
	//������ɳ��Ȳ����ַ���
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
			System.out.println("------����ǰ---------");
			for(String string:stringList){
				System.out.println("Ԫ�أ�"+string);
			}
			Collections.sort(stringList);
			System.out.println("------�����-------------");
			for(String string:stringList){
				System.out.println("Ԫ�أ�"+string);
			}
			
		}
       //���س��Ȳ����ַ���
	private String testString(Integer count) {
		// TODO Auto-generated method stub
		String str = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		//����StringBuffer�ഴ���ɱ��ַ�����ע��String���ַ������в��ɱ���
		StringBuffer sb = new StringBuffer();
		//��ȡstr�ĳ���
		int length = str.length();
		Random random = new Random();
		for(int i = 0;i < count;i++){
			//�����������λ��
			int num = random.nextInt(length);
			//����charAt()������ȡ����Ϊnum�µ��ַ���������append()����������λ�õ��ַ�׷�ӵ�sb���棬
			sb.append(str.charAt(num));
		}
		//��toString()����ת��ΪString����
		String temp =sb.toString();
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myCollectionsTest cr = new myCollectionsTest();
		cr.testSort();
	}

}
