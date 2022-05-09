package finarya_Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC28_UpdateViewControlPage {

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC28_UpdateViewControl.properties";
	WebDriver driver;
	public Finarya_RiskManagementModule riskmodule;

	public FinaryaTC28_UpdateViewControlPage(WebDriver driver) {
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

	public void clickonlistcontrol() throws Exception {
		riskmodule = new Finarya_RiskManagementModule(driver);
		Thread.sleep(1500);
		riskmodule.riskmanagement.click();
		Thread.sleep(1500);
		riskmodule.riskandcontrollibrary.click();
		Thread.sleep(1500);
		riskmodule.controllibrary.click();
		Thread.sleep(1500);
		riskmodule.listcontrol.click();
		Thread.sleep(1500);
		Reporter.log(
				"System opens page  List Control Master with Search Functionality" + ":-" + driver.getCurrentUrl());
	}

//LIST SEARCH FIELDS
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control_filter']/label/input")
	WebElement searchbox;

	// UPDATE CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[2]")
	WebElement tablerecordvalidate;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[1]/a[2]")
	WebElement updateicon;
	// UPDATE TAB COMMAN
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul")
	WebElement updatetab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a[text()='Update Control']")
	WebElement updatecontroltab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a/span[text()='Link Control']")
	WebElement linkcontrol;
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateControl']")
	WebElement clonecontrolbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='controlRefNo']")
	WebElement controlrefnoclone;
	@FindBy(how = How.XPATH, using = "//*[@id='btnCloneControl']")
	WebElement savebutton;

	public void searchrecord() {
		try {
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("searchupdatecontrol");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("searchupdatecontrol"));
			Thread.sleep(3000);
			String Actual = tablerecordvalidate.getText();
			Thread.sleep(3000);
			if (searctext.equalsIgnoreCase(Actual)) {
				Thread.sleep(1000);
				updateicon.click();
				Reporter.log("System will open Update Control Panel " + driver.getCurrentUrl());
				Thread.sleep(3000);
				Reporter.log("Update Tab Is" + updatetab.getText());
				Thread.sleep(3000);
			} else {
				Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickoncontrolrefno(String refno) {
		controlrefno.clear();
		controlrefno.sendKeys(refno);
	}

	public void clickoncontroltitle(String Title) {
		controltitle.clear();
		controltitle.sendKeys(Title);
	}

	public void clickoncontroldescription(String Controldescription) {
		controldescription.clear();
		controldescription.sendKeys(Controldescription);
	}

	public void verifyparentcontrolid() {
		String typevalue = parentcontrolid.getAttribute("value");
		System.out.println("System will automatically populate Parent Control ID:-" + typevalue);
		Reporter.log("System will automatically populate Parent Control ID:-" + typevalue);
	}

	public void clickonfullscreen() {
		fullscreen.click();
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
	}

	// NEXT BUTTON
	public void clickonnextbutton() {
		nextbutton.click();
	}

	// OWNER TAB

	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[2]")
	WebElement ownertab;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/span/span/span")
	WebElement departmentname;
	@FindBy(how = How.ID, using = "select2-departmentName_0-results")
	List<WebElement> autoSuggest;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/label/input[1]")
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
			if (Allsuggestionlist.equalsIgnoreCase(finalresult)) {
				AllSearch.get(i).click();
				pributton.click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	// LINK CONTROL
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

	// DEPARTMENT
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

	// PRODUCT
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

	// PROCESS

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

	// RISK
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
			String Expected = "Linked entites already selected for this control.";
			String Actual = alertmassegge.getText();
			if (Expected.equalsIgnoreCase(Actual)) {
				Reporter.log(Actual);
				okbuttonalert.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//REMOVE ENTITIES OR REMOVE BUTTON
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-link-entities']/tbody/tr[1]/td[6]/button[text()='Remove']")
	WebElement button;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-link-entities']/tbody/tr/td/button[text()='Remove']")
	List<WebElement> removebutton;

	public void clickonremovebutton() {
		System.out.println("Size Of Remove Button Is:-" + removebutton.size());
		int i = 0;
		while (i <= removebutton.size()) {
			button.click();
			i++;
		}

	}

//UPDATE BUTTON CLICK
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateControl']")
	WebElement updatebutton;

	public void clickonupdatebutton() {
		updatebutton.click();
		try {
			Reporter.log(alertmassegge.getText());
			String Expected = "Control creation failed.";
			String Actual = alerttitle.getText();
			if (Expected.equalsIgnoreCase(Actual)) {
				Reporter.log("Record already exists with Control name" + alerttitle.getText());
				okbuttonalert.click();
				Logout();
			} else {
				okbuttonalert.click();
				Reporter.log(alertmassegge.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("System opens page List Control Master and the Control ID created is listed here.:-"
				+ driver.getCurrentUrl());
	}

	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

	// VIEW TAB COMMAN
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[1]/a[1]")
	WebElement viewicon;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a[text()='View Control']")
	WebElement viewcontroltab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a[text()='Ownership']")
	WebElement ownershiptab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul[@role='tablist']/li/a/span[text()='Link Control']")
	WebElement linkcontroltab;

	public void viewcontrolrecord() throws Exception {
		try {
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("searchrecordafterupdate");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("searchrecordafterupdate"));
			Thread.sleep(3000);
			String Actual = tablerecordvalidate.getText();
			Thread.sleep(3000);
			if (searctext.equalsIgnoreCase(Actual)) {
				Thread.sleep(1000);
				viewicon.click();
				Thread.sleep(3000);
				viewcontroltab.click();
				Thread.sleep(3000);
				ownershiptab.click();
				Thread.sleep(3000);
				linkcontroltab.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ****************************************************

}