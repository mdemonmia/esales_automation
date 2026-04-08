package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Market {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Market(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void Add_Market() {
		WebElement click_market=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Market']")));
		js.executeScript("arguments[0].click();", click_market);
	}
	
	public void Name(String name) {
		try {
			if(name ==null || name.trim().isEmpty()) {
				System.out.println("Name is null/empty: "+name);
				return;
			}
			WebElement click_name=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='MarketName']")));
			click_name.clear();
			click_name.sendKeys(name);
		} catch (Exception e) {
			System.out.println("Name is error: " +name);
		}
		
	}
	
	public void Address(String addr) {
		
		try {
			if(addr == null || addr.trim().isEmpty()) {
				System.out.println("address is null/empty." +addr);
				return;
			}
			WebElement click_addr=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='MarketAddress']")));
			click_addr.clear();
			click_addr.sendKeys(addr);
		} catch (Exception e) {
			System.out.println("address is null/empty." +addr);
		}
		
	}
	
	public void Location_Type(String locty) {
		try {
			if(locty == null || locty.trim().isEmpty()) {
				System.out.println("location type is null/empty." +locty);
				return;
			}
			WebElement click_loc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='MarketLocationTypeId']")));
			Select select = new Select(click_loc);
			boolean found = false;
			for(WebElement loc:select.getOptions()) {
				if(loc.getText().trim().equalsIgnoreCase(locty.trim())) {
					select.selectByVisibleText(loc.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("location type is not found." +locty);
			}
		} catch (Exception e) {
			 System.out.println("Failed to select location type: " + locty);
		     e.printStackTrace();
		}
	}
	
	public void selectThana(String ThanaName) {
	    try {
	        // 1. Dropdown এ click করো
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='MarketThanaId_chosen']")   // adjust if needed
	        ));
	        dropdown.click();

	        // 2. Search box এ type করো
	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[@id='MarketThanaId_chosen']//input")
	        ));
	        searchBox.clear();
	        searchBox.sendKeys(ThanaName);

	        // 3. Matching option select করো   //div[@id='MarketThanaId_chosen']//li[contains(@class,'active-result')]
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='MarketThanaId_chosen']//li[contains(@class,'active-result')]")
	        ));
	        option.click();

	        System.out.println("Selected: " + ThanaName);

	    } catch (Exception e) {
	        System.out.println("Location not found: " + ThanaName);
	        e.printStackTrace();
	    }
	}
	
	public void select_Office(String ofc) {
		try {
			if(ofc == null || ofc.trim().isEmpty()) {
				System.out.println("Office is null/empty:" +ofc);
				return;
			}
			
			WebElement click_ofc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='office_id']")));
			Select select=new Select(click_ofc);
			
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(ofc.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("Office isnot found." +ofc);
			}
		} catch (Exception e) {
			System.out.println("Office name is found error." +ofc);
			e.printStackTrace();
		}
	}
	
	public void select_Territory(String terri) {
		try {
			if(terri == null || terri.trim().isEmpty()) {
				System.out.println("Territory is null/empty" +terri);
				return;
			}
			WebElement click_terri=wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='territory_id']")));
			Select select=new Select(click_terri);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				    By.xpath("//select[@id='territory_id']//option"), 1
				));
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				System.out.println("option: "+option.getText());
				if(option.getText().trim().equalsIgnoreCase(terri.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("Territory is not found." +terri);
			}
		} catch (Exception e) {
			System.out.println("Territory is error." +terri);
			e.printStackTrace();
		}
	}
	
	public void is_active(boolean select) {
	    try {
	        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(
	                By.xpath("//input[@type='checkbox']")
	        ));

	        boolean isChecked = checkbox.isSelected();

	        if (select && !isChecked) {
	            js.executeScript("arguments[0].click();", checkbox);
	        } else if (!select && isChecked) {
	            js.executeScript("arguments[0].click();", checkbox);
	        }

	    } catch (Exception e) {
	        System.out.println("Checkbox action failed");
	        e.printStackTrace();
	    }
	}

	

	public void Save_Btn() {
		WebElement click_btn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", click_btn);
	}
	
	//filter
	
	public void District(String dist) {
		try {
			WebElement click_dist=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='district_id']")));
			Select select = new Select(click_dist);
			boolean found=false;
			for(WebElement option: select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(dist.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("district not found: " +dist);
			}
		} catch (Exception e) {
			System.out.println("district error: " +dist);
			e.printStackTrace();
		}
		
	}
	
	public void Thana(String thana) {
		try {
			WebElement click_thana=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='thana_id']")));
			Select select = new Select(click_thana);
			
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='thana_id']//option"), 1));
			boolean found=false;
			for(WebElement option: select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(thana.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("district not found: " +thana);
			}
		} catch (Exception e) {
			System.out.println("district error: " +thana);
			e.printStackTrace();
		}
		
	}
	
	public void Search_Btn() {
		WebElement click_btn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[normalize-space()='Search']")));
		js.executeScript("arguments[0].click();", click_btn);
	}
	
	public void Reset_Btn() {
		WebElement click_btn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Reset']")));
		js.executeScript("arguments[0].click();", click_btn);
	}
	
	public boolean NameErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//input[@id='MarketName']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean LocationTypeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='MarketLocationTypeId']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean OfficeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='office_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean TerritoryErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='territory_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isSaved_successfully() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
