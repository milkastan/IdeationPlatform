package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserProfile extends Base{
	@FindBy(how=How.ID, using="RightCT_ucUserCounts_repStats_lblStatValue_0")
	WebElement ULastLogin;
	@FindBy(how=How.ID, using="RightCT_ucUserCounts_repStats_lblStatValue_1")
	WebElement UStartedCamp;
	@FindBy(how=How.ID, using="RightCT_ucUserCounts_repStats_lblStatValue_2")
	WebElement UIdeasSubmitted;
	@FindBy(how=How.ID, using="RightCT_ucUserCounts_repStats_lblStatValue_3")
	WebElement UCommentsMade;
	@FindBy(how=How.ID, using="RightCT_ucUserCounts_repStats_lblStatValue_4")
	WebElement URatingsMade;
	
	public UserProfile() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public String GetUserLastLogin() {
    	String d = ULastLogin.getText();
    	return d;
    }
    
    public String GetUserStartedCampaigns() {
    	String d = UStartedCamp.getText();
    	return d;
    }
    
    public String GetUserIdeasSubmitted() {
    	String d = UIdeasSubmitted.getText();
    	return d;
    }
    
    public String GetUserCommentsMade() {
    	String d = UCommentsMade.getText();
    	return d;
    }
    
    public String GetUserRatingsMade() {
    	String d = URatingsMade.getText();
    	return d;
    }
    
	  public void PrintUserDashboardInfo() {
	    	System.out.println("User Dashboard Info");
	    	System.out.println("-------------------------------------");
	    	System.out.println("User last login: "+GetUserLastLogin());
	     	System.out.println("Started campaigns: "+GetUserStartedCampaigns());
	     	System.out.println("Ideas submitted: "+GetUserIdeasSubmitted());
	     	System.out.println("Comments submitted: "+GetUserCommentsMade());
	     	System.out.println("Ratings made: "+GetUserRatingsMade());
	     	System.out.println("-------------------------------------");
	    }
}
