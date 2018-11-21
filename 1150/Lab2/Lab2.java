//Filename: Lab2.java
//Written by<Arundeep Chohan>
//Course: Cpsc 1150-001
//Instructor: Hossein Darbandi
//Compiler: Jdk 1.7
//Hardware: Intel Core 2

/*
This program finds both x1, x2 values from a quadratic equation and display answers in proper format.
*/
public class Lab2
{
   public static void main (String[] args)
   {
      // Assigning & declaring variables
      double a = 0;
      double b = 2;
      double c = 1;
      double d;
      double x1;
      double x2;
      
      d = Math.pow(b,2) - 4*a*c;
      //Check to see values of x1, x2 exist and if answer simplifies to a linear expression
      if(a == 0)
      {
         if(b == 0)
         {
            System.out.println("x1 and x2 have non-real answers");
         }
         else
         {
            x1 =-(c/b);//simplified linear expression
            x2 =x1;
            System.out.println("x1 = " + x1);//Displays results
            System.out.println("x2 = " + x2);
         }
            
      }
	   else if (d >= 0) //Checks for real answers
      {
	      x1 = (- b + Math.sqrt(d))/ (2 * a);
	      x2 = (- b - Math.sqrt(d))/ (2 * a);
         System.out.println("x1 = " + x1);
         System.out.println("x2 = " + x2);

	   }
	   else 
      {
         System.out.println("x1 and x2 have non-real answers");
	   }
      
      System.out.println("a = " + a);
      System.out.println("b = " + b);
      System.out.println("c = " + c);
   }
}
