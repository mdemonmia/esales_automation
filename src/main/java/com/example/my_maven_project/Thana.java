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

public class Thana {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Thana(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void AddThana() {
		WebElement click_newThana=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Thana']")));
		js.executeScript("arguments[0].click();", click_newThana);
	}
	
	public void Name(String name) {
		try {
			WebElement click_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='ThanaName']")));
			click_name.clear();
			if(name != null && !name.trim().isEmpty()) {
				
				click_name.sendKeys(name.trim());
			}
			
		} catch (NoSuchElementException e) {
			System.out.println("Name is not found: " +name);
		}
		
	}
	
	public void District(String dist) {
		try {
			WebElement click_dist=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='ThanaDistrictId']")));
			Select select=new Select(click_dist);
			if(dist != null && !dist.trim().isEmpty()) {
				boolean found=false;
				for(WebElement option:select.getOptions()) {
					if(option.getText().trim().equalsIgnoreCase(dist.trim())) {
						option.click();
						found=true;
						break;
					}
				}
				if(!found) {
					System.out.println("District isn't found: " +dist);
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("District error: " +dist);
		}
	}
	
	public void isActive() {
		WebElement click_active=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Active :']")));
		click_active.click();
	}
	
	public void Submit() {
		WebElement click_submit=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", click_submit);
	}
	
	//edit
	 public void EditBtn(String edit) {
		 WebElement click_edit=wait.until(ExpectedConditions.elementToBeClickable(By
				 .xpath("//td[text()='"+edit+"']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-pencil')]")));
		 js.executeScript("arguments[0].click();", click_edit);
	 }
	 
	 public void Update() {
			WebElement click_update=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@value='Update']")));
			js.executeScript("arguments[0].click();", click_update);
		}
	 
	 //delete
	 public void DeleteBtn(String dlt,boolean accept) {
		 try {
			 WebElement click_dlt=wait.until(ExpectedConditions.elementToBeClickable(By
					 .xpath("//td[text()='"+dlt+"']/following-sibling::td//i[contains(@class,'glyphicon glyphicon-trash')]")));
			 js.executeScript("arguments[0].click();", click_dlt);
			 
			 Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			 if(accept) {
				 alert.accept();
			 }else {
				 alert.dismiss();
				 System.out.println("dismiss alert.");
			 }
		 }catch (Exception e) {
			System.out.println("Not found the delete alert.");
		}
     } 
	
	 //filter 
	 
//	 public void Namefilter() {
//			WebElement click_Nfilter=wait.until(ExpectedConditions.elementToBeClickable(By
//					.xpath("//input[@id='ThanaName']")));
//			js.executeScript("arguments[0].click();", click_Nfilter);
//		}
	 
	 public void SearchBtn() {
			WebElement click_Sbtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[normalize-space()='Search']")));
			js.executeScript("arguments[0].click();", click_Sbtn);
		}
	 
	 public void ResetBtn() {
			WebElement click_Rbtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[normalize-space()='Reset']")));
			js.executeScript("arguments[0].click();", click_Rbtn);
		}
	 
	public boolean NameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//input[@id='ThanaName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean DistrictErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='ThanaDistrictId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean DeleteDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_saved_successfully() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean NameExist() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//div[@class='error-message']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
