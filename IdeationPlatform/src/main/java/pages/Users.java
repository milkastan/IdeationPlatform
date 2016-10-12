package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Users extends Base{
	
	@FindBy(how=How.ID, using="MainCT_btnCreateUser")
	WebElement CreateUserBtn;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbUserName")
	WebElement UsernameField;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbFirstName")
	WebElement FirstNameField;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbLastName")
	WebElement LastNameField;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbEmail")
	WebElement EmailField;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbPassword")
	WebElement PasswordField;
	@FindBy(how=How.ID, using="MainCT_ucUserEdit_tbConfirmPassword")
	WebElement ConfirmPasswordField;
	@FindBy(how=How.ID, using="MainCT_btnSubmit2")
	WebElement SubmitNewUserBtn;
	
	public Users() {
		PageFactory.initElements(Browser.driver, this);
	}

	public Users CreateNewUser(String un, String fn, String ln, String em ) {
			CreateUserBtn.click();
			WaitForVisibility(By.xpath("//*[text()='Create new user']"),3);
			UsernameField.sendKeys(un);
			FirstNameField.sendKeys(fn);
			LastNameField.sendKeys(ln);
			EmailField.sendKeys(em);
			PasswordField.sendKeys("123456");
			ConfirmPasswordField.sendKeys("123456");
			SubmitNewUserBtn.click();
			WaitForVisibility(By.xpath("//*[text()='Manage users']"),3);
		//}
		return this;
	}
	
}
