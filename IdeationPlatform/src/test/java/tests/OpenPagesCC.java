package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.DataproviderClass;

public class OpenPagesCC extends BaseTest{
	@BeforeTest
	public void setUp() {
		PrintCurrentDateTime();
    	System.out.println("Ideation Platform - Open all pages as Company Creator!");
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
    
    @Test(dataProvider="AZCC1",dataProviderClass=DataproviderClass.class)
    public void OpenIDEPagesCC(String uname, String pass) {
    	home=SignIn(uname,pass);
    	//print all visible menus for user
    	home.PrintAllMenuItems();
    	//User is navigated to Home
    	//Check Home page campaigns filters
    	home.HomeCampaignsChangeFilters();
    	home.SelectMenuRecentIdeasList();
    	home.SelectMenuMyIdeasList();
    	//Change Dashboard filters and get numbers for campaigns
    	dashb=home.navigatetoDashboard();
    	for (int i=0; i<4; i++) {
    		 dashb.FilterOrgCampaigns(i);
    		 dashb.PrintDashboardCampaignsInfo();
    	}
    	dashb.FilterActiveCampaigns(1);
    	for (int i=0; i<4; i++) {
      		 dashb.FilterOrgCampaigns(i);
      		 dashb.PrintDashboardCampaignsInfo();
      	}  
    	//Select menu Private Circles    
    	home.navigatetoPrivateCircles();
    	//Select menu Social Networks
    	home.navigatetoSocialNetworks(4);
    	//Select user profile
    	prof=home.SelectUserProfile();
    	prof.PrintUserDashboardInfo();
    	prof.SelectIdeaCommentsTAB(1);
    	//prof.SelectIdeaCommentsTAB(0);
     }	
}
