package hk.mc4u.junit5seleniumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author edmund
 *
 *         This class contain all the locator and methods of login page
 *         Reference: Complete Page Object Model (POM) using Page Factory in
 *         Selenium https://www.youtube.com/watch?v=fUSl-WhqymU
 */

public class LoginPage3 {
	WebDriver driver;

	// just two different ways to do the same thing
	@FindBy(id = "j_username")
	WebElement login;

	@FindBy(how = How.NAME, using = "j_password")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	WebElement loginButton;

	public LoginPage3(WebDriver driver) {
		this.driver = driver;
	}

	public Class<ControlPanel> performLogin(String login, String password) {
		this.login.sendKeys(login);
		this.password.sendKeys(password);
		loginButton.click();
		if (driver.getTitle().startsWith("Dashboard")) {
			return ControlPanel.class;
		} else {
			return null;
		}
	}
}
