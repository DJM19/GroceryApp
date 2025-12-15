package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
	//create constructor
	
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	
	 @FindBy(xpath="//img[contains(@src,'com/public/assets/admin/dist/img/avatar5.png')]") private WebElement adminbtn;
	 @FindBy(xpath="//a[contains(@href,'com/admin/logout')and @class='dropdown-item']") private  WebElement logoutbtn;
	 @FindBy(xpath="//a[contains(@href,'com/admin/list-admin')and @class='small-box-footer']") private WebElement moreinfoobutton;
	 @FindBy(xpath="//a[contains(@href,'com/admin/list-news')and @class=\"small-box-footer\"]") private WebElement moreinfonews;
	 @FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;
	 public HomePage clickOnadminButton() {
		 adminbtn.click();
		 return this;
	 }
	 public Loginpage clickOnLoginoutButton() {
		 logoutbtn.click();
		 return new Loginpage(driver);
	 }
	 public AdminUsersPage clickOnMoreInfo() {
		 moreinfoobutton.click();
		 return new AdminUsersPage(driver);
	 }
	 public ManageNewsPage clickOnMoreInfoNews() {
		 moreinfonews.click();
		 return new ManageNewsPage(driver);
	 }
	 public String isTitleDisplayed() {
			return text.getText();
		}
}
