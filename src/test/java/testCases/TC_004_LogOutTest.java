package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_004_LogOutTest extends BaseClass {
	@Test(groups= {"Sanity","Master","Regression"})
	public void LogOutTest() {

		logger.info("Starting TC_004_LogOutTest");
		try {
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccountLink();
			logger.info("Click on MyAccount link");
			hp.ClickOnLoginLink();
			logger.info("Click on Login link");
			LoginPage lp = new LoginPage(driver);
			lp.enterEmail(rb.getString("email"));
			logger.info("Entered mail");
			lp.enterPass(rb.getString("password"));
			logger.info("Entered Password");
			lp.ClickOnLoginbtn();
			logger.info("Click on Login Button");
			MyAccountPage map = new MyAccountPage(driver);
			if(map.isMyAccountPageExist()) {
				Assert.assertTrue(true);
				logger.info("MyAccount Page Verification pass");
			}else {
				Assert.assertTrue(false);
				logger.info("MyAccount Page Verification fail");
			}
			
			map.ClickOnlogout();
			logger.info("Clicked on Logout button");
			LogOutPage lop= new LogOutPage(driver);
			if(lop.LogOutPageVerify()) {
				Assert.assertTrue(true);
				logger.info("Logout Page Verification pass");
			}else {
				Assert.assertFalse(false);
				logger.info("Logout Page Verification fail");
			}
			lop.ClickOnContinuebtn();
			String PageTitle = driver.getTitle();
			if(PageTitle.equals("Your Store")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("End TC_004_LogOutTest");
	}

}
