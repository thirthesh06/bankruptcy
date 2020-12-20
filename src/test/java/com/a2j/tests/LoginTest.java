package com.a2j.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.a2j.base.ExcelDataProvider;
import utility.Constant;
import com.a2j.base.TestBase;
import com.a2j.pages.Dashboard_ProfilePage;
import com.a2j.pages.LoginPage;

public class LoginTest extends LoginPage {
	LoginPage loginPage;
	WebDriver driver;
	Dashboard_ProfilePage homePage;
	ExtentHtmlReporter htmlReporter;
	
	  static ExtentReports extent; // helps to generate the logs in test report.
	  ExtentTest test;
	 
	// private static Logger logger = LoggerFactory(LoginTest.class);
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	static final String EXPECTED_LOGIN_BUTTON = "  ";
	static final String EXPECTED_LOGOL = "      ";

	@BeforeClass
	public void init() {
		driver = TestBase.getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		driver.get(Constant.url);
		// logger.info("Retrieved ");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//loginPage.Loginlink();
		/*
		 * String URL = driver.getCurrentUrl(); Assert.assertEquals(URL,
		 * "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/" );
		 */

	}

	/*
	 * @Test public void getstarted() { loginPage.clickonGetStarted(); }
	 * 
	 * @Test public void loginhere() throws InterruptedException {
	 * loginPage.Loginlink(); Thread.sleep(5000); }Fail
	 * 
	 * invocationCount = 10, threadPoolSize = 5
	 */
	@Test()
	public void loginbutton() throws InterruptedException {
		// Thread.sleep(2000);
		loginPage.Loginlink();
		// loggers.logges("hi hello ");
	}

	// USERNAME VERIFICATION

	@Test(dependsOnMethods = { "loginbutton" })
	public void verifyloginuserTextBox() throws InterruptedException {
		//Thread.sleep(3000);
		// loggers.logges("hi hello ");
		// loginPage.clickOnLogin();
		// ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		String actualValue = loginPage.getUserNameTxtBoxPlaceHolder();
		Assert.assertEquals(actualValue, EXPECTED_USR_PLC_HOL);
		//Thread.sleep(2000);

	}

	// PASSWORD VERIFICATION

	@Test()
	public void verifyloginpasswordTextBox1() throws InterruptedException {
		// loginPage.clickOnLogin();
		String actualValue = loginPage.getPasswordTxtBoxPlaceHolder();
		try {
			Assert.assertEquals(actualValue, EXPECTED_PSW_PLC_HOL);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.sleep(2000);
	}

	@Test(dependsOnMethods = { "verifyloginuserTextBox", "verifyloginpasswordTextBox1" },dataProvider= "excelSheetNameAsMethodName",
			dataProviderClass=ExcelDataProvider.class,invocationCount=1)
	public void loginTest(String TestCaseID,String UserName, String Password) {

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/login");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//for(int i=0;i<=5;i++) {
		homePage = loginPage.login(UserName, Password);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, "Solvendo.io");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		loginPage.logout();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		loginPage.Loginlink();
		//}
		//test.log(LogStatus.PASS, URL);
		// test.log(LogStatus.PASS," successfuly logged in");
		// loggers.logges(" hi hello how do u do ");
		
		/*
		 * WebElement actual_msg=driver.findElement(By.id("//li[6]//a[1]//span[1]"));
		 * String text=actual_msg.getText(); String expect="plz enter valid email"; if
		 * (actual_msg.isEnabled() && text.contains("Logged In successfully")) {
		 * 
		 * Assert.assertEquals(actual_msg, expect);
		 * //System.out.println("Successfully completed"); }else{
		 * System.out.println("please enter valid username"); loginPage.logout(); }
		 */
		// Mr. Tejas Jatin Parikh
	}

	@AfterClass()
	public void teardown() {
		//report.flush();
		//report.close();
		driver.close();
		////driver.quit();
	}

}
