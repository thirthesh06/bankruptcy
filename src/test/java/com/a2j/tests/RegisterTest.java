package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.LoginPage;
import com.a2j.pages.Register_page;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utility.Constant;

public class RegisterTest {

	LoginPage loginPage;
	WebDriver driver;
	Register_page regPage;
	ExtentHtmlReporter htmlReporter;
	//static ExtentReports extent;
	// helps to generate the logs in test report.
	//ExtentTest test;

	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	static final String EXPECTED_LOGIN_BUTTON = "  ";
	static final String EXPECTED_LOGOL = "      ";

	static Map<String, String> testData;

	static {
		testData = new HashMap<>();
		//Resolution Professional,Corporate Debtor,Financial Creditor,Employee/Workman,Operational Creditor,Resolution Applicant,Creditor in Class and Others
		testData.put("roles1", "Financial Creditor");
		testData.put("pan", "fc1234567tyyyytkafda");
		testData.put("panemail", "ef212slyyydta@gmail");
		testData.put("password", "Test@123");
		testData.put("cinpassword", "Test@123");
	}

	@BeforeClass
	public void init() {
		driver = TestBase.getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		driver.get(Constant.url);

	}

	@Test
	public void regbtn() throws InterruptedException {
		// Thread.sleep(2000);
		regPage = loginPage.Reg_link();

	}

	@Test(dependsOnMethods = { "regbtn" })
	public void role() {
		// Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// regPage.role(testData.get("roles1"));
		regPage.role(testData.get("roles1"));

	}

	@Test(dependsOnMethods = { "role" })
	public void pannumber() {

		regPage.pannumber(testData.get("pan"));
	}

	@Test(dependsOnMethods = { "pannumber" })
	public void panemail() {
		regPage.email(testData.get("panemail"));
	}

	@Test(dependsOnMethods = { "panemail" })
	public void password() {
		regPage.password(testData.get("password"));
	}

	@Test(dependsOnMethods = { "password" })
	public void confirmpass() {
		regPage.confirmpassword(testData.get("cinpassword"));
	}

	@Test(dependsOnMethods = { "confirmpass" })
	public void register() {
		regPage.regbutton();

	}
	/*
	 * @Test(dependsOnMethods = { "register" }) public void teardown() {
	 * driver.quit(); }
	 */
}
