package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import automationcore.base_demo;
import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends 	Base {
HomePage home;
AdminUsersPage userpage;
	@Test(description="user is trying to register new admin user")
	public void isUserIsAbleToRegisterNewUser() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();
		userpage=home.clickOnMoreInfo();
		RandomDataUtility random=new RandomDataUtility();
		//String newusernamevalue = ExcelUtility.readStringData(0,0,"adminuser");
		//String newpasswordvalue = ExcelUtility.readStringData(0,1,"adminuser");
		String newusernamevalue =random.randomusername();
		String newpasswordvalue = random.randomPassword();
		userpage.clickaddButton().enterUsername(newusernamevalue).enterPassword(newpasswordvalue).selectDashboard().clickSubmit();
		Boolean alertdisplay=userpage.isalertDisplayed();
		System.out.println(alertdisplay);
		Assert.assertTrue(alertdisplay,Constant.useraddingerror);
	}
	@Test(description="user is trying to search admin user")
	
	public void isUserIsAbleToSearchtheUser() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();
		userpage=home.clickOnMoreInfo();
		String newuser = ExcelUtility.readStringData(0,0,"adminuser");
		userpage.clickOnSearchButton().serachcurrentuser(newuser).selecttype().clickSearch();
		String expected="Admin Users";
		String actual=userpage.admintext();
		Assert.assertEquals(actual,expected ,Constant.adminusersearcherror);
		
	}
	@Test(description="user is trying to retry")
	public void userisAbleToReset() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();
		userpage=home.clickOnMoreInfo();
		userpage.clickResetButton();
		String expected="Admin Users";
		String actual=userpage.admintext();
		Assert.assertEquals(actual,expected ,Constant.adminpagereseterror);
	}
}
