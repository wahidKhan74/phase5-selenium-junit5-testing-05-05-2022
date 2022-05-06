package com.simplilearn.webapptest.external.webelement;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomBrowserPopupTest {
	

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
	@DisplayName("Amazon Test : Browser Location Popup Test")
	public void testLocationPopup() throws InterruptedException { 
		//click to launch a popup
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		
		//switch from main window to popup window
		String mainWindow = driver.getWindowHandle();
		
		// list of external popup
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			
			// enter pin code
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500001");
			
			//submit location
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
			
		}
		driver.switchTo().window(mainWindow);		
		Thread.sleep(5000);
	}
}
