/*
 * Planer.cpp
 *
 *  Created on: Jan 26, 2017
 *      Author: Arundeep Singh Chohan
 *      Student#: 100201711
 *      Course#: Cpsc 1160-002
 *
 *      Write a planner program to plan his trip where the traveling cost between
 *      different stations (cities) are provided within an input file. The same city can't
 *      be visited more then once and the cities can not have a direct link.
 */
#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <limits.h>
#include <iomanip>

using namespace std;

bool isExist(const char*);
int getSize(const char*);
int getDataSize(const char*,int,string[]);
void getData(const char*,string [],int,int [][3]);
void getCityNames(string , string []);
int getStartIndex(string ,int, string[]);
void getName(const char * , string []);
void getRoute(int [][3],int,int);
int minDistance(int );

void output(string []);
int getSum();
int getCount();
void displayPath(int,string []);
void displayPathCost(int,string[]);

int MATRIX[10][10];
bool VISITED[10];
int PRICE[10];
int PARENT[10];
int COUNT=0;
int main()
{
	//int i,j;
	string input_filename;
	cout<<"Please enter input files:"<<endl;
	cin>>input_filename;
	const char* inputFile;
	inputFile = input_filename.c_str();
	//Testing if filename is valid
	while(!isExist(inputFile))
	{
		cout<<"Invalid filename for input file. Please try again. ";
		cin>>input_filename;
		inputFile = input_filename.c_str();
	}

	int size = getSize(inputFile);
	//cout<<"The number of cities are:"<<size<<endl;

	string cityNames[size];
	getName(inputFile,cityNames);
	int dataSize = getDataSize(inputFile,size,cityNames)*2;
	//cout<<"The number of inputed data are:"<<dataSize<<endl;

	int data [dataSize][3];// Start index-> End index with the price.
	getData(inputFile,cityNames,size,data);
	/*
	for(i=0;i<size;i++)
	{
		cout<<cityNames[i]<<endl;
	}

	for(i=0;i<dataSize;i++)
	{
		for(j=0;j<3;j++)
		{
			cout<<data[i][j]<<" ";
		}
		cout<<endl;
	}*/

	string start_location;
	int startIndex;
	cout<<"Please enter your start location:"<<endl;
	cin>>start_location;
	startIndex = getStartIndex(start_location,size,cityNames);
	while(startIndex == -1)
	{
		cout<<"Invalid start location. Please try again. "<<endl;
		cin>>start_location;
		startIndex = getStartIndex(start_location,size,cityNames);
	}
	//cout<<cityNames[startIndex]<<endl;
	getRoute(data,dataSize,startIndex);
	output(cityNames);
	/*
	for(i=0;i<size;i++)
	{
		for(j=0;j<size;j++)
		{
			if(MATRIX[i][j]!=INT_MAX)
			{
				cout<<MATRIX[i][j]<<" ";
			}
		}
	}
	for(i=0;i<size;i++)
	{
		cout<<i<<":"<<PRICE[i]<<endl;
	}
	for(i=0;i<size;i++)
	{
		cout<<i<<":"<<VISITED[i]<<endl;
	}
	for(i=0;i<size;i++)
	{
		cout<<i<<":"<<PARENT[i]<<endl;
	}
	*/
	return 0;
}

/* Returns the location of thes tring in citynames or -1 otherwise if not found
 *@param startLocation The string to check if it's in cityNames
 *@param size The size of cityNames
 *@return i The index of the string of where it's in the array
 */
int getStartIndex(string startLocation,int size, string cityNames [])
{
	for(int i=0;i<size;i++)
	{
		if(cityNames[i]==startLocation)
		{
			return i;
		}
	}
	return -1;
}

/*Returns true if filename is valid.
 *@param fileName The file to be opened
 *@return bool Tests whether the file can open
 */
bool isExist(const char* fileName)
{
	ifstream test(fileName);
	return test.good();
}

/*Returns number of cities.
 *@param fileName The file to be opened
 *@return count The number of cities
 */
int getSize(const char * filename)
{
	int count = 0,flag = 0;
	ifstream file;
	file.open(filename);
	string temp;
	getline(file, temp);
	for(size_t i = 0;i < temp.length();i++)
	{
		if(temp[i]==',')
		{
			//cout<<temp[i]<<endl;
			count++;
			flag =1;
		}
	}

	file.close();
	if(flag==1)
		return count+1;
	else
		return count;
}

/* Returns the number of data from the file
 *@param filename The file to be opened
 *@param array The array to be checked for valid numbers
 *@return count The amount of data added
 */
int getDataSize(const char * filename,int size,string array[])
{
	int count = 0;
	ifstream file;
	file.open(filename);
	string temp;
	getline(file, temp);
	string start,end,price;
	while(!file.eof())
	{
		file>>start>>end>>price;
		//cout<<start<<""<<end<<""<<price<<endl;
		//What if I get cities that aren't in my first line I get -1 to test them out
		//cout<<getStartIndex(start,size,array)<<"-----------"<<getStartIndex(end,size,array)<<endl;
		if((getStartIndex(start,size,array)!= -1) && (getStartIndex(end,size,array)!= -1))
		{
			count++;
		}
	}
	file.close();

	return count;
}

/* Populates an array from first line in a file
 *@param filename The file to be opened
 *@param array The array to be populated
 */
void getName(const char * filename, string array[])
{
		ifstream file;
		file.open(filename);
		string temp;
		string start,end,price;
		getline(file,temp);
		getCityNames(temp,array);
		file.close();
}

/* Populates an array after the first line in a file
 *@param filename The file to be opened
 *@param array The name of cities to be checked
 *@param array2 The 2d array to be populated
 *@param size The number of cities
 */
void getData(const char * filename, string array[],int size,int array2[][3])
{
	int count = 0;
	string temp;
	string start,end,price;
	ifstream file;

	file.open(filename);
	getline(file,temp);

	while(file>>start>>end>>price)
	{
		//cout<<start<<""<<end<<""<<price<<endl;
		//What if I get cities that aren't in my first line I get -1 to test them out
		if((getStartIndex(start,size,array)!=-1) && (getStartIndex(end,size,array)!=-1))
		{
			array2[count][0] = getStartIndex(start,size,array);
			array2[count][1] = getStartIndex(end,size,array);
			array2[count][2] = atof(price.substr(1).c_str());//price need to remove the $ and keep 123-->This will just skip the first one
			count++;
			array2[count][0] = getStartIndex(end,size,array);
			array2[count][1] = getStartIndex(start,size,array);
			array2[count][2] = atof(price.substr(1).c_str());//price need to remove the $ and keep 123-->This will just skip the first one
			count++;
		}
	}
	file.close();
}

/* Populates an array with the first line in a file
 *@param temp Holds the first line
 *@param array An empty array which will be populated
 */
void getCityNames(string temp, string array[])
{
	int count = 0;
	string temp2;

	for(size_t i = 0;i < temp.length();i++)
	{
		if(temp[i] != ',')//(temp[i]!=' ')&&  The first line should have no spaces in the text file is what I assume??
		{
			temp2 += temp[i];
		}
		//cout<<temp[i]<<endl;
		if(temp[i] == ',')
		{
			array[count] = temp2;
			temp2 = "";
			count++;
		}
	}
	array[count]=temp2;
}

/* Gets the route taken, price of the least costing trip.
*@param array2 Has the 2d array along with price
*@param size The size of what to populate
*@param startIndex A user inputed value to where to start
*/
void getRoute(int array2 [][3],int size,int startIndex)
{
	int i,j;

	for(i = 0;i < 10;i++)
	{
		for(j=0;j<10;j++)
		{
			MATRIX[i][j]= INT_MAX;
		}
	}

	for(i = 0;i < 10;i++)
	{
		PRICE[i]=INT_MAX;
		VISITED[i]=false;
		PARENT[i]=INT_MAX;
	}

	for(i = 0;i < size;i++)
	{
		MATRIX[array2[i][0]][array2[i][1]]=array2[i][2];
		//cout<<MATRIX[array2[i][0]][array2[i][1]]<<" ";
	}
	/*
	cout<<endl;

	for(i=0;i<10;i++)
	{
		for(j=0;j<10;j++)
		{
			cout<<MATRIX[i][j]<<" ";
		}
		cout<<endl;
	}
	 */
	// Distance of source vertex from itself is always 0
	PRICE[startIndex] = 0;
	PARENT[COUNT] = startIndex;

	// Find shortest path for all vertices
	for (int count = 0; count < size; count++)
    {
		// Pick the minimum distance vertex from the set of vertices not
	    // yet processed. u is always equal to src in first iteration.
		int u = minDistance(size);

		// Mark the picked vertex as processed
		VISITED[u] = true;

	    // Update dist value of the adjacent vertices of the picked vertex.
	    for (int v = 0; v < size; v++)
	    {
	    	// Update dist[v] only if is not in visited, there is an edge from
	        // u to v, and total weight of path from src to  v through u is
	        // smaller than current value of dist[v]
	        if (!VISITED[v] && MATRIX[u][v] && PRICE[u] != INT_MAX
	                                       && PRICE[u]+MATRIX[u][v] < PRICE[v])
	            PRICE[v] = PRICE[u] + MATRIX[u][v];
	     }
	 }
}

/*
* A utility function to find the vertex with minimum distance value, from the
* set of vertices not yet included in shortest path tree
*@param n The size of the array
*@return min_index The index of the lowest price
*/
int minDistance(int n)
{
   // Initialize min value
   int min = INT_MAX, min_index;

   for (int v = 0; v < n; v++)
   {
     if ((VISITED[v] == false) && (PRICE[v] <= min))
     {
         min = PRICE[v], min_index = v;
     	 PARENT[COUNT] = min_index;
     }
   }
   if(min!= INT_MAX)
   {
	   COUNT++;
   }
   return min_index;
}

/*This basically displays the proper output with cost,sum and average.It also displays the route taken.
 * @param array The name of cities
 */
void output(string array[])
{
	cout<<"Well."<<endl;
	cout<<"Suggesting plan to buy ticket with total cost $"<<getSum()<<endl;
	cout << string(50, '=')<<endl;
	int size = getCount();
	displayPath(size,array);
	cout << string(50, '=')<<endl;
	cout<<"Detailed Plan #Visiting city: "<<size<<" Cost Rate: "<<(getSum()/size)<<endl;
	cout << string(50, '-')<<endl;
	displayPathCost(size,array);
	cout << string(50, '-')<<endl;
	cout<<"Total Cost is $"<<getSum()<<endl;
}

/*This basically counts out the proper sum removing useless values.
 * @return sum The total cost for the trip
 */
int getSum()
{
	int sum = 0;
	for(int i = 0;i<10;i++)
	{
		if((PRICE[i]<INT_MAX)&&(PRICE[i]>0))
		{
			sum += PRICE[i];
		}
	}
	return sum;
}

/*This displays the path taken.
 * @param array The city names
 * @param n The size of the path
 */
void displayPath(int n,string array[])
{
	cout<<array[PARENT[0]];
	for(int i = 1;i <= n;i++)
	{
		cout<<" <-- "<<array[PARENT[i]];
	}
	cout<<endl;
}

/*This basically counts out the proper amount of paths
 * @return count The number of paths from price
 */
int getCount()
{
	int count = 0;
	for(int i = 0;i < 10;i++)
	{
		if((PRICE[i]<INT_MAX)&&(PRICE[i]>0))
		{
			count += 1;
		}
	}
	return count;
}

/*This displays the city names of the path taken.
 * @param size The number of paths
 * @param array The array of citynames
 */
void displayPathCost(int size,string array [])
{
	for(int i = 0;i < size;i++)
	{
		cout<<"Path = "<<array[PARENT[i]]<<" to "<<array[PARENT[i+1]]<<" costs "<<MATRIX[PARENT[i]][PARENT[i+1]]<<endl;
	}
}
