package pages;

import org.openqa.selenium.support.PageFactory;

public class UserProfile extends Base{

	
	public UserProfile() {
		PageFactory.initElements(Browser.driver, this);
	}
}
