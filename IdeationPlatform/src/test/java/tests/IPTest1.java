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
    	navigatetoIdeation ();
    	//ResizeBrowserWindow(760, 1280);
    	
    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Ideation Platform test!");
    }
   	
  /*  	@Test
    	public void RunIdeationTest1 () {
    	  
    		home=SignIn(username,password);
    		adm=home.navigatetoAdministration();
    		usr=adm.ViewUsers();
    		for (int i=1; i<20; i++) {
    		String un=users.getData(0, i, 0);
    		String fn=users.getData(0, i, 1);
    		String ln=users.getData(0, i, 2);
    		String em=users.getData(0, i, 3);
    		usr.CreateNewUser(un, fn, ln, em);
    		}
    	}*/
    
/*    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void CreateNewCampaign(String uname, String pass) {
    	home=SignIn(uname,pass);
		camp=home.navigatetoCreateCampaign();
		String cn=camps.getData(0, 1, 0);
        String cd=camps.getData(0, 1, 1);
        String sd=camps.getData(0, 1, 2);
        String ed=camps.getData(0, 1, 3);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        cir=camp.FindUserstoCampaigClick();
        cir.SelectCirclesMenu();
        //cir.SelectCircletoCampaign("ICB2TestUserGroup");
        cir.SaveCircletoCampaign();
        camp.SubmitCampaign();
        camp.FillTitle();
		camp.EditCampaign();
    }*/
    
/*    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void RunIPTests(String uname, String pass) {
    	home=SignIn(uname,pass);
    	dashb=home.navigatetoDashboard();
    	dashb.FilterActiveCampaigns(1);
    	dashb.FilterActiveCampaigns(0);
    	dashb.FilterOrgCampaigns(1);
    	dashb.FilterOrgCampaigns(2);
    	dashb.FilterOrgCampaigns(3);
    	dashb.FilterOrgCampaigns(0);
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
    @Test(dataProvider="User1",dataProviderClass=DataproviderClass.class)
    public void TestIdeationCircles(String uname, String pass) {
    	home=SignIn(uname,pass);
    	home.navigatetoSocialNetworks(2);
    	prof=home.SelectUserProfile();
    	//home.CheckCampainsNumber();
    	//dashb=home.navigatetoDashboard();
    	//dashb.PrintDashboardCampaignsInfo();
    	//dashb.FilterOrgCampaigns(1);
    	//home.SelectLogout();
    	//adm=home.navigatetoAdministration();
    	//cir=adm.SelectManageCircles();
    	//cir.EditCircle("NewCircle");
    	//cir.DeleteCircle("NewCircle");
    	 //home.PrintAllMenuItems();
    	
    }
    
}