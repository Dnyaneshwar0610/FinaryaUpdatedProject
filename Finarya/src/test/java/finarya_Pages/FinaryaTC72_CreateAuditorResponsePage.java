package finarya_Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC72_CreateAuditorResponsePage {
	WebDriver driver;

	public Finarya_AuditModulePage Audit;

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC72_CreateAuditorResponse.properties";

	public FinaryaTC72_CreateAuditorResponsePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	
	
	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	WebElement Usernametextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement Passwordtextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='js-login-btn']")
	WebElement loginbutton;
	
	@FindAll({ @FindBy(how = How.XPATH, using = " //*[@id='csi-dt-issues_filter']/label/input"),
		@FindBy(how = How.CSS, using = "#csi-dt-auditee-workbench_filter > label > input"), })
WebElement SearchCreateAuditorResponse;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tbody/tr[1]/td[2]"),
		@FindBy(how = How.CSS, using = "#csi-dt-issues > tbody > tr > td.sorting_1") })
WebElement auditresponseidvalidation;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tbody/tr[1]/td[1]/a"),
	@FindBy(how = How.CSS, using = "#csi-dt-issues > tbody > tr > td.sorting_1") })
WebElement responsebutton;

@FindBy(how = How.XPATH, using = "//div[@class='csi-panel-content']/ul")
WebElement Responsetab;

@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div[1]/div/button[2]")
WebElement clickonfullscreen;



@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[7]/div/div/div[2]/div[1]"),
	@FindBy(how = How.CSS, using = "#interimResponseField > div:nth-child(2) > div:nth-child(7) > div > div > div.jodit-workplace > div.jodit-wysiwyg") })
WebElement Auditorresponsetextbox;

@FindBy(how = How.XPATH, using = "//*[@id='issueCurrentStatus']")
WebElement Issuescurrentstatus; 

@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='auditeeEvidenceAttachment']"),
@FindBy(how = How.CSS, using ="#auditeeEvidenceAttachment")})
WebElement AuditorResponseEvidenceAttachment; 

@FindBy(how = How.XPATH, using = "//*[@id='select2-issueStatus-container'] ")
WebElement Issuesstatus; 

@FindAll({@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input"),
	@FindBy(how = How.CSS, using = "body > span > span > span.select2-search.select2-search--dropdown > input") })
WebElement  CommaninputSearchBox;

@FindAll({ @FindBy(how = How.XPATH, using = "//span[@class='select2-results']"),
	@FindBy(how = How.XPATH, using = "/html/body/span/span/span[2]"),
	@FindBy(how = How.CSS, using = "body > span > span > span.select2-results") })
List<WebElement> searchboxresultall;

@FindBy(how = How.XPATH, using = "//*[@id='issueClosureDate']")
WebElement IssueClosureDate;

@FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[4]/div/button")
WebElement SubmitAuditorResponseButton;
 
@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
WebElement popupmassage;
@FindBy(how = How.XPATH, using = "//div[@class='swal2-actions']/button[text()='OK']")
WebElement popupokbutton;
 


	public void auditorlogin() {
		loadpropertiesfile();
		Usernametextbox.clear();
		Usernametextbox.click();
		Usernametextbox.sendKeys(prop.readProperties("AuditeeUsername"));
		Passwordtextbox.clear();
		Passwordtextbox.click();
		Passwordtextbox.sendKeys(prop.readProperties("AuditeePassword"));
		loginbutton.click();
	}
	
	
	public void clickoncreateauditorresponse() throws Exception {
		Audit = new Finarya_AuditModulePage(driver);
		Thread.sleep(1000);
		Audit.ForwordArrow.click();
		Thread.sleep(1000);
		Audit.AuditMain.click();
		Thread.sleep(1000);
		Audit.AuditManagment.click();
		Thread.sleep(1000);
		Audit.AuditResponse.click();
		Thread.sleep(1000);
		Audit.CreateAuditResponse.click();
		Thread.sleep(1000);
		Audit.AuditorResponse.click();
		String URL = driver.getCurrentUrl();
		Reporter.log(URL);
		Reporter.log("System will open List Issues page and populates the List of the Issues .");
	}

	public void clickonauditorresponsebutton() throws Exception {
		Thread.sleep(1500);
		loadpropertiesfile();
		SearchCreateAuditorResponse.clear();
		SearchCreateAuditorResponse.click();
		SearchCreateAuditorResponse.sendKeys(prop.readProperties("ID"));
		String ExpectedResult = prop.readProperties("ID");
		System.out.println("Expected  ID Search IS" + ExpectedResult);
		Thread.sleep(1500);
		String AtualResult = auditresponseidvalidation.getText();
		System.out.println("Actual Aidit ID Search IS" + AtualResult);
		Thread.sleep(1000);
		if (AtualResult.equalsIgnoreCase(ExpectedResult)) {
			Thread.sleep(1500);
			responsebutton.click();
			String viewUrl = driver.getCurrentUrl();
			Reporter.log("After Click On Responce URL IS" + "  " + viewUrl);
			Thread.sleep(1000);
		    String Responstab =	Responsetab.getText();
			Reporter.log("System opens Auditor Response page with Tabs:" + "  " + Responstab);
			Assert.assertTrue(true);
			Reporter.log("Issues ID Are Matching");

		} else {
			Reporter.log("Issues ID Are not Not Matching");
			Assert.assertTrue(false);
			SearchCreateAuditorResponse.clear();

		}

	}

	
	public void clickonfullscreenbutton() throws Exception  {
		Thread.sleep(2000);
		clickonfullscreen.click();
	}
	
	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	public void senddataauditorresponse(String auditorresponse) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Auditorresponsetextbox));
		Auditorresponsetextbox.clear();
		Auditorresponsetextbox.click();
		Auditorresponsetextbox.sendKeys(auditorresponse);
	}
	

	public void clickonresponseauditorbrowsbutton() throws Exception {
		Thread.sleep(1000);
		boolean enable=AuditorResponseEvidenceAttachment.isEnabled();
		System.out.println("Response Evidance Attachment button"+""+enable);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(AuditorResponseEvidenceAttachment));
		//AuditorResponseEvidenceAttachment.sendKeys("C:\\Users\\CSI-Dev\\Downloads\\sample.pdf");
		Runtime.getRuntime().exec("X:\\AutoIT Test Script\\UploadFile.exe");
	}
	
	public void clickonresponseevidanceattacment() throws Exception {
			Thread.sleep(3000);
			
			StringSelection ss = new StringSelection("C:\\Users\\CSI-Dev\\Downloads\\sample.pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Reporter.log("System will open the path for file selection ");
			Reporter.log("The file can be seen attached"+" File Name Is" +AuditorResponseEvidenceAttachment.getText());
		}
	
	
	public void clickonissuescurrentstatus() {
       String currentstatus =  Issuescurrentstatus.getText();
       Reporter.log("Current Status Of Issues Is"+"  "+currentstatus);
	}
	
	

	
	public void clickonissuesstatus(String issuesstatusfiled) {
		Issuesstatus.click();
		CommaninputSearchBox.clear();
		CommaninputSearchBox.sendKeys(issuesstatusfiled);
		
	}
	public void clickonCommaninputSearchboxall() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("Issuesstatusselected")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}
	
	public void clickonissuesclouserdate() throws Exception {
		boolean issuesfield=IssueClosureDate.isEnabled();
		String issuesstatus=Issuesstatus.getText();
		System.out.println("Issues Status Is"+""+issuesstatus);
		if(issuesstatus.equalsIgnoreCase("Closed")) {
			clickonissuesdateclosure();
		}else {
			System.out.println("Issues Status Is Not Enable");
			Reporter.log("Issues Status Is"+"   "+issuesstatus);
		}
	
	
	}
	
	
	public void clickonissuesdateclosure() throws Exception {
		Thread.sleep(1500);
		loadpropertiesfile();
		IssueClosureDate.click();
		IssueClosureDate.clear();
		IssueClosureDate.sendKeys(prop.readProperties("issuesDateofClosureselect"));
		Thread.sleep(1500);
		IssueClosureDate.sendKeys(Keys.ENTER);
		
	}
	public void normalscrolldown() throws Exception {
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	

	public void clickonSubmitAuditorResponseButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitAuditorResponseButton));
		SubmitAuditorResponseButton.click();
		String popup=popupmassage.getText();
		Reporter.log("System displays a pop-up message ");
		Reporter.log(popup);
		popupokbutton.click();
		String URL =driver.getCurrentUrl();
		Reporter.log("After Click On OK Redirect To");
		Reporter.log(URL);
		
		
	}

}
