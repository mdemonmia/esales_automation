package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Thana;

public class ThanaTestcase extends BaseTest {
	
  @Test(priority=1)
  public void click_blank_name_other_field__valid_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.AddThana();
	  THA.Name("");
	  THA.District("DHAKA");
	  
	  THA.isActive();
	  THA.Submit();
	  
	  Assert.assertTrue(THA.NameErrorDisplay(), "Invalid name.");
  }
  
  @Test(priority=2)
  public void click_blank_district_other_field__valid_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.AddThana();
	  THA.Name("DOHAR");
	  THA.District("");
	  THA.isActive();
	  THA.Submit();
	  
	  Assert.assertTrue(THA.DistrictErrorDisplay(), "Invalid dist name.");
  }
  
  @Test(priority=3)
  public void click_name_exist_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.AddThana();
	  THA.Name("DOHAR");
	  THA.District("Dhaka");
	  THA.isActive();
	  THA.Submit();
	  
	  Assert.assertTrue(THA.NameExist(), "Invalid Existdata.");
  }
  
  @Test(priority=4)
  public void click_all_field_valid_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.AddThana();
	  THA.Name("DOHAR1");
	  THA.District("Dhaka");
	  THA.isActive();
	  THA.Submit();
	  
	  Assert.assertTrue(THA.is_saved_successfully(), "Invalid Existdata.");
  }
  
  @Test(priority=5)
  public void click_edit_name_field_blank_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.EditBtn("DOHAR1");
	  THA.Name("");
	  THA.District("Dhaka");
	  THA.isActive();
	  THA.Update();
	  
	  Assert.assertTrue(THA.NameErrorDisplay(), "Invalid Namedata.");
  }
  
  @Test(priority=6)
  public void click_edit_differentname_field_blank_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.EditBtn("DOHAR1");
	  THA.Name("DOHAR12");
	  THA.District("Dhaka");
	  THA.isActive();
	  THA.Update();
	  
	  Assert.assertTrue(THA.is_saved_successfully(), "Invalid DistNamedata.");
  }
  
  @Test(priority=7)
  public void click_delete_field_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.DeleteBtn("DOHAR12", true);
	  
	  Assert.assertTrue(THA.DeleteDisplay(), "Invalid DistNamedata.");
  }
  
  @Test(priority=8)
  public void click_Search_name_field_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.Name("Banani");
	  THA.SearchBtn();
	  THA.ResetBtn();  
  }
  
  @Test(priority=9)
  public void click_Search_district_field_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.District("Dhaka");
	  THA.SearchBtn();
	  THA.ResetBtn();  
  }
  
  @Test(priority=10)
  public void click_Search_all_field_valid_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/thanas");
	  Thana THA = new Thana(driver);
	  THA.Name("Banani");
	  THA.District("Dhaka");
	  THA.SearchBtn();
	  THA.ResetBtn();  
  }
}
