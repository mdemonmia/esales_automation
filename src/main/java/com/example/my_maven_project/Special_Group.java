package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Special_Group {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Special_Group(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	
	//add new special group
	
	public void add_Special_Group() {
		WebElement click_add_SG=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Special Group']")));
		js.executeScript("arguments[0].click();", click_add_SG);
	}
	
	public void policy_Name(String policy) {
		WebElement click_policy=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupName']")));
		click_policy.clear();
		click_policy.sendKeys(policy);
	}
	
	public void Remarks(String remarks) {
		WebElement click_remarks=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupRemarks']")));
		click_remarks.clear();
		click_remarks.sendKeys(remarks);
	}
	
	public void Start_Date(String st_date) {
		WebElement click_st_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupStartDate']")));
		click_st_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_st_date,st_date);
	}
	
	public void End_Date(String end_date) {
		WebElement click_en_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='SpecialGroupEndDate']")));
		click_en_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_en_date,end_date);
	}
	
	//territory add
	
	public void Territory_add(boolean enableTerritory, String office,String territory) throws InterruptedException {
		WebElement click_add_terr=wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//input[@id='SpecialGroupIsTerritory']")));
		
		if(enableTerritory) {
			if(!click_add_terr.isSelected()) {
				click_add_terr.click();
				}
		}else {
			if(click_add_terr.isSelected()) {
				click_add_terr.click();
			}
			return;
		}
			
		if(office !=null && territory !=null) {
			WebElement click_ofc_add=wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//select[@id='office_for_territory']")));
			Select select=new Select(click_ofc_add);
			select.selectByVisibleText(office);
				
			Thread.sleep(5000);
			WebElement click_territory=wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//select[@id='territory']")));
			Select select1=new Select(click_territory);
			select1.selectByVisibleText(territory);
				
			WebElement addBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//a[@id='add_outlet']")));
			js.executeScript("arguments[0].click();", addBtn);
		}
	}
	
	
	public void outlet_Group(String...groups) {
		WebElement click_og=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//label[normalize-space()='Outlet Group :']/following::div[contains(@class,'chosen-container')][1]")));
		click_og.click();
		for(String group:groups) {
			WebElement input_search=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[contains(@class,'chosen-container-active')]//input")));
			input_search.clear();
			input_search.sendKeys(group);
			
			WebElement option_match=wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[contains(@class,'chosen-container-active')]//input")));
			option_match.click();
			
			click_og.click();
		}
	}
	
	
	//view special group
	public void ViewBtn() {
		WebElement click_vBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
		js.executeScript("arguments[0].click();", click_vBtn);
	}
	
	
	//edit special group
	public void EditBtn() {
		WebElement click_editBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", click_editBtn);
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
	
	//submit
	public void SubmitBtn() {
		WebElement click_sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", click_sBtn);
	}
	
	
	
	public boolean policyErrorDisplay() {
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
