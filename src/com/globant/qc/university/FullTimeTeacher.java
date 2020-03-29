package com.globant.qc.university;

public class FullTimeTeacher extends Teacher {

	private int yearsOfExperience;
	private static double salaryMultiplier = 110;
	private double fullSalary;
	
	
	public FullTimeTeacher() {
		super();
		this.fullSalary = 0;
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param name
	 * @param baseSalary
	 */
	public FullTimeTeacher(String name, double baseSalary) {
		super(name, baseSalary);
		this.fullSalary = this.baseSalary;
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param name
	 * @param baseSalary
	 * @param yearsOfExperience
	 */
	public FullTimeTeacher(String name, double baseSalary, int yearsOfExperience) {
		super(name, baseSalary);
		this.yearsOfExperience = yearsOfExperience;
		this.fullSalary = this.baseSalary*this.salaryMultiplier*this.yearsOfExperience/100;
	}

	

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}


	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}


	public static double getSalaryMultiplier() {
		return salaryMultiplier;
	}


	public static void setSalaryMultiplier(double salaryMultiplier) {
		FullTimeTeacher.salaryMultiplier = salaryMultiplier;
	}


	public double getFullSalary() {
		return fullSalary;
	}


	public void setFullSalary(double fullSalary) {
		this.fullSalary = fullSalary;
	}


	@Override
	public String toString() {
		return "FullTimeTeacher [Years of Exp. = " + yearsOfExperience + "	Full Salary = " + fullSalary + "	Name = "
				+ name + "	Base Salary = " + baseSalary + "]\n";
	}


	
	


	
    
	
}
