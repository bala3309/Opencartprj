package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verifyLogin() {
		
		logger.info("******TC_002_LoginTest Started******");
		
		try {
		//Home
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// login
		LoginPage lp =new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mp =new MyAccountPage(driver);
		boolean result = mp.isMyAccountPageExsist();
		Assert.assertTrue(result);
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		
		logger.info("******TC_002_Login Test finished");
		

	}

}
