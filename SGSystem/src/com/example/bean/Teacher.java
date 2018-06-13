package com.example.bean;

public class Teacher {
	private String Tno;
	private String Tname;
	private String TSex;
	private String Tpassword;
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
