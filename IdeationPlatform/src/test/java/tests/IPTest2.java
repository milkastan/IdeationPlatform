package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.DataproviderClass;

public class IPTest2 extends BaseTest{
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
    
        @Test(dataProvider="AZSA1",dataProviderClass=DataproviderClass.class)
    public void OpenIDEPagesSA(String uname, String pass) {
    	home=SignIn(uname,pass);
    	camp=home.ViewCampaignbyNo(0);
    	ide=camp.ViewIdea(0);
    	String comm1 =ide.GetIdeaComments();
    	for (int i=1; i<3;i++) {
    		String com=azcamps.getData(2, i, 0);
    	    ide.SubmitComment(com);
    	}
    	String comm2 =ide.GetIdeaComments();
      	assertThat(Integer.parseInt(comm2),is(Integer.parseInt(comm1)+2));
    	System.out.println("Assert increasing idea comments on idea dashboard");
     
        //follow idea
    	String idefoll1 = ide.GetIdeaFollowers();
    	ide.FollowIdea();
    	String idefoll2 = ide.GetIdeaFollowers();
    	assertThat(Integer.parseInt(idefoll2),is(Integer.parseInt(idefoll1)+1));
    	System.out.println("Assert increasing idea  followers on ideas dashboard");
    	//Unfollow idea
    	String ideunfoll1 = ide.GetIdeaFollowers();
    	ide.UnfollowIdea();
    	String ideunfoll2 = ide.GetIdeaFollowers();
    	assertThat(Integer.parseInt(ideunfoll2),is(Integer.parseInt(ideunfoll1)-1));
    	System.out.println("Assert descreasing idea  followers on ideas dashboard");
    	 
        	
    }
}
