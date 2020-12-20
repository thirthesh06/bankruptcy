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
import com.a2j.pages.RpFastTrackPage;

import utility.Constant;


public class RpFastTrackMyCasesTest {
	LoginPage loginPage;
	WebDriver driver;
	// Dashboard_ProfilePage dashbrdPage;
	// CaseListPage caselistpage;
	// RpPage rppage;
	//RpMyCasesPage rpmycasespage;
	RpFastTrackPage rpfasttrackcasespage;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("caseid", "INSOLVO_C1111");

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
	}//tr[1]//td[3]//input[1]

	@Test(dependsOnMethods = { "verifyloginuserTextBox", "verifyloginpasswordTextBox1" })
	public void loginTest() {

		rpfasttrackcasespage = loginPage.rpftlogin("georgemichaellpu@gmail.com", "12jJ12@@@@");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void mycases() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		rpfasttrackcasespage.mycasesclick();

	}

	
	  @Test(enabled = true, dependsOnMethods = { "mycases" })
	  public void caseid() throws InterruptedException {
	  
		  rpfasttrackcasespage.clickByCaseId(testData.get("caseid"));
	  }
	 

	@Test(dependsOnMethods = { "caseid" })
	public void setup() {

		rpfasttrackcasespage.setup();
	}

	@Test(dependsOnMethods = { "setup" })
	public void caseprofile() {

		rpfasttrackcasespage.casemode();
	}
	@Test(dependsOnMethods = { "caseprofile" })
	public void saveprofile() {

		rpfasttrackcasespage.saveprofile();
	}
		
	@Test(dependsOnMethods = { "saveprofile" })
	public void checkbox() throws InterruptedException {

		rpfasttrackcasespage.checkboxverify();
	}
	
	/*
	 * @Test(dependsOnMethods = { "checkbox" }) public void checkbox1() throws
	 * InterruptedException {
	 * 
	 * WebElement e = null; rpmycasespage.checkboxverify(e); }
	 */
	 

	
	// usermanagemnt
	@Test(dependsOnMethods = { "checkbox" })
	public void nextbtn() {

		rpfasttrackcasespage.nextbutton();
	}
	

	
	
	@Test(dependsOnMethods = { "nextbtn" })
	public void vdrnextbtn() throws InterruptedException {
	

		rpfasttrackcasespage.vdrnext();
	}
	
	// user acces mamnagement 4 step
	@Test(dependsOnMethods = { "vdrnextbtn" })
	public void save() {
		rpfasttrackcasespage.save();
	}
	
	@Test(dependsOnMethods = { "save" })
	public void launchvdr() {
		rpfasttrackcasespage.vdr();
	}
}
