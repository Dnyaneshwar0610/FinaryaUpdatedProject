package finarya_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FinaryaTC07_CreateViewProductPage {
	WebDriver driver;

	public FinaryaTC07_CreateViewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/a/span")
	WebElement Administration;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[5]/a/span")
	WebElement ProductLibrary;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[5]/ul/li[1]/a/span")
	WebElement CreateProduct;
	@FindBy(how = How.XPATH, using = "//div[@id='smartwizard']/ul")
	WebElement tab;
	@FindBy(how = How.XPATH, using = "//*[@id='productName']")
	WebElement ProductNameTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='step-1']/div/div[2]/div/span/span[1]/span")
	WebElement ParentProductName;
	// Comman Search Box For All
	@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input")
	WebElement SearchBox;
	// Parent Product ID
	@FindBy(how = How.XPATH, using = "//*[@id='parentProductId']")
	WebElement ppid;
	// All Tab Next Button Xpath Are Same
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;
	// Owner Tab
	@FindBy(how = How.XPATH, using = "//*[@id='inlineRadio1']")
	WebElement PrimaryradioButton;
	@FindBy(how = How.XPATH, using = "//*[@id='primaryOwnerRow_0']/div[3]/div/span/span[1]/span")
	WebElement DepartmentName;
	@FindBy(how = How.XPATH, using = "//*[@id='add-button']")
	WebElement Add;
	// Link Product Tab
	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[1]/div/span/span[1]/span")
	WebElement Department;

	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[2]/div/span/span[1]/span")
	WebElement Process;
	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[3]/div/span/span[1]/span")
	WebElement Risk;
	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[1]/div[4]/div/span/span[1]/span")
	WebElement Control;
	@FindBy(how = How.XPATH, using = "//*[@id='step-2']/div[2]/div/button")
	WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//*[@id='btnSaveProducts']")
	WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[3]/button[1]")
	WebElement OkButton;

	public void clickOnadministration() {
		Administration.click();
	}

	public void clickOnProductLibrary() {
		ProductLibrary.click();
	}

	public void clickonCreateProduct() {
		CreateProduct.click();
		Reporter.log("System will open up and show tabs" + "   " + tab.getText());
	}

	public void ClickonProductNameTextBox(String ProductName) {
		ProductNameTextBox.clear();
		ProductNameTextBox.sendKeys(ProductName);

	}

	public void clickonParentProductName() {
		ParentProductName.click();
	}

	// click On Comman Search Box
	public void clickonSearchBox(String SearchData) {
		SearchBox.click();
		SearchBox.sendKeys(SearchData);
		SearchBox.sendKeys(Keys.ENTER);
	}

	public void parentproductid() {
		Reporter.log("System will automatically populate Parent Product ID Is" + "  " + ppid.getText());
	}

	// Click On Comman Next Button
	public void clickonNextbutton() {
		Nextbutton.click();
		Reporter.log("System opens up Ownership Tab");
	}

	public void clickonPrimaryradioButton() {
		PrimaryradioButton.click();
	}

	public void ClickonDepartmentName(String Name) {
		DepartmentName.clear();
		DepartmentName.sendKeys(Name);
	}

	public void ClickonAdd() {
		Add.click();
	}

	public void ClickonDepartment() {
		Department.click();
	}

	public void ClickonProcess() {
		Process.click();
	}

	public void ClickonRisk() {
		Risk.click();
	}

	public void ClickonControl() {
		Control.click();
	}

	public void clickonAddButton() {
		AddButton.click();
	}

	public void clickonSubmitButton() {
		SubmitButton.click();
	}

	public void ClickonOkButton() {
		OkButton.click();
	}
}
