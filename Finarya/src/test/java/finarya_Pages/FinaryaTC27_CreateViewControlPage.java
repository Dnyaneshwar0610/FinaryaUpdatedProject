package finarya_Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC27_CreateViewControlPage {
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC27_CreateViewControl.properties";
	WebDriver driver;
	public Finarya_RiskManagementModule riskmodule;

	public FinaryaTC27_CreateViewControlPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}
//COMMAN ALERT CONTENT
	// ALERT CONTENT
		@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
		WebElement alertmassegge;
		@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
		WebElement okbuttonalert;
		@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
		WebElement alerttitle;
	
	
// COMMAN SEARCHBOX
	@FindAll({ @FindBy(how = How.XPATH, using = "/html/body/span/span/span/input"),
			@FindBy(how = How.XPATH, using = "//*[@class='select2-search select2-search--dropdown']/input"),
			@FindBy(how = How.CSS, using = "body > span > span > span.select2-search.select2-search--dropdown > input") })
	WebElement commansearchbox;

// comman fullscreen button
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[2]")
	WebElement fullscreen;
//COMMAN ALL SERCH ROLE BOX
	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']/li")
	List<WebElement> AllSearch;
//COMMAN NEXT BUTTON"
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement nextbutton;

//CONTROL MODULE
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul")
	WebElement createcontroltab;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div/button[@id='advancebtnFiledsvisible']")
	WebElement additionalfieldbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='controlRefNo']")
	WebElement controlrefno;
	@FindBy(how = How.XPATH, using = "//*[@id='controlTitle']")
	WebElement controltitle;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[3]/div/span"),
			@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[3]/div/span/span[1]/span"),
			@FindBy(how = How.CSS, using = "#step-1 > div.form-row > div:nth-child(3) > div > span > span.selection > span") })
	WebElement parentcontrolname;
	@FindBy(how = How.XPATH, using = "//*[@id='parentControlId']")
	WebElement parentcontrolid;
	@FindBy(how = How.XPATH, using = "//*[@id='controlDescription']")
	WebElement controldescription;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[6]/div/span")
	WebElement opratinglevelofcontrol;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[7]/div/span")
	WebElement controlmode;
//reason for manual control
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[8]/div/span")
	WebElement reasonformanual;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[8]/div/span/span[1]/span/ul/li/input")
	WebElement inputreasonformanual;
//CONTROL NATURE
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[9]/div/span")
	WebElement controlnature;
//FRAUD PREVENTIVE
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[10]/div/span")
	WebElement fraudpreventive;

//Compensating Control 
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[11]/div/span")
	WebElement compensatingcontrol;
//Control Frequency
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[12]/div/span")
	WebElement controlfequency;

	public void clikoncreatecontrol() throws Exception {
		riskmodule = new Finarya_RiskManagementModule(driver);
		Thread.sleep(1500);
		riskmodule.riskmanagement.click();
		Thread.sleep(1500);
		riskmodule.riskandcontrollibrary.click();
		Thread.sleep(1500);
		riskmodule.controllibrary.click();
		Thread.sleep(1500);
		riskmodule.createcontrol.click();
		Thread.sleep(1500);
		Reporter.log("Screen will open up Create Control Panel" + ":-" + driver.getCurrentUrl());
		Reporter.log("Screen will open up Create Control Panel showing following Tabs:-" + createcontroltab.getText());
	}

	public void clickonadditionalfield() throws Exception {
		Thread.sleep(1000);
		additionalfieldbutton.click();
		Reporter.log("System will open up few Extra fields for input");
	}

	public void clickoncontrolrefno(String refno) {
		controlrefno.clear();
		controlrefno.sendKeys(refno);
	}

	public void clickoncontroltitle(String Title) {
		controltitle.clear();
		controltitle.sendKeys(Title);
	}

	public void clickonparentcontrolname() {
		loadpropertiesfile();
		parentcontrolname.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("parentcontrolname");
		System.out.println("Parent Control Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void parentcontroldropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("parentcontrolname");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			String finalresult = prop.readProperties("parentcontrolname");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void verifyparentcontrolid() {
		String typevalue = parentcontrolid.getAttribute("value");
		System.out.println("System will automatically populate Parent Control ID:-" + typevalue);
		Reporter.log("System will automatically populate Parent Control ID:-" + typevalue);
	}

	public void clickoncontroldescription(String Controldescription) {
		controldescription.clear();
		controldescription.sendKeys(Controldescription);
	}

	public void clickonfullscreen() {
		fullscreen.click();
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
	}

// OPRATING LAVEL CONTROL
	public void clickonopratinglevelcontrol() {
		loadpropertiesfile();
		opratinglevelofcontrol.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("opratingcontrol");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void opratingcontrolleveldropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("opratingcontrol");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("opratingcontrol");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//CONTROL MODE
	public void clickoncontrolmode() {
		loadpropertiesfile();
		controlmode.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("controlmodeproperties");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void controlmodedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("controlmodeproperties");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("controlmodeproperties");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//REASON FOR MANUAL CONTROL
	public void clickonreasonformanualcontrol1() {
		loadpropertiesfile();
		reasonformanual.click();
		inputreasonformanual.click();
		String fromproperties = prop.readProperties("reasonformanualcontrol1");
		System.out.println("oprating control Mode Is" + fromproperties);
		inputreasonformanual.sendKeys(fromproperties);
	}

	public void reasonformanualcontrolmodedropdown1() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("reasonformanualcontrol1");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("reasonformanualcontrol1");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	// REASON FOR MANUAL CONTROL
	public void clickonreasonformanualcontrol2() {
		loadpropertiesfile();
		
		reasonformanual.click();
		inputreasonformanual.click();
		String fromproperties = prop.readProperties("reasonformanualcontrol2");
		System.out.println("oprating control Mode Is" + fromproperties);
		inputreasonformanual.sendKeys(fromproperties);
	}

	public void reasonformanualcontrolmodedropdown2() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("reasonformanualcontrol2");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("reasonformanualcontrol2");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	// REASON FOR MANUAL CONTROL
	public void clickonreasonformanualcontrol3() {
		loadpropertiesfile();
		reasonformanual.click();
		inputreasonformanual.click();
		String fromproperties = prop.readProperties("reasonformanualcontrol3");
		System.out.println("oprating control Mode Is" + fromproperties);
		inputreasonformanual.sendKeys(fromproperties);
	}

	public void reasonformanualcontrolmodedropdown3() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("reasonformanualcontrol3");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("reasonformanualcontrol3");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//CONTROL NATURE
	public void clickoncontrolnature() {
		loadpropertiesfile();
		controlnature.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("controlnatureprop");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void controlnaturedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("controlnatureprop");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("controlnatureprop");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//Fraud Preventive
	public void clickonfraudpreventive() {
		loadpropertiesfile();
		fraudpreventive.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("FraudPreventive");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void fraudpreventivedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("FraudPreventive");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("FraudPreventive");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//Compensating Control	
	public void clickoncopensatingcontrol() {
		loadpropertiesfile();
		compensatingcontrol.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("copensetingpreventive");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void copensatingcontroldropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("copensetingpreventive");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("copensetingpreventive");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

//Control Frequency
	public void clickoncontrolfre() {
		loadpropertiesfile();
		controlfequency.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("controlfrquency");
		System.out.println("oprating control Mode Is" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void controlfredropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("controlfrquency");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();

			String finalresult = prop.readProperties("controlfrquency");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
//KEY CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[14]/div/span")
	WebElement keycontrolclick;
	
		public void clickonkeycontrol() {
			loadpropertiesfile();
			keycontrolclick.click();
			commansearchbox.click();
			String fromproperties = prop.readProperties("keycontrol");
			System.out.println("Key control  Is" + fromproperties);
			commansearchbox.sendKeys(fromproperties);
		}

		public void keycontroldropdown() throws Exception {
			Thread.sleep(3000);
			loadpropertiesfile();
			String fromproperties = prop.readProperties("keycontrol");
			Thread.sleep(3000);
			System.out.println("Total Auto Suggestion:-" + AllSearch.size());
			for (int i = 0; i < AllSearch.size(); i++) {
				String Allsuggestionlist = AllSearch.get(i).getText();
				String finalresult = prop.readProperties("keycontrol");
				if (Allsuggestionlist.equals(finalresult)) {
					AllSearch.get(i).click();
					Thread.sleep(3000);
					break;
				}
			}
		}

//CONTROL TYPE
		@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div[2]/div[17]/div/span")
		WebElement controltype;
		
		public void clickoncontroltype() {
			loadpropertiesfile();
			controltype.click();
			commansearchbox.click();
			String fromproperties = prop.readProperties("controltypeproperties");
			System.out.println("oprating control Mode Is" + fromproperties);
			commansearchbox.sendKeys(fromproperties);
		}

		public void controltypedropdown() throws Exception {
			Thread.sleep(3000);
			loadpropertiesfile();
			String fromproperties = prop.readProperties("controltypeproperties");
			Thread.sleep(3000);
			System.out.println("Total Auto Suggestion:-" + AllSearch.size());
			for (int i = 0; i < AllSearch.size(); i++) {
				String Allsuggestionlist = AllSearch.get(i).getText();
				String finalresult = prop.readProperties("controltypeproperties");
				if (Allsuggestionlist.equals(finalresult)) {
					AllSearch.get(i).click();
					Thread.sleep(3000);
					break;
				}
			}
		}
	
	
//NEXT BUTTON
	public void clickonnextbutton() {
		nextbutton.click();
	}
//OWNER TAB	
	// Ownertab
		@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[2]")
		WebElement ownertab;
		@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/span/span/span")
		WebElement departmentname;
		@FindBy(how = How.ID, using = "select2-departmentName_0-results")
		List<WebElement> autoSuggest;
		@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/label/input")
		WebElement pributton;
	
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

//LINK CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='linkEntityControlForm']/div[1]/div[1]/div/span")
	WebElement linkdepartment;
	@FindBy(how = How.XPATH, using = "//*[@id='linkEntityControlForm']/div[1]/div[2]/div/span")
	WebElement linkproduct;
	@FindBy(how = How.XPATH, using = "//*[@id='linkEntityControlForm']/div[1]/div[3]/div/span")
	WebElement linkprocess;
	@FindBy(how = How.XPATH, using = "//*[@id='linkEntityControlForm']/div[1]/div[4]/div/span")
	WebElement linkrisk;
	@FindBy(how = How.XPATH, using = "//*[@id='linkEntityControlForm']/div[2]/div[1]/button")
	WebElement addbutton;

	
//DEPARTMENT 
	public void clickonlinkdepartmentname() {

		loadpropertiesfile();
		linkdepartment.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("department");
		System.out.println("Link Department Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void linkdepartmentnamedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("department");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			String finalresult = prop.readProperties("department");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
	
//PRODUCT
	public void clickonlinkproduct() {

		loadpropertiesfile();
		linkproduct.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("product");
		System.out.println("Link Product Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void linkproductnamedropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("product");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			String finalresult = prop.readProperties("product");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
//PROCESS
	
	public void clickonlinkprocess() {
		loadpropertiesfile();
		linkprocess.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("process");
		System.out.println("Link Process Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void linkprocessdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("process");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			String finalresult = prop.readProperties("process");
			if (Allsuggestionlist.equals(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
	
//RISK
	public void clickonlinkriskname() {
		loadpropertiesfile();
		linkrisk.click();
		commansearchbox.click();
		String fromproperties = prop.readProperties("risk");
		System.out.println("link risk Name" + fromproperties);
		commansearchbox.sendKeys(fromproperties);
	}

	public void linkriskdropdown() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("risk");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			String finalresult = prop.readProperties("risk");
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
			String Expected="Linked entites already selected for this control.";
			String Actual=alertmassegge.getText();
			if(Expected.equalsIgnoreCase(Actual)) {
				Reporter.log(Actual);
				okbuttonalert.click();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
//SAVE SUBMIT BUTTON
	@FindBy(how = How.XPATH, using = "//*[@id='btnSaveControl']")
	WebElement submit;
	public void clickonsubmitbutton() {
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-450)","" );
        clickonfullscreen();
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		jse.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		try {
		Reporter.log(alertmassegge.getText());
		String Expected="Control creation failed.";
		String Actual =alerttitle.getText();		
		if(Expected.equalsIgnoreCase(Actual)) {
			Reporter.log("Record already exists with Control name:-"+alerttitle.getText());
			okbuttonalert.click();
			 clickonfullscreen();
			
		}else {
			okbuttonalert.click();
			Reporter.log("System displays a pop up message Control ID=xxx Created Successfully.");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("System opens page List Control Master and the Control ID created is listed here.:-"+driver.getCurrentUrl());
	}
//VIEW CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control_filter']/label/input")
	WebElement searchbox;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[2]")
	WebElement tablerecordvalidate;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[1]/a[1]")
	WebElement viewicon;
//VIEW TAB COMMAN
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a[text()='View Control']")
	WebElement viewcontroltab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a[text()='Ownership']")
	WebElement ownershiptab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a/span[text()='Link Control']")
	WebElement linkcontrol;
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateControl']")
	WebElement clonecontrolbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='controlRefNo']")
	WebElement controlrefnoclone;
	@FindBy(how = How.XPATH, using = "//*[@id='btnCloneControl']")
	WebElement savebutton;
	
	
	
	public void controllist() throws Exception {
		riskmodule = new Finarya_RiskManagementModule(driver);
		Thread.sleep(1500);
		riskmodule.riskmanagement.click();
		Thread.sleep(1500);
		riskmodule.riskandcontrollibrary.click();
		Thread.sleep(1500);
		riskmodule.controllibrary.click();
		Thread.sleep(1500);
		riskmodule.listcontrol.click();

	}
	public void viewcontrolrecord() throws Exception {
	try {
		loadpropertiesfile();
		searchbox.clear();
		searchbox.click();
		String searctext=prop.readProperties("searchviewcontrol");
		System.out.println(searctext);
		searchbox.sendKeys(prop.readProperties("searchviewcontrol"));
		Thread.sleep(3000);
		String Actual=tablerecordvalidate.getText();
		Thread.sleep(3000);
		if(searctext.equalsIgnoreCase(Actual)) {
			Thread.sleep(1000);
			viewicon.click();
			Thread.sleep(3000);
			viewcontroltab.click();
			Thread.sleep(3000);
			ownershiptab.click();
			Thread.sleep(3000);
			linkcontrol.click();
			Reporter.log("System will display all fields of the Control created");
			clickonfullscreen();
			Thread.sleep(3000);
			scrolldown();
			clonecontrolbutton.click();
			Thread.sleep(3000);
			Reporter.log("System opens Clone Control Panel");
			Reporter.log("Clone Control URL"+driver.getCurrentUrl());
			Thread.sleep(3000);
			ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(newtab.get(1));
			Thread.sleep(3000);
			clickonfullscreen();
			Thread.sleep(3000);
			controlrefnoclone.click();
			Thread.sleep(3000);
			controlrefnoclone.clear();
			Thread.sleep(3000);
			controlrefnoclone.sendKeys(prop.readProperties("controlrefnoupdate"));
			Thread.sleep(3000);
			scrolldown();
			scrolldown();
			Thread.sleep(3000);
			nextbutton.click();
			scrolldown();
			Thread.sleep(3000);
			savebutton.click();
			Thread.sleep(3000);
			Reporter.log("Record already exists with Control name"+alerttitle.getText());
			Thread.sleep(3000);
			okbuttonalert.click();
			Thread.sleep(3000);
			clickonfullscreen();
			Logout();
			driver.switchTo().window(newtab.get(0));
			clickonfullscreen();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
