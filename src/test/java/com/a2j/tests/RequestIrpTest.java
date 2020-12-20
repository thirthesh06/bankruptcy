package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.LoginPage;
import com.a2j.pages.RequestIrpPage;

import utility.Constant;

public class RequestIrpTest  {


	LoginPage loginPage;
	WebDriver driver;
	//Dashboard_ProfilePage dashbrdPage;
	RequestIrpPage requestirppage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	
	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("cin", "Test123r");
		testData.put("coprdeb", "fc12345678fr");
		testData.put("compnaytoken", "efefefr");
		testData.put("state", "karnataka");
		testData.put("rpname", "Tejas");
		testData.put("regnomb", "IBBI/IPA-001/IP-P00004/2016-17/10012");
	    testData.put("staterp", "");
	}

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

		requestirppage = loginPage.login1("panfc@123", "Test@123");
		
	}


	@Test(dependsOnMethods = {"loginTest"})
	  public void irp() throws InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  requestirppage.requestirpclick();
		  
		  }
	
	@Test(dependsOnMethods = {"irp"})
	  public void cin() throws InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  requestirppage.cin(testData.get("cin"));;
		  
		  }
	 @Test(dependsOnMethods = {"cin"})
	 public void corporatedebator() {
		 
		 requestirppage.corpdeb(testData.get("coprdeb"));
	  }
	  
	 @Test(dependsOnMethods = {"corporatedebator"})
	 public void campnytoken() {
	   requestirppage.campnytoken(testData.get("compnaytoken"));
	  }
	  
	  @Test(dependsOnMethods = {"campnytoken"})
	  public void state() {
	  requestirppage.state(testData.get("state"));
	  }
	
	  @Test(dependsOnMethods = {"state"})
	  public void requestirp() {
	  requestirppage.requestirp();
	  }
	  
	
	  @Test(dependsOnMethods = {"requestirp"}) 
	  public void namerp() {
	  requestirppage.namerp(testData.get("rpname")); }
	 
	  
	
	/*
	 * @Test(dependsOnMethods = {"requestirp"}) public void RegistrationNo() {
	 * requestirppage.RegistrationNo(testData.get("regnomb")); }
	 */
	  
	/*
	 * @Test(dependsOnMethods = {"RegistrationNo"})
	 *  public void staterp() {
	 * requestirppage.staterp(testData.get("staterp")); }
	 */
	  
	  @Test(dependsOnMethods= {"namerp"})
	  public void search() {
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  requestirppage.search();
	  }
	  
	  @Test(dependsOnMethods= {"search"})
	  public void reqbtn2() throws InterruptedException {
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  requestirppage.reqbtn();
	  }
	  @Test(dependsOnMethods= {"reqbtn2"})
	  public void teardown() {
		  driver.quit();
	  }
}
