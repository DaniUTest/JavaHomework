package com.globant.qc.university;


public class Teacher {
	
	protected String name;
	protected double baseSalary;
	
	
	
	public Teacher() {
		this.name = new String();
		this.baseSalary = 0;
		
	}
	
	/**
	 * @param name
	 * @param baseSalary
	 */
	public Teacher(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	

	@Override
	public String toString() {
		return "Teacher [" + (name != null ? "Name = " + name + "	" : "") + "	Base Salary = " + baseSalary + "]\n";
	}
	
	
	

}
