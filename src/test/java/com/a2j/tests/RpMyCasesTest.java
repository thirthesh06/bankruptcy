package com.a2j.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.LoginPage;
import com.a2j.pages.RpMyCasesPage;

import utility.Constant;

public class RpMyCasesTest {

	LoginPage loginPage;
	WebDriver driver;
	// Dashboard_ProfilePage dashbrdPage;
	// CaseListPage caselistpage;
	// RpPage rppage;
	RpMyCasesPage rpmycasespage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";

	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("caseid", "INSOLVO_CA1111");
		testData.put("state", "Delhi");

		//////////////// form A details///////////////
		testData.put("registeraddress", "aaaaaaaaaaaaaaaaaaaaaaaaaa");
		testData.put("phyaddress", "gggg");
		testData.put("insolvdate", "24-05-2020");
		testData.put("insolvenddate", "25-05-2020");
		testData.put("rpname", "test1123");
		testData.put("rpno", "789545621252");
		testData.put("irpaddress", "tgygyygy");
		testData.put("irpemail", "abc@gmail.com");
		testData.put("irpcorremail", "avvc@gmail.com");
		testData.put("crossaddress", "chennai");
		testData.put("lstdate", "30-5-2020");
		testData.put("classname", "testa1");
		testData.put("classname1", "testa111");
		testData.put("classname2", "testa1222");
		testData.put("classname3", "testa112");
		testData.put("web1", "www.ast.com");
		testData.put("webaddress1", "fffffffffffffffff");
		testData.put("signatre", "testa");
		// testData.put("signatre", "saveformA");

		//////////////// pubisd advertise//////////////

		testData.put("semail", "testa@famil.com");
		testData.put("ssite", "testa");
		testData.put("pdate", "25-05-2020");
		testData.put("esub", "testing");
		testData.put("ebody", "dummy text");
		testData.put("forms", "Form A");
		////////////////////////////////////////
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
	}// tr[1]//td[3]//input[1]

	@Test(dependsOnMethods = { "verifyloginuserTextBox", "verifyloginpasswordTextBox1" })
	public void loginTest() {

		rpmycasespage = loginPage.login4("georgemichaellpu@gmail.com", "12jJ12@@@@");

	}

	@Test(dependsOnMethods = { "loginTest" })
	public void mycases() throws InterruptedException {

		// actions.perform();
		Thread.sleep(2000);
		rpmycasespage.mycasesclick();

	}

	@Test(enabled = true, dependsOnMethods = { "mycases" })
	public void caseid() throws InterruptedException {

		rpmycasespage.clickByCaseId(testData.get("caseid"));
	}

	@Test(enabled = false, dependsOnMethods = { "caseid" })
	public void setup() {

		rpmycasespage.setup();
	}

	@Test(dependsOnMethods = { "caseid" })
	public void caseprofile() {

		rpmycasespage.casemode();
	}

	@Test(dependsOnMethods = { "caseprofile" })
	public void saveprofile() {

		rpmycasespage.saveprofile();
	}

	@Test(dependsOnMethods = { "saveprofile" })
	public void checkbox() throws InterruptedException {

		rpmycasespage.checkboxverify();
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

		rpmycasespage.nextbutton();
	}

	@Test(dependsOnMethods = { "nextbtn" })
	public void vdrnextbtn() throws InterruptedException {

		rpmycasespage.vdrnext();
	}

	// user acces mamnagement 4 step
	@Test(dependsOnMethods = { "vdrnextbtn" })
	public void save() {
		rpmycasespage.save();
	}

	@Test(dependsOnMethods = { "save" })
	public void launchvdr() {
		rpmycasespage.vdr();
	}

	@Test(dependsOnMethods = { "launchvdr" })
	public void formA() {
		rpmycasespage.formA();
	}

	//////////////////////////////// filling form A//////////////////

	@Test(dependsOnMethods = { "formA" })
	public void formAedit() {
		rpmycasespage.formAedit();
	}

	@Test(dependsOnMethods = { "formAedit" })
	public void registeraddress() {
		rpmycasespage.registeraddress(testData.get("registeraddress"));
	}

	@Test(dependsOnMethods = { "registeraddress" })
	public void pysicaladdress() {

		rpmycasespage.principaladdress(testData.get("phyaddress"));

	}

	@Test(dependsOnMethods = { "pysicaladdress" })
	public void insolvencydate() {

		rpmycasespage.insolvencydate(testData.get("insolvdate"));

	}

	@Test(dependsOnMethods = { "insolvencydate" })
	public void Insolenddate() {
		rpmycasespage.insolvencyenddate(testData.get("insolvenddate"));
	}

	@Test(dependsOnMethods = { "Insolenddate" })
	public void namaeofrp() {
		rpmycasespage.rpname(testData.get("rpname"));
	}

	@Test(dependsOnMethods = { "namaeofrp" })
	public void regnorp() {
		rpmycasespage.regnorp(testData.get("rpno"));
	}

	@Test(dependsOnMethods = { "regnorp" })
	public void irpaddress() {
		rpmycasespage.irpregaddress(testData.get("irpaddress"));
	}

	@Test(dependsOnMethods = { "irpaddress" })
	public void irpremail() {
		rpmycasespage.irpemail(testData.get("irpemail"));
	}

	@Test(dependsOnMethods = { "irpremail" })
	public void irpcorremail() {
		rpmycasespage.irpcorremail(testData.get("irpcorremail"));
	}

	@Test(dependsOnMethods = { "irpcorremail" })
	public void irpcorraddress() {
		rpmycasespage.irpcorrsaddress(testData.get("crossaddress"));
	}

	@Test(dependsOnMethods = { "irpcorraddress" })
	public void lasdatesub() {
		rpmycasespage.ltclaimsubdate(testData.get("lstdate"));
	}

	@Test(dependsOnMethods = { "lasdatesub" })
	public void namelass() {
		rpmycasespage.nameclass(testData.get("classname"));
	}

	@Test(dependsOnMethods = { "namelass" })
	public void namesclass1() {
		rpmycasespage.nameclasss(testData.get("classname1"), testData.get("classname2"), testData.get("classname3"));

	}

	@Test(dependsOnMethods = { "namesclass1" })
	public void weblink() {
		rpmycasespage.weblink(testData.get("web1"));

	}

	@Test(dependsOnMethods = { "weblink" })
	public void webaddress() {
		rpmycasespage.webaddress(testData.get("webaddress1"));

	}

	@Test(dependsOnMethods = { "webaddress" })
	public void signature() {
		rpmycasespage.signatureforma(testData.get("signatre"));

	}

	@Test(dependsOnMethods = { "signature" })
	public void saveformA() {
		rpmycasespage.saveform();
		// rpmycasespage.downloadformA();

	}

	@Test(dependsOnMethods = { "saveformA" })
	public void downloadformA() throws InterruptedException {

		rpmycasespage.downloadformA();

	}
	//////////////////////////////// publish and advertise//////////////

	@Test(dependsOnMethods = { "downloadformA" })
	public void publish() {
		rpmycasespage.publish();
	}

	@Test(dataProvider = "data", dependsOnMethods = { "publish" })
	public void test(String dataString) {
		List<String> dataList = Arrays.stream(dataString.split(",")).collect(Collectors.toList());
		rpmycasespage.pubstate(dataList.get(0));
		rpmycasespage.pubcdwebsite(dataList.get(1));
		rpmycasespage.clickOnPlus(dataList.get(4));

	}

	@DataProvider
	public Object[] data() {
		return new Object[] { "Delhi,Times Of India,null,null,Yes", "Uttar Pradesh,India Today,null,null,No" };
	}

	@Test(dependsOnMethods = { "test" })
	public void pubcdsite() {

		rpmycasespage.pubcdsitechkbx();

	}

	@Test(dependsOnMethods = { "pubcdsite" })
	public void cdsupportemail() {

		rpmycasespage.supportemail(testData.get("semail"));

	}

	@Test(dependsOnMethods = { "cdsupportemail" })
	public void cdsupportsite() {

		rpmycasespage.supportsite(testData.get("ssite"));

	}

	@Test(dependsOnMethods = { "cdsupportemail" })
	public void publishdate() {

		rpmycasespage.pubdate(testData.get("pdate"));

	}

	@Test(dependsOnMethods = { "publishdate" })
	public void emailsubject() {

		rpmycasespage.emailsub(testData.get("esub"));

	}

	@Test(dependsOnMethods = { "emailsubject" })
	public void emailbody() {

		rpmycasespage.emailbody(testData.get("ebody"));

	}

	@Test(dependsOnMethods = { "emailbody" })
	public void froms() {

		rpmycasespage.formselection(testData.get("forms"));

	}

	@Test(dependsOnMethods = { "froms" })
	public void sendemail() {

		rpmycasespage.sendemail();

	}
}
