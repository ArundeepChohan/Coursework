/*
 * StackOfCircles.h
 *
 *  	Created on: Feb 23, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 *       A header file for the declaration of the functions for stackofcircles.
 */

#ifndef STACKOFCIRCLES_H
#define STACKOFCIRCLES_H
#include"Circle.h"
class StackOfCircles
{
	public:
        StackOfCircles();
        bool isEmpty() const;
        Circle peek() const;//This also need to be Circle peek()
        void push(Circle value);//push(circle)
        Circle pop();//Circle pop()
        int getSize() const;
        void printStack();
    private:
        Circle Stack [50]; //So I have to make this a stack of circles something like circle stack[50]
        int size;

};

#endif /* STACKOFCIRCLES_H */
