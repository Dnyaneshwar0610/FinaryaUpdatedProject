package finarya_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC37_AuditorWorkbenchPage {
	WebDriver driver;

	public Finarya_AuditModulePage Audit;

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC37_AuditorWorkbench.properties";

	public  FinaryaTC37_AuditorWorkbenchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-auditor-workbench_filter']/label/input"),
			@FindBy(how = How.CSS, using = "#csi-dt-auditor-workbench_filter > label > input"), })
	WebElement SearchListAuditorWorkbench;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-auditor-workbench']/tbody/tr[1]/td[1]/a[2]"),
			@FindBy(how = How.CSS, using = "#csi-dt-auditor-workbench > tbody > tr:nth-child(1) > td.sorting_1.dtr-control > a:nth-child(2)") })
	WebElement auditorworkbenchicon;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-auditor-workbench']/tbody/tr[1]/td[2]")
	WebElement Validatiomauditid;

	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li")
	List<WebElement> expectedtab;
	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li/a[text()='Checklist']")
	WebElement checklisttab;
	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li/a[text()='Samples Download']")
	WebElement sampledownloadtab;
	
	//comments tab
	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li/a[text()='Comments']")
	WebElement commentstab;
		
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='defaultidform']/div/div[2]/div/div/div[2]/div[1]"),
		@FindBy(how = How.CSS, using = "#defaultidform > div > div:nth-child(2) > div > div > div.jodit-workplace > div.jodit-wysiwyg") })
WebElement  commentinputtextbox;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='defaultidform']/div/div[3]/button")
	WebElement submitbutton;
	
	
	public void clickonauditeeworkbench() throws Exception {
		Audit = new Finarya_AuditModulePage(driver);
		Thread.sleep(1000);
		Audit.ForwordArrow.click();
		Thread.sleep(1000);
		Audit.AuditMain.click();
		Thread.sleep(1000);
		Audit.AuditManagment.click();
		Thread.sleep(1000);
		Audit.AuditWorkbench.click();
		Thread.sleep(1000);
		Audit.AuditorWorkbench.click();
		Thread.sleep(1000);
	}

	public void clickonAuditorWorkbenchserachlist() throws Exception {
		loadpropertiesfile();
		SearchListAuditorWorkbench.clear();
		SearchListAuditorWorkbench.click();
		SearchListAuditorWorkbench.sendKeys(prop.readProperties("AuditID"));
		String ExpectedResult = prop.readProperties("AuditID");
		System.out.println("Expected Aidit ID Search IS" + ExpectedResult);
		Thread.sleep(1500);
		String AtualResult = Validatiomauditid.getText();
		System.out.println("Expected Aidit ID Search IS" + AtualResult);
		if (AtualResult.equalsIgnoreCase(ExpectedResult)) {
			Thread.sleep(1000);
			auditorworkbenchicon.click();
			String viewUrl = driver.getCurrentUrl();
			Reporter.log("After Click On View URL IS" + "  " + viewUrl);
			Assert.assertTrue(true);
			Reporter.log("Internal Audit Number Are Matching");

		} else {
			Reporter.log("Internal Audit Number Are Not Matching");
			Assert.assertTrue(false);
			SearchListAuditorWorkbench.clear();

		}

	}

	public void expectedtab() throws Exception {
		Thread.sleep(1000);
		for (WebElement tab : expectedtab) {
			Reporter.log("System will open Auditee Workbench page with tabs:" + "" + tab.getText());
			Reporter.log("System will open Auditee Workbench page with tabs Is Display:" + "" + tab.isDisplayed());

		}
	}

	public void clickchecklisttab() throws Exception {
		Thread.sleep(1000);
		checklisttab.click();
	}

	public void clickoncommentstab() throws Exception {
		Thread.sleep(1000);
		loadpropertiesfile();
		commentstab.click();

	}
	
	
	public void clickoninputcommenttextbox() throws Exception {
		Thread.sleep(1000);
		commentinputtextbox.click();
		commentinputtextbox.clear();
		commentinputtextbox.sendKeys(prop.readProperties("Commentsinput"));
	}
	public void clickonsubmitbutton() {
		submitbutton.click();
		
	}
}

