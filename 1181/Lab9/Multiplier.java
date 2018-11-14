/** 
Filename: Multiplier.java
Written by Arundeep Chohan
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates class Multiplier which implements Evaluator
*/
public class Multiplier implements Evaluator
{
   public Multiplier()
   {
      sum=0;
   }
   public void sum(double input)
   {
      sum/**+*/=input; //not sure if you wanted to keep multiplying or just mutliply two numbers
   }
   public void calculate(double that) 
   {
      sum=sum*that;
   }
   public double evaluate( )
   {
      return sum;
   }
   private double sum;
}
