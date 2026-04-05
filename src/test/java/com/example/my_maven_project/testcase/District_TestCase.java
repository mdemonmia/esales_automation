package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.District;

public class District_TestCase extends BaseTest{
	
  @Test(priority=1)
  public void click_BlankName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Name("");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.NameErrorDisplay(), "Field is not filled.");
  }
  
  @Test(priority=2)
  public void click_ValidName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Name("Hasangonj");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=3)
  public void click_BlankDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Division("");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.NameErrorDisplay(), "Field is not saved.");
  }
  
  @Test(priority=4)
  public void click_ValidDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Division("Rangpur");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.NameErrorDisplay(), "Field is not filled.");
  }
  
  @Test(priority=5)
  public void click_ExistName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Name("Hasangonj");
	  Dist.Division("Rangpur");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.NameExistErrorDisplay(), "Field is not saved.");
  }
  
  @Test(priority=6)
  public void click_AllValidOption() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Add_District();
	  Dist.Name("Isla");
	  Dist.Division("Rangpur");
	  Dist.SubmitBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=7)
  public void click_EditBlankName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.EditBtn("Isla");
	  Dist.Name("");
	  Dist.Division("Rangpur");
	  Dist.UpdateBtn();
	  Assert.assertTrue(Dist.NameErrorDisplay(), "Field is not filled.");
  }
  
  @Test(priority=8)
  public void click_EditValidName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.EditBtn("Isla");
	  Dist.Name("Isla_1");
	  Dist.Division("Rangpur");
	  Dist.UpdateBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=9)
  public void click_EditBlankDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.EditBtn("Isla_1");
	  Dist.Division("");
	  Dist.UpdateBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=10)
  public void click_EditValidDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.EditBtn("Isla_1");
	  Dist.Division("Rangpur");
	  Dist.UpdateBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=11)
  public void click_EditValidDivisionName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.EditBtn("Isla_1");
	  Dist.Name("Isla_1");
	  Dist.Division("Rangpur");
	  Dist.UpdateBtn();
	  Assert.assertTrue(Dist.is_saved_successfully(), "Field is not saved.");
  }
  
  @Test(priority=12)
  public void click_DeleteName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.DeleteBtn("Isla_1", true);

  }
  
  @Test(priority=13)
  public void click_EnterFilterName() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.FName("Sylhet");
	  Dist.SearchBtn();
	  Dist.ResetBtn();
  }
  
  @Test(priority=14)
  public void click_EnterFilterDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.Division("Sylhet");
	  Dist.SearchBtn();
	  Dist.ResetBtn();
  }
  
  @Test(priority=15)
  public void click_EnterFilterNameDivision() {
	  driver.get("http://202.126.123.157/esales_live/admin/districts/");
	  District Dist=new District(driver);
	  Dist.FName("Sylhet");
	  Dist.Division("Sylhet");
	  Dist.SearchBtn();
	  Dist.ResetBtn();
  }
  
}
