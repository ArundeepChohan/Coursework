/** 
Filename: TestCases.java
Written by Arundeep Chohan

Course: CPSC 1181-001
Instructor:Hossein Darbandi
This program is  used for testing
*/
class TestCases
{
  
//----------------------------------------------------
      //It is White's Turn
      System.out.println(p1.validateMove(0,0,1,1));//this is a black movement->false
      System.out.println(p1.validateMove(0,6,0,5));//this is a white movement->true
   
      //Testing if it can move to that piece
      p1.moveTo(0,6,0,5);//it should move a pawn(0,6) to (0,5)
      p1.print(g);
      p1.turn();
      
      //It is Black's Turn
      System.out.println(p1.validateMove(0,0,1,1));//this is a black movement->false
      System.out.println(p1.validateMove(0,6,0,5));//this is a white movement->false
      System.out.println(p1.validateMove(0,1,0,2));//this is a black movement->true
//----------------------------------------------------
}
