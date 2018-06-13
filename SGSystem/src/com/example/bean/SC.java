package com.example.bean;

public class SC {
	private String Sno;
	private String Cno;
	private Float Grade;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public Float getGrade() {
		return Grade;
	}
	public void setGrade(Float grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "SC [Sno=" + Sno + ", Cno=" + Cno + ", Grade=" + Grade + "]";
	}
	
	
}
