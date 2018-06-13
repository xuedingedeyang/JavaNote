package com.example.bean;

public class Student {
	private String Sno;
	private String Sname;
	private String Ssex;;
	private String Sage;
	private String Stel;
	private String Spassword;
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public String getSage() {
		return Sage;
	}
	public void setSage(String sage) {
		Sage = sage;
	}
	public String getStel() {
		return Stel;
	}
	public void setStel(String stel) {
		Stel = stel;
	}
	public String getSpassword() {
		return Spassword;
	}
	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
	
	@Override
	public String toString() {
		return "Student [Sno=" + Sno + ", Sname=" + Sname + ", Ssex=" + Ssex + ", Sage=" + Sage + ", Stel=" + Stel
				+ ", Spassword=" + Spassword + "]";
	}
	
	
}
