package com.example.bean;

import java.util.List;

public class Teacher {
	private String Tno;
	private String Tname;
	private String TSex;
	private String Tpassword;
	private Course course;
	
	
	
	
	public Teacher() {
		
	}
	
	
	public Teacher(String tno, String tname, String tSex, String tpassword, String tcno) {
		super();
		this.Tno = tno;
		this.Tname = tname;
		this.TSex = tSex;
		this.Tpassword = tpassword;
		this.course = new Course();
		this.course.setCno(tcno);
	}


	


	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTSex() {
		return TSex;
	}
	public void setTSex(String tSex) {
		TSex = tSex;
	}
	public String getTpassword() {
		return Tpassword;
	}
	public void setTpassword(String tpassword) {
		Tpassword = tpassword;
	}
	
	@Override
	public String toString() {
		return "Teacher [Tno=" + Tno + ", Tname=" + Tname + ", TSex=" + TSex + ", Tpassword=" + Tpassword + "]";
	}
	
	
}
