/** Test program for lab quiz 9 */
import java.util.*;
public class Lab9Test{
	public static void main(String[] args){
		
		// test cases
		
		String[] arr1 = {"this is a test", "another test", "and more"};
		System.out.println(countSymbol(arr1,'t'));
		System.out.println(countSymbol(arr1,' '));
      System.out.println(countSymbol(arr1,'v'));
		
      String[] arr2 = {"", "another test", " "};
		System.out.println(countSymbol(arr2,'o'));
		System.out.println(countSymbol(arr2,'r'));
        
	
	}

	/** count number of times character x appears in string
      @param str : string 
	@param x : the character should be counted
      @return number of times x appears in str
      */
	public static int countSymbol(String str, char x) 
   {
      // Your code goes here
      int i;
      int count = 0;
      for(i=0;i<str.length();i++)
      {
         if(str.charAt(i)==x)
         {
            count++;
         }
      }
      return count;
		   
	}

   /** count number of times character x appears in string
      @param arr : array of String
	@param x : the character should be counted
      @return number of times x appears in the arr
      */    
    public static int countSymbol(String[] arr, char x) 
   {
      // Your code goes here
      int i;
      int count = 0;
      for(i=0;i<arr.length;i++)
      {
         count+=countSymbol(arr[i],x);
      }
         return count;
	}
}    
