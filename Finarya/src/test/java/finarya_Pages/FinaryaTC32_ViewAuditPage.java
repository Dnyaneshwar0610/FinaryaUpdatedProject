package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC32_ViewAuditPage {
public Finarya_AuditModulePage Audit;
	WebDriver driver;
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC32_CreateViewAudit.properties";
	
   public FinaryaTC32_ViewAuditPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}
	
   @FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='csi-dt-auditor-workbench_filter']/label/input"),
		@FindBy(how=How.CSS,using=" #csi-dt-auditor-workbench_filter > label > input"),
	})
	WebElement SearchListAuditorWorkbench;
   
   @FindBy(how=How.XPATH,using="//*[@id='csi-dt-auditor-workbench']/tbody/tr[1]/td[1]/a[1]")
   WebElement Viewicon; 
   @FindBy(how=How.XPATH,using=" //*[@id='csi-dt-auditor-workbench']/tbody/tr/td[2]")
   WebElement Validatiomauditnumber; 
   

  
 
	public void clickonlistofcreateaudit() {
			Audit = new Finarya_AuditModulePage(driver);
			Audit.ForwordArrow.click();
			Audit.AuditMain.click();
			Audit.AuditManagment.click();
			Audit.AuditWorkbench.click();
			Audit.ListofCreateaudit.click();
		}

	public void clickonserachlist() {
		loadpropertiesfile();
		SearchListAuditorWorkbench.clear();
		SearchListAuditorWorkbench.click();
		SearchListAuditorWorkbench.sendKeys(prop.readProperties("ViewAudit"));
		String ExpectedResult=prop.readProperties("ViewAudit");
		String AtualResult=Validatiomauditnumber.getText();
		if(AtualResult==ExpectedResult) {
			Viewicon.click();
			String viewUrl=driver.getCurrentUrl();
		   Reporter.log("After Click On View URL IS"+"  "+viewUrl);
			Assert.assertTrue(true);
			Reporter.log("Internal Audit Number Are Matching");
			
		}else {
			Reporter.log("Internal Audit Number Are Not Matching");
			Assert.assertTrue(false);
			SearchListAuditorWorkbench.clear();
			
		}
		
		}

      
}
