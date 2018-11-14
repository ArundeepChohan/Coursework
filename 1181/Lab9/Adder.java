/** 
Filename: Adder.java
Written by Arundeep Chohan

Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates class Adder which implements Evaluator
*/
public class Adder implements Evaluator
{
   public Adder()
   {
      sum=0;
   }
   public void sum(double input)
   {
      sum/**+*/=input; //not sure if you wanted to keep adding or just add two numbers
   }
   public void calculate( double that ) 
   {
      sum=sum+that;
   }
   public double evaluate( )
   {
      return sum;
   }
   private double sum;
}
