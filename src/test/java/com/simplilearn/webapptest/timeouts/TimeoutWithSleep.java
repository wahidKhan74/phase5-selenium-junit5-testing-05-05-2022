package com.simplilearn.webapptest.timeouts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimeoutWithSleep {

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
	@DisplayName("Amazon Test : Customer Service Link")
	public void testBestSellerNavLink3() throws InterruptedException {
		// locate todays deals nav link on webpage
		WebElement custLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
		custLink.click();
		Thread.sleep(5000);
		String expected = "Help - Amazon Customer Service";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

}
