/** 
Filename: Evaluator.java
Written by Arundeep Chohan
Course:CPSC 1181-001
Instructor:Hossein Darbandi
This creates interface for Evaluator
*/
public interface Evaluator
{
   /**
      This method adds that to sum
      @param that Input to be added
      */
   void calculate( double that );
   /**
      @return sum
      */
   double evaluate( );
   /**
      This method adds input to sum
      @param input Input to be added
      */
   void sum(double input);
   
}
