package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_Category;

public class Product_Category_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_Blank_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.add_product_category();
	  PC.category_Name("");
	  PC.Parent_category_Name("");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.categoryErrorDisplay(), "Filled is selected.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=2)
  public void click_right_category_blank_parent_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.add_product_category();
	  PC.category_Name("Categories test_1");
	  PC.Parent_category_Name("");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.is_category_save_successfully(), "Category isn't saved successfully.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=3)
  public void click_right_category_parent_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.add_product_category();
	  PC.category_Name("Categories test");
	  PC.Parent_category_Name("Categories 1");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.is_category_save_successfully(), "Category isn't saved successfully.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=4)
  public void click_right_category_parent_same_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.add_product_category();
	  PC.category_Name("Categories test");
	  PC.Parent_category_Name("Categories 1");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.is_category_exists(), "Category isn't exists.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=5)
  public void click_right_category_parent_edit_blank_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.category_edit();
	  PC.category_Name("");
	  PC.Parent_category_Name("Categories 1");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.categoryErrorDisplay(), "Field not filled.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=6)
  public void click_right_category_parent_edit_blank_parent_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.category_edit();
	  PC.category_Name("Categories_Test");
	  PC.Parent_category_Name("");
	  PC.Is_Pharma_category_Name();
	  PC.SaveBtn();
	  
	  Assert.assertTrue(PC.is_category_save_successfully(), "Category isn't saved successfully.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=7)
  public void click_right_category_delete() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/product_categories");
	  Product_Category PC=new Product_Category(driver);
	  PC.click_Product_category();
	  PC.category_delete(true);
	  
	  Assert.assertTrue(PC.is_category_delete(), "Product category isn't deleted.");
	  Thread.sleep(5000);
  }
  
}
