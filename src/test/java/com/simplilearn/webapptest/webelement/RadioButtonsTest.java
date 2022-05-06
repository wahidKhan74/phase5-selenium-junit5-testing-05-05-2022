package com.simplilearn.webapptest.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioButtonsTest {

	String siteUrl = "file:///home/wahidkhan74gmai/eclipse-workspace/phase5-selenium-junit5-testing-05-05-2022/static/web-elements.html";
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
	@DisplayName("Radio button One exist test")
	public void testRadioButton1Exist() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	@Test
	@DisplayName("Radio button OTwone exist test")
	public void testRadioButton2Exist() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
	}
	
	
	@Test
	@DisplayName("Select Radio button One test")
	public void testSelectRadioButton1() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		/// select radio button one
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Select Radio button Two test")
	public void testSelectRadioButton2() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("female"));
		assertEquals(true, radioButton.isDisplayed());
		assertEquals(true, radioButton.isEnabled());
		assertEquals(false, radioButton.isSelected());
		/// select radio button one
		radioButton.click();
		assertEquals(true, radioButton.isSelected());
		Thread.sleep(3000);
	}
}
