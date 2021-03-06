package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.AssertJUnit.assertTrue;

public class Home extends Base{

	@FindBy(how=How.ID, using="MainCT_liCampaigns")
	WebElement MenuCampaignsList;
	@FindBy(how=How.ID, using="MainCT_liRecIdeas")
	WebElement RecIdeasList;
	@FindBy(how=How.ID, using="MainCT_liMyIdeas")
	WebElement MenuMyIdeasList;
	@FindBy(how=How.CLASS_NAME, using="dropdown-toggle")
	WebElement UserDD;
	@FindBy(how=How.XPATH,using="//*[@class='dropdown-menu dropdown-menu-right']/li[1]")
	WebElement MenuMyProfile;	
	@FindBy(how=How.XPATH,using="//*[@class='dropdown-menu dropdown-menu-right']/li[4]")
	WebElement MenuLogout;
	@FindBy(how=How.ID, using="MainCT_lvCampaigns_ctrl0_lblCampTitle_0")
	WebElement ViewCampaign1;
	@FindBy(how=How.ID, using="MainCT_ucGeneralStatistics_repStats_lblStatValue_0")
	WebElement MyCampaigns;
	@FindBy(how=How.ID, using="MainCT_ucGeneralStatistics_repStats_lblStatValue_1")
	WebElement MyIdeas;
	@FindBy(how=How.ID, using="MainCT_ucGeneralStatistics_repStats_lblStatValue_2")
	WebElement MyComments;
	@FindBy(how=How.ID, using="MainCT_ucGeneralStatistics_repStats_lblStatValue_3")
	WebElement MyAvgRating;
	@FindBy(how=How.XPATH, using="//*[@class='navbar-toggle']")
	WebElement MenuBtn;
	//total campaigns shown on home page
	@FindBy(how=How.XPATH, using="//*[@id='MainCT_tabCampaigns']/div/div/div/div")
	WebElement AllHomeCamp;
	@FindBy(how=How.ID, using="MainCT_lvCampaigns_ctrl0_PinIcon_0")
	WebElement PinIcon;
	
	public Home() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	//Check by name if campaign is on the first position
	public Home CheckFirstCampaignByName(String cname) {
		WebElement ct = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl0_lblCampTitle_0"));
		System.out.println("Assert campaign is at the first position");
		CompareText(ct.getText(),cname);
		System.out.println("---------------------------------");
		return this;
	}
	

	//Check if on the first campaign appear Pin icon
	public Home CheckFirstCampaignPinned(){
		System.out.println("Assert that campaing is marked with pin icon");
		assertTrue(PinIcon.isDisplayed());
		System.out.println("---------------------------------");
	return this;
	}
	
	//Search between all campaigns by name and return campaign number in the list
	public int FindCampNumber(String cname) {
		int i=-1;
    	List<WebElement> cmp = Browser.driver.findElements(By.xpath("//*[@id='MainCT_tabCampaigns']/div/div/div/div"));
    	System.out.println("*****Number if campaigns is: "+cmp.size());
    	int maxcamp =cmp.size();
		if (maxcamp > 0){
	  		for ( i=0; i<maxcamp; i++) {
	  			WebElement ct = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl"+String.valueOf(i)+"_lblCampTitle_"+String.valueOf(i)));
				if (ct.getText().equalsIgnoreCase(cname)){
					break;
				}
			}
		}
		System.out.println("Campaign "+cname+" has number "+i);
		System.out.println("----------------------------------");
		return i;
	}
	
	public UserProfile SelectUserProfile() {
		if (MenuBtn.isDisplayed()) {
			MenuBtn.click();
			WaitForVisibility(By.id("ucMenu_topnav"),5);  
			List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@id='ucMenu_topnav']/li/a"));
		  System.out.println("Number of menu items: "+mnu.size());
			mnu.get(6).click();
			
		} else {
		UserDD.click();
		WaitForVisibility(By.className("dropdown open"),1);	
		MenuMyProfile.click();
		WaitForVisibility(By.id("MainCT_lblName"),1);
		}
		System.out.println("Selected menu My Profile");
		System.out.println("-------------------------------------");
		return new UserProfile();
	}
	
	public Login SelectLogout() {
		if (MenuBtn.isDisplayed()) {
			MenuBtn.click();
			WaitForVisibility(By.id("ucMenu_topnav"),5);  
			List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@id='ucMenu_topnav']/li/a"));
		  System.out.println("Number of menu items: "+mnu.size());
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			mnu.get(8).click();
			System.out.println("Selected from responsive menu");
		} else {
		UserDD.click();
		WaitForVisibility(By.className("dropdown open"),1);	
		MenuLogout.click();
		WaitForVisibility(By.id("MainCT_pnlLogin"),1);
		}
		System.out.println("User loged out of Ideation Platform");
		return new Login();
	}
	
	public void SelectMainMenu(int i) {
		if (MenuBtn.isDisplayed()) {
			MenuBtn.click();
			WaitForVisibility(By.id("ucMenu_topnav"),5);  
		}
		List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@id='ucMenu_topnav']/li/a"));
		//System.out.println("Number of menu items: "+mnu.size());
		if (i<=mnu.size()) {
			mnu.get(i).click();
		} else {
			System.out.println("Menu item is not in range");
		}
	}

	public void PrintAllMenuItems(){
		List<WebElement> mnu = Browser.driver.findElements(By.xpath("//*[@id='ucMenu_topnav']/li/a"));
		System.out.println("Visible menus for user");
		System.out.println("-------------------------");
		for (int i=0; i< mnu.size(); i++) {
			System.out.println(mnu.get(i).getText());
		}
	}
	

    public Home navigatetoHome() {
    	System.out.println("Selected menu Home");
    	SelectMainMenu(0);
    	WaitForVisibility(By.id("MainCT_lblFilter"),5);    	
     	return this;
    }
   
    public Campaigns navigatetoCreateCampaign() {
    	System.out.println("Selected menu Create Campaign");
    	SelectMainMenu(2);
    	WaitForVisibility(By.id("MainCT_lblCampaignTitle"),3);
    	System.out.println("Creating new campaign");
    	System.out.println("-------------------------------------");
     	return new Campaigns();
    }
    
    public Dashboard navigatetoDashboard() {
     	System.out.println("Selected menu Dashboard");
    	SelectMainMenu(1);
    	WaitForVisibility(By.id("MainCT_ddlCampaignFilter"),3);
    	System.out.println("-------------------------------------");
     	return new Dashboard();
    }
    
    public Circles navigatetoPrivateCircles() {
    	System.out.println("Selected menu Private Circles");
        	SelectMainMenu(3);
        	WaitForVisibility(By.id("MainCT_ucManageCircles_btnAdd"),3);
        	System.out.println("-------------------------------------");
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	return new Circles();
    }
    
    public Discussions navigatetoSocialNetworks(int i) {
    	System.out.println("Selected menu Social Networks");
    	//i=4 for Admin and CC
    	//i=2 for user
    	SelectMainMenu(i);
    	WaitForVisibility(By.id("MainCT_ucManageCircles_btnAdd"),3);
    	System.out.println("-------------------------------------");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	return new Discussions();
    }
    
	//accessible by role administrator
    public Administration navigatetoAdministration() {
    	System.out.println("Selected menu Administration");
    	SelectMainMenu(5);
    	WaitForVisibility(By.id("MainCT_lblUserAdministration"),3);
    	System.out.println("-------------------------------------");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	return new Administration();
    }
    
    //Home submenu Campaigns
    public Home SelectMenuCampaignsList() {
    	System.out.println("Select Home menu Home/Campaigns");
    	MenuCampaignsList.click();
    	WaitForVisibility(By.id("MainCT_lblFilter"),3);
    	System.out.println("-------------------------------------");
    	return this;
    }
    
    public Home SelectMenuRecentIdeasList() {
    	System.out.println("Select Home menu Home/Recent ideas");
    	RecIdeasList.click();
    	WaitForVisibility(By.id("MainCT_ideaListUser_lvIdeas_layoutTemplate"),3);
    	System.out.println("-------------------------------------");
    	return this;
    }
    
    public Home SelectMenuMyIdeasList() {
    	System.out.println("Select Home menu Home/My ideas");
    	MenuMyIdeasList.click();
    	WaitForVisibility(By.id("MainCT_ideaListRecent_lvIdeas_layoutTemplate"),3);
    	System.out.println("-------------------------------------");
    	return this;
    }
    
    //0- active, 1-All, 2-Inactive, 3-Upcoming
    public Home FilterCampaigns(int i) {
    	if (Browser.driver.findElement(By.id("MainCT_lblFilter")).isDisplayed()) {
    	Select campfilter = new Select (Browser.driver.findElement(By.id("MainCT_ddlCampaignType")));
    	campfilter.selectByIndex(i);
    	WebElement selopt = Browser.driver.findElement(By.xpath("//*[@id='MainCT_ddlCampaignType']/option[@selected='selected']"));
	    System.out.println("Selected filter for campaigns :"+selopt.getText());
	    System.out.println("-------------------------------------");
    	}
       	return this;
    }
    
    public String GetHomeDashboardMyCampaigns() {
    	String d = MyCampaigns.getText();
    	return d;
    }
    
    public String GetHomeDashboardMyIdeas() {
    	String d = MyIdeas.getText();
    	return d;
    }
    
    public String GetHomeDashboardMyComments() {
    	String d = MyComments.getText();
    	return d;
    }
    
    public String GetHomeDashboardMyAvgRating() {
    	String d = MyAvgRating.getText();
    	return d;
    }
    
    public int GetNumberofCampaigns(){
    	List<WebElement> cmp = Browser.driver.findElements(By.xpath("//*[@id='MainCT_tabCampaigns']/div/div/div/div"));
    	return cmp.size();
    }
    
    public void PrintHomeCampaignsInfo() {
    	System.out.println("Ideation Home Campaigns Dashboard Info");
    	System.out.println("-------------------------------------");
    	System.out.println("My Campaigns:"+GetHomeDashboardMyCampaigns());
     	System.out.println("My Ideas:"+GetHomeDashboardMyIdeas());
     	System.out.println("My Comments:"+GetHomeDashboardMyComments());
     	System.out.println("My Average rating:"+GetHomeDashboardMyAvgRating());
     	System.out.println("-------------------------------------");
    }
    
    public Campaigns ViewCampaignbyNo(int i){
    	System.out.println("View campaign with number "+i);
    	WebElement cm = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl"+String.valueOf(i)+"_lblCampTitle_"+String.valueOf(i)));
    	cm.click();
    	WaitForVisibility(By.id("MainCT_lblCampaignName"),30);
    	System.out.println("-------------------------------------------");
       	return new Campaigns();
    }
    
    public String GetCampaignNamebyNo(int i){
    	System.out.println("Get name of campaign number "+i);
    	WebElement cm = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl"+String.valueOf(i)+"_lblCampTitle_"+String.valueOf(i)));
       	return cm.getText();
    }
    
    public Campaigns ViewFirstCampaign(){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("View first campaign");
    	WebElement cm = Browser.driver.findElement(By.id("MainCT_lvCampaigns_ctrl0_lblCampTitle_0"));  
    	WaitForClickable(cm, 5);
    	cm.click();
    	WaitForVisibility(By.id("MainCT_lblCampaignName"),30);
    	System.out.println("-------------------------------------------");
       	return new Campaigns();
    }
    
    public Home HomeCampaignsChangeFilters() {
    	//active Campaigns
    	FilterCampaigns(0);
    	CheckCampainsNumber();
    	PrintHomeCampaignsInfo();
    	//All Campaigns
    	FilterCampaigns(1);
    	CheckCampainsNumber();
    	PrintHomeCampaignsInfo();
    	//Inactive Campaigns
    	FilterCampaigns(2);
    	CheckCampainsNumber();
    	PrintHomeCampaignsInfo();
    	//Upcoming Campaigns
    	FilterCampaigns(3);
    	CheckCampainsNumber();
    	PrintHomeCampaignsInfo();
    	return this;
    }
    
    //Check if campaigns in the list is equal to number from Home dashboard
    public void CheckCampainsNumber(){
    	List<WebElement> cmp = Browser.driver.findElements(By.xpath("//*[@id='MainCT_tabCampaigns']/div/div/div/div"));
    	System.out.println("Number if campaigns is: "+cmp.size());
    	if (Integer.toString(cmp.size()).equalsIgnoreCase(GetHomeDashboardMyCampaigns())) {
    	    System.out.println("Number of campaigns in the list is equal to dashboard number (Campaigns I am invited to)");
    	} else
    		System.out.println("Number of shown campaigns is NOT equal to dashboard number");
    }
    
   
    
}
