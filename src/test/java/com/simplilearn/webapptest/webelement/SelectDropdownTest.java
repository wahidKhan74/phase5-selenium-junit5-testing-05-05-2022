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
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownTest {

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
	@DisplayName("Select Dropdown exist test")
	public void testSelectDropdownExist() throws InterruptedException {
		WebElement dropdown    = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		assertEquals(false, dropdown.isSelected());
	}
	
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	public void testSelectDropdownOption() throws InterruptedException {
		// locate select drop down
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		
		// Select for map web element to select option
		Select select = new Select(dropdown);
	
		// select bike as a selected option
		select.selectByVisibleText("Bike");
		
		//getelected option
		WebElement selectedValue = select.getFirstSelectedOption();
		
		assertEquals(" Bike ", selectedValue.getText());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test 3rd index as selected option from dropdown")
	public void test3rdIndexSelectDropdownOption() throws InterruptedException {
		// locate select drop down
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		
		// Select for map web element to select option
		Select select = new Select(dropdown);
	
		// select airplane from index 3 as a selected option
		select.selectByIndex(3);
		
		//get selected option
		WebElement selectedValue = select.getFirstSelectedOption();
		
		assertEquals(" Airplane ", selectedValue.getText());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test select option by value from dropdown")
	public void testSelectByValueDropdownOption() throws InterruptedException {
		// locate select drop down
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		
		// Select for map web element to select option
		Select select = new Select(dropdown);
	
		// select bike as a selected option
		select.selectByValue("car");
		
		//get selected option
		WebElement selectedValue = select.getFirstSelectedOption();
		
		assertEquals(" Car ", selectedValue.getText());
		
		Thread.sleep(3000);
	}
}
