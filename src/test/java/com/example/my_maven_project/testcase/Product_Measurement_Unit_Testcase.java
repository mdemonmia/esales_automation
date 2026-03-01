package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Product_Measurement_Unit;

public class Product_Measurement_Unit_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_blank_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/measurement_units");
	  Product_Measurement_Unit PMU=new Product_Measurement_Unit(driver);
	  PMU.click_Measurement_Unit();
	  PMU.add_measurement();
	  PMU.Measuement_Name("");
	  PMU.is_Active_Name();
	  PMU.saveBtn();
	  
	  Assert.assertTrue(PMU.measurementErrorDisplay(), "Field isn't filled.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=2)
  public void click_Measurement_exist_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/measurement_units");
	  Product_Measurement_Unit PMU=new Product_Measurement_Unit(driver);
	  PMU.click_Measurement_Unit();
	  PMU.add_measurement();
	  PMU.Measuement_Name("Box_2");
	  PMU.is_Active_Name();
	  PMU.saveBtn();
	  
	  Assert.assertTrue(PMU.measurement_exist_ErrorDisplay(), "Unit name isn't exist.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=3)
  public void click_Measurement_proper_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/measurement_units");
	  Product_Measurement_Unit PMU=new Product_Measurement_Unit(driver);
	  PMU.click_Measurement_Unit();
	  PMU.add_measurement();
	  PMU.Measuement_Name("Box_5");
	  PMU.is_Active_Name();
	  PMU.saveBtn();
	  
	  Assert.assertTrue(PMU.measurement_is_Successfully(), "Measurement unit has not been saved.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=4)
  public void click_Measurement_edit_blank_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/measurement_units");
	  Product_Measurement_Unit PMU=new Product_Measurement_Unit(driver);
	  PMU.click_Measurement_Unit();
	  PMU.edit_measure();
	  PMU.Measuement_Name("");
	  PMU.is_Active_Name();
	  PMU.saveBtn();
	  
	  Assert.assertTrue(PMU.measurementErrorDisplay(), "Measurement unit has not been saved.");
	  Thread.sleep(5000);
  }
  
  @Test(priority=5)
  public void click_Measurement_edit_create_name() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/measurement_units");
	  Product_Measurement_Unit PMU=new Product_Measurement_Unit(driver);
	  PMU.click_Measurement_Unit();
	  PMU.edit_measure();
	  PMU.Measuement_Name("Box_6");
	  PMU.is_Active_Name();
	  PMU.saveBtn();
	  
	  Assert.assertTrue(PMU.measurement_is_Successfully(), "Measurement unit has not been saved..");
	  Thread.sleep(5000);
  }
  
  
}
