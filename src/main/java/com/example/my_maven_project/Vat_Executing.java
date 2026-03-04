package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vat_Executing {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Vat_Executing(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_VAT_Execute() {
		WebElement click_add_vat=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Vat Executing Product']")));
		js.executeScript("arguments[0].click();", click_add_vat);
	}
	
	public void Product_Type(String pt) {
		if(pt==null || pt.trim().isEmpty()) {
			return;
		}
		WebElement click_pt=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='product_type']")));
		Select select=new Select (click_pt);
		try {
			select.selectByVisibleText(pt.trim());
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Option not found." +pt);
		}
		
	}
	
	public void Products(String product) {
		
		if(product==null || product.trim().isEmpty()) {
			return;
		}
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='product_id']/option"), 1));
		
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='product_id']")));
		
		Select select=new Select(click_product);
		try {
			select.selectByVisibleText(product.trim());
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Dropdown not found: " +product);
		}
		
	}
	
	
	//submit
	public void SubmitBtn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", sBtn);
	}
	
	public boolean ProductTypeErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='product_type']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ProductErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='product_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean EffectiveDateErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='VatexecutingProductEffectivedate']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean is_saved_successfull() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
