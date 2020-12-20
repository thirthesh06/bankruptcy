package com.a2j.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.a2j.base.TestBase;

public class Dashboard_ProfilePage extends TestBase {
//public static final String username = "FC@12345";
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;


	@FindBy(xpath = "//option[contains(text(),'Select the Nature of Business')]")
	List<WebElement> businesslist;

	

	@FindBy(css = ".btn")
	WebElement edit_btn;
	
	@FindBy(xpath = "//input[@id='fcname']")
	WebElement fc_name;
	
	@FindBy(xpath = "//input[@id='fccompany']")
	WebElement fccompany;
	
	@FindBy(xpath = "//input[@id='fcid']")
	WebElement fcid;
	
	@FindBy(xpath = "//option[contains(text(),'Select the Nature of Business')]")
	List<WebElement> fcnature;
	

	@FindBy(xpath = "//select[@id='state']")
	List<WebElement> fcstate;
	
	@FindBy(xpath = "//textarea[@id='fcaddress']")
	WebElement fcaddress;
	
	@FindBy(xpath = "//input[@id='fcwebsite']")
	WebElement fcwebsite;
	

	@FindBy(xpath = "//a[contains(text(),'add secondary email')]")
	WebElement email;
	
	
	@FindBy(xpath = "//form/div/div")
	List<WebElement> formData;

	@FindBy(xpath = "//span[contains(text(),'My Profile')]")
	WebElement myprofile;

	@FindBy(css = "#root > div > div > div > div.dashboard-main.dashboard-haslayout > div > div > div:nth-child(2) > form > div.text-center > button")
	WebElement saevedit;

	public Dashboard_ProfilePage() {
	}

	public Dashboard_ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		return valueList;
	}

	public void myprofileclick() {
		myprofile.click();
	}

	public void edit_profile_btn() throws InterruptedException {
		//Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", edit_btn);
		edit_btn.click();
	}

	// fc name
	public void FinancialCreditorName(String fcname) throws InterruptedException {
		Thread.sleep(2000);
		fc_name.clear();
		fc_name.sendKeys(fcname);
		
	}

	// fccompany
	public void FinancialCompanyName(String fccompany1) throws InterruptedException {
		Thread.sleep(2000);
		fccompany.clear();
		fccompany.sendKeys(fccompany1);
	}

	// fcid
	public void FinancialId(String fcid1) throws InterruptedException {
		Thread.sleep(2000);
		fcid.clear();
		fcid.sendKeys(fcid1);
		;
	}
	//emaial
	public void Financialemail(String email1) throws InterruptedException {
		Thread.sleep(2000);
		email.clear();
		email.sendKeys(email1);
		;
	}
	// nature of bsuniess

	public void fcnatureofbusiness(String business) throws InterruptedException {
		Thread.sleep(2000);
		
		Select busins = new Select(driver.findElement(By.xpath("//select[@id='industry']")));
		busins.selectByVisibleText(business);
		
		/*
		 * try {
		 * 
		 * for (WebElement option1 : businesslist) {
		 * System.out.println(option1.getText().toString()); if
		 * ("IT".equals(option1.getText())) // System.out.println(option1.toString());
		 * option1.click();
		 * 
		 * } } catch (StaleElementReferenceException e) { }
		 */
	}

	// fcstate
	public void Financialstate(String state) throws InterruptedException {
		Thread.sleep(2000);
		fcstate.clear();
		//fcstate.sendKeys(state);
	}

	// address
	public void address(String address) throws InterruptedException {
		Thread.sleep(2000);
		fcaddress.clear();
		fcaddress.sendKeys(address);
	}
	//website
	public void website(String website1) throws InterruptedException {
		Thread.sleep(2000);
		fcwebsite.clear();
		fcwebsite.sendKeys(website1);
	}

	public void saveedit() {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", saevedit);
		saevedit.click();
	}

	public String getFinalcialCreditorName() {
		// TODO Auto-generated method stub

		return null;
	}

}
