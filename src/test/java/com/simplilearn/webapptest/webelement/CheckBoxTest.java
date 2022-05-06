package com.simplilearn.webapptest.webelement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {

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
	@DisplayName("CheckBox One exist test")
	public void testCheckBox1Exist() throws InterruptedException {
		WebElement checkBox  = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("CheckBox Two exist as default select test")
	public void testCheckBox2Exist() throws InterruptedException {
		
		WebElement checkBox  = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		// default selected.
		assertEquals(true, checkBox.isSelected());
	}
	
	@Test
	@DisplayName("Select CheckBox One test")
	public void testSelectCheckBox1() throws InterruptedException {
		WebElement checkBox  = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		assertEquals(false, checkBox.isSelected());
		//select checkbox
		checkBox.click();
		assertEquals(true, checkBox.isSelected());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Deselect CheckBox Two test")
	public void testDeSelectCheckBox2() throws InterruptedException {
		WebElement checkBox  = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox.isDisplayed());
		assertEquals(true, checkBox.isEnabled());
		// default select
		assertEquals(true, checkBox.isSelected());
		//select checkbox
		checkBox.click();
		assertEquals(false, checkBox.isSelected());
		Thread.sleep(3000);
	}
}
