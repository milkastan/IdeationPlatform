package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
//import org.junit.Assert;


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
	@FindBy(how=How.ID, using="MainCT_hlnkEditUser")
	WebElement EditProfileMenu;
	@FindBy(how=How.ID, using="MainCT_btnCancel")
	WebElement CancelEditProfileBtn;
	
	
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
	    	List<WebElement> ide = Browser.driver.findElements(By.xpath("//*[@id='MainCT_ideaList_lvIdeas_layoutTemplate']/div/div"));
	    	System.out.println("Number if ideas is: "+ide.size());
	    	System.out.println("Check if idea list is equal to dashboard number");
	    	assertThat(Integer.toString(ide.size()), is(equalTo(GetUserIdeasSubmitted())));
	    }
	   
	    //i=0 Select Ideas TAB, i=1 - Select comments TAB
		public UserProfile SelectIdeaCommentsTAB(int i) {
			List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@class='nav nav-tabs']/li/a"));
			mnu.get(i).click();
			System.out.println("Selecting TAB Comment");
			String scom="Comments";
			String activmenu = Browser.driver.findElement(By.xpath("//*[@class='active']")).getText();
			System.out.println("Compare if active menu is comment");
			CompareText(scom,activmenu);
			System.out.println("----------------------");
			return this;
		}
	    
		public UserProfile OpenEditMyProfile() {
			EditProfileMenu.click();
			WaitForVisibility(By.id("MainCT_lblTitle"),2);
			CompareText(GetElementText(By.id("MainCT_lblTitle")),"Edit profile");
			System.out.println("Edit profile page is opened!");
			CancelEditProfileBtn.click();
			WaitForVisibility(By.id("MainCT_lblMobileTitle"),3);
			CompareText(GetElementText(By.id("MainCT_lblMobileTitle")),"Mobile phone:");
			System.out.println("Returned back to user profile page");
			return this;
		}
}
