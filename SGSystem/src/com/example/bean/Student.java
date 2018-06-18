package com.example.bean;

public class Student {
	private String Sno;
	private String Sname;
	private String Ssex;;
	private String Sage;
	private String Stel;
	private String Spassword;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String sno, String sname, String ssex, String sage, String stel, String spassword) {
		super();
		this.Sno = sno;
		this.Sname = sname;
		this.Ssex = ssex;
		this.Sage = sage;
		this.Stel = stel;
		this.Spassword = spassword;
	}


	public Student(String sno, String sname, String ssex, String sage, String sdept) {
		this.Sno = sno;
		this.Sname = sname;
		this.Ssex = ssex;
		this.Sage = sage;
		this.Stel = sdept;
	}



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
