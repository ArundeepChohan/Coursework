/*
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

