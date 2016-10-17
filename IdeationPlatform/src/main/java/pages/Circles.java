package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Circles extends Base{
	
	@FindBy(how=How.ID, using="MainCT_liCircles")
	WebElement CirclesMenu;
	@FindBy(how=How.ID, using="MainCT_liContributors")
	WebElement ContributorsMenu;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_rbGenericCircles")
	WebElement GenericCirclesMenu;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_rbPrivateCircles")
	WebElement PrivateCirclesMenu;
	@FindBy(how=How.ID, using="MainCT_ucManageCircleUsers_rbIntUsers")
	WebElement InternalUsersMenu;
	@FindBy(how=How.ID, using="MainCT_ucManageCircleUsers_rbAllUsers")
	WebElement AllUsersMenu;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_btnAdd")
	WebElement AddtocampaignBtn;
	@FindBy(how=How.ID, using="MainCT_btnSave2")
	WebElement SaveCircleBtn;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_tbFilter")
	WebElement FilterTextField;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_btnFilter")
	WebElement FilterBtn;
	@FindBy(how=How.ID, using="MainCT_ucManageCampaignCircles_lvAllCircles_cbSelect_0")
	WebElement FirstCheckbox;
	
	//Create, edit,delete circle
	@FindBy(how=How.ID, using="MainCT_ucManageCircles_tbCircleName")
	WebElement CircleNameField;
	@FindBy(how=How.ID, using="MainCT_ucManageCircles_btnAdd")
	WebElement CreateNewCircleBtn;
	
	
	public Circles() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public Circles SelectCirclesMenu(){
		CirclesMenu.click();
		WaitForVisibility(By.id("MainCT_ucManageCampaignCircles_lblAvailableCircles"),3);
		return this;
	}
	
	public Circles SelectContributorsMenu(){
		ContributorsMenu.click();
		WaitForVisibility(By.id("MainCT_ucManageCircleUsers_lblAvailableUsers"),3);
		return this;
	}
	
	public Circles SelectPrivateCirclesMenu(){
		PrivateCirclesMenu.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Circles SelectGenericCirclesMenu(){
		GenericCirclesMenu.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Circles SelectContributorsAllUsersMenu(){
		AllUsersMenu.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Circles SelectContributorsInternalUsersMenu(){
		InternalUsersMenu.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Circles SelectCircletoCampaign(String cname) {
		Browser.SwitchToFrame();
		SelectCirclesMenu();
		FilterTextField.sendKeys(cname);
		FilterBtn.click();
		FirstCheckbox.click();
		//WebElement circlecheck = Browser.driver.findElement(By.xpath("//text()='"+cname+"']/../following-sibling::td/span[@type='checkbox']"));
	 	//circlecheck.click();
	 	AddtocampaignBtn.click();
	 	WaitForVisibility(By.xpath("//div[@class='container-fluid']//text()='"+cname+"'"),3);
	 	SaveCircletoCampaign();
	 	return this;
	}
	
	public Circles SaveCircletoCampaign() {
		SaveCircleBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Browser.SwitchToMain();
		return this;
	}
	
	public Circles EditCircle(String cname) {
		WebElement CircleName = Browser.driver.findElement(By.xpath("//*[text()='NewCircle']"));
		String cnum = CircleName.getAttribute("id");
		cnum= cnum.substring(cnum.length()-1,cnum.length()); 
         System.out.println("Position of circle is:"+cnum);
         WebElement EditCircleBtn = Browser.driver.findElement(By.id("MainCT_ucManageCircles_lvCircles_lbtnEdit_"+cnum));
         EditCircleBtn.click();
		return this;
	}
	
	public Circles DeleteCircle(String cname) {
		WebElement CircleName = Browser.driver.findElement(By.xpath("//*[text()='NewCircle']"));
		String cnum = CircleName.getAttribute("id");
		cnum= cnum.substring(cnum.length()-1,cnum.length()); 
         System.out.println("Position of circle is:"+cnum);
         WebElement DeleteCircleBtn = Browser.driver.findElement(By.id("MainCT_ucManageCircles_lvCircles_lbtnDelete_"+cnum));
         DeleteCircleBtn.click();
         ConfirmDelete();
		return this;
	}
}
