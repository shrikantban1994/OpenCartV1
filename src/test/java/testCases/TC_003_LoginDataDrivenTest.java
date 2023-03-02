package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups= {"Master"})
	public void test_loginDDT(String email,String password,String exp)
	{
		try {
		logger.info("****   started TC_003_LoginDDT   ****");
		
		HomePage hp= new HomePage(driver);
		hp.ClickOnMyAccountLink();;
		logger.info("clicked on MyAccount");
		hp.ClickOnLoginLink();;
		logger.info("clicked on login");
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(email);
		logger.info("entered email address");
		lp.enterPass(password);
		logger.info("Entered password");
		lp.ClickOnLoginbtn();;
		Thread.sleep(4000);
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				macc.ClickOnlogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				macc.ClickOnlogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		
		/*hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clicklnklogin();
		logger.info("clicked on login");
		*/
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
