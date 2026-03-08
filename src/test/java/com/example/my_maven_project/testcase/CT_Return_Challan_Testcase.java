package com.example.my_maven_project.testcase;

import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.CT_Return_Challan;

public class CT_Return_Challan_Testcase extends BaseTest{
	
  @Test(priority=1)
  public void click_Valid_challanNoFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Challan_No("CTRCH133866");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=2)
  public void click_Valid_StatusFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Status("Received");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=3)
  public void click_Valid_Date_FromFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Date_From("26-01-2025");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=4)
  public void click_Valid_Date_ToFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Date_To("31-01-2025");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=5)
  public void click_Valid_InventoryStatusFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Inventory_Status("Sound");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=6)
  public void click_Valid_Sender_StoreFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Sender_Store("Chittagong Area Store");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=7)
  public void click_Valid_SAP_StatusFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.SAP_Status("SAP Error");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
  @Test(priority=8)
  public void click_Valid_AllFilter() {
	  driver.get("http://202.126.123.157/esales_live/admin/ct_return_challans");
	  CT_Return_Challan CRC=new CT_Return_Challan(driver);
	  CRC.Challan_No("CTRCH133866");
	  CRC.Status("Received");
	  CRC.Date_From("26-01-2025");
	  CRC.Date_To("31-01-2025");
	  CRC.Inventory_Status("Sound");
	  CRC.Sender_Store("Chittagong Area Store");
	  CRC.SAP_Status("Success");
	  
	  CRC.Search();
	  CRC.Reset();
  }
  
}
