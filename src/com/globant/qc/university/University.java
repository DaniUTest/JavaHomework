package com.globant.qc.university;
import java.util.ArrayList;

public class University {

	private String universityName;
	private ArrayList <Teacher> teacherList;
	private ArrayList <FullTimeTeacher> fullTimeTeachersList;
	private ArrayList <PartTimeTeacher> partTimeTeacherList;
	private ArrayList <Student> studentList;
	private ArrayList <UClass> uClassList;
	private ArrayList <StudentXClass> studentXclassList;


	public University (String universityName) {
		this.universityName=universityName;
		this.teacherList= new ArrayList<Teacher>();
		this.fullTimeTeachersList=new ArrayList<FullTimeTeacher>();
		this.partTimeTeacherList=new ArrayList<PartTimeTeacher>();
		this.studentList=new  ArrayList<Student>();
		this.uClassList=new ArrayList<UClass>();
		this.studentXclassList=new ArrayList<StudentXClass>();

	}

	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public void setTeacherList( ArrayList<FullTimeTeacher> fullTeacherList, ArrayList<PartTimeTeacher> partTimeTeacherList ) {

		this.teacherList=new ArrayList<Teacher>();
		this.teacherList.addAll(fullTeacherList);
		this.teacherList.addAll(partTimeTeacherList);
	}

	public ArrayList<FullTimeTeacher> getFullTimeTeachersList() {
		return fullTimeTeachersList;
	}
	public void setFullTimeTeachersList(ArrayList<FullTimeTeacher> fullTimeTeachersList) {
		this.fullTimeTeachersList = fullTimeTeachersList;

	}
	public ArrayList<PartTimeTeacher> getPartTimeTeacherList() {
		return partTimeTeacherList;
	}
	public void setPartTimeTeacherList(ArrayList<PartTimeTeacher> partTimeTeacherList) {
		this.partTimeTeacherList = partTimeTeacherList;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public ArrayList<UClass> getuClassList() {
		return uClassList;
	}
	public void setuClassList(ArrayList<UClass> uClassList) {
		this.uClassList = uClassList;
	}
	public ArrayList<StudentXClass> getStudentXclassList() {
		return studentXclassList;
	}
	public void setStudentXclassList(ArrayList<StudentXClass> studentXclassList) {
		this.studentXclassList = studentXclassList;
	}

	public void addStudent (Student s) {
		
		this.studentList.add(s);
	}
	
	public void addClass (UClass uclass) {
		this.uClassList.add(uclass);
		
	}
	
	public void setInitialTeacherToClassBulk () {

		int iterator=0;
		for (int i=0; i<this.teacherList.size(); i++)
		{

			this.uClassList.get(iterator).setClassTeacher(this.teacherList.get(i));
			iterator++;
			if(iterator==uClassList.size())
				return;

		}

	}


	public void printUClasses()
	{
		for (int i=0; i<uClassList.size();i++)
		{
			System.out.println("***************************************************************");
			System.out.println("Class Id: " + uClassList.get(i).getClassId());
			System.out.println("Class Name: " + uClassList.get(i).getClassName());	
			System.out.println("Classroom: " + uClassList.get(i).getClassroom());
			System.out.println("Teacher is: " + uClassList.get(i).getClassTeacher().toString());
			System.out.println();

		}

	}
	
	
	public void setInitialStudentToClassesBulk() {
		
		for (int i=0; i<uClassList.size();i++)
		{
			StudentXClass localNode = new StudentXClass(uClassList.get(i).getClassId());
			for(int j=0; j<studentList.size();j++)
			{
				if (i+j<studentList.size())
				{
					
					int localStudentId=studentList.get(i+j).getId();
					localNode.addStudenttoClass(localStudentId);
				}
				
			}
			this.studentXclassList.add(localNode);
			
		}
	}	
	
	
	public boolean addStudentToClassById (int studentId, int classId)
	{
		
		for(int i=0;i<this.studentXclassList.size();i++)
		{
			if(classId==this.studentXclassList.get(i).getClassId())
			{
				this.studentXclassList.get(i).addStudenttoClass(studentId);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	public void addClassWithStudents (StudentXClass sc)
	{

		this.studentXclassList.add(sc);
	}
	
	public boolean existStudent (int studentId)
	{
		for (int i=0;i<this.studentList.size();i++)
		{
			if(studentId==this.studentList.get(i).getId())
				return true;
			
		}
		
		return false;
	}
	
	public Teacher getTeacherFromPool (String teacherName)
	{
		for(int i=0;i<this.teacherList.size();i++)
		{
			if(this.teacherList.get(i).getName().compareTo(teacherName)==0)
			{
				return this.teacherList.get(i);
			}
		}
		
		return null;
		
	}
	
	public ArrayList<UClass> searchClassesbyStudentId (int studentId)
	{
		
		ArrayList<UClass> localUClassList = new ArrayList<UClass>();
		 
		for(int i=0; i<this.studentXclassList.size();i++)
		{
			if (this.studentXclassList.get(i).isStudentInClass(studentId))
			{
				if(searchInfoClassbyId(studentXclassList.get(i).getClassId())!=null) {
					localUClassList.add(searchInfoClassbyId(studentXclassList.get(i).getClassId()));
		
				}
			}
			
		}
		
		return localUClassList;
	}
	
	public UClass searchInfoClassbyId (int classId)
	{
		
		for (int i=0; i<this.uClassList.size();i++)
		{
			if(classId==this.uClassList.get(i).getClassId())
				return this.uClassList.get(i);
			
		}
		
		return null;
	}
	
		
	public void printStudentxClasses () {
		
		for (int i=0; i<this.studentXclassList.size();i++)
			System.out.println(this.studentXclassList.get(i).toString());
	
		

	}
	
	public void printFullInfoClass (StudentXClass sc)
	{
		
		int localClassId = sc.getClassId();
        ArrayList<Integer> localStudentIdList = new ArrayList<Integer>(sc.getStudentIdList());
		String localClassName = new String();
		String localClassTeacher = new String ();
		ArrayList<Student> localStudentList= new ArrayList<Student> ();
		
		for (int i=0;i<this.uClassList.size();i++)
		{
			if(localClassId==this.uClassList.get(i).getClassId())
			{
				localClassName=new String(this.uClassList.get(i).getClassName());
				localClassTeacher=new String(this.uClassList.get(i).getClassTeacher().getName());
			}
		}
		
	    for (int i=0; i<localStudentIdList.size();i++)
	    {
	    	
	    	for (int j=0; j < this.studentList.size(); j++)
	    	{
	    		if(localStudentIdList.get(i).intValue()==this.studentList.get(j).getId())
	    		{
	    			localStudentList.add(this.studentList.get(j));
	    			break;
	    		}
	    		
	    		
	    	}
	    	
	    }
	    
	    System.out.println("Class name:	"+ localClassName);
	    System.out.println("Class ID:	"+ localClassId);
	    System.out.println("Teacher:	"+ localClassTeacher);
	    System.out.println("The List of students is:\n "+ localStudentList);
	    
		
	}
	
	
	public void printFullInfoAllStudentxClass () {
		
		for (int i=0; i<this.studentXclassList.size();i++)
			printFullInfoClass(this.studentXclassList.get(i));
			
				
	}
	
	public void printFullInfoClassById (int classId)
	{
		for (int i=0;i<this.studentXclassList.size();i++)
		{
			if(classId==this.studentXclassList.get(i).getClassId())
			{
				printFullInfoClass(this.studentXclassList.get(i));
				return;
			}
			
		}
		
		System.out.println("This class is not registered");
		
	}
	
	
	


}

