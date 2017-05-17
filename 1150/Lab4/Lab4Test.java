public class Lab4Test
{
   public static void main (String[] args)
   {
	   int n = 99;
	   double y=0;
	
      
	   // Your goes here
      for(int j = 1;j <= (n -2);j+=2)
      {
         for(int i =j+2;i<= j+2;i+=2)
         {
            y+= ((double)j)/((double)i);
            // in each iteration shows the values of n and y.    
            System.out.println(" n = "+ i + " , y =  " + y);
         }
      }
   }
}    
