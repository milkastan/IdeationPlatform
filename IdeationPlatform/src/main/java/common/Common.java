package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.Browser;

public class Common {
	private static String filepath ="D:\\00-DISK-D\\WebDriver PXC Projects\\";
	private Date date;
	
	public Common() {
	}

     //click on element by JavascriptExecutor 
	//((JavascriptExecutor) Browser.driver).executeScript("arguments[0].click();", el);
	//Type in a Text Box by JSE
	//((JavascriptExecutor) Browser.driver).executeScript("document.getElementByID('elementid').value='test data'");

	
	public static void PrintConsoleToFile(String testResultFile) throws IOException {
		try {
		File file = new File(filepath+testResultFile); 
		FileOutputStream fis = new FileOutputStream(file);  
		PrintStream out = new PrintStream(fis);  
		System.setOut(out);
		} catch (FileNotFoundException e){
			System.out.println("Failed opening text file");
		}
    }
	
/*	 public void PrintCurrentDateTime(String format)
	 {
		 //Create object of SimpleDateFormat class and decide the format
         DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
         //get current date with Date()
         this.date = new Date();
         //Now format the date
         String date1 = dateFormat.format(date);
         //return string with current date and time             
         System.out.println("Current date&time: "+date1);
	 }*/
	
/*		public static void testTakesScreenshot() throws Exception {
			File scrFile = ((TakesScreenshot) Browser.driver)
			.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\00-DISK-D\\WebDriver PXC Projects\\CPDLocal\\main_page.png"));
		}
*/
		public static String GetCurrentDate(){
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy ");
			//get current date time with Date()
			 Date date = new Date();
			 // Now format the date
			 String date1= dateFormat.format(date);
			 System.out.println("Current date:"+date1);
			return date1;
		}
		
		public static String GetCurrentDateAZ(){
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
			//get current date time with Date()
			 Date date = new Date();
			 // Now format the date
			 String date1= dateFormat.format(date);
			 System.out.println("Current date:"+date1);
			return date1;
		}
		
		
}
