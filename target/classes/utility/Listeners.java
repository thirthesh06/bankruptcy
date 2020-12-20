package utility;



import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@SuppressWarnings("deprecation")
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	  System.out.println("hi"+new Date().toGMTString());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("hello");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("angel");	
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("how r u");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("see u soon");	
		  
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		  System.out.println("bye");	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		  System.out.println("tc");	
	}
	

}
