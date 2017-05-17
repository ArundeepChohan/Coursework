public class Lab6Test{
	public static void main (String[] args){
		int test1 = 36498;
		int test2 = 473;
		int test3 = 81;
		int test4 = 1;
		
		// test cases 
		System.out.println(" test 1:  leftRotate ( "+test1+ " )= "+ leftRotate(test1));
		System.out.println(" test 2:  leftRotate ( "+test2+ " )= "+ leftRotate(test2));
		System.out.println(" test 3:  leftRotate ( "+test3+ " )= "+ leftRotate(test3));
		System.out.println(" test 4:  leftRotate ( "+test4+ " )= "+ leftRotate(test4));
	}

	/** Takes a positive integer number, n, as argument, and returns numer of digits of n*/
	public static  int numberOfDigits(int n){

		// your code goes here
		int count = 0;
      while (n >0)
		{
         count ++;
         n = n/10;
      }
      return count;

	}
    
	/** use numberOfDigitsI( int n), and left-rotate the given positive integer n, and returns the result. */

	public static int leftRotate(int n){
		
		// your code goes here
		int numOfD = numberOfDigits(n),ans;
      int quotient,remainder;
      quotient = (int)(n/Math.pow(10,numOfD-1));
      remainder = (int)(n-(quotient * Math.pow(10,numOfD-1)));
      ans = (remainder*10) + quotient;
      return ans;
		
	}
	    
}    
