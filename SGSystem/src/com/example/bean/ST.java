package com.example.bean;

public class ST {
	private String sno;
	private String tno;
	private Float grade;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public Float getGrade() {
		return grade;
	}
	public void setGrade(Float grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "ST [sno=" + sno + ", tno=" + tno + ", grade=" + grade + "]";
	}
	
	
}
