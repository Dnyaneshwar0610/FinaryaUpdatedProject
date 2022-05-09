package finarya_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC18_UpdateViewProcessPage {

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC18_UpdateViewProcess.properties";
	WebDriver driver;
	Finarya_ProcessDocumentationModule mainprodoc;

	public FinaryaTC18_UpdateViewProcessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='panel-container show']/div/ul/li/a[text()='Process']")
	WebElement processtab;
// PROCESS FLOW DIAGRAM TAB
	@FindBy(how = How.XPATH, using = "//*[@class='panel-container show']/div/ul/li/a/span[text()='Process Flow Diagram']")
	WebElement processflowdiagramtab;
// SOP Tab
	@FindBy(how = How.XPATH, using = "//*[@class='panel-container show']/div/ul/li/a/span[text()='SOP']")
	WebElement soptab;
//INTERNAL/EXTERNAL CIRCULAR TAB
	@FindBy(how = How.XPATH, using = "//*[@class='panel-container show']/div/ul/li/a/span[text()='Internal/External Circulars']")
	WebElement internalexternalcirculartab;
// Process
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul")
	WebElement smartwizardtab;
//LINK PROCESS TAB
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li/a/span[text()='Link Process']")
	WebElement linkprocesstab;

// Ownertab
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[2]")
	WebElement ownertab;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/span/span/span")
	WebElement departmentname;
	@FindBy(how = How.ID, using = "select2-departmentName_0-results")
	List<WebElement> autoSuggest;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/label/input")
	WebElement pributton;
// Update Process
	@FindBy(how = How.XPATH, using = "//*[@id='processFlowId']")
	WebElement processflowid;
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/input[@id='documentId']")
	WebElement processinternalid;
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/input[@id='processName']")
	WebElement processname;
// Parent Process Name
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/span/span/span/span[@class='select2-selection__arrow']")
	WebElement parentprocessname;
	@FindBy(how = How.XPATH, using = "//span[@class='select2-search select2-search--dropdown']/input[@class='select2-search__field']")
	WebElement parentprocesssearchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-parentProcessName-results']/li")
	List<WebElement> autoSuggestParentProcessdropdown;
// Parent Process ID
	@FindBy(how = How.XPATH, using = "	//div[@id='step-01']/div/div/div/input[@id='parentProcessId']")
	WebElement parentprocessid;
// Process Description
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/textarea[@id='processDescription']")
	WebElement processDescription;
// Comman Searchbox
	@FindBy(how = How.XPATH, using = "/html/body/span/span/span/input")
	WebElement commansearchbox;
// commomn autosuggetion box
	@FindBy(how = How.XPATH, using = "//span[@class='select2-results']")
	List<WebElement> commanautosuggetionbox;
// Process Journey
	@FindBy(how = How.XPATH, using = "//*[@id='step-01']/div/div/div/span/span/span/ul/li/input")
	WebElement processjournysearch;
	@FindBy(how = How.XPATH, using = "//span[@class='select2-selection select2-selection--multiple']/ul/li/span[@class='select2-selection__choice__remove']")
	WebElement clearprocessjourny;
	@FindBy(how = How.XPATH, using = "//select[@id='processJourney']/option")
	List<WebElement> processjournyresult;
// Temporary Process
	@FindBy(how = How.XPATH, using = "	//*[@id='select2-temporaryPermanant-container']")
	WebElement TemporaryProcess;
// Process Frequency
	@FindBy(how = How.XPATH, using = "//*[@id='select2-processFrequency-container']")
	WebElement Processfrequency;
// Document Status
	@FindBy(how = How.XPATH, using = "	//div[@id='step-01']/div/div/div/input[@id='documentStatus']")
	WebElement documentstatus;
// Rolled up ID
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/input[@id='rolledUpId']")
	WebElement rolledupid;
// Next Button
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div/div/button[text()='Next']")
	WebElement nextbutton;
//Assign Process Document Approval
	@FindBy(how = How.XPATH, using = "//*[@id='pmc_cmc_list_table_filter']/label/input")
	WebElement SearchBox;
	@FindBy(how = How.XPATH, using = "//*[@id='pmc_cmc_list_table']/thead/tr[2]/th[5]/input")
	WebElement SearchApprovalName;
// table body
	@FindBy(how = How.XPATH, using = "//*[@id='pmc_cmc_list_table']/tbody/tr/td[5]")
	WebElement serchtextvalidation;
	@FindBy(how = How.XPATH, using = "//*[@id='pmc_cmc_list_table']/tbody/tr[1]/td/input")
	WebElement tablecheckbox;
// fullscreenbutton
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[2]")
	WebElement fullscreen;
//COMMAN ALL SERCH ROLE BOX
	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']/li")
	List<WebElement> AllSearch;
// LINK PROCESS
	@FindBy(how = How.XPATH, using = "//*[@id='step-04']/div[1]/div[1]/div/span/span[1]/span")
	WebElement deparment;
	@FindBy(how = How.XPATH, using = "//*[@id='step-04']/div[1]/div[2]/div/span/span[1]/span")
	WebElement product;
	@FindBy(how = How.XPATH, using = "//*[@id='step-04']/div[1]/div[3]/div/span/span[1]/span")
	WebElement risk;
	@FindBy(how = How.XPATH, using = "//*[@id='step-04']/div[1]/div[4]/div/span/span[1]/span")
	WebElement control;
// ADD Button
	@FindBy(how = How.XPATH, using = "//*[@id='step-04']/div/div/button")
	WebElement addbutton;
// ALERT CONTENT
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement alertmassegge;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
	WebElement okbuttonalert;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement alerttitle;
// PPROCESS FLOW UPLOAD OR BROWSE FILE
	@FindBy(how = How.XPATH, using = "//*[@class='custom-file']")
	WebElement browse;
// UPLOAD BUTTON
	@FindBy(how = How.XPATH, using = "//*[@id='upload']")
	WebElement uploadbutton;
//SOP
	@FindBy(how = How.XPATH, using = "//*[@id='dt_sop_list_filter']/label/input")
	WebElement sopmainsearchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='dt_sop_list']/tfoot/tr/th[4]/input")
	WebElement soptitlesearchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='dt_sop_list']/tbody/tr/td[4]")
	WebElement sopsearchverify;

	@FindBy(how = How.XPATH, using = "//*[@id='dt_sop_list']/tbody/tr/td/input[@id='sop_checkbox_1']")
	WebElement sopcheckbox;

//INTERNAL/EXTERNAL CIRCULAR TAB
	@FindBy(how = How.XPATH, using = "//*[@id='internal_circular_list_table_filter']/label/input")
	WebElement iecmainsearchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='internal_circular_list_table_wrapper']/div[2]/div/div[1]/div[1]/div/table/thead/tr[2]/th[5]/input")
	WebElement iecissuesdepartmentsearchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='internal_circular_list_table']/tbody/tr/td[5]")
	WebElement iecsearchverify;

	@FindBy(how = How.XPATH, using = "//*[@id='internal_circular_list_table']/tbody/tr/td[1]/input")
	WebElement ieccheckbox;
//SUBMIT BUTTON
	@FindBy(how = How.XPATH, using = "//*[@id='btnCreateProcess']")
	WebElement submitbutton;

	public void clickonlistprocess() {
		mainprodoc = new Finarya_ProcessDocumentationModule(driver);
		mainprodoc.ProcessDocumentation.click();
		mainprodoc.ProcessLibrary.click();
		mainprodoc.ListProcess.click();
		Reporter.log("Screen will open up List Process Panel" + "" + driver.getCurrentUrl());
	}

	// UPDATE RECORD
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process_filter']/label/input")
	WebElement searchreclistprocess;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process']/tbody/tr/td[3]")
	WebElement listrecordsearchverify;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process']/tbody/tr/td[1]/a[2]")
	WebElement updateicon;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process']/tbody/tr/td")
	WebElement tabledata;

	public void clickonserchlist() throws Exception {
		loadpropertiesfile();
		searchreclistprocess.clear();
		searchreclistprocess.click();
		String fromproperties = prop.readProperties("searchrecordupdate");
		searchreclistprocess.sendKeys(fromproperties);
		Thread.sleep(3000);
		String serchtextverify = listrecordsearchverify.getText();
		System.out.println("VERIFY TABLE TEXT" + serchtextverify);
		Thread.sleep(1500);
		if (fromproperties.equalsIgnoreCase(serchtextverify)) {
			Thread.sleep(3000);
			Thread.sleep(1500);
			updateicon.click();
			Reporter.log("System will display the searched record in the table");
		} else {
			Reporter.log(
					"System will not display the searched record in the table becouse record is not available in table");
			Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
			Reporter.log("No Search Record Found:="+tabledata.getText());
			Logout();
		}

	}

	
	
	public void clickonprocess() throws Exception {
		Thread.sleep(1500);
		processtab.click();
		Reporter.log("Screen will open up Process Panel showing following Tabs:" + smartwizardtab.getText());
	}

	public void clickonprocessflowid() throws InterruptedException {
		Thread.sleep(1500);
		processflowid.sendKeys("ABCER");
		String fieldNameVal = processflowid.getAttribute("value");
		if (fieldNameVal.contentEquals("ABCER")) {
			Reporter.log("Process Flow ID is Editable");
		} else {
			Reporter.log("Process Flow ID is system populated Is only Read Field:-" + fieldNameVal);
		}
	}
	
	
	
		
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
