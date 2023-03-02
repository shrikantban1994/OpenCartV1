package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement linkMyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement linkRegister;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement linkLogin;
	
	@FindBy(xpath = "//input[@name='search']")
	WebElement Searchtxt;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement Searchbtn;
	
	//Action Methods
	public void ClickOnMyAccountLink() {
		linkMyAccount.click();
	}

	public void ClickOnRegisterLink() {
		linkRegister.click();
	}

	public void ClickOnLoginLink() {
		linkLogin.click();
	}
	public void EnterSearchitem(String item) {
		Searchtxt.sendKeys(item);
	}
	public void ClickOnSearchbtn() {
		Searchbtn.click();
	}
}
