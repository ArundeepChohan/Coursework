/**
Filename: Lab8.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Nov,4, 2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program reads two integer values up to 30 significant figures and prints
out the addition of those two values.

(Bonus)This part prints out the multiplication values of those two values.
*/
import java.util.*;
public class Lab8
{
   final static int MAXIMUM = 30;
   public static void main(String[] args)
   {
      int [] num1 = getInput();//Getting input
      int [] num2 = getInput();
      
      int [] addition;
      int [] multiplication;
      
      int largerSize,i;
      String temp="",temp2="",formattedNum1="",formattedNum2="",formattedAddition="",formattedMultiplication="";
      
      if(num1.length > num2.length)
      {
         largerSize = num1.length;
      }
      else
      {
         largerSize = num2.length;
      }
      
      
      for(i = 0;i<((largerSize+1)+((largerSize+1-1)/3));i++)
      {
         temp+="-";
      }
      formattedNum1 = format(num1,largerSize,largerSize+1);//Formatting for proper output(only for addition)
      formattedNum2 = format(num2,largerSize,largerSize+1);
      addition = new int[largerSize+1];//Addition portion of the lab
      add(num1,num2,addition);
      formattedAddition = format(addition,largerSize,largerSize+1);
      printTable(formattedNum1,formattedNum2,"+",temp,formattedAddition);
      
      for(i = 0;i<((num1.length+num2.length)+(((num1.length+num2.length)-1)/3));i++)
      {
         temp2+="-";
      }
      formattedNum1 = format(num1,largerSize,(num1.length+num2.length));//Formatting for proper output(only for multiplication)
      formattedNum2 = format(num2,largerSize,(num1.length+num2.length));
      multiplication = new int[num1.length + num2.length];//Multiplication portion of the lab(Bonus)
      multiply(num1,num2,multiplication);
      formattedMultiplication = format(multiplication,largerSize,(num1.length+num2.length));
      printTable(formattedNum1,formattedNum2,"*",temp2,formattedMultiplication);
      
   }
   
   /**
   Method getInput returns the integer array from a line of message with values between(0-9).
   @return numbers An integer array(0-9)from a line of message.
   */
   public static int[] getInput()
   {
      int i,j = 0,size;
      char[] message;
      int[] numbers;
      do
      {
         message = input();
         size = getSize(message);
      }
      while(size <= 0);
   
      if(size < MAXIMUM)//Stores up to 30 digits
         numbers = new int[size];
      else
         numbers = new int[MAXIMUM];
      
      for(i = 0;j < numbers.length && i < message.length;i++)//Stores up to 30 digits with characters from 0-9
      {
         if((message[i] >= '0')&&(message[i] <= '9'))
         {
            numbers[j] = message[i]-'0';
            j++;
         }
      }
      
      return numbers;
   }
   
   /**
   Method getSize returns the size of the array to store values in.
   @param array The line of characters read.
   @return count The size of the array.
   */
   public static int getSize(char[] array)
   {
      int i,count = 0;
      for(i = 0; i < array.length;i++)
      {
         if((array[i] >= '0') && (array[i] <= '9'))
         {
            count++;
         }
      }
      
      return count;
   }
   
   /** 
   Method input reads a line of message from keyboard and returns it as an array of char
   @return Array of characters 
   */
   public static char[] input()
   {
      String message;
      
      System.out.print("Input : ");
      Scanner input = new Scanner(System.in);
      message = input.nextLine();// Read a line of message
      
      return message.toCharArray();
   }  
   
   /**
   Method format displays appropriate number of spaces and commas
   @param array An integer array(0-9)from a line of message.
   @param largerSize The value which needs less commas.
   @param spaces The size for spaces needed. 
   @return String The proper formatted display of the array.    
   */
   public static String format(int [] array,int largerSize,int spaces)
   {
      int i,endOfZeroes = 0;
      String temp = "";
      
      i = 0;
      while((array[i] == 0)&&(i < array.length-1))//checks for proceeding zeroes
      {
         //temp=" "+temp;
         endOfZeroes++;
         i++;
      }
      
      for(i = endOfZeroes;i < (spaces - array.length);i++)//adds spaces for length
      {
         temp=" "+temp;
      }
      
      if(array.length < spaces)
      {
         for(i = endOfZeroes;i < (((spaces-1)/3)-((array.length-1)/3));i++)//calculates additional spaces for smaller number for commas
         {
            temp=" "+temp;
         }
      }
      
      for(i = endOfZeroes;i < array.length;i++)
      {
         temp+=array[i];
         if(((((array.length - i)-1)%3)==0)&&(i != (array.length-1)))//adds commas for every 3 numbers
         {
            temp= temp+",";
         }
      } 
            
      return temp;
   }
   
   
   /**
   Method add takes two integer values and adds them together.
   @param num1 An integer array(0-9)from a line of message.
   @param num2 An integer array(0-9)from a line of message.
   @param num3 The added values of both the arrays.
   */
   public static void add(int[] num1, int[] num2,int[] num3)
   {
      int i,j,k;
      
      i = num3.length-1;
      j = num1.length-1;
      k = num2.length-1;
      
      while(j >= 0 && k >= 0)
      {
         storeInArray(num1[j] + num2[k],i,num3);
         k-=1;
         j-=1;
         i-=1;
      }
      
      while(j >= 0)
      {
         storeInArray(num1[j],i,num3);
         j-=1;
         i-=1;
      }
     
      while(k >= 0)
      {
         storeInArray(num2[k],i,num3);
         k-=1;
         i-=1;
      }
   }
   
   /**
   Method storeInArray stores the values in the correct location and 
   adjusts already stored values.
   @param value The value to be stored in the array.
   @param position The location of where to store the value.
   @param num3 The array for which the values are to be stored.
   */
   public static void storeInArray(int value,int position,int[] num3)
   {
      if((value + num3[position]) >= 10)
      {
         num3[position-1] += ((value+num3[position])/10);
         num3[position] = ((value+num3[position])%10);
      }
      else 
      {
         num3[position]+=value;
      }
   }
   
   /**
   Method multiply takes two integer arrays and multiplies their values
   and stores the result into a new array.
   @param num1 An integer array(0-9)from a line of message.
   @param num2 An integer array(0-9)from a line of message.
   @param num3 The array for which the values are to be stored.
   */
   public static void multiply(int[] num1, int[] num2,int[] num3)
   {
      if(num1.length > num2.length)
      {
         mult(num1,num2,num3);
      }
      else
      {
         mult(num2,num1,num3);
      }
         
   }
   
   /**
   Method mult takes two integer arrays and multiplies their values
   and stores the result into a new array.
   @param num1 An integer array(0-9)from a line of message.
   @param num2 An integer array(0-9)from a line of message.
   @param num3 The array for which the values are to be stored.
   */
   public static void mult(int[] num1,int[] num2,int[] num3)
   {
      int i,j,k,power = 0,value = 0;
      for(k = num2.length-1;k >= 0;k--)
      {
         i = num3.length-1;
         for(j = num1.length-1;j>=0;j--)
         {
            value = num1[j] * num2[k];
            storeInArray(value,(i-power),num3);
            i-=1;
         }
         power+=1;
      }
   }
   
   /**
   Method printTable takes the properly formatted strings of the arrays 
   and displays them properly.
   @param formattedNum1 num1 properly formatted with spaces and commas.
   @param formattedNum2 num2 properly formatted with spaces and commas.
   @param sign The type of equation.
   @param temp The underline of the equation.
   @param answer The answer of formattedNum1 and formattedNum2 to the sign specified.
   */
   public static void printTable(String formattedNum1,String formattedNum2,String sign,String temp,String answer)
   {
      System.out.println(formattedNum1+sign);
      System.out.println(formattedNum2);
      System.out.println(temp);
      System.out.println(answer);
      System.out.println("");
   }
}