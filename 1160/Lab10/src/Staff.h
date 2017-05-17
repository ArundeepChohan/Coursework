/*
 * Staff.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#ifndef STAFF_H_
#define STAFF_H_
#include "Employee.h"
#include <string>
#include <iostream>
using namespace std;
class Staff: public Employee
{
	public:
		Staff();
		Staff(string title);
		virtual ~Staff();
		string toString() const;
		string getValue();
		int &getCount() { return numOfStaff; }

	private:
		//A staff member has a title.
		string title;
};
/*
 * Default constructor
 * Constructs a staff of default title
 */
Staff::Staff()
{
	// TODO Auto-generated constructor stub
	if(((numOfEmployee - 1 == 0 ||
			   ((double)numOfStudents / (numOfEmployee - 1.00) > 10.00)))&&((((double)numOfStaff/numOfPeople)*100)<7))
	{
		this->title="DEFAULT";
		numOfStaff++;
		//cout << "Performs tasks for Staff's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should admit more students before hiring another employee!");
	}

}

/*
 * Constructs a staff with given title
 * @param title any
 */
Staff::Staff(string title)
{
	// TODO Auto-generated constructor stub
	if(((numOfEmployee - 1 == 0 ||
				   ((double)numOfStudents / (numOfEmployee - 1.00) > 10.00)))&&((((double)numOfStaff/numOfPeople)*100)<7))

	{
		this->title=title;
		numOfStaff++;
		//cout << "Performs tasks for Staff's constructor" << endl;
	}
	else
	{
		throw runtime_error("You should admit more students before hiring another employee!");
	}

}

Staff::~Staff()
{
	// TODO Auto-generated destructor stub
	numOfStaff++;
}

string Staff::getValue()
{
	return title ;
}

string Staff::toString() const
{
	return name +" Class name:Staff";
}
#endif /* STAFF_H_ */

