package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String Cno;
	private String Cname;
	private String Ctime;
	private String Ccredit;
	private String Cremarks;
	private List<Teacher>teachers = new ArrayList<>();
	
	
	
	public Course() {
		
	}
	public Course(String cno, String cname, String ctime, String credit) {
		this.Cno=cno;
		this.Cname = cname;
		this.Ctime = ctime;
		this.Ccredit = credit;
	}
	

	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCtime() {
		return Ctime;
	}
	public void setCtime(String ctime) {
		Ctime = ctime;
	}
	public String getCcredit() {
		return Ccredit;
	}
	public void setCcredit(String ccredit) {
		Ccredit = ccredit;
	}
	public String getCremarks() {
		return Cremarks;
	}
	public void setCremarks(String cremarks) {
		Cremarks = cremarks;
	}
	
	@Override
	public String toString() {
		return "Course [Cno=" + Cno + ", Cname=" + Cname + ", Ctime=" + Ctime + ", Ccredit=" + Ccredit + ", Cremarks="
				+ Cremarks + "]";
	}
	
	
}
