package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Special_Group;

public class Special_Group_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_blank_policyname_other_field_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
	  Special_Group SG=new Special_Group(driver);
	  SG.add_Special_Group();
	  SG.policy_Name("");
	  SG.Remarks("test");
	  SG.Start_Date("2026-01-01");
	  SG.End_Date("2026-12-31");
	  SG.Territory_add(true,null,null);
	  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
	  SG.SubmitBtn();
	  Assert.assertTrue(SG.policyErrorDisplay(), "Field isnot filled.");
  }
 
  @Test(priority=2)
  public void click_blank_rename_other_field_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
	  Special_Group SG=new Special_Group(driver);
	  SG.add_Special_Group();
	  SG.policy_Name("Vertical Innovation Joya Offer 2026");
	  SG.Remarks("");
	  SG.Start_Date("2026-01-01");
	  SG.End_Date("2026-12-31");
	  SG.Territory_add(true,null,null);
	  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
	  SG.SubmitBtn();
	  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot saved.");
  }
  
  @Test(priority=3)
  public void click_blank_startDate_other_field_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
	  Special_Group SG=new Special_Group(driver);
	  SG.add_Special_Group();
	  SG.policy_Name("Vertical Innovation Joya Offer 2026");
	  SG.Remarks("test");
	  SG.Start_Date("");
	  SG.End_Date("2026-12-31");
	  SG.Territory_add(true,null,null);
	  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
	  SG.SubmitBtn();
	  Assert.assertTrue(SG.StartDateErrorDisplay(), "Field isnot saved.");
  }
  
  @Test(priority=4)
  public void click_blank_EndDate_other_field_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
	  Special_Group SG=new Special_Group(driver);
	  SG.add_Special_Group();
	  SG.policy_Name("Vertical Innovation Joya Offer 2026");
	  SG.Remarks("test");
	  SG.Start_Date("2026-01-01");
	  SG.End_Date("");
	  SG.Territory_add(true,null,null);
	  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
	  SG.SubmitBtn();
	  Assert.assertTrue(SG.EndDateErrorDisplay(), "Field isnot filled.");
  }
	
  @Test(priority=5)
  public void click_blank_uncheck_territory_other_field_proper_data() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
	  Special_Group SG=new Special_Group(driver);
	  SG.add_Special_Group();
	  SG.policy_Name("Vertical Innovation Joya Offer 2026");
	  SG.Remarks("test");
	  SG.Start_Date("2026-01-01");
	  SG.End_Date("2026-12-31");
	  SG.Territory_add(false,null,null);
	  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
	  SG.SubmitBtn();
	  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot saved.");
  }
	
	  @Test(priority=6)
	  public void click_blank_outletGroup_territory_other_field_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.add_Special_Group();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(false,null,null);
		  SG.outlet_Group("","");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot saved.");
	  }
	  
	  @Test(priority=7)
	  public void click_all_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.add_Special_Group();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(true,"Rangpur Sales Office","Kurigram");
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot saved.");
	  }
	  
	  @Test(priority=8)
	  public void click_view_special_group() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.ViewBtn();
	
	  }
	  
	  @Test(priority=9)
	  public void click_edit_blank_policyname_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(true,null,null);
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.policyErrorDisplay(), "Field isnot saved.");
	  }
	  
	  @Test(priority=10)
	  public void click_edit_blank_remarks_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(true,null,null);
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot saved.");
	  }
	
	  @Test(priority=11)
	  public void click_edit_blank_StartDate_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(true,null,null);
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.StartDateErrorDisplay(), "Field isnot filled.");
	  }
	
	  @Test(priority=12)
	  public void click_edit_blank_EndDate_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("");
		  SG.Territory_add(true,null,null);
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.EndDateErrorDisplay(), "Field isnot filled.");
	  }
	  
	  @Test(priority=13)
	  public void click_edit_blank_territory_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(false,null,null);
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot filled.");
	  }
  
	  
	  @Test(priority=14)
	  public void click_edit_blank_outletGroup_other_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(false,null,null);
		  SG.outlet_Group("","");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot filled.");
	  }
	
	  @Test(priority=15)
	  public void click_edit_all_field_with_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.EditBtn();
		  SG.policy_Name("Vertical Innovation Joya Offer 2026");
		  SG.Remarks("test");
		  SG.Start_Date("2026-01-01");
		  SG.End_Date("2026-12-31");
		  SG.Territory_add(true,"Rangpur Sales Office","Kurigram");
		  SG.outlet_Group("B K INTERNATIONAL","Bidynondo Foundation");
		  SG.SubmitBtn();
		  Assert.assertTrue(SG.is_saved_successfull(), "Field isnot filled.");
	  }
	  
	  @Test(priority=16)
	  public void click_delete_special_group() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/special_groups/");
		  Special_Group SG=new Special_Group(driver);
		  SG.DeleteBtn(true);
		  
		  Assert.assertTrue(SG.is_delete_successfull(), "Delete not working.");
		  
	  }
}


