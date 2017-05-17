/*
 * TestLinkedList.cpp
 *
 *  Created on: Mar 8, 2017
 *       Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 */
#include"LinkedList.h"
#include <iostream>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <Limits.h>
#include <cstddef>
#include <stdexcept>
#include <exception>

int getInput();
void printList(LinkedList<int> list);
void genLinkedList(int,LinkedList<int>& list);
void split(LinkedList<int> source,LinkedList<int>& frontList, LinkedList<int>& backList);
void merge(LinkedList<int>& source, LinkedList<int> frontList, LinkedList<int> backList);
void mergeSort(LinkedList<int>& list);

using namespace std;
int main()
{
	// Use the function from last assignment

	int n = getInput();
	//Test Problem 2

	LinkedList<int> list;
	genLinkedList(n, list);
	cout << "The random list: " ;
	printList(list);

	//Test Problem 3
	LinkedList<int> first;
	LinkedList<int> second;
	split(list, first, second);
	cout << "The list after splitting: " ;
	printList(list);
	cout << "The first half of list: " ;
	printList(first);
	cout << "The second half of list: " ;
	printList(second);

	//Test Problem 5 (explicitly) and Problem 4 (implicitly)
	mergeSort(list);
	cout << "The list after sorting: " ;
	printList(list);

	return 0;
}
/*
 * Gets a number between 0-100
 * @return A number between 0-100
 */
int getInput()
{
	int n;

	cout<<"Enter a number between 0-100"<<endl;
	cin>>n;
	while(n<=0||n>100||cin.fail())
	{
		cin.clear();
		cin.ignore(INT_MAX,'\n');
		cout<<"Enter a number between 0-100"<<endl;
		cin>>n;
	}
		return n;
}

/*
 * This method goes through the linked list and prints the elements
 * @param list A Linked list full of values
 */
void printList(LinkedList<int> list)
{
     for (int i = 0; i < list.getSize(); i++)
     {
           cout << list.get(i) << " ";
     }
     cout << endl;

}
/*
 * This method fills a LinkedList up to n of random values between 0-100.
 * @param n The number of random values
 * @param list The empty list
 */
void genLinkedList(int n,LinkedList<int>& list)
{
	srand(time(NULL));
	for(int i=0;i<n;i++)
	{
		list.add((rand()%100));
	}
}

/*
 * Splits the List into two.
 * @param source The Linked List to be split.
 * @param frontList The front part
 * @param backList The back part.
 */
void split(LinkedList<int> source,
LinkedList<int>& frontList, LinkedList<int>& backList)
{
	int size;
	size=(source.getSize()+1)/2;

	for(int i =0;i<source.getSize();i++)
	{
		if(i<size)
		{
			frontList.add(source.get(i));
		}
		else
		{
			backList.add(source.get(i));

		}
	}
}

/*
 * This method splits list and sorts each and then merges.
 * @param list The Linked list to be merge sorted.
 */
void mergeSort(LinkedList<int>& list)
{
	if (list.getSize() <= 1)
	{
		return;
	}

	LinkedList<int> frontList;
	LinkedList<int> backList;
	split(list, frontList, backList);
	mergeSort(frontList);
	mergeSort(backList);
	merge(list,frontList, backList);

}

/*
 *This merges the two LinkedLists into one/
 *@param source Overwrite this LinkedList
 *@param frontList The sorted front list
 *@param backList The sorted back list
 */
void merge(LinkedList<int>& source, LinkedList<int> frontList, LinkedList<int> backList)
{
	source.clear();
	Iterator<int> frontIterator = frontList.begin();
	Iterator<int> backIterator = backList.begin();

	while (!frontIterator.isEqual(frontList.end()) && !backIterator.isEqual(backList.end()))
	{
		if (frontIterator.content() < backIterator.content())
		{
			source.add(frontIterator.content());
			frontIterator.next();
		}
		else
		{
			source.add(backIterator.content());
			backIterator.next();
		}
	}

	while (!frontIterator.isEqual(frontList.end()))
	{
		source.add(frontIterator.content());
		frontIterator.next();
	}

	while (!backIterator.isEqual(backList.end()))
	{
		source.add(backIterator.content());
		backIterator.next();
	}
}



