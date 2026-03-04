package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Vat_Executing;

public class Vat_Executing_Testcase extends BaseTest{
	
//  @Test(priority=1)
//  public void click_Null_ProductType_Other_Field_Proper_Data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
//	  Vat_Executing VE=new Vat_Executing(driver);
//	  VE.Add_VAT_Execute();
//	  VE.Product_Type(null);
//	  VE.SubmitBtn();
//	  
//	  Assert.assertTrue(VE.ProductTypeErrorDisplay(), "Item isnot select in the list.");
//  }
//  
//  @Test(priority=2)
//  public void click_Empty_ProductType_Other_Field_Proper_Data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
//	  Vat_Executing VE=new Vat_Executing(driver);
//	  VE.Add_VAT_Execute();
//	  VE.Product_Type("");
//	  VE.SubmitBtn();
//	  
//	  Assert.assertTrue(VE.ProductTypeErrorDisplay(), "Item isnot select in the list.");
//  }
  
//  @Test(priority=3)
//  public void click_valid_ProductType_Other_Field_Proper_Data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
//	  Vat_Executing VE=new Vat_Executing(driver);
//	  VE.Add_VAT_Execute();
//	  VE.Product_Type("Saleable");
//	  VE.SubmitBtn();
//	  
//	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
//  }
  
//  @Test(priority=4)
//  public void click_null_Product_Other_Field_Proper_Data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
//	  Vat_Executing VE=new Vat_Executing(driver);
//	  VE.Add_VAT_Execute();
//	  VE.Product_Type("Saleable");
//	  VE.Products(null);
//	  VE.SubmitBtn();
//	  
//	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
//  }
  
//  @Test(priority=5)
//  public void click_blank_Product_Other_Field_Proper_Data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
//	  Vat_Executing VE=new Vat_Executing(driver);
//	  VE.Add_VAT_Execute();
//	  VE.Product_Type("Saleable");
//	  VE.Products("");
//	  VE.SubmitBtn();
//	  
//	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
//  }
  
  @Test(priority=6)
  public void click_valid_Product_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products("Product 704");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.EffectiveDateErrorDisplay(), "Item isnot select in the list");
  }
}
