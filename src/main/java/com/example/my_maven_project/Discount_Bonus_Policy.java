package com.example.my_maven_project;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Discount_Bonus_Policy {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Discount_Bonus_Policy(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_Discount_Policy() {
		WebElement click_Discpoli=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Add New']")));
		js.executeScript("arguments[0].click();", click_Discpoli);
	}
	
	public void Policy_Name(String pn) {
		WebElement click_policy=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyName']")));
		click_policy.clear();
		click_policy.sendKeys(pn);
	}
	
	public void Remarks(String rmrk) {
		WebElement click_remarks=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyRemarks']")));
		click_remarks.clear();
		click_remarks.sendKeys(rmrk);
	}
	
	public void StartDate(String st_date) {
		WebElement click_st_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyStartDate']")));
		click_st_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_st_date, st_date);
	}
	
	public void EndDate(String en_date) {
		WebElement click_en_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyEndDate']")));
		click_en_date.clear();
		js.executeScript("arguments[0].value=arguments[1];", click_en_date, en_date);
	}
	
	public void Policy_Applicable(String PA) {
		WebElement click_Pa=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='policy_applicable']")));
		
		Select select = new Select(click_Pa);
		try {
			select.selectByVisibleText(PA);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("Option not found in Policy Applicable dropdown: " + PA);
		}
		
	}
	
	public void Capping_Policy(String CP) {
		WebElement click_CP=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='caping_policy']")));
		Select select=new Select(click_CP);
		try {
			select.selectByVisibleText(CP);
		} catch (NoSuchElementException e) {
			select.selectByIndex(0);
			System.out.println("Option not found.Default option select.");
		}
	}
	
	public void Target_Quantity_Base(String TQB) {
		WebElement click_target_quantity=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyTargetQty']")));
		click_target_quantity.clear();
		click_target_quantity.sendKeys(TQB);
	}
	
	public void Percentage(String percent) {
		WebElement click_percent=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='DiscountBonusPolicyPercentage']")));
		click_percent.clear();
		click_percent.sendKeys(percent);
	}
	
	public void Discount_Policy_Type(String DPT) {
		WebElement click_DPT=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='discount_policy_type']")));
		Select select=new Select(click_DPT);
		try {
			select.selectByVisibleText(DPT);
		} catch (NoSuchElementException e) {
			select.selectByIndex(0);
			System.out.println("Option not found. Default option selected.");
		}
	}
	
	public void Create_For(String... Options) {
		
		if(Options ==null || Options.length==0) {
			System.out.println("Create for options blank.");
			return;
		}
		
		for(String option:Options) {
			if(option==null || option.trim().isEmpty()) {
				return;
			}
			WebElement click_option=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//label[normalize-space()='" +option+ "']/preceding-sibling::input[@type='checkbox']")));
			if(!click_option.isSelected()) {
				click_option.click();
			}
		}
		
	}
	
	public void Product(String...products) {
		if(products == null || products.length==0) {
			System.out.println("No product");
			return;
		}
		
			for(int i=0;i<products.length;i++) {
				if(products[i]==null || products[i].trim().isEmpty()) {
					return;
				}
				List<WebElement> dropdown=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
						.xpath("//select[contains(@name,'product')]"), i));
				WebElement currentDropdown=dropdown.get(i);
				Select select=new Select(currentDropdown);
				select.selectByVisibleText(products[i]);
				
				if(i<products.length-1) {
					WebElement addBtn=wait.until(ExpectedConditions.elementToBeClickable(By
							.xpath("//button[normalize-space()='Add More']")));
					addBtn.click();
				}
			}
		} 
		
	
	public void Set() {
		WebElement click_setBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Set']")));
		js.executeScript("arguments[0].click();", click_setBtn);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	 
	
	//Policy option
	public void AddpolicyOptions(String[] policy, String[] CFor,String[] Minqty,String[] Unit,String[] MinValue,String[] DiscAmount, String[] discpertk) {
		
		for(int i=0;i<policy.length;i++) {
			// Wait for policy option dropdown count
			
			List<WebElement> policydrop=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
					.xpath("//select[starts-with(@id,'policy_')]/option[normalize-space()='"+policy+"']")));
			WebElement currentDrop=policydrop.get(i);
			Select select=new Select(currentDrop);
			select.selectByVisibleText(policy[i]);
			
			//create for 
			
			    if(CFor == null || CFor.length==0) {
			    	return;
			    }
			   
			    for(String opt:CFor) {
			    	if(opt==null || opt.trim().isEmpty()) {
			    		continue;
			    	}
			    	WebElement click_opt=wait.until(ExpectedConditions.elementToBeClickable(By
			    			.xpath("//label[normalize-space()='" + opt + "']/preceding-sibling::input")));
			    	if(!click_opt.isSelected()) {
			    		click_opt.click();
			    	}
			
			//MINQty
			List<WebElement> minqty=driver.findElements(By
					.xpath("//input[contains(@name,'min_qty')]"));
			minqty.get(i).clear();
			minqty.get(i).sendKeys(Minqty[i]);
			
			//Minvalue
			
			List<WebElement> minvalue=driver.findElements(By
					.xpath("//input[contains(@name,'min_value')]"));
			minvalue.get(i).clear();
			minvalue.get(i).sendKeys(MinValue[i]);
			
			//measurement unit
			
			List<WebElement> mUnit=driver.findElements(By.xpath("//select[contains(@name,'measurement_unit')]"));
			Select select1 =new Select(mUnit.get(i));
			select1.selectByVisibleText(Unit[i]);
			
			//DiscAmount
			List<WebElement> disc_amount=driver.findElements(By
					.xpath("//input[contains(@name,'discount')]"));
			disc_amount.get(i).clear();
			disc_amount.get(i).sendKeys(DiscAmount[i]);
			
			//discount percentage taka
			List<WebElement> dispertk=driver.findElements(By.xpath("//select[contains (@name,'discount_type')]"));
			Select select3=new Select(dispertk.get(i));
			select3.selectByVisibleText(discpertk[i]);
			
			//add more button
			
			if(i<policy.length-1) {
				WebElement addBtn=wait.until(ExpectedConditions.elementToBeClickable(By
						.xpath("//button[normalize-space()='Add More Option']")));
				addBtn.click();
				
				// Wait for new section to appear
				wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
						.xpath("//select[contains(@name,'policy')]"), i+1));
			}
	    }	
		
	  }
	}
	
//	public void AddpolicyOptions(String policy, String CFor,String Minqty,String Unit,String MinValue,String DiscAmount, String discpertk) throws InterruptedException {
//	
//		// 1. Wait for first available dropdown
//	    WebElement currentDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
//	            By.xpath("//select[starts-with(@id,'policy_')]")
//	    ));
//
//	    // 2. Wait for option to be present
//	    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
//	            ExpectedConditions.presenceOfNestedElementLocatedBy(
//	                    currentDropdown,
//	                    By.xpath(".//option[normalize-space()='" + policy + "']")
//	            )
//	    );
//	    
//	    Select select=new Select(currentDropdown);
//	    select.selectByVisibleText(policy);
//	    Thread.sleep(5000);
		
		
//		// প্রথমে select element কে locate করো
//	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
//	        By.xpath("//select[starts-with(@id,'policy_')]")
//	    ));
//	    // Scroll into view (optional, JS use করে)
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
//	    // তারপর Select object তৈরি করো
//	    Select select = new Select(dropdown);
//	 // wait করে visible text select করো
//	    wait.until(driver -> {
//	        try {
//	            select.selectByVisibleText(policy);
//	            return true;
//	        } catch (NoSuchElementException e) {
//	            return false;
//	        }
//	    });
//		
//	    //4. Create For handling
//	   
//	    if(CFor == null || CFor.trim().isEmpty()) {
//	    	return;
//	    }
//	    String[] cfor=CFor.split(",");
//	    for(String opt:cfor) {
//	    	if(opt==null || opt.trim().isEmpty()) {
//	    		continue;
//	    	}
//	    	WebElement click_opt=wait.until(ExpectedConditions.elementToBeClickable(By
//	    			.xpath("//label[normalize-space()='" + opt + "']/preceding-sibling::input")));
//	    	if(!click_opt.isSelected()) {
//	    		click_opt.click();
//	    	}
//	    }
//	    
//	    // 5. MIN Qty
//	    WebElement minQtyInput = driver.findElement(By.xpath("//input[contains(@name,'min_qty')]"));
//	    minQtyInput.clear();
//	    minQtyInput.sendKeys(Minqty);
//
//	    // 6. MIN Value
//	    WebElement minValueInput = driver.findElement(By.xpath("//input[contains(@name,'min_value')]"));
//	    minValueInput.clear();
//	    minValueInput.sendKeys(MinValue);
//
//	    // 7. Measurement Unit
//	    WebElement mUnitDropdown = driver.findElement(By.xpath("//select[contains(@name,'measurement_unit')]"));
//	    new Select(mUnitDropdown).selectByVisibleText(Unit);
//
//	    // 8. Discount Amount
//	    WebElement discountInput = driver.findElement(By.xpath("//input[contains(@name,'discount')]"));
//	    discountInput.clear();
//	    discountInput.sendKeys(DiscAmount);
//
//	    // 9. Discount Type
//	    WebElement discTypeDropdown = driver.findElement(By.xpath("//select[contains(@name,'discount_type')]"));
//	    new Select(discTypeDropdown).selectByVisibleText(discpertk);
//		
//	}
	

	
	//save
	
	public void Save_Btn() {
		WebElement sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		        // JS click
		        js.executeScript("arguments[0].click();", sBtn);
        
	}

	
	public boolean PolicyErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DiscountBonusPolicyName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean StartDateErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DiscountBonusPolicyStartDate']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean EndDateErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='DiscountBonusPolicyEndDate']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
