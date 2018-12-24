/*
 *      The implementation of the Circle functions.
 */
#include "Circle.h"

/*
 * Construct a default circle object
 */
Circle::Circle()
{
	radius = 1;
}

/*
 * Construct a circle object
 * @param newRadius The new value of radius
 */
Circle::Circle(double newRadius)
{
	radius = newRadius;
}

/*
 * Return the area of this circle
 * @return The area of the area
 */
double Circle::getArea()
{
	return radius * radius * 3.14159;
}

/*
 * Return the radius of this circle
 * @return radius The circle's radius
 */
double Circle::getRadius()
{
	return radius;
}
/*
 * Set a new radius
 * @param newRadius The new value of radius
 */
void Circle::setRadius(double newRadius)
{
	radius = (newRadius >= 0) ? newRadius : 0;
}
