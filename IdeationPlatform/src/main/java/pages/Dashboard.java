package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dashboard extends Base{

	@FindBy(how=How.ID, using="MainCT_ucOrganisationStats_repStats_lblStatValue_0")
	WebElement DCampaigns;
	@FindBy(how=How.ID, using="MainCT_ucOrganisationStats_repStats_lblStatValue_1")
	WebElement DSubmittedIdeas;
	@FindBy(how=How.ID, using="MainCT_ucOrganisationStats_repStats_lblStatValue_2")
	WebElement DCommentsMade;
	@FindBy(how=How.ID, using="MainCT_ucOrganisationStats_repStats_lblStatValue_3")
	WebElement DContributors;
	
	public Dashboard() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public String GetDashboardCampaigns() {
    	String d = DCampaigns.getText();
    	return d;
    }
    
    public String GetDashboardSubmittedIdeas() {
    	String d = DSubmittedIdeas.getText();
    	return d;
    }
    
    public String GetDashboardComments() {
    	String d = DCommentsMade.getText();
    	return d;
    }
    
    public String GetDashboardContributors() {
    	String d = DContributors.getText();
    	return d;
    }
	  public void PrintDashboardCampaignsInfo() {
    	System.out.println("Ideation Dashboard Campaigns Info");
    	System.out.println("My Campaigns:"+GetDashboardCampaigns());
     	System.out.println("My Ideas:"+GetDashboardSubmittedIdeas());
     	System.out.println("My Comments:"+GetDashboardComments());
     	System.out.println("My Average rating:"+GetDashboardContributors());
     	System.out.println("-------------------------------------");
    }
    
	//0-All Campaigns, 1- Active Campaigns
    public Dashboard FilterActiveCampaigns(int i) {
    	if (Browser.driver.findElement(By.id("MainCT_ddlCampaignFilter")).isDisplayed()) {
    	Select campfilter1 = new Select (Browser.driver.findElement(By.id("MainCT_ddlCampaignFilter")));
    	campfilter1.selectByIndex(i);
    	WebElement selopt = Browser.driver.findElement(By.xpath("//*[@id='MainCT_ddlCampaignFilter']/option[@selected='selected']"));
	    System.out.println("Selected filter :"+selopt.getText());
	    System.out.println("-------------------------------------");
    	}
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	return this;
    }
    
	//0-Entire organization, 1- My campaigns, 2-Campaigns I am invited to, 3-Followed campaigns  
    public Dashboard FilterOrgCampaigns(int i) {
    	if (Browser.driver.findElement(By.id("MainCT_ddlStatisticsView")).isDisplayed()) {
    	Select campfilter2 = new Select (Browser.driver.findElement(By.id("MainCT_ddlStatisticsView")));
    	campfilter2.selectByIndex(i);
    	WebElement selopt = Browser.driver.findElement(By.xpath("//*[@id='MainCT_ddlStatisticsView']/option[@selected='selected']"));
	    System.out.println("Selected filter :"+selopt.getText());
	    System.out.println("-------------------------------------");
    	}
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
       	return this;
    }
	
}
