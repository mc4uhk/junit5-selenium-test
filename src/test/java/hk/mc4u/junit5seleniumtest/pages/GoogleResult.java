package hk.mc4u.junit5seleniumtest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author edmund
 *
 *         This class contain all the locator and methods of login page
 *         Reference: Complete Page Object Model (POM) using Page Factory in
 *         Selenium https://www.youtube.com/watch?v=fUSl-WhqymU
 */

public class GoogleResult extends Page {

	@FindBy(how = How.XPATH, using = "//input[@title='Google 搜尋']")
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//input[@aria-label='Google 搜尋']")
	WebElement searchButton;

	public GoogleResult(WebDriver driver) {
		super(driver);
	}

	public GoogleResult search(String search) {
		searchBox.clear();
		searchBox.sendKeys(search);
		searchBox.sendKeys(Keys.ENTER);
		if (driver.getTitle().startsWith(search)) {
			return PageFactory.initElements(driver, GoogleResult.class);
		} else {
			return null;
		}
	}
}
