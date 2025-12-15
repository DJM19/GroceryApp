package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	 PageUtility page=new PageUtility();

	public WebDriver driver;
	
	
	 public AdminUsersPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 @FindBy(xpath="//a[contains(@href,'javascript:void(0)')and contains(@class,'btn-danger')]")  WebElement addbtn;
	 @FindBy(id="username")  WebElement usernameTextField;
	 @FindBy(id="password") WebElement passwordField;
	 @FindBy(id="user_type") WebElement dropdown;
	 @FindBy(name="Create") WebElement submitbtn;
	 @FindBy(className="close")	WebElement alert; 
	 
	 
	 public AdminUsersPage clickaddButton() {
		 addbtn.click();
		 return this;
	 }
	 
	 public AdminUsersPage enterUsername(String newusernamevalue)
		{
		 usernameTextField.sendKeys(newusernamevalue);
		 return this;
		}
	 
	 public AdminUsersPage enterPassword(String newpasswordvalue) {
		 passwordField.sendKeys(newpasswordvalue);
		 return this;
	 }
	 
	 public AdminUsersPage selectDashboard() {
		 page.selectvalue(dropdown, "Admin");
		 return this;
			/*
			 * Select select = new Select(dropdown); 
			 * select.selectByVisibleText("Admin");
			 */
	 }
	 public AdminUsersPage clickSubmit() {
		submitbtn.click(); 
		return this;
	 }
	 public boolean isalertDisplayed() {
		 return alert.isDisplayed();
	 }
	 @FindBy(xpath="//a[contains(@href,'javascript:void(0)')and contains(@class,'btn-primary')]") WebElement serachbtn;
	 @FindBy(id="un") WebElement searchuser;
	 @FindBy(id="ut") WebElement type;
	 @FindBy(name="Search") WebElement btnSerach;
	 @FindBy(xpath="//h1[text()='Admin Users']") WebElement textadmin;
	 
	 public AdminUsersPage clickOnSearchButton() {
		 serachbtn.click();
		 return this;
	 }
	 public AdminUsersPage serachcurrentuser(String newuser) {
		 searchuser.sendKeys(newuser);
		 return this;
	 }
	 public AdminUsersPage selecttype() {
		 page.selectvalue(type, "Admin");

		 return this;
	 }
	 public AdminUsersPage clickSearch() {
		 btnSerach.click();
		 return this;
	 }
	 
	 public String admintext() {
		 return textadmin.getText();
		  
	 }
	 
	 @FindBy(xpath="//a[contains(@href,'com/admin/list-admin')and contains(@class,'btn-warning')]") WebElement resetBtn;
	 
	 public AdminUsersPage clickResetButton() {
		 resetBtn.click();
		 return this;
	 }
}
