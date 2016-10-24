package pages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Ideas extends Base{
	//Idea Actions
	@FindBy(how=How.ID, using="MainCT_hlnkEditIdea")
	WebElement EditIdea;
	@FindBy(how=How.ID, using="MainCT_lnkDeleteIdea")
	WebElement DeleteIdea;

	@FindBy(how=How.ID, using="MainCT_lnkFollowIdea")
	WebElement FollowIdea;
	@FindBy(how=How.ID, using="MainCT_hlnkSubmitComment")
	WebElement SubmitComment;
	@FindBy(how=How.ID, using="MainCT_divMoveIdea")
	WebElement MoveIdea;
	//Idea details
	@FindBy(how=How.ID, using="MainCT_lblIdeaName")
	WebElement IdeaName;
	@FindBy(how=How.ID, using="MainCT_btnDelete")
	WebElement DeleteIdeaBtn;
	
	//View campaign text
	@FindBy(how=How.XPATH, using="//*[@id='MainCT_lblCampaignName']/text()")
	WebElement CampTitle;
	@FindBy(how=How.XPATH, using="//*[@id='lblDescription']/text()")
	WebElement CampDesc;
	
	//Comments
	@FindBy(how=How.ID, using="MainCT_tbComment")
	WebElement CommentsField;
	@FindBy(how=How.ID, using="MainCT_btnSave")
	WebElement CommentsSaveBtn;
	@FindBy(how=How.XPATH, using="MainCT_btnCancel")
	WebElement CommentsCancelBtn;

		
	public Ideas() {
		PageFactory.initElements(Browser.driver, this);
	}
	
     public  Ideas SubmitComment(String com) {
    	 SubmitComment.click();
    	 WaitForVisibility(By.id("MainCT_lblComment"),2);
    	 Browser.SwitchToFrame();
    	 CommentsField.click();
    	 CommentsField.sendKeys(com);
    	 CommentsSaveBtn.click();
    	 Browser.SwitchToMain();
    	 System.out.println("Added comment for idea!");
    	 WaitForVisibility(By.id("MainCT_lblIdeaName"),3);
    	 return this;
    }
     
     public Ideas CheckifCommentaddedtoIdea(String comtxt) {
    	 List<WebElement> com = Browser.driver.findElements(By.xpath("//*[contains(text(),'" + comtxt + "')]"));
    	 Assert.assertTrue("Text not found!", com.size() > 0);
    	 if ( com.size()>0 ){
    		System.out.println("Comment has added to idea"); 
    	 }
    	 return this;
     }

    public Ideas EditComment(int i) {
    	System.out.println("Edit comment" +String.valueOf(i));
    	WaitForVisibility(By.id("MainCT_ideaCommentList_lvComments_lnkEditComment_"+String.valueOf(i)),3);
    	WebElement ecom = Browser.driver.findElement(By.id("MainCT_ideaCommentList_lvComments_lnkEditComment_"+String.valueOf(i)));
    	if (ecom.isDisplayed()) {
    	ecom.click();
    	WaitForVisibility(By.id("MainCT_lblComment"),2);
   	    Browser.SwitchToFrame();
   	    CommentsField.click();
   	    CommentsField.sendKeys(" Changed");
   	    CommentsSaveBtn.click();
   	    Browser.SwitchToMain();
   		System.out.println("Comment for idea has changed!");
   	    WaitForVisibility(By.id("MainCT_lblIdeaName"),3);
    	}
    	return this;
    }
    
    public Ideas DeleteComment(int i) {
    	System.out.println("Deleting comment " +String.valueOf(i));
    	WaitForVisibility(By.id("MainCT_ideaCommentList_lvComments_btnDeleteComment_"+String.valueOf(i)),3);
    	WebElement dcom = Browser.driver.findElement(By.id("MainCT_ideaCommentList_lvComments_btnDeleteComment_"+String.valueOf(i)));
    	if (dcom.isDisplayed()) {
    	dcom.click();
    	ConfirmDelete();	
    	WaitForVisibility(By.id("MainCT_lblIdeaName"),3);
    	}
    	return this;
    }
    
    public Ideas DeleteIdeaByMenu() {
    	DeleteIdea.click();
    	ConfirmDelete();	
    	return this;
    }
    
    public Ideas DeleteIdeaFromEdit() {
    	EditIdea.click();
    	WaitForVisibility(By.id("MainCT_lblTitle"),2);
    	if (DeleteIdeaBtn.isDisplayed()) {
    		DeleteIdeaBtn.click();
    		ConfirmDelete();	
    		WaitForVisibility(By.id("MainCT_lblFilter"),2);
       	}
    	return this;
    }
    
    public Ideas FollowIdea(){
    	System.out.println(FollowIdea.getText());
    	if (FollowIdea.getText().equalsIgnoreCase("Follow idea")) {
    	FollowIdea.click();
    	while (!(FollowIdea.getText().equalsIgnoreCase("Unfollow idea")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Menu items has changed to "+FollowIdea.getText());
    	}else {
    		System.out.println("Ideas is already followed");
    	}  
    	return this;
    }
    
    public Ideas UnfollowIdea(){
    	System.out.println(FollowIdea.getText());
    	if (FollowIdea.getText().equalsIgnoreCase("Unfollow idea")) {
    	FollowIdea.click();
    	while (!(FollowIdea.getText().equalsIgnoreCase("Follow idea")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Menu items has changed to "+FollowIdea.getText());
    	}else {
    		System.out.println("Ideas is already Unfollowed");
    	}  
    	return this;
    }
    
    

}
