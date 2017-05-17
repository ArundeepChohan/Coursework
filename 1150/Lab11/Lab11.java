/*
 *Program Name: Lab11.java
 *Author:           Michael Currie 100206245
 *Co-Author:      Arundeep Chohan 100201711
 *Date:             November 19th, 2013
 *Course:           CPSC 1150-1
 *Instructor:     Hossein Darbandi
 *Compiler:         JDK 1.7
 *Hardware:        Intel Core 2 Duo
 *Contact:           mcurrie02@mylangara.bc.ca
 */
 
 /* This program takes a file of words and a file of phone numbers and matches each phone number
 to the possible words to be used in place of the phone number */
 import java.io.*;
 import java.util.*;
 public class Lab11 {
    public static void main(String[] args) throws FileNotFoundException{
       String[] wordsArray = new String[countWords("samplewords.txt")];
       String[] wordsAsNumbers = new String[countWords("samplewords.txt")];
       String[] telephoneNumbers = new String[countWords("telephone.txt")];
       fillArray("telephone.txt", telephoneNumbers);
       fillArray("samplewords.txt", wordsArray);
       wordsToNumbers(wordsArray, wordsAsNumbers);
       matchNumbersToWords(wordsArray, wordsAsNumbers, telephoneNumbers);
    }
    
    /** method countWords() takes a file and counts the number of words in the file 
          @param file: The file name in String form
          @return the number of words in the file     */
   
    public static int countWords(String file) throws FileNotFoundException {
       Scanner in = new Scanner(new File(file));
       int count = 0;
       String dump;
       while (in.hasNext()) {
          dump = in.next(); //Move the file pointer for every iteration of the loop
          count++;
       }
       in.close();
       return count;
    }
    
    /** method fillArray() takes a file name as a string and an array of the correct length to fill with the contents of the file.
             @param file: the name of the file to be read
             @param arr: an array with the proper size to receive all of the contents of the file    */
    
    public static void fillArray(String file, String[] arr) throws FileNotFoundException {
       Scanner in = new Scanner(new File(file));
       int i = 0;
       while (in.hasNextLine()) {
          arr[i] = in.nextLine();
          i += 1;
       }
       in.close();
    }
    
    /** method wordsToNumbers() takes an array of words and an array to fill with the phone digit representation of the words.
             @param arr: an array of words
             @param arr2: an array to be filled with the phone digit representation of the words from arr    */
    
    public static void wordsToNumbers(String[] arr, String [] arr2) {
       String tmp = "";
       for (int i = 0; i < arr.length; i++){
          for (int j = 0; j < arr[i].length();j++){
             tmp += characterToPhoneDigit(arr[i].charAt(j));
          }
          arr2[i] = tmp;
          tmp = "";
       }
    }
    
    /** method characterToPhoneDigit() takes a character and returns the phone digit representation of the character.
             @param character: a character value
             @return a string phone digit from 2-9.    */
    
    public static String characterToPhoneDigit(char character){
      String[] letters = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
      
      int i;
      for(i = 0;i< letters.length;i++)
      {
         if(letters[i].indexOf(character)!=-1)
            return Integer.toString(i+2);
      }
      return " ";
   
    }
    
    /** method matchNumbersToWords() takes arrays of words, numbers representing the previous words, and telephone numbers and matches occurances where the words match the telephone numbers and prints the occurances to the file "result.txt".
             @param words: an array of words
             @param wordsAsNumbers: an array of string numbers matching to the array of words
             @param numbers: an array of telephone numbers as String    */
    
    public static void matchNumbersToWords(String[] words, String[] wordsAsNumbers, String[] numbers) throws FileNotFoundException{
       PrintWriter out = new PrintWriter(new File("result.txt"));
       String number = "";
       
       for (int i = 0; i < numbers.length && numbers[i] != null; i++) {
          numbers[i] = numbers[i].substring(4, numbers[i].length());//remove the "604 " from the numbers
          out.println("Tel: " + numbers[i]);
          
          matchPhoneDigitsToWords(numbers[i], wordsAsNumbers, words, out); //Find all matches of the whole phone number
          matchPhoneDigitsToWords(numbers[i].substring(0, 3), wordsAsNumbers, words, out);//Find all matches of the first three numbers
          matchPhoneDigitsToWords(numbers[i].substring(3, numbers[i].length()), wordsAsNumbers, words, out);//Find all matches of the last four numbers
          out.println("--------------------");
       }
       
       //~ bonus(numbers,words,out);
       out.close();
    }
    
    /** method matchPhoneDigitsToWords() takes a String of numbers and sees if the telephone digits of an array of words match the String of numbers and prints the result to a file named "result.txt"
             @param number: a String of digits
             @param wordsAsNumbers: an array of Strings of digits matching up to the array words
             @param words: an array of words
             @param out: the PrintWriter linking to result.txt from matchNumbersToWords()    */
    
    public static void matchPhoneDigitsToWords(String number, String[] wordsAsNumbers, String[] words, PrintWriter out) {
       for (int j = 0; j < wordsAsNumbers.length; j++){
             if (number.equals(wordsAsNumbers[j])) {
               out.println(number + ":  " + words[j]);
            }
         } 
    }
   //~ public static void bonus(String[] numbers, String[] words,PrintWriter out)
   //~ {
       //~ //find all 7 lengthed combinations
      //~ ArrayList<String> masterList = phoneList(words);
      //~ for (int i = 0; i < numbers.length && numbers[i] != null; i++)
      //~ {
         //~ for(String s:masterList)
         //~ {
            //~ if(numbers[i].equals(s))
               //~ out.println(s);
         //~ }
      //~ }
   //~ }
   //~ public static void getM(String newStr,String[] words, int i, ArrayList<String> wordList)
   //~ {
      //~ if(newStr.length()==7)
      //~ {
        //~ wordList.add(newStr);
      //~ }
      //~ else if(newStr.length()>7 || i > words.length)
      //~ {
      //~ }
      //~ else
      //~ {
         
         //~ getM(newStr+newStr,words,i,wordList);
         //~ for(int j=0; j< words.length;j++)
         //~ {
            //~ getM(newStr+words[j],words,i+1,wordList);
         //~ }
      //~ }
         
   //~ }
   //~ public static ArrayList<String> phoneList(String [] words)
   //~ {
      //~ ArrayList<String> masterList = new ArrayList<String>();
      //~ masterList.add("");
      //~ for(int i =0; i < words.length;i++)
      //~ {
         //~ getM(words[i],words,i,masterList);
      //~ }
      //~ return masterList;
   //~ }
}
 