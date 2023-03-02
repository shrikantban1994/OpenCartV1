package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//a[text()='login page']")
	WebElement LoginPageLink ;
	
	@FindBy(name="firstname")
	WebElement FirstNametxt ;
	
	@FindBy(name="lastname")
	WebElement LastNametxt ;
	
	@FindBy(name="email")
	WebElement Emailtxt ;
	
	@FindBy(name="telephone")
	WebElement telephonetxt;
	
	@FindBy(name="password")
	WebElement passwordtxt;
	
	@FindBy(name="confirm")
	WebElement confirmpasstxt;
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	WebElement yesSubOption;
	
	@FindBy(xpath="(//input[@name='newsletter'])[2]")
	WebElement NoSubOption;
	
	@FindBy(name="agree")
	WebElement agreeCheckbox ;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continuebtn;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement Successfullmsg;
	
	//Action Methods
	public void ClickLoginPageLink() {
		LoginPageLink.click();
	}
	public void EnterFirstName(String fname) {
		FirstNametxt.sendKeys("shrikant");
	}
	public void EnterLastName(String lname) {
		LastNametxt.sendKeys(lname);
	}
	public void EnterEmail(String email) {
		Emailtxt.sendKeys(email);
	}
	public void Entertelephone(String mobno) {
		telephonetxt.sendKeys(mobno);
	}
	public void Enterpassword(String pass) {
		passwordtxt.sendKeys(pass);
	}
	public void Enterconfirmpass(String confirm) {
		confirmpasstxt.sendKeys(confirm);
	}
	public void ClickyesSubOption() {
		yesSubOption.click();
	}
	public void ClickNoSubOption() {
		NoSubOption.click();
	}
	public void ClickagreeCheckbox() {
		agreeCheckbox.click();
	}
	public void ClickContinuebtn() {
		Continuebtn.click();
		
//		Continuebtn.submit();
		
//		Actions action = new Actions(driver);
//		action.moveToElement(Continuebtn).click().perform();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", Continuebtn);
		
//		Continuebtn.sendKeys(Keys.ENTER);
		
//		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(Continuebtn)).click();
	}
	public String GetSuccessfullmsg() {
		try {
			return(Successfullmsg.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}

}
