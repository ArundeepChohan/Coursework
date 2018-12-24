/*
 *      The implementation of the Stackofcircles function.
 */
#include "StackOfCircles.h"
#include <iostream>    // using IO functions
#include <iomanip>
#include "Circle.h"
using namespace std;

using std::cout;
using std::cin;
using std::endl;
using std::setw;
using std::setprecision;
using std::fixed;

/* Construct a default StackOfCircles object
 */
StackOfCircles::StackOfCircles()
{
	size = 0;
}

/* Checks if stack is empty
 * @return bool The size of stack
 */
bool StackOfCircles::isEmpty() const
{
	return size == 0;
}

/* Peeks at top of stack
 * @return Top of stack
 */
Circle StackOfCircles::peek() const
{
	return Stack[size-1];
}

/* Pushes a value(circle later) onto the stack and increments size.
 * @param value The value to be pushed
 */
void StackOfCircles::push(Circle value)
{
	Stack[size++] = value.getRadius();
}

/*  Pops the top of array and decrements size.
 * @return The top of the stack
 */
Circle StackOfCircles::pop()
{
	return Stack[--size];
}

/* Gets the size of the stack
 * @return size of array
 */
int StackOfCircles::getSize() const
{
	return size;
}

/* Add a method (function) named printStack to your StackOfCircles class that prints out the
 * stack.
 */
void StackOfCircles::printStack()
{
	cout<<"#Elm in stack\tRadius"<<endl;
	int counter = 1;
	for(int i=size-1;i>=0;i--)
	{
		double x=Stack[i].getRadius();
		//cout<<setw(3)<<size-i<<"\t\t"<<fixed<<setprecision(2)<<setw(5)<<x<<endl;
		cout<<setw(3)<<size-i<<x<<endl;
	}

}
