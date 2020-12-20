package com.a2j.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RpFastTrackPage {
	
	private boolean isChecked;
	//private WebElement e;
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'My Cases')]")
	WebElement mycases;

	@FindBy(xpath = "//tr//td[contains(text(),'INSOLVO_Test123r')]")
	WebElement caseid;

	@FindBy(xpath = "//tr[3]//td[9]//a[1]//button[1]")
	WebElement setup;

	@FindBy(xpath = "//input[@id='fastTrack']")
	WebElement ftcasemode;
	
	@FindBy(xpath="//input[@class='btn btn-hm w-25']")
WebElement saveprofile;	
	
	@FindBy(css = "tbody > tr:nth-child(1) > td:nth-child(3) > input")
	WebElement checkBoxElement;
	
	@FindBy(xpath = "//button[@class='btn btn-hm']")
	WebElement nxtbtn;

	@FindBy(css = "#root > div > div > div.dashboard-main.dashboard-haslayout > div > div > div > div.col-sm-12 > div.row.mt-3.mb-5 > div.col-md-2 > button")
	WebElement vdrnxt;
	
	@FindBy(xpath = "//button[contains(text(),'SAVE')]")
	WebElement save;
	
	@FindBy(xpath = "//button[contains(text(),'LAUNCH VDR')]")
	WebElement vdrlaunch;
	
	
	public RpFastTrackPage() {
	}

	public RpFastTrackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		return valueList;
	}

	public void mycasesclick() {
		mycases.click();
	}

	public void caseid(String caseid1) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(700,700)");
		caseid.sendKeys(caseid1);
	}

	public void setup() {
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("window.scrollBy(500,0)");
		 */
		wait.until(ExpectedConditions.elementToBeClickable(setup));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", setup);

		setup.click();
	}
     //fasttrack mode
	public void casemode() {

		ftcasemode.click();
		/*
		 * String URL = driver.getCurrentUrl(); Assert.assertEquals(URL,
		 * ""
		 * );
		 */
	}
	
	public void saveprofile() {
		saveprofile.click();
		/*
		 * String URL = driver.getCurrentUrl(); Assert.assertEquals(URL,
		 * "http://stg-solvendo.s3-website.ap-south-1.amazonaws.com/profile/creditor/fc"
		 * );
		 */
	}
	
	public void checkboxverify() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxElement));
		String attr = checkBoxElement.getAttribute("checked");
		Assert.assertEquals(Boolean.parseBoolean(attr), true);
		isChecked = checkBoxElement.isSelected();
	}
	
	
	/*
	 * trList = All the tr's (table rows) as a list findElements(TBODY > TR)
	 * loop thru trList
	 * 		save in tdList = tr.findElelments(td xpath)
	 * 		WebElelemnt checkbox = tdList.get(2)
	 * 		checkverifybox(checkbox) 
	 * 
	 * 
	 * 
	 * 
	 * 
}
	 */
	
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
	
	
	
	public void checkboxverify(WebElement e) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> e1 = driver.findElements(By.xpath("//tbody//tr//td"));
		// System.out.println(e1.get(0).getText());
		for (int i = 0; i <= e1.size(); i++) {
			System.out.println(e1.get(i).getText()); // System.out.println(e1); WebElement
			checkBoxElement = driver.findElement(By.xpath("//tbody//tr//td"));
			System.out.println(checkBoxElement.getText().toString()); // String attr =
			checkBoxElement.getAttribute("checked");

			//// Assert.assertEquals(Boolean.parseBoolean(attr), true);
			// e1.get(i).click(); //System.out.println(e);
		}
	}
	 
	
	// usermanagement
	public void nextbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", nxtbtn);
		nxtbtn.click();
	}
	// vdr setup
	public void vdrnext() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(vdrnxt));
		//Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", vdrnxt);
		vdrnxt.click();
	}
	public void save() {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", vdrnxt);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
	}
	
	//launch vdr
	public void vdr() {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", vdrnxt);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(vdrlaunch));
		vdrlaunch.click();
	}

}
