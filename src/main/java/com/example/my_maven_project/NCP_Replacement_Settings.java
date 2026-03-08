package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NCP_Replacement_Settings {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public NCP_Replacement_Settings(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_New_NCP() {
		WebElement click_add=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New NCP Product Settings']")));
		js.executeScript("arguments[0].click();", click_add);
	}
	
	public void Products(String product) {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='product_id']")));
		Select select=new Select(click_product);
		
		if(product== null || product.trim().isEmpty()) {
			try {
				select.selectByIndex(0);
			} catch (Exception e) {
				System.out.println("Default dropdown select.");
			}
		}else {
			try {
				select.selectByVisibleText(product.trim());
			} catch (NoSuchElementException e) {
				throw new RuntimeException("Option not found: " +product);
			}
		}
		
	}
	
	public void Replace_product(String...Rproduct) {
		
		if(Rproduct ==null || Rproduct.length==0) {
			return;
		}
		for(int i=0; i<Rproduct.length;i++) {
		
			try {
				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='product_id1']/option"), 1));
				WebElement click_replace=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("(//select[@id='product_id1'])[" + (i + 1) + "]")));
				Select select=new Select(click_replace);
			    select.selectByVisibleText(Rproduct[i]);
		    if(i<Rproduct.length-1) {
			    	WebElement click_add_More=wait.until(ExpectedConditions.elementToBeClickable(By
			    			.xpath("//button[normalize-space()='Add More']")));
			    	js.executeScript("arguments[0].click();", click_add_More);
			    	
			    	  // wait for new dropdown to appear
                wait.until(ExpectedConditions.elementToBeClickable(
                         By.xpath("(//select[@id='product_id1'])[" + (i + 2) + "]")));
		    }
		} catch (StaleElementReferenceException e) {
				System.out.println("Element not found" +Rproduct[i]);
		
		}catch (NoSuchElementException e) {
               throw new RuntimeException("Product not found in dropdown: " + Rproduct[i]);
		}catch (org.openqa.selenium.TimeoutException e) {
		  System.out.println("Waiting for dropdown took too long, retrying for product: " + Rproduct[i]);
		}

	   }
   }
	
	
	public void is_Active() {
		WebElement click_active=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Active :']")));
		if(!click_active.isSelected()) {
			click_active.click();
		}
	}
	
	public void SubmitBtn() {
		WebElement click_active=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", click_active);
	}
	
	
	public boolean ProductErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='product_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ReplaceProductErrorDisplay() {
		try {
			 return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='product_id1']"))).isDisplayed();
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

}
