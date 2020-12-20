package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.ExcelDataProvider;
import com.a2j.base.TestBase;
import com.a2j.pages.EmployeeEFileCliamPage;

import com.a2j.pages.LoginPage;

import utility.Constant;

public class EmployeeEFileCliamTest {

	LoginPage loginPage;
	WebDriver driver;
	EmployeeEFileCliamPage employeeEfilecliampage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("cin1", "junoc6");
		testData.put("totalclmamt", "15000");
		testData.put("docref", "Test");
		testData.put("debincurd", "test");
		testData.put("dbindate", "12/6/2020");
		testData.put("mutual", "test");
		testData.put("workman1", "test");
		
		
		testData.put("workmanid1", "we45255");
		
		testData.put("workmantta1", "4500");
		
		testData.put("workmanpmd1", "7855");
		
		
		testData.put("proofofcliam", "test12345");
		testData.put("sign", "test123");
		testData.put("rcrditor", "test");
		testData.put("autorized", "testbhhh");
		testData.put("date", "5");
		testData.put("year", "2020");
		testData.put("claimamt", "11500");
		testData.put("listdoc", "ssssssssssssssssssssssss");
		testData.put("detailsmutual", "assasasssssssssasasasasssaa");
		testData.put("deponentssign", "testsign");
		testData.put("place", "banglore");
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

		employeeEfilecliampage = loginPage.EmployeeEloginclaim("We@12345", "We@12345");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void filecliam() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		employeeEfilecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		// actions.perform();
		// Thread.sleep(2000);
		employeeEfilecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		// actions.perform();

		employeeEfilecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {

		// actions.perform();

		employeeEfilecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formE() throws InterruptedException {

		employeeEfilecliampage.mutualcredit(testData.get("mutual"));
		employeeEfilecliampage.totalcliamamount(testData.get("totalclmamt"));
		employeeEfilecliampage.deponentssignature(testData.get("deponentssign"));
		/*
		 * employeeEfilecliampage.annexturewe1(testData.get("workman1"));
		 * employeeEfilecliampage.annextureweid(testData.get("workmanid1"));
		 * employeeEfilecliampage.annextureweta1(testData.get("workmantta1"));
		 * employeeEfilecliampage.annexturewepmd1(testData.get("workmanpmd1"));
		 */
		
		
		
	}

	@Test(dependsOnMethods = { "formE" })
	public void submitbtn() throws InterruptedException {

		employeeEfilecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		employeeEfilecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}
	
	

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void Eclaimdata(String serialno,String type,String employeeid,String employeename,String pancard,String email,String phone, String amount, String currency, String contamt)
			throws InterruptedException {

		employeeEfilecliampage.claimdata(type,employeeid,employeename,pancard,email,phone,amount, currency, contamt);

	}
	
	@Test(dependsOnMethods= {"Eclaimdata"})
	public void savedetailsbtn() {
		employeeEfilecliampage.savedetails();
	}
	
	@Test(dependsOnMethods= {"savedetailsbtn"})
	public void submitclaimdatabtn() {
		employeeEfilecliampage.submitclmbtn();
	}
	@Test(dependsOnMethods= {"submitclaimdatabtn"})
	public void confirmsubmitsbtn() {
		employeeEfilecliampage.confirmbtn();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}
	
	
	
}
