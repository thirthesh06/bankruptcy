package com.a2j.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.Dashboard_ProfilePage;
import com.a2j.pages.LoginPage;

import utility.Constant;



public class Dashboard_ProfileTest extends Dashboard_ProfilePage {

	LoginPage loginPage;
	WebDriver driver;
	Dashboard_ProfilePage dashbrdPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	@BeforeClass
	public void init() {
		driver = TestBase.getDriver("chrome");
		loginPage = new LoginPage(driver);
		driver.get(Constant.url);
	}

	@Test()
	public void loginbutton() {
		loginPage.Loginlink();
		//homePage = loginPage.login("thirthesh06@gmail.com", "thirthesh@12");
	}

	@Test(dependsOnMethods = { "loginbutton"})
	public void verifyloginuserTextBox() throws InterruptedException {
		Thread.sleep(3000);
		//loginPage.clickOnLogin();
		// ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		String actualValue = loginPage.getUserNameTxtBoxPlaceHolder();
		Assert.assertEquals(actualValue, EXPECTED_USR_PLC_HOL);
		Thread.sleep(2000);

	}

	// PASSWORD VERIFICATION

	@Test
	public void verifyloginpasswordTextBox1() throws InterruptedException {
		//loginPage.clickOnLogin();
		String actualValue = loginPage.getPasswordTxtBoxPlaceHolder();
		try {
			Assert.assertEquals(actualValue, EXPECTED_PSW_PLC_HOL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = { "verifyloginuserTextBox" ,"verifyloginpasswordTextBox1" })
	public void loginTest() {

		dashbrdPage = loginPage.login("panfc@123", "Test@123");
		
	}


	@Test(dependsOnMethods = {"loginTest"})
	  public void myprofile() throws InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  dashbrdPage.myprofileclick();
		  //scroll to edit button/
		  /*
		   * Action action = new Action(driver);
		   * actiion.moveToElelment(.....).build().perform();
		   * 
		   * 
		   * JavaScriptE
		   * 
		   * js.
		   */
		
		  //dashbrdPage.edit_profile_btn(); 
		  }
	
	  @Test(dependsOnMethods= {"myprofile"})
	  public void edit_btn() throws
	  InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  dashbrdPage.edit_profile_btn();
		  //dashbrdPage.edit_profile_btn(); 
		  }
	  
	  
	  
	/*
	 * // finacialcreditorname
	 * 
	 * @Test(dependsOnMethods = { "edit_btn" }) public void fcname() throws
	 * InterruptedException { dashbrdPage.FinancialCreditorName("thir"); }
	 * //finicaial company
	 * 
	 * @Test(dependsOnMethods = { "fcname" }) public void fccompany() throws
	 * InterruptedException { dashbrdPage.FinancialCompanyName("thir"); }
	 * 
	 * //finicaial id
	 * 
	 * @Test(dependsOnMethods = { "fccompany" }) public void fcid() throws
	 * InterruptedException { dashbrdPage.FinancialId("thir"); }
	 * 
	 * //fc email
	 * 
	 * @Test(dependsOnMethods = { "fcid" }) public void fcemail() throws
	 * InterruptedException { dashbrdPage.Financialemail("thir"); }
	 * 
	 * 
	 * 
	 * //finicaial nature of business
	 * 
	 * @Test(dependsOnMethods = { "fcid" }) public void fcnatureofbusiness() throws
	 * InterruptedException { dashbrdPage.FinancialCreditorName("thir"); }
	 * //finicial state
	 * 
	 * @Test(dependsOnMethods = { "fcnatureofbusiness" }) public void fcstate()
	 * throws InterruptedException { dashbrdPage.FinancialCreditorName("thir"); }
	 * //fc address
	 * 
	 * @Test(dependsOnMethods = { "fcnatureofbusiness" }) public void fcaddress()
	 * throws InterruptedException { dashbrdPage.FinancialCreditorName("thir"); }
	 * 
	 * //fcwebsite
	 * 
	 * @Test(dependsOnMethods = { "fcaddress" }) public void fcwebsite() throws
	 * InterruptedException { dashbrdPage.FinancialCreditorName("thir"); }
	 * 
	 */
	  @Test(dependsOnMethods= {"edit_btn"})
		public void teardown() {
			driver.quit();
		}
}
