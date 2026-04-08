package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Market;

public class MarketTestCase extends BaseTest{
  @Test(priority=1)
  public void click_all_field_valid() throws InterruptedException {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.Add_Market();
	  market.Name("Sobujbag");
	  market.Address("dhaka");
	  market.Location_Type("Rural");
	  market.selectThana("Dhanmondi");
	  market.select_Office("Dhaka West Sales Office");
	  market.select_Territory("Adabor (Dip Kumar Mondal)");
	  market.is_active(true);
	  market.Save_Btn();
	  
	  Assert.assertTrue(market.isSaved_successfully(), "market not saved.");
  }
  
  @Test(priority=2)
  public void fill_name_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.Name("jamgora");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=3)
  public void fill_location_type_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.Location_Type("Rural");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=4)
  public void fill_district_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.District("DHAKA");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=5)
  public void fill_thana_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.District("DHAKA");
	  market.Thana("Dhanmondi");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=6)
  public void fill_office_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.select_Office("Dhaka West Sales Office");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=7)
  public void fill_territory_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.select_Office("Dhaka West Sales Office");
	  market.select_Territory("Adabor (Dip Kumar Mondal)");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
  
  @Test(priority=8)
  public void fill_all_field_search_reset() {
	  driver.get("http://202.126.123.157/esales_live/admin/markets/");
	  Market market=new Market(driver);
	  market.Name("Sobujbag");
	  market.Location_Type("Rural");
	  market.District("DHAKA");
	  market.Thana("Dhanmondi");
	  market.select_Office("Dhaka West Sales Office");
	  market.select_Territory("Adabor (Dip Kumar Mondal)");
	  market.Search_Btn();
	  market.Reset_Btn();
	  
  }
}
