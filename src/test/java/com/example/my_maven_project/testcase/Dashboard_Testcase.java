package com.example.my_maven_project.testcase;

import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Dashboard;

public class Dashboard_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_Blank_Region() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_report_live/admin/dashboards");
	  Dashboard dashboard=new Dashboard(driver);
	  dashboard.click_Dashboard();
	  dashboard.click_Region("");
  }
  
  @Test(priority=2)
  public void click_Region() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_report_live/admin/dashboards");
	  Dashboard dashboard=new Dashboard(driver);
	  dashboard.click_Dashboard();
	  dashboard.click_Region("Region North");
  }
  
  
  @Test(priority=3)
  public void click_Area_Office() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_report_live/admin/dashboards");
	  Dashboard dashboard=new Dashboard(driver);
	  dashboard.click_Dashboard();
	  dashboard.click_Area("Rangpur Sales Office");
  }
  

  @Test(priority=4)
  public void click_Source() {
	  driver.get("http://202.126.123.157/esales_report_live/admin/dashboards");
	  Dashboard dashboard=new Dashboard(driver);
	  dashboard.click_Dashboard();
	  dashboard.Source("SMC");
  }
  

  @Test(priority=5)
  public void click_All_Dashboard_Item() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_report_live/admin/dashboards");
	  Dashboard dashboard=new Dashboard(driver);
	  dashboard.click_Dashboard();
	  dashboard.click_Region("Region North");
	  dashboard.click_Area("Rangpur Sales Office");
	  dashboard.Source("SMC");
  }
  
}
