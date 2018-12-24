/
 *
 */

#include <iostream>
using namespace std;
int moves=0;

//Moves n disks from source to destination with tmp
void Honoi(int n, char source, char destination, char tmp) {
     if (n == 1) // Stopping condition
     {
          cout << "Move from " << source << " to " << destination << endl;
          moves++;

     }
     else {
            Honoi (n - 1, source, tmp, destination);
            Honoi (1, source, destination, tmp);
            Honoi (n - 1, tmp, destination, source);
      }
}
//Moves n disks from source to destination with tmp
void semiHonoi(int n, char even, char odd, char tmp) {

    	 if(n ==2)
    	 {
    		 cout << "Move from " << even<<" to " << tmp << endl;
    		 cout << "Move from " << odd<<" to " << tmp << endl;
    		 moves+=2;
    	 }
    	 else
    	 {
    		semiHonoi (n-2,even,odd,tmp);
            Honoi (n-2, tmp,odd,even);
            cout << "Move from " << even<<" to " << tmp << endl;
            moves++;
            Honoi(n-1,odd,tmp,even);

    	}

}
int main() {
      cout << "Enter number of disks: ";  // Read number of disks, n
      int n;
      cin >> n;
       // Finds the solution recursively
       cout << "The moves are: " << endl;
       semiHonoi(2*n, 'A', 'B', 'C');
       cout << moves<<endl;


       return 0;
}


