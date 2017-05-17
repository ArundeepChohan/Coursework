/**
Filename: Lab8.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Nov,4, 2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

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
      while (message.length() > MAXIMUM);
         
      if(message.length()>=3)
      {
         if((message.charAt(1) == '/' )||(message.charAt(2) == '/'))
         {
            date(message);
         
         }
         else 
         {
            System.out.println(format(message)+" is "+number(message));
         }
      }
      else
      {
         System.out.println(format(message)+" is "+number(message));
      }
   }
   
   /** 
      Method input reads a line of message from keyboard and returns it as an array of char
      @return Array of characters 
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
   public static String number(String message)
   {
      char[] number; 
      number = message.toCharArray();
      int i, value1,value2;
      int x = 0;
      String temp = ""; 
   
      String[] oneNumber = {"","one","two","three","four","five","six","seven","eight","nine"};
      String[] tenNumber = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
      String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
      String[] special = {"hundred","thousand","million","billion","trillion"};
    
      if((number.length==1) && (number[0] =='0'))
      {
				return "zero";
      }
      else
      {
         for(i = number.length-1; i >=0;i--)
         {
            
            if(x!=0)
            {
               temp=special[x]+" and, "+temp;
            }
            
            value1 = number[i] - '0';
            
            
            if((i-1) >= 0)
            {
               value2 =(number[i-1] -'0') * 10;
               temp = get10(value1,value2,oneNumber,tenNumber,tens)+" "+temp;
            }
            else
            {
               value2 = 0;
               temp = get10(value1,value2,oneNumber,tenNumber,tens)+" "+temp;
            }
            
            i-=2;
            if(i >=0)
            {
               if(((number.length-i)%3==0)&&((number[i] - '0')> 0))
               {
                  temp = oneNumber[(number[i] - '0')] +" "+special[0]+" "+temp;
               }
            }
            
            x+=1;
         }  
         
         return temp;
      }
   }

   /**
      Method format displays number in a proper format with appropriate commas and spaces.
      @param message :User inputted message up to 15 length.
      */
   public static String format(String message)
   {
      String temp = "";
      int i,endofZeroes=0;
      
      while((message.charAt(endofZeroes)=='0')&&(endofZeroes<(message.length()-1) ))
      {
         endofZeroes+=1;
      }
      
      for(i = endofZeroes;i<message.length();i++)
      {
         if((((message.length()-i)%3)==0) && (i!=0))
         {
            temp+=",";
         }
         temp+=message.charAt(i);
         
      }
      return temp;
   }
   
   /**
      Method get10 gets the values of 2 digits of the number.
      @param value1 :The value of the first digit.
      @param value2 :The value of the second digit.
      @param oneNumber :The values of the one digit numbers.
      @param tenNumber :The values of the two digit numbers.
      @param tens :The values of the two digit numbers.
      @return The string indicating the value 
      */
   public static String get10(int value1,int value2,String [] oneNumber,String [] tenNumber,String [] tens)
   {
   
      if((value1 + value2) >= 20)
		{
			return tens[((value2)/10)-2]+" "+oneNumber[value1];
		}
		else if(((value1 + value2)< 10) && ((value1 + value2)>=0))
		{
         return oneNumber[value1]+" ";
		}
      
      return tenNumber[(value1 + value2)%10]+" ";
   }
}