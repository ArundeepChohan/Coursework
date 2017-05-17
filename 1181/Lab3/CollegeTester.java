/** 
Filename: CollegeTester.java
Written by Arundeep Chohan
Written on Sept, 24, 2012
Course: CPSC 1181-001
Instructor:Hossein Darbandi

This program tests the College class
*/
import java.util.*;
public class CollegeTester
{
	/**
	Initializes variables
	*/
   private static College Langara= new College();
   private static final String CONFIRMATION ="YES";
   private static final String ADD="ADD"; //– Add a new Student
   private static final String FIND="FIND"; //– Find a Student
   private static final String ADD_QUIZ ="ADDQUIZ"; //– Add a quiz score for a student
   private static final String FIND_HIGHEST="FINDHIGHEST"; //– Find a student with the highest quiz score
   private static final String DELETE="DELETE"; //– Delete a Student
   private static final String QUIT="QUIT"; //– Quit
	
   /**
	This program prompt user for input for action
	*/
   public static void main(String[]args)
   {
      System.out.println(ADD);
      System.out.println(FIND);
      System.out.println(ADD_QUIZ);
      System.out.println(FIND_HIGHEST);
      System.out.println(DELETE);
      System.out.println(QUIT);
      String command="",reply="";
      Scanner myInput = new Scanner(System.in);  
      boolean another = true;

      while (another)
      {
         System.out.println("Enter a command"); 
         command = myInput.nextLine();
         action(command.toUpperCase());
         System.out.println("Do you want to continue yes/no?"); 
         reply=myInput.nextLine();
         if((reply.toUpperCase()).equals(CONFIRMATION))
            another = true;
         else
            System.exit(0);
      }
   }
	
   /**
	This method calls the appropriate action based on the users input
	@param command User generated input
	*/
   private static void action (String command)  
   {
      if(command.equals(ADD))
         addStudent();
      else if(command.equals(FIND))
         find();
      else if (command.equals(ADD_QUIZ))
         addQuiz();
      else if (command.equals(FIND_HIGHEST))
         findHighest();
      else if (command.equals(DELETE))
         delete();
      else if (command.equals(QUIT))
         quit();
      else 
      {
         System.out.println("Bad input");
      }
   } 
	
	/**
	This method calls addstudent to check if capable of adding a student
	*/
   private static void addStudent()
   {
      String name,id,address;
      Scanner myInput = new Scanner(System.in);  
      System.out.println("Enter student's name:");
      name =myInput.nextLine();
      System.out.println("Enter student's id:");
      id =myInput.nextLine();
      System.out.println("Enter student's address:");
      address=myInput.nextLine();
      if(Langara.addStudent(name,id,address)==true)
      {
         Langara.students.add(new Student(name,id,address));
         System.out.println("A Student added to the College directory");
      }
      else
         System.out.println("Failure to add student");
   }
	
	/**
	This method calls findStudent to check if capable of finding a student
	*/
   private static void find()
   {
      String id="";
      Scanner myInput = new Scanner(System.in);  
      System.out.println("Enter student's id:");
      id =myInput.nextLine();
      Student find=Langara.findStudent(id);
      if(find!=null)
      {
            System.out.println("Name Id Average Address");
            System.out.println(find.toString());
	   }
         else
            System.out.println("No matches were found");
      
   }
	
   /**
	This method adds a quizscore given a student's id
	*/
   private static void addQuiz()
   {
      double quizScore;
      String id="";
      Scanner myInput = new Scanner(System.in); 
      System.out.println("Enter student's id:");
      id = myInput.nextLine();
      System.out.println("Enter student's quiz score:");   
      quizScore = myInput.nextDouble();
     
      Langara.addQuizScore(id,quizScore);
   }
   
   /**
	This method calls a method which finds the highest grade in the group of students and 
	get the object of student
	*/
   private static void findHighest()
   {
      Student findHighest=Langara.findHighest();
      if(findHighest!=null)
      {
         System.out.println("Name Id Average Address");
         System.out.println(findHighest.toString());
      }
      else
         System.out.println("No matches were found");
  
   }
	
   /**
	This method deletes a student according to the user inputted id
	*/
   private static void delete()
   {
      String id="";
      Scanner myInput = new Scanner(System.in);  
      System.out.println("Enter student's id:");
      id=myInput.nextLine();
      int i;
      for(i=0;i<Langara.students.size();i++)
      {
         if(Langara.deleteStudent(Langara.students.get(i),Langara.students.get(i).getID())==true)
         {
            System.out.println("Student removed");
            Langara.students.remove(i);
         }
      }
   }
	
   /**
	This method clears and quit the program
	*/
   private static void quit()
   {
   Langara.quit();
   }
}
