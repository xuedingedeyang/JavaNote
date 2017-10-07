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
		System.out.println("请输入学生信息:");
		for(int i = 0 ; i < 5 ; i++){
			System.out.println("请输入学生姓名:");
			String name = sc.next();
			System.out.println("请输入语文成绩:");
			float chineseGrade = sc.nextFloat();
			System.out.println("请输入数学成绩:");
			float mathGrade = sc.nextFloat();
			System.out.println("请输入英语成绩:");
			float englishGrade = sc.nextFloat();
			stus[i] = new Student(name,chineseGrade,mathGrade,englishGrade);
		}
		sort(stus);
		save(stus);
		System.out.println("学生信息如下：\n\n\n");
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
			fw.write("          学生列表                   \n");
			for(Student stu:stus){
				fw.write("姓名:    " + stu.name + "\n");
				fw.write("语文成绩：" + stu.chineseGrade + "\n");
				fw.write("数学成绩:" + stu.mathGrade + "\n");
				fw.write("英语成绩：" + stu.englishGrade + "\n");
				fw.write("总成绩:" + stu.total + "\n");
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
