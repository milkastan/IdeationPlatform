package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;

import pages.*;

import common.ExcelDataConfig;
import common.GenerateData;


public class BaseTest {
	//Konica Azure
	
	//ICB Azure Environment
	String   azidpurl="https://ideatest.azurewebsites.net";
	//ICB Test environment
    String   idpurl="https://ideation.icb.bg/RLS/Login.aspx";
    String	 picturepath="D:\\00-DISK-D\\IdeationPlatform\\Pictures\\tn_DSC02492.jpg";
    String	 docpath="D:\\00-DISK-D\\IdeationPlatform\\Pictures\\Transition-9K-14K-2015-R4.pdf";
    
    Login   		 logon;
    Home	 		 home;
    Administration	 adm;
    Users			 usr;
    Dashboard		 dashb;
    Discussions		 dis;
    Circles		     cir;
    UserProfile		 prof;
    Campaigns		 camp;
    Ideas		     ide;
    
    ExcelDataConfig azcamps = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\IdeationLocal\\IdeationPlatform\\AZCampaigns.xlsx"); 
    ExcelDataConfig camps = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\IdeationLocal\\deationPlatform\\campaigns.xlsx"); 	 
    ExcelDataConfig users = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\IdeationLocal\\IdeationPlatform\\UsersData.xlsx");
       
   
	GenerateData gendata = new GenerateData();
	private Date date;
	
	public void RunBrowser() {
		//Browser.initFF();
		Browser.initChrome();
		//Browser.initIE();
		//Browser.initEdge();
		//Browser.initOpera();
		Browser.mainwin = Browser.driver.getWindowHandle();
	}
	
	public void navigatetoIdeation () {
		RunBrowser();
		Browser.driver.get(idpurl);
	}
	
	public void navigatetoIdeationICBAZ () {
		RunBrowser();
		Browser.driver.get(azidpurl);
	}
	
	public void ResizeBrowserWindow(int width, int height) {
		Browser.driver.manage().window().setSize(new Dimension(width, height));
	}
	
	protected Home SignIn(String usr, String pass) {
		logon = new Login();
		long start = System.currentTimeMillis();
		logon.successFullLogin(usr, pass);
		long end = System.currentTimeMillis();
		long time = end-start;
		System.out.println("**** Login time: "+time);
		return new Home();
	}

	public void Delay(long sec) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void QuitBrowser(){
		Browser.quit();
	}
	
	 public void PrintCurrentDateTime()
	 {
		 //Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //get current date with Date()
        this.date = new Date();
        
        //Now format the date
        String date1 = dateFormat.format(date);
        //return string with current date and time             
        System.out.println("Current date&time: "+date1);
	 }
	
}
