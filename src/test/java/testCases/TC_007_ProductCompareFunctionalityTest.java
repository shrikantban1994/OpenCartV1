package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_007_ProductCompareFunctionalityTest extends BaseClass {
	@Test(groups= {"Master","Sanity","Regression"})
	public void ProductCompareFunctionalityTest() {
		logger.info("Starting TC_007_ProductCompareFunctionality test");
		try {
			HomePage hp =new HomePage(driver);
			hp.ClickOnMyAccountLink();
			hp.ClickOnLoginLink();
			
			LoginPage lp =new LoginPage(driver);
			lp.enterEmail(rb.getString("email"));
			lp.enterPass(rb.getString("password"));
			lp.ClickOnLoginbtn();
			logger.info("Login into application");
			hp.EnterSearchitem("mac");
			hp.ClickOnSearchbtn();
			logger.info("Navigate to search page");
			
			SearchPage sp =new SearchPage(driver);
			sp.ClickOnComapareiMacbtn();
			logger.info("Clicked on iMac Compare button");
			Thread.sleep(5000);
			sp.ClickOnComapareMacBookbtn();
			logger.info("Clicked on MacBook Compare button");
			sp.ClickOnTotalComparelink();
			logger.info("Clicked on Total Compare link and navigate capare product page");
			Thread.sleep(5000);
			String PageTitle = driver.getTitle();
			if(PageTitle.equals("Product Comparison")) {
				Assert.assertTrue(true);
				logger.info("Test case passed");
			}else {
				Assert.assertTrue(false);
				logger.info("Test case failed");
			}
			
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("End TC_007_ProductCompareFunctionality test");
	
	}
	
}
