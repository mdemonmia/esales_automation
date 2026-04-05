package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Division {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Division(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_Division() {
		WebElement click_divi=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Division']")));
		js.executeScript("arguments[0].click();", click_divi);
	}
	
	public void Name(String name) {
		try {
				WebElement click_name=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//input[@id='DivisionName']")));
				click_name.sendKeys(Keys.CONTROL+"a");
				click_name.sendKeys(Keys.DELETE);
				if(name !=null && !name.trim().isEmpty()) {
					click_name.sendKeys(name);
				}
	
		} catch (NoSuchElementException e) {
			System.out.println("name isnot found: " +name);
		}
	}
	
	
	public void SubmitBtn() {
		WebElement submitBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		submitBtn.click();
	}
	
	//view division
	public void ViewBtn(String Name) {
		WebElement viewBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//td[text()='" + Name + "']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-eye-open')]")));
		viewBtn.click();
	}
	
	//Edit division
	public void EditBtn(String edit) {
		WebElement editBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//td[text()='"+edit+"']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-pencil')]")));
		js.executeScript("arguments[0].click();", editBtn);
	}
	
	
	public boolean NameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DivisionName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean is_saved_successfully() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
