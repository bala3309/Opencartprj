package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException {
		
		logger.info("****TC_03 Login DDT started*********");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccount
			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExsist();

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {

					mp.clickLogout();
					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);

				}

			}

			if (exp.equalsIgnoreCase("invalid")) {

				if (targetPage == true) {

					mp.clickLogout();
					Assert.assertTrue(false);
				} else {

					Assert.assertTrue(true);

				}

			}
		}

		catch (Exception e) {
			Assert.fail();
		}
		
		Thread.sleep(5000);
		logger.info("****TC_03 Login DDT Finished*********");

	}

}
