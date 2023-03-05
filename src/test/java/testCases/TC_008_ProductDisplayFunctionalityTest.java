package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_008_ProductDisplayFunctionalityTest extends BaseClass {
	@Test(groups= {"Master","Sanity","Regression"})
	public void ProductCompareFunctionalityTest() {
		logger.info("Starting TC_008_ProductDisplayFunctionality test");
		try {
			HomePage hp =new HomePage(driver);
			hp.ClickOnMyAccountLink();
			hp.ClickOnLoginLink();
			
			LoginPage lp =new LoginPage(driver);
			lp.enterEmail(rb.getString("email"));
			lp.enterPass(rb.getString("password"));
			lp.ClickOnLoginbtn();
			logger.info("Login into application");
			hp.EnterSearchitem("iMac");
			hp.ClickOnSearchbtn();
			logger.info("Navigate to search page");
			
			SearchPage sp =new SearchPage(driver);
			sp.ClickOniMacimg();
			logger.info("Clicked on iMac image");
			Thread.sleep(5000);
			String PageTitle = driver.getTitle();
			if(PageTitle.equals("iMac")) {
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}else {
				Assert.assertTrue(false);
				logger.info("Test case failed");
			}
			
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("End TC_008_ProductDisplayFunctionality test");
	
	}
	
}
