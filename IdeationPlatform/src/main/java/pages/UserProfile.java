package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Assert;

public class UserProfile extends Base{
	@FindBy(how=How.ID, using="MainCT_ucUserCounts_repStats_lblStatValue_0")
	WebElement ULastLogin;
	@FindBy(how=How.ID, using="MainCT_ucUserCounts_repStats_lblStatValue_1")
	WebElement UStartedCamp;
	@FindBy(how=How.ID, using="MainCT_ucUserCounts_repStats_lblStatValue_2")
	WebElement UIdeasSubmitted;
	@FindBy(how=How.ID, using="MainCT_ucUserCounts_repStats_lblStatValue_3")
	WebElement UCommentsMade;
	@FindBy(how=How.ID, using="MainCT_ucUserCounts_repStats_lblStatValue_4")
	WebElement URatingsMade;
	@FindBy(how=How.ID, using="MainCT_ucUserRating_lblRatingValue")
	WebElement URatingValue;
	
	
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
    
    public String GetUserRatingValue() {
    	String d = URatingValue.getText();
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
	     	System.out.println("Ratings made: "+GetUserRatingValue());
	     	System.out.println("-------------------------------------");
	    }
	  
	    public void CheckIdeasNumber(){
	    	List<WebElement> ide = Browser.driver.findElements(By.xpath(""));
	    	System.out.println("Number if ideas is: "+ide.size());
	    	if (Integer.toString(ide.size()).equalsIgnoreCase(GetUserIdeasSubmitted())) {
	    	    System.out.println("Number of ideas in the list is equal to dashboard number of Ideas Submitted");
	    	} else
	    		System.out.println("Number of ides in the list is NOT equal to dashboard number Ideas submitted");
	    }
	   
	    //i=0 Select Ideas TAB, i=1 - Select comments TAB
		public UserProfile SelectIdeaCommentsTAB(int i) {
			List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@class='nav nav-tabs']/li/a"));
			mnu.get(i).click();
			String sid="Ideas";
			String scom="Comments";
			String activmenu = Browser.driver.findElement(By.xpath("//*[@class='active']")).getText();
			if (i==0) {
			     Assert.assertTrue((sid.equalsIgnoreCase(activmenu)),"Menu Ideas is not active");
			     System.out.println("Selected menu Ideas on My Profile");			  
			}else {
				Assert.assertTrue((scom.equalsIgnoreCase(activmenu)),"Menu Comments is not active");
				System.out.println("Selected menu Comments on My Profile");
			}
			System.out.println("----------------------");
			return this;
		}
	    
}
