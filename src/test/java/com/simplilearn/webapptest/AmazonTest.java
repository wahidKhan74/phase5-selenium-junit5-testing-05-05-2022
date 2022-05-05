package com.simplilearn.webapptest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class AmazonTest {

	// step1: formulate a test url & driver path
	String siteUrl = "https://www.amazon.in/";
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
	@DisplayName("Amazon Test : Homepage Title ")
	void testAmazonHomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Amazon Test :  Soruce URl")
	void testAmazonHomeSourceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}

	@Test
	@DisplayName("Amazon Test :  Search product 1")
	void testAmazonSearchProductTest() {
		// search text
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();

		// 5. perform test
		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Amazon Test :  Search product 2")
	void testAmazonSearchProductTest2() {
		// search text
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Apple mac book");
		searchBox.submit();

		// 5. perform test
		String expected = "Amazon.in : Apple mac book";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

}
