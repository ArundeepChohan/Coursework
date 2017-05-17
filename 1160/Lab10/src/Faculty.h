/*
 * Faculty.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#ifndef FACULTY_H_
#define FACULTY_H_
#include "Employee.h"
#include <iostream>
#include <string>
using namespace std;
class Faculty:public Employee
{
	public:
		Faculty();
		Faculty(int hour,int rank);
		virtual ~Faculty();
		string toString() const;
		string getValue();

		int &getCount() { return numOfFaculty; }
	private:
		//A faculty member has office hour and a rank.
		int hour;
		int rank;
};
/*
 * Default constructor
 * Creates a faculty of today's hour and rank 1
 */
Faculty::Faculty()
{
	// TODO Auto-generated constructor stub
	//Don't worry about this I just made the faculty default to what hour it was made
	if(((numOfEmployee - 1 == 0 ||((double)numOfStudents / (numOfEmployee - 1)) > 10.00))&&(((double)numOfFaculty/numOfPeople)*100)<2)
	{
		time_t now = time(0);
		tm *ltm = localtime(&now);
		this->hour=  ltm->tm_hour;
		this->rank=1;
		numOfFaculty++;
		//cout << "Performs tasks for Faculty's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should hire an Employee before admitting a new student!");
	}
}
/*
 * Default constructor
 * Creates a faculty of given rank and hour
 * @param rank any
 * @param hour 1-24
 */
Faculty::Faculty(int hour,int rank)
{
	// TODO Auto-generated constructor stub
	if(hour<1||hour>24)
	{
		throw runtime_error("Incorrect hour");
	}
	if(((numOfEmployee - 1 == 0 ||((double)numOfStudents / (numOfEmployee - 1)) > 10.00))&&(((double)numOfFaculty/numOfPeople)*100)<2)
	{
		this->hour= hour;
		this->rank= rank;
		numOfFaculty++;
		//cout << "Performs tasks for Faculty's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should admit more students before hiring another employee!");
	}
}

Faculty::~Faculty()
{
	// TODO Auto-generated destructor stub
	numOfFaculty--;
}
string Faculty::getValue()
{
	return convert(hour)+" "+convert(rank) ;
}

string Faculty::toString() const
{
	return name +" Class name:Faculty";
}

#endif /* FACULTY_H_ */
