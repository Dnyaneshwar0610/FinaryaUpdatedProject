package finarya_Pages;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC02_CreateViewDepartmentPage {
	WebDriver driver;
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC02_CreateViewDepartment.properties";
	public Finarya_AdministrationModule main;

	

	public FinaryaTC02_CreateViewDepartmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// create Depatment
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[1]/a")
	WebElement CreatedepTabExpe;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/ul/li[2]/a/span")
	WebElement LinkdepTabExpe;

	@FindBy(how = How.XPATH, using = "//*[@id='departmentName']")
	WebElement DepartmentName;
	// parent department name
	@FindBy(how = How.XPATH, using = "//*[@id='step-01']/div/div[2]/div/span/span[1]/span")
	WebElement Departmentparent;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	@FindBy(how = How.ID, using = "select2-parentDepartmentName-results")
	List<WebElement> autoSuggest;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;

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

	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[2]/div/button")
	WebElement Add;

	@FindBy(how = How.XPATH, using = "//*[@id='btnSaveDepartment']")
	WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement Validation;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[3]/button[1]")
	WebElement OkButton;
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	WebElement logout;

	// View Department
	
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department']/tbody/tr[1]/td[1]/a[1]")
	WebElement View;
	//VIEW TAB
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a[text()='Department']")
	WebElement Departmenttab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a/span[text()='Link Department']")
	WebElement linkdepartment;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a/span[text()='Life Events']")
	WebElement lifeevent;



	public void clickOndepartmentworkbench() {
		main=new Finarya_AdministrationModule(driver);
		main.Administration.click();
		main.DepartmentWorkbench.click();
		main.CreateDepartment.click();
	}
	public void expected() {
		try {
			SoftAssert softassertion = new SoftAssert();
			String ExpectedResult = "Create Department";
			String ActualResult = CreatedepTabExpe.getText();
			boolean Result = CreatedepTabExpe.isDisplayed();
			if (ExpectedResult.equalsIgnoreCase(ActualResult)) {
				softassertion.assertEquals(ActualResult, ExpectedResult);
				softassertion.assertTrue(true);
				Reporter.log(ActualResult);
			} else {
				softassertion.assertEquals(ActualResult, ExpectedResult);
				Assert.assertTrue(false);
				Reporter.log(ActualResult);
			}
			String ExpectedResultlink = "Link Processes";
			String ActualResultlink = LinkdepTabExpe.getText();
			boolean Resultlink = LinkdepTabExpe.isDisplayed();
			if (ExpectedResultlink.equalsIgnoreCase(ActualResultlink)) {
				softassertion.assertEquals(ActualResultlink, ExpectedResultlink);
				softassertion.assertTrue(true);
				Reporter.log(ActualResultlink);
			} else {
				softassertion.assertEquals(ActualResultlink, ExpectedResultlink);
				softassertion.assertTrue(false);
				Reporter.log(ActualResultlink);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public void departmentName(String Name) {
		DepartmentName.clear();
		DepartmentName.sendKeys(Name);
	}

	public void parentdep(String parentDep) {
		Departmentparent.click();
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
	}

	public void clickonNextButton() {
		Nextbutton.click();
	}

	public void clickonSubmitButton() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(1000);
		SubmitButton.click();
	}

	public void Assertion() {

		System.out.println("Validation Started");
		String ExpectedResult = "Created Successfully";
		System.out.println("Expected Result Is=" + " " + ExpectedResult);
		String ActualResult = Validation.getText().substring(20, 35);
		System.out.println("ActualResult Is =" + "  " + ActualResult);
		String ActualResultAlert = Validation.getText();
		if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
			assertEquals(ActualResult, ExpectedResult);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(true);
		} else {
			assertEquals(ActualResultAlert, ExpectedResult);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(false);
		}

	}

	public void clickonOkButton() {
		OkButton.click();

	}

	public void clickonlogout() {
		logout.click();

	}

	public void clickonviewdep() {
		main=new Finarya_AdministrationModule(driver);
		main.Administration.click();
		main.DepartmentWorkbench.click();
		main.ListDepartment.click();
		View.click();
		String viewurl = driver.getCurrentUrl();
		Reporter.log("Create Department View URL IS" + "    " + viewurl);
		Departmenttab.click();
		linkdepartment.click();
		lifeevent.click();
	}

}
