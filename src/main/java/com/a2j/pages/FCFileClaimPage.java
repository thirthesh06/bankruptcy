package com.a2j.pages;

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
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FCFileClaimPage {
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//private WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'File Claim')]")
	WebElement fileclaim;
///#root > div > div > div > div.dashboard-main.dashboard-haslayout > div > div > div.row.mt-3.mb-5 > div:nth-child(1) > a > div > span:nth-child(2)
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

	@FindBy(xpath = "//input[@id='totalAmountClaim']")
	WebElement totalcliamamount;

	@FindBy(xpath = "//textarea[@id='substantiatedDocumentsOfDebt']")
	WebElement documentreference;

	@FindBy(xpath = "//input[@id='howDebtIncurred']")
	WebElement debtIncurred;

	@FindBy(xpath = "//input[@id='whenDebtIncurredStartDate']")
	WebElement debincurdate;

	@FindBy(xpath = "//textarea[@id='detailsOfMutualCredit']")
	WebElement mutualcredit;

	@FindBy(xpath = "//textarea[@id='detailsOfSecurityHeld']")
	WebElement securityheld;

	@FindBy(xpath = "//input[@id='bankName']")
	WebElement bankname;

	@FindBy(xpath = "//input[@id='accountNumber']")
	WebElement aacno;

	@FindBy(xpath = "//input[@id='ifscCode']")
	WebElement ifsc;

	@FindBy(xpath = "//textarea[@id='proofOfClaim']")
	WebElement proof;

	@FindBy(xpath = "//input[@id='authorisedPerson']")
	WebElement signature;

	@FindBy(xpath = "//label[contains(text(),'Name in BLOCK LETTERS:')]")
	WebElement blkname;

	@FindBy(xpath = "//input[@id='relationWithCreditor']")
	WebElement relationcreditor;

	@FindBy(xpath = "//textarea[@id='addressOfAuthorisePerson']")
	WebElement authorizedperson;

	@FindBy(xpath = "//div[@class='text-left']//input[@id='indebtedYear']")
	WebElement debtyear;

	@FindBy(xpath = "//input[@id='indebtedAmount']")
	WebElement amtcliam;

	@FindBy(xpath = "//textarea[@id='listOfDocumentsEvidenceOfClaim']")
	WebElement listdocument;

	@FindBy(xpath = "//textarea[@id='detailsOfMutualDealings']")
	WebElement detailsmutualfund;

	@FindBy(xpath = "//div[13]//input[1]")
	WebElement deponentssignature;

	@FindBy(xpath = "//input[@id='contentStart']")
	WebElement verifystartnum;

	@FindBy(xpath = "//input[@id='contentEnd']")
	WebElement verifyendnum;

	@FindBy(xpath = "//input[@id='place']")
	WebElement verifyplace;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitbtn;

	@FindBy(xpath = "//a[contains(text(),'Proceed')]")
	WebElement proceedbtn;

	@FindBy(xpath = "//input[@name='Date']")
	WebElement clmdate;

	@FindBy(xpath = "//input[@placeholder='FC Type']")
	WebElement fctype1;

	@FindBy(xpath = "//input[@placeholder='FC Name']")
	WebElement fcname1;

	@FindBy(xpath = "//input[@placeholder='Location']")
	WebElement location1;

	@FindBy(xpath = "//input[@placeholder='Transaction Nature']")
	WebElement Financial;

	@FindBy(xpath = "//input[@placeholder='Transaction Instrument']")
	WebElement Instrument;

	@FindBy(xpath = "//input[@placeholder='Document ID']")
	WebElement documentid;

	@FindBy(xpath = "//input[@placeholder='Amount']")
	WebElement amount1;

	@FindBy(xpath = "//select[@id='currency0']//option")
	List<WebElement> currency1;

	@FindBy(xpath = "//input[@placeholder='FC Amount INR']")
	List<WebElement> convertedamt;

	@FindBy(xpath = "//button[contains(text(),'Save Details')]")
	WebElement savedetails;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitclm;

	@FindBy(xpath = "//button[@class='btn'][contains(text(),'Submit')]")
	WebElement confirmsubbtn;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public FCFileClaimPage() {
	}

	public FCFileClaimPage(WebDriver driver) {
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
		Thread.sleep(2000);
		// wait.until(ExpectedConditions.elementToBeClickable(readcliam));
		readcliam.click();
	}

	public void cinnumber(String cin1) {
		//System.out.println(cin1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", cinnumber);
		//
		//System.out.println(cin1);
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

	public void totalcliamamount(String totalclmamt) throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(2000);
		totalcliamamount.clear();
		totalcliamamount.sendKeys(totalclmamt);

	}

	public void documentreference(String docref) {
		documentreference.clear();
		documentreference.isEnabled();
		documentreference.sendKeys(docref);
	}

	public void debincured(String debincurd) {
		debtIncurred.clear();
		debtIncurred.isEnabled();
		debtIncurred.sendKeys(debincurd);
	}

	public void dbstartdate(String dbindate) {
		debincurdate.clear();
		debincurdate.isEnabled();
		debincurdate.sendKeys(dbindate);
	}

	public void mutualcredit(String mutual) {
		mutualcredit.clear();
		mutualcredit.isEnabled();
		mutualcredit.sendKeys(mutual);

	}

	public void Detailsofsecurityheld(String security) {
		securityheld.clear();
		securityheld.isEnabled();
		securityheld.sendKeys(security);

	}

	public void bankname(String bkname) {
		bankname.clear();
		bankname.isEnabled();
		bankname.sendKeys(bkname);

	}

	public void accno(String accnumber) {
		aacno.clear();
		aacno.isEnabled();
		aacno.sendKeys(accnumber);

	}

	public void ifsc(String ifsccode) {
		ifsc.clear();
		ifsc.isEnabled();
		ifsc.sendKeys(ifsccode);

	}

	public void proofofcliam(String proofofcliam) {
		proof.clear();
		proof.isEnabled();
		proof.sendKeys(proofofcliam);
	}

	public void signature(String sign) {
		signature.clear();
		signature.isEnabled();
		signature.sendKeys(sign);

	}

	public void nameblockletter(String blkletter) {
		blkname.clear();
		blkname.isEnabled();
		blkname.sendKeys(blkletter);
	}

	public void relationcreditor(String rcrditor) {
		relationcreditor.clear();
		relationcreditor.isEnabled();
		relationcreditor.sendKeys(rcrditor);
	}

	public void authorizedperson(String autorized) {
		authorizedperson.clear();
		authorizedperson.isEnabled();
		authorizedperson.sendKeys(autorized);
	}

	public void declarationdate(String date) {
		Select startdate = new Select(
				driver.findElement(By.xpath("//div[@class='text-left']//select[@id='indebtedDate']//select")));
		startdate.selectByVisibleText(date);
		System.out.println(date);

	}

	public void indebtyear(String year) {
		debtyear.clear();
		debtyear.isEnabled();
		debtyear.sendKeys(year);

	}

	public void amountofclaim(String claimamt) {
		amtcliam.clear();
		amtcliam.isEnabled();
		amtcliam.sendKeys(claimamt);
	}

	public void listofdocument(String listdoc) {
		listdocument.clear();
		listdocument.isEnabled();
		listdocument.sendKeys(listdoc);

	}

	public void detailsofmutualfund(String detailsmutual) {
		detailsmutualfund.clear();
		detailsmutualfund.isEnabled();
		detailsmutualfund.sendKeys(detailsmutual);

	}

	public void deponentssignature(String deponentssign) {
		deponentssignature.clear();
		deponentssignature.isEnabled();
		deponentssignature.sendKeys(deponentssign);

	}

	public void verificationstart(String startnum) {
		verifystartnum.clear();
		verifystartnum.isEnabled();
		verifystartnum.sendKeys(startnum);
	}

	public void verificationend(String endnum) {
		verifyendnum.clear();
		verifyendnum.isEnabled();
		verifyendnum.sendKeys(endnum);
	}

	public void veriyplace(String place) {
		verifyplace.clear();
		verifyplace.isEnabled();
		verifyplace.sendKeys(place);

	}

	public void submitbutton() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].scrollIntoView(true)", submitbtn);
		// wait.until(ExpectedConditions.elementToBeClickable(claimbtn));
		submitbtn.click();
	}

	public void proceedbutton() throws InterruptedException {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].scrollIntoView(true)", proceedbtn);
		// wait.until(ExpectedConditions.elementToBeClickable(claimbtn));
		proceedbtn.click();
	}

	public void claimdata(String date, String fctype, String fcname, String location, String finanacical, String ift,
			String Documentid, String amount5, String currency, String contamt) throws InterruptedException {

		// for (int i = 0; i <= fctype.length() - 1; i++) {

		clmdate.clear();
		clmdate.sendKeys(date);

		fctype1.clear();
		fctype1.isEnabled();
		fctype1.sendKeys(fctype);

		fcname1.clear();
		fcname1.isEnabled();
		fcname1.sendKeys(fcname);

		location1.clear();
		location1.isEnabled();
		location1.sendKeys(location);

		Financial.clear();
		Financial.isEnabled();
		Financial.sendKeys(finanacical);

		Instrument.clear();
		Instrument.isEnabled();
		Instrument.sendKeys(ift);

		documentid.clear();
		documentid.isEnabled();
		documentid.sendKeys(Documentid);

		amount1.clear();
		amount1.isEnabled();
		amount1.sendKeys(amount5);
		// System.out.println(amount5);

		if (currency != null) {
			// System.out.println(currency);
			try {
				currency1.clear();
				for (WebElement option : currency1) {
					// System.out.println(option.getText().toString());
					if (currency.equalsIgnoreCase(option.getText()))
						option.click();
					break;
					///////////////////////////
					// Currency.getInstance(option.getText().toString());
					/// System.out.println(option.getText().toString());

				}

			} catch (StaleElementReferenceException e) {
			}
		}
		convertedamt.clear();

		String act1 = driver.findElement(By.xpath("//td[10]//input[1]")).getAttribute("value");

		String excepted = contamt.toString();
		Assert.assertEquals(act1, excepted);

	}

	public void savedetails() {
		savedetails.click();
	}

	public void submitclmbtn() {
		submitclm.click();
	}

	public void confirmbtn() {
		driver.switchTo().activeElement().findElement(By.xpath("//button[@class='btn'][contains(text(),'Submit')]"))
				.click();
		// confirmsubbtn.click();
	}

}

//}
