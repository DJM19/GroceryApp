package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import automationcore.base_demo;
import constant.Constant;
import pages.HomePage;
import pages.Loginpage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage home;
	ManageNewsPage newspage;
	
	@Test(description="user is trying to add new news")
	public void isUserIsAbleToAddNewNews() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();
		newspage=home.clickOnMoreInfoNews();
		String addnews = ExcelUtility.readStringData(0,0,"addnews");
		newspage.clickNewButton().addnewsinfield(addnews).clickOnAdd();
		
		Boolean alertdisplay=newspage.isalertDisplayed();
		System.out.println(alertdisplay);
		Assert.assertTrue(alertdisplay,Constant.newsaddingerror);
		
	}
	@Test(description="user is trying to search news")
	public void isUserIsAbleTosearchNews() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginpage");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginpage");
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();
		newspage=home.clickOnMoreInfoNews();
		newspage.clickSearch();
		String serachnew = ExcelUtility.readStringData(0,0,"addnews");
		newspage.serachNews(serachnew).clickSearchnews();
		String expected="Search Manage News";
		String actual=newspage.newspage();
		Assert.assertEquals(actual,expected ,Constant.newssearcherror);
		
	}
}
