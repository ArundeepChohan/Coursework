import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/** tests readWrite method   */
public class Lab11Test{
	public static void main (String[] args) throws FileNotFoundException 
   {
		
		
        // test cases
        readWrite("input.txt", "output1.txt", "Java", "JAVA");
        readWrite("input.txt", "output2.txt", "is", "IS NOT");


        
    }

	/** Copies content of source file to destination file and changes all occurances of oldStr to new Str
        @param srcFileName: source file name
        @param dstFileName: destination file name
        @param oldStri  :old string that will be replace by new String
        @param newStr  :new string that will be substituded for the oldstr in the destination file
        */
	public static void readWrite(String srcFileName, String dstFileName, String oldStr, String newStr) throws FileNotFoundException 
   {
        // your code goes here
      
      Scanner read = new Scanner(new File(srcFileName));
      PrintWriter write = new PrintWriter(new File(dstFileName));
      
      String temp ="";
      while(read.hasNextLine())
      {
         temp = read.nextLine();
         temp = temp.replaceAll(oldStr,newStr);
         write.println(temp);
        
      }
      
      write.close();
      read.close();

   }
}    
