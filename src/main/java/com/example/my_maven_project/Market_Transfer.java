package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Market_Transfer {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public Market_Transfer(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}

	public void Office(String ofc) {
		try {
			if(ofc == null || ofc.trim().isEmpty()) {
				System.out.println("Office name is null/empty:"+ofc);
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
				System.out.println("office is not found " +ofc);
			}
		} catch (Exception e) {
			System.out.println("office is error: " +ofc);
			e.printStackTrace();
		}
	}
	
	public void To_Office(String tofc) {
		try {
			if(tofc == null || tofc.trim().isEmpty()) {
				System.out.println("To office is null/empty: " +tofc);
				return;
			}
			
			WebElement click_tofc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='to_office_id']")));
			Select select=new Select(click_tofc);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
					.xpath("//select[@id='to_office_id']//option"),1));
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(tofc.trim())){
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("to office is not found: "+tofc);
			}
		} catch (Exception e) {
			System.out.println("to office is error: "+tofc);
			e.printStackTrace();
		}
	}
	
	public void Territory(String terri) {
		try {
			if(terri == null || terri.trim().isEmpty()) {
				System.out.println("Territory is null/empty:" +terri);
				return;
			}
			
			WebElement  click_terri=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='territory_id']")));
			Select select=new Select(click_terri);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
					.xpath("//select[@id='territory_id']//option"), 1));
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(terri.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("Territory is not found: " +terri);
			}
		} catch (Exception e) {
			System.out.println("Territory is error: " +terri);
			e.printStackTrace();
		}
	}
	
	public void To_territory(String toterri) {
		try {
			if(toterri == null || toterri.trim().isEmpty()) {
				System.out.println("To territory is null/empty:" +toterri);
				return;
			}
			
			WebElement click_toterri=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='to_territory_id']")));
			Select select = new Select(click_toterri);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
					.xpath("//select[@id='to_territory_id']//option"), 1));
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(toterri.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("To territory is not found: " +toterri);
			}
						
		} catch (Exception e) {
			System.out.println("To territory is error: " +toterri);
			e.printStackTrace();
		}
	}
	
	public void Thana(String thana) {
		try {
			if(thana == null || thana.trim().isEmpty()) {
				System.out.println("thana is null/empty: " +thana);
				return;
			}
			
			WebElement click_thana=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='thana_id']")));
			Select select=new Select(click_thana);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
					.xpath("//select[@id='thana_id']//option"), 1));
			boolean found=false;
			for(WebElement option:select.getOptions()) {
				if(option.getText().trim().equalsIgnoreCase(thana.trim())) {
					select.selectByVisibleText(option.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("Thana is not found: " +thana);
			}
		} catch (Exception e) {
			System.out.println("Thana is error: " +thana);
			e.printStackTrace();
		}
	}
	
	public void Markets(String market) {
		try {
			if(market == null || market.trim().isEmpty()) {
				System.out.println("Markets is null/empty: " +market);
				return;
			}
			
			String[] marketArray=market.split(",");
			
			for(String marketName:marketArray) {
				WebElement click_market=wait.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//label[normalize-space()='"+marketName.trim()+"']")));
				String for_value=click_market.getAttribute("for");
				WebElement checkbox=driver.findElement(By.id(for_value));
				if(!checkbox.isSelected()) {
					click_market.click();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void SaveBtn() {
		WebElement click_save=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", click_save);
	}
	
	public boolean OfficeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='office_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean To_OfficeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='to_office_id']"))).isDisplayed();
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
	
	public boolean To_territoryErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='to_territory_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ThanaErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='thana_id']"))).isDisplayed();
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
}
