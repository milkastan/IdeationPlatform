package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Common;
import common.DataproviderClass;

public class ManageCampaign extends BaseTest{
	@BeforeTest
	public void setUp() {
		PrintCurrentDateTime();
    	System.out.println("Ideation Platform - Manage campaigns!");
    	System.out.println("--------------------------------------------");
    	navigatetoIdeation ();
    	//ResizeBrowserWindow(760, 1280);
    	
    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Ideation Platform test!");
    	PrintCurrentDateTime();
    	System.out.println("--------------------------------");
    }
    
    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void CreateNewCampaign(String uname, String pass) {
    	home=SignIn(uname,pass);
/*    	//Create new campaign
		camp=home.navigatetoCreateCampaign();
		//read campaign data from excel
		String cn=camps.getData(0, 1, 0);
        String cd=camps.getData(0, 1, 1);
        String sd = Common.GetCurrentDate();
        String ed=camps.getData(0, 1, 2);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        camp.AddCampaignAdministgrator("icb2cc@icb2.bg");
        //cir=camp.FindUserstoCampaigClick();
        //cir.SelectCircletoCampaign("TestCircle");
        camp.PublishCampaign();
        //end of create new campaign
*/        
    	//View first campaign and follow campaign
    	camp=home.ViewFirstCampaign();
       //Follow campaign
       String fc1 = camp.GetCampaignFollowers();
       camp.FollowCampaign();
       String fc2 = camp.GetCampaignFollowers();
       camp.CheckFollowCampaignNum(fc1, fc2);
       //Unfollow campaign  
       String fc3 = camp.GetCampaignFollowers();
       camp.UnfollowCampaign();
       String fc4 = camp.GetCampaignFollowers();
       camp.CheckFollowCampaignNum(fc3, fc4);
    	


        
    }
}
