package utility;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports getInstance() {
		
		Date date = new Date();
		
		String currentDateAndTime = date.toString();
		
		String fileName = currentDateAndTime.replace(" ","_").replace(":","_")+".html";
		
		String filePath = "reports//"+fileName;
		
		ExtentReports eReport = new ExtentReports(filePath,true,DisplayOrder.NEWEST_FIRST);
		
		File reportConfigFile = new File("ReportsConfig.xml");
		
		eReport.loadConfig(reportConfigFile);
		
		eReport.addSystemInfo("TestNG","6.9.9")
		.addSystemInfo("Selenium","2.53.1")
		.addSystemInfo("Environment","QA")
		.addSystemInfo("Name","Thirthesh");
		
		return eReport;	
		
	}

}
