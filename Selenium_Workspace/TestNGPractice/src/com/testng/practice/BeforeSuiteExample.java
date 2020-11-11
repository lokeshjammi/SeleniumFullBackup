package com.testng.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeSuiteExample {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.google.com";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		System.out.println("Before test method is running");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("After test method is running");
	}

	@Test
	public void test() {
		driver.get(URL);
		System.out.println("Test Method is running");
	}

	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Before suite method is running");
	}

	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("After suite method is running");
	}
}
