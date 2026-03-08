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

public class CT_Return_Challan {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public CT_Return_Challan(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}

	public void Challan_No(String challan) {
		WebElement click_challan=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanChallanNo']")));
		click_challan.clear();
		click_challan.sendKeys(challan);
	}
	
	public void Status(String status) {
		
		WebElement click_challan=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ReturnChallanStatus']")));
		Select select=new Select(click_challan);
		
		if(status == null || status.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option selected");
			}
		}else {
			try {
				select.selectByVisibleText(status);
			} catch (NoSuchElementException e) {
				throw new RuntimeException("option not found: "+status);
			}
		}
		
		
	}
	
	public void Date_From(String Fdate) {
		WebElement click_fDate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanDateFrom']")));
		click_fDate.clear();
		click_fDate.sendKeys(Fdate);
		js.executeScript("arguments[0].value=arguments[1];", click_fDate,Fdate);
	}
	
	public void Date_To(String Tdate) {
		WebElement click_tDate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanDateTo']")));
		click_tDate.clear();
		click_tDate.sendKeys(Tdate);
		js.executeScript("arguments[0].value=arguments[1];", click_tDate,Tdate);
	}
	
	public void Inventory_Status(String Istatus) {
		WebElement click_Istatus=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='inventory_status_id']")));
		Select select=new Select(click_Istatus);
		if(Istatus==null || Istatus.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option selected");
			}
		}else {
			try {
				select.selectByVisibleText(Istatus);
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +Istatus);
			}
		}
		
	}
	
	public void Sender_Store(String Sstore) {
		WebElement click_Sstore=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ReturnChallanSenderStoreId']")));
		Select select=new Select(click_Sstore);
		
		if(Sstore == null || Sstore.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option selected");
			}
		}else {
			try {
				select.selectByVisibleText(Sstore);
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +Sstore);
			}
		}
		
	}
	
	public void SAP_Status(String SSAP) {
		WebElement click_Ssap=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ReturnChallanSapStatus']")));
		Select select=new Select(click_Ssap);
		
		if(SSAP ==null || SSAP.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option selected");
			}
		}else {
			try {
				select.selectByVisibleText(SSAP);
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +SSAP);
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
				.xpath("//a[normalize-space()='Reset']")));
		js.executeScript("arguments[0].click();", click_reset);
	}
	
	public void View() {
		WebElement click_view=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
		js.executeScript("arguments[0].click();", click_view);
	}
}
