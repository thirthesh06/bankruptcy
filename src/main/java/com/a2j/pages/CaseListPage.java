package com.a2j.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CaseListPage {

	private WebDriver driver;
	//private WebDriverWait wait;
	@FindBy(xpath = "//span[contains(text(),'Case List')]")
	WebElement caselst;

	@FindBy(linkText = "Upload Order")
	WebElement upload;

	@FindBy(xpath = "//span[@class='filepond--label-action']")
	WebElement browsefile;

	@FindBy(xpath = "//select[@id='finalirp']//option")
	List<WebElement> confirmrp;

	@FindBy(xpath = "//button[contains(text(),'Upload NCLT Order')]")
	WebElement uploadnnclt;

	////////////////////////////////
	public CaseListPage() {
	}

	public CaseListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getFormDataValues() {
		List<String> valueList = driver.findElements(By.cssSelector("form > div > div > label")).stream()
				.map(e -> e.getText()).collect(Collectors.toList());
		System.out.println(valueList);
		return valueList;
	}

	public void caselistclick() {
		caselst.click();
	}

	/*
	 * public void clickByCaseId(String caseId) throws InterruptedException {
	 * Thread.sleep(2000); WebElement
	 * htmltable=driver.findElement(By.xpath("//*[@id='root']//table[1]/tbody"));
	 * List<WebElement> trList = htmltable.findElements(By.tagName("tr"));//
	 * (".table > tbody:nth-child(2) > tr> td")); //System.out.println(trList);
	 * 
	 * 
	 * trList.stream().map(d -> d.findElements(By.
	 * cssSelector(".table > tbody:nth-child(2) > tr > td:nth-child(1)"))).forEach(l
	 * -> {
	 * 
	 * if(l.get(0).getText().equalsIgnoreCase(caseId)) {
	 * System.out.println(l.toString()); l.get(9).click(); } });
	 * 
	 * for(int rnum=0;rnum<trList.size();rnum++) { List<WebElement>
	 * columns=trList.get(rnum).findElements(By.
	 * cssSelector(".table > tbody:nth-child(2) > tr > td:nth-child(1)"));
	 * //System.out.println("Number of columns:"+columns.size());
	 * 
	 * for(int cnum=0;cnum<columns.size();cnum++) {
	 * //System.out.println(columns.get(cnum).getText());
	 * if(columns.get(cnum).getText().equalsIgnoreCase(caseId)) {
	 * //System.out.println(columns.get(cnum).getText()); Thread.sleep(2000);
	 * columns.get(cnum).click(); System.out.println(columns.get(cnum).getText());
	 * Thread.sleep(2000); } else { System.out.println("caseid dont match"); break;
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	//a[@class='tg-btnmakeanoffer']
	/////////////////////////////////////////////////////// try////////////////////////////////////////
	public void clickByCaseId(String caseId) throws InterruptedException {
		Thread.sleep(2000);
		
		List<WebElement> allRows = driver.findElements(By.cssSelector(".table > tbody:nth-child(2) > tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> datas = allRows.get(i).findElements(By.tagName("td"));
			if (datas.get(0).getText().equalsIgnoreCase(caseId)) {
				// System.out.println(columns.get(cnum).getText());
				System.out.println("FOUND");
				//Thread.sleep(2000);
				// WebElement setup = datas.get(9);
				WebElement setup = driver.findElement(By.xpath("//td[text()='" + datas.get(0).getText()
						+ "']//following-sibling::td//a[@class='tg-btnmakeanoffer']"));
				//wait.until(ExpectedConditions.elementToBeClickable(setup));
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

	/////////////////////////////////////////////////////////////////////////////////////////////////

	public void uploadfile() {
		/*
		 * WebElement element = driver.findElement(By.partialLinkText("Upload Ord"));
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", element);
		 */
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Upload Ord")).click();
		// upload.click();
	}

	public void browsefile() throws InterruptedException {

		browsefile.click();
		Thread.sleep(2000);
	}
	/*
	 * public void confrp(String conrp) { //role.sendKeys(role1);
	 * wait.until(ExpectedConditions.elementToBeClickable(confirmrp)); Select select
	 * = new Select(confirmrp); select.selectByVisibleText(conrp); }
	 */

	public void confrp(String conrp) {
		if (conrp != null) {
			try {

				for (WebElement option : confirmrp) {
					System.out.println(option.getText().toString());
					if (conrp.equals(option.getText()))
						option.click();

				}

			} catch (StaleElementReferenceException e) {
			}
		}
	}

	public void uploadbtnnclt() {
		uploadnnclt.click();
	}

}
