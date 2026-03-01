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

public class Bonus_Card {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Bonus_Card(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
				
	}
	
	public void click_Bonus_Card() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		js.executeScript("arguments[0].click();", click_product);
		
		WebElement click_bonus_card=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//a[@href='/esales_live/admin/bonus_cards']//span[contains(text(),'Bonus Cards')]")));
		js.executeScript("arguments[0].click();", click_bonus_card);
	}
	
	
	//add bonus card
	
	public void add_Bonus_Card() {
		WebElement click_bc=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Bonus Card']")));
		js.executeScript("arguments[0].click();", click_bc);
	}
	
	public void Bonus_Card_Name(String bcard) {
		WebElement click_Bcard=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='BonusCardName']")));
		
		click_Bcard.clear();
		click_Bcard.sendKeys(bcard);
		
	}
	
	public void Fiscal_Year_Name(String fyear) {
		
		try {
			WebElement click_Fyear=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='BonusCardFiscalYearId']")));
			Select select=new Select(click_Fyear);
			
			if(fyear== null || fyear.trim().isEmpty()) {
				try {
					select.selectByVisibleText("");
				} catch (Exception e) {
					select.selectByIndex(0);
				}
				
			}else {
				select.selectByVisibleText(fyear);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Fiscal year dropdown option not found: " +e.getMessage());
		}
		
	}
	
	public void Bonus_Card_Type(String bcType) {
		
		try {
			WebElement click_BCT=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='BonusCardBonusCardTypeId']")));
			Select select=new Select(click_BCT);
			
			if(bcType==null || bcType.isEmpty()) {
				
				try {
					select.selectByVisibleText("");
				} catch (Exception e) {
					select.selectByIndex(0);
				}
				
			}else {
				select.selectByVisibleText(bcType);
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Bonus Card Type dropdown option not found: " +e.getMessage());
		}
		
		
	}
	
	public void Bonus_Card_Product(String product) {
		
		try {
			WebElement click_Product=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='BonusCardProductId']")));
			Select select=new Select(click_Product);
			
			if(product==null || product.isEmpty()) {
				try {
					select.selectByVisibleText("");
				} catch (Exception e) {
					select.selectByIndex(0);
				}
				
			}else {
				select.selectByVisibleText(product);
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Product dropdown option not found: " +e.getMessage());
		}
		
		
	}
	
	public void Min_Qty_Per_Memo(String MQmemo) {
		WebElement click_Permemo=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='BonusCardMinQtyPerMemo']")));
		click_Permemo.clear();
		click_Permemo.sendKeys(MQmemo);
		
	}
	
	public void Min_Qty_Per_Year(String MQyear) {
		WebElement click_Peryear=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='BonusCardMinQtyPerYear']")));
		click_Peryear.clear();
		click_Peryear.sendKeys(MQyear);
		
	}
	
	public void is_active_checkbox() {
		WebElement click_checkbox=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Active :']")));
			js.executeScript("arguments[0].click();", click_checkbox);
		
	}
	
	//save button
	
	public void click_SaveBtn() {
		WebElement click_sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
			js.executeScript("arguments[0].click();", click_sBtn);
		
	}
	
	//filter search/reset
	
	public void click_SearchBtn() {
		WebElement click_sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Search']")));
			js.executeScript("arguments[0].click();", click_sBtn);
		
	}
	
	public void click_resetBtn() {
		WebElement click_rBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Reset']")));
			js.executeScript("arguments[0].click();", click_rBtn);
		
	}
	
	//bonus card edit
	
	public void click_editBtn() {
		WebElement click_eBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-pencil')]]")));
			js.executeScript("arguments[0].click();", click_eBtn);
		
	}
	
	//bonus card delete
	public void click_dltBtn(boolean accept) {
		WebElement click_dBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-trash')]]")));
			js.executeScript("arguments[0].click();", click_dBtn);
			
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			if(accept) {
				alert.accept();
			}else {
				alert.dismiss();
			}
		
	}
	
	
	public boolean MinPerYearErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='BonusCardMinQtyPerYear']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean MinPerQTYErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='BonusCardMinQtyPerMemo']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean BonusCardProductErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='BonusCardProductId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean BonusCardTypeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='BonusCardBonusCardTypeId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean FiscalYearErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='BonusCardFiscalYearId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean BonusCardErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='BonusCardName']"))).isDisplayed();
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_saved_successfully() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_delete_successfully() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
