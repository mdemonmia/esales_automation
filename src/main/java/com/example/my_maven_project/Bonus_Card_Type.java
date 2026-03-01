package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bonus_Card_Type {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Bonus_Card_Type(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Bonus_Card_Type() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", click_product);
		
		WebElement click_bonus_card_type=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[normalize-space()='Bonus Card Type']")));
		js.executeScript("arguments[0].click();", click_bonus_card_type);
	}
	
	
	//add bonus card
	
	public void add_bonus_Card() {
		WebElement add_bonus=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Bonus Card Type']")));
		js.executeScript("arguments[0].click();", add_bonus);
	}
	
	public void Bonus_Card_Name(String cName) {
		WebElement bonus_Name=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='BonusCardTypeName']")));
		bonus_Name.clear();
		bonus_Name.sendKeys(cName);
	}
	
	public void saveBtn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", sBtn);
	}
	
	//edit bonus card type
	public void Bonus_Card_edit() {
		WebElement bonus_edit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
		js.executeScript("arguments[0].click();", bonus_edit);
	}
	
	//delete bonus card type
	public void Bonus_Card_delete(boolean accept) {
		WebElement bonus_dlt=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
		js.executeScript("arguments[0].click();", bonus_dlt);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		if(accept) {
			alert.accept();
		}else {
			alert.dismiss();
		}
	}
	
	public boolean BonusCardTypeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='BonusCardTypeName']"))).isDisplayed();
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
	
	public boolean BonusCardTypeExistErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
