package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Variant_List;

public class Variant_List_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_variant_blank() {
	  
	  driver.get("http://202.126.123.157/esales_live/admin/variants/");
	  Variant_List VL=new Variant_List(driver);
	  VL.click_Variant();
	  VL.add_Variant();
	  VL.variant_Name("");
	  VL.SubmitBtn();
	  
	  Assert.assertTrue(VL.VnameErrorDisplay(), "Field isn't filled.");
  }
	
	  @Test(priority=2)
	  public void click_variant_exist() {
		  
		  driver.get("http://202.126.123.157/esales_live/admin/variants/");
		  Variant_List VL=new Variant_List(driver);
		  VL.click_Variant();
		  VL.add_Variant();
		  VL.variant_Name("Variant 129");
		  VL.SubmitBtn();
		  
		  Assert.assertTrue(VL.VnameErrorDisplayExist(), "Variant name isn't exist.");
	  }
	  
	  @Test(priority=3)
	  public void click_variant_properData() {
		  
		  driver.get("http://202.126.123.157/esales_live/admin/variants/");
		  Variant_List VL=new Variant_List(driver);
		  VL.click_Variant();
		  VL.add_Variant();
		  VL.variant_Name("Variant_129");
		  VL.SubmitBtn();
		  
		  Assert.assertTrue(VL.Vnam_is_successfull(), "Variant name isn't saved.");
	  }
	
	  @Test(priority=4)
	  public void click_variant_Edit_blank_Data() {
		  
		  driver.get("http://202.126.123.157/esales_live/admin/variants/");
		  Variant_List VL=new Variant_List(driver);
		  VL.click_Variant();
		  VL.click_edit();
		  VL.variant_Name("");
		  VL.click_update();
		  
		  Assert.assertTrue(VL.VnameErrorDisplay(), "Field isn't filled.");
	  }
	  
	  @Test(priority=5)
	  public void click_variant_Edit_Proper_Data() {
		  
		  driver.get("http://202.126.123.157/esales_live/admin/variants/");
		  Variant_List VL=new Variant_List(driver);
		  VL.click_Variant();
		  VL.click_edit();
		  VL.variant_Name("Variant_129_1");
		  VL.click_update();
		  
		  Assert.assertTrue(VL.Vnam_is_successfull(), "variant name is not saved successfully.");
	  }
	  
	  @Test(priority=6)
	  public void click_variant_Delete_Data() {
		  
		  driver.get("http://202.126.123.157/esales_live/admin/variants/");
		  Variant_List VL=new Variant_List(driver);
		  VL.click_Variant();
		  VL.Delete_Btn(true);
		 
		  
		  Assert.assertTrue(VL.VnameDelete_successfull(), "variant name is not delete successfully.");
	  }
	
	
}
