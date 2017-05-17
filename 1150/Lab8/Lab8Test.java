/** readArray and leftRotate methods  */
import java.util.Scanner;
public class Lab8Test{
	public static void main(String[] args){
		
		// test cases
		// Note that we assumed that we already know how many numbers are in each test case.
		int[] arr1 = new int [6];
		String str1 = "8 3 6 9 11 22";
		readArray(str1, arr1);
		leftRotate(arr1);
		printArray(arr1);
		
		int[] arr2 = new int [4];
		String str2 = "45 11 34 33";
		readArray(str2, arr2);
		leftRotate(arr2);
		printArray(arr2);
		
		int[] arr3 = new int [1];
		String str3 = "21";
		readArray(str3, arr3);
		leftRotate(arr3);
		printArray(arr3);
	
	}

	/** read integer numbers from string, str, and store them in arr
      @param str: string that holds integer values
	@param arr, the array the numbers will be stored in
      */
	public static void readArray (String str, int[] arr) 
   {
		// Your code goes here
		int i,j=0;

      String[] str2;
      str2 = str.split(" ");

      for(i = 0;i < str2.length;i++)
		{
         arr[j]= Integer.parseInt(str2[i]);
         j++;
      }
		
	}
    
	/** left rotates the given array one element  
      @param arr: array of integers
      */
	public static void leftRotate (int[] arr)
   {
		// your code goes here
		int temp,i;
      if(arr.length!=0)
      {
         temp = arr[0];
         for(i = 0;i< arr.length-1;i++)
         {
            arr[i]=arr[i+1];
         }
		   arr[i]=temp;
      }
	}
	
	 
	/** Prints elements of the arrayin a single line seperated by one space 
        @param arr: array of integers
        */
	public static void printArray (int[] arr)
   {
		// your code goes here
		int i;
      for(i = 0; i< arr.length;i++)
		{
         System.out.print(arr[i]+" ");
      }  
      
      System.out.println("\n-----------");
	}
	    
}    
