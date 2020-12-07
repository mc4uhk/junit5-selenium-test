package hk.mc4u.junit5seleniumtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import hk.mc4u.junit5seleniumtest.pages.GoogleHome;
import hk.mc4u.junit5seleniumtest.pages.GoogleResult;

public class GooglePageTest extends JUnitTestBase {

	private GoogleHome page;

	@BeforeEach
	public void initPageObjects() {
		page = PageFactory.initElements(driver, GoogleHome.class);
	}

	@Test
	public void testHomePageHasAHeader() throws InterruptedException {
		driver.get(page.getUrl());
		GoogleResult resultPage = page.search("java");
		resultPage.search("maven")
			.search("junit")
			.search("junit 5");
		Thread.sleep(3000);
//		Assertions.assertFalse("".equals(page.header.getText()));
	}
}
