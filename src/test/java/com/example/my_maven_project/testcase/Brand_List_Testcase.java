package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Brand_List;

public class Brand_List_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_blank_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.add_brand();
	  BL.brand_Name("");
	  BL.submitBtn();
	  
	  Assert.assertTrue(BL.BnameErrorDisplay(), "Field isn't filled.");
	  
  }
  
  @Test(priority=2)
  public void click_exist_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.add_brand();
	  BL.brand_Name("Brand 80");
	  BL.submitBtn();
	  
	  Assert.assertTrue(BL.BnameErrorDisplayExist(), "Brand name isn't exist.");
	  
  }
  
  @Test(priority=3)
  public void click_proper_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.add_brand();
	  BL.brand_Name("Brand_80");
	  BL.submitBtn();
	  
	  Assert.assertTrue(BL.is_successfully(), "Brand name isn't save successfully.");
	  
  }
  
  @Test(priority=4)
  public void click_edit_blank_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.brand_Edit();
	  BL.brand_Name("");
	  BL.updateBtn();
	  
	  Assert.assertTrue(BL.BnameErrorDisplay(), "Field isn't filled.");
	  
  }
  
  @Test(priority=5)
  public void click_edit_proper_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.brand_Edit();
	  BL.brand_Name("Brand_80_1");
	  BL.updateBtn();
	  
	  Assert.assertTrue(BL.is_successfully(), "Brand name updated successfull.");
	  
  }
  
  @Test(priority=6)
  public void click_edit_delete_brand_Name() {
	  driver.get("http://202.126.123.157/esales_live/admin/brands/");
	  Brand_List BL=new Brand_List(driver);
	  BL.click_Brand();
	  BL.deleteBtn(true);
	  
  }
  
}
