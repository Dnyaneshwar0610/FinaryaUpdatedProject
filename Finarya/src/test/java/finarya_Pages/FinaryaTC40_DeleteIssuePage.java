package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC40_DeleteIssuePage {

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC40_DeleteIssue.properties";
	WebDriver driver;
	public Finarya_AuditModulePage Audit;

	public FinaryaTC40_DeleteIssuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// COMMAN NEXT BUTTON"
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement nextbutton;
	// comman fullscreen button
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[2]")
	WebElement fullscreen;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tfoot/tr[1]/th[1]/input")
	WebElement searchbox;

	// UPDATE CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues']/tbody/tr[1]/td[2]")
	WebElement tablerecordvalidate;

	public void clickonlistofissue() throws Exception {
		Audit = new Finarya_AuditModulePage(driver);
		Thread.sleep(1500);
		Audit.ForwordArrow.click();
		Thread.sleep(1500);
		Audit.AuditMain.click();
		Thread.sleep(1500);
		Audit.AuditManagment.click();
		Thread.sleep(1500);
		Audit.IssuesManagement.click();
		Thread.sleep(1500);
		Audit.ListIssues.click();
	}

	public void searchrecord() {
		try {
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("searchlistissue");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("searchissueid"));
			Thread.sleep(3000);
			String Actual =tablerecordvalidate.getText();
			System.out.println(Actual);
			Thread.sleep(3000);
			if (searctext.equalsIgnoreCase(Actual)) {
				Reporter.log("AS PER TEST STEP DELETE ICON IS NOT PRESENT ON LIST ISSUE");
				Reporter.log("System will open Issues List Panel " + driver.getCurrentUrl());
				Assert.assertTrue(false);
			} else {
				Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
