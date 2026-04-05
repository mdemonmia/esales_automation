package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Division;

public class Division_Testcase extends BaseTest{
	
  @Test(priority=1)
  public void click_blankNameandSubmit() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.Add_Division();
	  divi.Name("");
	  divi.SubmitBtn();
	  
	  Assert.assertTrue(divi.NameErrorDisplay(), "Field isnot filled.");
  }
  
  @Test(priority=2)
  public void click_validNameandSubmit() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.Add_Division();
	  divi.Name("Sylhet");
	  divi.SubmitBtn();
	  
	  Assert.assertTrue(divi.is_saved_successfully(), "Field isnot saved.");
  }
  
  @Test(priority=3)
  public void click_ViewNameRangpur() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.ViewBtn("Rangpur");
	 
  }
  
  @Test(priority=4)
  public void click_blank_EditNameRangpur() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.EditBtn("Rangpur");
	  divi.Name("");
	  divi.SubmitBtn();
	  Assert.assertTrue(divi.NameErrorDisplay(), "Field isnot filled.");
	 
  }
  
  @Test(priority=5)
  public void click_invalid_EditNameRangpur() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.EditBtn("Rangpur");
	  divi.Name("Rangpur_1");
	  divi.SubmitBtn();
	  Assert.assertTrue(divi.is_saved_successfully(), "Field isnot saved.");
	 
  }
  
  @Test(priority=6)
  public void click_valid_EditNameRangpur() {
	  driver.get("http://202.126.123.157/esales_live/admin/divisions");
	  Division divi=new Division(driver);
	  divi.EditBtn("Rangpur_1");
	  divi.Name("Rangpur");
	  divi.SubmitBtn();
	  Assert.assertTrue(divi.is_saved_successfully(), "Field isnot saved.");
	 
  }
}
