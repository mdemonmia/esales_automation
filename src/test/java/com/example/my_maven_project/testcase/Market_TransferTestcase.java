package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Market_Transfer;

public class Market_TransferTestcase extends BaseTest{
  @Test(priority=1)
  public void click_office_field_valid() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets_transfers");
	  Market_Transfer MT=new Market_Transfer(driver);
	  MT.Office("Dhaka West Sales Office");
	  MT.To_Office("Dhaka East Sales Office");
	  MT.Territory("Gulshan (Sohel Akram)");
	  MT.To_territory("Kamrangir Char (A.K.M. Omar Ali)");
	  MT.Thana("Tejgaon");
	  MT.Markets("BABLI,BOU BAZAR,LOVE ROAD");
	  MT.SaveBtn();
	  
	  Assert.assertTrue(MT.is_saved_successfully(), "Not saved.");
  }
}
