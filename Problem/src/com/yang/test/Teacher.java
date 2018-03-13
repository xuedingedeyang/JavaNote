package com.yang.test;

public class Teacher extends Person {
	private String duty;
	private String section;
	
	public void print()
	{
		super.print();
		System.out.println("职务:" + duty);
		System.out.println("部门:"+section);
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
}
