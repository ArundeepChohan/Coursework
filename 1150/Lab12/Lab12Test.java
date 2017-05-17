
/** tests recursive method   */
public class Lab12Test
{
	public static void main (String[] args) 
   {
      //Test Cases
      myMethod(6);
      System.out.println("----------");
      myMethod(1);	
      System.out.println("----------");
      myMethod(-1);	
      
   }

	/** Prints numbers from n to 1, one number each number in a line using recursion 
             without using any looping mechanisim.
        @param n: a positive integer number
        */
	public static void myMethod( int n) 	
   {
      // your code goes here
      if(n > 0)
      {
         System.out.println(n);
         myMethod(n-1);
      }
	}
}    
