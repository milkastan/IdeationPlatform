package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {
	
	@FindBy(how=How.ID, id="MainCT_tbUsername")
	WebElement usernameField;
	@FindBy(how=How.ID, id="MainCT_tbPassword")
	WebElement passwordField;
	@FindBy(how=How.ID, id="MainCT_btnLogin")
	WebElement Loginbtn;
	@FindBy (how=How.PARTIAL_LINK_TEXT,using="MainCT_hlForgottenPassword")
	WebElement forgotPassLnk;
		
	public Login() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	public Home successFullLogin(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		Loginbtn.click();
		WaitForVisibility(By.id("MainCT_lblFilter"),3);
		System.out.println("user:"+username+", password:"+password+" logged in Ideation Platform");
		System.out.println("--------------------------------------------");
		System.out.println("Ideation Platform Home page is opened");
		return new Home();
	}

}
