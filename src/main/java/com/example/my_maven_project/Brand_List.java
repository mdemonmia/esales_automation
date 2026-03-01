package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Brand_List {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Brand_List(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Brand() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", click_product);
		
		WebElement click_brand=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[normalize-space()='Brand List']")));
		js.executeScript("arguments[0].click();", click_brand);
	}
	
	//add brand list
	
	public void add_brand() {
		WebElement click_brand=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Brand']")));
		js.executeScript("arguments[0].click();", click_brand);
	}
	
	public void brand_Name(String bName) {
		WebElement brand_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='BrandName']")));
		brand_name.clear();
		brand_name.sendKeys(bName);
	}
	
	//edit brand
	
	public void brand_Edit() {
		WebElement brand_edit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", brand_edit);
	}
	
	//Delete Brand
	
	public void deleteBtn(boolean accept) {
		WebElement dltBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
		js.executeScript("arguments[0].click();", dltBtn);
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		if(accept) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	//submit
	public void submitBtn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", sBtn);
		
	}
	
	//update
		public void updateBtn() {
			WebElement uBtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@value='Update']")));
			js.executeScript("arguments[0].click();", uBtn);
			
		}
	
	public boolean BnameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='BrandName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean BnameErrorDisplayExist() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_successfully() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	

}
