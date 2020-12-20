package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.LoginPage;
import com.a2j.pages.RpPage;



public class RpTest {

	LoginPage loginPage;
	WebDriver driver;
	// Dashboard_ProfilePage dashbrdPage;
	// CaseListPage caselistpage;
	RpPage rppage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("caseid", "Temp_INSOLVO_TESTOC");
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
		// homePage = loginPage.login("thirthesh06@gmail.com", "thirthesh@12");
	}

	@Test(dependsOnMethods = { "loginbutton" })
	public void verifyloginuserTextBox() throws InterruptedException {
		Thread.sleep(3000);
		// loginPage.clickOnLogin();
		// ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		String actualValue = loginPage.getUserNameTxtBoxPlaceHolder();
		Assert.assertEquals(actualValue, EXPECTED_USR_PLC_HOL);
		Thread.sleep(2000);

	}

	// PASSWORD VERIFICATION

	@Test
	public void verifyloginpasswordTextBox1() throws InterruptedException {
		// loginPage.clickOnLogin();
		String actualValue = loginPage.getPasswordTxtBoxPlaceHolder();
		try {
			Assert.assertEquals(actualValue, EXPECTED_PSW_PLC_HOL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = { "verifyloginuserTextBox", "verifyloginpasswordTextBox1" })
	public void loginTest() {

		rppage = loginPage.login3("georgemichaellpu@gmail.com", "12jJ12@@@@");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void caserequests() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		rppage.caserequestsclick();

	}
	
	@Test(enabled = true, dependsOnMethods = { "caserequests" })
	  public void caseid() throws InterruptedException {
	  
		rppage.clickByCaseId(testData.get("caseid"));
		//rppage.clickByCaseId(testData.get(caseId));
	  }

	@Test(dependsOnMethods = { "caseid" })
	public void accept() throws InterruptedException {
		Thread.sleep(2000);
		rppage.accept();
	}
	@Test(dependsOnMethods = { "accept" })
	public void downlaoadfrom2() throws InterruptedException {
		Thread.sleep(2000);
		rppage.downform2();
	}
	/*
	 * @Test(dependsOnMethods = { "downlaoadfrom2" }) public void uploadfrom2()
	 * throws InterruptedException { Thread.sleep(2000); rppage.uploadform2(); }
	 */
	
	@Test(dependsOnMethods = { "downlaoadfrom2" })
	public void teardown() {
		driver.quit();
	}
}
