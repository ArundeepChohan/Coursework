/*

 */

#ifndef SRC_NAME_H_
#define SRC_NAME_H_
#include <string>
#include <iostream>
#include <fstream>
using namespace std;
class Name
{
	private:
		int year;
		int rank;
		string name;
		int frequency;
		char gender;
	public:
		Name();
		//Constructs an empty name
		Name(int,int,string,int,char);
		bool operator <(const Name& n2);
		bool operator <=(const Name& n2);
		bool operator ==(const Name& n2);
		int compareTo(const Name& r2)const;
		bool equals(const Name& r2) const;
		friend istream& operator>>(istream& in, Name &n2);
		friend ostream& operator<<(ostream& out,const Name &n2);
		};

#endif /* SRC_NAME_H_ */
