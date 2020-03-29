package com.globant.qc.university;

public class Student {
	
	private String studentName;
	private int id;
	private int age;
	
	
	
	public Student() {
		this.studentName = new String();
		this.id = 0;
		this.age = 0;
	}
	
	/**
	 * @param studentName
	 * @param id
	 * @param age
	 */
	public Student(String studentName, int id, int age) {
		this.studentName = studentName;
		this.id = id;
		this.age = age;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return  (studentName != null ? "Student Name =" + studentName + "	" : "") + "ID =" + id + "	Age ="
				+ age + "\n";
	}
	
	

}
