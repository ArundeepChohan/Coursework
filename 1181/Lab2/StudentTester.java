/** 
Filename: StudentTester.java
Written by Arundeep Chohan
Course:CPSC 1181-001
Instructor:Hossein Darbandi

A class to test the Student class and Address class
*/
public class StudentTester
{
   /** Tests the methods in Student class to be able to 
      retrieve information in the address class and be
      able to set new variables also
      */
   public static void main(String[]args)
   {
   //Testing student overload 
      Student Student1 = new Student();
      Student Student2 = new Student("Tom");
      Student Student3 = new Student("Arundeep","100201711");
      
   //Testing getID and getName
      System.out.println("Id is:"+Student1.getID()+" Name is:"+Student1.getName());
      System.out.println("Id is:"+Student2.getID()+" Name is:"+Student2.getName());
      System.out.println("Id is:"+Student3.getID()+" Name is:"+Student3.getName());
   
   //Testing setID, setName,getID,getName
      System.out.println();
      Student3.setID("Undercover");
      System.out.println("Id: "+Student3.getID());
      Student3.setName("Operative");
      System.out.println("Name: "+Student3.getName());
      
   //Testing getAverageQuizScore and addNewQuizScore
      System.out.println();
      System.out.println("My quiz score averages: "+Student3.getAverageQuizScore());
      Student3.addNewQuizScore(75);
      System.out.println("My quiz score averages: "+Student3.getAverageQuizScore());
      Student3.addNewQuizScore(101);
      System.out.println("My quiz score averages: "+Student3.getAverageQuizScore());
      System.out.println();
      
      System.out.println("My friends quiz score averages: "+Student2.getAverageQuizScore());
      Student2.addNewQuizScore(70);
      System.out.println("My friends quiz score averages: "+Student2.getAverageQuizScore());
      Student2.addNewQuizScore(80);
      System.out.println("My friends quiz score averages: "+Student2.getAverageQuizScore());
      System.out.println();
      
   //Testing setAddress and getting individual parts from the address
      System.out.println("The address of the student before setting address: "+ Student3.getAddress());
      System.out.println("Suite number:"+Student3.getSuiteNumber());
      System.out.println("The street is: "+Student3.getStreet());
      System.out.println("In the city of: "+Student3.getCity());
      System.out.println("In the province of: "+Student3.getProvice());
      System.out.println("The postal code is:"+Student3.getPostalCode());
      Student3.setAddress("555","The Slums","Vancouver","Bc","777777");
      System.out.println("The address of the student after: "+ Student3.getAddress());
      System.out.println("Suite number:"+Student3.getSuiteNumber());
      System.out.println("The street is: "+Student3.getStreet());
      System.out.println("In the city of: "+Student3.getCity());
      System.out.println("In the province of: "+Student3.getProvice());
      System.out.println("The postal code is:"+Student3.getPostalCode());
      System.out.println();
      
      System.out.println("The address of the student before setting address: "+ Student2.getAddress());
      System.out.println("Suite number:"+Student2.getSuiteNumber());
      System.out.println("The street is: "+Student2.getStreet());
      System.out.println("In the city of: "+Student2.getCity());
      System.out.println("In the province of: "+Student2.getProvice());
      System.out.println("The postal code is:"+Student2.getPostalCode());
      Student2.setAddress("1234","The Prairies","Regina","Sasketchewan","123456");
      System.out.println("The address of the student after: "+ Student2.getAddress());
      System.out.println("Suite number:"+Student2.getSuiteNumber());
      System.out.println("The street is: "+Student2.getStreet());
      System.out.println("In the city of: "+Student2.getCity());
      System.out.println("In the province of: "+Student2.getProvice());
      System.out.println("The postal code is:"+Student2.getPostalCode());
      
   //~ Testing Address class just checking if it can't be referred like this and it can't
   //~ Address();
      //~ System.out.println(Address.getSuiteNumber());
      //~ System.out.println(Address.getStreet());
      //~ System.out.println(Address.getCity());
      //~ System.out.println(Address.getProvice());
      //~ System.out.println(Address.getPostalCode());
      //~ System.out.println(Address.getAddress()); 
   }
}
