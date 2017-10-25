package collection_map_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/*
	 * ������װѧ�����Ͷ���
	 */
	public  Map<String ,Student>students;
	/*
	 * �ڹ������г�ʼ��students����
	 * 
	 */
	
	/*
	 * ������ӣ�����ѧ��ID���ж��Ƿ�ռ��
	 * ��δ��ռ�ã�������������������ѧ�����󣬲���
	 * ��ӵ�students��
	 */
	public void testPut(){
		//����һ����Scanner����������ȡ�����ѧ��ID������
		Scanner console = new Scanner(System.in);
		int i = 0;
		while(i<3){
			System.out.println("������ѧ��ID��");
			String ID = console.next();
			//�жϸ�ID�Ƿ�ռ��
			Student st =  students.get(ID);
			if(st==null){
				//��ʾ����ѧ������
				System.out.println("������ѧ��������");
				String name  =console.next();
				//�����µ�ѧ������
				Student newStudent = new Student(ID,name);
				//ͨ������students��put���������ID-ѧ��ӳ��
				students.put(ID, newStudent);
				System.out.println("�ɹ����ѧ����"+students.get(ID).name);
				i++;
			}else{
				System.out.println("��ѧ��ID�ѱ�ռ�ã�");
				continue;
			}
			
		}
	}
	/*
	 * ����Map��KeySet����
	 * 
	 */
	public void testKeySet(){
		//ͨ��KeySet����������Map�е����С�������Set����
		Set<String>keySet = students.keySet();
		//ȡ��students������
		System.out.println("�ܹ��У�"+students.size()+"��ѧ��");
		//����KeySet��ȡ��ÿһ�������ٵ���get����ȡ��ÿһ������Ӧ��value
		for(String stuID:keySet){
			Student st = students.get(stuID);
			if(st!=null)
				System.out.println("ѧ����"+st.name);
		}
	}
	/*
	 * ����ɾ��Map�е�ӳ��
	 */
	public void testRemove(){
		//��ʾ�û������ɾ����ѧ��ID
		//System.out.println("������Ҫɾ��ѧ����ID");
		//��ȡ�Ӽ�������Ĵ�ɾ��ѧ��ID�ַ���
		Scanner	console = new Scanner(System.in);
		while(true){
		//��ʾ�û������ɾ����ѧ��ID
		System.out.println("������Ҫɾ��ѧ����ID");
		String ID = console.next();
		//�жϸ�ID�Ƿ��ж�Ӧѧ������
		Student st = students.get(ID);
		if(st==null){
			//��ʾ�����ID������
			System.out.println("��ID������");
			continue;
		}
		students.remove(ID);
		System.out.println("�ɹ�ɾ��ѧ����"+st.name);
		break;
	}
	
}
	
	/*
	 * ͨ��entrySet����������Map
	 * 
	 */
	public void testEntrySet(){
		//ͨ��entrySet����������Map�����м�ֵ��
		Set<Entry<String,Student>>entrySet = students.entrySet();
		for(Entry<String,Student>entry:entrySet){
			System.out.println("ȡ�ü���"+entry.getKey());
			System.out.println("��Ӧ��ֵΪ"+entry.getValue().name);
		}
	}
	public MapTest(){
		this.students = new HashMap<String,Student>();
	}
	/*
	 * 
	 * ����put�����޸�Map�����е�ӳ��
	 */
	public 	void testModify(){
		//��ʾ����Ҫ�޸ĵ�ѧ��ID
		System.out.println("������Ҫ�޸ĵ�ѧ��ID��");
		//����һ��Scanner����ȥ��ȡ�Ӽ��������ѧ��ID
		Scanner console = new Scanner(System.in);
		while(true){
			//��ȡ�Ӽ��������ѧ��ID
			String stuID = console.next();
			//��students�в��Ҹ�ѧ��ID��Ӧ��ѧ������
			Student student = students.get(stuID);
			if(student == null){
				System.out.println("��ID�����ڣ�����������");
				continue;
			}
			//��ʾ��ǰ��Ӧ��ѧ�����������
			System.out.println("��ǰ��ѧ��ID����Ӧ��ѧ��Ϊ��"+student.name);
			//��ʾ�����µ�ѧ�����������޸����е�ӳ��
			System.out.println("�������µ�ѧ��������");
			String name = console.next();
			Student newStudent = new Student(stuID,name);
			students.put(stuID, newStudent);
			System.out.println("�޸ĳɹ���");
			break;
		}
		
	}
	
	/*
	 * ����Map���Ƿ����ĳ��Keyֵ����ĳ��Valueֵ
	 */
	 public void testContainsKeyOrValue(){
		 //��ʾ����ѧ��ID
		 System.out.println("������Ҫ��ѯ��ѧ��ID��");
		 Scanner console = new Scanner(System.in);
		 String id = console.next();
		 //��Map�У���containsKey()���������ж��Ƿ����ĳ��Keyֵ
		 System.out.println("�������ѧ��Ϊ��"+id+",��ѧ��ӳ������Ƿ���ڣ�"+students.containsKey(id));
		 if(students.containsKey(id))
			 System.out.println("��Ӧ��ѧ��Ϊ��"+students.get(id).name);
		 //��ʾ����ѧ������
		 System.out.println("������Ҫ��ѯѧ��������");
		 String name  = console.next();
		 //��containsValue()�������ж��Ƿ����ĳ��Valueֵ
		 if(students.containsValue(new Student(null,name)))
			 System.out.println("��ѧ��ӳ����а���ѧ����"+name);
		 else
			 System.out.println("�����ڴ�ѧ��");
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
//		mt.testRemove();
//		mt.testEntrySet();
//		mt.testModify();
//		mt.testEntrySet();
		mt.testContainsKeyOrValue();
	}

}
