package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
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
		
		WebElement click_pt=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='product_type']")));
		Select select=new Select (click_pt);
		
		if(pt==null || pt.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option selected");
			}
		}else {
			try {
				select.selectByVisibleText(pt.trim());
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found." +pt);
			}
		}
		
		 // alert handle
		try {
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			System.out.println("Alert accepted");
		} catch (Exception e) {
			System.out.println("Alert is not clicked.");
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
	
	
	public void Effective_Date(String date) {
		if(date == null || date.trim().isEmpty()){
			return;
		}
		
		WebElement click_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='VatexecutingProductEffectivedate']")));
		
		click_date.clear();
		click_date.sendKeys(date);
		js.executeScript("arguments[0].value=arguments[1];", click_date,date);
				
	}
	
	
	
	public void Price(String price) {
		if(price == null || price.trim().isEmpty()) {
			return;
		}
		
		WebElement click_price=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='VatexecutingProductPrice']")));
		
		wait.until(ExpectedConditions.elementToBeClickable(click_price));
		click_price.clear();
		click_price.sendKeys(price);
		js.executeScript("arguments[0].value=arguments[1];", click_price,price);
	}
	
	
	
	public void VAT(String vat) {
		if(vat == null || vat.trim().isEmpty()) {
			return;
		}
		
		WebElement click_vat=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='VatexecutingProductVat']")));
		click_vat.clear();
		click_vat.sendKeys(vat);
		js.executeScript("arguments[0].value=arguments[1];", click_vat,vat);
	}
	
	//submit
	public void SubmitBtn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", sBtn);
	}
	
	//view 
	
	public void ViewBtn() {
		WebElement vBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
		js.executeScript("arguments[0].click();", vBtn);
	}
	
	
	//Edit
	
		public void EditBtn() {
			WebElement eBtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
			js.executeScript("arguments[0].click();", eBtn);
		}
	
	//Delete
		
		public void DeleteBtn(boolean accept) {
			WebElement eBtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
			js.executeScript("arguments[0].click();", eBtn);
			
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			
			if(accept) {
				alert.accept();
			}else {
				alert.dismiss();
			}
		}
		
		// filter
		
		public void Product_Type_Filter(String pt) {
			WebElement click_pt=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='VatexecutingProductProductTypeId']")));
			Select select =new Select(click_pt);
			
			if(pt ==null || pt.trim().isEmpty()) {
				try {
					select.selectByIndex(0);
				} catch (Exception e) {
					System.out.println("Default dropdown select.");
				}
			}else {
				try {
					select.selectByVisibleText(pt.trim());
				} catch (NoSuchElementException e) {
					throw new RuntimeException("Option not found" +pt);
				}
			}
		}
		
		
		public void Product_Category(String pc) {
			WebElement click_pc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='category_id']")));
			Select select =new Select(click_pc);
			
			if(pc ==null || pc.trim().isEmpty()) {
				try {
					select.selectByIndex(0);
				} catch (Exception e) {
					System.out.println("Default dropdown select.");
				}
			}else {
				try {
					select.selectByVisibleText(pc.trim());
				} catch (NoSuchElementException e) {
					throw new RuntimeException("Option not found" +pc);
				}
			}
		}
		
		
		public void Brand(String brand) {
			WebElement click_brand=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='VatexecutingProductBrandId']")));
			Select select=new Select(click_brand);
			if(brand == null || brand.trim().isEmpty()) {
				try {
					select.selectByIndex(0);
				} catch (Exception e) {
					System.out.println("Default dropdown select.");
				}
			}else {
				try {
					select.selectByVisibleText(brand);
				} catch (NoSuchElementException e) {
					throw new RuntimeException("Option not found:" +brand);
				}
			}
		}
		
		public void Search() {
			WebElement click_search=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[normalize-space()='Search']")));
			js.executeScript("arguments[0].click();", click_search);
		}
		
		public void Reset() {
			WebElement click_reset=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[normalize-space()='Search']")));
			js.executeScript("arguments[0].click();", click_reset);
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

	
	public boolean PriceErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='VatexecutingProductPrice']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean VatErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='VatexecutingProductVat']"))).isDisplayed();
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
	
	public boolean is_deleted_successfull() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
