package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Master","Regression"})
	void test_Account_Registration() throws IOException {
		
		logger.debug("Application logs......");
		logger.info("*** Staring TC_001_AccountRegistrationTest *** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccountLink();
			logger.info("Clicked on MyAccount link");
			hp.ClickOnRegisterLink();
			logger.info("Clicked on Register link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regpage.EnterFirstName(randomString());
			regpage.EnterLastName(randomString());
			regpage.EnterEmail(randomString() + "@gmail.com");
			regpage.Entertelephone(randomNumber());
			String password = randomAlphaNumeric();
			regpage.Enterpassword(password);
			regpage.Enterconfirmpass(password);
			regpage.ClickyesSubOption();
			regpage.ClickagreeCheckbox();
			regpage.ClickContinuebtn();
			logger.info("Clicked on Continue button");
			Thread.sleep(5000);
			String confmsg = regpage.GetSuccessfullmsg();
			logger.info("Validating Expected Message");
			Assert.assertEquals(confmsg, "Congratulations! Your new account has been successfully created!",
					"Test failed");
		} catch (Exception e) {
			
			logger.error("Test failed");
			Assert.fail();
			
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest *** ");
	}

}
