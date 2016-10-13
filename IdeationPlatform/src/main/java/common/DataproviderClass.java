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
	
}
