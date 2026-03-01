package com.example.my_maven_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		this.js=(JavascriptExecutor) driver;
	}
	
	public void click_Dashboard() {
		WebElement dashboard=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[normalize-space()='Dashboard']")));
		js.executeScript("arguments[0].scrollIntoView(true);", dashboard);
		js.executeScript("arguments[0].click();", dashboard);
	}
	
	public void click_Region(String regi) throws InterruptedException {
		WebElement region=wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//select[@id='region_office_id']")));
		Select select=new Select(region);
		try {
			select.selectByVisibleText(regi);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Regional office not found: " +regi);
		}
	}
	
	public void click_Area(String area) throws InterruptedException {
		WebElement area_off=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//select[@id='top_boxes_office_id']")));
		Select select=new Select(area_off);
		try {
			select.selectByVisibleText(area);
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			System.out.println("Area office name not found: " +area);
			throw e;
		}
	}
	
	public void Source(String src) {
		WebElement sorce=wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//select[@id='source']")));
		Select select=new Select(sorce);
		try {
			select.selectByVisibleText(src);
		} catch (NoSuchElementException e) {
			System.out.println("Source not found: " +src);
			throw e;
		}
	}

}
