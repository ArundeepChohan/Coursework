 import java.io.*;
 import java.util.*;
public class Lab11Perm
{
   public static void main (String[] args)
   {
      String number="1234567";
      String[] words= {"a","b"};
      //find all 7 lengthed combinations
      ArrayList<String> masterList = phoneList(words);
      String temp="";
      ArrayList<String> res = new ArrayList<String>(); 
      for (int i = 0; i < masterList.size(); i++)
      {
         String item = masterList.get(i);
         System.out.println(item);
         if(item.equals(number) )
            res.add(item);
      }
      for (int i = 0; i < res.size(); i++)
      {
         String item =res.get(i);
         System.out.println(item);
      }
      
      
   }
   public static void getM(String newStr,String[] words, int i, ArrayList<String> wordList)
   {
      if(newStr.length()==7)
      {
        wordList.add(newStr);
      }
      else if(newStr.length()>7 || i > words.length-1)
      {
      }
      else
      {
         getM(newStr+words[i],words,i,wordList);
         
         for(int j=i+1; j< words.length;j++)
         {
            getM(newStr+words[j],words,j,wordList);
         }
 
      }
         
   }
   public static ArrayList<String> phoneList(String [] words)
   {
      ArrayList<String> masterList = new ArrayList<String>();
      masterList.add("");
      for(int i = 0; i < words.length;i++)
      {
         getM(words[i],words,i,masterList);
      }
      return masterList;
   }
   public static String convert(String word)
   {
      String temp="";
      for(int i =0;i< word.length();i++)
      {
         temp+=characterToPhoneDigit(word.charAt(i));
      }
      return temp;
   }
   
   /** 
      method characterToPhoneDigit() takes a character and returns the phone digit representation of the character.
      @param character: a character value
      @return a string phone digit from 2-9.    
      */
   public static String characterToPhoneDigit(char character)
   {
      String[] letters = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
      int i;
      for(i = 0;i< letters.length;i++)
      {
         if(letters[i].indexOf(character)!=-1)
            return Integer.toString(i+2);
      }
      return " ";
   }
   
}
