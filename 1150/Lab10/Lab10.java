/**
Filename: Lab10.java
Written by<Arundeep Chohan>
Course: Cpsc 1150-001
Instructor: Hossein Darbandi
Compiler: Jdk 1.7
Hardware: Intel Core 2

This program reads input from a file and sorts the input alphabetically,removes duplicates, and prints to another file.
*/
// Import packages
import java.io.*;
import java.util.*;
public class Lab10
{
	public static void main(String[] args)throws FileNotFoundException 
   {
		
		// Test cases
		String srcFileName = getInput();
      
      try
      {
         Scanner read = new Scanner(new File(srcFileName));
         read.close();
      }
      catch(FileNotFoundException ex)
      {
         System.out.println("File doesn't exist.");
         System.exit(0);
      }
      
      String dstFileName = getInput();
      
      final int size = getSize(srcFileName);
      String[] words = new String[size]; 
      
      store(words,srcFileName);
      words = removeDuplicates(words);
      
      writeFile(dstFileName,words);
	}
   /**
      Method getInput returns the file destination given from user input.
      @return message file destination.
      */
   public static String getInput()
   {
      
      String message = "";
      System.out.print("Input file destination: ");
      Scanner input = new Scanner(System.in);
      message = input.nextLine();// Read a line of message
      
      return message;
   }
   
   /**
      Method getSize returns the estimated size of array to collect the words.
      @param srcFileName The name of the file to be read.
      @return The estimated size of the array to collect the words.
      */
   public static int getSize(String srcFileName)throws FileNotFoundException 
   {
      int i = 0;
      File input = new File(srcFileName);
      Scanner read = new Scanner(new File(srcFileName));
      String temp ="";
      while(read.hasNext())
      {
         temp = read.next();
         i+=1;
      }
      
      read.close();
      
      return i;
   }
   
   /**
      Method store aphabetically sorts input, removes words(based on many factors) and converts to lower case.
      @param srcFileName The name of the file to be read.
      @param words An array to store words in.
      */
   public static void store(String [] words,String srcFileName) throws FileNotFoundException 
   {
      int i = 0,x = 0;
      
      String temp ="";
      String [] words2= new String[words.length];
      Scanner read = new Scanner(new File(srcFileName));
      
      while(read.hasNext())
      {
         temp = read.next();
         words2[i] = temp;
         i+=1;
      }
      read.close();
      
      for(i = 0;i < words2.length;i++)
      {
         words2[i] = words2[i].toLowerCase();//Converting to proper format
         words2[i] = words2[i].replaceAll("[.'\"?!():;,]", " ");
         words2[i] = words2[i].trim();
      
         if(isWord(words2[i]))//checks if it is a word
         {
            words[x]=words2[i];
            x++;
         }
      }
      
      alphSort(words);
   } 
   

   /**
      Method isWord checks for numbers or non hyphen special characters.
      @param temp2 A word to be checked.
      @return True/False indicating if it's a word.
      */
   public static boolean isWord(String temp2)
   {
      int i;
      
      for(i = 0;i < temp2.length();i++)
      {
         if((temp2.charAt(i) < 'a')||(temp2.charAt(i) > 'z'))
         {
            if(temp2.charAt(i)!='-')
            {
               return false;
            }
         }
      }
      
      return true;
   }
   
   /**
      Method writeFile writes words to a file.
      @param dstFileName The name of the file to be written to.
      @param words An array of stored words.
      */
   public static void writeFile(String dstFileName,String [] words) throws FileNotFoundException 
   {
      int i;
      PrintWriter write = new PrintWriter(new File(dstFileName));
      
      for(i = 0;(i < words.length)&&(words[i] != null);i++)
      {
         write.println(words[i]);
      }
      
      write.close();
   }
   
   /**
      Method alphSort sorts array of words alphabetically.
      (Selection sort from class with compareto)
      @param words An array of stored words.
      */
   public static void alphSort(String[] words)
   {
      int i,j;
      String temp = "";
      for(i = 0;(i < words.length-1)&&(words[i]!= null);i++)
      {
         for(j= i+1;(j < words.length)&&(words[j]!= null);j++ )
         {
            if(words[j].compareTo(words[i])<0)
            {
               temp = words[i];
               words[i] = words[j];
               words[j] = temp;
            }
         }
      }
   }
   
   /**
      Method removeDuplicates removes duplicates in array of words.
      (Selection sort from class with compareto)
      @param words An array of stored words.
      @return An array without duplicates.
      */
   public static String[] removeDuplicates(String [] words)
   {
      int i,j,x = 0;
      String [] words2 = new String[words.length];
      
      for(i = 0;(i < words.length-1)&&(words[i]!= null);i++)
      {
         for(j= i+1;(j < words.length)&&(words[j]!= null);j++ )
         {
            if(words[j].compareTo(words[i])==0)
            {
               words[j]="DUMMY";
            }
         }
      }
      
      for(i = 0;(i < words.length)&&(words[i]!= null) ;i++)
      {
            if(!words[i].equals("DUMMY"))
            {
               words2[x] = words[i];
               x++;
            }
         
      }
      
      return words2;
   }
}
