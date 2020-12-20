package com.a2j.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RpMyCasesPage {
	private boolean isChecked;
	// private WebElement e;
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'My Cases')]")
	WebElement mycases;

	@FindBy(xpath = "//tr//td[contains(text(),'INSOLVO_Test123r')]")
	WebElement caseid;

	@FindBy(xpath = "//tr[3]//td[9]//a[1]//button[1]")
	WebElement setup;

	@FindBy(xpath = "//input[@id='NormalMode']")
	WebElement casemode;

	@FindBy(xpath = "//input[@class='btn btn-hm w-25']")
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

	@FindBy(xpath = "//nav[@class='nav']//span[contains(text(),'Form A')]")
	WebElement formA;

	@FindBy(xpath = "//span[@class='btn btn-info']")
	WebElement formAedit;

	@FindBy(xpath = "//input[@id='corporateDebtorAddress']")
	WebElement regaddress;

	@FindBy(xpath = "//input[@id='cdPrincialOfficeAddress']")
	WebElement principaladdress;

	//

	@FindBy(xpath = "//span[contains(text(),'Publish and Advertise')]")
	WebElement publish;

	@FindBy(xpath = "//select[@class='form-control']//option")
	List<WebElement> statelist;

	@FindBy(xpath = "//label[contains(text(),'Times Of India')]")
	WebElement publishwebsite;

	@FindBy(xpath = "//input[@id='insolvencyCommencementStartDate']")
	WebElement insovencydate;

	@FindBy(xpath = "//input[@id='insolvencyCommencementEstimatedEndDate']")
	WebElement insovencyendate;

	@FindBy(xpath = "//input[@id='irpname']")
	WebElement namerp;

	@FindBy(xpath = "//input[@id='irpregistrationNumber']")
	WebElement regnorp;

	@FindBy(xpath = "//input[@id='irpregisteredAddress']")
	WebElement irpregaddress;

	@FindBy(xpath = "//input[@id='irpregisteredEmail']")
	WebElement irpregemail;

	@FindBy(xpath = "//input[@id='irpcorrespondenceEmail']")
	WebElement irpcorrpoemail;

	@FindBy(xpath = "//input[@id='irpcorrespondenceAddress']")
	WebElement irpcorrospoaddress;

	@FindBy(xpath = "//table[@class='table table-bordered text-left table-font-style']//input[@id='claimEndDate']")
	WebElement claimlastdate;

	@FindBy(xpath = "//input[@id='classesOfCreditors']")
	WebElement nameclass;

	@FindBy(xpath = "//textarea[@id='firstNameForClass']")
	WebElement nameclass1;
	
	@FindBy(xpath = "//textarea[@id='secondNameForClass']")
	WebElement nameclass2;
	
	@FindBy(xpath = "//textarea[@id='thirdNameForClass']")
	WebElement nameclass3;

	@FindBy(xpath = "//textarea[@id='webLink']")
	WebElement web;

	@FindBy(xpath = "//textarea[@id='physicalAddress']")
	WebElement webaddress;
	

	@FindBy(xpath = "//input[@id='rpsignature']")
	WebElement signature;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement saveformA;
	
	@FindBy(xpath="//span[contains(text(),'Download Form A')]")
	WebElement downloadformA;
	
	@FindBy(xpath="//button[contains(text(),'+')]")
	WebElement plus;
	
	
	@FindBy(xpath="//label[contains(text(),'Publish on corporate debtor website')]")
	WebElement publishcdchkbx;
	
	@FindBy(xpath="//input[@placeholder='CD Support Email']")
	WebElement supportemail;
	
	@FindBy(xpath="//input[@placeholder='CD Website']")
	WebElement supportcdsite;
	
	@FindBy(xpath="//input[@id='DatePicker']")
	WebElement publishdate;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Subject']")
	WebElement emailsubject;
	
	@FindBy(xpath="//textarea[@placeholder='Enter email body']")
	WebElement emailbody;
	
	
	@FindBy(xpath = "//select[@name='fileType']//option")
	List<WebElement> fromlist;
	
	
	@FindBy(xpath="//button[contains(text(),'Send Email')]")
	WebElement sendemailbtn;
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public RpMyCasesPage() {
	}

	public RpMyCasesPage(WebDriver driver) {
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

	public void casemode() {

		casemode.click();
		/*
		 * String URL = driver.getCurrentUrl(); Assert.assertEquals(URL, "" );
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
	 * trList = All the tr's (table rows) as a list findElements(TBODY > TR) loop
	 * thru trList save in tdList = tr.findElelments(td xpath) WebElelemnt checkbox
	 * = tdList.get(2) checkverifybox(checkbox)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void clickByCaseId(String caseId) throws InterruptedException {
		Thread.sleep(2000);
		// WebElement htmltable =
		// driver.findElement(By.xpath("//*[@id='root']//table[1]/tbody"));
		// List<WebElement> trList = htmltable.findElements(By.tagName("tr"));//
		// (".table > tbody:nth-child(2) > tr> td"));
		// System.out.println(trList);

		// for (int rnum = 0; rnum < trList.size(); rnum++) {
		List<WebElement> allRows = driver.findElements(By.cssSelector(".table > tbody:nth-child(2) > tr"));
		// System.out.println("Number of columns:"+columns.size());

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> datas = allRows.get(i).findElements(By.tagName("td"));
			if (datas.get(0).getText().equalsIgnoreCase(caseId)) {
				// System.out.println(columns.get(cnum).getText());
				System.out.println("FOUND");
				Thread.sleep(2000);
				// WebElement setup = datas.get(9);
				WebElement setup = driver.findElement(By.xpath("//td[text()='" + datas.get(0).getText()
						+ "']/following-sibling::td/a/button[text()='Setup']"));
				wait.until(ExpectedConditions.elementToBeClickable(setup));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", setup);
				// setup.findElement(By.xpath("(//a/button[text()='Setup'])["+(i+1)+"]")).click();
				Thread.sleep(2000);
				setup.click();
				break;
			} else {
				System.out.println("caseid dont match");
			}
			// System.out.println(columns.get(cnum).getText());

		}

//		}

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
		// Thread.sleep(2000);
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

	// launch vdr
	public void vdr() {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", vdrnxt);
		 */
		wait.until(ExpectedConditions.elementToBeClickable(vdrlaunch));
		vdrlaunch.click();
	}

	// starting of vdr page
	// Form A

	public void formA() {
		wait.until(ExpectedConditions.elementToBeClickable(formA));
		formA.click();
	}

	public void formAedit() {

		wait.until(ExpectedConditions.elementToBeClickable(formAedit));
		// Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", formAedit);
		formAedit.click();
	}

	public void registeraddress(String registeraddress) {
		regaddress.clear();
		regaddress.sendKeys(registeraddress);
	}

	public void principaladdress(String phyaddress) {
		principaladdress.clear();
		principaladdress.sendKeys(phyaddress);
	}

	public void insolvencydate(String date) {
		insovencydate.clear();
		insovencydate.sendKeys(date);
	}

	public void insolvencyenddate(String enddate) {
		insovencyendate.clear();
		insovencyendate.sendKeys(enddate);
	}

	public void rpname(String rpname) {
		namerp.clear();
		namerp.sendKeys(rpname);
	}

	public void regnorp(String rpno) {
		regnorp.clear();
		regnorp.sendKeys(rpno);
	}

	public void irpregaddress(String irpaddress) {
		irpregaddress.clear();
		irpregaddress.sendKeys(irpaddress);
	}

	public void irpemail(String irpemail) {
		irpregemail.clear();
		irpregemail.sendKeys(irpemail);
	}

	public void irpcorremail(String irpcorremail) {
		irpcorrpoemail.clear();
		irpcorrpoemail.sendKeys(irpcorremail);
	}

	public void irpcorrsaddress(String crossaddress) {
		irpcorrospoaddress.clear();
		irpcorrospoaddress.sendKeys(crossaddress);
	}

	public void ltclaimsubdate(String lstdate) {
		claimlastdate.clear();
		claimlastdate.sendKeys(lstdate);
	}

	public void nameclass(String classname) {
		nameclass.clear();
		nameclass.sendKeys(classname);
	}

	public void nameclasss(String classname1, String classname2, String classname3) {
		
		nameclass1.clear();
		nameclass2.clear();
		nameclass3.clear();
		nameclass1.sendKeys(classname1);
		nameclass2.sendKeys(classname2);
		nameclass3.sendKeys(classname3);
	}

	public void weblink(String web1) {
		web.clear();
		web.sendKeys(web1);

	}

	public void webaddress(String webaddress1) {
		webaddress.clear();
		webaddress.sendKeys(webaddress1);

	}
	public void signatureforma(String signatre) {
		signature.clear();
		signature.sendKeys(signatre);
	}
	
	public void saveform() {
		saveformA.click();
	}
   public void downloadformA(){
	   wait.until(ExpectedConditions.elementToBeClickable(downloadformA));
	   downloadformA.click();
   }
	//////////////////////////////////// publish and advertise/////////////////////
	public void publish() {
		wait.until(ExpectedConditions.elementToBeClickable(publish));
		publish.click();
	}

	public void pubstate(String state) {
		if (state != null) {
			try {

				for (WebElement option : statelist) {
					System.out.println(option.getText().toString());
					if (state.equals(option.getText()))
						option.click();
					

				}
				
			} catch (StaleElementReferenceException e) {
			}
		}
	}

	private By getPaperXpath(String paperName) {
		return By.xpath("//label[contains(text(),'" + paperName + "')]");
	}

	public void pubcdwebsite(String paperName) {
		if (!paperName.equals(null)) {
			By publishwebsiteBy = getPaperXpath(paperName);
			WebElement publishwebsite = driver.findElement(publishwebsiteBy);
			publishwebsite.click();
			wait.until(ExpectedConditions.elementToBeClickable(publishwebsite));
			isChecked = publishwebsite.isSelected();
			
			
		}
		
	}

	public void clickOnPlus(String value) {
		if (value.equalsIgnoreCase("yes")) {
		   plus.click();
		   
		}
	}
	
	public void pubcdsitechkbx() {
		wait.until(ExpectedConditions.elementToBeClickable(publishcdchkbx));
		publishcdchkbx.click();
	}
	public void supportemail(String semail) {
		supportemail.clear();
		supportemail.sendKeys(semail);
	}
	public void supportsite(String ssite) {
		supportcdsite.clear();
		supportcdsite.sendKeys(ssite);
	}
	
	public void pubdate(String pdate) {
		publishdate.clear();
		publishdate.sendKeys(pdate);
	}
	
	public void emailsub(String esub) {
		emailsubject.clear();
		emailsubject.sendKeys(esub);
	}
	public void emailbody(String ebody) {
		emailbody.clear();
		emailbody.sendKeys(ebody);
	}
	
	public void formselection(String forms) {
		if (forms != null) {
			try {

				for (WebElement option : fromlist) {
					System.out.println(option.getText().toString());
					if (forms.equals(option.getText()))
						option.click();
					

				}
				
			} catch (StaleElementReferenceException e) {
			}
		}
	}
	public void sendemail() {
		sendemailbtn.click();
	}
	
}
