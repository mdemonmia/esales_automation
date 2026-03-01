package com.example.my_maven_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected static WebDriver driver;
	
	@BeforeSuite
	public void Setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown() {
		if(driver !=null) {
			driver.quit();
			driver=null;
		}
	}

}
