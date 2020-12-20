package com.a2j.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.ExcelDataProvider;
import com.a2j.base.TestBase;
import com.a2j.pages.LoginPage;
import com.a2j.pages.OCFileCliamPage;

import utility.Constant;

public class OCFileClaimTest {
	
	LoginPage loginPage;
	WebDriver driver;
	OCFileCliamPage ocfilecliampage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("cin1", "junoc6");
		testData.put("totalclmamt", "15000");
		testData.put("docref", "Test");
		testData.put("arproceeding", "test");
		testData.put("debincurd", "test");
		testData.put("dbcurdwen", "tets");
		testData.put("dbindate", "12/6/2020");
		testData.put("mutual", "test");
		testData.put("retention", "test");
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

		ocfilecliampage = loginPage.OCloginclaim("panoc@1234545", "Test@123");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void filecliam() throws InterruptedException {

		Thread.sleep(2000);
		ocfilecliampage.fileclaimclick();

	}

	@Test(dependsOnMethods = { "filecliam" })
	public void readcliam() throws InterruptedException {

		ocfilecliampage.readclaim();

	}

	@Test(dependsOnMethods = { "readcliam" })
	public void cin() throws InterruptedException {

		ocfilecliampage.cinnumber(testData.get("cin1"));

	}

	@Test(dependsOnMethods = { "cin" })
	public void claimbtn() throws InterruptedException {

		ocfilecliampage.claimbutton();

	}

	@Test(dependsOnMethods = { "claimbtn" })
	public void formB() throws InterruptedException {


		ocfilecliampage.totalcliamamount(testData.get("totalclmamt"));
		ocfilecliampage.documentreference(testData.get("docref"));
		ocfilecliampage.aribitary(testData.get("arproceeding"));
		ocfilecliampage.debincured(testData.get("debincurd"));
		ocfilecliampage.debincuredwen(testData.get("dbcurdwen"));
		//ocfilecliampage.dbstartdate(testData.get("dbindate"));
		ocfilecliampage.mutualcredit(testData.get("mutual"));
		ocfilecliampage.detailsOfAnyRetention(testData.get("retention"));
		ocfilecliampage.bankname(testData.get("bkname"));
		ocfilecliampage.accno(testData.get("accnumber"));
		ocfilecliampage.ifsc(testData.get("ifsccode"));
		ocfilecliampage.proofofcliam(testData.get("proofofcliam"));
		ocfilecliampage.signature(testData.get("sign"));
		ocfilecliampage.relationcreditor(testData.get("rcrditor"));
		ocfilecliampage.authorizedperson(testData.get("autorized"));
		// filecliampage.declarationdate(testData.get("date"));
		ocfilecliampage.indebtyear(testData.get("year"));
		ocfilecliampage.amountofclaim(testData.get("claimamt"));
		ocfilecliampage.listofdocument(testData.get("listdoc"));
		ocfilecliampage.detailsofmutualfund(testData.get("detailsmutual"));
		ocfilecliampage.deponentssignature(testData.get("deponentssign"));
		ocfilecliampage.verificationstart(testData.get("startnum"));
		ocfilecliampage.verificationend(testData.get("endnum"));
		ocfilecliampage.veriyplace(testData.get("place"));
	}

	@Test(dependsOnMethods = { "formB" })
	public void submitbtn() throws InterruptedException {

		ocfilecliampage.submitbutton();

	}

	@Test(dependsOnMethods = { "submitbtn" })
	public void procedbtn() throws InterruptedException {

		ocfilecliampage.proceedbutton();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/claim/upload-files");
	}
	
	

	@Test(dependsOnMethods = {
			"procedbtn" }, dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class, invocationCount = 1)
	public void occlaimdata(String serialno,String date,String ocname,String octype,String location,String finanacical,String ift,String documentid, String amount, String currency, String contamt)
			throws InterruptedException {

		ocfilecliampage.claimdata(date,ocname,octype,location,finanacical,ift,documentid,amount, currency, contamt);

	}
	
	@Test(dependsOnMethods= {"occlaimdata"})
	public void savedetailsbtn() {
		ocfilecliampage.savedetails();
	}
	
	@Test(dependsOnMethods= {"savedetailsbtn"})
	public void submitclaimdatabtn() {
		ocfilecliampage.submitclmbtn();
	}
	@Test(dependsOnMethods= {"submitclaimdatabtn"})
	public void confirmsubmitsbtn() {
		ocfilecliampage.confirmbtn();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/allClaims");
	}

}
