package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.Dashboard_ProfilePage;
import com.a2j.pages.LoginPage;



import jdk.internal.jline.internal.Log;
import utility.Constant;
import utility.loggers;


public class EditProfileTest extends TestBase {
	/*
	 * ExtentReports eReport; ExtentTest eTest;
	 */
	
	LoginPage loginPage;
	WebDriver driver;
	Dashboard_ProfilePage dashbrdPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	static Map<String, String> testData;

	static {
		testData = new HashMap<>();
		testData.put("fcname", "thir");
		testData.put("fccompany", "abc");
		testData.put("fcid", "785");
		testData.put("fcnature", "IT");
		testData.put("state", "Goa");
		testData.put("fcaddress", "test");
		testData.put("website", "test");
		testData.put("fcemail", "test");
	}

	@BeforeClass
	public void init() {
		driver = TestBase.getDriver("chrome");
		loginPage = new LoginPage(driver);
		driver.get(Constant.url);
		//eReport = utility.ExtentManager.getInstance();
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

		dashbrdPage = loginPage.login("panfc@123", "Test@123");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void myprofile() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		dashbrdPage.myprofileclick();
		// scroll to edit button/
		/*
		 * Action action = new Action(driver);
		 * actiion.moveToElelment(.....).build().perform();
		 * 
		 * 
		 * JavaScriptE
		 * 
		 * js.
		 */

		// dashbrdPage.edit_profile_btn();
	}

	@Test(dependsOnMethods = { "myprofile" })
	public void edit_btn() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		dashbrdPage.edit_profile_btn();
		// dashbrdPage.edit_profile_btn();
	}

	@Test(dependsOnMethods = { "edit_btn" })
	public void fcname() throws InterruptedException {
		dashbrdPage.FinancialCreditorName("thir");
	}

	@SuppressWarnings("restriction")
	@Test(dependsOnMethods = { "fcname" })
	public void editTest() throws InterruptedException {
		// edit buton click
		
		dashbrdPage.FinancialCreditorName(testData.get("fcname"));
		//loggers.logges("hi");
		//Log.info(LogStatus.PASS);
		//eTest.log(LogStatus.INFO, "pass"+testData.get("fcname"));
		// save button click
	}

	// finicaial company
	@Test(dependsOnMethods = { "fcname" })
	public void fccompany() throws InterruptedException {
		dashbrdPage.FinancialCompanyName(testData.get("fccompany"));

	}

	// finicaial id
	@Test(dependsOnMethods = { "fccompany" })
	public void fcid() throws InterruptedException {
		dashbrdPage.FinancialId(testData.get("fcid"));
	}

	// finicaial nature of business
	@Test(dependsOnMethods = { "fcid" })
	public void fcnatureofbusiness() throws InterruptedException {
		dashbrdPage.fcnatureofbusiness(testData.get("fcnature"));
	}

	// email
	@Test(dependsOnMethods = { "fcid" })
	public void fcemail() throws InterruptedException {
		dashbrdPage.fcnatureofbusiness(testData.get("fcemail"));
	}

	// finicial state
	@Test(dependsOnMethods = { "fcid" })
	public void fcstate() throws InterruptedException {
		dashbrdPage.Financialstate(testData.get("state"));
	}

	// fc address
	@Test(dependsOnMethods = { "fcstate" })
	public void fcaddress() throws InterruptedException {
		dashbrdPage.address(testData.get("fcaddress"));
	}

	// fcwebsoite
	@Test(dependsOnMethods = { "fcaddress" })
	public void fcwebsite() throws InterruptedException {
		dashbrdPage.website(testData.get("website"));
	}
//save deytaisls
	@Test(dependsOnMethods = { "fcwebsite" })
	public void saveeditdetails() {
		dashbrdPage.saveedit();
	}

	@Test(dependsOnMethods = { "saveeditdetails" })
	public void verifyEditedData() {
		Assert.assertEquals(dashbrdPage.getFormDataValues(), testData.values());
	}

	@Test(dependsOnMethods = { "saveeditdetails" })
	public void teardown() {
		//eReport.flush();
		driver.quit();
	}

}
