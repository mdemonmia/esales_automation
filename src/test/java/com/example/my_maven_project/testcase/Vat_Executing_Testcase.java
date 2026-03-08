package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Vat_Executing;

public class Vat_Executing_Testcase extends BaseTest{
	
  @Test(priority=1)
  public void click_Null_ProductType_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type(null);
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.ProductTypeErrorDisplay(), "Item isnot select in the list.");
  }
  
  @Test(priority=2)
  public void click_Empty_ProductType_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.ProductTypeErrorDisplay(), "Item isnot select in the list.");
  }
  
  @Test(priority=3)
  public void click_valid_ProductType_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
  }
  
  @Test(priority=4)
  public void click_null_Product_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products(null);
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
  }
  
  @Test(priority=5)
  public void click_blank_Product_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products("");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.ProductErrorDisplay(), "Item isnot select in the list");
  }
  
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
  
  @Test(priority=7)
  public void click_null_effectiveDate_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products("Product 704");
	  VE.Effective_Date(null);
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.EffectiveDateErrorDisplay(), "Item isnot select in the list");
  }
  
  @Test(priority=8)
  public void click_blank_effectiveDate_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products("Product 704");
	  VE.Effective_Date("");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.EffectiveDateErrorDisplay(), "Item isnot select in the list");
  }
  
  @Test(priority=9)
  public void click_valid_effectiveDate_Other_Field_Proper_Data() {
	  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
	  Vat_Executing VE=new Vat_Executing(driver);
	  VE.Add_VAT_Execute();
	  VE.Product_Type("Saleable");
	  VE.Products("Product 704");
	  VE.Effective_Date("01-01-2026");
	  VE.SubmitBtn();
	  
	  Assert.assertTrue(VE.PriceErrorDisplay(), "Item isnot select in the list");
  }
  
	  @Test(priority=10)
	  public void click_null_Price_Other_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price(null);
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.PriceErrorDisplay(), "Item isnot select in the list");
	  }
	  
	  
	  @Test(priority=11)
	  public void click_blank_Price_Other_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price("");
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.PriceErrorDisplay(), "Item isnot select in the list");
	  }
	  
	  @Test(priority=12)
	  public void click_valid_Price_Other_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price("67.5");
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.VatErrorDisplay(), "Item isnot select in the list");
	  }
	  
	  
	  @Test(priority=13)
	  public void click_null_Vat_Other_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price("67.5");
		  VE.VAT(null);
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.VatErrorDisplay(), "Item isnot select in the list");
	  }
  
	  @Test(priority=14)
	  public void click_blank_Vat_Other_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price("67.5");
		  VE.VAT("");
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.VatErrorDisplay(), "Item isnot select in the list");
	  }
	  
	  @Test(priority=15)
	  public void click_All_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Add_VAT_Execute();
		  VE.Product_Type("Saleable");
		  VE.Products("Product 704");
		  VE.Effective_Date("01-01-2026");
		  VE.Price("67.5");
		  VE.VAT(".00");
		  VE.SubmitBtn();
		  
		  Assert.assertTrue(VE.is_saved_successfull(), "Item isnot select in the list");
	  }
	  
	  @Test(priority=16)
	  public void click_view_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.ViewBtn();
		
	  }
	  
	  @Test(priority=17)
	  public void click_blank_ProductType_Field_Proper_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.EditBtn();
		  VE.Product_Type("");
		  VE.Products("");
		    
	  }
	  

	  
	  @Test(priority=18)
	  public void click_delete_Vat_Executing() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.DeleteBtn(true);
		  
		  Assert.assertTrue(VE.is_deleted_successfull(), "Item isnot deleted in the list");
	  }
	
	  @Test(priority=19)
	  public void click_Filter_productType_with_properData_Vat_Executing() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Product_Type_Filter("Saleable");
		  VE.Product_Category("");
		  VE.Brand("");
		  VE.Search();
		  
		  VE.Reset();
		  
		  
	  }
	
	 @Test(priority=20)
	  public void click_Filter_productCategory_with_properData_Vat_Executing() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Product_Type_Filter("");
		  VE.Product_Category("Categories 14");
		  VE.Brand("");
		  VE.Search();
		  
		  VE.Reset();
		  
		  
	  }
	 
	 
	 @Test(priority=21)
	  public void click_Filter_productBrand_with_properData_Vat_Executing() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Product_Type_Filter("");
		  VE.Product_Category("");
		  VE.Brand("Brand 75");
		  VE.Search();
		  
		  VE.Reset();
		   
	  }
	 
	 @Test(priority=22)
	  public void click_Filter_with_properData_Vat_Executing() {
		  driver.get("http://202.126.123.157/esales_live/admin/vatexecuting_products/");
		  Vat_Executing VE=new Vat_Executing(driver);
		  VE.Product_Type_Filter("Saleable");
		  VE.Product_Category("Categories 14");
		  VE.Brand("Brand 75");
		  VE.Search();
		  
		  VE.Reset();
		   
	  }
	  
}
