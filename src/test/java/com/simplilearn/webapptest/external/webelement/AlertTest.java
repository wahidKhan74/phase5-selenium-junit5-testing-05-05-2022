package com.simplilearn.webapptest.external.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTest {

	String siteUrl = "file:///home/wahidkhan74gmai/eclipse-workspace/phase5-selenium-junit5-testing-05-05-2022/static/alert-web-elements.html";
	String driverPath = "drivers/linux/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		 driver.close();
	}

	@Test
	@DisplayName("Simple Alert dailog test")
	public void testAlertDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		//switch to sub window alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Do you really want to proceed ??", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Confirmation dailog test with accept")
	public void testConfirmDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		//switch to sub window alert
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with ok button click
		confirm.accept();
	}
	
	
	@Test
	@DisplayName("Confirmation dailog test with cancel")
	public void testConfirmDailogWindowCancel() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		//switch to sub window alert
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with cancel button click
		confirm.dismiss();
	}
	
	
	@Test
	@DisplayName("Prompt  dailog test with accept")
	public void testPromptDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();
		//switch to sub window alert
		Alert propmt = driver.switchTo().alert();
		assertEquals("Please enter your name.", propmt.getText());
		propmt.sendKeys("John Smith");
		
		Thread.sleep(3000);		
		// propmt with accept button click
		propmt.accept();
	}
}
