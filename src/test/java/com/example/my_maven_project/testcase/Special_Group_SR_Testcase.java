package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Special_Group_SR;

public class Special_Group_SR_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_Blank_policyName_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
	  Special_Group_SR SGSR=new Special_Group_SR(driver);
	  SGSR.add_Special_Group_SR();
	  SGSR.policy_Name("");
	  SGSR.Remarks("test");
	  SGSR.Start_Date("2026-01-01");
	  SGSR.End_Date("2026-12-31");
	  SGSR.Remove_office("SBS Commercial Limited");
	  SGSR.Outlet_Group("DB outlet 1");
	  SGSR.Remove_Outlet_Category("Person");
	  SGSR.SubmitBtn();
	  
	  Assert.assertTrue(SGSR.policyNameErrorDisplay(), "field isnot filled.");
  }
  
  @Test(priority=2)
  public void click_Blank_remarks_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
	  Special_Group_SR SGSR=new Special_Group_SR(driver);
	  SGSR.add_Special_Group_SR();
	  SGSR.policy_Name("SR Special Group.");
	  SGSR.Remarks("");
	  SGSR.Start_Date("2026-01-01");
	  SGSR.End_Date("2026-12-31");
	  SGSR.Remove_office("SBS Commercial Limited");
	  SGSR.Outlet_Group("DB outlet 1");
	  SGSR.Remove_Outlet_Category("Person");
	  SGSR.SubmitBtn();
	  
	  Assert.assertTrue(SGSR.is_saved_successfull(), "field isnot filled.");
  }
  
  @Test(priority=3)
  public void click_Blank_startDate_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
	  Special_Group_SR SGSR=new Special_Group_SR(driver);
	  SGSR.add_Special_Group_SR();
	  SGSR.policy_Name("SR Special Group.");
	  SGSR.Remarks("test");
	  SGSR.Start_Date("");
	  SGSR.End_Date("2026-12-31");
	  SGSR.Remove_office("SBS Commercial Limited");
	  SGSR.Outlet_Group("DB outlet 1");
	  SGSR.Remove_Outlet_Category("Person");
	  SGSR.SubmitBtn();
	  
	  Assert.assertTrue(SGSR.StartDateErrorDisplay(), "field isnot filled.");
  }
  
  @Test(priority=4)
  public void click_Blank_EndDate_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
	  Special_Group_SR SGSR=new Special_Group_SR(driver);
	  SGSR.add_Special_Group_SR();
	  SGSR.policy_Name("SR Special Group.");
	  SGSR.Remarks("test");
	  SGSR.Start_Date("2026-01-01");
	  SGSR.End_Date("");
	  SGSR.Remove_office("SBS Commercial Limited");
	  SGSR.Outlet_Group("DB outlet 1");
	  SGSR.Remove_Outlet_Category("Person");
	  SGSR.SubmitBtn();
	  
	  Assert.assertTrue(SGSR.EndDateErrorDisplay(), "field isnot filled.");
  }
  
  @Test(priority=4)
  public void click_Blank_OutletGroup_other_field_proper_data() {
	  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
	  Special_Group_SR SGSR=new Special_Group_SR(driver);
	  SGSR.add_Special_Group_SR();
	  SGSR.policy_Name("SR Special Group.");
	  SGSR.Remarks("test");
	  SGSR.Start_Date("2026-01-01");
	  SGSR.End_Date("2026-12-31");
	  SGSR.Remove_office("SBS Commercial Limited");
	  SGSR.Outlet_Group("");
	  SGSR.Remove_Outlet_Category("Person");
	  SGSR.SubmitBtn();
	  
	  Assert.assertTrue(SGSR.is_saved_successfull(), "field isnot filled.");
  }
	
	  @Test(priority=5)
	  public void click_View_Special_Group() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.view_Special_Group_SR();
		
	  }
	  
	 @Test(priority=6)
	  public void click_Edit_Blank_PolicyName_other_field_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.Edit_Special_Group_SR();
		  SGSR.policy_Name("");
		  SGSR.Remarks("test");
		  SGSR.Start_Date("2026-01-01");
		  SGSR.End_Date("2026-12-31");
		 // SGSR.Remove_office("SBS Commercial Limited");
		  SGSR.Outlet_Group("DB outlet 1");
		 // SGSR.Remove_Outlet_Category("Person");
		  SGSR.SubmitBtn();
		  
		  Assert.assertTrue(SGSR.policyNameErrorDisplay(), "field isnot filled.");
	  }
	 
	 @Test(priority=7)
	  public void click_Edit_Blank_Remarks_other_field_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.Edit_Special_Group_SR();
		  SGSR.policy_Name("SR Special Group");
		  SGSR.Remarks("");
		  SGSR.Start_Date("2026-01-01");
		  SGSR.End_Date("2026-12-31");
		 // SGSR.Remove_office("SBS Commercial Limited");
		  SGSR.Outlet_Group("DB outlet 1");
		 // SGSR.Remove_Outlet_Category("Person");
		  SGSR.SubmitBtn();
		  
		  Assert.assertTrue(SGSR.is_saved_successfull(), "field isnot filled.");
	  }
	
	 @Test(priority=8)
	  public void click_Edit_Blank_StartDate_other_field_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.Edit_Special_Group_SR();
		  SGSR.policy_Name("SR Special Group");
		  SGSR.Remarks("test");
		  SGSR.Start_Date("");
		  SGSR.End_Date("2026-12-31");
		 // SGSR.Remove_office("SBS Commercial Limited");
		  SGSR.Outlet_Group("DB outlet 1");
		 // SGSR.Remove_Outlet_Category("Person");
		  SGSR.SubmitBtn();
		  
		  Assert.assertTrue(SGSR.StartDateErrorDisplay(), "field isnot filled.");
	  }
	
	 @Test(priority=9)
	  public void click_Edit_Blank_EndDate_other_field_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.Edit_Special_Group_SR();
		  SGSR.policy_Name("SR Special Group");
		  SGSR.Remarks("test");
		  SGSR.Start_Date("2026-01-01");
		  SGSR.End_Date("");
		 // SGSR.Remove_office("SBS Commercial Limited");
		  SGSR.Outlet_Group("DB outlet 1");
		 // SGSR.Remove_Outlet_Category("Person");
		  SGSR.SubmitBtn();
		  
		  Assert.assertTrue(SGSR.StartDateErrorDisplay(), "field isnot filled.");
	  }
	
	@Test(priority=10)
	  public void click_Edit_Blank_OutletGroup_other_field_proper_data() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.Edit_Special_Group_SR();
		  SGSR.policy_Name("SR Special Group");
		  SGSR.Remarks("test");
		  SGSR.Start_Date("2026-01-01");
		  SGSR.End_Date("2026-12-31");
		 // SGSR.Remove_office("SBS Commercial Limited");
		  SGSR.Outlet_Group("");
		 // SGSR.Remove_Outlet_Category("Person");
		  SGSR.SubmitBtn();
		  
		  Assert.assertTrue(SGSR.is_saved_successfull(), "field isnot filled.");
	  }
	
	@Test(priority=11)
	  public void click_Delete_Cancel_Special_Group_SR() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.DeleteBtn(false);
		  
	  }
	
	@Test(priority=12)
	  public void click_Delete_True_Special_Group_SR() {
		  driver.get("http://202.126.123.157/esales_live/admin/sr_special_groups/");
		  Special_Group_SR SGSR=new Special_Group_SR(driver);
		  SGSR.DeleteBtn(true);
		  
		  Assert.assertTrue(SGSR.is_delete_successfull(), "field isnot filled.");
	  }
}
