package com.a2j.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.a2j.base.TestBase;


public class LoginPage extends TestBase {
	@FindBy(xpath = "//input[@id='email']")
	WebElement loginTxtBox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTxtBox;

	@FindBy(xpath = "//button[@class='form-btn login-btn']")
	WebElement submitBtn;

	@FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@class='hm-btn']")
	WebElement getstartedBtn;

	@FindBy(xpath  = "//button[@class='btn btn-outline-info']")
	WebElement loginhere;
	@FindBy(css = "#header > div > div > div > a:nth-child(2) > button ")
	WebElement regbtn;
	
	@FindBy(xpath = "//span[contains(text(),'Logout')] ")
	WebElement logout;
	
	
	private WebDriverWait wait;
	
	private WebDriver driver;
	
	public LoginPage() {
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickonGetStarted() {
		getstartedBtn.click();

	}

	public void Loginlink() {
		wait.until(ExpectedConditions.elementToBeClickable(loginhere));
		loginhere.click();
		
	}

	public String getUserNameTxtBoxPlaceHolder() {
		return loginTxtBox.getAttribute("placeholder");

	}

	public String getPasswordTxtBoxPlaceHolder() {
		wait.until(ExpectedConditions.elementToBeClickable(passwordTxtBox));
		return passwordTxtBox.getAttribute("placeholder");
   }
	
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}

	public Dashboard_ProfilePage login(String userEmail, String password) {
		wait.until(ExpectedConditions.elementToBeClickable(loginTxtBox));
		loginTxtBox.clear();

		loginTxtBox.sendKeys(userEmail);
		//test.log(LogStatus.INFO, "logged In username"+userEmail);
		//test.log(LogStatus.PASS,""+userEmail);
		wait.until(ExpectedConditions.elementToBeClickable(passwordTxtBox));
		passwordTxtBox.clear();
		passwordTxtBox.sendKeys(password);
		//test.log(LogStatus.INFO, "logged In username"+password);
		loginBtn.click();
		
		//logout.click();
		// logo.isDisplayed();
		return new Dashboard_ProfilePage(this.driver);
	}

	public Register_page Reg_link() {

		wait.until(ExpectedConditions.elementToBeClickable(loginhere));
		regbtn.click();
		return new Register_page(this.driver);
	}
	public RequestIrpPage login1(String userEmail, String password) {

		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new RequestIrpPage(this.driver);
	}
	public CaseListPage login2(String userEmail, String password) {

		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new CaseListPage(this.driver);
	}
	
	public RpPage login3(String userEmail, String password) {

		loginTxtBox.sendKeys(userEmail);
		//test.log(LogStatus.INFO, "logged In username"+userEmail);
		passwordTxtBox.sendKeys(password);
	//	test.log(LogStatus.INFO, "logged In username"+userEmail);
		loginBtn.click();
		// logo.isDisplayed();
		return new RpPage(this.driver);
	}
	public RpMyCasesPage login4(String userEmail, String password) {

		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new RpMyCasesPage(this.driver);
	}
	//rpfasttrackcasespage
	public RpFastTrackPage rpftlogin(String userEmail, String password) {

		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new RpFastTrackPage(this.driver);
	}
///currency conversion page
	public CurrencyConversionPage logincurrency(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new CurrencyConversionPage(this.driver);
	}
	//filecliam
	public FCFileClaimPage loginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new FCFileClaimPage(this.driver);
	}
	
	public OCFileCliamPage OCloginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new OCFileCliamPage(this.driver);
	}
	public EmployeeEFileCliamPage EmployeeEloginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new EmployeeEFileCliamPage(this.driver);
	}
	public EmployeeDFileCliamPage EmployeeDloginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new EmployeeDFileCliamPage(this.driver);
	}
	public CCFileClaimPage ccloginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new CCFileClaimPage(this.driver);
	}
	public OTFileClaimPage otloginclaim(String userEmail, String password) {
		// TODO Auto-generated method stub
		loginTxtBox.sendKeys(userEmail);
		passwordTxtBox.sendKeys(password);
		loginBtn.click();
		// logo.isDisplayed();
		return new OTFileClaimPage(this.driver);
	}
}
