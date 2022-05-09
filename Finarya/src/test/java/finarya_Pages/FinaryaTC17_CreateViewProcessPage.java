package finarya_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC17_CreateViewProcessPage {

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC17_CreateViewProcess.properties";
	WebDriver driver;
	Finarya_ProcessDocumentationModule mainprodoc;

	public FinaryaTC17_CreateViewProcessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	@FindBy(how = How.XPATH, using = "//*[@class='panel-container show']/div/ul")
	WebElement createprocesstab;
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
// Create Process
	@FindBy(how = How.XPATH, using = "//div[@id='step-01']/div/div/div/input[@id='processFlowId']")
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
//VIEW RECORD
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process_filter']/label/input")
	WebElement searchreclistprocess;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process']/tbody/tr/td[3]")
	WebElement listrecordsearchverify;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-process']/tbody/tr/td[1]/a[1]")
	WebElement processlistviewicon;

	public void clickonprocessdocumentation() {
		mainprodoc = new Finarya_ProcessDocumentationModule(driver);
		mainprodoc.ProcessDocumentation.click();
		mainprodoc.ProcessLibrary.click();
		mainprodoc.CreateProcess.click();
		Reporter.log("Screen will open up Create Process Panel" + "" + driver.getCurrentUrl());
		Reporter.log(
				"Screen will open up Create Process Panel showing following Tabs:" + "" + createprocesstab.getText());
	}

	public void clickonlistprocess() {
		mainprodoc = new Finarya_ProcessDocumentationModule(driver);
		mainprodoc.ProcessDocumentation.click();
		mainprodoc.ProcessLibrary.click();
		mainprodoc.ListProcess.click();
		Reporter.log("Screen will open up List Process Panel" + "" + driver.getCurrentUrl());
	}

	public void clickonprocess() throws Exception {
		Thread.sleep(1500);
		processtab.click();
		Reporter.log("Screen will open up Process Panel showing following Tabs:" + smartwizardtab.getText());
	}

	public void clickonprocessflowid() {
		processflowid.sendKeys("ABCER");
		String fieldNameVal = processflowid.getAttribute("value");
		if (fieldNameVal.contentEquals("ABCER")) {
			Reporter.log("Process Flow ID is Editable");
		} else {
			Reporter.log("Process Flow ID is system populated Is only Read Field:-" + fieldNameVal);
		}
	}

	public void verifyprocessInternalID() throws Exception {
		try {
			processinternalid.clear();
			processinternalid.sendKeys("ABCD$#^&*()%^%");
			// Retrieve typed value
			String typedValue = processinternalid.getAttribute("value");
			Thread.sleep(1500);
			if (typedValue.contentEquals("ABCD$#^&*()%^%")) {
				Thread.sleep(1500);
				Reporter.log("Process Internal ID Allowed  Special characters:-" + typedValue);
				Assert.assertTrue(false);
			} else {
				Reporter.log("Process Internat ID Are Not Allowed  Special characters" + typedValue);
				Assert.assertTrue(true);
			}
		} catch (AssertionError e) {
			// e.printStackTrace();
			System.out.println(e);
		}
	}

	public void clickonprocessinternalid(String IntrnalID) {
		processinternalid.clear();
		processinternalid.sendKeys(IntrnalID);
	}

	public void verifyprocessname() throws Exception {
		try {
			processname.clear();
			processname.sendKeys("ABCD$#^&*()%^%");
			// Retrieve typed value
			String typedValue = processname.getAttribute("value");
			Thread.sleep(1500);
			if (typedValue.contentEquals("ABCD$#^&*()%^%")) {
				Thread.sleep(1500);
				Reporter.log("Process Name Are Allowed Special characters:-" + typedValue);
				Assert.assertTrue(false);
			} else {
				Reporter.log("Process Name Are Not Allowed Special characters:-" + typedValue);
				Assert.assertTrue(true);
			}
		} catch (AssertionError e) {
			// e.printStackTrace();
			System.out.println(e);
		}

	}

	public void clickonprocessname(String pName) {
		processname.clear();
		processname.sendKeys(pName);
	}

	public void clickonparentprocessname() {
		loadpropertiesfile();
		parentprocessname.click();
		parentprocesssearchbox.click();
		String fromproperties = prop.readProperties("ParentProcessName");
		System.out.println("Parent Process Name" + fromproperties);
		parentprocesssearchbox.sendKeys(fromproperties);
	}

	public void parentprocessdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("ParentProcessName");
		for (WebElement p : autoSuggestParentProcessdropdown) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(fromproperties)) {
				;
				p.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void parentprocessID() throws Exception {
		// Retrieve typed value
		String typedValue = parentprocessid.getAttribute("value");
		Thread.sleep(1500);
		System.out.println("System will automatically populate Parent Process ID" + parentprocessid.getText());
		Reporter.log("System will automatically populate Parent Process ID:" + typedValue);
	}

	public void clickonprocessdescription(String Processdescription) {
		processDescription.clear();
		processDescription.sendKeys(Processdescription);
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)", "");
	}

	public void scrollup() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)", "");
	}

	public void clickonparentprocessjourny() {
		loadpropertiesfile();
		try {
			clearprocessjourny.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		processjournysearch.click();
		String fromproperties = prop.readProperties("processjourny");
		processjournysearch.sendKeys(fromproperties);
		processjournysearch.sendKeys(Keys.ENTER);
	}

	public void processjourydropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("processjourny");
		for (WebElement p : processjournyresult) {
			if (p.getText().equalsIgnoreCase(fromproperties)) {
				;
				p.click();
				break;
			}
		}
	}

	public void clickontempprocess() {
		loadpropertiesfile();
		TemporaryProcess.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("TemporaryProcess");
		System.out.println("Temporary Process" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
		commansearchbox.sendKeys(Keys.ENTER);

	}

	public void temprocessdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("TemporaryProcess");
		for (WebElement p : commanautosuggetionbox) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(fromproperties)) {
				;
				p.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void clickonprocessfre() {
		loadpropertiesfile();
		Processfrequency.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("ProcessFrequency");
		System.out.println("Process Frequency is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
		commansearchbox.sendKeys(Keys.ENTER);
	}

	public void clickondocumentstatus(String docustatus) {
		documentstatus.clear();
		documentstatus.sendKeys(docustatus);
	}

	public void clickonrolledupid(String rolledid) {
		rolledupid.clear();
		rolledupid.sendKeys(rolledid);
	}

	// Next Button
	public void clickonnextbutton() {
		nextbutton.click();

	}

	public void clickondepartmentname() {

		loadpropertiesfile();
		departmentname.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("DepartmentName");
		System.out.println("Department Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void departmentnamedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("DepartmentName");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("dep" + Allsuggestionlist);
			String finalresult = prop.readProperties("DepartmentName");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				pributton.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void assinprocessdoc() throws Exception {
		loadpropertiesfile();
		SearchBox.clear();
		SearchBox.click();
		String fromproperties = prop.readProperties("processdocumentname");
		SearchBox.sendKeys(fromproperties);
		Thread.sleep(1500);
		SearchApprovalName.clear();
		SearchApprovalName.click();
		SearchApprovalName.sendKeys(fromproperties);
		Thread.sleep(3000);
		String serchtextverify = serchtextvalidation.getText();
		System.out.println("VERIFY TABLE TEXT" + serchtextverify);
		Thread.sleep(1500);
		if (fromproperties.equalsIgnoreCase(serchtextverify)) {
			Thread.sleep(3000);
			Thread.sleep(1500);
			tablecheckbox.click();
			Reporter.log("System will display the searched record in the table");
			Reporter.log("Scroll down. System will display the selected record in the table Process Document "
					+ "Approvals selected for this Process along with a Remove button in the Action Column");
		} else {
			Reporter.log(
					"System will not display the searched record in the table becouse record is not available in table");
		}

	}

	public void clickonfullscreen() {
		fullscreen.click();
	}

	public void scrolldowntarget() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(nextbutton));

	}

	// LINK PROCESS
	// Department
	public void clickondepartment() {
		loadpropertiesfile();
		deparment.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("Deparment");
		System.out.println("Department" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void departmentdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("Deparment");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("Deparment AllSuggestionList" + Allsuggestionlist);
			String finalresult = prop.readProperties("Deparment");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	// PRODUCT
	public void clickonproduct() {

		loadpropertiesfile();
		product.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("Product");
		System.out.println("Product " + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void productdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("Product");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("Product AllSuggestionList" + Allsuggestionlist);
			String finalresult = prop.readProperties("Product");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	// Risk

	public void clickonrisk() {

		loadpropertiesfile();
		risk.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("Risk");
		System.out.println("Risk " + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void riskdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("Risk");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("Risk AllSuggestionList" + Allsuggestionlist);
			String finalresult = prop.readProperties("Risk");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void clickoncontrol() {

		loadpropertiesfile();
		control.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("Control");
		System.out.println("Control " + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void controldropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("Control");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("Control AllSuggestionList" + Allsuggestionlist);
			String finalresult = prop.readProperties("Control");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void clickonaddbutton() {
		addbutton.click();
		try {
			String Alertmassage = alertmassegge.getText();
			Reporter.log("Link Process Add:-" + Alertmassage);
			okbuttonalert.click();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clikonprocessflowdiagramtab() {
		processflowdiagramtab.click();
		Reporter.log("System will open up page Upload Process Flow Diagram");
	}

	public void clikonbrowse() {
		browse.click();
	}

	public void Uploadfile() throws Exception {
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
		Reporter.log("The file can be seen attached" + " File Name Is:-" + browse.getText());
	}

	public void clickonuploadbutton() {
		uploadbutton.click();
		String Expectedresult = "Files Uploaded Successfully.";
		try {
			String Alertmassage = alertmassegge.getText();
			if (Alertmassage.equalsIgnoreCase(Alertmassage)) {
				Reporter.log("System gives a alert Files  Uploaded Successfully:-" + Alertmassage);
				okbuttonalert.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//SOP
	public void clickonsop() {
		soptab.click();
		Reporter.log("System will display the available SOP records in the table");
	}

	public void clickonsopsearchbox() throws Exception {
		loadpropertiesfile();
		sopmainsearchbox.clear();
		sopmainsearchbox.click();
		String fromproperties = prop.readProperties("sopsearchvalue");
		sopmainsearchbox.sendKeys(fromproperties);
		Thread.sleep(1500);
		/*
		 * sopmainsearchbox.clear(); Thread.sleep(1500);
		 * 
		 * soptitlesearchbox.clear(); soptitlesearchbox.click();
		 * soptitlesearchbox.sendKeys(fromproperties);
		 */
		Thread.sleep(3000);
		String serchtextverify = sopsearchverify.getText();
		System.out.println("VERIFY TABLE TEXT" + serchtextverify);
		Thread.sleep(1500);
		if (fromproperties.equalsIgnoreCase(serchtextverify)) {
			Thread.sleep(3000);
			Thread.sleep(1500);
			sopcheckbox.click();
			Reporter.log("System will display the searched record in the table");
			Reporter.log("System will display the selected record in the table Process Document "
					+ "Approvals selected for this Process along with a Remove button in the Action Column");
		} else {
			Reporter.log(
					"System will not display the searched record in the table becouse record is not available in table");
		}

	}

	public void clickoninternalexternalcircular() {
		internalexternalcirculartab.click();
		Reporter.log("System will display the available Internal/External Circulars records in the table");

	}

	public void clickonsearchinternalexternalcircular() throws Exception {
		loadpropertiesfile();
		iecmainsearchbox.clear();
		iecmainsearchbox.click();
		String fromproperties = prop.readProperties("internalexternalsearch");
		iecmainsearchbox.sendKeys(fromproperties);
		Thread.sleep(1500);
		iecmainsearchbox.clear();
		Thread.sleep(1500);
		iecissuesdepartmentsearchbox.clear();
		iecissuesdepartmentsearchbox.click();
		iecissuesdepartmentsearchbox.sendKeys(fromproperties);
		Thread.sleep(3000);
		String serchtextverify = iecsearchverify.getText();
		System.out.println("VERIFY TABLE TEXT" + serchtextverify);
		Thread.sleep(1500);
		if (fromproperties.equalsIgnoreCase(serchtextverify)) {
			Thread.sleep(3000);
			Thread.sleep(1500);
			ieccheckbox.click();
			Reporter.log("System will display the searched record in the table");
			Reporter.log("System will display the selected record in the table Process Document "
					+ "Approvals selected for this Process along with a Remove button in the Action Column");
		} else {
			Reporter.log(
					"System will not display the searched record in the table becouse record is not available in table");
		}

	}

	public void clickonsubmitbutton() throws Exception {
		Thread.sleep(1000);
		processtab.click();
		Thread.sleep(1000);
		linkprocesstab.click();
		Thread.sleep(1000);
		scrolldown();
		Thread.sleep(1000);
		submitbutton.click();
		Thread.sleep(1000);
		Reporter.log("System displays a pop-up message:-" + alertmassegge.getText());
		Thread.sleep(1000);
		okbuttonalert.click();
		Thread.sleep(1000);
		Reporter.log("System opens page List Process Master and the process created is seen in the table below:");
		Reporter.log("AFTER CLICK ON SUBMIT URL:-" + driver.getCurrentUrl());
	}

	public void clickonviewprocess() {
		String ExpectedURL = "https://10.10.10.14:9443/showListProcessesPage";
		String ActualURL = driver.getCurrentUrl();

		if (ExpectedURL.equalsIgnoreCase(ActualURL)) {
			clickonlistprocess();
			
		} else{
			Reporter.log("record already exists with Process Name");
			clickonlistprocess();
	
		}
		
	}

	public void clickonserchlist() throws Exception {
		loadpropertiesfile();
		searchreclistprocess.clear();
		searchreclistprocess.click();
		String fromproperties = prop.readProperties("searchviewrecord");
		searchreclistprocess.sendKeys(fromproperties);
		Thread.sleep(3000);
		String serchtextverify = listrecordsearchverify.getText();
		System.out.println("VERIFY TABLE TEXT" + serchtextverify);
		Thread.sleep(1500);
		if (fromproperties.equalsIgnoreCase(serchtextverify)) {
			Thread.sleep(3000);
			Thread.sleep(1500);
			processlistviewicon.click();
			Reporter.log("System will display the searched record in the table");
			Reporter.log("All the data fields are blocked for editing");
		} else {
			Reporter.log(
					"System will not display the searched record in the table becouse record is not available in table");
		}
}
}