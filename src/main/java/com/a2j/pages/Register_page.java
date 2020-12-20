package com.a2j.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register_page  {
private WebDriverWait wait;
WebDriver driver;
	//private WebDriver driver;
	
	@FindBy(css = "#header > div > div > div > a:nth-child(2) > button ")
	WebElement regbtn;

	@FindBy(xpath = "//input[@id='username']")
	WebElement pannumber;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='passwordConfirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//button[@class='button ripple-effect btn btn-primary w-100']")
	WebElement registerbtn;
	
	@FindBy(id = "role")
	WebElement role;
	
		

	public Register_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void Reg_link() {
		wait.until(ExpectedConditions.elementToBeClickable(regbtn));
		regbtn.click();
	}
	
	public void role(String role1) {
		//role.sendKeys(role1);
		wait.until(ExpectedConditions.elementToBeClickable(role));
		Select select = new Select(role);
		select.selectByVisibleText(role1);
	}
	
	public void pannumber(String pan) {
		pannumber.sendKeys(pan);
	}
	
	public void email(String panemail) {
		email.sendKeys(panemail);
	}
	public void password(String pswd) {
		password.sendKeys(pswd);
	}
	public void confirmpassword(String cinpswd) {
		confirmpassword.sendKeys(cinpswd);
	}
	
	public void regbutton() {
		registerbtn.click();
	}
}
