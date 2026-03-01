package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Measurement_Unit {

	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_Measurement_Unit(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Measurement_Unit() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", click_product);
		
		WebElement click_Measurement=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[normalize-space()='Measurement Unit List']")));
		js.executeScript("arguments[0].click();", click_Measurement);
	}
	
	//add measurement unit
	
	public void add_measurement() {
		WebElement measurement=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Measurement Unit']")));
		js.executeScript("arguments[0].click();", measurement);
	}
	
	public void Measuement_Name(String mName) {
		WebElement click_mName=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='MeasurementUnitName']")));
		click_mName.clear();
		click_mName.sendKeys(mName);
	}
	
	public void is_Active_Name() {
		WebElement click_mName=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Active :']")));
		if(!click_mName.isSelected()) {
			js.executeScript("arguments[0].click();", click_mName);
		}else {
			js.executeScript("arguments[0].click();", click_mName);
		}
	}
	
	//edit product measurement unit
	
	public void edit_measure() {
		WebElement click_measure=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", click_measure);
	}
	
	//submit btn
	
	public void saveBtn() {
		WebElement save=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", save);
	}
	
	public boolean measurementErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='MeasurementUnitName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}	
	}
	
	public boolean measurement_exist_ErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}	
	}
	
	public boolean measurement_is_Successfully() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}	
	}

}
