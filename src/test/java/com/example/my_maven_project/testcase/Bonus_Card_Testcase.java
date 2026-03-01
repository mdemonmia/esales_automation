package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Bonus_Card;

public class Bonus_Card_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_name_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("200");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.BonusCardErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=2)
  public void click_fiscal_year_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("200");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.FiscalYearErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=3)
  public void click_bonus_card_type_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("200");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.BonusCardTypeErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=4)
  public void click_product_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("200");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.BonusCardProductErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=5)
  public void click_MinQTY_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("");
	  BC.Min_Qty_Per_Year("200");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.MinPerQTYErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=6)
  public void click_MinYear_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.MinPerYearErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=7)
  public void click_all_blank_other_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("");
	  BC.Fiscal_Year_Name("");
	  BC.Bonus_Card_Type("");
	  BC.Bonus_Card_Product("");
	  BC.Min_Qty_Per_Memo("");
	  BC.Min_Qty_Per_Year("");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.BonusCardErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=8)
  public void click_all_field_with_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.add_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("2025-2026");
	  BC.Bonus_Card_Type("Big Bonus");
	  BC.Bonus_Card_Product("Product 27");
	  BC.Min_Qty_Per_Memo("20");
	  BC.Min_Qty_Per_Year("300");
	  BC.is_active_checkbox();
	  BC.click_SaveBtn();
	  
	  Assert.assertTrue(BC.is_saved_successfully(), "Field isn't filled.");
  }
  
  
  @Test(priority=9)
  public void click_Filter_name_field_with_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
	  Bonus_Card BC=new Bonus_Card(driver);
	  BC.click_Bonus_Card();
	  BC.Bonus_Card_Name("Product 27 Big Bonus");
	  BC.Fiscal_Year_Name("");
	  BC.Bonus_Card_Type("");
	  BC.Bonus_Card_Product("");
	  BC.click_SearchBtn();
	  Thread.sleep(5000);
	  BC.click_resetBtn();
	  
  }
  
	  @Test(priority=10)
	  public void click_Filter_Bonus_Card_Type_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.Bonus_Card_Name("");
		  BC.Fiscal_Year_Name("");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("");
		  BC.click_SearchBtn();
		  Thread.sleep(5000);
		  BC.click_resetBtn();
		  
	  }
	
	 @Test(priority=11)
	  public void click_Filter_Product_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.Bonus_Card_Name("");
		  BC.Fiscal_Year_Name("");
		  BC.Bonus_Card_Type("");
		  BC.Bonus_Card_Product("Product 27");
		  BC.click_SearchBtn();
		  Thread.sleep(5000);
		  BC.click_resetBtn();
		  
	  }
	
	
	 @Test(priority=12)
	  public void click_Filter_fiscal_year_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.Bonus_Card_Name("");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("");
		  BC.Bonus_Card_Product("");
		  BC.click_SearchBtn();
		  Thread.sleep(5000);
		  BC.click_resetBtn();
		  
	  }
	
	 @Test(priority=13)
	  public void click_Filter_all_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.click_SearchBtn();
		  Thread.sleep(5000);
		  BC.click_resetBtn();
		  
	  }
	 
	 @Test(priority=14)
	  public void click_edit_name_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.BonusCardErrorDisplay(), "Field isn't filled.");
		  
	  }
	 
	 @Test(priority=15)
	  public void click_edit_Fiscal_Year_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.FiscalYearErrorDisplay(), "Field isn't filled.");
		  
	  }
	 
	 @Test(priority=16)
	  public void click_edit_Bonus_Card_Type_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.BonusCardTypeErrorDisplay(), "Not selected item in the list.");
		  
	  } 
	 
	 @Test(priority=17)
	  public void click_edit_Bonus_Card_Product_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.BonusCardProductErrorDisplay(), "Not selected item in the list.");
		  
	  } 
	 
	 @Test(priority=18)
	  public void click_edit_Bonus_Card_MinQtyMemo_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.MinPerQTYErrorDisplay(), "Field isn't filled.");
		  
	  }
  
	 @Test(priority=19)
	  public void click_edit_Bonus_Card_MinQtyYear_field_blank_other_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.MinPerYearErrorDisplay(), "Field isn't filled.");
		  
	  }
	 
	 @Test(priority=20)
	  public void click_edit_Bonus_Card_All_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_editBtn();
		  BC.Bonus_Card_Name("Product 27 Big Bonus");
		  BC.Fiscal_Year_Name("2025-2026");
		  BC.Bonus_Card_Type("Big Bonus");
		  BC.Bonus_Card_Product("Product 27");
		  BC.Min_Qty_Per_Memo("20");
		  BC.Min_Qty_Per_Year("300");
		  BC.is_active_checkbox();
		  BC.click_SaveBtn();
		  
		  Assert.assertTrue(BC.is_saved_successfully(), "Field isn't saved.");
		  
	  }
	
	 @Test(priority=21)
	  public void click_edit_Bonus_Card_Delete_field() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/bonus_cards/");
		  Bonus_Card BC=new Bonus_Card(driver);
		  BC.click_Bonus_Card();
		  BC.click_dltBtn(true);
		  
		  Assert.assertTrue(BC.is_delete_successfully(), "Field isn't deleted.");
		  
	  }
	
}
