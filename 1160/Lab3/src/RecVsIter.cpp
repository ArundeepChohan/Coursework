/*
 *      This program displays the recursive/iterative methods of both the Fibonacci and Factorials.
 */
#include<iostream>

using namespace std;

int* iterFact(int);
void recFact(int);

unsigned long long iterFibo(int);
unsigned long long recFibo(int);

int multiply(int,int[],int);

const int MAX = 200;

int ITERF[MAX];
int RECF[MAX];

int main()
{
	char answer = 'Y';
	int n,i;
	do {
	cout << endl << endl;
	cout <<">===============( New RUN )===============<" <<endl;
	cout << "\nPlease enter an integer number: ";
	cin >> n;
	cout << endl;

	iterFact(n);
	cout << "Iterative Factorial(" << n <<") is ";
	for(i=MAX-1;i>=0;i--)
	{
		cout<<ITERF[i];
	}
	cout<<endl;

	// Initialize result
	RECF[MAX-1] = 1;

	recFact(n) ;
	cout << "Recursive Factorial(" << n <<") is " ;
	for(i=0;i<MAX;i++)
	{
		cout<<RECF[i];
	}
	cout<<endl;



	cout << "Iterative Fibonacci(" << n <<") is " << iterFibo(n) << endl;

	cout << "Recursive Fibonacci(" << n <<") is " << recFibo(n)  << endl;

	cout << "Do you want to continue? (Y/N)";

	//fill( RECF, RECF+ sizeof( RECF), 0 );
	fill( ITERF, ITERF+ sizeof( ITERF ), 0 );

	cin >> answer;
	} while (toupper(answer) == 'Y');
	cout << "The Program has ended gracefully!" ;
	return 0;
}

/*This multiples an array with factorials and returns the array recursively
 *@param n The number to go up to(How many factorial)
 *@return
 */
void recFact(int n)
{
	if (!n)
		return  ;
	int carry = 0;
	for (int i=MAX-1; i>=0; --i)
	{
	        RECF[i] = (RECF[i] * n) + carry;
	        carry = RECF[i]/10;
	        RECF[i] %= 10;
    }
	    recFact(n-1);

}


/*This multiples an array with factorials and returns the array iteratively
 *@param n The number to go up to(How many factorial)
 *@return ITERF  Array with iteratively values of factorial multiplied
 */
int * iterFact(int n)
{
	// Initialize result
	ITERF[0] = 1;
	int res_size = 1;

    // Apply simple factorial formula n! = 1 * 2 * 3 * 4...*n
	for (int i=2; i<=n; i++)
		res_size = multiply(i, ITERF, res_size);

	return ITERF;
}

/*
 *@param x The number to multiply
 *@param res[]  The array to store values
 *@param res_size The size of the array
 *@return res_size The new size of array
 */
int multiply(int x, int res[], int res_size)
{
	int carry = 0; // Initialize carry
	int prod;
	for (int i=0; i<res_size; i++)
	{
	   prod = res[i] * x + carry;        // One by one multiply n with individual digits of res[]
	   res[i] = prod % 10; // Store last digit of 'prod' in res[]
	   carry = prod/10; // Put rest in carry
	}
	while (carry)
	{            // Put carry in res and increase result size
	   res[res_size] = carry%10;
	   carry = carry/10;
	   res_size++;
	}

	// Put carry in res and increase result size
     while (carry)
     {
    	 res[res_size] = carry%10;
         carry = carry/10;
         res_size++;
     }

     return res_size;
 }

/* Returns the nth element recursively
 *@param n The element to retrieve
 *@return array[n]  The corresponding element
 */
unsigned long long recFibo(int n)
{
	if (n <= 2)
		return 1;

	return recFibo(n-1) + recFibo(n-2);
}

/* Returns the nth element iteratively
 *@param n The element to retrieve
 *@return array[n]  The corresponding element
 */
unsigned long long iterFibo(int n)
{

	unsigned long long array [100];
	array[0]=0;
	array[1]=1;

	if(n==0)
	{
		return array[1];
	}
	for(int i=2;i<(n+1);i++)
	{
		array[i]=array[i-1]+array[i-2];
	}

	for(int i =0;i<(n+1);i++)
	{
		cout<<array[i]<<" ";
	}
	cout<<endl;

	return array[n];
}
