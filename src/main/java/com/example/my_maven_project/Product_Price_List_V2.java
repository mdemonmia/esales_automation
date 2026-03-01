package com.example.my_maven_project;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Price_List_V2 {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Product_Price_List_V2(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Price_List() {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Products']")));
		
		try {
			new Actions(driver).moveToElement(click_product).perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			click_product.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", click_product);
		}
		
		
		
		WebElement click_Product_Price=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//span[contains(normalize-space(),'Product Price List')]")));
		js.executeScript("arguments[0].scrollIntoView(true);", click_Product_Price);
		try {
			click_Product_Price.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", click_Product_Price);
		}
		
	}
	
	public void click_Set_Price(String pid) {
		WebElement click_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//tr[td[normalize-space()='" + pid + "']]//a[normalize-space()='Set Price']")));
		js.executeScript("arguments[0].click();", click_product);
		
	}
	
	//add new price
	
	public void click_add_Price() {
		WebElement click_add_product=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='New Price']")));
		js.executeScript("arguments[0].click();", click_add_product);
		
	}
	
	
	public void effective_date(String date) {
		WebElement click_date=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductPriceEffectiveDate']")));
		js.executeScript("arguments[0].click();", click_date);
		click_date.clear();
		click_date.sendKeys(date);
		
	}
	
	public void MRP(String mrp) {
		WebElement click_MRP=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductPriceMrp']")));
		click_MRP.clear();
		click_MRP.sendKeys(mrp);
		
	}
	
	public void VAT_apply() {
		WebElement click_VAT_apply=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//b[normalize-space()='Is Vat Applicable :']")));
		js.executeScript("arguments[0].click();", click_VAT_apply);
		
	}
	
	public void VAT_Percentage(String vat) {
		WebElement click_MRP=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductPriceVat']")));
		click_MRP.clear();
		click_MRP.sendKeys(vat);
		
	}
	
	//submit
	public void Submit_Btn() {
		WebElement click_sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@value='Submit']")));
		js.executeScript("arguments[0].click();", click_sBtn);
		
	}
	
	
	public void multipleCheckboxSelect() {
		String [] checkboxes= {"DB :", "SO :", "SR :"};
		
		for(String name:checkboxes) {
			WebElement checkbox=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//td[normalize-space()='" + name + "']/parent::tr//input[@type='checkbox']")));
			if(!checkbox.isSelected()) {
				js.executeScript("arguments[0].click();", checkbox);
			}
		}
	}

	//process click
	public void Process_Btn() {
		WebElement click_pBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[@class='section all_price_section']//button[@class='btn btn-info btn_process pull-right'][normalize-space()='Process']")));
		js.executeScript("arguments[0].click();", click_pBtn);
		
		try {
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			
			System.out.println("Alert is present: " +alert.getText());
			alert.accept();
		} catch (Exception e) {
			System.out.println("No alert appeared after clicking Process.");
		}
		
	}
	
	//unprocess click
	public void unProcess_Btn() {
		WebElement click_upBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[@class='section all_price_section']//button[@class='btn btn-danger btn_unprocess pull-right'][normalize-space()='Unprocess']")));
		js.executeScript("arguments[0].click();", click_upBtn);
		
	}
	
	
	//Minimum Quantity select
	public void click_minQty(String mQty) {
		
		if(mQty!=null && !mQty.isEmpty() && !mQty.matches("^\\d+(\\.\\d+)?$")) {
			throw new IllegalArgumentException("Only numeric value allowed.");
		}
		WebElement click_mqty=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductPriceMinQty']")));
		click_mqty.clear();
		click_mqty.sendKeys(mQty);
		
	}
	
	//Trade Price select
	public void click_Trade_Price(String Tprice) {
		
		if(Tprice!=null && !Tprice.isEmpty() && !Tprice.matches("^\\d+(\\.\\d+)?$")) {
			throw new IllegalArgumentException("Only numeric value allowed.");
		}
		WebElement click_tprice=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='ProductPriceTradePrice']")));
		click_tprice.clear();
		click_tprice.sendKeys(Tprice);
		
	}
	
	//db discount percentage select
	public void click_DB_Disc_per(String discp) {
		if(discp!=null && !discp.isEmpty() && !discp.matches("^\\d+(\\.\\d+)?$")) {
			throw new IllegalArgumentException("Only numeric value allowed.");
		}
		WebElement click_disc_percentage=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='db_discount']")));
		click_disc_percentage.clear();
		click_disc_percentage.sendKeys(discp);
		
	}
	
	//db Price select
	public void click_DB_price(String dprice) {
		if (dprice !=null && !dprice.isEmpty() && !dprice.matches("^\\d+(\\.\\d+)?$")) {
		    throw new IllegalArgumentException("Only numeric value allowed.");
		} 
		WebElement click_db_price=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@id='db_price']")));
		click_db_price.clear();
		click_db_price.sendKeys(dprice);
		
	}
	
	//sr price
	
	public void set_SR_Price(String srp) {
		
		if(srp !=null && !srp.isEmpty() && !srp.matches("^\\d+(\\.\\d+)?$")) {
			throw new IllegalArgumentException("Only numeric value allowed.");
		}
		WebElement click_srp=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@name='data[sr_price][1][]']")));
		click_srp.clear();
		click_srp.sendKeys(srp);
	}
	
	
	//view
	
		public void View_price() {
			
			WebElement click_srp=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//a[i[contains(@class,'glyphicon glyphicon-eye-open')]]")));
			click_srp.click();
		}
		
	//filter
	
	public void product_category(String cat) {
			
			WebElement click_srp=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//select[@id='category_id']")));
			Select select=new Select(click_srp);
			select.selectByVisibleText(cat);
		}
	
	public void product_Type(String type) {
		
		WebElement click_type=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='ProductProductTypeId']")));
		Select select=new Select(click_type);
		select.selectByVisibleText(type);
	}
	
	//search
	public void SearchBtn() {
			
			WebElement click_sBtn=wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//button[normalize-space()='Search']")));
			js.executeScript("arguments[0].click();", click_sBtn);
		}
	
	//search
	public void resetBtn() {
		
		WebElement click_rBtn=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//a[normalize-space()='Reset']")));
		js.executeScript("arguments[0].click();", click_rBtn);
	}
	
	//Error
	public boolean SRpriceErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@name='data[sr_price][1][]']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean DBpriceErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='db_price']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean DBdiscpercentageErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='db_discount']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean TradePriceErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='ProductPriceTradePrice']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean MinqtyErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='ProductPriceMinQty']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean dateErrorDisplay() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//input[@id='ProductPriceEffectiveDate']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean is_save_successfully_Display() {
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@class='alert alert-success']"))).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
