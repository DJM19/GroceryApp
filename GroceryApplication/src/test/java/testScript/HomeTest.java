package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import automationcore.base_demo;
import constant.Constant;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage home;
@Test(description="user is trying to logout")
public void verifyUserisabletoSuccessfullyLoggedoutCredentials() throws IOException {
	String userNameValue=ExcelUtility.readStringData(0, 0, "LoginPage");
	String passwordValue=ExcelUtility.readStringData(0, 1, "LoginPage");
	Loginpage loginpage=new Loginpage(driver);
	loginpage.verifyValidUsernameonUsernamefield(userNameValue).verifyValidPasswordonPasswordfield(passwordValue);
	home=loginpage.clickLoginButton();
	home.clickOnadminButton();
	loginpage=home.clickOnLoginoutButton();
	String expected="7rmart supermarket";
	String actual=loginpage.isTitleDisplayed();
	Assert.assertEquals(actual,expected ,Constant.logouterror);
	
}

}
