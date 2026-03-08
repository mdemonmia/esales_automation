package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.NCP_Replacement_Settings;

public class NCP_Replacement_Settings_Testcase extends BaseTest{
  @Test(priority=1)
  public void click_null_product() {
	  driver.get("http://202.126.123.157/esales_live/admin/ncp_return_products/");
	  NCP_Replacement_Settings NRS=new NCP_Replacement_Settings(driver);
	  NRS.Add_New_NCP();
	  NRS.Products(null);
	  NRS.Replace_product(null);
	  NRS.is_Active();
	  NRS.SubmitBtn();
	  
	  Assert.assertTrue(NRS.ProductErrorDisplay(), "Field isnot filled.");
  }
	
	 @Test(priority=2)
	  public void click_blank_product() {
		  driver.get("http://202.126.123.157/esales_live/admin/ncp_return_products/");
		  NCP_Replacement_Settings NRS=new NCP_Replacement_Settings(driver);
		  NRS.Add_New_NCP();
		  NRS.Products("");
		  NRS.Replace_product(null);
		  NRS.is_Active();
		  NRS.SubmitBtn();
		  
		  Assert.assertTrue(NRS.ProductErrorDisplay(), "Field isnot filled.");
	  }
	
	
	 @Test(priority=3)
	  public void click_Add_Replace_Productwith_Valid_Data() {
		  driver.get("http://202.126.123.157/esales_live/admin/ncp_return_products/");
		  NCP_Replacement_Settings NRS=new NCP_Replacement_Settings(driver);
		  NRS.Add_New_NCP();
		  NRS.Products("Product 27");
		  NRS.Replace_product("Product 20");
		  NRS.is_Active();
		  NRS.SubmitBtn();
		  
		  Assert.assertTrue(NRS.is_saved_successfull(), "Field isnot saved.");
	  }
	
}
