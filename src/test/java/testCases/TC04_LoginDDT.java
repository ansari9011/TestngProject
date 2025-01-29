package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.DataProvider;



import java.io.IOException;



import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.ExcelUtility;

public class TC04_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData")

	public void Verify_LoginSST(String email, String PWD, String Exp) {

		try {
			HomePage HP = new HomePage(driver);

			HP.ClickOnMYaccount();
			HP.clickLogin();

			// Login
			LoginPage LP = new LoginPage(driver);
			LP.setEmailAddress(email);
			LP.setPassword(PWD);
			LP.ClickLogin();

			// MyAccount

			MyAccountPage mcc = new MyAccountPage(driver);
			boolean targetpage = mcc.isMyaccountPage();

			if (Exp.equalsIgnoreCase("Valid")) {

				if (targetpage == true) {
					mcc.ClickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (Exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);

				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="\\TESTING NOTES\\SALENIUM\\framework\\14SetAutomation_Framework 4\\14SetAutomation_Framework\\testData\\TestData.xlsx";//taking excel file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	 //5
		
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][] = new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	
}
