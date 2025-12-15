package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText("Admin");
	}

	public boolean selectRadiobutton(WebElement radiobutton) {
		return radiobutton.isSelected();

	}

	public void alertconfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertcancel(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

}
