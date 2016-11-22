package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.DataproviderClass;


public class IPTest1 extends BaseTest{
	@BeforeTest
	public void setUp() {
    	System.out.println("Ideation Platform - Start test!");
    	System.out.println("--------------------------------------------");
    	//navigatetoIdeation ();
    	navigatetoIdeationICBAZ();
    	//ResizeBrowserWindow(760, 1280);
    	
    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Ideation Platform test!");
    }
   	
/*    @Test(dataProvider="AZSA1",dataProviderClass=DataproviderClass.class)
    	public void CreateUsers(String uname, String pass) {
    	  	home=SignIn(uname,pass);
    		adm=home.navigatetoAdministration();
    		usr=adm.SelectUsersAdministration();
    		for (int i=81; i<131; i++) {
    		String un=users.getData(0, i, 0);
    		String fn=users.getData(0, i, 1);
    		String ln=users.getData(0, i, 2);
    		String em=users.getData(0, i, 3);
     		System.out.println(un+" "+fn+" "+ln+" "+em);
    		usr.CreateNewUser(un, fn, ln, em);
    		}
    	   
    	}*/
    
  /* @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void CreateNewCampaign(String uname, String pass) {
    	home=SignIn(uname,pass);
       //camp=home.ViewFirstCampaign();
    //	camp.ExportCampaign();
    	//delete campaign
    	//home.navigatetoHome();
    	camp=home.ViewFirstCampaign();
    	//camp.SubmitNewIdea("Idea for test automation tool", false);
    	//camp.SubmitNewIdea("Private idea for test automation tool", true);

   }*/
    
/*    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void RunIPTests2(String uname, String pass) {
    	home=SignIn(uname,pass);
    	camp=home.ViewCampaign(0);
   		camp.EditCampaign();
   		camp.SubmitCampaign();
     	//String s = home.GetHomeDashboardMyCampaigns();
    	//System.out.println("May Campaigns: "+s);
     	//home.navigatetoDashboard();
    	//home.SelectUserProfile();
    	//home.SelectLogout();
       	
    }*/
    
/*    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void FillNewCampaign(String uname, String pass) {
    	home=SignIn(uname,pass);
	    camp=home.ViewCampaign(0);
	    ide=camp.ViewIdea(0);
	    ide.SubmitComment("This is a comment for idea");
	    ide.DeleteComment(0);
	    ide=camp.SubmitNewIdea("WebDriver Test Automation",false );
	    String com1="This is a comment for idea";
	    ide.SubmitComment(com1);
	    ide.EditComment(0);
	    ide.DeleteComment(0);
	    ide.DeleteIdeaFromEdit();

	   ide.DeleteIdeaByMenu();  
	   ide.DeleteIdeaFromEdit();
	   ide.FollowIdea();
}*/
/*   @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void TestIdeationCircles(String uname, String pass) {
    	home=SignIn(uname,pass);
    	camp=home.ViewFirstCampaign();

         
   }*/
}