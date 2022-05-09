package finarya_Pages;

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

public class FinaryaTC71_CreateAuditeeResponsePage {
	
	WebDriver driver;

	public Finarya_AuditModulePage Audit;

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC71_CreateAuditeeResponse.properties";

	public FinaryaTC71_CreateAuditeeResponsePage(WebDriver driver) {
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
WebElement SearchCreateAuditeeResponse;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tbody/tr[1]/td[2]"),
		@FindBy(how = How.CSS, using = "#csi-dt-issues > tbody > tr > td.sorting_1") })
WebElement auditresponseidvalidation;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tbody/tr[1]/td[1]/a"),
	@FindBy(how = How.CSS, using = "#csi-dt-issues > tbody > tr > td.sorting_1") })
WebElement responsebutton;

@FindBy(how = How.XPATH, using = "//div[@class='csi-panel-content']/ul")
WebElement Responsetab;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[7]/div/div/div[2]/div[1]"),
	@FindBy(how = How.CSS, using = "#interimResponseField > div:nth-child(2) > div:nth-child(7) > div > div > div.jodit-workplace > div.jodit-wysiwyg") })
WebElement issuesresponsetextbox;

@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[8]/div/div/div[2]/div[1]"),
	@FindBy(how = How.CSS, using = "#interimResponseField > div:nth-child(2) > div:nth-child(8) > div > div > div.jodit-workplace > div.jodit-wysiwyg") })
WebElement ReasonforDelaytextbox;

@FindBy(how = How.XPATH, using = "//*[@id='proposedDateofClosure']")
WebElement ExpectedDateofClosure; 

@FindAll({@FindBy(how = How.XPATH, using = "//*[@id='responseEvidenceAttachment']"),
@FindBy(how = How.CSS, using ="#responseEvidenceAttachment")})
WebElement ResponseEvidenceAttachment; 

@FindBy(how = How.XPATH, using = "//*[@id='select2-isRcaRequired-container'] ")
WebElement RCARequired; 

@FindAll({@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input"),
	@FindBy(how = How.CSS, using = "body > span > span > span.select2-search.select2-search--dropdown > input") })
WebElement  CommaninputSearchBox;

@FindAll({ @FindBy(how = How.XPATH, using = "//span[@class='select2-results']"),
	@FindBy(how = How.XPATH, using = "/html/body/span/span/span[2]"),
	@FindBy(how = How.CSS, using = "body > span > span > span.select2-results") })
List<WebElement> searchboxresultall;

@FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[14]/div/span/span[1]/span/ul/li/input ")
WebElement Responsible; 
@FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[15]/div/span/span[1]/span")
WebElement Accountable; 
@FindBy(how = How.XPATH, using = "//*[@id='interimResponseField']/div[2]/div[16]/div/span/span[1]/span/ul/li/input")
WebElement Consulted; 
@FindBy(how = How.XPATH, using = "//*[@id=\"interimResponseField\"]/div[2]/div[17]/div/span/span[1]/span/ul/li/input")
WebElement Informed; 

@FindBy(how = How.XPATH, using = "//*[@id='submitResponseBtn']")
WebElement SubmitAuditeeResponseButton;
 
@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
WebElement popupmassage;
@FindBy(how = How.XPATH, using = "//div[@class='swal2-actions']/button[text()='OK']")
WebElement popupokbutton;
 


	public void auditeelogin() {
		loadpropertiesfile();
		Usernametextbox.clear();
		Usernametextbox.click();
		Usernametextbox.sendKeys(prop.readProperties("AuditeeUsername"));
		Passwordtextbox.clear();
		Passwordtextbox.click();
		Passwordtextbox.sendKeys(prop.readProperties("AuditeePassword"));
		loginbutton.click();
	}
	
	
	public void clickoncreateauditeeresponse() throws Exception {
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
		Audit.AuditeeResponse.click();
		String URL = driver.getCurrentUrl();
		Reporter.log(URL);
		Reporter.log("System will open List Issues page and populates the List of the Issues .");
	}

	public void clickonauditeeresponsebutton() throws Exception {
		Thread.sleep(1500);
		loadpropertiesfile();
		SearchCreateAuditeeResponse.clear();
		SearchCreateAuditeeResponse.click();
		SearchCreateAuditeeResponse.sendKeys(prop.readProperties("ID"));
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
			Reporter.log("System opens Auditee Response page with Tabs:" + "  " + Responstab);
			Assert.assertTrue(true);
			Reporter.log("Issues ID Are Matching");

		} else {
			Reporter.log("Issues ID Are not Not Matching");
			Assert.assertTrue(false);
			SearchCreateAuditeeResponse.clear();

		}

	}

	
	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		 jse.executeScript("window.scrollBy(0,300)","");
	}
	
	
	public void senddataissueresponse(String issuesresponse) {
		issuesresponsetextbox.clear();
		issuesresponsetextbox.click();
		issuesresponsetextbox.sendKeys(issuesresponse);
	}
	
	
	public void senddatareasonfordelay(String DelayReason) throws Exception {
		Thread.sleep(1000);
		ReasonforDelaytextbox.clear();
		ReasonforDelaytextbox.click();
		ReasonforDelaytextbox.sendKeys(DelayReason);
	}
	
	public void clickonexpecteddateclosure() throws Exception {
		Thread.sleep(1500);
		loadpropertiesfile();
		ExpectedDateofClosure.click();
		ExpectedDateofClosure.clear();
		ExpectedDateofClosure.sendKeys(prop.readProperties("ExpectedDateofClosureselect"));
		Thread.sleep(1500);
		ExpectedDateofClosure.sendKeys(Keys.ENTER);
		
	}
	
	public void clickonresponseevidancebutton() throws Exception {
		Thread.sleep(1000);
		boolean enable=ResponseEvidenceAttachment.isEnabled();
		System.out.println("Response Evidance Attachment button"+""+enable);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ResponseEvidenceAttachment));
		ResponseEvidenceAttachment.sendKeys("C:\\Users\\CSI-Dev\\Downloads\\sample.pdf");
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
			Reporter.log("The file can be seen attached"+" File Name Is" +ResponseEvidenceAttachment.getText());
		}
	
	public void clickonRCARequired(String RCARequiredFields) {
		RCARequired.click();
		CommaninputSearchBox.clear();
		CommaninputSearchBox.sendKeys(RCARequiredFields);
		
	}
	public void clickonCommaninputSearchboxall() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("RCARequired")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}
	
	
	public void clickonResponsible(String AuditeeResponsible) {
		Responsible.click();
		Responsible.clear();
		Responsible.sendKeys(AuditeeResponsible);
		
	}
	public void clickonsearchResposible() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("ResponsibleSelect")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}
	
	
	public void clickonAccountable(String AuditeeAccountable) {
		Accountable.click();
		CommaninputSearchBox.clear();
		CommaninputSearchBox.sendKeys(AuditeeAccountable);
		
	}
	public void clickonsearchboxAuditeeAccountable() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("AccountableSelect")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}
	
	
	public void clickonConsulted(String AuditeeConsulted) {
		Consulted.click();
		Consulted.clear();
		Consulted.sendKeys(AuditeeConsulted);
		
	}
	public void clickonSerachAuditeeConsulted() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("ConsultedSelect")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}
	
	public void clickonInformed(String AuditeeInformed) {
		Informed.click();
		Informed.clear();
		Informed.sendKeys(AuditeeInformed);
		
	}
	public void clickonSerchInformed() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("InformedSelect")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonSubmitAuditeeResponseButton() {
		SubmitAuditeeResponseButton.click();
		String popup=popupmassage.getText();
		Reporter.log("System displays a pop-up message ");
		Reporter.log(popup);
		popupokbutton.click();
		String URL =driver.getCurrentUrl();
		Reporter.log("After Click On OK Redirect To");
		Reporter.log(URL);
		
		
	}

}
