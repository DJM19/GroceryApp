package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import automationcore.base_demo;
import constant.Constant;
import pages.HomePage;
import pages.Loginpage;

import utilities.ExcelUtility;


	

	public class LoginTest extends 	Base
	{
		HomePage home;
		@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
		public void verifyUserwithValidCredentials() throws IOException
		{
			String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
			String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
			
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
			home=loginpage.clickLoginButton();
			Boolean dashboardDisplyed=loginpage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplyed,Constant.validcredentialerror);
		}
		@Test(priority=2,description = "user is trying to login with invalid username and valid password",retryAnalyzer=retry.Retry.class)
		public void verifyInvalidusernameandValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.readStringData(1, 0, "loginpage");
			String passwordvalue = ExcelUtility.readStringData(1, 1, "loginpage");
			
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();
			String expected="7rmart supermarket";
			String actual=loginpage.isTitleDisplayed();
			Assert.assertEquals(actual,expected ,Constant.invalidcredentialerror);
		}
		@Test(priority=3)
		public void verifyValidusernameandInvalidPassword() throws IOException {
			String usernamevalue = ExcelUtility.readStringData(2, 0, "loginpage");
			String passwordvalue = ExcelUtility.readStringData(2, 1, "loginpage");
			
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();
			String expected="7rmart supermarket";
			String actual=loginpage.isTitleDisplayed();
			Assert.assertEquals(actual,expected ,Constant.invalidcredentialerror);
		}
		@Test(priority=4,description="user is trying to login with invalid credentials",groups= {"smoke"},dataProvider = "loginProvider")
		public void verifyINalidusernameandInvalidPassword(String usernamevalue,String passwordvalue) throws IOException {
			/*
			 * String usernamevalue = ExcelUtility.readStringData(3, 0, "loginpage"); String
			 * passwordvalue = ExcelUtility.readStringData(3, 1, "loginpage");
			 */
			
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();
			String expected="7rmart supermarket";
			String actual=loginpage.isTitleDisplayed();
			Assert.assertEquals(actual,expected ,Constant.invalidcredentialerror);
		}	
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
		// new Object[] {ExcelUtility.getStringData(3,
		// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		}
		
	}