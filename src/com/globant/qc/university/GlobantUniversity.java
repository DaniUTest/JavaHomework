package com.globant.qc.university;
import java.util.ArrayList;
import java.util.Scanner;

public class GlobantUniversity {



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		University myUniversity=new University("Globant Academy");
		myUniversity.setFullTimeTeachersList(fullTimeTeacherListGenerator());
		myUniversity.setPartTimeTeacherList(partTimeTeacherListGenerator());
		myUniversity.setTeacherList(myUniversity.getFullTimeTeachersList(), myUniversity.getPartTimeTeacherList());
		myUniversity.setStudentList(studentListGenerator());
		myUniversity.setuClassList(uClassListGenerator());
		myUniversity.setInitialTeacherToClassBulk();
		myUniversity.setInitialStudentToClassesBulk();
		//myUniversity.printStudentxClasses();
		//myUniversity.printUClasses();
		//myUniversity.printFullInfoAllStudentxClass();

		while(true)	
		{

			System.out.println("Welcome Menu");
			System.out.println("1.-Print all teachers");
			System.out.println("2.-Print all classes");
			System.out.println("3.-Create a new student and add him to a existing class");
			System.out.println("4.-Create a new class and add a teacher and students");
			System.out.println("5.-List all the classes in which a given student is included ");
			System.out.println("6.-Exit");
			System.out.println("\n\nPlease, enter your option:");

			Scanner keyboardOption = new Scanner(System.in);
			Scanner anyKey=new Scanner(System.in);
			Scanner info = new Scanner(System.in);
			
			String  auxString = new String();
		
			
			int option = keyboardOption.nextInt();

			switch (option) {
			case 1:
				System.out.println(myUniversity.getTeacherList());
				System.out.println("\n\nPlease, strike any key to continue...");
				anyKey.nextLine();
				fakeClearScreen();
				break;
			case 2:
				System.out.println(myUniversity.getuClassList());
				System.out.println("\n\nPlease, choose a Id Class to show detailed information OR 0 to return to previous menu");
				Scanner classOption=new Scanner(System.in);
				int classId=classOption.nextInt();

				while (classId!=0)
				{
					myUniversity.printFullInfoClassById(classId);
					System.out.println("\n\nPlease, choose a Id Class to show detailed information OR 0 to return to previous menu");
					classId=classOption.nextInt();
				}

				System.out.println("\n\nPlease, strike any key to continue...");
				anyKey.nextLine();
				fakeClearScreen();
				break;
			case 3:
				Student localStudent = new Student();
				System.out.println("Please, enter the data of the student");
				System.out.println("Enter student full name: ");
				auxString=info.nextLine();
				localStudent.setStudentName(auxString);
				System.out.println("Enter Id : ");
				auxString=info.nextLine();
				localStudent.setId((new Integer(auxString)).intValue());
				System.out.println("Enter Age : ");
				auxString=info.nextLine();
				localStudent.setAge((new Integer(auxString)).intValue());
				myUniversity.addStudent(localStudent);
				System.out.println ("The student has been added to University");
				System.out.println("Enter Id Class : ");
				auxString=info.nextLine();
				int localIdClass = ((new Integer(auxString)).intValue());
				boolean addStudentSucess = myUniversity.addStudentToClassById(localStudent.getId(), localIdClass);
				if(addStudentSucess)
					System.out.println("The student " + localStudent.getStudentName() + " identified by " + localStudent.getId() + " was added to Class ID " + localIdClass + " succesfully");
				else
					System.out.println("The student " + localStudent.getStudentName() + " identified by " + localStudent.getId() + " was NOT added to Class ID " + localIdClass);
				System.out.println("\n\nPlease, strike any key to continue...");
				anyKey.nextLine();
				fakeClearScreen();
				break;

			case 4:	

				UClass localUclass = new UClass();
				System.out.println("Please, enter the data of class");
				System.out.println("Enter Class name: ");
				auxString=info.nextLine();
				localUclass.setClassName(auxString);
				System.out.println("Enter Class Id: ");
				auxString=info.nextLine();
				localUclass.setClassId(new Integer(auxString).intValue());
				System.out.println("Enter Class Room: ");
				auxString=info.nextLine();
				localUclass.setClassroom(auxString);
				System.out.println("Enter Teacher Name: ");
				auxString=info.nextLine();
				Teacher localTeacher = myUniversity.getTeacherFromPool(auxString);
				if(localTeacher!=null)
				{
					localUclass.setClassTeacher(localTeacher);
					myUniversity.addClass(localUclass);
					System.out.println("The class " + localUclass.getClassName() + " identified by " + localUclass.getClassId() + " was added succesfully");
				}
				else
				{
					System.out.println("The class " + localUclass.getClassName() + " identified by " + localUclass.getClassId() + " was NOT added because Teacher " + auxString + " DOES NOT exist ");
					break;
				}

				System.out.println("Please add student to the class ID " + localUclass.getClassId() + " OR 0 to finish");
				Scanner studentIdtext=new Scanner(System.in);
				int localStudentId=studentIdtext.nextInt();
				ArrayList <Integer> localStudentList = new ArrayList<Integer>();

				while (localStudentId!=0)
				{
					if(myUniversity.existStudent(localStudentId))
					{
						localStudentList.add(localStudentId);
					}
					else
					{
						System.out.println("The student identified by Id " + localStudentId + " does not exist");
					}
					System.out.println("Please add student to the class ID " + localUclass.getClassId() + " OR 0 to finish");		
					localStudentId=studentIdtext.nextInt();
				}
				 StudentXClass localSC = new StudentXClass(localStudentList,localUclass.getClassId());
				 myUniversity.addClassWithStudents(localSC);
				
				System.out.println("\n\nPlease, strike any key to continue...");
				anyKey.nextLine();
				fakeClearScreen();
				break;

			case 5:
				ArrayList<UClass> localUclassList = new ArrayList<UClass>();
				System.out.println("Please, enter the Student ID");
				int auxInt=0;
				auxInt=info.nextInt();
				localUclassList=myUniversity.searchClassesbyStudentId(auxInt);
				System.out.println("The Student identified by ID " + auxInt + " is registered int the following classes");
				System.out.println(localUclassList);
				System.out.println("\n\nPlease, strike any key to continue...");
				anyKey.nextLine();
				fakeClearScreen();
				break;
				
			default:
				System.out.println("Thank you! Goodbye!!");
				System.exit(1);
			}


		}




	}

	public static  ArrayList <FullTimeTeacher> fullTimeTeacherListGenerator()
	{
		ArrayList <FullTimeTeacher> tempList = new ArrayList <FullTimeTeacher>();
		tempList.add(new FullTimeTeacher("Jack Allate", 500, 3));
		tempList.add(new FullTimeTeacher("Bob Alicon", 500, 2));

		return tempList;

	}

	public static  ArrayList <PartTimeTeacher> partTimeTeacherListGenerator()
	{
		ArrayList <PartTimeTeacher> tempList = new ArrayList <PartTimeTeacher>();
		tempList.add(new PartTimeTeacher("Albert Jota", 20, 40));
		tempList.add(new PartTimeTeacher("Isella Creyo", 30, 40));

		return tempList;

	}


	public static  ArrayList <Student> studentListGenerator()
	{
		ArrayList <Student> tempList = new ArrayList <Student>();
		tempList.add(new Student("Bruce Wayne", 100001, 20));
		tempList.add(new Student("Clark Kent", 100002, 19));
		tempList.add(new Student("Diana Prince", 100003, 19));
		tempList.add(new Student("Barry Allen", 100004, 21));
		tempList.add(new Student("Tony Stark", 100005, 30));
		tempList.add(new Student("Peter Parker", 100006, 15));
		return tempList;

	}

	public static ArrayList <UClass> uClassListGenerator(){

		ArrayList <UClass> tempList = new ArrayList <UClass>();
		tempList.add(new UClass(101, "Blockchain", "101-Room"));
		tempList.add(new UClass(102, "Videogames", "102-Room"));
		tempList.add(new UClass(103, "BigData", "103-Room"));
		tempList.add(new UClass(104, "Programming", "104-Room"));
		return tempList;

	}

	public static void fakeClearScreen ()
	{
		for(int i=0;i<0;i++)
			System.out.println();
	}




}
