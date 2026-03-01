package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_Price_List_V2;

public class Product_Price_List_V2_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_Blank_set_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
//	  PPL.click_Price_List();
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=2)
  public void click_Blank_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.Process_Btn();
	 
  }
  
  @Test(priority=3)
  public void click_multiple_Checkbox_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	 
	 
	  PPL.Submit_Btn();
  }
  
  
  @Test(priority=4)
  public void click_multiplecheckbox_process_unprocess_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	 
	  PPL.Process_Btn();
	  PPL.unProcess_Btn();
  }

  @Test(priority=5)
  public void click_Blank_minqty_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  @Test(priority=6)
  public void click_Blank_Tprice_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.click_Trade_Price("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  @Test(priority=7)
  public void click_Blank_DBDiscount_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.click_Trade_Price("");
	  PPL.click_DB_Disc_per("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  @Test(priority=8)
  public void click_Blank_DBPrice_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.click_Trade_Price("");
	  PPL.click_DB_Disc_per("");
	  PPL.click_DB_price("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  
  @Test(priority=9)
  public void click_Blank_SRPrice_process_Price() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.click_Trade_Price("");
	  PPL.click_DB_Disc_per("");
	  PPL.click_DB_price("");
	  PPL.set_SR_Price("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  @Test(priority=10)
  public void click_Blank_date_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.dateErrorDisplay(), "Filed not filled.");
	  
  }
  
  
  @Test(priority=11)
  public void click_Blank_Mrp_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.is_save_successfully_Display(), "Field isnot saved.");
	  
  }
  
  @Test(priority=12)
  public void click_Blank_percentage_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.is_save_successfully_Display(), "Field isnot saved.");
	  
  }
 
  @Test(priority=13)
  public void click_Blank_MinQty_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.MinqtyErrorDisplay(), "Field isnot saved.");
	  
  }
  
  @Test(priority=14)
  public void click_Blank_Trade_Price_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.TradePriceErrorDisplay(), "Field isnot saved.");
	  
  }
  
  @Test(priority=15)
  public void click_Blank_DB_Discount_Percentage_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("");
	  PPL.click_DB_price("");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.DBdiscpercentageErrorDisplay(), "Field isnot saved.");
	  
  }
  
  @Test(priority=16)
  public void click_Blank_SR_Price_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.SRpriceErrorDisplay(), "Field isnot saved.");
	  
  }
  
  @Test(priority=17)
  public void click_all_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
	  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
	  PPL.click_Set_Price("Product 59");
	  PPL.click_add_Price();
	  PPL.effective_date("2020-02-25");
	  PPL.MRP("300");
	  PPL.VAT_apply();
	  PPL.VAT_Percentage("10");
	  PPL.multipleCheckboxSelect();
	  PPL.Process_Btn();
	  PPL.click_minQty("1");
	  PPL.click_Trade_Price("300");
	  PPL.click_DB_Disc_per("3");
	  PPL.click_DB_price("291");
	  PPL.set_SR_Price("300");
	  PPL.Submit_Btn();
	  
	  Assert.assertTrue(PPL.is_save_successfully_Display(), "Field isnot saved.");
	  
  }
	
	 @Test(priority=18)
	  public void click_view_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
		  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
		  PPL.click_Set_Price("Product 59");
		  PPL.View_price();
	  }
	 
	 
	 @Test(priority=19)
	  public void click_category_filter_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
		  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
		  PPL.product_category("Categories 1");
		  PPL.SearchBtn();
		  PPL.resetBtn();
	  }
	 
	 @Test(priority=20)
	  public void click_product_type_filter_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
		  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
		  PPL.product_Type("Saleable");
		  PPL.SearchBtn();
		  PPL.resetBtn();
	  }
  
	 @Test(priority=21)
	  public void click_All_filter_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/product_prices_v2");
		  Product_Price_List_V2 PPL=new Product_Price_List_V2(driver);
		  PPL.product_category("Categories 1");
		  PPL.product_Type("Saleable");
		  PPL.SearchBtn();
		  PPL.resetBtn();
	  }
}
