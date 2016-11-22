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
    	System.out.println("Finished Manage Campaigns test!");
    	PrintCurrentDateTime();
    	System.out.println("--------------------------------");
    }
    
    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void TestManageCampaigns(String uname, String pass) {
    	home=SignIn(uname,pass);
    	//delete campaign
    	camp=home.ViewFirstCampaign();
    	camp.DeleteCampaign();
    	//Create new campaign
		camp=home.navigatetoCreateCampaign();
		//read campaign data from excel
		String cn=camps.getData(0, 1, 0);
        String cd=camps.getData(0, 1, 1);
        String sd = Common.GetCurrentDate();
        String ed=camps.getData(0, 1, 2);
        System.out.println("End Date:"+ed);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        camp.AddCampaignAdministgrator("icb2cc@icb2.bg");
        //cir=camp.FindUserstoCampaigClick();
        //cir.SelectCircletoCampaign("TestCircle");
        camp.PublishCampaign();
        //end of create new campaign
        //Edit campaign - menu from Actions View campaing page
    	camp=home.ViewFirstCampaign();
    	camp.EditCampaign();  
      	
    	//Follow campaign - Actions commands
       String fc1 = camp.GetCampaignFollowers();
       camp.FollowCampaign();
       String fc2 = camp.GetCampaignFollowers();
       camp.AssertIncreatingFollowCampaign(fc1, fc2);
       //Unfollow campaign  
       String fc3 = camp.GetCampaignFollowers();
       camp.UnfollowCampaign();
       String fc4 = camp.GetCampaignFollowers();
       camp.AssertDecreasingFollowCampaign(fc3, fc4);	   
      
       //Test Pin-Unpin Campaign
       home.navigatetoHome();    
       int cnum=home.GetNumberofCampaigns();
       String cname1 = home.GetCampaignNamebyNo(0);
 
   	  //Find campaign number by name and view campaign
        String cname2=home.GetCampaignNamebyNo(cnum-1);
   	    camp=home.ViewCampaignbyNo(cnum);
   	    //Pin campaign and check on the Home list
   	    //if pinned campaign is on the first position
   	    camp.PinCampaign();
   	    home.navigatetoHome();
        home.CheckFirstCampaignByName(cname2);
        home.CheckFirstCampaignPinned();
        //View first campaign and unpin
        //Campaign should not be on the first position
        camp=home.ViewFirstCampaign();
        camp.UnpinCampaign();
        home.navigatetoHome();
        home.CheckFirstCampaignByName(cname1);
        //share campaign
       	camp=home.ViewFirstCampaign();
    	camp.ShareCampaign();

    }
}
