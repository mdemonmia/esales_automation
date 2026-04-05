package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_Issue_SO;

public class Product_Issue_SO_Testcase extends BaseTest{
	

  @Test(priority=1)
  public void click_AddProductBtnWithBlankReceiverStore_() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
	  Product_Issue_SO PIS = new Product_Issue_SO(driver);
	  PIS.Add_Issue();
	  PIS.Receiver_Store("");
	  PIS.AddProductBtn();
	  
  }
  
  @Test(priority=2)
  public void click_AddProductBtnWithvalidReceiverStore_() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
	  Product_Issue_SO PIS = new Product_Issue_SO(driver);
	  PIS.Add_Issue();
	  PIS.Receiver_Store("Jamgora_Store (Arif Billah )");
	  PIS.AddProductBtn();
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority=3)
  public void click_AddProductBtnWithBlankIssueDate_() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
	  Product_Issue_SO PIS = new Product_Issue_SO(driver);
	  PIS.Add_Issue();
	  PIS.Issue_Date("");
	  PIS.AddProductBtn();
	  
  }
  
  @Test(priority=4)
  public void click_AddProductBtnWithValidIssueDate_() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
	  Product_Issue_SO PIS = new Product_Issue_SO(driver);
	  PIS.Add_Issue();
	  PIS.Issue_Date("10");
	  PIS.AddProductBtn();
	  
  }

	  @Test(priority=5)
	  public void click_AddProductBtnWithBlankRemarks() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.Remarks("");
		  PIS.AddProductBtn();
		  
	  }
  
	  
	  @Test(priority=6)
	  public void click_AddProductBtnWithValidRemarks() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.Remarks("Test");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=7)
	  public void click_AddProductBtnWithBlankcarriedBy() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.CarriedBy("");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=8)
	  public void click_AddProductBtnWithValidCarriedBy() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.CarriedBy("Golam Rabbi");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=9)
	  public void click_AddProductBtnWithBlankTruck() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.Truck("");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=10)
	  public void click_AddProductBtnWithValidTruck() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.Truck("2420");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=11)
	  public void click_AddProductBtnWithBlankDriver() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.DriverInfo("");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=12)
	  public void click_AddProductBtnWithValidDriver() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.DriverInfo("Turzo");
		  PIS.AddProductBtn();
		  
	  }
	  
	  @Test(priority=13)
	  public void click_AllWithValidDriver() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Add_Issue();
		  PIS.Receiver_Store("Jamgora_Store (Arif Billah )");
		  PIS.Issue_Date("10");
		  PIS.Remarks("Test");
		  PIS.CarriedBy("Golam Rabbi");
		  PIS.Truck("2420");
		  PIS.DriverInfo("Turzo");
		  String[] products = {"Product 704","Product 59"};
	      String[] batchs = {"rirgfkb","abc"};
	      String[] expiries = {"Dec-25","Dec-25"};
	      String[] qtys = {"2","5"};
	      PIS.product_Set(products, batchs, expiries, qtys);
	      PIS.Draft_Button();
	      PIS.Submit_Button();
		  
	  }
	
	  @Test(priority=14)
	  public void click_View_ProductIssue() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.View();
		
	  }
	  
	  @Test(priority=15)
	  public void click_ChallanFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Challan_No("PI546317");
		  PIS.Search();
		  PIS.Reset();
	  }
	  
	  @Test(priority=16)
	  public void click_FromDateFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Date_From("01-01-2026");
		  PIS.Search();
		  PIS.Reset();
	  }
	  
	  @Test(priority=17)
	  public void click_ToDateFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Date_To("10-01-2026");
		  PIS.Search();
		  PIS.Reset();
	  }
	  
	  @Test(priority=18)
	  public void click_TerritoryFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Territory("Jamgora (Arif Billah)");
		  PIS.Search();
		  PIS.Reset();
	  }
	  
	  @Test(priority=19)
	  public void click_StatusFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Status("Pending");
		  PIS.Search();
		  PIS.Reset();
	  }
	  
	  @Test(priority=20)
	  public void click_AllvalidFilter() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/product_issues/");
		  Product_Issue_SO PIS = new Product_Issue_SO(driver);
		  PIS.Challan_No("PI546317");
		  PIS.SAP_Challan_No("");
		  PIS.Date_From("11-01-2026");
		  PIS.Date_To("11-03-2026");
		  PIS.Territory("Jamgora (Arif Billah)");
		  PIS.Status("Pending");
		  PIS.SAP_Status("");
		  PIS.Search();
		  PIS.Reset();
	  }
}
