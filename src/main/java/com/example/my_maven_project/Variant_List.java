package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variant_List {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Variant_List(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Variant() {
		 WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				 .xpath("//span[normalize-space()='Products']")));
		 js.executeScript("arguments[0].click();", click_product);
		 
		 WebElement click_variant=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				 .xpath("//span[normalize-space()='Variant List']")));
		 js.executeScript("arguments[0].click();", click_variant);
	}

	
	//add variant
	
	public void add_Variant() {
		WebElement click_variant=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Variant']")));
		js.executeScript("arguments[0].click();", click_variant);
	}
	
	public void variant_Name(String vName) {
		WebElement variant_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='VariantName']")));
		variant_name.clear();
		variant_name.sendKeys(vName);
	}
	
	//Submit
	
	public void SubmitBtn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", sBtn);
	}
	
	//edit variant
	public void click_edit() {
		WebElement eBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", eBtn);
	}
	
	//update variant
		public void click_update() {
			WebElement uBtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@value='Update']")));
			js.executeScript("arguments[0].click();", uBtn);
		}
	
	
	//delete variant
	
	public void Delete_Btn(boolean accept) {
		WebElement dltBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
		js.executeScript("arguments[0].click();", dltBtn);
		
		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
		if(accept) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	
	public boolean VnameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='VariantName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean VnameErrorDisplayExist() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-danger']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean VnameDelete_successfull() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean Vnam_is_successfull() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}
