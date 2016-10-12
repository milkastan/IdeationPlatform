package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.DataproviderClass;

public class OpenPagesSysAdmin extends BaseTest{
	@BeforeTest
	public void setUp() {
    	System.out.println("Ideation Platform - Open all pages as system administrator!");
    	System.out.println("--------------------------------------------");
    	navigatetoIdeation ();
    	//ResizeBrowserWindow(760, 1280);
    	
    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Ideation Platform test!");
    }
    
    @Test(dataProvider="Administrator",dataProviderClass=DataproviderClass.class)
    public void CreateNewCampaign(String uname, String pass) {
    	home=SignIn(uname,pass);
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
    	dashb.FilterActiveCampaigns(0);
    	dashb.PrintDashboardCampaignsInfo();  
    	//Select menu Private Circles    
    	home.navigatetoPrivateCircles();
    	//Select menu Social Networks
    	home.navigatetoSocialNetworks();
    	//Select Administration
    	adm=home.navigatetoAdministration();
    	adm.SelectManageCircles();
    	adm=home.navigatetoAdministration();
    	adm.SelectUsersAdministration();
    	//Create New campaign
    	dashb=home.navigatetoDashboard();
    	
    	
    	
    }	
}
