package com.example.my_maven_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transfer_Thana {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Transfer_Thana(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void selectOffice(String ofc) {
		try {
			WebElement click_ofc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='office_id']")));
			Select select=new Select(click_ofc);
			
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='office_id']/option"), 1));
			if(ofc==null || ofc.trim().isEmpty()) {
				System.out.println("Office is null or empty." +ofc);
				return;
			}
			
				boolean found = false;
				for(WebElement office:select.getOptions()) {
					if(office.getText().trim().toLowerCase().contains("select")) {
						continue;
					}
					if(office.getText().trim().equalsIgnoreCase(ofc.trim())) {
						select.selectByVisibleText(office.getText().trim());
						found=true;
						break;
					}
				}
				if(!found) {
					System.out.println("office not found: "+ofc);
				}
						
		} catch (NoSuchElementException e) {
			System.out.println("office error:" +ofc);
		}
	}
	
	public void selectTooffice(String toofc) {
		try {
			WebElement click_toofc=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='to_office_id']")));
			
			Select select = new Select(click_toofc);
			if(toofc == null || toofc.trim().isEmpty()) {
				System.out.println("To office is null or empty." +toofc);
				return;
			}
			
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='to_office_id']/option"), 1));
			
			boolean found = false;
			for(WebElement offices:select.getOptions()) {
				if(offices.getText().trim().toLowerCase().contains("select")) {
					continue;
				}
				
				if(offices.getText().trim().equalsIgnoreCase(toofc.trim())) {
					select.selectByVisibleText(offices.getText().trim());
					found=true;
					break;
				}	
				
			}
			if(!found) {
				System.out.println("to office not found: " +toofc);
			}
		} catch (NoSuchElementException e) {
			System.out.println("to office error: " +toofc);
		}
		
	}
	
	public void selectTerritory(String terri) {
		try {
			WebElement click_terri=wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='territory_id']")));
			Select select=new Select(click_terri);
			
			if(terri == null || terri.trim().isEmpty()) {
				System.out.println("territory is null or empty."+terri);
				return;
			}
			
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='territory_id']/option"), 1));
			
			boolean found=false;
			for(WebElement territory:select.getOptions()) {
				if(territory.getText().trim().toLowerCase().contains("select")) {
					continue;
				}
				
				if(territory.getText().trim().equalsIgnoreCase(terri.trim())) {
					select.selectByVisibleText(territory.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("territory is not found: "+terri);
			}
		} catch (Exception e) {
			System.out.println("territory error: "+terri);
		}
	}
	
	public void selectToterritory(String toTerri) {
		try {
			WebElement click_toTerri=wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//select[@id='to_territory_id']")));
			Select select = new Select(click_toTerri);
			if(toTerri == null || toTerri.trim().isEmpty()) {
				System.out.println("to territory is null or empty:"+toTerri);
				return;
			}
			
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
					.xpath("//select[@id='to_territory_id']/option"), 1));
			boolean found=false;
			for(WebElement territories:select.getOptions()) {
				if(territories.getText().trim().toLowerCase().contains("select")) {
					continue;
				}
				
				if(territories.getText().trim().equalsIgnoreCase(toTerri.trim())) {
					select.selectByVisibleText(territories.getText().trim());
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println("to territory is not found: " +toTerri);
			}
		} catch (Exception e) {
			System.out.println("to territory is error: " +toTerri);
		}
	}
	

	
	public void selectThana(String thanas) {
	    try {
	    	if(thanas == null || thanas.trim().isEmpty()) {
				System.out.println("thana is null or empty" +thanas);
				return;
			}
	        String[] thanaArray = thanas.split(",");

	        for (String thana : thanaArray) {

	            // label find by text
	            WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//label[normalize-space()='" + thana.trim() + "']")));

	            // get 'for' attribute → ThanaId281
	            String forValue = label.getAttribute("for");

	            // find checkbox using id
	            WebElement checkbox = driver.findElement(By.id(forValue));

	            if (!checkbox.isSelected()) {
	                label.click();   // 🔥 IMPORTANT: label click করলেই checkbox select হবে
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean officeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='office_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void saveBtn() {
		WebElement click_saveBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Save']")));
		js.executeScript("arguments[0].click();", click_saveBtn);
	}
	
	public boolean ToofficeErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='to_office_id']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ToterritoryErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//select[@id='to_territory_id']"))).isDisplayed();
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
