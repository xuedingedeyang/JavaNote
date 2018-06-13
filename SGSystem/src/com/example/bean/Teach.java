package com.example.bean;

public class Teach {
	private String Tno;
	private String Cno;
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	@Override
	public String toString() {
		return "Teach [Tno=" + Tno + ", Cno=" + Cno + "]";
	}
	
	
}
