package com.a2j.tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;
import com.a2j.pages.CaseListPage;
import com.a2j.pages.LoginPage;

import utility.Constant;

public class CaseListTest {
	LoginPage loginPage;
	WebDriver driver;
	//Dashboard_ProfilePage dashbrdPage;
	CaseListPage caselistpage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	//fileLocation= C:\\Users\\thirthesh\\Downloads\\NCLT Order.pdf;
	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("cin", "Test123tr");
		testData.put("coprdeb", "fc123456tt78fr");
		testData.put("compnaytoken", "efefetfr");
		testData.put("state", "karnataka");
		testData.put("rpname", "Vikram");
		testData.put("regnomb", "IBBI/IPA-002/IP-N00003/2016-2017/10003");
	    testData.put("staterp", "");
	    testData.put("caseid", "Temp_IN_junedemo29");
	    testData.put("conrp", "Mr Ashish Chhawchharia");
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
		//homePage = loginPage.login("thirthesh06@gmail.com", "thirthesh@12");
	}

	@Test(dependsOnMethods = { "loginbutton"})
	public void verifyloginuserTextBox() throws InterruptedException {
		//Thread.sleep(3000);
		//loginPage.clickOnLogin();
		// ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		String actualValue = loginPage.getUserNameTxtBoxPlaceHolder();
		Assert.assertEquals(actualValue, EXPECTED_USR_PLC_HOL);
		//Thread.sleep(2000);

	}

	// PASSWORD VERIFICATION

	@Test
	public void verifyloginpasswordTextBox1() throws InterruptedException {
		String actualValue = loginPage.getPasswordTxtBoxPlaceHolder();
		try {
			Assert.assertEquals(actualValue, EXPECTED_PSW_PLC_HOL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = { "verifyloginuserTextBox" ,"verifyloginpasswordTextBox1" })
	public void loginTest() {

		caselistpage = loginPage.login2("panfc@123", "Test@123");
		
	}


	@Test(dependsOnMethods = {"loginTest"})
	  public void caselist() throws InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  caselistpage.caselistclick();
		  
		  }
	
	@Test(enabled = true, dependsOnMethods = { "caselist" })
	  public void caseid() throws InterruptedException {
	  
		caselistpage.clickByCaseId(testData.get("caseid"));
	  }
	
	// uplaoding nclt order
	@Test(dependsOnMethods = {"caseid"})
	public void testUpload() throws InterruptedException
	{driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		//caselistpage.uploadfile();
		caselistpage.browsefile();
		uploadFile("E:\\V2J-Auto\\Bankruptcypro\\Nclt\\nclt_order.pdf");
		Thread.sleep(2000);
	}
	
	/**
     * This method will set any parameter string to the system's clipboard.
     */
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }
	
	@Test(dependsOnMethods = { "testUpload" })
	public void confirmrp() throws InterruptedException {
Thread.sleep(2000);
		caselistpage.confrp(testData.get("conrp"));
	}
	
	@Test(dependsOnMethods = { "confirmrp" })
	public void uploadbtn() throws InterruptedException {
		Thread.sleep(2000);
		caselistpage.uploadbtnnclt();
	}
	
	/*
	 * @Test(dependsOnMethods = {"testUpload"}) public void teardown() {
	 * driver.quit(); }
	 */
	

}
