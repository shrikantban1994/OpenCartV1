package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_006_Search extends BaseClass {
	@Test(groups= {"Master","Sanity","Regression"})
	public void SearchFunctionalityTest() {
		logger.info("Starting TC_006_Search test");
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
			String Title = driver.getTitle();
			if(Title.equals("Search - mac")) {
				Assert.assertTrue(true);
				logger.info("Test case is passed");
			}else {
				Assert.assertTrue(false);
				logger.info("Test Case is failed");
			}
			
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("End TC_006_Search test");
	}

}
