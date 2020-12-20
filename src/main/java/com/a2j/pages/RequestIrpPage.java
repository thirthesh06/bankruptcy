package com.a2j.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestIrpPage {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	

	@FindBy(xpath = "//span[contains(text(),'Request IRP')]")
	WebElement RequestIrp;
	
	@FindBy(xpath = "//input[@placeholder='CIN']")
	WebElement cinnumber;
	
	@FindBy(xpath = "//input[@placeholder='CORPORATE Debtor']")
	WebElement copdeb;
	
	@FindBy(xpath = "//input[@placeholder='Company Token']")
	WebElement campnaytoken;
	
	@FindBy(xpath = "//select[@name='IRPState']")
	WebElement state;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement requestirpbtn;
	
	@FindBy(xpath="//input[@id='irname']")
	WebElement rpname;
	
	@FindBy(xpath="//input[@id='irid']")
	WebElement regnum;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement search;
	
	@FindBy(xpath="//button[contains(text(),'Request')]")
	WebElement reqbtn;
	
	
	
	public RequestIrpPage() {
	}

	public RequestIrpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		return valueList;
	}

	public void requestirpclick() {
		RequestIrp.click();
	}
	public void cin(String cin) {
		cinnumber.sendKeys(cin);
	}
	
	public void corpdeb(String corpdeb) {
		copdeb.sendKeys(corpdeb);
	}
	public void campnytoken(String camptokn) {
		campnaytoken.sendKeys(camptokn);
	}
	public void state(String sate) {
		state.sendKeys(sate);
	}
	public void requestirp() {
		requestirpbtn.click();
	}
	
	public void namerp(String namerp) {
		rpname.sendKeys(namerp);
	}
	public void RegistrationNo(String regno) {
		regnum.sendKeys(regno);
	}
	/*
	 * public void staterp(String staterp) { state.sendKeys(staterp); }
	 */
	
	public void search() {
		search.click();
	}
	public void reqbtn() throws InterruptedException {
		Thread.sleep(2000);
		reqbtn.click();
	}
	
}
