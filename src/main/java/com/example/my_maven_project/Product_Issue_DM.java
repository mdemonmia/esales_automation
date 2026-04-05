package com.example.my_maven_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Issue_DM {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_Issue_DM(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_Issue_DM() {
		WebElement click_dm=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Create New']")));
		click_dm.click();
	}
	
	public void Receiver_Store(String store) {

		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("receiver_store_id")));
			
			WebElement dropdown=driver.findElement(By.id("receiver_store_id"));
			Select select = new Select(dropdown);
			if(store == null || store.trim().isEmpty()) {
				select.selectByIndex(0);
				System.out.println("Default dropdown select.");
			}else {
				boolean found=false;
				for(WebElement opt:select.getOptions()) {
					if(opt.getText().trim().equalsIgnoreCase(store.trim())) {
						opt.click();
						found=true;
						System.out.println("store selected: " +store);
						break;
					}
				}
				if(!found) {
					System.out.println("Store not found: " +store);
				}
			}
			
			//if Dom refreshed wait
			wait.until(ExpectedConditions.refreshed
					(ExpectedConditions.presenceOfElementLocated(By.id("receiver_store_id"))));
			
		} catch (Exception e) {
			System.out.println("Receiver store select failed: " + e.getMessage());
		}
	}
	
	public void Product_Issue_Date(String date) {
		if(date == null || date.trim().isEmpty()) {
			return;
		}
		
		WebElement click_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='challan_date']")));
		js.executeScript("arguments[0].click();", click_date);
		
		Actions action = new Actions(driver);
		action.moveToElement(click_date).click().build().perform();
		try {
			WebElement selectDate=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//td[contains(@class,'day') and not(contains(@class,'disabled')) and normalize-space()='" + date + "']")));
			js.executeScript("arguments[0].click();", selectDate);
			action.moveToElement(selectDate).click().build().perform();
			
		} catch (StaleElementReferenceException e) {
			System.out.println("Date not select. Retrying...");
		}
		
	}
	
	public void Remarks(String remarks) {
		WebElement click_remark=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanRemarks']")));
		click_remark.clear();
		click_remark.sendKeys(remarks);
	}
	
	public void Carried_By(String carried) {
		WebElement click_carried=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanCarriedBy']")));
		click_carried.clear();
		click_carried.sendKeys(carried);
	}
	
	public void Truck(String truck) {
		WebElement click_truck=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanCarriedBy']")));
		click_truck.clear();
		click_truck.sendKeys(truck);
	}
	
	public void Driver(String driver) {
		WebElement click_driver=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanCarriedBy']")));
		click_driver.clear();
		click_driver.sendKeys(driver);
	}

	public void Product_Set(String[] products, String[] batches, String[]expiries,String[]qtys) {
		for(int i=0; i<products.length;i++) {
			String product=products[i];
			String batch=batches[i];
			String expiry=expiries[i];
			String qty=qtys[i];
			
			try {
				  // -------------------
	            // 1️⃣ Select Product
	            // -------------------
				
				if(product == null || product.trim().isEmpty()) {
					System.out.println("Product blank index:" +i);
					continue;
				}
				
				WebElement dropdown=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//div[@id='product_id_chosen']")));
				dropdown.click();
				WebElement search=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//div[@id='product_id_chosen']//input")));
				search.clear();
				search.sendKeys(product);
				
				List<WebElement> options=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
						.xpath("//div[@id='product_id_chosen']//li[contains(@class,'active-result')]")));
				for(WebElement opt:options) {
					if(opt.getText().trim().equalsIgnoreCase(product.trim())) {
						try {
							opt.click();
						} catch (Exception e) {
							js.executeScript("arguments[0].click();", opt);
						}
						break;
					}
				}
				
				// -------------------
	            // 2️⃣ Batch
	            // -------------------
				
				try {
					if(batch !=null && !batch.trim().isEmpty()) {
						WebElement batchDrop=wait.until(ExpectedConditions.elementToBeClickable(By
								.id("batch_no")));
						//dropdown option load wait
						
						wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
								.xpath("//select[@id='batch_no']//option"), 1));
						Select select = new Select(batchDrop);
						select.selectByVisibleText(batch);
					}
				} catch (Exception e) {
					System.out.println("Batch not found: " + batch);
				}
				
				//expiry
				
				try {

	                if (expiry != null && !expiry.trim().isEmpty()) {

	                    WebElement expiryDropdown = wait.until(
	                            ExpectedConditions.elementToBeClickable(By.id("expire_date")));

	                    // wait until expiry options load
	                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	                            By.xpath("//select[@id='expire_date']/option"), 1));

	                    Select expirySelect = new Select(expiryDropdown);
	                    expirySelect.selectByVisibleText(expiry);
	                }

	            } catch (Exception e) {
	                System.out.println("Expiry not found: " + expiry);
	            }

				  // -------------------
	            // 4️⃣ Quantity
	            // -------------------
	            if (qty != null && !qty.trim().isEmpty()) {
	                WebElement qtyInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("ChallanChallanQty")));
	                qtyInput.clear();
	                qtyInput.sendKeys(qty);
	            }

	            // -------------------
	            // 5️⃣ Add button
	            // -------------------
	            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//span[contains(@class,'add_more')]")));
	            js.executeScript("arguments[0].click();", addBtn);

	         // -------------------
	            // 6️⃣ Duplicate check
	            // -------------------
	            try {
	                WebElement existMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//div[contains(text(),'product already exist')]")));

	                if (existMsg.isDisplayed()) {
	                    System.out.println("Product already exists: " + product);
	                }

	            } catch (TimeoutException e) {
	                // no duplicate
	            }

	            Thread.sleep(500);
			} catch (Exception e) {
				 System.out.println("Error processing product: " + product + " | " + e.getMessage());
			}
		}
	}
	
	//ADD PRODUCT BUTTON
		public void AddProductBtn() {
			WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//span[@class='btn btn-xs btn-primary add_more']")));
	        js.executeScript("arguments[0].click();", addBtn);
		}
		
		public void Draft_Button() {
			WebElement click_draft=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@name='draft']")));
			js.executeScript("arguments[0].click();", click_draft);
		}
		
		public void Submit_Button() {
			WebElement click_submit=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@name='save']")));
			js.executeScript("arguments[0].click();", click_submit);
		}
	
}
