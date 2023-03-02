package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {

	public LogOutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[text()='Continue']")
	WebElement Continuebtn;
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement AccountPageTitle;
	
	public void ClickOnContinuebtn() {
		Continuebtn.click();
	}
	public boolean LogOutPageVerify() {
		String PageTitle= AccountPageTitle.getText();
		if(PageTitle.equals("Account Logout")) {
			return true;
		}else {
			return false;
		}
	}
}
