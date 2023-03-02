package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_005_ForgotPasswordTest extends BaseClass {
	@Test(groups= {"Sanity","Master","Regression"})
	public void ForgotPasswordTest() {

		try {
			logger.info("Starting TC_005_ForgotPasswordTest");
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccountLink();
			logger.info("Clicked on MyAccount link");
			hp.ClickOnLoginLink();
			logger.info("Clicked on LoginPage link");
			LoginPage lp = new LoginPage(driver);
			lp.ClickOnforgotpasslink();
			logger.info("Clicked on ForgotPassword link");
			
			ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
			fpp.EnterMail(rb.getString("email"));
			logger.info("Entered Mailid");
			if (fpp.IsDisplyedBackbtn()) {
				Assert.assertTrue(true);
				logger.info("Displayed back button verification pass");
			} else {
				Assert.assertTrue(false);
				logger.info("Displayed back button verification fail");
			}
			fpp.ClickOnContinuebtn();
			logger.info("Clicked on Continue btn");
			if (fpp.VerifyConfirmationMSG()) {
				Assert.assertTrue(true);
				logger.info("Displayed Confirmation massege verification pass");
			} else {
				Assert.assertTrue(false);
				logger.info("Displayed Confirmation massege verification pass");
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("End TC_004_ForgotPasswordTest");

	}

}
