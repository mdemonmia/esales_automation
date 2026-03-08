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

public class Return_Challan_SO_ASO {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Return_Challan_SO_ASO(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}

	public void AreaOffice(String ofc) {
		WebElement click_ofc=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='office_id']")));
		Select select= new Select(click_ofc);
		if(ofc == null || ofc.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option not found.");
			}
		}else {
			try {
				select.selectByVisibleText(ofc.trim());
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +ofc);
			}
		}
	}
	
	public void SAP_Status(String sStatus) {
		WebElement click_status=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ReturnChallanSapStatus']")));
		Select select= new Select(click_status);
		if(sStatus == null || sStatus.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option not found.");
			}
		}else {
			try {
				select.selectByVisibleText(sStatus.trim());
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +sStatus);
			}
		}
	}
	
	public void Challan_No(String cNo) {
		WebElement click_cno=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanChallanNo']")));
		click_cno.clear();
		click_cno.sendKeys(cNo);
	}
	
	public void Status(String Status) {
		WebElement click_Status=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ReturnChallanStatus']")));
		Select select= new Select(click_Status);
		if(Status == null || Status.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default option not found.");
			}
		}else {
			try {
				select.selectByVisibleText(Status.trim());
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +Status);
			}
		}
	}
	
	public void Date_From(String Fdate) {
		WebElement click_fDate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanDateFrom']")));
		click_fDate.clear();
		click_fDate.sendKeys(Fdate);
		js.executeScript("arguments[0].value=arguments[1];", click_fDate, Fdate);
	}
	
	public void Date_To(String Tdate) {
		WebElement click_Tdate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ReturnChallanDateTo']")));
		click_Tdate.clear();
		click_Tdate.sendKeys(Tdate);
		js.executeScript("arguments[0].value=arguments[1];", click_Tdate, Tdate);
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
