package yang.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
	
	String name;
	float chineseGrade;
	float mathGrade;
	float englishGrade;
	float total;
	
	public Student(String name,float chinese,float math,float english){
		this.name = name;
		this.chineseGrade = chinese;
		this.mathGrade = math;
		this.englishGrade = english;
		this.total = chinese+math+english;
	}
	
	public static void main(String[] args){
		Student[] stus = new Student[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("������ѧ����Ϣ:");
		for(int i = 0 ; i < 5 ; i++){
			System.out.println("������ѧ������:");
			String name = sc.next();
			System.out.println("���������ĳɼ�:");
			float chineseGrade = sc.nextFloat();
			System.out.println("��������ѧ�ɼ�:");
			float mathGrade = sc.nextFloat();
			System.out.println("������Ӣ��ɼ�:");
			float englishGrade = sc.nextFloat();
			stus[i] = new Student(name,chineseGrade,mathGrade,englishGrade);
		}
		sort(stus);
		save(stus);
		System.out.println("ѧ����Ϣ���£�\n\n\n");
		showTable();
	}
	
	public static void sort(Student[] stus){
		for(int i = 0 ; i < stus.length ; i++){
			for(int j = i+1 ; j < stus.length ; j++){
				if(stus[j].total > stus[i].total){
					Student temp = stus[i];
					stus[i] = stus[j];
					stus[j] = temp;
				}
			}
		}
	}
	
	public static void save(Student[] stus){
		FileWriter fw;
		try {
			fw = new FileWriter("pome.txt");
			fw.write("          ѧ���б�                   \n");
			for(Student stu:stus){
				fw.write("����:    " + stu.name + "\n");
				fw.write("���ĳɼ���" + stu.chineseGrade + "\n");
				fw.write("��ѧ�ɼ�:" + stu.mathGrade + "\n");
				fw.write("Ӣ��ɼ���" + stu.englishGrade + "\n");
				fw.write("�ܳɼ�:" + stu.total + "\n");
				fw.write("\n\n\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showTable(){
		FileInputStream in;
		try {
			in = new FileInputStream("pome.txt");
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while((hasRead = in.read(buf)) > 0){
				System.out.println(new String(buf,0,hasRead));
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
