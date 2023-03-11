package com.StudentApplication;
import java.util.Scanner;
import java.io.IOException;
public class Main {
	
	public static void studentMethod() {
		Scanner sc=new Scanner(System.in);
		StudentImplement dao=new StudentImplement();
		String name;
		int id;
		long phonenumber;
		int age;
		int courseId;
		do {
		System.out.println("1. Add Student\n" +
                "2. Show All Student\n" +
                "3. Show Student based on id \n" +
                "4. Update the Student\n" +
                "5. Delete the Student\n");
		System.out.println("Enter Choice: ");
		  int ch=sc.nextInt();
		  //This is to clear the screen
		  
		  switch(ch) {
		  case 1:
			  Student stu=new Student();
			  System.out.println("Enter ID: ");
			   id=sc.nextInt();
			   sc.nextLine();
			  System.out.println("Enter name: ");
			   name=sc.nextLine();
			  System.out.println("Enter phonenumber: ");
			   phonenumber=sc.nextLong();
			  System.out.println("Enter age: ");
			  age=sc.nextInt();
			  System.out.println("Enter courseId: ");
			  courseId=sc.nextInt();
			  stu.setId(id);
			  stu.setName(name);
			  stu.setPhoneNumber(phonenumber);
			  stu.setAge(age);
			  stu.setCourseId(courseId);
			  dao.createStudent(stu);
			  break;
		  case 2:
			  dao.showAllStudent();
			  break;
		  case 3:
			  System.out.print("Enter id: ");
			  id=sc.nextInt();
			  dao.showStudentBasedOnID(id);
			  break;
			  
		  case 4:
			  System.out.print("Enter id:");
			   id=sc.nextInt();
			   sc.nextLine();
			  System.out.print("Enter name:");
			   name=sc.nextLine();
			  dao.updateStudent(id, name);
			  break;
		  
		  case 5:
			  System.out.print("Enter id: ");
			  id=sc.nextInt();
			  dao.deleteStudent(id);
			  break;
			  
		  case 6:
			  System.out.println("Thank you for using our Application!!");
			  return ;
			  default:
				  System.out.println("Enter valid choice!!");
				  break;
		  
		  }
	}while(true);
	}
	
	public static void courseMethod() {
		Scanner sc=new Scanner(System.in);
		CourseImplement dao=new CourseImplement();
		int courseId;
		String name;
	  	String Instructor;
		do {
		System.out.println("1. Add Course\n" +
                "2. Show All Course\n" +
                "3. Show Course based on id \n" +
                "4. Update the CourseName\n" +
                "5. Delete the Course\n");
		System.out.println("Enter Choice: ");
		  int ch=sc.nextInt();
		
		  //This is to clear the screen
		  
		switch(ch) {
		  case 1:
			  Course stu=new Course();
			  System.out.println("Enter ID: ");
			   courseId=sc.nextInt();
			   sc.nextLine();
			  System.out.println("Enter name: ");
			   name=sc.nextLine();
			  System.out.println("Enter Instructor: ");
			   Instructor=sc.nextLine();
			  
			  stu.setCourseId(courseId);
			  stu.setName(name);
			  stu.setInstructor(Instructor);
			  dao.createCourse(stu);
			  break;
		  case 2:
			  dao.showAllCourse();
			  break;
		  case 3:
			  System.out.print("Enter id: ");
			  courseId=sc.nextInt();
			  dao.showCourseBasedOnID(courseId);
			  break;
			  
		  case 4:
			  System.out.print("Enter id:");
			   courseId=sc.nextInt();
			   sc.nextLine();
			  System.out.print("Enter name:");
			   name=sc.nextLine();
			  dao.updateCourse(courseId, name);
			  break;
		  case 5:
			  System.out.print("Enter id: ");
			  courseId=sc.nextInt();
			  dao.deleteCourse(courseId);
			  break;
		  case 6:
			  System.out.println("Thank you for using our Application!!");
			  return;
			  default:
				  System.out.println("Enter valid choice!!");
				  break;
		}}while(true);
	
	}
	public static void enrollMethod() {
		Enrollment en=new Enrollment();
		en.run();
		en.showAllStudent();
	}
	
	public static void assessMethod() {
		Assessment en=new Assessment();
		en.showAllStudent();
		en.run();
		en.showAllStudent();
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Student Application");
		do{
		front:
			System.out.println("1. Student Registration\n" +
                "2. Course Allocation\n" +
                "3. Enrollment \n" +
                "4. Assessment\n"+
                "5.Exit"
				);
		System.out.print("Enter your choice: ");
			int  choose= sc.nextInt();
			switch(choose) {
			case 1:
				studentMethod();
				break;
			case 2:
				courseMethod();
				break;
			case 3:
				enrollMethod();
				break;
			case 4:
				assessMethod();
			  case 5:
				  System.out.println("Thank you for using our Application!!");
				  System.exit(0);
			default:
				System.out.println("Invalid");
				System.exit(0);
				break;
			}
		}while(true);}
		

}
