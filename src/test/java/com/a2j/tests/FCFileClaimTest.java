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
import com.a2j.pages.FCFileClaimPage;
import com.a2j.pages.LoginPage;
import utility.Constant;

public class FCFileClaimTest {

	LoginPage loginPage;
	WebDriver driver;
	FCFileClaimPage filecliampage;
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

		filecliampage = loginPage.loginclaim("panfc@123", "Test@123");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void filecliam() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		filecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		// actions.perform();
		// Thread.sleep(2000);
		filecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		// actions.perform();

		filecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {

		// actions.perform();

		filecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formC() throws InterruptedException {


		filecliampage.totalcliamamount(testData.get("totalclmamt"));
		filecliampage.documentreference(testData.get("docref"));
		filecliampage.debincured(testData.get("debincurd"));
		filecliampage.dbstartdate(testData.get("dbindate"));
		filecliampage.mutualcredit(testData.get("mutual"));
		filecliampage.Detailsofsecurityheld(testData.get("security"));
		filecliampage.bankname(testData.get("bkname"));
		filecliampage.accno(testData.get("accnumber"));
		filecliampage.ifsc(testData.get("ifsccode"));
		filecliampage.proofofcliam(testData.get("proofofcliam"));
		filecliampage.signature(testData.get("sign"));
		filecliampage.relationcreditor(testData.get("rcrditor"));
		filecliampage.authorizedperson(testData.get("autorized"));
		// filecliampage.declarationdate(testData.get("date"));
		filecliampage.indebtyear(testData.get("year"));
		filecliampage.amountofclaim(testData.get("claimamt"));
		filecliampage.listofdocument(testData.get("listdoc"));
		filecliampage.detailsofmutualfund(testData.get("detailsmutual"));
		filecliampage.deponentssignature(testData.get("deponentssign"));
		filecliampage.verificationstart(testData.get("startnum"));
		filecliampage.verificationend(testData.get("endnum"));
		filecliampage.veriyplace(testData.get("place"));
	}

	@Test(dependsOnMethods = { "formC" })
	public void submitbtn() throws InterruptedException {

		filecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		filecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}
	
	

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void claimdata(String serialno,String date,String fctype,String fcname,String location,String finanacical,String ift,String documentid, String amount, String currency, String contamt)
			throws InterruptedException {

		filecliampage.claimdata(date,fctype,fcname,location,finanacical,ift,documentid,amount, currency, contamt);

	}
	
	@Test(dependsOnMethods= {"claimdata"})
	public void savedetailsbtn() {
		filecliampage.savedetails();
	}
	
	@Test(dependsOnMethods= {"savedetailsbtn"})
	public void submitclaimdatabtn() {
		filecliampage.submitclmbtn();
	}
	@Test(dependsOnMethods= {"submitclaimdatabtn"})
	public void confirmsubmitsbtn() {
		filecliampage.confirmbtn();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}
	
}
