package com.example.my_maven_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Issue_SO {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_Issue_SO(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_Issue() {
		WebElement click_issue=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Create New']")));
		js.executeScript("arguments[0].click();", click_issue);
	}
	

	public void Receiver_Store(String store) {

	    try {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // dropdown load হওয়া wait
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("receiver_store_id")));

	        WebElement dropdown = driver.findElement(By.id("receiver_store_id"));
	        Select select = new Select(dropdown);
	        
	       

	        if (store == null || store.trim().isEmpty()) {

	            select.selectByIndex(0);
	            System.out.println("Default receiver selected");

	        } else {

	            boolean found = false;

	            for (WebElement option : select.getOptions()) {

	                if (option.getText().trim().equalsIgnoreCase(store.trim())) {

	                    option.click();
	                    found = true;
	                    System.out.println("Selected store: " + store);
	                    break;
	                }
	            }

	            if (!found) {
	                System.out.println("Store not found: " + store);
	            }
	        }

	        // DOM refresh wait
	        wait.until(ExpectedConditions.refreshed(
	                ExpectedConditions.presenceOfElementLocated(By.id("receiver_store_id"))));

	    } catch (Exception e) {

	        System.out.println("Receiver store select failed: " + e.getMessage());
	    }
	}
	
	public void Issue_Date(String date) {
		if(date == null || date.trim().isEmpty()) {
			return;
		}
		
		
		WebElement click_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='challan_date']")));
		js.executeScript("arguments[0].click();", click_date);
		
		Actions action=new Actions(driver);
		action.moveToElement(click_date).click().build().perform();
		try {
			WebElement selectDate=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//td[contains(@class,'day') and not(contains(@class,'disabled')) and normalize-space()='" + date + "']")));
			js.executeScript("arguments[0].click();", selectDate);
			action.moveToElement(selectDate).build().perform();
		} catch (StaleElementReferenceException e) {
			 System.out.println("StaleElementReferenceException, retrying to find date...");
		}
		
		
	}
	
	public void Remarks(String remarks) {
		WebElement click_remarks=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanRemarks']")));
		click_remarks.clear();
		click_remarks.sendKeys(remarks);
	}
	
	public void CarriedBy(String carry) {
		WebElement click_carry=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanCarriedBy']")));
		click_carry.clear();
		click_carry.sendKeys(carry);
	}
	
	public void Truck(String truck) {
		WebElement click_truck=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanTruckNo']")));
		click_truck.clear();
		click_truck.sendKeys(truck);
	} 
	
	public void DriverInfo(String driver) {
		WebElement click_driver=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanDriverName']")));
		click_driver.clear();
		click_driver.sendKeys(driver);
	} 
	


	// ----------------------------
	// Helper method: safe alert handling
	// ----------------------------
	
	private void waitForAndAcceptAlert() {
	    try {
	        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));
	        Alert alert = alertWait.until(ExpectedConditions.alertIsPresent());
	        System.out.println("Alert Text: " + alert.getText());
	        alert.accept();
	        Thread.sleep(200); // small pause
	    } catch (TimeoutException e) {
	        // no alert appeared, safe to continue
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (UnhandledAlertException e) {
	        // just in case, handle residual alert
	        try {
	            driver.switchTo().alert().accept();
	        } catch (Exception ex) {
	            System.out.println("No residual alert to handle.");
	        }
	    }
	}
	
	public void product_Set(String[] products, String[] batchs, String[] expiries, String[] qtys) {

	    for (int i = 0; i < products.length; i++) {

	        String product = products[i];
	        String batch = batchs[i];
	        String expiry = expiries[i];
	        String qty = qtys[i];

	        try {

	            // -------------------
	            // 1️⃣ Select Product
	            // -------------------
	            if (product == null || product.trim().isEmpty()) {
	                System.out.println("Product blank at index " + i);
	                continue;
	            }

	            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("//div[@id='product_id_chosen']")));
	            dropdown.click();

	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[@id='product_id_chosen']//input")));
	            search.clear();
	            search.sendKeys(product);

	            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                    By.xpath("//div[@id='product_id_chosen']//li[contains(@class,'active-result')]")
	            ));

	            for (WebElement opt : options) {
	                if (opt.getText().trim().equalsIgnoreCase(product.trim())) {

	                    // normal click try
	                    try {
	                        opt.click();
	                    } catch (Exception e) {
	                        // fallback JS click
	                        js.executeScript("arguments[0].click();", opt);
	                    }

	                    break;
	                }
	            }


	            // -------------------
	            // 2️⃣ Batch
	            // -------------------
	            try {

	                if (batch != null && !batch.trim().isEmpty()) {

	                    WebElement batchDropdown = wait.until(ExpectedConditions.elementToBeClickable(
	                            By.id("batch_no")));

	                    // wait until batch options load
	                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
	                            By.xpath("//select[@id='batch_no']/option"), 1));

	                    Select batchSelect = new Select(batchDropdown);
	                    batchSelect.selectByVisibleText(batch);
	                }

	            } catch (Exception e) {
	                System.out.println("Batch not found: " + batch);
	            }

	            // -------------------
	            // 3️⃣ Expiry
	            // -------------------
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
	
	//View
	
	public void View() {
		WebElement click_view=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
		click_view.click();
				
	}
	
	
	//Filter
	
	public void Challan_No(String challan) {
		
		if(challan == null || challan.trim().isEmpty()) {
			return;
		}
		WebElement click_challan=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanChallanNo']")));
		click_challan.clear();
		click_challan.sendKeys(challan);
	}
	
	public void SAP_Challan_No(String sap_challan) {
		if(sap_challan == null || sap_challan.trim().isEmpty()) {
			return;
		}
		WebElement click_sap_challan=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanChallanReferanceNo']")));
		click_sap_challan.clear();
		click_sap_challan.sendKeys(sap_challan);
	}
	
	public void Date_From(String fDate) {
		if(fDate == null || fDate.trim().isEmpty()) {
			return;
		}
		WebElement click_fDate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanDateFrom']")));
		click_fDate.clear();
		click_fDate.sendKeys(fDate);
		js.executeScript("arguments[0].value=arguments[1];", click_fDate,fDate);
	}
	
	public void Date_To(String tDate) {
		if(tDate == null || tDate.trim().isEmpty()) {
			return;
		}
		WebElement click_tDate=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ChallanDateTo']")));
		click_tDate.clear();
		click_tDate.sendKeys(tDate);
		js.executeScript("arguments[0].value=arguments[1];", click_tDate,tDate);
	}
	
	public void Territory(String territory) {
		if(territory == null || territory.trim().isEmpty()) {
			return;
		}
		WebElement click_territory=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='territory_id']")));
		Select select=new Select(click_territory);
		select.selectByVisibleText(territory);
	}

	public void Status(String status) {
		if(status == null || status.trim().isEmpty()) {
			return;
		}
		WebElement click_status=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ChallanStatus']")));
		Select select=new Select(click_status);
		select.selectByVisibleText(status);
	}
	
	public void SAP_Status(String SAP_status) {
		if(SAP_status == null || SAP_status.trim().isEmpty()) {
			return;
		}
		WebElement click_sap_status=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ChallanStatus']")));
		Select select=new Select(click_sap_status);
		select.selectByVisibleText(SAP_status);
	}
	
	
	//Search 
	public void Search() {
		WebElement click_search=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Search']")));
		click_search.click();
				
	}
	
	//Reset
		public void Reset() {
			WebElement click_reset=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[normalize-space()='Reset']")));
			click_reset.click();
					
		}
	
}
