package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC08_UpdateViewProductPage {
	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "TC08_UpdateViewProduct.properties";

	public FinaryaTC08_UpdateViewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-product_filter']/label/input")
	WebElement ListProductSearchBox;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-product']/tbody/tr/td[2]")
	WebElement perticularseachrecord;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-product']/tbody/tr[1]/td[1]/a[2]")
	WebElement updateicon;
	@FindBy(how = How.XPATH, using = "//div[@id='smartwizard']/ul")
	WebElement tab;
	@FindBy(how = How.XPATH, using = "//*[@id='productId']")
	WebElement productId;
	@FindBy(how = How.XPATH, using = "//*[@id='productName']")
	WebElement ProductNameTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div/div[2]/div/span/span[1]/span")
	WebElement ParentProductName;
	// comman search box all
	@FindAll({ @FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']"),
			@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input"),
			@FindBy(how = How.CSS, using = "body > span > span > span.select2-search.select2-search--dropdown > input") })
	WebElement CommaninputSearchboxall;

	// comman search box result container

	@FindAll({ @FindBy(how = How.XPATH, using = "//span[@class='select2-results']"),
			@FindBy(how = How.XPATH, using = "/html/body/span/span/span[2]"),
			@FindBy(how = How.CSS, using = "body > span > span > span.select2-results") })
	List<WebElement> searchboxresultall;
	@FindBy(how = How.XPATH, using = "//*[@id='parentProductId']")
	WebElement ppid;
	// All Tab Next Button Xpath Are Same
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;
	// Alert Content
	@FindBy(how = How.XPATH, using = "//div[@class='swal2-content']")
	WebElement alertmassage;
	@FindBy(how = How.XPATH, using = "//div[@class='swal2-actions']/button[text()='OK']")
	WebElement OkButton;

	// OwnerShip Tab
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div[1]/div")
	WebElement primarybutton;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div/div/span/span/span[@role='combobox']")
	WebElement departmentname;
	@FindBy(how = How.XPATH, using = "//*[@id='add-button']")
	WebElement addbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow']/div/div[4]/div/a/i")
	List<WebElement> minusbutton;

	// link product tab
	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[1]/div/span/span[1]/span")
	WebElement department;
	@FindBy(how = How.ID, using = "//*[@id='select2-masterDepartmentsDropdown-results']")
	List<WebElement> autoSuggestDepartmentSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[2]/div/span/span[1]/span")
	WebElement Process;
	@FindBy(how = How.ID, using = "select2-masterProcessesDropdown-results")
	List<WebElement> autoSuggestProcessSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[3]/div/span/span[1]/span")
	WebElement Risk;
	@FindBy(how = How.ID, using = "select2-masterRisksDropdown-results")
	List<WebElement> autoSuggestRiskSearchbox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[4]/div/span/span[1]/span")
	WebElement Control;
	@FindBy(how = How.XPATH, using = "//*[@class='select2-results']/ul/li")
	List<WebElement> autoSuggestControlSearchbox;
	// @FindBy(how = How.ID, using = "select2-masterControlsDropdown-results")
	// List<WebElement> autoSuggestControlSearchbox;

	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;

	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[2]/div/button")
	WebElement Add;
	// update button
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateProducts']")
	WebElement Updatebutton;

	// view
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-product']/tbody/tr[1]/td[1]/a[1]")
	WebElement viewicon;
	// view ownershiptab
	@FindBy(how = How.XPATH, using = "//div[@class='panel-content']/ul/li/a[text()='Ownership']")
	WebElement ownershiptab;
	@FindBy(how = How.XPATH, using = "//div[@class='panel-content']/ul/li/a/span[text()='Link Product']")
	WebElement linkProduct;

	// log out
	@FindBy(how = How.XPATH, using = "//*[text()='Logout']")
	WebElement logout;

	public void clickonlistproduct() throws Exception {
		mainmodule = new Finarya_AdministrationModule(driver);
		Thread.sleep(1400);
		mainmodule.Profile.click();
		mainmodule.Administration.click();
		mainmodule.ProductLibrary.click();
		mainmodule.ProductList.click();
		Reporter.log(
				"System will open page List Product Master with Search Functionality" + "   " + driver.getCurrentUrl());
	}

	public void clickonsearch() throws Exception {
		loadpropertiesfile();
		ListProductSearchBox.clear();
		ListProductSearchBox.sendKeys(prop.readProperties("inputproductname"));

		String expected = prop.readProperties("inputproductname");
		System.out.println("Expected" + expected);
		Thread.sleep(1500);
		String Actual = null;
		try {
			Actual = perticularseachrecord.getText();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Actual" + Actual);
		try {
			if (expected.equalsIgnoreCase(Actual)) {
				Thread.sleep(1500);
				updateicon.click();
				Reporter.log("System will open up" + "   " + driver.getCurrentUrl());
				Reporter.log("System will open up and show tabs" + "   " + tab.getText());
			} else {
				Reporter.log("The corresponding record will not matching");
				Reporter.log("The corresponding record may be Updated");
				clickonviewproductupdated();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void captureproductid() {
		Reporter.log("System will automatically populate Product ID Is" + "  " + productId.isDisplayed());
	}

	public void clickonProductNameTextBox(String ProductName) {
		ProductNameTextBox.clear();
		try {
			OkButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProductNameTextBox.click();
		ProductNameTextBox.sendKeys(ProductName);

	}

	public void clickonParentProductName() {
		ParentProductName.click();
	}

	public void clickonNextbutton() {
		Nextbutton.click();
	}

	// click On Comman Search Box
	public void clickonSearchBox(String SearchData) {
		CommaninputSearchboxall.click();
		CommaninputSearchboxall.sendKeys(SearchData);
		CommaninputSearchboxall.sendKeys(Keys.ENTER);
	}

	public void clickonprimarybutton() throws Exception {
		Thread.sleep(1500);
		primarybutton.click();
	}

	public void clickondepartmentname(String department) {
		departmentname.click();
		CommaninputSearchboxall.click();
		CommaninputSearchboxall.sendKeys(department);

	}

	public void clickonCommaninputSearchboxall() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : searchboxresultall) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equalsIgnoreCase(prop.readProperties("departmentnameproperties")))
				;
			p.click();
			Thread.sleep(3000);
			break;
		}
	}

	public void addbutton() {
		for (int i = 0; i < 3; i++) {
			addbutton.click();
		}
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// scroll down
		jse.executeScript("window.scrollBy(0,550)", "");
	}

	public void minusbutton() throws Exception {

		int minusbuttonsize = minusbutton.size();
		System.out.println("Size of minus Button is" + minusbuttonsize);
		for (int i = minusbuttonsize - 1; i > 0; i--) {
			Thread.sleep(1000);
			minusbutton.get(i).click();
			Reporter.log("The Field is deleted");
		}

	}

	public void clickondepartment(String departmentselect) {
		department.click();
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(departmentselect);
	}

	public void dropdowndepartment() throws Exception {
		Thread.sleep(3000);
		loadpropertiesfile();
		for (WebElement p : autoSuggestDepartmentSearchbox) {
			System.out.println("Values are = " + p.getText());
			if (p.getText().equals(prop.readProperties("department")))
				;
			p.click();
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
			if (a.getText().equals(prop.readProperties("Process")))
				;
			a.click();

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
			if (a.getText().equals(prop.readProperties("Risk")))
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
		loadpropertiesfile();
		Thread.sleep(3000);
		for (WebElement a : autoSuggestControlSearchbox) {
			System.out.println("Values are = " + a.getText());
			Thread.sleep(3000);
			if (a.getText().equals(prop.readProperties("Control")))
				;
			Thread.sleep(3000);
			a.click();
			break;
		}

	}

	public void clickonAddButton() throws Exception {
		Add.click();
		Thread.sleep(1500);
		String massage = alertmassage.getText();
		Reporter.log("System displays message" + "  " + massage);
		OkButton.click();
		Reporter.log("The selected data will be populated in below table");
	}

	public void clickonUpdateButton() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(1000);
		Updatebutton.click();
		String massage = alertmassage.getText();
		Reporter.log("System displays message" + "  " + massage);
		OkButton.click();
		Reporter.log("System opens List Product Master and the record created above will be listed below." + ""
				+ driver.getCurrentUrl());
	}

	public void clickonviewproductupdated() throws Exception {

		loadpropertiesfile();
		clickonlistproduct();
		ListProductSearchBox.clear();
		ListProductSearchBox.sendKeys(prop.readProperties("updateinputproductname"));

		String expected = prop.readProperties("updateinputproductname");
		System.out.println("Expected" + expected);
		Thread.sleep(1500);
		String Actual = perticularseachrecord.getText();
		System.out.println("Actual" + Actual);
		try {
			if (expected.equalsIgnoreCase(Actual)) {
				Thread.sleep(1500);
				viewicon.click();
				Reporter.log("System will open up" + "   " + driver.getCurrentUrl());
				Thread.sleep(1400);
				ownershiptab.click();
				linkProduct.click();

			} else {
				Reporter.log("The Updated record will not matching");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
