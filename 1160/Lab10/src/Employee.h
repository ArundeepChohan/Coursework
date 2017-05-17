/*
 * Employee.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#ifndef EMPLOYEE_H_
#define EMPLOYEE_H_
#include "Person.h"
#include <string>
#include <iostream>
#include <stdio.h>
#include <time.h>

using namespace std;
class Employee:public Person
{

	public:
		Employee();
		Employee(string office, string datehired, double salary);
		virtual ~Employee();
		string toString() const;
		string getValue();
		int &getCount() { return numOfEmployee; }

	private:
		//An employee has an office, salary, and date-hired.
		double salary;
		string datehired;
		string office;
};

/*
 * Default constructor
 * Constructs an employee of today's date, salary =0 and default office.
 */
Employee::Employee()
{
	// TODO Auto-generated constructor stub
	if((((double)numOfEmployee/numOfPeople)*100)<9)
	{
		this->office="DEFAULT";
		time_t now = time(0);
		struct tm tstruct;
		char buf[80];
		tstruct = *localtime(&now);

		strftime(buf, sizeof(buf), "%Y%m%d", &tstruct);
		this->datehired=buf;
		this->salary=0;
		numOfEmployee++;
		//cout << "Performs tasks for Employee's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should admit more students before hiring another employee!");
	}
}

/*
 * Constructs an Employee given office, datehired and salary.
 * @param office any
 * @param datehired any
 * @param salary any
 */
Employee::Employee(string office, string datehired, double salary)
{
	// TODO Auto-generated constructor stub

	if((((double)numOfEmployee/numOfPeople)*100)<9)
	{
		this->office=office;
		this->datehired=datehired;
		this->salary=salary;
		numOfEmployee++;
		//cout << "Performs tasks for Employee's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should admit more students before hiring another employee!");
	}
}

Employee::~Employee() {
	// TODO Auto-generated destructor stub
	numOfEmployee--;
}
string Employee::getValue()
{
	return office+" "+datehired+" "+convert(salary);
}

string Employee::toString() const
{
	return name +" Class name:Employee";
}

#endif /* EMPLOYEE_H_ */


