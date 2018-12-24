/*

 */
#include<iostream>
#include <string>
#include <sstream>

using namespace std;
class Person
{
	private:
		int age;
		string name;

	public:
		~Person(){}
		Person(){
			string input;
			// How to get a string/sentence with spaces
			cout << "Please enter a valid name(with spaces):\n>";
			getline(cin, input);
			cout << "You entered: " << input << endl;
			name=input;
			age=0;
			while (true) {
				cout << "Please enter a valid age: ";
				getline(cin, input);

				// This code converts from string to number safely.
				stringstream myStream(input);
				if (myStream >> age)
					break;
				cout << "Invalid number, please try again" << endl;
			}
			cout << "You entered: " << age << endl << endl;
		}
		 void showData(){
			cout<<",(name="<<name <<")"<<",(age="<<age<<")";
		}
};
class Student: public Person
{
	private:
		string major;

	public:
		Student(){
			string input;
			// How to get a string/sentence with spaces
			cout << "Please enter a valid major(with spaces):\n>";
			getline(cin, input);
			cout << "You entered: " << input << endl;
			major=input;
		}
		~Student(){}
		void showData(){
			Person::showData();
			cout<<",(major="<<major <<")";
		}

};
class Employee:public Person
{
	private:
		string title;
	public:
		Employee(){
			string input;
			// How to get a string/sentence with spaces
			cout << "Please enter a valid title(with spaces):\n>";
			getline(cin, input);
			cout << "You entered: " << input << endl;
			title=input;
		}
		~Employee(){}
		void showData(){
			Person::showData();
			cout<<",(title="<<title <<")";
		}

};
class TA:public Employee, Student
{
	private:
		int id;
	public:
		~TA(){}
		TA(){
			id=0;
			string input;
			while (true) {
				cout << "Please enter a valid id: ";
				getline(cin, input);

				// This code converts from string to number safely.
				stringstream myStream(input);
				if (myStream >> id)
					break;
				cout << "Invalid number, please try again" << endl;
			}
			cout << "You entered: " << id << endl << endl;
		}
		void showData(){
			Student::showData();
			Employee::showData();
			cout<<",(TA id="<<id <<")";
		}
};
int main() {
/*
	cout <<endl << "It is about to create an object of Person " <<endl;
	Person p;
	cout <<endl << "Person's data: " ;
	p.showData();
	// Testing single inheritance
	cout <<endl << "It is about to create an object of Employee " <<endl;
	Employee e;
	cout <<endl << "Employee's data: " ;
	e.showData();
	// Testing single inheritance
	cout <<endl << "It is about to create an object of Student " <<endl;
	Student s;
	cout <<endl << "Students's data: " ;
	s.showData();
	*/
	// Testing multiple inheritance
	cout <<endl << "It is about to create an object of TA " <<endl;
	TA ta;
	cout <<endl << "TA's data: " ;
	ta.showData();
	return 0;
}


