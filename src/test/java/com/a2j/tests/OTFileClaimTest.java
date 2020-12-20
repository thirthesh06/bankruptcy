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
import com.a2j.pages.OTFileClaimPage;
import com.a2j.pages.LoginPage;

import utility.Constant;

public class OTFileClaimTest {
	LoginPage loginPage;
	WebDriver driver;
	OTFileClaimPage otfilecliampage;
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
		testData.put("security", "test");
		testData.put("bkname", "sbi");
		testData.put("accnumber", "1234565212");
		testData.put("ifsccode", "sbi123456");
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

		otfilecliampage = loginPage.otloginclaim("ottest@123", "Test@123");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void filecliam() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		otfilecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		// actions.perform();
		// Thread.sleep(2000);
		otfilecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		otfilecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {
		otfilecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formF() throws InterruptedException {

		otfilecliampage.totalcliamamount(testData.get("totalclmamt"));
		otfilecliampage.documentreference(testData.get("docref"));
		otfilecliampage.debincured(testData.get("debincurd"));
		// otfilecliampage.dbstartdate(testData.get("dbindate"));
		otfilecliampage.mutualcredit(testData.get("mutual"));
		otfilecliampage.Detailsofsecurityheld(testData.get("security"));
		otfilecliampage.bankname(testData.get("bkname"));
		otfilecliampage.accno(testData.get("accnumber"));
		otfilecliampage.ifsc(testData.get("ifsccode"));
		// otfilecliampage.proofofcliam(testData.get("proofofcliam"));
		// otfilecliampage.signature(testData.get("sign"));
		// otfilecliampage.relationcreditor(testData.get("rcrditor"));
		// otfilecliampage.authorizedperson(testData.get("autorized"));
		// filecliampage.declarationdate(testData.get("date"));
		otfilecliampage.indebtyear(testData.get("year"));
		otfilecliampage.amountofclaim(testData.get("claimamt"));
		otfilecliampage.listofdocument(testData.get("listdoc"));
		otfilecliampage.detailsofmutualfund(testData.get("detailsmutual"));
		otfilecliampage.deponentssignature(testData.get("deponentssign"));
		// otfilecliampage.verificationstart(testData.get("startnum"));
		/// otfilecliampage.verificationend(testData.get("endnum"));
		otfilecliampage.veriyplace(testData.get("place"));
	}

	@Test(dependsOnMethods = { "formF" })
	public void submitbtn() throws InterruptedException {

		otfilecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		otfilecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void otclaimdata(String serialno, String date, String ottype, String otname, String location,
			String finanacical, String ift, String documentid, String amount, String currency, String contamt)
			throws InterruptedException {

		otfilecliampage.claimdata(date, ottype, otname, location, finanacical, ift, documentid, amount, currency,
				contamt);

	}

	@Test(dependsOnMethods = { "otclaimdata" })
	public void savedetailsbtn() {
		otfilecliampage.savedetails();
	}

	@Test(dependsOnMethods = { "savedetailsbtn" })
	public void submitclaimdatabtn() {
		otfilecliampage.submitclmbtn();
	}

	@Test(dependsOnMethods = { "submitclaimdatabtn" })
	public void confirmsubmitsbtn() {
		otfilecliampage.confirmbtn();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}
}
