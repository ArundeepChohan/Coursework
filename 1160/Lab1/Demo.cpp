/*
 * demo.cpp
 *
 *  Created on: Jan 5, 2017
 *      Author: Arundeep Chohan
 *      Student#: 100201711
 */

#include<iostream>
#include<math.h>


using namespace std;

int validateInput(int);

int main()
{
	int startNum,endNum;
	int found=0, count=0;
	cout<<"Enter Number START of Range:  ";
	cin>>startNum;
	startNum = validateInput(startNum);

	cout<<"Enter Number END of Range:  ";
	cin>>endNum;
	endNum = validateInput(endNum);
	for(int i=startNum; i<=endNum; i++)
	{
		for(int j=2; j<=sqrt(i); j++)
		{
			if(i%j==0)
				count++;
		}
		if(count==0 && i!=1)
		{
			found++;
			cout<<"Prime Number -> "<<i<<endl;
			count=0;
		}
		count=0;
	}
	cout<<"Total Prime Number Between Range "<<startNum<<" to "<<endNum<<" = "<<found<<endl;
	return 0;
}
// input validation
int validateInput(int num)
{
	while(cin.fail())
	{
		cin.clear(); // clear input buffer to restore cinto a usable state
		cin.ignore(INT_MAX, '\n'); // ignore last input
		cout << "You can only enter numbers.\n";
		cout << "Enter a number: ";
		cin >> num;
	}
	return num;
}
