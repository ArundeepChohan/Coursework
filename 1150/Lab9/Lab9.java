/**
Filename: Lab9.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Instructor: Hossein Darbandi

This program either prints out a date or a number based on given input.
*/
import java.util.*;
public class Lab9
{
   final static int MAXIMUM = 15;
   public static void main(String[] args)
   {
	String message;
	do
	{
		message = input();
	}
	while(message.length() >MAXIMUM);
      
	if(message.length()>=3)
	{
		if((message.charAt(1) == '/' )||(message.charAt(2) == '/'))
		{
			date(message);
         
		}
		else 
		{
		number(message);
		}
	}
	else
	{
		number(message);
	}
	}
   
	/** 
	Method input reads a line of message from keyboard and returns it.
	@return String :A user inputted message.
	*/
   public static String input()
   {
      String message;
   
      System.out.print("Input : ");
      Scanner input = new Scanner(System.in);
      message = input.nextLine();// Read a line of message
      
      return message;
   } 
  /**
	Method date prints out the date in proper format.
	Date entered in this fashion (dd/mm/yyyy).
	@param message :User inputted message up to 15 length.
	*/
   public static void date(String message)
   {
      String[] months = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
      String[] time = message.split("/");
      
      System.out.println(months[Integer.parseInt(time[1])-1]+" "+time[0]+','+time[2]);
      
   }
  	
	/**
	Assume number is 15 length and entered is correct.
	@param message :User inputted message up to 15 length.
	*/
   public static void number(String array)
   {
      int loc = 0,j,specialLoc = 0,value1,value2;
      String temp=" ";
      String[] ones = {"one","two","three","four","five","six","seven","eight","nine"};
      String[] ten = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
      String[] tens = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
      String[] special = {"hundred","thousand","million","billion","trillion"};
      
      if(array.length() == 1)
		{
			
			if(array.charAt(0)=='0')
			{
				temp= "Zero";
			}
			else
			{
				temp= ones[array.charAt(0)-'0'];
			}
		}
		else
		{
			for(j = 1;j < array.length()+1;j++)
			{
				loc = j%3;
				value1 =array.charAt(array.length()-j)-'0';
         
				if(check(j,array) != 0)//proper special loc
				{
					temp = special[specialLoc]+", and "+temp;
				}
         
				if((array.length()-j-1)>=0)//gets 10's out
				{
					value2 =(array.charAt(array.length()-j-1)-'0')*10;
				}
				else
				{
					value2 =0;
				}
         
				if((((value1 + value2) > 10)&&((value1 + value2) < 20))&&(loc == 1))//gets 10's out
				{
					if((array.length() > 3)&& (j!=1))
					{
						temp = ten[value1 - 1]+" "+special[specialLoc]+" "+temp;
						j++;
					}
					else
					{
						temp = ten[value1 - 1]+" "+temp;
						j++;
					}
				}
				else
				{
					if(array.charAt(array.length()-j)!='0')
					{
						switch(loc)
						{
							case 1:
							{
								temp = ones[(array.charAt(array.length()-j))-'0'-1]+" "+temp;
								break;
							}
							case 2:
							{
								temp = tens[(array.charAt(array.length()-j))-'0'-1]+" "+temp;
								break;
							}
							case 0:
							{
								temp = special[0]+" "+temp;
								temp = ones[(array.charAt(array.length()-j))-'0'-1]+" "+temp;
								break;
							}
							default: 
						}
					}
				}
 
         if((loc%3) == 1)
         {
            specialLoc+=1;
         }
	}
	}
      System.out.println(format(array)+" is "+temp+".");
   }
   
   public static int check(int j, String array)
   {
      int i = j - 3,sum = 0;
      
      if(((j%3) == 1)&&(j > 1)&&(i >= 0))
      {
         return Integer.parseInt(array.substring(i,j));
      }
      
      return sum;
   }
   
	/**
	Method format displays appropriate number of spaces and commas.
	@param message :User inputted message up to 15 length.
	@return  temp :Proper formatted message up to 15 length.
	*/
   public static String format(String array)
   {
      String temp="";
      int i,endofZeroes=0;
      
      while((array.charAt(endofZeroes)=='0')&&(endofZeroes<(array.length()-1) ))
      {
         endofZeroes+=1;
      }
      
      for(i = endofZeroes;i<array.length();i++)
      {
         if((((array.length()-i)%3)==0) && (i!=0))
         {
            temp+=",";
         }
         temp+=array.charAt(i);
         
      }
      return temp;
   }
}
