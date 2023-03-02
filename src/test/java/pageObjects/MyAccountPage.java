package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	//element
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myaccountpageHeading;
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement logoutbtn;
	
	public boolean isMyAccountPageExist() {
		try
		{
			return (myaccountpageHeading.isDisplayed());
		} catch(Exception e) {
			return (false);
		}
	}
	public void ClickOnlogout() {
		logoutbtn.click();
	}

}
