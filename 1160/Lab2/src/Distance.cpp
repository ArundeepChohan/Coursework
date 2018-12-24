/*
Calculates Distance
 */
#include<iostream>
#include<math.h>
#include<fstream>
#include<string>
#include<iomanip>      // std::setw

using namespace std;

double toRadians(double );
double calDistance(double, double, double, double );
bool isExist(const char*);
string *getCities(const char *);
double *getLocations(const char *);
void printOutput(double[][10]);

string cities[10];
double location[20];
double cityLocation[10][2];

const int R = 6371;
const int size=(sizeof(cities)/sizeof(cities[0]));
int main ()
{
	string city_filename;
	string loc_filename;
	const char* cityFile,*locFile;

	//Testing out the distance functions and toradians funcion
	cout<<"Degree 0: "<<toRadians(60)<<endl;
	cout<<"Distance between points: "<<calDistance(47.606209,-122.332071,
			43.653226,-79.383184)<<endl;

	cout<<"Please enter a filename for cities: ";
	cin>>city_filename;

	cityFile = city_filename.c_str();
	//Testing if filename is valid
	while(!isExist(cityFile))
	{
		cout<<"Invalid filename for city. Please try again. ";
		cin>>city_filename;
		cityFile = city_filename.c_str();
	}
	cout<<"Please enter a filename for locations: ";
	cin>>loc_filename;
	locFile = loc_filename.c_str();
	while(!isExist(locFile))
	{
		cout<<"Invalid filename for Locations. Please try again.";
		cin>>loc_filename;
		locFile = loc_filename.c_str();
	}
	//Gets the cities and locations and stores in globals arrays
	getCities(cityFile);
	getLocations(locFile);

	for(unsigned int i=0; i<(size*2); i++)
	{
		cout<<location[i]<< endl;
	}

	for(int i=0; i<size; i++)
	{
		cout<<cities[i] << endl;
	}

	for(int i=0;i<size;i++)
	{
		cout<<i<<": ";
		for(int j=0;j<2;j++)
		{
			cityLocation[i][j]=location[((i*2)+j)];
			cout<<cityLocation[i][j]<<" ";
		}
		cout<<endl;
	}
	//Stores the distance between cities in a 2d array.
	double results[size][size];
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			results[i][j]=calDistance(location[(i*2)],location[(i*2)+1],location[j*2],location[(j*2)+1]);
			cout<<results[i][j]<<" ";
		}
		cout<<endl;
	}

	printOutput(results);
	return 0;
}
/*
 Converts degree into radians
 */
double toRadians(double degree)
{
	return(( degree * M_PI ) / 180 );
}
/*
 Returns a double between 4 points.
 */
double calDistance(double latA, double lonA, double latB, double lonB)
{
	return acos(cos(toRadians(latA))* cos(toRadians(latB))* cos(toRadians(lonB)-toRadians(lonA))+ sin(toRadians(latA))* sin(toRadians(latB)))*R;
}
/*
 Returns an array with cities
 */
string * getCities(const char *filename)
{
	ifstream file;
	int i=0;
	file.open(filename);

	getline(file, cities[0]);//this one will be overwritten

	cout << "Inserting in array to store values. " << endl;
	while(!file.eof())
	{
		getline(file, cities[i]);
		cout << "Added value into an array: "<<cities[i]<< endl;
		i++;
	}
	file.close();
	return cities;
}
/*
 Returns an array with the values of location.
 */
double* getLocations(const char *filename)
{
	ifstream file;
	int i=0;
	double a,b;

	file.open(filename);
	cout << "Inserting in array to store values. " << endl;
	file>>a;
	while(!file.eof())
	{
		file>>a>>b;
		location[i]=a;
		location[i+1]=b;
		i+=2;
		cout << "Added value into an array: "<<a<<endl;
		cout << "Added value into an array: "<<b<<endl;
	}
	return location;
}
/*
 Returns true if filename is valid
 */
bool isExist(const char* fileName)
{
	ifstream test(fileName);
	return test.good();
}
/*
Takes in a 2d array and displays the output.The distance value is a rounded value with no digit after decimal point and it is printed in 8 digits width. Also we have 12 characters
to print name of each city.
 */
void printOutput(double results[][10])
{
	int i,j,offset = 0,temp = size,offsetheader;
	while(temp/10!=0)
	{
		offset += 1;
		temp = temp/10;
	}
	offsetheader = offset;
	cout<<left<<setw(20+offset)<<"Distance in Km "<<right;
	for(i=0;i<size;i++)
	{
		if(((i+1)%10==0)&&(i!=0))
		{
			offsetheader--;
		}
		for(j=0;j<offsetheader;j++)
		{
			cout<<setw(offsetheader)<<" ";
		}
		cout<<right<<(i+1)<<")"<<setw(6-offsetheader)<<" ";

	}
	cout<<endl;

	for(i=0;i<size;i++)
	{
		cout<<setfill('-')<<setw(10)<<"-";
	}
	cout<<setw(offset)<<endl;

	cout<<setfill(' ');
	for(i=0;i<size;i++)
	{
		if(((i+1)%10==0)&&(i!=0))
		{
			offset--;
		}
		cout<<i+1<<")"<<setw(12)<<left<<cities[i];
		for(j=0;j<offset;j++)
		{
			cout<<setw(offset)<<" ";
		}
		for(j=0;j<size;j++)
		{
			cout<<setw(8)<<right<<int(results[i][j]+0.5);
		}
		cout<<endl;
	}
}
