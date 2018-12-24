/*
 */
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <ostream>
#include <sstream>
#include <vector>
#include <string>
#include "Name.h"
#include <Math.h>
#include <stdlib.h>     /* atoi */
#include <algorithm>
using namespace std;

string getStat(string) throw (runtime_error);
void genFile(ofstream&);
void combineFilesToBinary(ofstream&);
void sort(ifstream&, ofstream&);
void find20Populars(ifstream&, ofstream&);
int toInt(string);
string ToString(int  val);
void removeStuff(string& str, char character);

int main()
{

    ifstream input;
    ofstream output;
    ifstream binaryInput;
    ofstream binaryOutput;

    string temp1="Stat.txt";
    string temp2="AllNames.dat";
    string temp3="SortedAllNames.dat";
    string temp4="20Names.txt";

    // problem 2
    output.open(temp1.c_str());
    if(output.is_open())
    {
    	genFile(output);
    }
    output.close();

    // problem 3
    binaryOutput.open(temp2.c_str(), ios::out | ios::binary);
    if(binaryOutput.is_open())
    {
    	combineFilesToBinary(binaryOutput);
    }
    binaryOutput.close();

    Name r1(2, 2,"bob",10,'M');
   	Name r2(2, 2,"bob",11,'M');
   	Name r3(2, 2,"cam",10,'M');
   	Name r4(2, 2,"bob",10,'F');
   	Name r5(1, 2,"bob",10,'M');
   	/*
   	 * Freq
   	 * Name
   	 * Gender
     * Year
   	 */

   	//cout << "r1 < r2 is " << (r1<(r2) ? "true" : "false") << endl;
   	//cout << "r1 < r3 is " << (r1<(r3) ? "true" : "false") << endl;
   	//cout << "r1 < r4 is " << (r1<(r4) ? "true" : "false") << endl;
   	//cout << "r1 < r5 is " << (r1<(r5) ? "true" : "false") << endl;

   	cout << "r1 <= r2 is " << (r1<=(r2) ? "true" : "false") << endl;
   	cout << "r1 <= r3 is " << (r1<=(r3) ? "true" : "false") << endl;
   	cout << "r1 <= r4 is " << (r1<=(r4) ? "true" : "false") << endl;
   	cout << "r1 <= r5 is " << (r1<=(r5) ? "true" : "false") << endl;
    //cout << "r1 > r2 is " << (r1>(r2) ? "true" : "false") << endl;
    //cout << "r1 > r3 is " << (r1>(r3) ? "true" : "false") << endl;
    //cout << "r1 > r4 is " << (r1>(r4) ? "true" : "false") << endl;
    //cout << "r1 > r5 is " << (r1>(r5) ? "true" : "false") << endl;
    cout<<r1<<r2<<r3<<r4<<r5<<endl;

    // problem 4
    binaryInput.open(temp2.c_str(), ios::in | ios::binary);
    binaryOutput.open(temp3.c_str(), ios::out | ios::binary);
    if(binaryOutput.is_open()&&binaryInput.is_open())
    {
    	sort(binaryInput, binaryOutput);
    }
    binaryInput.close();
    binaryOutput.close();

    // problem 5
    binaryInput.open(temp3.c_str(), ios::in | ios::binary);
    output.open(temp4.c_str());
    if(binaryInput.is_open()&& output.is_open())
    {
    	find20Populars(binaryInput, output);
    }

    binaryInput.close();
    output.close();

    cout << "Done" << endl;

    return 0;
}
/*
 * Prints years 2010-2015 to the stat.txt file.
 * @param output The output file of stat.txt
 */
void genFile(ofstream& output)
{
    output << "Year, MalePopulation, MPP, FemalePopulation, FPP, TotalPopulation" << endl;
    for (int year = 2010; year <= 2015; year++)
    {
        output << getStat(ToString(year)) << endl;
    }
}
/*
 * Adds up BabyNameRanking to Year, MalePopulation, MPP, FemalePopulation, FPP, TotalPopulation
 * and outputs in to the stat.txt file.
 * @param year The file to be opened
 * @return string  A string consisting of Year, MalePopulation, MPP, FemalePopulation, FPP, TotalPopulation
 */
string getStat(string year) throw (runtime_error)
{
	string temp="./Names/Babynameranking" + year + ".txt";
    ifstream input(temp.c_str());
    if (input.fail())
    {
        throw runtime_error("File does not exist");
    }

    string rank, male, female, malepop, femalepop, line;

    int totalMale=0,totalFemale=0;
    getline(input, line);
    while (getline(input, line))
    {
    	istringstream iss(line);
    	if (!(iss >> rank >> male >> malepop >> female >> femalepop))
    		break;
    	// Read data to the end of file
    	cout<<rank <<" "<<male<<" "<<malepop<<" "<<female<<" "<<femalepop<<endl;
    	totalMale+=toInt(malepop);
    	totalFemale+=toInt(femalepop);
    }
    input.close();
    int total = totalMale+totalFemale;
    ostringstream oss;
    oss << year << ", " << totalMale << ", " << (roundf((((double)totalMale/total)*100)*100)/100)
    	<< "%, " << totalFemale << ", " <<( roundf((((double)totalFemale/total)*100)*100)/100)
		<< "%, " << total;
    return oss.str();
}

/*
 * Create two Name objects for each line of data (one for male, one
 * for female), and save them into the binary file named allNames.dat.
 * @param binaryOuput AllNames.dat file to be outputted to
 */
void combineFilesToBinary(ofstream& binaryOutput)
{
	string temp;
	for (int year = 2010; year <= 2015; year++)
	{
		temp="./Names/Babynameranking" + ToString(year) + ".txt";
		ifstream input(temp.c_str());
		if (input.fail())
		{
			cout << "File does not exist" << endl;
			cout << "Exit program" << endl;
			break ;
		}

		string male,female,malepop,femalepop,rank,line;
		getline(input, line);
    	while (getline(input, line))
    	{
    		//Breaks up line into 2 parts
    		istringstream iss(line);
    		if (!(iss >> rank >> male >> malepop >> female >> femalepop))
    			break;
			Name maleName(year, toInt(rank),male,toInt(malepop), 'M' );
			Name femaleName(year, toInt(rank),female, toInt(femalepop), 'F');

			binaryOutput.write(reinterpret_cast<char*>(&maleName), sizeof(Name));
			binaryOutput.write(reinterpret_cast<char*>(&femaleName), sizeof(Name));
		}
    	input.close();
	}
}

/*
 * Write a function named sort that sorts objects in AllNames.dat file. Then write the sorted
 * list into a binary file named sortedAllNames.dot.
 * @param binaryInput AllNames.dat file to be inputted from
 * @param binaryOutput sortedAllNames file to be outputted to
 */
void sort(ifstream& binaryInput, ofstream& binaryOutput)
{
/*
 	 Name names[2000];
 	 int i=0;
 	 int j;
 	 while(binaryInput>>names[i])
 	 {
 	 	 i++;
 	 }
 	 Name temp;
 	 for(i=0;i<1999;i++)
 	 {
 	 	 for(j=i+1;j<2000;j++)
 	 	 {
 	 	 	 if(names[i]<names[j])
 	 	 	 {
 	 	 	 	 temp=names[i];
 	 	 	 	 names[i]=names[j];
 	 	 	 	 names[j]=temp;
 	 	 	 }
 	 	 }
 	 }

 	 for(i=0;i<2000;i++)
 	 {
 	 	 binaryOutput<<names[i];
 	 }
*/

    vector<Name> names; // vector that stores names

    // read binaryInput>>name
    Name name;
   
    while(binaryInput.read(reinterpret_cast<char*>(&name), sizeof(Name)))
    {
        names.push_back(name);
    }

    //This should use the overloaded <,<=,>
    sort(names.begin(), names.end());

    // write binaryOutput << names[i]
    for (unsigned int i = 0; i < names.size(); i++)
    {
    	binaryOutput.write(reinterpret_cast<char*>(&names[i]), sizeof(Name));
    }

}
/*
 *Write a function named find20Populars that reads top 10 most popular and 10 least popular
 *names from sortedAllNames.dot binary file and writes them into a text file named
 *20Names.txt.
 *@param binaryInput sortedAllNames.dot to be retrieved from
 *@param output 20Names.txt The file to be written to in "Name, Gender, Frequency, Year, RankInYear"
 */
void find20Populars(ifstream& binaryInput, ofstream& output)
{
    output << "Name, Gender, Frequency, Year, RankInYear" << endl;

    int year,rank,frequency;
    string temp;
    char gender;
    Name name;
    for (int i = 0; i < 10; i++)
    {
    	binaryInput.read(reinterpret_cast<char*>(&year), sizeof(int));
    	binaryInput.read(reinterpret_cast<char*>(&rank), sizeof(int));
    	binaryInput.read(reinterpret_cast<char*>(&temp), temp.size());
    	binaryInput.read(reinterpret_cast<char*>(&frequency), sizeof(int));
    	binaryInput.read(reinterpret_cast<char*>(&gender), sizeof(char));

    	output << temp.c_str()<<','<< gender<<','<<frequency <<','<<year<<','<<rank <<endl;
    	cout<<temp.c_str()<<','<< gender<<','<<frequency <<','<<year<<','<<rank <<endl;

    }
    binaryInput.seekg(0, ios::end);
    for (int j = 0; j< 10; j++)
    {

       	binaryInput.read(reinterpret_cast<char*>(&year), sizeof(int));
       	binaryInput.read(reinterpret_cast<char*>(&rank), sizeof(int));
       	binaryInput.read(reinterpret_cast<char*>(&temp), temp.size());
       	binaryInput.read(reinterpret_cast<char*>(&frequency), sizeof(int));
       	binaryInput.read(reinterpret_cast<char*>(&gender), sizeof(char));

       	output << temp.c_str()<<','<< gender<<','<<frequency <<','<<year<<','<<rank <<endl;
       	cout<<temp.c_str()<<','<< gender<<','<<frequency <<','<<year<<','<<rank <<endl;

       	binaryInput.seekg(-(2*sizeof(Name)), ios::cur);
    }

}
/*-
 * Return an int from string
 * @param str A string to remove comma's
 * @return an int value
 */
int toInt(string str)
{
	removeStuff(str,',');
	return atoi(str.c_str());
}

/*
 * Removes comma's
 * @param str A string to be changed
 * @param character The char to be removed from string
 */
void removeStuff(string& str, char character)
{
	size_t pos;
	while((pos=str.find(character)) != string::npos )
	{
      str.erase(pos, 1);
	}
}

/*
 * Converts to string
 * @param val An int
 * @return a string value of the int
 */
string ToString(int val)
{
    stringstream stream;
    stream << val;
    return stream.str();
}
