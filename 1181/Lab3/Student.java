/** 
Filename: Student.java
Written by Arundeep Chohan
Written on Sept, 19, 2012
Course: CPSC 1181-001
Instructor:Hossein Darbandi

This program uses OOP to call multiple methods to set variables and give output without
asking for user input
*/
public class Student
{
   /**
	Initializes variables that get referenced
	*/
   private String name="DEFAULT";
   private String id="DEFAULT";
   private String addressComma=",";
   private Address Data = new Address();
   private double quiz=0;
   private double numOfScore =0;
   final static double MAX_GRADE =10;
   final static double MIN_GRADE =0; 

   
   /**
	Constructs class student with no parameters
	and initializes name and id
	*/   
   public Student()
   {
      this.id="No Id";
      this.name="No Name";
   }

   /** 
	Constructs class student with one parameter
	and initializes name and id
	@param name String obtained from user
	*/
   public Student(String name)
   {
      this.id="No Id";
      this.name=name;
   }

   /**
	Constructs class student with two parameters
	and initializes name and id
	@param name String obtained from user
	@param id String obtained form user
	*/
   public Student(String name,String id)
   {
      this.name=name;
      this.id=id;
   }
   
	/** 
	Constructs class student with three parameters
	and initializes name and id
	@param address String obtained from user
	@param name String obtained from user
	@param id String obtained from user
	*/
   public Student(String name,String id,String address)
   {
      this.name=name;
      this.id=id;
      correctAddress(address);
   }
	
   /**
	This method sets address to either empty
	or if it contains more than one comma sets variables to something else
	@param address obtained from user
	*/
   public void correctAddress(String address)
   {
      int i;
      String suiteNumber="",street="",city="",provice="",postalCode="";
      if(address.indexOf(addressComma)>=0)
      {
         String tokens[]=address.split(addressComma);
         for(i=0;i<tokens.length;i++)
         {
            switch(i)
            {
               case 0:
                  suiteNumber=tokens[i];
                  break;
               case 1:
                  street=tokens[i];
                  break;
               case 2:
                  city=tokens[i];
                  break;
               case 3:
                  provice=tokens[i];
                  break;
               case 4:
                  postalCode=tokens[i];
                  break;
               default:
                  System.out.println("What happened with the input");
                  break;
            }
         }
      }
            Data.set(suiteNumber,street,city,provice,postalCode);
      
   }
   
   /** 
	This method sets name to parameter called
	@param name obtained from user
	*/
   public void setName(String name)
   {
      this.name=name;
   }

   /**   
	This method sets id to parameter called
	@param id obtained from user
	*/
   public void setID(String id)
   {
      this.id=id;
   }

   /** 
	This method returns name
	@return String
	*/
   public String getName()
   {
      return this.name;
   }

   /** 
	This method returns id
	@return String
	*/
   public String getID()
   {
      return this.id;
   }

   /** 
	This method increments numOfScore and quiz by parameter called
	unless it is out of range
	@param quiz A double to increment quiz score
	*/
   public void addNewQuizScore(double quiz)
   { 
      if((quiz <=MAX_GRADE)&&(quiz>=MIN_GRADE))
      {
      this.quiz+=quiz;
      this.numOfScore+=1;
      }
   }

   /** 
	This method calculates and returns the average quiz score of the student
	@return double
	*/
   public double getAverageQuizScore()
   {
      if(this.numOfScore==0||this.quiz==0)
      {
         return 0;
      }
      return this.quiz/this.numOfScore;
   }

   /** 
	This method sets the information for address along with others
	@param suiteNumber String
	@param street String
	@param city String
	@param provice String
	@param postalCode String
	Postcondition:The user has to call with 5 parameters
	*/
   public void setAddress(String suiteNumber,String street,String city,String provice,String postalCode)
   {
      Data.set(suiteNumber,street,city,provice,postalCode);
   }

   /** This method returns the suiteNumber
	@return String
	*/
   public String getSuiteNumber()
   {
      return Data.getSuiteNumber();
   }

   /** This method returns the street
	@return String
	*/
   public String getStreet()
   {
      return Data.getStreet();
   }

   /** This method returns the city
	@return String
	*/
   public String getCity()
   {
      return Data.getCity();
   }

   /** This method returns the provice
	@return String
	*/
   public String getProvice()
   {
      return Data.getProvice();
   }

   /** This method returns the postal code
	@return String
	*/
   public String getPostalCode()
   {
      return Data.getPostalCode();
   }

   /** This method returns the address
	@return String
	*/
   public String getAddress()
   {
      return Data.getAddress();
   }
   
   /**
	This method returns the name,id and address 
	@return String
	*/
   public String toString()
   {
      return this.name+" "+this.id+" "+this.quiz+" "+Data.getAddress();
   }
}