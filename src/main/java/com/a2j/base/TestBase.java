package com.a2j.base;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase 
{
	public static String dest;
	public static String time;
	//public static ExtentReports report;
	//public static ExtentTest test;
	WebDriver driver;
	
	static JavascriptExecutor js;
	public boolean isAlreadyLogIn = false;

	public static WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver(getCapabilities());
			 
		} else {

		}
		return null;
	}

	public void tearDown(WebDriver driver) {
		//driver.quit();
	}

	
	  public static ChromeOptions getCapabilities() { ChromeOptions options = new
	  ChromeOptions(); options.addArguments("start-maximized");
	  options.addArguments("disable-infobars");
	  options.addArguments("--disable-notifications"); 
	  options.setPageLoadStrategy(PageLoadStrategy.NONE);
	  File f = new File("src/main/resources/drivers/extension_1_31_0_0.crx"); options.addExtensions(f);
	  return options;
	  }
	  
	/*
	 * public static String takeScreenshot(WebDriver driver) { try { DateFormat
	 * dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss"); Date date = new
	 * Date(); //System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
	 * time = dateFormat.format(date); //System.out.println("Time is" + time);
	 * TakesScreenshot tc = (TakesScreenshot) driver; File src =
	 * tc.getScreenshotAs(OutputType.FILE);
	 * 
	 * dest = "E:\\V2J-Auto\\Bankruptcypro\\Reports\\Images\\" + time + ".png"; File
	 * destination = new File(dest); FileUtils.copyFile(src, destination);
	 * //System.out.println("image destination" + dest);
	 * System.out.println("Screen shot taken");
	 * 
	 * // return dest; } catch (Exception ex) {
	 * System.out.println("Screenshot error is" + ex.getMessage()); } return dest; }
	 * 
	 * 
	 * @BeforeTest public void Reportsetup() { try {
	 * 
	 * report=new
	 * ExtentReports("E://V2J-Auto//Bankruptcypro//Reports//Report.html",true);
	 * //report=new ExtentReports(
	 * "E://GIT_Project//TestNG_ExtentReport_Maven//ExtentReport//Report"+System.
	 * currentTimeMillis()+".html",true); report.addSystemInfo("HostName",
	 * "Thirthesh") .addSystemInfo("Environment", "Windows")
	 * .addSystemInfo("User","Thirthesh") .addSystemInfo("Project Name",
	 * "Bankruptcy"); report.loadConfig(new
	 * File(System.getProperty("user.dir")+"\\extent-config.xml"));
	 * 
	 * 
	 * } catch(Exception ex) { System.out.println("Issue is"+ex.getMessage()); } }
	 * 
	 * @AfterMethod public void getReport(ITestResult result) { try { String
	 * screnshotpath = takeScreenshot(driver); if (result.getStatus() ==
	 * ITestResult.FAILURE) {
	 * 
	 * // String info=result.getThrowable(); test.log(LogStatus.FAIL,
	 * result.getThrowable()); test.log(LogStatus.FAIL,
	 * "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
	 * test.log(LogStatus.FAIL, "Test Case Fail is:- "+result.getName());
	 * 
	 * //test.addScreenCaptureFromPath("please refer below screennshot"
	 * ,screnshotpath);
	 * 
	 * } else if(result.getStatus()==ITestResult.SUCCESS) { test.log(LogStatus.PASS,
	 * "Test Case pass is:- "+result.getName()); test.log(LogStatus.PASS,
	 * "Below is the screen shot:-"+test.addScreenCapture(screnshotpath)); } else
	 * if(result.getStatus()==ITestResult.SKIP) { test.log(LogStatus.SKIP,
	 * "test Case skip is:- "+result.getName()); } else
	 * if(result.getStatus()==ITestResult.STARTED) {test.log(LogStatus.INFO,
	 * "Test Case started");
	 * 
	 * } report.endTest(test);
	 * 
	 * } catch (Exception es) {
	 * System.out.println(" Report genration Excepion is:- " + es.getMessage()); } }
	 * 
	 * @AfterTest public void endTest() { report.flush(); report.close(); }
	 */


@BeforeTest
public void Reportsetup()
{
	try
	{
	
			/*
			 * report=new
			 * ExtentReports("E://V2J-Auto//Bankruptcypro//Reports//Report.html",true);
			 * 
			 * report.addSystemInfo("HostName", "Thirthesh") .addSystemInfo("Environment",
			 * "windows") .addSystemInfo("User","thirthesh") .addSystemInfo("Project Name",
			 * "Solvendo"); report.loadConfig(new
			 * File(System.getProperty("user.dir")+"\\extent-config.xml"));
			 */

			
	}
	catch(Exception ex)
	{
		System.out.println("Issue is"+ex.getMessage());
	}
}
@AfterMethod
public void getReport(ITestResult result) {
	try {
		//String screnshotpath = takeScreenshot(driver);
		if (result.getStatus() == ITestResult.FAILURE) {

			// String info=result.getThrowable();
			//test.log(LogStatus.FAIL, result.getThrowable());
			//test.log(LogStatus.FAIL, "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
			//test.log(LogStatus.FAIL, "Test Case Fail is:- "+result.getName());

			//test.addScreenCaptureFromPath("please refer below screennshot",screnshotpath);

		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			//test.log(LogStatus.PASS, "Test Case pass is:- "+result.getName());
			//test.log(LogStatus.PASS, "Below is the screen shot:-"+test.addScreenCapture(screnshotpath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			//test.log(LogStatus.SKIP, "test Case skip is:- "+result.getName());
		}
		else if(result.getStatus()==ITestResult.STARTED)
		{//test.log(LogStatus.INFO, "Test Case started");

		}
		//report.endTest(test);

	} catch (Exception es) {
		System.out.println(" Report genration Excepion is:- " + es.getMessage());
	}
}


@AfterTest
public void endTest()
{
	//report.flush();
	//report.close();
}
}
