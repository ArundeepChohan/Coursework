/*
 * Student.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#ifndef STUDENT_H_
#define STUDENT_H_
#include "Person.h"
#include <string>
#include <iostream>

using namespace std;
class Student:public Person {
	public:
		Student();
		Student(string status);
		virtual ~Student();
		string toString() const;
		string getValue();
		int &getCount() { return numOfStudents; }

	private:
		//student has class status (freshman, sophomore, junior, or senior).
		string statuses [4] = { "freshman","sophomore","junior","senior" };
		string status;
};

/*
 * Default constructor
 * Creates a student of freshman status
 */
Student::Student() {
	// TODO Auto-generated constructor stub
	if((((numOfEmployee == 0 && numOfStudents <= 12.0) ||
		((numOfStudents + 1) / (double)numOfEmployee <= 12.0)))&&((((double)numOfStudents/numOfPeople)*100)<91))
	{
		this->status=statuses[0];
		numOfStudents++;
		//cout << "Performs tasks for Student's constructor" << endl;

	}
	else
	{
		throw runtime_error("You should h+ire an Employee before admitting a new student!");
	}

}

/*
 *  Constructs a student based of given status
 *  @param status "freshman","sophomore","junior","senior"
 */
Student::Student(string status)
{
	// TODO Auto-generated constructor stub
	// found value at "result" pointer location...
	bool found =false;
	for(int i = 0; i < 4 ; i ++)
	{
	    if (status == statuses[i])
	    {
	    	//Do Stuff
	        found = true;
	        break;
	    }
	}
	if(!found)
	{
		throw runtime_error("Not right status");
	}
	if((((numOfEmployee == 0 && numOfStudents <= 12.0) ||
	((numOfStudents + 1) / (double)numOfEmployee <= 12.0)))&&((((double)numOfStudents/numOfPeople)*100)<91))
	{
		this->status=status;
		numOfStudents++;
		//cout << "Performs tasks for Student's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should hire an Employee before admitting a new student!");
	}

}

Student::~Student()
{
	// TODO Auto-generated destructor stub
	numOfStudents--;
}

string Student::getValue()
{
	return status ;
}

string Student::toString() const
{
	string temp =name +" Class name:Student";
	return temp;
}
#endif /* STUDENT_H_ */

