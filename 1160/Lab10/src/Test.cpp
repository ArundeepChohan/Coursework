/*
 * Test.cpp
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#include <iostream>
#include <string>
#include "Person.h"
#include "Student.h"
#include "Employee.h"
#include "MyDate.h"
#include "Faculty.h"
#include "Staff.h"
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
using namespace std;

int main()
{
	Person* person;
	/*Student* student = new Student;
	Employee* employee = new Employee;
	Faculty* faculty= new Faculty;
	Staff* staff= new Staff;*/

	MyDate mydate;
	cout<<mydate.toString()<<endl;
	cout<<mydate.getValue()<<endl;

	for(int i=0;i<13;i++)
	{
		for(int j=0;j<=31;j++)
		{

			try
			{
				MyDate faultyDate(100,i,j);
				//cout<<faultyDate.toString()<<endl;
				cout<<faultyDate.getValue()<<endl;

			}
			catch (exception &e)
			{
				cout << e.what()<<endl;
			}
		}
	}

	const int TOTAL = 1000; // Number of objects to generate
	const double STAFF_RATIO = 7; // Desired ratios of Staff
	const double FACULTY_RATIO = 2; // Desired ratios of Faculty Members
	//const double STUDENT_RATIO = 91; // Desired ratios of Student Members
	// Initializes the seed
	srand(time(NULL));
	int hour=1,rank=1;
	string title="Captain",status="freshman";

	for(int i = 0; i< TOTAL; ++i)
	{
		int num = rand() % 100;
		if(num < FACULTY_RATIO)
		{
			try
			{
				person = new Faculty(hour, rank);
			}
			catch (exception &e)
			{
				cout << e.what()<<endl;
			}
		}
		else if(num < STAFF_RATIO)
		{
			try
			{
				person = new Staff(title);
			}
			catch (exception &e)
			{
				cout << e.what()<<endl;
			}
		}
		else
		{
			try
			{
				person = new Student(status);
			}
			catch (exception &e)
			{
				cout << e.what()<<endl;
			}
		}
		cout<<person->ratio()<<endl;
	}

	//Testing the student and faculty

	try
	{
		person = new Student("BLAH");
	}
	catch (exception &e)
	{
		cout << e.what()<<endl;
	}
	try
	{
		person = new Faculty(0,1);
	}
	catch (exception &e)
	{
		cout << e.what()<<endl;
	}

	return 0;
}
