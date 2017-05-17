/*
 * Name.cpp
 *
 *  Created on: Mar 18, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 */
#include "Name.h"

/*
 * Default constructor
 */
Name::Name()
{
	this->year=0;
	this->rank=0;
	this->name=' ';
	this->frequency=0;
	this->gender=' ';

}

/*
 * Sets constructor with param
 */
Name::Name(int year,int rank,string name,int frequency,char gender)
{
	this->year=year;
	this->rank=rank;
	this->name=name;
	this->frequency=frequency;
	this->gender=gender;

}

/*
 * Return value comparing two Names
 */
bool Name::operator<(const Name& r2)
{
	  if (compareTo(r2) < 0)
	  {
	       return true;
	  }
	  return false;
}

/*
 * Return value comparing two Names
 */
bool Name::operator<=(const Name& r2)
{
	if (compareTo(r2) <= 0 )
	{
		return true;
	}
	return false;
}

/*
 * Return value comparing two Names
 */
bool Name::operator==(const Name& r2)
{
      return equals(r2);
}

/*
 * To compare two Name objects, you should consider the following order on fields of object:
 * 1. Frequency
 * 2. Name
 * 3. Gender
 * 4. Year
 */
int Name::compareTo(const Name& r2) const
{
	if ( this->frequency > r2.frequency )
		return 1;
	if (this->frequency < r2.frequency)
		return -1;

	if (this->name > r2.name )
		return 1;
	if (this->name < r2.name)
		return -1;

	if (this->gender > r2.gender)
		return 1;
	if (this->gender < r2.gender)
		return -1;

	if (this->year > r2.year)
		return 1;
	if (this->year < r2.year)
		return -1;

	return 0;
}

/*
 * Returns value comparing two values
 */
bool Name::equals(const Name& r2) const
{
	if (compareTo(r2) == 0)
		return true;
	else
		return false;
}

/*
 * Overloaded >>
 */
istream& operator>>(istream& in, Name &n2)
{

	 in >> n2.year >> n2.rank >> n2.name >> n2.frequency >> n2.gender;
	 return in;
	//Same for every attribute of your class.

}

/*
 * Overloaded <<
 */
 ostream& operator<<(ostream& out,const Name &n2)
 {
	 out << n2.year <<" " << n2.rank <<" " << n2.name <<" "<< n2.frequency <<" "<< n2.gender<<endl;
	 return out;
	 //Same for every attribute of your class.

 }


