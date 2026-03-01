package com.example.my_maven_project.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.my_maven_project.BaseTest;
import com.example.my_maven_project.Login_Page;

public class Login_Page_Testcase extends BaseTest{
 
//	@Test(priority=1)
//  public void click_all_Blankfield() {
//		driver.get("http://202.126.123.157/esales_live/admin/login");
//		Login_Page LP=new Login_Page(driver);
//		LP.click_Username("");
//		LP.click_Password("");
//		LP.click_LoginBtn();
//		
//		Assert.assertTrue(LP.usernameErrorDisplay(), "Please fill out this field.");
//  }
//	
//	@Test(priority=2)
//	  public void click_password_Blank() {
//			driver.get("http://202.126.123.157/esales_live/admin/login");
//			Login_Page LP=new Login_Page(driver);
//			LP.click_Username("admin");
//			LP.click_Password("");
//			LP.click_LoginBtn();
//			
//			Assert.assertTrue(LP.passwordErrorDisplay(), "Please fill out this field.");
//	  }
//	
//	@Test(priority=3)
//	  public void click_Username_Blank() {
//			driver.get("http://202.126.123.157/esales_live/admin/login");
//			Login_Page LP=new Login_Page(driver);
//			LP.click_Username("");
//			LP.click_Password("123456");
//			LP.click_LoginBtn();
//			
//			Assert.assertTrue(LP.usernameErrorDisplay(), "Please fill out this field.");
//	  }
//	
//	@Test(priority=4)
//	  public void click_Username_Wrong() {
//			driver.get("http://202.126.123.157/esales_live/admin/login");
//			Login_Page LP=new Login_Page(driver);
//			LP.click_Username("emon");
//			LP.click_Password("");
//			LP.click_LoginBtn();
//			
//			Assert.assertTrue(LP.passwordErrorDisplay(), "Please fill out this field.");
//	  }
//	@Test(priority=5)
//	  public void click_password_Wrong() {
//			driver.get("http://202.126.123.157/esales_live/admin/login");
//			Login_Page LP=new Login_Page(driver);
//			LP.click_Username("");
//			LP.click_Password("123586");
//			LP.click_LoginBtn();
//			
//			Assert.assertTrue(LP.usernameErrorDisplay(), "Please fill out this field.");
//	  }
//	
//	@Test(priority=6)
//	  public void click_Username_Password_Wrong() {
//			driver.get("http://202.126.123.157/esales_live/admin/login");
//			Login_Page LP=new Login_Page(driver);
//			LP.click_Username("emon");
//			LP.click_Password("123586");
//			LP.click_LoginBtn();
//			
//			Assert.assertTrue(LP.LoginErrorDisplay(), "Incorrect Email/Username or Password.");
//	  }
	
	@Test(priority=7)
	  public void click_Right_Username_Password() {
			driver.get("http://202.126.123.157/esales_live/admin/login");
			Login_Page LP=new Login_Page(driver);
			LP.click_Username("admin");
			LP.click_Password("123456");
			LP.click_LoginBtn();
			
			
	  }
	
}
