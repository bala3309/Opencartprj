package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UserRegisterPage;
import testbase.BaseClass;

public class TC_001_UserAccountRegistration extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void account_Registration() {

		try {

			logger.info("**Starting TC_001_UserAccountRegistration**");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();

			logger.info("**Clicked My account Link**");
			hp.clickRegister();

			logger.info("**Clicked Register Link**");

			UserRegisterPage register = new UserRegisterPage(driver);

			logger.info("**Entering Customer details**");

			register.setFirstName(randomString().toUpperCase());
			register.setLastName(randomString().toUpperCase());
			register.setEmail(randomString() + "@gmail.com"); // generate random email
			register.setTelephone(randomNumber());

			String password = randomPwd();

			register.setpwd(password);
			register.setConfirmPwd(password);
			register.chkPolicy();
			register.clickContinue();

			logger.info("** validating expected message**");

			String confirmationMsg = register.getConfirmationMsg();

			if (confirmationMsg.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);

			} else {

				logger.error("Test failed");
				logger.debug("debug logg");

				Assert.assertTrue(false);

			}

			// Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");

		}

		catch (Exception e) {

			Assert.fail();
		}

		logger.info("**TC_001 UserAccountRegistration Finished**");

	}

}
