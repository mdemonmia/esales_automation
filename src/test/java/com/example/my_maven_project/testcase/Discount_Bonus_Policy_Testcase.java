package com.example.my_maven_project.testcase;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Discount_Bonus_Policy;

public class Discount_Bonus_Policy_Testcase extends BaseTest{
//  @Test(priority=1)
//  public void click_Blank_PolicyName_other_field_proper_data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//	  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//	  DBP.Add_Discount_Policy();
//	  DBP.Policy_Name("");
//	  DBP.Remarks("test");
//	  DBP.StartDate("01-03-2026");
//	  DBP.EndDate("31-03-2026");
//	  DBP.Policy_Applicable("No");
//	  DBP.Capping_Policy("Yes");
//	  DBP.Target_Quantity_Base("1000");
//	  DBP.Percentage("75");
//	  DBP.Discount_Policy_Type("Discount");
//	  DBP.Create_For("SO","SR");
//	  DBP.Product("Product 353","Product 354");
//	  DBP.Save_Btn();
//	  Assert.assertTrue(DBP.PolicyErrorDisplay(), "Field isnot filled.");
//  }
//  
//  @Test(priority=2)
//  public void click_Blank_Remarks_other_field_proper_data() {
//	  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//	  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//	  DBP.Add_Discount_Policy();
//	  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//	  DBP.Remarks("");
//	  DBP.StartDate("01-03-2026");
//	  DBP.EndDate("31-03-2026");
//	  DBP.Policy_Applicable("No");
//	  DBP.Capping_Policy("Yes");
//	  DBP.Target_Quantity_Base("1000");
//	  DBP.Percentage("75");
//	  DBP.Discount_Policy_Type("Discount");
//	  DBP.Create_For("SO","SR");
//	  DBP.Product("Product 353","Product 354");
//	  DBP.Save_Btn();
//	  
//  }
//	
//	  @Test(priority=3)
//	  public void click_Blank_Capping_Policy_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("0103-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("");
//		  DBP.Target_Quantity_Base("1000");
//		  DBP.Percentage("75");
//		  DBP.Discount_Policy_Type("Discount");
//		  DBP.Create_For("SO","SR");
//		  DBP.Product("Product 353","Product 354");
//		  DBP.Save_Btn();
//		  
//		 // DBP.Alerthandle();
//		  Assert.assertTrue(DBP.StartDateErrorDisplay(), "Field isn't filled.");
//		  Thread.sleep(5000);
//	  }
//	
//	  @Test(priority=4)
//	  public void click_Blank_TargetQTY_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("0103-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("Yes");
//		  DBP.Target_Quantity_Base("");
//		  DBP.Percentage("75");
//		  DBP.Discount_Policy_Type("Discount");
//		  DBP.Create_For("SO","SR");
//		  DBP.Product("Product 353","Product 354");
//		  DBP.Save_Btn();
//		  
//		 // DBP.Alerthandle();
//		  Assert.assertTrue(DBP.StartDateErrorDisplay(), "Field isn't filled.");
//		  Thread.sleep(5000);
//	  }
//	
//	  @Test(priority=5)
//	  public void click_Blank_Percentage_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("0103-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("Yes");
//		  DBP.Target_Quantity_Base("1000");
//		  DBP.Percentage("");
//		  DBP.Discount_Policy_Type("Discount");
//		  DBP.Create_For("SO","SR");
//		  DBP.Product("Product 353","Product 354");
//		  DBP.Save_Btn();
//		  
//		 // DBP.Alerthandle();
//		  Assert.assertTrue(DBP.StartDateErrorDisplay(), "Field isn't filled.");
//		
//	  }
//	
//	  @Test(priority=6)
//	  public void click_Blank_DiscountPolicyType_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("0103-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("Yes");
//		  DBP.Target_Quantity_Base("1000");
//		  DBP.Percentage("75");
//		  DBP.Discount_Policy_Type("");
//		  DBP.Create_For("SO","SR");
//		  DBP.Product("Product 353","Product 354");
//		  DBP.Save_Btn();
//		  
//		 // DBP.Alerthandle();
//		  Assert.assertTrue(DBP.StartDateErrorDisplay(), "Field isn't filled.");
//		
//	  }
//	  
//	  @Test(priority=7)
//	  public void click_Blank_CreateFor_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("01-03-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("Yes");
//		  DBP.Target_Quantity_Base("1000");
//		  DBP.Percentage("75");
//		  DBP.Discount_Policy_Type("Discount");
//		  DBP.Create_For("","");
//		  DBP.Product("Product 353","Product 354");
//		  DBP.Save_Btn();
//		  
//	  }
//	
//	  @Test(priority=8)
//	  public void click_Blank_Product_other_field_proper_data() throws InterruptedException {
//		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
//		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
//		  DBP.Add_Discount_Policy();
//		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
//		  DBP.Remarks("test");
//		  DBP.StartDate("01-03-2026");
//		  DBP.EndDate("31-03-2026");
//		  DBP.Policy_Applicable("No");
//		  DBP.Capping_Policy("Yes");
//		  DBP.Target_Quantity_Base("1000");
//		  DBP.Percentage("75");
//		  DBP.Discount_Policy_Type("Discount");
//		  DBP.Create_For("SO","SR");
//		  DBP.Product("","");
//		  DBP.Save_Btn();
//		  
//	  }
	
	  @Test(priority=9)
	  public void click_Blank_Product_other_field_proper_data() throws InterruptedException {
		  driver.get("http://202.126.123.157/esales_live/admin/discount_bonus_policies/");
		  Discount_Bonus_Policy DBP=new Discount_Bonus_Policy(driver);
		  DBP.Add_Discount_Policy();
		  DBP.Policy_Name("Product 353 & 354 Bonus Offer.");
		  DBP.Remarks("test");
		  DBP.StartDate("01-03-2026");
		  DBP.EndDate("31-03-2026");
		  DBP.Policy_Applicable("No");
		  DBP.Capping_Policy("Yes");
		  DBP.Target_Quantity_Base("1000");
		  DBP.Percentage("75");
		  DBP.Discount_Policy_Type("Discount");
		  DBP.Create_For("SO","SR");
		  DBP.Product("Product 353","Product 354");
		  DBP.Set();
//		  DBP.AddPolicyOptionFull("OnlyDiscount", new String[]{"SO","SR"},"10","PACK","2000","2","%");
		  
		  DBP.AddpolicyOptions(new String[]{"Only Discount"}, new String[]{"SO","SR"},new String[]{"10"},new String[]{"PACK"},new String[]{"2000"},new String[]{"2"},new String[]{"%"});
	  }
}
