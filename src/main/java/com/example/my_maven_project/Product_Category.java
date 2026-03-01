package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Category {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_Category(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}

	public void click_Product_category() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", click_product);
		
		WebElement click_category=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[normalize-space()='Product Category List']")));
		js.executeScript("arguments[0].click();", click_category);
	}
	
	//add product category
	
	public void add_product_category() {
		WebElement click_add_Btn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Product Category']")));
		js.executeScript("arguments[0].click();", click_add_Btn);
	}
	
	public void category_Name(String cName) {
		WebElement c_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductCategoryName']")));
		c_name.clear();
		c_name.sendKeys(cName);
	}
	
	public void Parent_category_Name(String p_Name) throws InterruptedException {
		WebElement p_c_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductCategoryParentId']")));
		
		Select select=new Select(p_c_name);
		try {
			select.selectByVisibleText(p_Name);
			Thread.sleep(5000);
		} catch (NoSuchElementException e) {
			System.err.println("Parent category name not found: " +p_Name);
		}
		
	}
	
	public void Is_Pharma_category_Name() {
		WebElement pharma_check=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Pharma Product :']")));
		if(!pharma_check.isSelected()) {
			js.executeScript("arguments[0].click();", pharma_check);
		}else {
			js.executeScript("arguments[0].click();", pharma_check);
		}
	}
	
	//category name edit
	
	public void category_edit() {
		WebElement edit_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", edit_name);
	}
	
	
	//delete category name
	
	public void category_delete(boolean accept) {
		WebElement dlt=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
		js.executeScript("arguments[0].click();", dlt);
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	
		System.out.println("Alert Text: " +alert.getText());
		
		if(accept) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	
	//save button
	
	public void SaveBtn() {
		WebElement sava_btn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", sava_btn);
	}
	
	public boolean categoryErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='ProductCategoryName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_category_save_successfully() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_category_exists() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_category_delete() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}
