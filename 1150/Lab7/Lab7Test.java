/** tests printArray and average methods  */
public class Lab7Test{
	public static void main (String[] args){
		int[] arr1 = {5,3,8,3,5,3};
		int[] arr2 = {5,20,10,30,5,15,10};
		int[] arr3 = {8};
		
        // test cases
        printArray(arr1);
        System.out.println("average = "+ average(arr1));
        System.out.println();
        
        printArray(arr2);
        System.out.println("average = "+ average(arr2));
        System.out.println();

        printArray(arr3);
        System.out.println("average = "+ average(arr3));
        System.out.println();


        
    }

	/** Takes an array of integers and prints each element of the array in a line
        @param arr: array 
        */
	public static void printArray(int[] arr)
   {
      int i;
      // your code goes here
      for(i = 0;i< arr.length;i++)
      {
		   System.out.println(arr[i]);
      }
      
  
    }
    
	/** finds and returns average of an array of integers 
        @param arr: array 
        @return average of the array
        */

	public static double average(int[] arr)
   {
      // your code goes here
		double sum =0;
      int i;
      for(i=0;i< arr.length;i++)
      {
         sum+=arr[i];
      }
		
		return sum/arr.length; 
	}
	    
}    
