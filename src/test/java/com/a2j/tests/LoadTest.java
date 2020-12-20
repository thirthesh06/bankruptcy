package com.a2j.tests;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.a2j.base.TestBase;

import utility.Constant;


public class LoadTest  {
//    invocationCount  TestNG should run this test method
	WebDriver driver;

    @Test(invocationCount = 5,threadPoolSize = 3, timeOut = 30000)
    public void loadTestThisWebsite() {
    	driver = TestBase.getDriver("chrome");
    	driver.get(Constant.url);
        String urlweb = "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/";
        System.out.println("This is " + urlweb);
        Assert.assertEquals("http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/", urlweb);
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
        
        driver.quit();

    }

    

}