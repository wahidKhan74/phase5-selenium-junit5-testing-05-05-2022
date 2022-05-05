package com.simplilearn.webapptest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleHomepageTest {

	// step1: formulate a test url & driver path
	String siteUrl = "https://www.google.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// 2. set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);
		// 3. instantiate selenium web driver
		driver = new ChromeDriver();
		// 4. launch browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		// 6. close driver
		driver.close();
	}

	@Test
	@DisplayName("Test Google Home Page Correct Title")
	public void testGoogleHomePage() {
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	@DisplayName("Test Google Home Page Incorrect Title")
	public void testGoogleHomePage2() {
		String expectedTitle = "Goooooogle";
		String actualTitle = driver.getTitle();
		assertNotEquals(expectedTitle, actualTitle);
	}
	
	@Test
	@DisplayName("Test Google Home Page Source URL")
	public void testGoogleHomePage3() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
}
