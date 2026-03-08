package com.example.my_maven_project.testcase;

import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Return_Challan_SO_ASO;

public class Return_Challan_SO_ASO_Testcase extends BaseTest{
	
  @Test(priority=1)
  public void click_valid_Area_officeFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.AreaOffice("Dhaka West Sales Office");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=2)
  public void click_valid_SAPStatusFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.SAP_Status("Success");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=3)
  public void click_valid_ChallanFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.Challan_No("RCHDM145242");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=4)
  public void click_valid_StatusFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.Status("Received");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=5)
  public void click_valid_From_DateFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.Date_From("13-01-2026");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=6)
  public void click_valid_To_DateFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.Date_To("13-01-2026");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=7)
  public void click_valid_AllFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.AreaOffice("Dhaka West Sales Office");
	  RCS.SAP_Status("Success");
	  RCS.Challan_No("RCHDM145242");
	  RCS.Status("Received");
	  RCS.Date_From("13-01-2026");
	  RCS.Date_To("13-01-2026");
	  
	  RCS.Search();
	  RCS.Reset();
  }
  
  @Test(priority=8)
  public void click_view_AllFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/return_challans_to_aso");
	  Return_Challan_SO_ASO RCS=new Return_Challan_SO_ASO(driver);
	  RCS.View();
  }
  
}
