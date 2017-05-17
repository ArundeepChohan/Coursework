/*
 * Person.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 *
 *
 */

#ifndef PERSON_H_
#define PERSON_H_
#include <string>
#include <iostream>
#include <sstream>
#include <stdio.h>
#include <Math.h>

using namespace std;
class Person {

	public:
		Person();
		Person(string name, string address, int phonenumber,string email);
		virtual ~Person();
		virtual string toString() const;
		string convert(double i);
		virtual string getValue();
		string ratio();
		virtual int &getCount() { return numOfPeople; }

		static int numOfPeople;
		static int numOfEmployee;
		static int numOfStaff;
		static int numOfFaculty;
		static int numOfStudents;
	protected:
		//A person has a name, address, phone number, and e-mail address.
		string name;

	private:
		string address;
		int phonenumber;
		string email;
};

//The organization has an unwritten rule that for every 10-12 students a person must be employed.
int Person::numOfPeople= 0;
int Person::numOfEmployee = 0;
int Person::numOfStaff = 0;
int Person::numOfFaculty = 0;
int Person::numOfStudents = 0;

/*
 * Default constructor
 * Creates a person of default values
 */
Person::Person()
{
	// TODO Auto-generated constructor stub
	this->name="DEFAULT";
	this->address="DEFAULT";
	this->phonenumber=1;
	this->email="DEFAULT";
	numOfPeople++;
	//cout << "Performs tasks for Person's constructor" << endl;
}
/*
 * Creates a person of given values.
 * @param name
 * @param address
 * @param phonenumber
 * @param email
 */
Person::Person(string name, string address, int phonenumber,string email)
{
	// TODO Auto-generated constructor stub
	this->name=name;
	this->address=address;
	this->phonenumber=phonenumber;
	this->email=email;
	numOfPeople++;
	//cout << "Performs tasks for Person's constructor" << endl;
}
Person::~Person()
{
	// TODO Auto-generated destructor stub
	numOfPeople--;
}

string Person::toString() const
{
	return name +" Class name:Person";
}
string Person::getValue()
{
	return name+" "+address+" "+convert(phonenumber)+" "+email ;
}
/*
 * Allows the user to checks the current ratio of the staff, faculty and students.
 * @return The ratio of the students, staff and faulty
 */
string Person::ratio()
{
	double ratio1=(double)numOfStudents/numOfPeople;
	double ratio2=(double)numOfFaculty/numOfPeople;
	double ratio3=(double)numOfStaff/numOfPeople;
	//return convert(floor((ratio1)*100.00+0.5)/100.00)+" "+convert(floor((ratio2)*100.00+0.5)/100.00)+" "+convert(floor((ratio3)*100.00+0.5)/100.00);
	return convert(ratio1)+" "+ convert(ratio2)+" "+ convert(ratio3);
}
string Person::convert(double i)
{
    stringstream ss;
    ss << i;
    return ss.str();
}
#endif /* PERSON_H_ */

