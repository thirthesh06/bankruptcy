package com.a2j.pages;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CurrencyConversionPage {

	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//private WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'File Claim')]")
	WebElement fileclaim;

	@FindBy(xpath = "//span[contains(text(),'Read Claim Process')]")
	WebElement readcliam;

	@FindBy(css = " #root > div > div > div > div.dashboard-main.dashboard-haslayout > div > div > div.row.mt-3.mb-5 > div:nth-child(3) > div > span:nth-child(2)")
	WebElement fillclaim;
	
	@FindBy(xpath = "//input[@id='cin']")
	WebElement cinnumber;

	@FindBy(xpath = "//button[@id='promotorGroup']//*[local-name()='svg']")
	WebElement search;

	@FindBy(xpath = "//button[@class='button ripple-effect btn btn-primary']")
	WebElement claimbtn;

	@FindBy(xpath = "//a[contains(text(),'Proceed')]")
	WebElement proceedbtn;

	@FindBy(xpath = "//input[@placeholder='Amount']")
	WebElement amount1;

	@FindBy(xpath = "//select[@id='currency0']//option")
	List<WebElement> currency1;

	@FindBy(xpath = "//input[@placeholder='FC Amount INR']")
	List<WebElement> convertedamt;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public CurrencyConversionPage() {
	}

	public CurrencyConversionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		return valueList;
	}

	public void fileclaimclick() {
		// wait.until(ExpectedConditions.elementToBeClickable(fileclaim));
		fileclaim.click();

	}

	public void readclaim() throws InterruptedException {
		//
		Thread.sleep(20000);
		// wait.until(ExpectedConditions.elementToBeClickable(readcliam));
		readcliam.click();
	}

	public void cinnumber(String cin1) {
		System.out.println(cin1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", cinnumber);
		//
		System.out.println(cin1);
		cinnumber.sendKeys(cin1);
		search.click();

	}

	public void claimbutton() {
		Point p = new Point(0, 3000);

		// Minimize the current window to the set position
		driver.manage().window().setPosition(p);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].scrollIntoView(true)", claimbtn);
		// wait.until(ExpectedConditions.elementToBeClickable(claimbtn));
		claimbtn.click();
	}

	public void proceedbutton() throws InterruptedException {

		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].scrollIntoView(true)", proceedbtn);
		// wait.until(ExpectedConditions.elementToBeClickable(claimbtn));
		proceedbtn.click();
	}

	public void amount(String serilano, String amount5, String currency, String contamt) throws InterruptedException {

		for (int i = 0; i <= serilano.length() - 1; i++) {
			amount1.clear();
			amount1.sendKeys(amount5);
			//System.out.println(amount5);
			
			if (currency != null) {
				System.out.println(currency);
				try {
					currency1.clear();
					for (WebElement option : currency1) {
						//System.out.println(option.getText().toString());
						if (currency.equalsIgnoreCase(option.getText()))
							option.click();
						///////////////////////////
						Currency.getInstance(option.getText().toString());
						System.out.println(option.getText().toString());
					
					}

				} catch (StaleElementReferenceException e) {
				}
			}
			convertedamt.clear();

			String act1 = driver.findElement(By.xpath("//td[10]//input[1]")).getAttribute("value");
			
			
			String excepted = contamt.toString();
			Assert.assertEquals(act1, excepted);

		}
	}

}
