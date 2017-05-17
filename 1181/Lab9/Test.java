/** 
Filename: Test.java
Written by Arundeep Chohan
Written on Nov,13,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This program tests the evaluator class
*/
import java.util.*;
public class Test
{
   public static void main(String[]args)
   {
      double num1,num2;
      double that,sum;
         
      Scanner myInput = new Scanner(System.in);
     
      Adder a =new Adder();
      for(int i=0;i<10;i++)
      {
        
         System.out.println("Adding");
         //System.out.println("Enter the firstNum");  //Used for INPUT
         num1=/*myInput.nextDouble();*/i;
         //System.out.println("Enter the secondNum");
         num2=/*myInput.nextDouble();*/i;
            
         sum=num1;
         that=num2;
         a.sum(sum);
         a.calculate(that);
         
         System.out.println(a.evaluate());
         System.out.println("Added");
         
      }
      Multiplier x =new Multiplier();
      for(int i=0;i<10;i++)
      {
         System.out.println("Multiplying");  
         //System.out.println("Enter the firstNum");  //Used for INPUT
         num1=/*myInput.nextDouble();*/i;
         //System.out.println("Enter the secondNum");
         num2=/*myInput.nextDouble();*/i;
         
         sum=num1;
         that=num2;
         x.sum(sum);
         x.calculate(that);
         System.out.println(x.evaluate());
          System.out.println("Multiplied");
      }
      Subtractor s =new Subtractor();
      for(int i=0;i<10;i++)
      {
        
         System.out.println("Subtracting"); 
         //System.out.println("Enter the firstNum");  //Used for INPUT
         num1=/*myInput.nextDouble();*/i;
         //System.out.println("Enter the secondNum");
         num2=/*myInput.nextDouble();*/i;
            
         sum=num1;
         that=num2;
         s.sum(sum);
         
         System.out.println(s.evaluate());
         System.out.println("Subtracted");
      }
     
      //Evaluator n1,n2;
      //
   }
}