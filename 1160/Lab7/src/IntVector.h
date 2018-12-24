/*
 *
 */

#ifndef INTVECTOR_H_
#define INTVECTOR_H_

class IntVector
{
	public:
		IntVector();
		//Constructs an empty vector of int type.
		IntVector(unsigned int);
		//Constructs a vector with the initial capacity.
		IntVector(unsigned int,int);
		//Constructs a vector with the initial capacity, filled with specified values.
		IntVector(const IntVector&);
		//Copy constructor.
		~IntVector();
		//Destructor.
		void add(int);
		//Appends the element in this vector.
		void remove();
		//Removes the last element from this vector.
		unsigned int const getSize();
		//Returns the number of the elements in this vector.
		unsigned int const getCapacity();
		//Returns the capacity of this vector.
		int const at(unsigned int);
		//Returns the element at the specified index in this vector.
		bool const isEmpty();
		//Returns true if this vector is empty.
		void clear();
		//Removes all elements from this vector.
		void removeDup();
		//Removes all duplicates from this vector.
		IntVector intersect (IntVector);
		//Returns the intersection of this vector with the specified vector (v2)
	private:
		int* doubleCapacity(const int* list, int size);
		//The function returns a new array that doubles the size of the parameter list.
		unsigned int size=0;
		unsigned int capacity=1;
		int *array=new int[1];
};

#endif /* INTVECTOR_H_ */
