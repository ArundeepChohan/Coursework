/** Test program for lab auiz 10 */

// Import packages
import java.io.*;
import java.util.*;
public class Lab10Test{
	public static void main(String[] args)throws FileNotFoundException {
		
		// Test cases

		readWrite("test1.txt", "out1.txt");
		readWrite("test2.txt", "out2.txt");	
	
	}

	/** copies the content of the srcFileName into dstFileName, and add the average of the number to the end of the dstFileName
        @param srcFileName :  souce file name contains double numbers
	@param dstFileName : destination file name 
        */
	public static void readWrite(String srcFileName, String dstFileName) throws FileNotFoundException //throws Exception
   {
      // Your code goes here
      int i = 0;
      double sum = 0,average;
      String temp="";
      
      File input = new File(srcFileName);
      //~ if(!input.exists())
      //~ {
         //~ System.out.println("File doesn't exists");
         //~ System.exit(0);
      //~ }
      
      File output = new File(dstFileName);
      
      //~ if(output.exists())
      //~ {
         //~ System.out.println("File already exists");
         //~ System.exit(0);
      //~ }
      
      Scanner read = new Scanner(new File(srcFileName));
      PrintWriter write = new PrintWriter(new File(dstFileName));
         
      while(read.hasNext())
      {
         temp= read.nextLine();
         write.println(temp);
         sum+=Double.parseDouble(temp);
         i+=1;
      }
      
      average =sum/i;
      write.println(average);
	   read.close();
      write.close();
	}
}
