package com.example.my_maven_project.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.National_Sales_Target;

public class National_Sales_Target_Testcase extends BaseTest{
	
//  @Test(priority=1)
//  public void click_blankFiscalYear() {
//	  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//	  National_Sales_Target NST=new National_Sales_Target(driver);
//	  NST.Fiscal_Year("");
//	  
//	  NST.SaveBtn();
//	  Assert.assertTrue(NST.FiscalYearErrorDisplay(), "Item not selected.");
//	  
//  }
  
//  @Test(priority=2)
//  public void click_validFiscalYear() {
//	  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//	  National_Sales_Target NST=new National_Sales_Target(driver);
//	  NST.Fiscal_Year("2025-2026");
//	  NST.SaveBtn();
//	  Assert.assertTrue(NST.ProductErrorDisplay(), "Item not selected.");
//	  
//  }
	
//	  @Test(priority=3)
//	  public void click_blankMonth() {
//		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//		  National_Sales_Target NST=new National_Sales_Target(driver);
//		  NST.Month("");
//		  NST.SaveBtn();
//		  Assert.assertTrue(NST.ProductErrorDisplay(), "Item not selected.");
//		  
//	  }
	  
//	  @Test(priority=4)
//	  public void click_validMonth() {
//		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//		  National_Sales_Target NST=new National_Sales_Target(driver);
//		  NST.Month("March");
//		  NST.SaveBtn();
//		  Assert.assertTrue(NST.FiscalYearErrorDisplay(), "Item not selected.");
//		  
//	  }
	
//	  @Test(priority=5)
//	  public void click_blankProduct() {
//		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//		  National_Sales_Target NST=new National_Sales_Target(driver);
//		  NST.Product("");
//		  NST.SaveBtn();
//		  Assert.assertTrue(NST.FiscalYearErrorDisplay(), "Item not selected.");
//		  
//	  }
	  
//	  @Test(priority=6)
//	  public void click_blankProduct() {
//		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//		  National_Sales_Target NST=new National_Sales_Target(driver);
//		  NST.Product("Product 704");
//		  NST.SaveBtn();
//		  Assert.assertTrue(NST.FiscalYearErrorDisplay(), "Item not selected.");
//		  
//	  }
	  
	  @Test(priority=7)
	  public void click_validAllField() {
		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
		  National_Sales_Target NST=new National_Sales_Target(driver);
		  NST.Fiscal_Year("2025-2026");
		  NST.Month("March");
		  NST.Product("Product 704");
		  NST.SetMonthlyTarget("Gulshan", "100", "10000");
		  NST.Target_Set("Mar", "50", "5000");
		  NST.SaveBtn();
		  
	  }
	
//	  @Test(priority=8)
//	  public void click_fileupload() {
//		  driver.get("http://202.126.123.157/esales_live/admin/sale_targets_base_wise");
//		  National_Sales_Target NST=new National_Sales_Target(driver);
//
//		  NST.click_upload();
//		  
//		  
//	  }
}
