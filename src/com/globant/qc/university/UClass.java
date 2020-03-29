package com.globant.qc.university;



public class UClass {

	private int classId;
	private String className;
	private String classroom;
	private Teacher classTeacher;
	/**
	 * 
	 */
	public UClass() {
		
	}
	/**
	 * @param classId
	 * @param className
	 * @param classroom
	 */
	public UClass(int classId, String className, String classroom) {
		
		this.classId = classId;
		this.className = className;
		this.classroom = classroom;
	}
	/**
	 * @param classId
	 * @param className
	 * @param classroom
	 * @param classTeacher
	 */
	public UClass(int classId, String className, String classroom, Teacher classTeacher) {
		
		this.classId = classId;
		this.className = className;
		this.classroom = classroom;
		this.classTeacher = classTeacher;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public Teacher getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}
	
	
	
	@Override
	public String toString() {
		return "Class Id=" + classId + "	" + (className != null ? "Class Name=" + className + "	" : "")
				+ (classroom != null ? "Classroom = " + classroom + "":"") + "\n";
	}
	









}
