package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'com/admin/news/add')]")
	WebElement addnewsbutton;
	@FindBy(id = "news")
	WebElement newstext;
	@FindBy(name = "create")
	WebElement addbtn;
	@FindBy(xpath = "//a[contains(@href,'javascript:void(0)')]")
	WebElement clickOnSearch;
	@FindBy(name = "un")
	WebElement searchField;
	@FindBy(name = "Search")
	WebElement searchbtn;

	@FindBy(className = "close")
	WebElement alert;
	@FindBy(xpath = "//h4[text()='Search Manage News']")
	WebElement newstextdispalyed;

	public ManageNewsPage clickNewButton() {
		addnewsbutton.click();
		return this;
	}

	public ManageNewsPage addnewsinfield(String addnews) {
		newstext.sendKeys(addnews);
		return this;
	}

	public ManageNewsPage clickOnAdd() {
		addbtn.click();
		return this;
	}

	public ManageNewsPage clickSearch() {
		clickOnSearch.click();
		return this;
	}

	public ManageNewsPage serachNews(String serachnew) {
		searchField.sendKeys(serachnew);
		return this;
	}

	public ManageNewsPage clickSearchnews() {
		searchbtn.click();
		return this;
	}

	public boolean isalertDisplayed() {
		return alert.isDisplayed();
	}
	
	 public String newspage() {
		 return newstextdispalyed.getText();
		  
	 }
}
