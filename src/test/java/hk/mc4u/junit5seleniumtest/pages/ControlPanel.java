package hk.mc4u.junit5seleniumtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author edmund
 *
 *This class contain all the locator and methods of login page
 *Reference:
 *Complete Page Object Model (POM) using Page Factory in Selenium
 *https://www.youtube.com/watch?v=fUSl-WhqymU
 */

public class ControlPanel {
	WebDriver driver;

	//just two different ways to do the same thing
	@FindBy(how = How.LINK_TEXT,using = "HelloWorld")
	WebElement itemName;

	public ControlPanel(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLink(String linkText) {
		itemName = driver.findElement(By.linkText(linkText));
		itemName.click();
	}
}
