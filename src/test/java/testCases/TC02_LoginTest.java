package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC02_LoginTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void vrify_Login() {

		logger.info("***** Startign TC_02_LoginTest");

		try {
			// Home Page
			HomePage HP = new HomePage(driver);
			logger.info("Navigating to the Home Page.");

			logger.info("Clicking on 'My Account'.");

			HP.ClickOnMYaccount();

			logger.info("Clicking on 'Login'.");

			HP.clickLogin();

			// Login
			logger.info("Navigating to the Login Page.");

			LoginPage LP = new LoginPage(driver);
			LP.setEmailAddress(UserEmail);
			LP.setPassword(password);

			LP.ClickLogin();

			// Myaccount

			MyAccountPage MA = new MyAccountPage(driver);

			boolean text = MA.isMyaccountPage();
			AssertJUnit.assertTrue(text);

			MA.ClickLogout();
		} catch (Exception e) {
			Assert.fail();
		}

	}
		

}
