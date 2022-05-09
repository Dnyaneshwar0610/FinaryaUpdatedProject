package finarya_Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
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

public class FinaryaTC32_CreateViewAuditPage {
	WebDriver driver;
	public Finarya_AuditModulePage Audit;

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC32_CreateViewAudit.properties";

	public FinaryaTC32_CreateViewAuditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//div[@id='smartwizard']/ul/li/a[text()='Audit']"),
			@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[1]/a"),
			@FindBy(how = How.CSS, using = "#smartwizard > ul > li.nav-item.active > a") })
	WebElement Auditepanel;
	@FindAll({ @FindBy(how = How.XPATH, using = "//div[@id='smartwizard']/ul/li/a[text()='Stakeholders']"),
			@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[2]/a"),
			@FindBy(how = How.CSS, using = "#smartwizard > ul > li:nth-child(2) > a") })
	WebElement Stakeholderspanel;
	@FindAll({ @FindBy(how = How.XPATH, using = "//div[@id='smartwizard']/ul/li/a[text()='Checklist']"),
			@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[5]/a"),
			@FindBy(how = How.CSS, using = "#smartwizard > ul > li:nth-child(5) > a") })
	WebElement Checklistpanel;

	@FindBy(how = How.XPATH, using = "//*[@id='auditNumberInternal']")
	WebElement IntAudNumTextbox;
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-internalExternal-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-internalExternal-container']/span") })
	WebElement Auditbreachtype;

	// comman search box all

	@FindAll({ @FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']"),
			@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input"),
			@FindBy(how = How.CSS, using = "body > span > span > span.select2-search.select2-search--dropdown > input") })
	WebElement CommaninputSearchboxall;

	@FindAll({ @FindBy(how = How.XPATH, using = "//span[@class='select2-results']"),
			@FindBy(how = How.XPATH, using = "/html/body/span/span/span[2]"),
			@FindBy(how = How.CSS, using = "body > span > span > span.select2-results") })
	List<WebElement> searchboxresultall;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-auditType-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-auditType-container']/span") })
	WebElement auditType;
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-auditSubType-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-auditSubType-container']/span") })
	WebElement auditSubType;
	@FindBy(how = How.XPATH, using = "//*[@id='auditDescription']")
	WebElement auditDescrtextbox;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//div[@class='daterangepicker ltr auto-apply single opensright show-calendar']//td"),
			@FindBy(how = How.XPATH, using = "//div[@class='calendar-table']//td") })
	List<WebElement> ComCalender;

	@FindBy(how = How.XPATH, using = "//*[@id='auditPeriodStartDate']")
	WebElement AuditPeriodStartDate;
	@FindBy(how = How.XPATH, using = "//*[@id='auditPeriodEndDate']")
	WebElement auditPeriodEndDate;

	@FindBy(how = How.XPATH, using = "//*[@id='select2-auditTestingCycle-container']")
	WebElement auditTestingCycle;
	@FindBy(how = How.XPATH, using = "//*[@id='startDate']")
	WebElement Startdate;
	@FindBy(how = How.XPATH, using = "//*[@id='endDate']")
	WebElement Enddate;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='step-1']/form/div[2]/div[13]/div/span/span[1]/span"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-departmentName-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-departmentName-container']/span") })
	WebElement departmentName;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='step-1']/form/div[2]/div[18]/div/span/span[1]/span"),
			@FindBy(how = How.CSS, using = "#step-1 > form > div.form-row > div:nth-child(18) > div > span > span.selection > span"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-branchName-container']/span") })
	WebElement BranchName;

	@FindBy(how = How.XPATH, using = "//*[@id='branchCode']")
	WebElement branchCode;
	@FindBy(how = How.XPATH, using = "//*[@id='costCenter']")
	WebElement costCenter;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='auditStakeHolderRow_0']/div/div[3]/div/span/span[1]/span"),
			@FindBy(how = How.CSS, using = "#auditStakeHolderRow_0 > div > div:nth-child(3) > div > span > span.selection > span") })
	WebElement UserName1;
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='auditStakeHolderRow_1']/div/div[3]/div/span/span[1]/span"),
			@FindBy(how = How.CSS, using = "#auditStakeHolderRow_1 > div > div:nth-child(3) > div > span > span.selection > span") })
	WebElement UserName2;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-userRole_0-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-userRole_0-container']/span") })
	WebElement UserRole1;
	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-userRole_1-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-userRole_1-container']/span") })
	WebElement UserRole2;
	@FindBy(how = How.XPATH, using = "//*[@id='add-button']")
	WebElement addbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='hideRisk']/span")
	WebElement hideRisk;
	@FindBy(how = How.XPATH, using = "//*[@id='controls_list_table']/tbody/tr[1]/td[1]/input[@type='checkbox']")
	WebElement controllisttable;

	@FindBy(how = How.XPATH, using = "//*[@id='selected_controls_table']/tbody/tr")
	WebElement selectedcontrollisttable;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='processRiskControlUploadBox']"),
			@FindBy(how = How.XPATH, using = "//div[@class='custom-file']"),
			@FindBy(how = How.CSS, using = "#processRiskControlUploadBox") })
	WebElement FileUpload;
	@FindBy(how = How.XPATH, using = "//*[@id='submitButton']")
	WebElement submitbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement alertmsgauditcreate;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement alertokbutton;
	@FindAll({ @FindBy(how = How.XPATH, using = "//button[text()='Additional Fields']"),
			@FindBy(how = How.XPATH, using = "//*[@id='advancebtnFiledsvisible']"),
			@FindBy(how = How.CSS, using = "#advancebtnFiledsvisible") })
	WebElement additionalfieldsbutton;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='select2-samplingMethodology-container']"),
			@FindBy(how = How.XPATH, using = "//*[@id='select2-samplingMethodology-container']/span") })
	WebElement samplingMethodology;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='sampleCount']"),
			@FindBy(how = How.CSS, using = "#sampleCount") })
	WebElement samplecount;

	public void clickonforwordarrow() {
		Audit = new Finarya_AuditModulePage(driver);
		Audit.ForwordArrow.click();
	}

	public void clickonaudit() throws Exception {
		Thread.sleep(1000);
		Audit = new Finarya_AuditModulePage(driver);
		Audit.AuditMain.click();
	}

	public void clickonauditmanagment() throws InterruptedException {
		Thread.sleep(1000);
		Audit = new Finarya_AuditModulePage(driver);
		Audit.AuditManagment.click();
	}

	public void clickonauditworkbench() throws Exception {
		Thread.sleep(1000);
		Audit = new Finarya_AuditModulePage(driver);
		Audit.AuditWorkbench.click();
	}

	public void clickoncreateaudit() throws Exception {
		Thread.sleep(1000);
		Audit = new Finarya_AuditModulePage(driver);
		Audit.Createaudit.click();
	}

	public void verifyCreateAuditPanel() {
		boolean Audit = Auditepanel.isDisplayed();
		boolean Stakeholders = Stakeholderspanel.isDisplayed();
		boolean Checklist = Checklistpanel.isDisplayed();
		if (Audit == true) {
			Reporter.log("Expected Result is System opens page Create Audit Panel with Tabs Is Display" + "  "
					+ Auditepanel.getText());
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		if (Stakeholders == true) {
			Reporter.log("Expected Result is System opens page Create Audit Panel with Tabs Is Display" + "  "
					+ Stakeholderspanel.getText());
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		if (Checklist == true) {
			Reporter.log("Expected Result is System opens page Create Audit Panel with Tabs Is Display" + "  "
					+ Checklistpanel.getText());
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void clickonAudNumTextbox(String addnum) {
		IntAudNumTextbox.sendKeys(addnum);

	}

	public void clickonAuditbreachtype(String breachtype) {
		Auditbreachtype.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(breachtype);

	}

	public void clickonCommaninputSearchboxall() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("AuditBreachType")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonAudittype(String audittype) throws Exception {
		Thread.sleep(1000);
		auditType.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(audittype);

	}

	public void clickonaudittype() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("Audittype")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonAuditsubtype(String AuditSubtype) {
		auditSubType.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(AuditSubtype);

	}

	public void clickonauditsubtype() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("AuditSubtype")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void auditDescription(String AuditDesc) {
		auditDescrtextbox.clear();
		auditDescrtextbox.click();
		auditDescrtextbox.sendKeys(AuditDesc);
	}

	public void clickonapStartDate() {
		AuditPeriodStartDate.clear();
		AuditPeriodStartDate.click();
		for (WebElement ele : ComCalender) {
			String date = ele.getText();
			Calendar now = Calendar.getInstance();
			int day = now.get(Calendar.DAY_OF_MONTH);
			String currentday = Integer.toString(day);

			if (date.equalsIgnoreCase(currentday)) {
				ele.click();
				break;
			}
		}
	}

	public void clickonapEndDate() throws Exception {

		Date dt = new Date();
		auditPeriodEndDate.clear();
		auditPeriodEndDate.click();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, 1);
		dt = calendar.getTime();
		String tommorowsDate = new SimpleDateFormat("dd/MMM/yyyy").format(dt);
		// enter tomorrow's date in the field
		Thread.sleep(1000);
		auditPeriodEndDate.sendKeys(tommorowsDate);
		auditPeriodEndDate.click();
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// scroll down
		jse.executeScript("window.scrollBy(0,950)", "");
	}

	public void clickonAudittestinglife(String Auditlifecycle) throws Exception {
		Thread.sleep(1000);
		auditTestingCycle.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(Auditlifecycle);

	}

	public void clickonaudittestinglifecycle() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("AuditTestingCycle")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonstartDate() {
		Startdate.clear();
		Startdate.click();
		for (WebElement sdate : ComCalender) {
			String date = sdate.getText();
			Calendar now = Calendar.getInstance();
			int day = now.get(Calendar.DAY_OF_MONTH);
			String currentday = Integer.toString(day);

			if (date.equalsIgnoreCase(currentday)) {
				sdate.click();
				break;
			}
		}
	}

	public void clickonendDate() throws Exception {

		Date dt = new Date();
		Enddate.clear();
		Enddate.click();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.add(Calendar.DATE, 31);
		dt = calendar.getTime();
		String tommorowsDate = new SimpleDateFormat("dd/MMM/yyyy").format(dt);
		// enter tomorrow's date in the field
		Thread.sleep(1000);
		Enddate.sendKeys(tommorowsDate);

	}

	public void clickonadditionalfields() throws Exception {
		Thread.sleep(1000);
		additionalfieldsbutton.click();
	}

	public void clickonsamplingmethdology(String samplingmethdology) throws Exception {
		Thread.sleep(1000);
		samplingMethodology.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(samplingmethdology);

	}

	public void clickonsamplingmethdologysearchbox() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("samplingMethodology")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonsamplecount(String Samplecount) throws Exception {
		Thread.sleep(1000);
		samplecount.sendKeys(Samplecount);
	}

	public void clickondepartmentName(String Depatmentname) throws Exception {
		Thread.sleep(1500);
		boolean depa = departmentName.isDisplayed();
		boolean depa1 = departmentName.isEnabled();
		System.out.println(depa);
		System.out.println(depa1);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(departmentName));
		departmentName.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(Depatmentname);

	}

	public void clickondepartmentNamesearch() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("DepartmentName")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonBranchname(String Branchname) {
		boolean branch = BranchName.isDisplayed();
		boolean branch1 = BranchName.isEnabled();
		System.out.println(branch);
		System.out.println(branch1);
		BranchName.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(Branchname);

	}

	public void clickonBranchnamesearch() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("BranchName")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void getcostcode() {
		Reporter.log("Branch Code Is Automaticaly Created Is" + " " + branchCode.getText());
		Reporter.log("Cost Center Name Is Automaticaly Created Is" + " " + costCenter.getText());

	}

	public void clickonnextbutton() throws InterruptedException {
		Thread.sleep(1000);
		Nextbutton.click();
	}

	public void clickonusername1(String username1) throws Exception {
		Thread.sleep(1000);
		UserName1.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(username1);

	}

	public void clickonusernamesearchbox1() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("UserName1")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonuserroal1(String userroal1) throws Exception {
		Thread.sleep(1000);
		UserRole1.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(userroal1);

	}

	public void clickonuserroalsearchbox1() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("UserRole1")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonaddbutton() {
		addbutton.click();
	}

	public void clickonusername2(String username2) throws Exception {
		Thread.sleep(1000);
		UserName2.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(username2);

	}

	public void clickonusernamesearchbox2() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("UserName2")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonuserroal2(String userroal2) throws Exception {
		Thread.sleep(1000);
		UserRole2.click();
		CommaninputSearchboxall.clear();
		CommaninputSearchboxall.sendKeys(userroal2);

	}

	public void clickonuserroalsearchbox2() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("UserRole2")))
				;
			Thread.sleep(3000);
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void gettexthiderisk() {
		Reporter.log("System opens up Assign Process, Risk & Control to Auditor" + "   " + hideRisk.getText());

	}

	public void clickonchechbox() throws Exception {
		Thread.sleep(1000);
		controllisttable.click();
		boolean checkboxcontrollist = controllisttable.isSelected();
		Reporter.log("System will display the matching record in the table" + "   " + checkboxcontrollist);

	}

	public void selectedcontrolrecord() {
		Reporter.log("System will display the matching record in the Selected control table" + "   "
				+ selectedcontrollisttable.getText());
	}

	public void scrollup() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// scroll down
		jse.executeScript("window.scrollBy(0,-350)", "");
	}

	public void clickonbrowsefile(WebDriver driver) throws Exception {
		Thread.sleep(3000);
		FileUpload.click();
		StringSelection ss = new StringSelection("C:\\Users\\CSI-Dev\\Downloads\\finaryalogo.jpg");
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

	public void clickonsubmitbutton() {
		submitbutton.click();

	}

	public void verifycreateaudit() {
		String Verifycreateaudit = alertmsgauditcreate.getText();
		Reporter.log("Audit ID = *** Created Successfully." + "" + Verifycreateaudit);
		alertokbutton.click();
		String URL = driver.getCurrentUrl();
		Reporter.log("After Sucessfully Create Audit Open URL Is" + "  " + URL);
		String ExpectedURL = "https://10.10.10.14:9443/showListAuditsPage";
		String ActulURL = URL;
		
	}

}