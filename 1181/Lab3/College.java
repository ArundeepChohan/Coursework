/** 
Filename: College.java
Written by Arundeep Chohan
Course: CPSC 1181-001
Instructor:Hossein Darbandi

Develop a program that stores the College’s Student’s information. The program should support the following operations.
Adding a new student to the college.
Looking up an existing student.
Adding a quiz score (assume that the quiz scores are always out of 10).
Finding a student with the college’s highest quiz average.
Deleting students from the college.
*/
import java.util.*;
public class College
{
   /*
	Intializing variables 
	*/
   ArrayList<Student>students = new ArrayList<Student>();
   private static final int IDSIZE =8;
	
   /**
	Constructor class
	*/
   public College()
   {
      
   }
 
   /**
	This method checks if the student is already in the arraylist and returns a boolean
	@param name obtained from user
	@param id obtained from user
	@param address obtained from user
	*/
   public boolean addStudent(String name,String id,String address)
   {
      if(id.length()!=IDSIZE)
         return false;
      for(Student e:students)
      {
         if((name.equals(e.getName()))&&(id.equals(e.getID()))&&(address.equals(e.getAddress())))
         {
            return false;
         }
      }
      return true;
         
   }
	
   /** 
	This method returns a reference to a student
	@param id obtained from user
	@return Object/null
	*/
   public Student findStudent(String id)
   {
      if(id.length()!=IDSIZE)
         return null;
      if(students.isEmpty())
         return null;
      for(Student e:students)
      {
         if (e.getID().equals(id))
         {
            return e;
         }
      }
      return null; 
   }
	
   /** 
	This method adds a quiz score to a student given his/her student ID
	@param id obtained from user
	@param quiz obtained from user
	*/
   public void addQuizScore(String id,double quiz)
   {  
      
      String check="";
      if(id.length()==IDSIZE)
      {
         for(Student e:students)
         {
            check=e.getID();
            if(id.equals(check))
            {
               System.out.println("Score added");
               e.addNewQuizScore(quiz);
            }
         }
      }
   }

   /**
	This method returns a reference of the student with the highest average
	@return bestStudent object of student with highest grade
	*/
   public Student findHighest()
   {
      if(students.isEmpty())
         return null;
      Student bestStudent = students.get(0);
      for(Student e:students)
      {
         if(e.getAverageQuizScore()>bestStudent.getAverageQuizScore())
         {  
            bestStudent=e;
         }
      }
       return bestStudent;
   }

   /**
	This method deletes a student from the list given his/her student ID
	@param s object in students to compare id
	@param id obtained from user
	*/
   public boolean deleteStudent(Student s,String id)
   {
      if(id.length()!=IDSIZE)
         return false;
      Scanner myInput = new Scanner(System.in);  
      final String confirmation ="YES";
      String reply="";
      if(s.getID().equals(id)) 
      {  
         System.out.println(s.getName()+'\n'+
         ":Delete student yes/no?");
         reply=myInput.nextLine();
         if((reply.toUpperCase()).equals(confirmation))
         {
            return true;
            
         }
      }
            return false;
   }
   
   /**
	This method clears the arrayList students and exits the program
	*/
   public void quit()
   {
      students.clear();
      System.exit(0);
   }
}
