package com.globant.qc.university;

public class PartTimeTeacher extends Teacher {

	private int hoursPerWeek;
	private double fullSalary;
	
	
	public PartTimeTeacher() {
		super();
		this.fullSalary = 0;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PartTimeTeacher(String name, double baseSalary) {
		super(name, baseSalary);
		this.fullSalary = this.baseSalary;
		
	}


	/**
	 * @param name
	 * @param baseSalary
	 * @param hoursPerWeek
	 */
	public PartTimeTeacher(String name, double baseSalary, int hoursPerWeek) {
		super(name, baseSalary);
		this.hoursPerWeek = hoursPerWeek;
		this.fullSalary = this.baseSalary*this.hoursPerWeek;
	}


	public int getHoursPerWeek() {
		return hoursPerWeek;
	}


	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}


	public double getFullSalary() {
		return fullSalary;
	}


	public void setFullSalary(double fullSalary) {
		this.fullSalary = fullSalary;
	}



	@Override
	public String toString() {
		return "PartTimeTeacher [Hours per Week = " + hoursPerWeek + "	Full Salary = " + fullSalary + "	Name = " + name
				+ "	Base Salary = " + baseSalary + "]\n";
	}




	

	



}
