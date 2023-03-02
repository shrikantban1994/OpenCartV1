package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"Master","Sanity"})
	public void LoginTest() {
		
		logger.info("Starting TC_002_LoginTest");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.ClickOnMyAccountLink();
		hp.ClickOnLoginLink();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(rb.getString("email"));
		lp.enterPass(rb.getString("password"));
		lp.ClickOnLoginbtn();
		lp.VerifyBrokenLinks();
		
		MyAccountPage map =new MyAccountPage(driver);
		boolean targetPage =map.isMyAccountPageExist();
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
