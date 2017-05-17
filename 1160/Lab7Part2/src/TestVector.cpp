/*
 * TestVector.cpp
 *
 *  Created on: Mar 4, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 */

#include "Vector.h"
#include <iostream>
#include <string>
#include <stdexcept>      // std::out_of_range
using namespace std;

int main()
{
	//Problem 4

	Vector<int> myVector;

	// Store numbers 1, 2, 3, 4, 5, ..., 10 to the vector

	for (int i = 0; i < 10; i++)
	{
		myVector.add(i + 1);
	}
	// Display the numbers in the vector
	cout << "Numbers in the vector: ";

	for (unsigned int i = 0; i < myVector.getSize(); i++)
	{
		try
		{
			cout << myVector.at(i) << " ";
		}
		catch(const out_of_range& oor)
		{

		}
	}

	// Remove the last element

	myVector.remove();

	Vector<int> vector2(5,4);

	cout << "\nThe capacity of v2 is : " << vector2.getCapacity();

	if (! myVector.isEmpty())
	{
		cout << "\nThe myVector is not empty.";
	}

	vector2.add(7);

	Vector<int> vector3 = myVector.intersect(vector2);
	cout << "\nThe intersection between myVector and v2 is : ";
	for (unsigned int i = 0; i < vector3.getSize(); i++)
	{
		try
		{
			cout << vector3.at(i) << " ";
		}
		catch(const out_of_range& oor)
		{

		}
	}

	vector2.clear();

	if (vector2.isEmpty())
	{
		cout << "\nThe v2 is empty.";
	}


	//------------------------------------------------------------------
	// Increase the size of vector dynamically
	for(int i=0; i<100; i++)
	{
		vector2.add(i+1);
	}
	cout << "\nThe capacity of v2 is : " << vector2.getCapacity() <<endl;

	//----------------------------

	return 0;
}
