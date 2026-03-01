package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_productlist {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_productlist(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Product_productlist() {
		WebElement product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", product);
		
		WebElement product_list=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Product List']")));
		js.executeScript("arguments[0].click();", product_list);
	}
	
	public void click_productName(String pName) {
		WebElement product_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductName']")));
		product_Name.sendKeys(pName);
	}
	
	public void click_product_Category(String category) throws InterruptedException {
		WebElement category_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='category_id']")));
		Select select=new Select(category_Name);
		try {
			select.selectByVisibleText(category);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +category);
			throw e;
		}
	}
	
	public void click_Brand(String brand) throws InterruptedException {
		WebElement brand_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductBrandId']")));
		Select select=new Select(brand_Name);
		try {
			select.selectByVisibleText(brand);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +brand);
			throw e;
		}
	}
	
	public void click_Variant(String variant) throws InterruptedException {
		WebElement variant_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductVariantId']")));
		Select select=new Select(variant_Name);
		try {
			select.selectByVisibleText(variant);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +variant);
			throw e;
		}
	}
	
	public void click_Measurement_unit(String munit) throws InterruptedException {
		WebElement Measurement_unit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductBaseMeasurementUnitId']")));
		Select select=new Select(Measurement_unit);
		try {
			select.selectByVisibleText(munit);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +munit);
			throw e;
		}
	}
	
	public void click_Product_Type(String ptype) throws InterruptedException {
		WebElement product_type=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductProductTypeId']")));
		Select select=new Select(product_type);
		try {
			select.selectByVisibleText(ptype);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +ptype);
			throw e;
		}
	}
	
	public void click_Group_Name(String group) throws InterruptedException {
		WebElement group_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductGroupId']")));
		Select select=new Select(group_Name);
		try {
			select.selectByVisibleText(group);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Category name not found: " +group);
			throw e;
		}
	}
	
	
	public void click_searchBtn() {
		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Search']")));
		js.executeScript("arguments[0].click();", search);
	}
	
	
	public void click_resetBtn() {
		WebElement reset=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Reset']")));
		js.executeScript("arguments[0].click();", reset);
	}
	
	
	//product rearrange
	
	public void product_Rearrange() throws InterruptedException {
		WebElement arrange=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Product Rearrange']")));
		js.executeScript("arguments[0].click();", arrange);
		
		WebElement source=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[normalize-space()='Product 705']")));
		WebElement target=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[normalize-space()='Product 27']")));
		
		Actions action=new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release().build().perform();
		Thread.sleep(10000);
	}
	
	//product view
	
		public void product_view() throws InterruptedException {
			WebElement view=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[i[contains(@class,'glyphicon-eye-open')]]")));
			js.executeScript("arguments[0].click();", view);
			
			Thread.sleep(10000);
		}
		
		//product edit
		
		public void product_edit() throws InterruptedException {
			WebElement edit=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
			js.executeScript("arguments[0].click();", edit);
			
			Thread.sleep(5000);
		}	
		
		public void product_Name(String pName) throws InterruptedException {
			WebElement product_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='ProductName']")));
			product_name.clear();
			product_name.sendKeys(pName);
			
			Thread.sleep(5000);
		}
		
		public void Bangla_Name(String pName) {
			WebElement bangla_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='ProductNameBangla']")));
			bangla_name.clear();
			bangla_name.sendKeys(pName);
		}
		
		public void Display_Name(String pName) {
			WebElement display_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='ProductProductDisplayName']")));
			display_name.clear();
			display_name.sendKeys(pName);
		}
		
		public void is_Pharma() {
			WebElement pharma_tik=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//b[normalize-space()='Is Pharma :']")));
			if(!pharma_tik.isSelected()) {
				js.executeScript("arguments[0].click();", pharma_tik);
			}else {
				js.executeScript("arguments[0].click();", pharma_tik);
			}	
		}
		
		public void is_SD() {
			WebElement SD_tik=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//b[normalize-space()='Is SD :']")));
			js.executeScript("arguments[0].scrollIntoView(true);", SD_tik);
			if(!SD_tik.isSelected()) {
				js.executeScript("arguments[0].click();", SD_tik);
			}else {
				js.executeScript("arguments[0].click();", SD_tik);
			}
		}
		
		
		
		public void SaveBtn() {
			WebElement save_Btn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[normalize-space()='Save']")));
			js.executeScript("arguments[0].scrollIntoView(true);", save_Btn);
			js.executeScript("arguments[0].click();", save_Btn);
		}
		
		public boolean product_Name_ErrorDisplay() {
			
			try {
				 return wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//input[@id='ProductName']"))).isDisplayed();
			} catch (Exception e) {
				return false;
			}
			
		}
		
		
		public boolean is_Product_saved_Successfully() {
			try {
				return wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[@class='alert alert-success']"))).isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}

}
