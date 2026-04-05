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

public class National_Sales_Target {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public National_Sales_Target(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Fiscal_Year(String fy) {
		try {
			
			WebElement click_fs=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='SaleTargetFiscalYearId']")));
			Select select= new Select(click_fs);
			if(fy == null || fy.trim().isEmpty()) {
				select.selectByIndex(0);
			}else {
				select.selectByVisibleText(fy);
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Fiscal year not found: " +fy);
		}
		
	}
	
	public void Month(String month) {
	
		try {
			WebElement click_month=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='SaleTargetMonthId']")));
			Select select=new Select(click_month);
			if(month == null || month.trim().isEmpty()) {
				select.selectByIndex(0);
			}else {
				select.selectByVisibleText(month);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Month not found: " +month);
		}
	}
	
	public void Product(String product) {
		
		try {
			WebElement click_product=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("SaleTargetProductId")));
			Select select=new Select(click_product);
			if(product == null || product.trim().isEmpty()) {
				select.selectByIndex(0);
			}else {
				select.selectByVisibleText(product);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Product not found: " +product);
		}
	}
	
	public void SetMonthlyTarget(String base,String qty,String amt) {

	    try {

	        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//td[normalize-space()='" + base + "']/ancestor::tr")));

	        WebElement click_qty = row.findElement(By.xpath(".//input[contains(@name,'Quantity')]"));
	        click_qty.clear();
	        click_qty.sendKeys(qty);

	        WebElement click_amt = row.findElement(By.xpath(".//input[contains(@name,'Amount')]"));
	        click_amt.clear();
	        click_amt.sendKeys(amt);

	        WebElement click_SMT = row.findElement(By.xpath(".//a[contains(text(),'Set Monthly Target')]"));
	        js.executeScript("arguments[0].click();", click_SMT);

	    } catch (Exception e) {
	        System.out.println("Base not found: " + base);
	    }
	}
	
	public void Target_Set(String month, String qty, String amt) {
	    try {
	        // ১। মাসের হেডার খুঁজে পাওয়া এবং স্ক্রল করে দেখানো
	        WebElement monthHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//th[normalize-space()='" + month + "']")));
	        js.executeScript("arguments[0].scrollIntoView(true);", monthHeader);

	        // ২। চেক করা যদি ইনপুট ফিল্ড visible না হয়
	        WebElement row = monthHeader.findElement(By.xpath("./ancestor::tr"));
	        WebElement inputQty = row.findElement(By.xpath(".//input[contains(@id,'SaleTargetMonth_quantity')]"));
	        WebElement inputAmt = row.findElement(By.xpath(".//input[contains(@id,'SaleTargetMonthE')]"));

	        // ৩। যদি invisible হয়, JS দিয়ে click করে row খুলতে পারি
	        js.executeScript("arguments[0].scrollIntoView(true);", inputQty);
	        js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1;", inputQty);
	        js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1;", inputAmt);

	        // ৪। Quantity & Amount সেট করা
	        inputQty.clear();
	        inputQty.sendKeys(qty);

	        inputAmt.clear();
	        inputAmt.sendKeys(amt);

	        System.out.println("Monthly target set successfully for " + month);

	    } catch (Exception e) {
	        System.out.println("Error setting monthly target for " + month + ": " + e.getMessage());
	    }
	}

	
	public void click_download() {
		WebElement downloadBtn=wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[@id='dl_exel_month']")));
		downloadBtn.click();
	}
	
	public void click_upload() {
	    try {
	        // ১। UPLOAD পপআপ ওপেন করা
	        WebElement uploadBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[normalize-space()='OR UPLOAD XCEL Month wise']")));
	        uploadBtn.click();

	        // ২। file input কে DOM-এ খুঁজে পাওয়া
	        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//input[@type='file']")));

	        // ৩। যদি ইনপুট hidden থাকে, JS দিয়ে দেখানো
	        js.executeScript("arguments[0].style.display='block'; arguments[0].style.opacity=1;", fileInput);

	        // ৪। ফাইল path পাঠানো
	        fileInput.sendKeys("C:\\Users\\USER\\Downloads\\Tmonth.xls");

	        // ৫। UPLOAD বাটনে ক্লিক করা (explicit wait + JS fallback)
	        WebElement click_uploadBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//input[@value='UPLOAD']")));

	        try {
	            // Selenium regular click
	            wait.until(ExpectedConditions.elementToBeClickable(click_uploadBtn)).click();
	        } catch (Exception e) {
	            // যদি clickable না হয়, JS দিয়ে ক্লিক
	            js.executeScript("arguments[0].click();", click_uploadBtn);
	        }

	        System.out.println("File uploaded successfully.");

	    } catch (Exception e) {
	        System.out.println("Upload failed: " + e.getMessage());
	    }
	}



	
	public void SaveBtn() {
		WebElement click_saveBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@name='save_button']")));
		click_saveBtn.click();
	}
	
	public boolean FiscalYearErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='SaleTargetFiscalYearId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ProductErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='SaleTargetProductId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
