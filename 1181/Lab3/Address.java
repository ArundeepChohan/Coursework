/** 
Filename: Address.java
Written by Arundeep Chohan
Written on Sept, 19, 2012
Course: CPSC 1181-001
Instructor:Hossein Darbandi

This program uses OOP to call multiple methods to set variables and give output without
asking for user input
*/
public class Address
{
   private String suiteNumber="DEFAULT SUITE ";
   private String street="DEFAULT STREET";
   private String city="DEFAULT CITY";
   private String provice="DEFAULT PROVICE";
   private String postalCode="DEFAULT POSTALCODE";
   private String address="DEFAULT ADDRESS";
 
   /** 
	Creates a constructor Address with no parameter
	*/
   public Address()
   { 
      this.suiteNumber="";
      this.street="";
      this.city="";
      this.provice="";
      this.postalCode="";
      this.address="";
   }

   /** 
	This method sets the variables with parameters called
	@param suiteNumber String
	@param street String
	@param city String
	@param provice String
	@param  postalCode String
	*/
   public void set(String suiteNumber,String street,String city,String provice,String postalCode)
   {
      this.suiteNumber=suiteNumber;
      this.street=street;
      this.city=city;
      this.provice=provice;
      this.postalCode=postalCode;
      this.address=suiteNumber+","+street+","+city+","+provice+","+postalCode;
   }

   /** 
	This method returns the suiteNumber
	@return String
	*/
   public String getSuiteNumber()
   {
      return this.suiteNumber;
   }
   
   /** This method returns the street
	@return String
	*/
   public String getStreet()
   {
      return this.street;
   }

   /** 
	This method returns the city
	@return String
	*/
   public String getCity()
   {
      return this.city;
   }

   /** 
	This method returns the provice
	@return String
	*/
   public String getProvice()
   {
      return this.provice;
   }

   /** 
	This method returns the postal code
	@return String
	*/
   public String getPostalCode()
   {
      return this.postalCode;
   }
   
   /**
	This method returns the address
	@return String
	*/
   public String getAddress()
   {
      return this.address;
   }
}