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
import com.a2j.pages.CCFileClaimPage;
import com.a2j.pages.LoginPage;

import utility.Constant;

public class CCFileClaimTest {

	LoginPage loginPage;
	WebDriver driver;
	CCFileClaimPage ccfilecliampage;
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

		ccfilecliampage = loginPage.ccloginclaim("ccpan@1234", "Test@123");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void filecliam() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		ccfilecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		// actions.perform();
		// Thread.sleep(2000);
		ccfilecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		// actions.perform();

		ccfilecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {

		// actions.perform();

		ccfilecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formCA() throws InterruptedException {


		ccfilecliampage.totalcliamamount(testData.get("totalclmamt"));
		ccfilecliampage.documentreference(testData.get("docref"));
		ccfilecliampage.debincured(testData.get("debincurd"));
		ccfilecliampage.dbstartdate(testData.get("dbindate"));
		ccfilecliampage.mutualcredit(testData.get("mutual"));
		ccfilecliampage.Detailsofsecurityheld(testData.get("security"));
		ccfilecliampage.bankname(testData.get("bkname"));
		ccfilecliampage.accno(testData.get("accnumber"));
		ccfilecliampage.ifsc(testData.get("ifsccode"));
		ccfilecliampage.proofofcliam(testData.get("proofofcliam"));
		ccfilecliampage.signature(testData.get("sign"));
		ccfilecliampage.relationcreditor(testData.get("rcrditor"));
		ccfilecliampage.authorizedperson(testData.get("autorized"));
		ccfilecliampage.indebtyear(testData.get("year"));
		ccfilecliampage.amountofclaim(testData.get("claimamt"));
		ccfilecliampage.listofdocument(testData.get("listdoc"));
		ccfilecliampage.detailsofmutualfund(testData.get("detailsmutual"));
		ccfilecliampage.deponentssignature(testData.get("deponentssign"));
		
	}

	@Test(dependsOnMethods = { "formCA" })
	public void submitbtn() throws InterruptedException {

		ccfilecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		ccfilecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}
	
	

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void ccclaimdata(String serialno,String date,String crtype,String crname,String location,String finanacical,String ift,String documentid, String amount, String currency, String contamt)
			throws InterruptedException {

		ccfilecliampage.claimdata(date,crtype,crname,location,finanacical,ift,documentid,amount, currency, contamt);

	}
	
	@Test(dependsOnMethods= {"otclaimdata"})
	public void savedetailsbtn() {
		ccfilecliampage.savedetails();
	}
	
	@Test(dependsOnMethods= {"savedetailsbtn"})
	public void submitclaimdatabtn() {
		ccfilecliampage.submitclmbtn();
	}
	@Test(dependsOnMethods= {"submitclaimdatabtn"})
	public void confirmsubmitsbtn() {
		ccfilecliampage.confirmbtn();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}
}
