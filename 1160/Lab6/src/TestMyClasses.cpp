/*
 * TestMyClasses.cpp
 *
 *  	Created on: Feb 22, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 *		This application creates circles with any radius,
 *		populates an array randomly 0-50.00 with a user inputed size.
 *		it populates a stack with circles and can pop out the max
 *		radius circles in the stack.
 */

#include "CIRCLE.cpp"
#include "STACKOFCIRCLES.cpp"

#include <stdlib.h>     // srand, rand
#include <time.h>       // time
#include <stdio.h>
#include <cstdlib>
#include <iostream>
#include <iomanip>

using namespace std;

int getInput();
void genArrayOfCircles(int ,Circle []);
void printCircleArray(int, Circle []);

StackOfCircles populateStackOfCircles(int);
/*
Circle getMaxCircle(StackOfCircles&);
*/
double randomize();

int SIZE=50;

int main() {

srand(time(NULL));
Circle data [SIZE];
int n = getInput();
genArrayOfCircles(n, data);
printCircleArray(n, data);

int size = getInput();
StackOfCircles stack = populateStackOfCircles(size);
stack.printStack();
//Circle maxCircle = getMaxCircle(stack);
//cout <<"The maximum radius is: " << maxCircle.getRadius() <<endl;
//stack.printStack();

return 0;
}

/* Gets a number between 0-50 for the size from the user.
 * @return n A value between 0-50
 */
int getInput()
{
	int n;
	cout<<"Enter a value between 0-50."<<endl;
	cin>>n;
	while(n<0 || n>50)
	{
		cout<<"Wrong value,Enter a value between 0-50!"<<endl;
	}
	return n;
}

/* Obtains a number between 0-50 into 2 decimal places.
 * @return num A value between 0-50 as a decimal number with 2 decimal points.
 */
double randomize()
{
	double num = (double)(rand() % 5000) / 100;
	return num;
}

/* Write a function genArrayOfCircles that receives an integer (e.g. n, which is
 * in interval [0, 50]). Then generates and returns n non-duplicated Circles with random
 * radius:
 * @param n The number of elements to retrieve
 * @param data The circle to fill with radius
 */
void genArrayOfCircles(int n, Circle data [])
{
	int array[5000];
	for(int i=0; i<n;i++ )
	{
		double temp = randomize();
		if(array[(int)temp*100]!=1)
		{
			data[i].setRadius(temp);
			array[(int)temp*100]=1;
			i++;
		}
	}
}

/*
 * @param n The number of elements in the array
 * @param data The filled circle array of radius
 */
void printCircleArray(int n, Circle data [])
{
	for(int i=0;i<n;i++)
	{
		cout<<data[i].getRadius()<<endl;
	}
}

/* Write a function named populateStackOfCircles that receives an integer (e.g.
 * n, which is in interval [0, 50]). Then generates and returns a stack of non-duplicated
 * Circles with size n.
 * @param n The number of circles to populate the stack
 * @return StackOfCircles
 */

StackOfCircles populateStackOfCircles(int n)
{
	StackOfCircles stack;
	int array[5000];

	for(int i=0; i<n; )
	{
		double temp = randomize();
		if(array[(int)temp*100]!=1)
		{
			Circle circle(temp);// Here I need to figure out how to make a stack of circles not int
			stack.push(circle);
			array[(int)temp*100]=1;
			i++;
		}
	}
	return stack;
}

/* Write a function named getMaxCircle that receives a stack of circles. Then
 * it finds the circle with maximum radius in the stack. It removes this object
 * from the stack and return it to main function.
 * @param stack The stack filled with circles
 * @return maxcircle The stack without the max radius circle
 */
/**
Circle getMaxCircle(StackOfCircles &stack)
{

	Circle maxCircle;
	StackOfCircles temp;
	double maxRadius = 0;
	while(!stack.isEmpty())
	{
		Circle tempCircle = stack.pop();
		if(tempCircle.getRadius()> maxRadius)
		{
			maxCircle = tempCircle;
			maxRadius = tempCircle.getRadius();
		}
		temp.push(tempCircle);
		//cout<<tempCircle.getRadius()<<endl;
	}
	while(!temp.isEmpty())
	{
		Circle tempCircle = temp.pop();
		if(tempCircle.getRadius() != maxCircle.getRadius())
		{
			stack.push(tempCircle);
			//cout<<tempCircle.getRadius()<<endl;
		}
	}

	return maxCircle;
}
*/
