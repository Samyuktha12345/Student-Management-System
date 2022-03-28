package com.StudentManagementSystem;

import java.util.Scanner;

public class Student {

private String firstName;
private String lastName;
private int studentID;
private String courses = "";
private int tuitionBalance = 0;
private int costOfCourse = 1000;
private static int id = 2000;
//constructor: user to enter students information
public Student()
{
	Scanner in = new Scanner(System.in);
	System.out.print("Enter student firstName:");
	this.firstName = in.nextLine();
	System.out.print("Enter student lastName:");
	this.lastName = in.nextLine();
	
	setStudentID();
}
//generate an ID
private void setStudentID() {
	
	id++;
	this.studentID = id;
}
//Enroll courses
public void enroll()
{
	//get inside a loop ,user hits 0
	do
	{
		System.out.print("Enter course to enroll(Q to quit):");
		Scanner in = new Scanner(System.in);
		String Course = in.nextLine();
		if(!Course.contentEquals("Q"))
		{
			courses = courses +"\n" +Course;
			tuitionBalance = tuitionBalance+costOfCourse;
		}
		else
		{
			break;
		}
	}
	while(1!=0);
	
	}
//view balance
public void viewBalance()
{
	
System.out.println("your balance is:$"+tuitionBalance);
}
//pay Tuition
public void payTuition()
{
	viewBalance();
	System.out.print("Enter your payment:$");
	Scanner in = new Scanner(System.in);
	int payment = in.nextInt();
	tuitionBalance = tuitionBalance-payment;
	System.out.println("Thankyou for your payment of $"+payment);
	viewBalance();
}
//show status
public String toString()
{
	return "Name: " + firstName + " " + lastName + 
			"\nstudentId: " + studentID + "\nCoursesEnrolled:" + courses + "\nBalance: $" + tuitionBalance;
}

public static void main(String[]args)
{
	
	//Ask how many users we want to add
	System.out.print("Enter number of new students to enroll:");
	Scanner in=new Scanner(System.in);
	int numOfStudents = in.nextInt();
	Student[]students = new Student[numOfStudents];
	//create i number of new students
	for(int i = 0;i < numOfStudents; i++)
		{
		students[i] = new Student();
		students[i].enroll();
		students[i].payTuition();
		}
	for(int i = 0;i < numOfStudents; i++)
	{
		System.out.println(students[i].toString());
	}
}
}
