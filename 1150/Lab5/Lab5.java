/**
Filename: Lab5.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Oct, 10, 2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program prints all prime palindrome numbers less than an user inputted number(n).
*/
import java.util.*;
public class Lab5
{
	/** 
	Method main takes a value from method getInput and invokes method isPrimePalindrome with that value.
	@param args
      */
	public static void main (String[] args)
	{
		isPrimePalindrome(getInput());
	}
	
	/** 
	Method getInput prompts user for correct input and returns value to main.
	@return int :User inputted number greater than 0
	*/
	public static int getInput()
	{
		Scanner input = new Scanner(System.in);
		int n;
		do
		{
			System.out.println("Enter a positive integer number");
			n = input.nextInt();
		}
		while(n <= 0); //checks for negative integer input or zero 
		return n;
	}
	
	/** 
	Method isPrimePalindrome prints out all prime palindromes less than n.
	@param n :A user inputted number greater then 0
      @return none
	*/
	public static void isPrimePalindrome(int n)
	{
		//1, 2, 3, 5, 7, 11, 101 are all palindrome prime numbers less than 102. 
		int counter = 1;
      //Checks for prime palindromes less then n.
		while(counter < n)
		{
			if(is_Prime(counter) && is_Palindrome(counter))
			{
				System.out.print(counter +", ");
			}
			counter++;
		}
		
		if(n == 1)
			System.out.print("There are no values under 1");
		else
			System.out.print("are all palindrome prime numbers less than " +n );
	}
	
	/** 
	Method isPrime checks to see if number is a prime number.
	@param n :A number between user input and 1
	@return boolean :a value indicating if number is prime
	*/
	public static boolean is_Prime(int n)
	{
		//1, 2, 3, 5, 7, 11, 13, 17, 19, 23 are prime numbers.
		int counter = 2;
		//Checks if a prime number by transversing half the numbers and seeing if its divisible.
		while(counter <= (n/2))
		{
			if(n%counter == 0)
			{
				return false;
			}
			counter++;
		}
		
		return true;
	}
	
	/** 
	Method isPalindrome checks to see if number is a palindrome number.
	@param n :A number between user input and 1
	@return boolean : a value indicating if number is palindrome
	*/
	public static boolean is_Palindrome(int n)
	{
		//1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121 are palindrome numbers.
		int initial = n,reversed = 0;
		
		if(n < 10)
			return true;
		/*
		Reverses the number one digit at a time using temp variables.
		1000->0
		100->0
		10->0
		1->1
		*/
		while(initial > 0)
		{
			reversed = (reversed * 10) + (initial%10);
			initial = initial/10;
		}
		
		if(reversed == n)
			return true;
			
		return false;
	}
}