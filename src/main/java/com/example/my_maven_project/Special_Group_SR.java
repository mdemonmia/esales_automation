package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Special_Group_SR {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Special_Group_SR(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	// add special group sr
	public void add_Special_Group_SR() {
		WebElement click_sgsr=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Special Group']")));
		click_sgsr.click();
	}
	
	public void policy_Name(String pName) {
		WebElement click_policy_name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupName']")));
		click_policy_name.clear();
		click_policy_name.sendKeys(pName);
	}
	
	public void Remarks(String remarks) {
		WebElement click_remarks=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupRemarks']")));
		click_remarks.clear();
		click_remarks.sendKeys(remarks);
	}
	
	public void Start_Date(String st_date) {
		
//		if(st_date == null || st_date.trim().isEmpty() || !st_date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
//			throw new IllegalArgumentException("Invalid date format! Only YYYY-MM-DD allowed.");
//		}
		WebElement click_st_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupStartDate']")));
		click_st_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_st_date,st_date);
	}
	
	public void End_Date(String en_date) {
//		if(en_date ==null || en_date.trim().isEmpty() || !en_date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
//			throw new IllegalArgumentException("Invalid date format! Only YYYY-MM-DD allowed.");
//		}
		WebElement click_en_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupEndDate']")));
		click_en_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_en_date,en_date);
	}
	
	
	public void Remove_office(String...rmv_ofcs) {
		
		for(String rmv_ofc:rmv_ofcs) {
			WebElement click_rmv_office=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//li[span[normalize-space()='" + rmv_ofc + "']]//a[@class='search-choice-close']")));
			js.executeScript("arguments[0].click();", click_rmv_office);
		}
		
	}
	
	public void Outlet_Group(String...groups) {
		
		WebElement click_og=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//label[normalize-space()='Outlet Group :']/following::div[contains(@class,'chosen-container')][1]")));
		
		
		for(String group:groups) {
			
			if(group==null || group.trim().isEmpty()) {
				continue;
			}
			click_og.click();
			WebElement click_option=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[contains(@class,'chosen-container-active')]//input")));
			click_option.clear();
			click_option.sendKeys(group);
			
			WebElement click_matches=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//li[contains(@class,'active-result') and normalize-space()='" + group + "']")));
			click_matches.click();
			
		}
		
		// Close dropdown properly
	    js.executeScript("document.activeElement.blur();");
	}
	
	
	public void Remove_Outlet_Category(String...rmv_ocs) {
		
		for(String rmv_oc:rmv_ocs) {
			WebElement click_remove_oc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//li[span[normalize-space()='" + rmv_oc + "']]//a[@class='search-choice-close']")));
			click_remove_oc.click();
		}
		
	}
	
	//submit
	
	public void SubmitBtn() {
		js.executeScript("document.body.click();"); //close dropdown
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].scrollIntoView(true);", sBtn);
		js.executeScript("arguments[0].click();", sBtn);
	}
	
	//view
	
	public void view_Special_Group_SR() {
		WebElement click_view=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
		js.executeScript("arguments[0].click();", click_view);
	}
	
	//edit
	
	public void Edit_Special_Group_SR() {
		WebElement click_edit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", click_edit);
	}
	
	//delete special group
			public void DeleteBtn(boolean accept) {
				WebElement click_dltBtn=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
				js.executeScript("arguments[0].click();", click_dltBtn);
				
				Alert alert=wait.until(ExpectedConditions.alertIsPresent());
				if(accept) {
					alert.accept();
				}else {
					alert.dismiss();
				}
			}
	
	public boolean policyNameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='SpecialGroupName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean StartDateErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='SpecialGroupStartDate']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean EndDateErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='SpecialGroupEndDate']"))).isDisplayed();
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
	
	public boolean is_delete_successfull() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}


