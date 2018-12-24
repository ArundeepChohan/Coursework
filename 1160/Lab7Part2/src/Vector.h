/*
 *
 */

#include <iostream>
#include <stdlib.h>
#include <string>
#include <stdexcept>      // std::out_of_range
#ifndef VECTOR_H_
#define VECTOR_H_
using namespace std;

template<typename T>
class Vector
{
	public:
		Vector();
		Vector(unsigned int);
		Vector(unsigned int,T);
		Vector(const Vector&);
		~Vector();

		void add(T);
		void remove();
		unsigned int const getSize();
		unsigned int const getCapacity();
		T& at(unsigned int);
		bool const isEmpty();
		void clear();
		Vector<T> intersect (Vector<T>);
		void removeDup();

	private:
		T* doubleCapacity(T* list, unsigned int size);
		unsigned int size;
		unsigned int capacity;
		T *array;
};

template<typename T>
Vector<T>::Vector()
{
	size=0;
	capacity=1;
	array = (capacity == 0) ? NULL : new T[capacity];
}
template<typename T>
Vector<T>::Vector(unsigned int capacity)
{
	size=capacity;
	array = (capacity == 0) ? NULL : new T[capacity];
	this->capacity=capacity;
}
template<typename T>
Vector<T>::Vector(unsigned int capacity,T defaultValue)
{
	size= capacity;
	array = (capacity == 0) ? NULL : new T[capacity];
	for (unsigned int i = 0; i < size; i++)
	{
		array[i] = defaultValue;
	}
	this->capacity=capacity;

}
template<typename T>
Vector<T>::Vector(const Vector &elem)
{
	capacity=elem.capacity;
	size=elem.size;
	array = (capacity == 0) ? NULL : new T[capacity];
	for(unsigned int i=0;i<size;i++)
	{
		array[i]=elem.array[i];
	}

}
template<typename T>
Vector<T>::~Vector()
{
	if (array != NULL)
	{
		delete[] array;
	}

}

template<typename T>
void Vector<T>::add(T value)
{
	if(size==capacity)
	{
		array = doubleCapacity(array,capacity);
		capacity*=2;
	}
	array[size++]=value;
}
template<typename T>
void Vector<T>::remove()
{
	if(size!=0)
	{
		size--;
	}
}
template<typename T>
unsigned int const Vector<T>::getSize()
{
	return size;
}
template<typename T>
unsigned int const Vector<T>::getCapacity()
{
	return capacity;
}
template<typename T>
T& Vector<T>::at(unsigned int index)
{
	if(index < 0 || size <= index)
	{
		throw out_of_range("Error");
	}
	return array[index];
}
template<typename T>
bool const Vector<T>::isEmpty()
{
	return size==0;
}
template<typename T>
void Vector<T>::clear()
{
	size = 0;

}
template<typename T>
T* Vector<T>::doubleCapacity(T* list,unsigned int size)
{
	unsigned int doubled=size*2;
	T *temp = (size == 0) ? NULL : new T[doubled];
	for(unsigned int i=0;i<size;i++)
	{
		temp[i]=list[i];
	}
	if (list != NULL)
	{
		delete[] list;
	}
	return temp;

}

template<typename T>
Vector<T> Vector<T>::intersect (Vector<T> v2){

	Vector<T> intersect;

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

template<typename T>
void Vector<T>::removeDup()
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

#endif /* VECTOR_H_ */

