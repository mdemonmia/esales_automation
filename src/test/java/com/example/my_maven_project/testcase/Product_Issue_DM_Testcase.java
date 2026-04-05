package com.example.my_maven_project.testcase;

import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_Issue_DM;

public class Product_Issue_DM_Testcase extends BaseTest{
	
//  @Test(priority=1)
//  public void click_AddProductBtnWithBlankReceiverStore() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Receiver_Store("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=2)
//  public void click_AddProductBtnWithValidReceiverStore() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Receiver_Store("Link Road_Store (Hasan Mia )");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=3)
//  public void click_AddProductBtnWithBlankIssueDate() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Product_Issue_Date("");
//	  PID.AddProductBtn();
//  }
	
//  @Test(priority=4)
//  public void click_AddProductBtnWithValidIssueDate() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Product_Issue_Date("11");
//	  PID.AddProductBtn();
//  }

//  @Test(priority=5)
//  public void click_AddProductBtnWithBlankRemarks() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Remarks("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=6)
//  public void click_AddProductBtnWithValidRemarks() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Remarks("Test");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=7)
//  public void click_AddProductBtnWithBlankcarriedBy() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Carried_By("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=8)
//  public void click_AddProductBtnWithValidcarriedBy() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Carried_By("Rabbi");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=9)
//  public void click_AddProductBtnWithBlankTruck() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Truck("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=10)
//  public void click_AddProductBtnWithBlankTruck() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Truck("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=11)
//  public void click_AddProductBtnWithValidTruck() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Truck("4220");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=12)
//  public void click_AddProductBtnWithBlankDriver() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Driver("");
//	  PID.AddProductBtn();
//  }
  
//  @Test(priority=13)
//  public void click_AddProductBtnWithValidkDriver() {
//	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
//	  Product_Issue_DM PID=new Product_Issue_DM(driver);
//	  PID.Add_Issue_DM();
//	  PID.Driver("Turzo");
//	  PID.AddProductBtn();
//  }
  
  @Test(priority=13)
  public void click_AllWithValidField() {
	  driver.get("http://202.126.123.157/esales_live/admin/dm_product_issues/"); 
	  Product_Issue_DM PID=new Product_Issue_DM(driver);
	  PID.Add_Issue_DM();
	  PID.Receiver_Store("Link Road_Store (Hasan Mia )");
	  PID.Product_Issue_Date("12");
	  PID.Remarks("Test");   
	  PID.Carried_By("Rabbi");
	  PID.Truck("4220");
	  PID.Driver("Turzo");
	  String[] products = {"Product 29","Product 52"};
      String[] batchs = {"IN2027","IN2027"};
      String[] expiries = {"Nov-29","Mar-30"};
      String[] qtys = {"2","5"};
      PID.Product_Set(products, batchs, expiries, qtys);
      PID.Draft_Button();
      PID.Submit_Button();
  }
}
