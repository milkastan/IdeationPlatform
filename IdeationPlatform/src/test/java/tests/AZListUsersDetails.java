package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Browser;
import common.Common;
import common.DataproviderClass;

public class AZListUsersDetails extends BaseTest{
	@BeforeTest
	public void setUp() {
		PrintCurrentDateTime();
    	System.out.println("Ideation Platform - Manage Ideas!");
    	System.out.println("--------------------------------------------");
    	navigatetoIdeationICBAZ();
    	//ResizeBrowserWindow(760, 1280);

    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Manage Ideas test!");
    	PrintCurrentDateTime();
    	System.out.println("--------------------------------");
    	QuitBrowser();
    }
    
    @Test(dataProvider="AZSA1",dataProviderClass=DataproviderClass.class)
    public void TestManageIdeas(String uname, String pass) {
    	String[] testusers = {"Adam.Mason","pepi","icbazcc","saicbaz"};
    	home=SignIn(uname,pass);
		//read campaign data from excel	
       camp=home.navigatetoCreateCampaign();
		String cn=azcamps.getData(0, 1, 0);
        String cd=azcamps.getData(0, 1, 1);
        String sd = Common.GetCurrentDateAZ();
        String ed=azcamps.getData(0, 1, 2);
        System.out.println("End Date:"+ed);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        camp.AddCampaignAdministgrator("Adam.Mason@icbaz.bg");
        camp.PublishCampaign();    
        //end of create new campaign
        QuitBrowser();
    	
       	for (int j=0;j<4;j++)  {
          navigatetoIdeationICBAZ();
          home=SignIn(testusers[j],"123456");
        
    	camp=home.ViewCampaignbyNo(0);
    	//Submit ideas and check Campaign dashboard number for ideas
    	//String idnum1= camp.GetCampaignsIdeas();
    	//System.out.println("Initial Campaign ideas is "+idnum1);
    	for (int i=0; i<1;i++) {
        String ititle = "Idea from "+testusers[j];
        String idesc = azcamps.getData(1, i, 1);
        ide=camp.SubmitNewIdea(ititle, idesc,false);

    	for (int k=1; k<2;k++) {
       		String com="Comment from "+testusers[j];
    	    ide.SubmitComment(com);
    	}
        ide.GotoCampaign();
    	}
    	QuitBrowser();
      }
       	
       	for (int n=0;n<4;n++)  {
            navigatetoIdeationICBAZ();
            home=SignIn(testusers[n],"123456");
          
      	camp=home.ViewCampaignbyNo(0); 	
      	ide=camp.ViewIdea(0);
      	for (int k=1; k<2;k++) {
    		String com="Comment from "+testusers[n];
    	    ide.SubmitComment(com);
    	}
      	QuitBrowser();
    }   	
   
    }
}
