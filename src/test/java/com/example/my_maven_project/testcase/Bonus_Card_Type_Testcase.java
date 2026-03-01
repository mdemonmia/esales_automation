package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Bonus_Card_Type;

public class Bonus_Card_Type_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_Blank_Type_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.add_bonus_Card();
	  BCT.Bonus_Card_Name("");
	  BCT.saveBtn();
	  
	  Assert.assertTrue(BCT.BonusCardTypeErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=2)
  public void click_Blank_Type_Exist_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.add_bonus_Card();
	  BCT.Bonus_Card_Name("Big Bonus");
	  BCT.saveBtn();
	  
	  Assert.assertTrue(BCT.BonusCardTypeExistErrorDisplay(), "Name field isn't exist.");
  }
  
  @Test(priority=3)
  public void click_Proper_Type_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.add_bonus_Card();
	  BCT.Bonus_Card_Name("Big Bonus 1");
	  BCT.saveBtn();
	  
	  Assert.assertTrue(BCT.is_saved_successfull(), "Name field isn't exist.");
  }
  
  @Test(priority=4)
  public void click_Edit_Blank_Type_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.Bonus_Card_edit();
	  BCT.Bonus_Card_Name("");
	  BCT.saveBtn();
	  
	  Assert.assertTrue(BCT.BonusCardTypeErrorDisplay(), "Field isn't filled.");
  }
  
  @Test(priority=5)
  public void click_Edit_Proper_Type_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.Bonus_Card_edit();
	  BCT.Bonus_Card_Name("Big_Bonus_1");
	  BCT.saveBtn();
	  
	  Assert.assertTrue(BCT.is_saved_successfull(), "Field isn't filled.");
  }
  
  @Test(priority=6)
  public void click_Delete_Type_Name() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/bonus_card_types");
	  Bonus_Card_Type BCT=new Bonus_Card_Type(driver);
	  BCT.click_Bonus_Card_Type();
	  BCT.Bonus_Card_delete(true);
	  
	  Assert.assertTrue(BCT.is_delete_successfull(), "Bonus card type isn't deleted.");
  }
  
}


