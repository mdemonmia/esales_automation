package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class District {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public District(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_District() {
		WebElement click_district=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New District']")));
		js.executeScript("arguments[0].click();", click_district);
	}
	
	public void Name(String name) {
		try {
			WebElement click_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DistrictName']")));
			click_name.sendKeys(Keys.CONTROL+"a");
			click_name.sendKeys(Keys.DELETE);
			
			if(name != null && !name.trim().isEmpty()) {
				click_name.sendKeys(name);
			}
		} catch (NoSuchElementException e) {
			System.out.println("name isnot found: " +name);
		}
		
	}
	
	public void FName(String fname) {
		try {
			WebElement click_fname=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='name']")));
			click_fname.sendKeys(Keys.CONTROL+"a");
			click_fname.sendKeys(Keys.DELETE);
			
			if(fname != null && !fname.trim().isEmpty()) {
				click_fname.sendKeys(fname);
			}
		} catch (NoSuchElementException e) {
			System.out.println("name isnot found: " +fname);
		}
		
	}
	
	public void Division(String division) {
		try {
			
			WebElement click_divi=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='DistrictDivisionId']")));
			Select select = new Select(click_divi);
			try {
				if(division == null || division.trim().isEmpty()) {
					select.selectByIndex(0);
				}else {
					select.selectByVisibleText(division);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (NoSuchElementException e) {
			System.out.println("Division is not found: " +division);
		}
	}
	
	public void SubmitBtn() {
		WebElement submitBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", submitBtn);
	}
	
	//edit button
	public void EditBtn(String edit) {
		WebElement click_edit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//td[text()='"+edit+"']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-pencil')]")));
		js.executeScript("arguments[0].click();", click_edit);
	}
	
	//delete
	public void DeleteBtn(String delete,boolean action) {
		try {
			WebElement click_dlt=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//td[text()='"+delete+"']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-trash')]")));
			js.executeScript("arguments[0].click();", click_dlt);
			Alert alert =wait.until(ExpectedConditions.alertIsPresent());
			if(action) {
				alert.accept();
				System.out.println("accept alert.");
			}else {
				alert.dismiss();
				System.out.println("dismiss alert.");
			}
		} catch (Exception e) {
			System.out.println("Not found the delete alert.");
		}
	}
	
	//filter
	
	public void SearchBtn() {
		WebElement click_search=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Search']")));
		js.executeScript("arguments[0].click();", click_search);
	}
	
	public void ResetBtn() {
		WebElement click_reset=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Reset']")));
		js.executeScript("arguments[0].click();", click_reset);
	}
	
	
	public void UpdateBtn() {
		WebElement click_update=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Update']")));
		js.executeScript("arguments[0].click();", click_update);
	}
	public boolean NameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DistrictName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean NameExistErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean DeleteDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("alert alert-success"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_saved_successfully() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
