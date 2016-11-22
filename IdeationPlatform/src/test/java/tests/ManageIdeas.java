package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Common;
import common.DataproviderClass;

public class ManageIdeas extends BaseTest{
	@BeforeTest
	public void setUp() {
		PrintCurrentDateTime();
    	System.out.println("Ideation Platform - Manage Ideas!");
    	System.out.println("--------------------------------------------");
    	navigatetoIdeation();
    	//ResizeBrowserWindow(760, 1280);

    }
	
    @AfterTest
    public void ShutDown() {
    	System.out.println("Finished Manage Ideas test!");
    	PrintCurrentDateTime();
    	System.out.println("--------------------------------");
    }
    
    @Test(dataProvider="AZSA1",dataProviderClass=DataproviderClass.class)
    public void TestManageIdeas(String uname, String pass) {
    	home=SignIn(uname,pass);
    	
		//read campaign data from excel
       camp=home.navigatetoCreateCampaign();
		String cn=azcamps.getData(0, 1, 0);
        String cd=azcamps.getData(0, 1, 1);
        String sd = Common.GetCurrentDateAZ();
        String ed=azcamps.getData(0, 1, 2);
        System.out.println("End Date:"+ed);
        camp.FillinNewCampaign(cn, cd, sd, ed);
        //camp.AddCampaignAdministgrator("icb2cc@icb2.bg");
        camp.PublishCampaign();
        //end of create new campaign
       
    	camp=home.ViewCampaignbyNo(4);
    	//Submit ideas and check Campaign dashboard number for ideas
    	String idnum1= camp.GetCampaignsIdeas();
    	for (int i=1; i<5;i++) {
        String ititle = azcamps.getData(1, i, 0);
        String idesc = azcamps.getData(1, i, 1);
        System.out.println(ititle);
        System.out.println(idesc);
        ide=camp.SubmitNewIdea(ititle, idesc,false);
        ide.GotoCampaign();
    	}
    	String idnum2= camp.GetCampaignsIdeas();
    	assertThat(Integer.parseInt(idnum2),is(Integer.parseInt(idnum1)+4));
    	
  	//Submit comments for first idea and check idea dashboard comments number
     	ide=camp.ViewIdea(0);
    	String comm1 =ide.GetIdeaComments();
    	for (int i=1; i<5;i++) {
    		String com=azcamps.getData(2, i, 0);
    	    ide.SubmitComment(com);
    	}
    	String comm2 =ide.GetIdeaComments();
    	assertThat(Integer.parseInt(comm2),is(Integer.parseInt(comm1)+4));
     
        //follow idea
    	String idefoll1 = ide.GetIdeaFollowers();
    	ide.FollowIdea();
    	String idefoll2 = ide.GetIdeaFollowers();
    	assertThat(Integer.parseInt(idefoll2),is(Integer.parseInt(idefoll1)+1));
    	//Unfollow idea
    	String ideunfoll1 = ide.GetIdeaFollowers();
    	ide.UnfollowIdea();
    	String ideunfoll2 = ide.GetIdeaFollowers();
    	assertThat(Integer.parseInt(ideunfoll2),is(Integer.parseInt(ideunfoll1)-1));
    	
    }    
}
