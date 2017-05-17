/*
 * 		Assign5.cpp
 *
 *  	Created on: Feb 2, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 *      Course#: CPSC 1160-002
 *
 *		Write a program that asks for a number from the user, generates
 *		an array of size of the number with random values between n-n^2
 *		and find the median of the array.
 *
 */
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time */
#include <iostream>
#include <limits.h>

using namespace std;

void generateRandom(int [],int);
void quickSort(int [], int, int );
void improvedquickSort(int [], int, int );
int partition(int [], int , int );
int median(int,int []);
int improvedMedian(int , int []);
int selection_algorithm(int [],int ,int ,int );
int partitions(int [],int ,int );
void swap (int [],int , int );
int main ()
{
	int n;

	cout<<"Please input a number for n:"<<endl;
	cin>> n;
	//Let's just say we want a positive n that fits in a integer data type
	while(n<0||(INT_MAX/n <n))
	{
		cout<<"Please input a number for n:"<<endl;
		cin>> n;
	}
	int test1[]={1, 9, 6, 8, 7, 3, 3};
	int test2[]={1, 9, 6, 7, 3, 3};
	cout<<"The median of test1 array : "<<median(sizeof(test1)/sizeof(test1[0]),test1)<<endl;
	cout<<"The median of test2 array : "<<median(sizeof(test2)/sizeof(test2[0]),test2)<<endl;

	int randNum [n];
	srand(time(NULL));
	generateRandom(randNum,n);

	cout<<"The improved median is : "<<improvedMedian(n,randNum)<<endl;
	cout<<"The median is : "<<median(n,randNum)<<endl;

	int quickSort[n];
	generateRandom(quickSort,n);
	cout<<"Unsorted array: "<<endl;
	for(int i=0;i<n;i++)
	{
		cout<<quickSort[i]<<endl;
	}

	improvedquickSort(quickSort,0,n-1);
	cout<<"Improved quick sort array: "<<endl;
	for(int i=0;i<n;i++)
	{
		cout<<quickSort[i]<<endl;
	}
	return 0;
}

/*	Allocates an array of n size with values between n - n^2.
 * @param n The size of array
 * @param array The array to be populated
*/
void generateRandom(int array[],int n)
{
	for(int i=0;i<n;i++)
	{
		array[i]=rand()%(n*n-n) +n;;
		//cout<<"Then randomly generated number is: "<<array[i]<<endl;
	}
}

/*	Finding the median of the array.
 * @param first The start index
 * @param last The end index
 * @param array A populated array
 * @return The next index to be partitioned
*/
int partition(int array[], int first, int last)
{
	int pivot = array[first];  // Choose the pivot
	int low = first + 1;   // Index for forward search
	int high = last;      // Index for backward search
	while (high > low)
	{
		// Search forward from left
		while (low <= high && array[low] <= pivot)
			low++;
		// Search backward from right
		while (low <= high && array[high] > pivot)
			high--;
		// Swap two elements in the list
	    if (high > low)
	    {
	    	int temp = array[high];
	        array[high] = array[low];
	        array[low] = temp;
	    }
	}

	while (high > first && array[high] >= pivot)
		high--;
	     // Swap pivot with list[high]
	    if (pivot > array[high])
	    {
	    	array[first] = array[high];
	    	array[high] = pivot;
	    	return high;
	    }
	    else
	    {
	         return first;
	    }
}

/*	Breaking an array to be partitioned
 * @param low The start index
 * @param high The end index
 * @param array An array to be sorted
*/
void quickSort(int array[],int low,int high)
{
	int j;
    if(low<high)
    {
    	j=partition(array,low,high);
        quickSort(array,low,j-1);
        quickSort(array,j+1,high);
    }
}

/*	 An improved quicksort of nlogn complexity using n/2 as pivot point.
  * @param left The start index
  * @param right The end index
  * @param array The array to be sorted
 */
void improvedquickSort(int array[], int left, int right)
{
	int i = left, j = right;
    int pivot = array[(left + right) / 2];

    /* partition */
    while (i <= j)
    {
    	while (array[i] < pivot)
    		i++;
        while (array[j] > pivot)
            j--;
            if (i <= j)
            {
            	swap(array,i,j);
            	i++;
            	j--;
           }
       };

       /* recursion */
       if (left < j)
       {
             quickSort(array, left, j);
       }
       if (i < right)
       {
             quickSort(array, i, right);
       }
}

/* Return either n/2 or n/2-1 if the size of array is either odd or even
 * @param n The size of the array
 * @param array An unsorted array of random numbers between n-n^2
 * @return median the middle number
 */
int median(int n,int array[])
{
	quickSort(array,0,n-1);
	for(int i=0;i<n;i++)
	{
		cout<<array[i]<<" "<<endl;
	}
	if(n%2==0)
	{
		return array[(n/2)-1];
	}
	else
	{
		return array[(n/2)];
	}
}

/* Return the improved median of o(n) complexity
 * @param n The size of array
 * @param array The unsorted populated array
 * @return The median using partial sorting in o(n)
 */
int improvedMedian(int n, int array[])
{
	if(n%2==0)
		return selection_algorithm(array, 0, n-1, n/2);
	else
		return selection_algorithm(array, 0, n-1, n/2+1);
}

/* Swap two values in the array
 * @param array Unsorted array
 * @param i The index to be swapped
 * @param j The index to be swapped
 */
void swap (int array[],int i, int j)
{
	int temp= array[i];
	array[i]=array[j];
	array[j]=temp;
}

/*
 * https://discuss.codechef.com/questions/1489/find-median-in-an-unsorted-array-without-sorting-it
 * Partial swapping in 0(n) to find median
 * @param array Unsorted array
 * @param low The start index
 * @param high The end index
 * @return the median
 */
int partitions(int array[],int low,int high)
{
    int p=low,r=high,x=array[r],i=p-1;
    for(int j=p;j<=r-1;j++)
    {
        if (array[j]<=x)
        {

            i=i+1;
            swap(array,i,j);
        }
    }
    swap(array,i+1,r);
    return i+1;
}

/* https://discuss.codechef.com/questions/1489/find-median-in-an-unsorted-array-without-sorting-it
 * So this finds the value at n/2 without sorting it using the concept of quicksort, picking a pivot
 * checking which values are greater or less then pivot.
 * @param array The unsorted array
 * @param left The start index
 * @param right The end index
 * @param kth The position to find
 * @return
 */
int selection_algorithm(int array[],int left,int right,int kth)
{
    for(;;)
    {
        int pivotIndex=partitions(array,left,right);          //Select the Pivot Between Left and Right
        int len=pivotIndex-left+1;

        if(kth==len)
            return array[pivotIndex];

        else if(kth<len)
            right=pivotIndex-1;

        else
        {
            kth=kth-len;
            left=pivotIndex+1;
        }
    }
    return -1;
}
