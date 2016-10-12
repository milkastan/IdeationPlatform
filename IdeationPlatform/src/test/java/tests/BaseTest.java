package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;
import common.ExcelDataConfig;
import common.GenerateData;


public class BaseTest {
	
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
    
    String		username="msicb2";
    String 		password="123456";
    
    ExcelDataConfig camps = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\IdeationPlatform\\campaigns.xlsx"); 	 
    ExcelDataConfig users = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\IdeationPlatform\\UsersDataExcel.xlsx"); 			 
	GenerateData gendata = new GenerateData();
	
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
	
}
