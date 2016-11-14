package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Common;
import common.DataproviderClass;

public class AZManageCampaign extends BaseTest{
	@BeforeTest
	public void setUp() {
		PrintCurrentDateTime();
    	System.out.println("Ideation Platform Azure- Manage campaigns!");
    	System.out.println("--------------------------------------------");
    	navigatetoIdeationAZTest1 ();
    	//ResizeBrowserWindow(760, 1280);

    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Manage Campaigns test!");
    	PrintCurrentDateTime();
    	System.out.println("--------------------------------");
    }
    
    @Test(dataProvider="AZSA1",dataProviderClass=DataproviderClass.class)
    public void TestManageCampaigns(String uname, String pass) {
    	home=SignIn(uname,pass);
    	//delete campaign
    	camp=home.ViewFirstCampaign();
    	camp.DeleteCampaign();
    	//Create new campaign
    	for (int i=1;i<6;i++)  {
		camp=home.navigatetoCreateCampaign();
		//read campaign data from excel
		String cn=azcamps.getData(0, i, 0);
        String cd=azcamps.getData(0, i, 1);
        String sd = Common.GetCurrentDateAZ();
        String ed=azcamps.getData(0, i, 2);
        System.out.println("End Date:"+ed);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        camp.AddCampaignAdministgrator("kocc@konicaminolta.com");
        //cir=camp.FindUserstoCampaigClick();
        //cir.SelectCircletoCampaign("TestCircle");
        camp.PublishCampaign();
        home.navigatetoHome();
        home.VerifyFirstCampaignByName(cn);
        //end of create new campaign
    	}
     
        //Edit campaign - menu from Actions View campaing page
    	camp.EditCampaign();  
      	
    	//Follow campaign - Actions commands
       String fc1 = camp.GetCampaignFollowers();
       camp.FollowCampaign();
       String fc2 = camp.GetCampaignFollowers();
       camp.CheckFollowCampaignNum(fc1, fc2);
       //Unfollow campaign  
       String fc3 = camp.GetCampaignFollowers();
       camp.UnfollowCampaign();
       String fc4 = camp.GetCampaignFollowers();
       camp.CheckFollowCampaignNum(fc3, fc4);	   
      
       //Test Pin-Unpin Campaign
       home.navigatetoHome();                
   	  //Find campaign number by name and view campaign
        String cname="Android framework";
    	int cnum=home.FindCampNumber(cname);
   	    if (cnum != -1){
   	    camp=home.ViewCampaign(cnum);}
   	    //Pin campaign and check on the Home list
   	    //if pinned campaign is on the first position
   	    camp.PinCampaign();
   	    home.navigatetoHome();
        home.CheckFirstCampaignByName(cname);
        home.CheckFirstCampaignPinned();
        //View first campaign and unpin
        //Campaign should not be on the first position
        camp=home.ViewFirstCampaign();
        camp.UnpinCampaign();
        home.navigatetoHome();
        home.CheckFirstCampaignByName(cname);
        //share campaign
       	camp=home.ViewFirstCampaign();
    	camp.ShareCampaign();

    }
    
 }
