/**
Filename: Lab7.java
Written by<Arundeep Chohan>
Contact: arundeepchohan2009@hotmail.com
Written on<Oct, 22, 2013>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program deals with various applications with arrays.
*/
import java.util.*;
public class Lab7
{
   public static void main(String[] args) 
   {
      int[] arrItem1 = new int[10];
      int[] arrItem4 = new int[arrItem1.length];
      int[] arrItem5 = new int [50];
      char[] arrItem7 = new char[256];
      int size;

      initialize(arrItem1);      // Item 1
      
      printArray(arrItem1);      // Item 2
      
      reverseArray(arrItem1);    // Item 3
      printArray(arrItem1);
    
      sumArray(arrItem1,arrItem4);  // Item 4
      printArray(arrItem4);
    
      initialize(arrItem5, 10, 20);   // Item 5
      printArray(arrItem5);
      
      countArray(arrItem5);    // Item 6
      
      size = readArray(arrItem7);  // item 7
      System.out.println("Size is: "+size);
      
      printOneInLine(arrItem7,size);  // item 8

   }
   
   /**
      Method initialize takes an array of integers and initialize each element with a random number between 1 and 10. 
      @param arr :An integer array
      */
   public static void initialize(int[] arr)
   {
      int i;
      int low = 1, high = 10;
      
      for(i = 0;i < arr.length;i++)
      {
         arr[i] = getRandom(low,high);//gets random value between low and high
      }
   }
   
   /**
      Method initialize is an overloading method which initializes each elements of the array to a random number between downLimit and upLimit.
      @param arr :An integer array
      @param low :The minimum value in the array
      @param high :The maximum value in the array
      */
   public static void initialize(int[] arr, int low,int high)
   {
      int i;
      
      for(i = 0;i < arr.length;i++)
      {
         arr[i] = getRandom(low,high);//gets random value between low and high
      }
   }
   
   /**
      Method getRandom returns a random value between low and high
      @param low :The minimum value in the array
      @param high :The maximum value in the array
      @return A random integer value between low and high
      */
   public static int getRandom(int low, int high)
   {
      return (int)(Math.random()*(high - low + 1))+low;
   }
   
   /**
      Method printArray takes an array of integers and prints the contents of the array one element in each line.
      @param arr :An integer array
      */
   public static void printArray(int[] arr)
   {
      int i;
      
      for(i = 0;i < arr.length;i++)
      {
         System.out.println(arr[i]);
      }
      System.out.println("\n-----------");
   }
   
   /**
      Method reverseArray reverses contents of a given array of integers. 
      @param arr :An integer array
      */
   public static void reverseArray(int[] arr)
   {
      int i,temp;
      /*
            Goes to half and reverses the the two ends of the array
            1. {1,2,3,4,5}
               {5,2,3,4,1}
            2.{5,2,3,4,1}
               {5,4,3,2,1}
            */
      for(i = 0 ;i < arr.length/2;i++)
      {
         temp = arr[i];
         arr[i] = arr[arr.length-1-i];
         arr[arr.length-1-i] = temp;
      }
   }
   
   /**
      Method sumArray sums elements of arr and places them into arr2.
      @param arr :An integer array
      @param arr2 :Sumed up elements of arr
      */
   public static void sumArray(int[] arr, int[] arr2)
   {
      int sum = 0;
      int i;
      
      for(i = 0;i < arr.length;i++)
      {
         sum+=arr[i];
         arr2[i] = sum;
      }
   }
   
   /**
      Method countArray counts the occurence of each number in the array and prints the result.
      @param arr :An integer array
      */
   public static void countArray(int[] arr)
   {
      int low, high, i;
      int [] count;
      
      if(arr.length != 0 )
      {
         high = findMax(arr);
         low = findLow(arr);
         count = new int [high - low +1];
         /*
                  This increments counter based on number in array.
                  */
         for(i = 0;i< arr.length;i++)
         {
            count[arr[i]-low]+=1;
         }
      
         for(i = 0; i < count.length;i++)
         {
            if(count[i] > 0)
               System.out.println((i + low) + " occurs = " +count[i]+" times.");
         }
         System.out.println("\n-----------");
      }
      else
      {
         System.out.println("There are no values in the array.");
         System.out.println("\n-----------");
      }
   }
   
   /**
      Method findMax finds and returns the maximum integer value in the array.
      @param arr :An integer array
      @return high :The maximum value in the array
      */
   public static int findMax(int[] arr)
   {
      int i;
      int high = arr[0];
      
      for(i = 0;i < arr.length;i++)
      {
         if(arr[i] > high)
            high = arr[i];
      }
      
      return high;
   }
   
   /**
      Method findLow finds and returns the minimum integer value in the array.
      @param arr :An integer array
      @return low :The minimum value in the array
      */
   public static int findLow(int[] arr)
   {
      int i;
      int low = arr[0];
      
      for(i = 0;i < arr.length;i++)
      {
         if(arr[i] < low)
            low = arr[i];
      }
      return low;
   }
   
   /**
      Method readArray stores a message in a character array of size 256 and returns the numbers of characters stored in the array.
      @param arr :An array of characters
      @return i :The number of characters stored
      */
   public static int readArray(char[] arr)
   {
      int i;
      char[] input = myInput();
      for(i = 0;i < input.length && i < arr.length;i++)//goes to size 256 max or to length of message
      {
         arr[i] = input[i];
      }
      return i;
   }
   
   /** 
      Method myInput reads a line of message from keyboard and returns it as an array of char
      @return Array of characters 
      */
   public static char[] myInput()
   {
      String message;
      System.out.print("Input : ");
      Scanner input = new Scanner(System.in);
      message = input.nextLine();// Read a line of message
      
      return message.toCharArray();
   } 
   
   /**
      Method printOneInLine prints out each word of the message in a line.
      @param arr :An array of characters
      @param size :The size of the array
      */
   public static void printOneInLine(char[] arr,int size)
   {
      int i;
      for(i = 0; i < size; i++)
      {
         if(arr[i]>(char)32)
            System.out.print((char)arr[i]);
         else
            System.out.println("");
      }
      
      System.out.println("\n-----------");
   }
}