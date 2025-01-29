package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;

import PageObjects.AccountRegistrationPAge;
import PageObjects.HomePage;

public class TC01_AccountRegistrationTest extends BaseClass {

	@Test
	public void Verifry_Account_Registration() {

		try {
			
		HomePage HP = new HomePage(driver);
		HP.ClickOnMYaccount();
		logger.info("Click on the MyAccount link");

		HP.clikRegister();
		logger.info("Click on the Register link");

		AccountRegistrationPAge AP = new AccountRegistrationPAge(driver);
		logger.info("Providing customer details....");

		AP.setFirstName(randomString().toLowerCase());
		

		AP.setLastName(randomString().toUpperCase());
		AP.setEmail(randomAplaNumeric() + "@gmail.com");
		AP.setTelephonel(randomNumber());

		String Password = randomAplaNumeric();
		AP.setPassword(Password);
		AP.enter_ConfirmPassword(Password);

		AP.setPrivacy();
		AP.ClickContinue();
		logger.info("validating expected Message....");

		String confmsg = AP.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")){
		
		 AssertJUnit.assertTrue(true);
		}
		else{	
			 logger.error("Test failed");
			 AssertJUnit.assertTrue(false);
		}
		}
		catch (Exception e) {	
		Assert.fail();
		}
		logger.info("***** Finshied TC01_ AccountRegistrationTest ****");

	}

}
