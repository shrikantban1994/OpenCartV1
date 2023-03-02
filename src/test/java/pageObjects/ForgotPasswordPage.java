package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")
	WebElement enteremail;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continuebtn;
	
	@FindBy(xpath="//a[text()='Back']")
	WebElement BackBtn;
	
	@FindBy(xpath="//div[text()=' An email with a confirmation link has been sent your email address.']")
	WebElement ConfirmMsg;
	
	public void EnterMail(String mail) {
		enteremail.sendKeys(mail);
	}
	public void ClickOnContinuebtn() {
		Continuebtn.click();
	}
	public boolean IsDisplyedBackbtn() {
		if(BackBtn.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean VerifyConfirmationMSG() {
		String verifymsg=ConfirmMsg.getText();
		if(verifymsg.equals("An email with a confirmation link has been sent your email address.")) {
			return true;
		}else {
			return false;
		}
	}

}
