package com.example.bean;

public class STGrade {
	private String courseName;
	private String teacherName;
	private Float grade;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Float getGrade() {
		return grade;
	}
	public void setGrade(Float grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "STGrade [courseName=" + courseName + ", teacherName=" + teacherName + ", grade=" + grade + "]";
	}
	
	
}
