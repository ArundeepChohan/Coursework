/*
 * TestCode.cpp

 *
 *  Created on: Mar 1, 2017
 *       Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 */
#include "IntVector.h"
#include <iostream>
#include <string>

using namespace std;

int main()
{
	//----------------------------------------------------------

	//Problem 3
	IntVector v1;

	// Store numbers 1, 2, 3, 4, 5, ..., 10 to the vector
	for (int i = 0; i < 10; i++)
	{
		v1.add(i + 1);
	}

	// Display the numbers in the vector
	cout << "Numbers in the vector: ";
	for (unsigned int i = 0; i < v1.getSize(); i++)
	{
		cout << v1.at(i) << " ";
	}

	// Remove the last element
	v1.remove();

	IntVector v2(5,4);
	cout << "\nThe capacity of v2 is : " << v2.getCapacity();
	if (! v1.isEmpty())
	{
		cout << "\nThe myVector is not empty.";
	}

	v2.add(7);

	IntVector v3 = v1.intersect(v2);
	cout << "\nThe intersection between myVector and v2 is : ";
	for (unsigned int i = 0; i < v3.getSize(); i++)
	{
		cout << v3.at(i) << " ";
	}

	//v2.clear();

	if (v2.isEmpty())
	{
		cout << "\nThe v2 is empty.";
	}
	//------------------------------------------------------------------
	// Increase the size of vector dynamically
	for(int i=0; i<100; i++)
	{
		v2.add(i+1);
	}
	cout << "\nThe capacity of v2 is : " << v2.getCapacity() <<endl;
	//----------------------------

	return 0;
}

