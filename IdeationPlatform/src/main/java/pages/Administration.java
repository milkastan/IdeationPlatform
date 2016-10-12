package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Administration extends Base{
	@FindBy(how=How.ID, id="MainCT_lblUserAdministration")
	WebElement UserAdminBtn;
	@FindBy(how=How.ID, id="MainCT_lblManageCircles")
	WebElement ManageCirclesBtn;
	
	
	public Administration() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public Users SelectUsersAdministration() {
		UserAdminBtn.click();
		WaitForVisibility(By.id("MainCT_lblTitle"),3);
		System.out.println("-------------------------------------");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Users();
	}
	
	public Circles SelectManageCircles() {
		ManageCirclesBtn.click();
		WaitForVisibility(By.id("MainCT_lblTitle"),3);
		System.out.println("-------------------------------------");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Circles();
	}
	
}
