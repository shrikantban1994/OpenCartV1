package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
		// elements
		@FindBy(name="email")
		WebElement emailtxt ;
		
		@FindBy(id="input-password")
		WebElement passtxt;
		
		@FindBy(xpath="(//a[text()='Forgotten Password'])[1]")
		WebElement forgotPasslink ;
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement loginbtn;
		
		@FindBy(xpath="//a[text()='Continue']")
		WebElement continuebtn;
		
		@FindBy(tagName="a")
		List<WebElement> LinkList ;
		
		//Action methods
		public void enterEmail(String mail) {
			emailtxt.sendKeys(mail);
		}
		public void enterPass(String pass) {
			passtxt.sendKeys(pass);
		}
		public void ClickOnforgotpasslink() {
			forgotPasslink.click();
		}
		public void ClickOnLoginbtn() {
			loginbtn.click();
		}
		public void ClickOncontinuebtn() {
			continuebtn.click();
		}
		public String VerifyBrokenLinks() throws IOException {
			for (WebElement element : LinkList) {
				String url = element.getAttribute("href");
				URL link = new URL(url);
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();
				if (httpConn.getResponseCode() >= 400) {
					return url + " - " + "is Broken Link";
				} else {
					return url + " - " + "is valid Link";
				}

			}
			return "Tast case failed";
		}
}
