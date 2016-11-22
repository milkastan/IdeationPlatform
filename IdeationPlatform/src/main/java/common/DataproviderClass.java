package common;

import org.testng.annotations.DataProvider;


public class DataproviderClass {

	
	@DataProvider(name="Administrator")
	public  static Object[][]  getAdministrator(){
		return new Object[][] { 
				{"msicb2","123456"}  
			};
     }
	
	@DataProvider(name="CompanyCreator")
	public  static Object[][]  getCompanyCreator(){
		return new Object[][] { 
				{"icb2cc","123456"}  
			};
     }
	
	@DataProvider(name="User1")
	public  static Object[][]  getUser1(){
		return new Object[][] { 
				{"icb2user1","123456"}  
			};
     }
	
	@DataProvider(name="ExtUser1")
	public  static Object[][]  getExtUser1(){
		return new Object[][] { 
				{"extuser7","123456"}  
			};
     }
	//---------Users for Azure Test Environmen------------
	
	@DataProvider(name="AZSA1")
	public  static Object[][]  getAZSA1(){
		return new Object[][] { 
				{"saicbaz","123456"}  
			};
     }
	
	@DataProvider(name="AZCC1")
	public  static Object[][]  getAZCC1(){
		return new Object[][] { 
				{"icbazcc","123456"}  
			};
     }

	@DataProvider(name="AZUser1")
	public  static Object[][]  getAZUser1(){
		return new Object[][] { 
				{"icbazuser1","123456"}  
			};
     }
	
	@DataProvider(name="AZExtUser1")
	public  static Object[][]  getAZExtUser1(){
		return new Object[][] { 
				{"icbazextuser1","123456"}  
			};
     }
	

}
