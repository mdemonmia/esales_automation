package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_productlist;

public class Product_productlist_Testcase extends BaseTest{
  @Test(priority=1)
  public void Search_product_Name_Reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_productName("Product 704");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
 
  @Test(priority=2)
  public void Search_Category_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_product_Category("Categories 1");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=3)
  public void Search_Brand_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_Brand("Brand 31");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=4)
  public void Search_Variant_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_Variant("Variant 38");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=5)
  public void Search_Measurement_Unit_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_Measurement_unit("PIECES");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=6)
  public void Search_Product_Type_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_Product_Type("Saleable");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=7)
  public void Search_Group_Name_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_Group_Name("Group-Common");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=8)
  public void Search_All_Field_Reset() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.click_product_Category("Categories 1");
	  Ppi.click_Brand("Brand 31");
	  Ppi.click_Variant("Variant 38");
	  Ppi.click_Measurement_unit("PIECES");
	  Ppi.click_Product_Type("Saleable");
	  Ppi.click_Group_Name("Group-Common");
	  Ppi.click_searchBtn();
	  Ppi.click_resetBtn();
  }
  
  @Test(priority=9)
  public void Product_Rearrange() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.product_Rearrange();
	  
  }
  
  @Test(priority=10)
  public void Product_view() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.product_view();
	  
  }
  
  
  @Test(priority=11)
  public void Product_Edit_Blank_productName() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.product_edit();
	  Ppi.product_Name("");
	  Ppi.Bangla_Name("Product_704");
	  Ppi.Display_Name("Product_704");
	  Ppi.click_product_Category("Categories 1");
	  Ppi.click_Brand("Brand 31");
	  Ppi.click_Variant("Variant 38");
	  Ppi.click_Product_Type("Saleable");
	  
	  Ppi.SaveBtn();
	  
	  Assert.assertTrue(Ppi.product_Name_ErrorDisplay(), "Please fill out this field.");
	  
  }
  
  
  @Test(priority=12)
  public void Product_Edit_Blank_productName_Tik_pharma_sd() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.product_edit();
	  Ppi.product_Name("");
	  Ppi.Bangla_Name("Product_704");
	  Ppi.Display_Name("Product_704");
	  Ppi.click_product_Category("Categories 1");
	  Ppi.click_Brand("Brand 31");
	  Ppi.click_Variant("Variant 38");
	  Ppi.click_Product_Type("Saleable");
	  Ppi.is_Pharma();
	  Ppi.is_SD();
	  Ppi.SaveBtn();
	  
	  Assert.assertTrue(Ppi.product_Name_ErrorDisplay(), "Please fill out this field.");
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority=13)
  public void Product_Edit_right_productName_Tik_pharma_sd() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/products");
	  Product_productlist Ppi=new Product_productlist(driver);
	  Ppi.click_Product_productlist();
	  Ppi.product_edit();
	  Ppi.product_Name("Product_704");
	  Ppi.Bangla_Name("Product_704");
	  Ppi.Display_Name("Product_704");
	  Ppi.click_product_Category("Categories 1");
	  Ppi.click_Brand("Brand 31");
	  Ppi.click_Variant("Variant 38");
	  Ppi.click_Product_Type("Saleable");
	  Ppi.is_Pharma();
	  Ppi.is_SD();
	  Ppi.SaveBtn();
	  
	  Assert.assertTrue(Ppi.is_Product_saved_Successfully(), "saved message not displayed");
	  
	  
  }
  
  
}


