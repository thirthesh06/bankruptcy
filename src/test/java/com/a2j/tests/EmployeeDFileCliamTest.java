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
import com.a2j.pages.EmployeeDFileCliamPage;
import com.a2j.pages.LoginPage;

import utility.Constant;

public class EmployeeDFileCliamTest {

	LoginPage loginPage;
	WebDriver driver;
	EmployeeDFileCliamPage employeeDfilecliampage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("Authorized","No");
		testData.put("cin1", "junoc6");
		testData.put("totalclmamt", "15000");
		testData.put("docref", "Test");
		
		testData.put("arproceeding", "Test");
		testData.put("debincurd1", "test");
		testData.put("debincurd2", "test");
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

		employeeDfilecliampage = loginPage.EmployeeDloginclaim("We@12345", "We@12345");

	}
	
	@Test(dependsOnMethods = { "loginTest" })
	public void myprofile() throws InterruptedException {

		
		Thread.sleep(2000);
		employeeDfilecliampage.myprofileclick();
	}


	@Test(dependsOnMethods = { "myprofile" })
	public void edit_btn() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		employeeDfilecliampage.edit_profile_btn();
		// dashbrdPage.edit_profile_btn();
	}

	@Test(dependsOnMethods = { "edit_btn" })
	public void authoririzedrp() throws InterruptedException {
		employeeDfilecliampage.authoririzedrp(testData.get("Authorized"));
	}
	
	@Test(dependsOnMethods = { "authoririzedrp" })
	public void saveeditdetails() {
		employeeDfilecliampage.saveedit();
	}
	
	@Test(dependsOnMethods = { "saveeditdetails" })
	public void filecliam() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		employeeDfilecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		// actions.perform();
		// Thread.sleep(2000);
		employeeDfilecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		// actions.perform();

		employeeDfilecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {

		// actions.perform();

		employeeDfilecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formD() throws InterruptedException {

		employeeDfilecliampage.totalcliamamount(testData.get("totalclmamt"));
		employeeDfilecliampage.documentreference(testData.get("docref"));
		employeeDfilecliampage.aribitary(testData.get("arproceeding"));
		employeeDfilecliampage.howwen(testData.get("debincurd1"));
		employeeDfilecliampage.howwen1(testData.get("debincurd2"));
		employeeDfilecliampage.mutualcredit(testData.get("mutual"));
		employeeDfilecliampage.bankname(testData.get("bkname"));
		employeeDfilecliampage.accno(testData.get("accnumber"));
		employeeDfilecliampage.ifsc(testData.get("ifsccode"));
		employeeDfilecliampage.signature(testData.get("sign"));
		employeeDfilecliampage.relationcreditor(testData.get("rcrditor"));
		employeeDfilecliampage.authorizedperson(testData.get("autorized"));
		employeeDfilecliampage.indebtyear(testData.get("year"));
		employeeDfilecliampage.amountofclaim(testData.get("claimamt"));
		employeeDfilecliampage.listofdocument(testData.get("listdoc"));
		employeeDfilecliampage.detailsofmutualfund(testData.get("detailsmutual"));
		employeeDfilecliampage.veriyplace(testData.get("place"));
		
		
	}

	@Test(dependsOnMethods = { "formD" })
	public void submitbtn() throws InterruptedException {

		employeeDfilecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		employeeDfilecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}
	
	

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void Dclaimdata(String serialno,String type,String employeeid,String employeename,String pancard,String email,String phone, String amount, String currency, String contamt)
			throws InterruptedException {

		employeeDfilecliampage.claimdata(type,employeeid,employeename,pancard,email,phone,amount, currency, contamt);

	}
	
	@Test(dependsOnMethods= {"Dclaimdata"})
	public void savedetailsbtn() {
		employeeDfilecliampage.savedetails();
	}
	
	@Test(dependsOnMethods= {"savedetailsbtn"})
	public void submitclaimdatabtn() {
		employeeDfilecliampage.submitclmbtn();
	}
	@Test(dependsOnMethods= {"submitclaimdatabtn"})
	public void confirmsubmitsbtn() {
		employeeDfilecliampage.confirmbtn();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}
	
	
	
	
}
