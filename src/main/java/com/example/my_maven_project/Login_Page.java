package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Login_Page(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Username(String uName) {
		WebElement userName=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='inputEmail']")));
		userName.clear();
		userName.sendKeys(uName);
		
	}
	
	public void click_Password(String pwd) {
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='inputPassword']")));
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void click_LoginBtn() {
		WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Login']")));
		js.executeScript("arguments[0].click();", login);
	}
	
	public boolean usernameErrorDisplay() {
		
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='inputEmail']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean passwordErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='inputPassword']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean LoginErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='alert alert-danger']"))).getText() != null;
		} catch (Exception e) {
			return false;
		}
	}

}
