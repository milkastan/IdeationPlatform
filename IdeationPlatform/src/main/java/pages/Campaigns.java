package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Campaigns extends Base{
	/*@FindBy(how=How.ID, using="MainCT_tbCampaignTitle")
	WebElement CampaignTitle;
	@FindBy(how=How.ID, using="MainCT_tbDescription")
	WebElement CampaignDesc;*/
	@FindBy(how=How.ID, using="MainCT_lblSubmitUsers")
	WebElement FindUsers;
	@FindBy(how=How.ID, using="MainCT_btnSubmit1")
	WebElement SubmitCampaign;
	@FindBy(how=How.ID, using="MainCT_hlnkCancel")
	WebElement CancelCampaign;
	@FindBy(how=How.ID, using="MainCT_dpStartDate_theTextBox")
	WebElement StartDateField;
	@FindBy(how=How.ID, using="MainCT_dpEndDate_theTextBox")
	WebElement EndDateField;
	@FindBy(how=How.ID, using="MainCT_tbAdmins")
	WebElement CampAdminField;
	@FindBy(how=How.ID, using="MainCT_clbTags_listbox_chosen")
	WebElement CampTagField;
	@FindBy(how=How.XPATH, using="//*[@name='ctl00$MainCT$clbTags$btnAdd']")
	WebElement AddTagBtn;
	
	//Campaign Actions
	@FindBy(how=How.ID, using="RightCT_hlnkEditCampaign")
	WebElement EditCampaign;
	@FindBy(how=How.ID, using="RightCT_lnkDelete")
	WebElement DeleteCampaign;
	@FindBy(how=How.ID, using="RightCT_lnkFollowCampaign")
	WebElement FollowCampaign;
	@FindBy(how=How.ID, using="RightCT_hlnkSubmitIdea")
	WebElement SubmitIdea;
	@FindBy(how=How.ID, using="RightCT_lnkPinCampaign")
	WebElement PinCampaign;
	@FindBy(how=How.ID, using="RightCT_hlnkExportCampaign")
	WebElement ExportCampaign;
	@FindBy(how=How.ID, using="RightCT_hlnkShareCampaign")
	WebElement ShareCampaign;
	//View campaign text
	@FindBy(how=How.XPATH, using="//*[@id='MainCT_lblCampaignName']/text()")
	WebElement CampTitle;
	@FindBy(how=How.XPATH, using="//*[@id='lblDescription']/text()")
	WebElement CampDesc;
	
	//Create new idea fields
	@FindBy(how=How.ID, using="MainCT_chbPrivacy")
	WebElement IdeaPrivacy;
	@FindBy(how=How.ID, using="MainCT_btnSubmit2")
	WebElement SaveIdea;
	//Bold, italic, bullets for description  2 fields bold and italic
	@FindBy(how=How.XPATH, using="//*[@class='k-tool-icon k-bold'])")
	WebElement DescBoldBtn;
	@FindBy(how=How.XPATH, using="//*[@class='k-tool-icon k-italic']")
	WebElement DescItalicBtn;
	@FindBy(how=How.XPATH, using="//*[@class='k-tool-icon k-insertUnorderedList']")
	WebElement DescBulletsBtn;
	//Number of Campaigns shown on Home page
	@FindBy(how=How.XPATH, using="//*[@id='MainCT_tabCampaigns']/div/div/div/div")
	WebElement HomeCampNum;
	
	//Campaign dashboard statistics
	@FindBy(how=How.ID, using="RightCT_ucCampaignCounts_repStats_lblStatValue_0")
	WebElement CampViews;
	@FindBy(how=How.ID, using="RightCT_ucCampaignCounts_repStats_lblStatValue_1")
	WebElement CampFollowers;
	@FindBy(how=How.ID, using="RightCT_ucCampaignCounts_repStats_lblStatValue_2")
	WebElement CampIdeas;
	@FindBy(how=How.ID, using="RightCT_ucCampaignCounts_repStats_lblStatValue_3")
	WebElement CampComments;
	@FindBy(how=How.ID, using="RightCT_ucCampaignCounts_repStats_lblStatValue_4")
	WebElement CampAvgRating;
	
	
	//input[@type='text'] - TAG is nd input field

	public static int CampNum;
	
	public Campaigns() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public String GetCampaignViews() {
    	String d = CampViews.getText();
    	return d;
    }
    
    public String GetCampaignFollowers() {
    	String d = CampFollowers.getText();
    	return d;
    }
    
    public String GetCampaignsIdeas() {
    	String d = CampIdeas.getText();
    	return d;
    }
    
    public String GetCampComments() {
    	String d = CampComments.getText();
    	return d;
    }
    
     public String GetCampaignAvgRating() {
    	String d = CampAvgRating.getText();
    	return d;
    }
    
	  public void PrintCampaignDashboardInfo() {
	    	System.out.println("User Dashboard Info");
	    	System.out.println("-------------------------------------");
	    	System.out.println("Campaign Views: "+GetCampaignViews());
	     	System.out.println("Campaign Followers: "+GetCampaignFollowers());
	     	System.out.println("Campaigns Ideas: "+GetCampaignsIdeas());
	     	System.out.println("Campaign Comments: "+GetCampComments());
	     	System.out.println("Campaign Avg Rating: "+GetCampaignAvgRating());
	     	System.out.println("-------------------------------------");
	    }
	
	public Campaigns FillinNewCampaign(String campn, String campdes, String sdate, String edate) {
		List<WebElement> txt = Browser.driver.findElements(By.xpath("//td[@class='k-editable-area']/iframe"));
		List<WebElement> bbtns = Browser.driver.findElements(By.xpath("//*[@class='k-tool-icon k-bold']"));
		List<WebElement> ibtns = Browser.driver.findElements(By.xpath("//*[@class='k-tool-icon k-italic']"));
		txt.get(0).click();
		txt.get(0).sendKeys(campn);
		bbtns.get(1).click();   // bold button
		txt.get(1).click();
		txt.get(1).sendKeys("Description of campaign "+campn);
		txt.get(1).sendKeys(Keys.RETURN);
		DescBulletsBtn.click();
		ibtns.get(1).click();
		txt.get(1).sendKeys("Description of campaign");
		txt.get(1).sendKeys(Keys.RETURN);
		txt.get(1).sendKeys("Description of campaign");
		txt.get(1).sendKeys(Keys.RETURN);
		StartDateField.sendKeys(sdate);
		EndDateField.sendKeys(edate);
		
		return this;
	}
	
	//am = admin emails
    public Campaigns AddCampaignAdministgrator(String am) {
    	CampAdminField.sendKeys(am);
    	return this;
    }

/*	public Campaigns FillTitleDescription() {
		List<WebElement> txt = Browser.driver.findElements(By.xpath("//td[@class='k-editable-area']/iframe"));
		txt.get(0).click();
		txt.get(0).sendKeys("This is title");
		txt.get(1).click();
		txt.get(1).sendKeys("This is description");
		System.out.println("text boxs:"+txt.size());
		return this;
	}*/
	
	
	public Circles FindUserstoCampaigClick() {
		FindUsers.click();
		Browser.SwitchToFrame();
		WaitForVisibility(By.id("cboxTitle"),3);
		return new Circles();
	}
	
	public Campaigns PublishCampaign(){
		if (SubmitCampaign.isDisplayed()){
		    SubmitCampaign.click();
		}
		WaitForVisibility(By.id("MainCT_lblCampaignName"),3);		
		return this;
	}
	
	public Campaigns CheckForFirstCampaign(String cname) {
		WebElement firstcamp = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl0_lblCampTitle_0"));
		if (firstcamp.getText().equalsIgnoreCase(cname)) {
		    System.out.println("Campaign with title: "+cname+" is on the rist position!");
		}else {
			System.out.println("Campaign with title: "+cname+" is not at the first position");
		}
		return this;
	}
	
	public void FindCampNumber(String cname) {
		int i;
		System.out.println("Total number of cappaigns on Home page : "+HomeCampNum.getText());
		if (HomeCampNum.getText() != "0"){
			int maxcamp = Integer.parseInt(HomeCampNum.getText());
			for ( i=0; i>maxcamp; i++) {
				WebElement cam = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl0_lblCampTitle_"+String.valueOf(i)+"_lblCampaignTitle_"+String.valueOf(i)));
				if (cam.getText().equalsIgnoreCase(cname)){
					CampNum=i;
					break;
				}
			}
		}
	}

   public Campaigns EditCampaign(){
		EditCampaign.click();
		List<WebElement> txt = Browser.driver.findElements(By.xpath("//td[@class='k-editable-area']/iframe"));
		txt.get(0).click();
		txt.get(0).sendKeys(" Changed");
		txt.get(1).click();
		txt.get(1).sendKeys(" Description Changed");
		return this;
	}
	
	public Ideas ViewIdea(int i){
    	WebElement ide = Browser.driver.findElement(By.id("MainCT_IdeaList_lvIdeas_ctrl"+String.valueOf(i)+"_lblCampaignTitle_"+String.valueOf(i)));
    	ide.click();
    	WaitForVisibility(By.id("MainCT_lblIdeaName"),30);
       	return new Ideas();
    }
    
    public Ideas ViewFirstIdea(){
    	WebElement cm = Browser.driver.findElement(By.id("MainCT_IdeaList_lvIdeas_ctrl0_lblCampaignTitle_0"));                                       
    	cm.click();
    	WaitForVisibility(By.id("MainCT_lblIdeaName"),30);
       	return new Ideas();
    }
    
    public Ideas SubmitNewIdea(String title, boolean privacy) {
    	SubmitIdea.click();
    	WaitForVisibility(By.id("MainCT_lblTitle"),3);
		List<WebElement> txt = Browser.driver.findElements(By.xpath("//td[@class='k-editable-area']/iframe"));
		txt.get(0).click();
		txt.get(0).sendKeys(title);
		List<WebElement> bbtns = Browser.driver.findElements(By.xpath("//*[@class='k-tool-icon k-bold']"));
		bbtns.get(1).click();
		List<WebElement> ibtns = Browser.driver.findElements(By.xpath("//*[@class='k-tool-icon k-italic']"));
		ibtns.get(1).click();
		txt.get(1).click();
		txt.get(1).sendKeys("Selenium is a web application testing framework that allows you to write tests in many programming languages like  Java, C#, Groovy, Perl, PHP, Python and Ruby.");
		txt.get(1).sendKeys(Keys.RETURN);
		DescBulletsBtn.click();
		txt.get(1).sendKeys("Selenium deploys on Windows, Linux, and MAC OS");
		txt.get(1).sendKeys(Keys.RETURN);
		txt.get(1).sendKeys("WebDriver is a web automation framework that allows you to execute your tests against different browsers");
				
		if (privacy) {
			IdeaPrivacy.click();
		}
		SaveIdea.click();
		WaitForVisibility(By.id("MainCT_lblCampaignName"),3);	
    	return new Ideas();
    }
    
    public Campaigns FollowCampaign(){
    	System.out.println("Click on Follow Campaign!");
    	if (FollowCampaign.getText().equalsIgnoreCase("Follow Campaign")) {
    		FollowCampaign.click();
    	while (!(FollowCampaign.getText().equalsIgnoreCase("Unfollow Campaign")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Menu items has changed to "+FollowCampaign.getText());
    	}else {
    		System.out.println("Campaign is already followed");
    	}  
    	return this;
    }
    
    public Campaigns CheckFollowCampaignNum(String fc1, String fc2) {
        if (Integer.parseInt(fc2)==(Integer.parseInt(fc1)+1)) {
        	System.out.println("Followed campaing number on dashboard has increased by one after Follow Campaign!");
        }else if (Integer.parseInt(fc2)==(Integer.parseInt(fc1)-1)) {
        	System.out.println("Followed campaing number on dashboard has decreased by one by Unfollow Campaign!");
        }else {
        	System.out.println("Dashboard Followed is not updated!");
        }
        System.out.println("-------------------------------------------");
    	return this;
    }

    public Campaigns UnfollowCampaign(){
    	System.out.println("Click on Unfollow Campaign!");
    	if (FollowCampaign.getText().equalsIgnoreCase("Unfollow Campaign")) {
    		FollowCampaign.click();
    	while (!(FollowCampaign.getText().equalsIgnoreCase("Follow Campaign")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Menu items has changed to "+FollowCampaign.getText());
    	}else {
    		System.out.println("Campaign is already Unfollowed");
    	}  
    	return this;
    }
    
    public Campaigns PinCampaign(){
    	System.out.println(PinCampaign.getText());
    	if (PinCampaign.getText().equalsIgnoreCase("Pin Campaign")) {
    		PinCampaign.click();
    	while (!(PinCampaign.getText().equalsIgnoreCase("Unpin Campaign")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Campaign has to appear first in the list");
    	}else {
    		System.out.println("Campaign is already first in the list");
    	}  
    	return this;
    }
    
    public Campaigns UnpinCampaign(){
    	System.out.println(PinCampaign.getText());
    	if (PinCampaign.getText().equalsIgnoreCase("Unpin Campaign")) {
    		PinCampaign.click();
    	while (!(PinCampaign.getText().equalsIgnoreCase("Pin Campaign")))
    			{
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    	System.out.println("Unpin Campaign has executed");
    	}else {
    		System.out.println("Campaign is not pinned in the list");
    	}  
    	return this;
    }
}
