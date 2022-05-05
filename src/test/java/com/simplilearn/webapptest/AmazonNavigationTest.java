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

public class AmazonNavigationTest {

	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test : BestSeller Link")
	public void testBestSellerNavLink() {
		// locate mobile nav link on webpage
		WebElement bestLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		bestLink.click();
		String expected = "Amazon.in Bestsellers: The most popular items on Amazon";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Amazon Test : Todays Deals Link")
	public void testBestSellerNavLink2() {
		// locate todays deals nav link on webpage
		WebElement todayLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));
		todayLink.click();
		String expected = "";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Amazon Test : Customer Service Link")
	public void testBestSellerNavLink3() {
		// locate todays deals nav link on webpage
		WebElement custLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
		custLink.click();
		String expected = "Help - Amazon Customer Service";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

}
