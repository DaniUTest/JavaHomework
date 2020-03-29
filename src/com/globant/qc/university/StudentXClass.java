package com.globant.qc.university;

import java.util.ArrayList;

public class StudentXClass {

	private ArrayList <Integer> studentIdList;
	private int classId;

	/**
	 * 
	 */
	
	
	
	public StudentXClass() {
		this.studentIdList=new ArrayList<Integer>();
		this.classId=0;

	}
	
	

	/**
	 * @param classId
	 */
	public StudentXClass(int classId) {
		this.studentIdList=new ArrayList<Integer>();
		this.classId = classId;
	}



	/**
	 * @param studentIdList
	 * @param classId
	 */
	public StudentXClass(ArrayList<Integer> studentIdList, int classId) {
		this.studentIdList = studentIdList;
		this.classId = classId;
	}
	


	public ArrayList<Integer> getStudentIdList() {
		return studentIdList;
	}

	public void setStudentIdList(ArrayList<Integer> studentIdList) {
		this.studentIdList = studentIdList;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}


	public void addStudenttoClass (int studentId)
	{
		this.studentIdList.add(new Integer(studentId));
		
	}
	
	public boolean isStudentInClass (int studentId)
	{
		for(int i=0;i<this.studentIdList.size();i++)
		{
			if(studentId==this.studentIdList.get(i).intValue())
				return true;
		}
		
		return false;
	}


	@Override
	public String toString() {
		return "StudentXClass [studentIdList=" + studentIdList + ", classId=" + classId + "]";
	}


	



}
