public class Lab3Test{
    public static void main (String[] args){
	    
      int x =10;
      int n = 100;
      double y = 0;
	
      // Your code goes here
      int count = 1;
      while(n>= count)
      {
         y= y+(count/Math.pow(x,count));
         count++;
      }
      System.out.println("y= "+ y);
    
    }
}    
