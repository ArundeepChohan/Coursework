/*
 *
 */
#include "IntVector.h"

/*
 * Constructs an empty vector of int type.
 */
IntVector::IntVector()
{

}

/*
 * Constructs a vector with the initial capacity.
 * @param capacity Value of new capacity
 */
IntVector::IntVector(unsigned int capacity)
{
	this->capacity=capacity;
}

/*
 * Constructs a vector with the initial capacity, filled with specified values.
 * @param capacity Value of new capacity.
 * @param defaultValue The specified values.
 */
IntVector::IntVector(unsigned int capacity,int defaultValue)
{
	int * array = new int [capacity];
	for (unsigned int i = 0; i < capacity; i++)
	{
		array[i]=defaultValue;
	}
	this->capacity=capacity;

}

/*
 * Copy constructor.
 * @param elem The IntVector to be copied.
 */
IntVector::IntVector(const IntVector &elem)
{
	capacity=elem.capacity;
	size=elem.size;
	array= new int[capacity];
	for(unsigned int i=0;i<size;i++)
	{
		array[i]=elem.array[i];
	}

}

/*
 * Destructor.
 */
IntVector::~IntVector()
{
	delete [] array;
}
/*
 * Appends the element in this vector.
 */
void IntVector::add(int value)
{
	if(size==capacity)
	{
		array = doubleCapacity(array,capacity);
		capacity*=2;
	}
	array[size++]=value;
}
/*
 * Removes the last element from this vector.
 */
void IntVector::remove()
{
	if(size!=0)
	{
		array[size--]=0;
	}
}

/*
 * Returns the number of the elements in this vector.
 * @return size
 */
unsigned int const IntVector::getSize()
{
	return size;
}

/*
 * Returns the capacity of this vector.
 * @return capacity
 */
unsigned int const IntVector::getCapacity()
{
	return capacity;
}

/*
 * Returns the element at the specified index in this vector.
 * @param index the location of array to get
 *
 */
int const IntVector::at(unsigned int index)
{
	if(index> size||index<0 )
	{
		return -1;
	}

	return array[index];
}

/*
 * Returns true if this vector is empty.
 */
bool const IntVector::isEmpty()
{
	return size==0;
}

/*
 * Removes all elements from this vector.
 */
void IntVector::clear()
{
	size=0;
}

/*
 * The function returns a new array that doubles the size of the parameter list.
 * @param list The array of vector values
 * @param size The size of the array
 * @return A new array of double size
 */
int* IntVector::doubleCapacity(const int* list, int size)
{
	int doubled=size*2;
	int * temp = new int[doubled];
	for(int i=0;i<size;i++)
	{
		temp[i]=list[i];
	}
	delete [] list;

	return temp;
}

/*
 * Removes the duplicates in the vector
 */
void IntVector::removeDup()
{
	for(unsigned int i=0;i<size;i++)
	{
	    for(unsigned int j=i+1;j<size;)
	    {
	        if(array[i]==array[j])
	        {
	            for(unsigned int k=j;k<size;k++)
	            {
	                array[k]=array[k+1];

	            }
	            size--;
	        }
	        else
	        {
	            j++;
	        }
	    }
	}
}

/*
 * Returns the intersection of this vector with the specified vector (v2).
 * @param v2 The IntVector to be intersected
 * @param interect A new IntVector of values intersected by v2 and array
 */
IntVector IntVector::intersect (IntVector v2){

	IntVector intersect;
	for ( unsigned int i = 0; i < size; i++)
	{
		for ( unsigned int j  = 0; j < v2.getSize(); j++)
	    {
			if (array[i] == v2.at(j))
	        {
				intersect.add(array[i]);
	        }
	    }
	}
	intersect.removeDup();
	return intersect;
}

