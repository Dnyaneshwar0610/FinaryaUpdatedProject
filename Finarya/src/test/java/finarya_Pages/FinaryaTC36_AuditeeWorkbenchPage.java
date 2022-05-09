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

public class FinaryaTC36_AuditeeWorkbenchPage {

	WebDriver driver;

	public Finarya_AuditModulePage Audit;

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC36_AuditeeWorkbench.properties";

	public FinaryaTC36_AuditeeWorkbenchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}
	

	@FindAll({ @FindBy(how = How.XPATH, using = " //*[@id='csi-dt-auditee-workbench_filter']/label/input"),
			@FindBy(how = How.CSS, using = "#csi-dt-auditee-workbench_filter > label > input"), })
	WebElement SearchListListAuditeeResponse;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-auditee-workbench']/tbody/tr[1]/td[1]/a[2]"),
			@FindBy(how = How.CSS, using = "#csi-dt-auditee-workbench > tbody > tr:nth-child(1) > td.sorting_1.dtr-control > a:nth-child(2)") })
	WebElement auditresponseicon;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-auditee-workbench']/tbody/tr[1]/td[2]")
	WebElement Validatiomauditid;

	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li")
	List<WebElement> expectedtab;
	@FindBy(how = How.XPATH, using = "//*[@id='workbench_tabs']/ul/li/a[text()='Upload']")
	WebElement uploadtab;
	@FindBy(how = How.XPATH, using = "//*[@id='audit_controls_samples_table']/tbody/tr[1]/td[1]")
	WebElement uploadsamplebutton;
	

	@FindAll({
			@FindBy(how = How.XPATH, using = "//span[@class='btn btn-success fileinput-button waves-effect waves-themed dz-clickable']/span"),
			@FindBy(how = How.CSS, using = "#actions > div.col-lg-7 > span") })
	WebElement Addfilebutton;

	@FindAll({
		@FindBy(how = How.XPATH, using = "	//*[@id='previews']/div/div/button/span[text()='Start']"),
		@FindBy(how = How.CSS, using = "#previews > div > div:nth-child(5) > button.btn.btn-primary.start.waves-effect.waves-themed") })
WebElement startbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='previews']/div/div/strong[@class='error text-danger']")
	WebElement fileuploaderror;
	@FindBy(how = How.XPATH, using = "//*[@id='UploadAuditControlSampleModal']/div/div/div[3]/button")
	WebElement closebutton;

	
	@FindBy(how = How.XPATH, using = "//*[@id='audit_controls_samples_table']/tbody/tr[1]/td[9]/div/input")
	WebElement Reasonfornotuploadfile;
	
	@FindBy(how = How.XPATH, using = "//*[@id='audit_controls_samples_table']/tbody/tr[1]/td[9]/div/button[text()='ADD']")
	WebElement ADDbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement alertcontent;
	
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
	WebElement alertcontentokbutton;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='audit_controls_samples_table']/tbody/tr[1]/td[10]/button[text()='Comments']")
	WebElement commentbutton;
	//Sample Audit Control Comments
	@FindBy(how = How.XPATH, using = "//table[@id='audit_control_sample_comments_table']/tbody/tr/td[1]")
	List<WebElement> SampleAuditControlCommentsTtable;
	
	@FindBy(how = How.XPATH, using = "//table[@id='audit_control_sample_comments_table']/tbody/tr")
	WebElement SampleAuditCtabletext;
	@FindBy(how = How.XPATH, using = "//*[@id='auditControlSampleCommentsModal']/div/div/div[3]/button")
	WebElement SampleAuditControlclosebutton;

	
	
	
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
		Audit.AuditeeWorkbench.click();
		Thread.sleep(1000);
	}

	public void clickonauditeeworkbenchserachlist() throws Exception {
		Thread.sleep(1500);
		loadpropertiesfile();
		SearchListListAuditeeResponse.clear();
		SearchListListAuditeeResponse.click();
		SearchListListAuditeeResponse.sendKeys(prop.readProperties("AuditID"));
		String ExpectedResult = prop.readProperties("AuditID");
		System.out.println("Expected Aidit ID Search IS" + ExpectedResult);
		Thread.sleep(1500);
		String AtualResult = Validatiomauditid.getText();
		System.out.println("Actual Aidit ID Search IS" + AtualResult);
		Thread.sleep(1000);
		if (AtualResult.equalsIgnoreCase(ExpectedResult)) {
			Thread.sleep(1500);
			auditresponseicon.click();
			String viewUrl = driver.getCurrentUrl();
			Reporter.log("After Click On View URL IS" + "  " + viewUrl);
			Assert.assertTrue(true);
			Reporter.log("Internal Audit Number Are Matching");

		} else {
			Reporter.log("Internal Audit Number Are Not Matching");
			Assert.assertTrue(false);
			SearchListListAuditeeResponse.clear();

		}

	}

	public void expectedtab() throws Exception {
		Thread.sleep(1000);
		for (WebElement tab : expectedtab) {

			Reporter.log("System will open Auditee Workbench page with tabs:" + "" + tab.getText());
			Reporter.log("System will open Auditee Workbench page with tabs Is Display:" + "" + tab.isDisplayed());

		}
	}

	public void clickonuploadtab() throws Exception {
		Thread.sleep(1000);
		uploadtab.click();
	}

	public void clickonuploadsample() throws Exception {
		Thread.sleep(1000);
		uploadsamplebutton.click();
	}

	public void clickonaddfilebutton() throws Exception {
		Thread.sleep(1000);
		Addfilebutton.click();
	}
	
	
	public void addfile() throws Exception {
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
			}
public void clickonstartbutton() throws Exception {
	Thread.sleep(3000);
	startbutton.click();
}
public void geterror() throws Exception {
	Thread.sleep(1000);
	String ActualResultFile=null;
	try {
		ActualResultFile = fileuploaderror.getText();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Atribute is");
	Reporter.log("File is Upload Or Not Status"+"    "+ActualResultFile);
	String ExpectedResult="System will display option to Delete the uploaded file";
	if (ExpectedResult.equalsIgnoreCase(ActualResultFile)) {
		Reporter.log("File Upload");
		Reporter.log("File is Upload Or Not Status"+"    "+ActualResultFile);
		Assert.assertTrue(true);
		
	}else {
		Reporter.log("File Upload Not Successfully");
		Reporter.log("File is Upload Or Not Status"+"    "+ActualResultFile);
		Assert.assertTrue(false);
	}
	
}
	public void totaldownscroll() throws Exception {
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void clickonclosebutton() throws Exception {
		Thread.sleep(4000);
		closebutton.click();
		String URL=driver.getCurrentUrl();
		Reporter.log("\"System will take the User back to Auditee Workbench\"+"+URL);
	}

	
	
	public void clickonreasonupload() throws Exception
	{
		try {
		Thread.sleep(1000);
		boolean reasonfornotuploadfiletext =Reasonfornotuploadfile.isDisplayed();
		Thread.sleep(1000);
		System.out.println("Reason For Not Upload file Text box is display"+reasonfornotuploadfiletext);
		if(reasonfornotuploadfiletext==true) {
			clickonReasonfornotuploadfile();
			clickonaddbutton();
			clickoncommentbutton();
			verificationofcomment();
			clickonsampalauditcontclose();
			
		}else {
			System.out.println("File Upload Sucessfully So No Reason For Upload File.");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
public void clickonReasonfornotuploadfile() {
	
	loadpropertiesfile();
	Reasonfornotuploadfile.clear();
	Reasonfornotuploadfile.click();
	Reasonfornotuploadfile.sendKeys(prop.readProperties("InputReasonsfornotUploadingSample"));
	String ReasonMassege=Reasonfornotuploadfile.getText();
	}

public void clickonaddbutton() throws Exception {
	Thread.sleep(1000);
	ADDbutton.click();
	String Alert=alertcontent.getText();
	Reporter.log("Reason For File Upload Status"+"  "+Alert);
	alertcontentokbutton.click();
}

public void clickoncommentbutton() {
	commentbutton.click();

}

public void verificationofcomment() {
	int Count=SampleAuditControlCommentsTtable.size();
	System.out.println("SampleAuditControlCommentsTtable"+""+Count);
	for(int i=Count;i<=Count+1;i++) {
		String textcomment=SampleAuditCtabletext.getText();
		System.out.println("Comment massage is"+"  "+textcomment);
		Reporter.log("Comment massage is"+"  "+textcomment);
		break;
	}
}
public void clickonsampalauditcontclose() throws Exception {
	Thread.sleep(1000);
	SampleAuditControlclosebutton.click();	
	Reporter.log("System will take the User back to Auditee Workbench"+"  "+driver.getCurrentUrl());
}

}



