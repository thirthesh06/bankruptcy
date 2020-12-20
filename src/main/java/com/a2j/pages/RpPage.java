package com.a2j.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RpPage {

	private WebDriver driver;
	@FindBy(xpath="//span[contains(text(),'Case Requests')]")
	WebElement caserequest;
	
	@FindBy(linkText  ="Upload Order")
	WebElement upload;
	
	@FindBy(xpath  ="//div[@class='dashboardbox irdashboardbox mt-3']//div[1]//p[1]//div[1]//div[1]//a[1]//button[text()='Accept']")
	WebElement accept;
	 @FindBy(xpath = "//tr//td[contains(text(),'panfc@123')]")
	 WebElement username;
	 
	 @FindBy(xpath = "//button[contains(@class,'btn btn-primary btn-sm')]")
	 WebElement form2;
	
	 @FindBy(css = "#root > div > div > div > div.dashboard-main.dashboard-haslayout > div > div.dashboardbox.irdashboardbox.mt-3 > div.dashboardholder > table > tbody > tr:nth-child(9) > td:nth-child(7) > div > p:nth-child(1) > div > div > a")
	 WebElement uploadform2;
	 
	public RpPage() {
	}

	public RpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		return valueList;
	}

	public void caserequestsclick() {
		caserequest.click();
	}
	public void clickByCaseId(String caseId) throws InterruptedException {
		Thread.sleep(2000);
		WebElement htmltable=driver.findElement(By.xpath("//*[@id='root']//table[1]/tbody"));
		List<WebElement> trList = htmltable.findElements(By.tagName("tr"));//(".table > tbody:nth-child(2) > tr> td"));
		//System.out.println(trList);
		
		/*
		 * trList.stream().map(d -> d.findElements(By.
		 * cssSelector(".table > tbody:nth-child(2) > tr > td:nth-child(1)"))).forEach(l
		 * -> {
		 * 
		 * if(l.get(0).getText().equalsIgnoreCase(caseId)) {
		 * System.out.println(l.toString()); l.get(9).click(); } });
		 */
		for(int rnum=0;rnum<trList.size();rnum++)
		{
		List<WebElement> columns=trList.get(rnum).findElements(By.cssSelector(".table > tbody:nth-child(2) > tr > td:nth-child(1)"));
		//System.out.println("Number of columns:"+columns.size());
		 
		for(int cnum=0;cnum<columns.size();cnum++)
		{
			//System.out.println(columns.get(cnum).getText());
			if(columns.get(cnum).getText().equalsIgnoreCase(caseId)) {
				//System.out.println(columns.get(cnum).getText());
				Thread.sleep(2000);
				 columns.get(cnum).click();
				 System.out.println(columns.get(cnum).getText());
				 Thread.sleep(2000);
				 }
			else {
				System.out.println("caseid dont match");
				break;
				
			}
			}
		
		}
		
		
	}
	
	public void accept() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", accept);
		//username.click();
		accept.click();
	}
     public void downform2() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", form2);
		//username.click();
		form2.click();
	}
     public void uploadform2() {
 		
 		JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("arguments[0].scrollIntoView(true)", uploadform2);
 		//username.click();
 		uploadform2.click();
 	}
}
