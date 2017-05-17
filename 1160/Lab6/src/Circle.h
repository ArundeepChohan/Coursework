/*
 * Circle.h
 *
 *  	Created on: Feb 23, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 *      A header file for the declaration of the functions for Circle.
 */

#ifndef CIRCLE_H
#define CIRCLE_H

class Circle
{
	public:
		// Construct a default circle object
		Circle();
		// Construct a circle object
		Circle(double);
		// Return the area of this circle
		double getArea();
		// Return the radius
		double getRadius();
		// Sets to new radius
		void setRadius(double);
	private:
		double radius;

};
#endif/* CIRCLE_H */

