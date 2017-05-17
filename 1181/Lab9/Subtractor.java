/** 
Filename: Subtractorjava
Written by Arundeep Chohan
Written on Nov,13,2012
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates class Subtractor which implements Evaluator
*/
public class Subtractor implements Evaluator
{
   public Subtractor()
   {
      sum=0;
   }
   public void sum(double input)
   {
    sum/**+*/=input; //not sure if you wanted to keep subtracting or just subtract two numbers
   }
   public void calculate(double that ) 
   {
      sum=sum-that;
   }
   public double evaluate( )
   {
      return sum;
   }
   private double sum;
}