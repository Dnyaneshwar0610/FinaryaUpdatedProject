package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC03_UpdateViewDepartmentPage {
	WebDriver driver;
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC03_UpdateViewDepartment.properties";
	public Finarya_AdministrationModule main;
	public FinaryaTC03_UpdateViewDepartmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// administration
	@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[5]/div[3]/a/img")
	WebElement Profile;
	@FindBy(how = How.XPATH, using = "//span[text()='Administration']")
	WebElement Administration;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[3]/a/span")
	WebElement Department;
//list

	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[3]/ul/li[2]/a/span")
	WebElement ListDepartment;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department_filter']/label/input")
	WebElement ListDepartmentSearch;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department']/tbody/tr[1]/td[1]/a[2]")
	WebElement update;
	@FindBy(how =How.XPATH,using="//*[@id='csi-dt-department']/tbody/tr[1]/td[1]/a[1]")
	WebElement View;
//VIEW TAB
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a[text()='Department']")
	WebElement Departmenttab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a/span[text()='Link Department']")
	WebElement linkdepartment;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a/span[text()='Life Events']")
	WebElement lifeevent;
	
// Update Department Tab
	@FindBy(how = How.XPATH, using = "//*[@id='departmentName']")
	WebElement DepartmentName;
	// parent department name
	@FindBy(how=How.XPATH,using="//*[@id='select2-parentDepartmentName-container']/span")
	WebElement Dropdownvalueclear;
	@FindBy(how = How.XPATH, using = "//*[@id='step-01']/div/div[3]/div/span/span[1]/span")
	WebElement Departmentparent;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	@FindBy(how = How.ID, using = "select2-parentDepartmentName-results")
	List<WebElement> autoSuggest;
	// Next Button
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;
	// product process risk control tab
	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[1]/div[1]/div/span/span[1]/span")
	WebElement Product;
	@FindBy(how = How.ID, using = "select2-masterProductsDropdown-results")
	List<WebElement> autoSuggestProductSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[1]/div[2]/div/span/span[1]/span")
	WebElement Process;
	@FindBy(how = How.ID, using = "select2-masterProcessesDropdown-results")
	List<WebElement> autoSuggestProcessSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[1]/div[3]/div/span/span[1]/span")
	WebElement Risk;
	@FindBy(how = How.ID, using = "select2-masterRisksDropdown-results")
	List<WebElement> autoSuggestRiskSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[1]/div[4]/div/span/span[1]/span")
	WebElement Control;
	@FindBy(how = How.ID, using = "select2-masterControlsDropdown-results")
	List<WebElement> autoSuggestControlSearchbox;
//add button
	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[2]/div/button")
	WebElement Add;

	// Final
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateDepartment']")
	WebElement Updatebutton;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement Validation;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[3]/button[1]")
	WebElement OkButton;
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	WebElement logout;

	public void clickOnlistdepartment() {
		main=new Finarya_AdministrationModule(driver);
		main.Administration.click();
		main.DepartmentWorkbench.click();
		main.ListDepartment.click();
	}

	public void clickonsearch() {
		loadpropertiesfile();
		ListDepartmentSearch.clear();
		ListDepartmentSearch.sendKeys(prop.readProperties("ListDepartmentsearch"));
	}

	public void clickonupdate() throws InterruptedException {
		Thread.sleep(2000);
		update.click();
		String CurrentURL = driver.getCurrentUrl();
		Reporter.log(CurrentURL);
	}

	public void departmentName(String Name) throws Exception {
		Thread.sleep(1000);
		DepartmentName.clear();
		Thread.sleep(1000);
		DepartmentName.sendKeys(Name);
	}

	public void parentdep(String parentDep) throws InterruptedException {
		Thread.sleep(1000);
		Dropdownvalueclear.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(parentDep);

	}

	public void dropdownvalue() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		// print the auto suggest
		for (WebElement a : autoSuggest) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase(prop.readProperties("ParentDepartmentName")))
				;
			a.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void clickonNextButton() {
		Nextbutton.click();
	}
	public void clickonproduct(String product) {
		Product.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(product);
	}

	public void dropdownproduct() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : autoSuggestProductSearchbox) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("Product")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}

	}

	public void clickonprocess(String process) {
		Process.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(process);
	}

	public void dropdownprocess() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement a : autoSuggestProcessSearchbox) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase(prop.readProperties("Process")))
				;
			a.click();
			Thread.sleep(3000);
			break;
		}

	}

	public void clickonrisk(String risk) {
		Risk.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(risk);
	}

	public void dropdownrisk() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement a : autoSuggestRiskSearchbox) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase(prop.readProperties("Risk")))
				;
			a.click();
			Thread.sleep(3000);
			break;
		}

	}

	public void clickoncontrol(String control) throws Exception {
		Control.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(control);
	}

	public void dropdowncontrol() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement a : autoSuggestControlSearchbox) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase(prop.readProperties("Control")))
				;
			a.click();
			Thread.sleep(3000);
			break;
		}

	}


	public void clickonAddButton() {
		Add.click();
		try {
			String ActualResult = Validation.getText();
			Reporter.log(ActualResult);
			System.out.println("Add Button Alert"+ActualResult);
		}catch(Exception e) {
			e.printStackTrace();
		}
		OkButton.click();
	}
	
	public void scrolldown() throws Exception {
		Thread.sleep(1500);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll up
		jse.executeScript("window.scrollBy(0,-250)","");
		//scroll down
		 jse.executeScript("window.scrollBy(0,950)","");
	}
	
	public void clickonupdatebutton() throws Exception {
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Updatebutton));
		Updatebutton.click();
		Thread.sleep(1000);
		try {
			String Alert =Validation.getText();
			System.out.println(Alert);
			Reporter.log(Alert);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
public void clickonokbutton() throws Exception {
	OkButton.click();
	Thread.sleep(1000);
	String URL=driver.getCurrentUrl();
	Reporter.log("System openes List Department Master"+"   "+URL);
}

public void clickonviewdep() {
	View.click();
	String updateviewurl=driver.getCurrentUrl();
	Reporter.log("View UPDATE URL IS"+"    "+updateviewurl);
	Departmenttab.click();
	linkdepartment.click();
	lifeevent.click();
}


public void clickonlogout() {
	logout.click();
	
}


}
