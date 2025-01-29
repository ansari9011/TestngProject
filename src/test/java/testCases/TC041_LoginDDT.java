package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.excelUtility2;

public class TC041_LoginDDT extends BaseClass{
	
	
	
	
	@Test(dataProvider = "logindata")
	public void Verify_LoginDDT(String email,String PWD,String Exp) {
		try {
		HomePage hp= new HomePage(driver);
		hp.ClickOnMYaccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(PWD);
		lp.ClickLogin();
		
		MyAccountPage mcp=new MyAccountPage(driver);
	boolean targetpage=	mcp.isMyaccountPage();
	
	if(Exp.equalsIgnoreCase("Valid")) {
		
		if(targetpage==true) {
			mcp.ClickLogout();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	
	if(Exp.equalsIgnoreCase("Invalid")) {
		if(targetpage==true) {
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
	}
		}catch (Exception e) {
			Assert.fail();
		}
		
	}
	@DataProvider(name= "logindata")
	public String[][] getData() throws IOException {
		
		String path="\\TESTING NOTES\\SALENIUM\\framework\\14SetAutomation_Framework 4\\14SetAutomation_Framework\\testData\\TestData.xlsx";
		excelUtility2 xlutil= new excelUtility2(path);
	int totalrowcount=	xlutil.getRowCount("Sheet1");
	int totalcellcount=xlutil.getCellCount("Sheet1", 1);
	String logindata[][]= new String [totalrowcount][totalcellcount];
	
	for(int i=1;i<=totalrowcount;i++) {
		for(int j=0;j<totalcellcount;j++) {
			logindata[i-1][j]=	xlutil.getCellData("Sheet1", i, j);
		}
	}
	return logindata;
		
		
	}
	
	

}
