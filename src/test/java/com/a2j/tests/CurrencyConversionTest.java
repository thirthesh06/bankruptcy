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
import com.a2j.pages.CurrencyConversionPage;
import com.a2j.pages.LoginPage;
import utility.Constant;

public class CurrencyConversionTest {


	LoginPage loginPage;
	WebDriver driver;
	CurrencyConversionPage currencyconversionpage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	static final String EXPECTED_USR_PLC_HOL = "PAN number or Email";
	static final String EXPECTED_PSW_PLC_HOL = "Password";
	
	static Map<String, String> testData;
	static {
		testData = new HashMap<>();
		testData.put("cin1", "junoc6");
		
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
		Thread.sleep(3000);
		//loginPage.clickOnLogin();
		// ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		String actualValue = loginPage.getUserNameTxtBoxPlaceHolder();
		Assert.assertEquals(actualValue, EXPECTED_USR_PLC_HOL);
		Thread.sleep(2000);

	}

	// PASSWORD VERIFICATION

	@Test
	public void verifyloginpasswordTextBox1() throws InterruptedException {
		//loginPage.clickOnLogin();
		String actualValue = loginPage.getPasswordTxtBoxPlaceHolder();
		try {
			Assert.assertEquals(actualValue, EXPECTED_PSW_PLC_HOL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}
	@Test(dependsOnMethods = { "verifyloginuserTextBox" ,"verifyloginpasswordTextBox1" })
	public void loginTest() {

		currencyconversionpage = loginPage.logincurrency("panfc@123", "Test@123");
		
	}


	@Test(dependsOnMethods = {"loginTest"})
	  public void filecliam() throws InterruptedException { 
		
		 // actions.perform();
		  Thread.sleep(2000);
		  currencyconversionpage.fileclaimclick();
		  
		  }
	
	  @Test(dependsOnMethods = {"filecliam"}) public void readcliam() throws
	  InterruptedException {
	  
	  // actions.perform(); 
		 // Thread.sleep(2000);
		  currencyconversionpage.readclaim();
	  
	  }
	  
	  @Test(dependsOnMethods = {"readcliam"}) public void cin() throws
	  InterruptedException {
	  
	  // actions.perform();
	  
	  currencyconversionpage.cinnumber(testData.get("cin1"));
	  
	  
	  }
	  
	
	  @Test(dependsOnMethods = {"cin"}) 
	  public void claimbtn() throws
	  InterruptedException {
	  
	  // actions.perform();
	  
	  currencyconversionpage.claimbutton();
	 
	  
	  }
	  @Test(dependsOnMethods = {"claimbtn"})
	  public void procedbtn() throws
	  InterruptedException {
	  
	  // actions.perform();
	  
	  currencyconversionpage.proceedbutton();
	 
	  
	  }
	 
	  @Test(dependsOnMethods = { "procedbtn" },dataProvider= "excelSheetNameAsMethodName",
				dataProviderClass=ExcelDataProvider.class,invocationCount=1)
		public void currencytest(String serialno,String amount, String currency,String contamt) throws InterruptedException {
	  
	  currencyconversionpage.amount(serialno,amount,currency,contamt);
	 // currencyconversionpage.currencytype(currency);
	  //currencyconversionpage.convtamt(contamt);
	  
	  }
}
