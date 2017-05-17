/*
 * MyDate.h
 *
 *  Created on: Mar 30, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 */

#ifndef MYDATE_H_
#define MYDATE_H_
#include <string>
#include <iostream>
#include <stdio.h>
#include <time.h>
#include <sstream>
using namespace std;
class MyDate
{
	public:
		MyDate();
		MyDate(int year,int month,int day);
		virtual ~MyDate();
		string convert(int i);
		string getValue() ;
		virtual string toString() const;
		int retrieveDays(int year,int month);
	private:
		// contains the fields year, month, and day
		int year;
		int month;
		int day;
};
/*
 * Default constructor that generates mydate for today's date
 */
MyDate::MyDate()
{
	// TODO Auto-generated constructor stub
	time_t now = time(0);
	tm *ltm = localtime(&now);

	this->year=1900 + ltm->tm_year;
	this->month=1 + ltm->tm_mon;
	this->day=ltm->tm_mday ;
	//cout << "Performs tasks for MyDate's constructor" << endl;

}
/*
 * Constructor that generates mydate for given date. Basically checks if it a correct date.
 * @param year The year to be set Any
 * @param month The month to be set 1-12
 * @param day The day to be set 1-31
 */
MyDate::MyDate(int year, int month, int day)
{
	//The exact number of days in the given year in the month
	int numberOfDays=retrieveDays(year,month);

	string message="";
	if(month<1||month>12)
	{
		message+="The month is out of range. ";
	}
	if(day<1||day>numberOfDays)
	{
		message+="The day is out of range. ";
	}
	if(month<1||month>12||day<1||day>numberOfDays)
	{
		throw runtime_error(message);
	}

	this->year=year;
	this->month=month;
	this->day=day;
	//cout << "Performs tasks for MyDate's constructor" << endl;

}
/*
 * Returns the amount of days in the given year and month.
 * @param year The year to be checked Any
 * @param month The month to be checked Any
 * @return The number of days
 */
int MyDate::retrieveDays(int year,int month)
{
	int numberOfDays=0;
	if (month == 4 || month == 6 || month == 9 || month == 11)
		numberOfDays = 30;
	else if (month == 2)
	{
		bool isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		if (isLeapYear)
			numberOfDays = 29;
		else
			numberOfDays = 28;
	}
	else
	{
	  numberOfDays = 31;
	}
	return numberOfDays;
}

/*
 * Default constructor
 */
MyDate::~MyDate()
{
	// TODO Auto-generated destructor stub
}

/*
 * Converts integer to string
 * @param i Integer to be changed
 * @return string The integer to string
 */
string MyDate::convert(int i)
{
    stringstream ss;
    ss << i;
    return ss.str();
}

/*
 * Returns the value of the year,month and day
 * @return string
 */
string MyDate::getValue()
{
	return convert(year)+" "+ convert(month)+" "+convert(day)+" ";
}

/*
 * Returns the class name
 * @return string
 */
string MyDate::toString() const
{
	return "Class function: MyDate";
}
#endif /* MYDATE_H_ */

