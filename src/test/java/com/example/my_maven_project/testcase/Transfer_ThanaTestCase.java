package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Transfer_Thana;

public class Transfer_ThanaTestCase extends BaseTest{
//  @Test(priority=1)
//  public void all_fields_blank() {
//	  driver.get("http://202.126.123.157/esales_live/admin/thana_transfers");
//	  Transfer_Thana TT=new Transfer_Thana(driver);
//	  TT.selectOffice("");
//	  TT.selectTooffice("");
//	  TT.selectTerritory("");
//	  TT.selectToterritory("");
//	  TT.selectThana("");
//	  TT.saveBtn();
//	  
//	  Assert.assertTrue(TT.officeErrorDisplay(), "Item not selected.");
//  }
//  @Test(priority=2)
//  public void office_fields_blank_other_valid_field() throws InterruptedException {
//	  driver.get("http://202.126.123.157/esales_live/admin/thana_transfers");
//	  Transfer_Thana TT=new Transfer_Thana(driver);
//	  TT.selectOffice("Chattogram Sales Office");
//	  TT.selectTooffice("");
//	  Thread.sleep(5000);
//	  TT.selectTerritory("Amirabad");
//	  TT.selectToterritory("");
//	  Thread.sleep(5000);
//	  TT.selectThana("Chandanaish,Satkania");
//	  TT.saveBtn();
//	  
//	  Assert.assertTrue(TT.ToofficeErrorDisplay(), "Item not selected.");
//  }
  
  @Test(priority=3)
  public void all_fields_valid() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/thana_transfers");
	  Transfer_Thana TT=new Transfer_Thana(driver);
	  TT.selectOffice("Chattogram Sales Office");
	  TT.selectTooffice("Bogura Sales Office");
	  
	  TT.selectTerritory("Amirabad (Md. Masud Rana)");
	  TT.selectToterritory("Dupcachia (IA) (Md. Imran Ali )");
	
	  TT.selectThana("Chandanaish,Satkania");
	  TT.saveBtn();
	  
	  Assert.assertTrue(TT.is_saved_successfully(), "Item not selected.");
  }
}
