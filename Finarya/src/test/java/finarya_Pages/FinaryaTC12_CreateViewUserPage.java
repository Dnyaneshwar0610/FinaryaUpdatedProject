package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC12_CreateViewUserPage {
	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE ="TC12_CreateViewUser.properties";

	public FinaryaTC12_CreateViewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// Create User Page
	@FindBy(how = How.XPATH, using = "//*[@id='myUserId']")
	WebElement LoginIDTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='userFullName']")
	WebElement UserFullNameTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PassTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement EmailTextBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement NextButton;
//Assign Role
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div[2]/div/div/div[1]/div[2]/div[1]/input")
	WebElement AllCheckBox;
	@FindBy(how = How.XPATH, using = "//*[@id='btnSaveUser']")
	WebElement SaveButton;

	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement AlertText;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement Alerttitle;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='No']")
	WebElement Nobutton;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='Yes']")
	WebElement yesbutton;

	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[3]/button[1]")
	WebElement OkButton;

	public void clickoncreateuser() throws Exception {
		mainmodule = new Finarya_AdministrationModule(driver);
		Thread.sleep(1400);
		mainmodule.Administration.click();
		mainmodule.UserManagement.click();
		mainmodule.CreateUser.click();
		Reporter.log(
				"System will open Create User page with tabs Create User Assign Role" + " " + driver.getCurrentUrl());
	}

	public void loginIDTextBox(String LoginID) {
		LoginIDTextBox.clear();
		LoginIDTextBox.sendKeys(LoginID);
	}

	public void verifyfullnametextbox() {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys("ASSDuiouoiRT");
		// Retrieve typed value
		String typedValue = UserFullNameTextBox.getAttribute("value");
		// Get the length of typed value
		int size = typedValue.length();
		System.out.println("Size Of Attribute" + size);
		if (size == 0) {
			Reporter.log("Alphabets are not allowed.");
			System.out.println("Alphabets are not allowed.");
		} else {
			Reporter.log("System should allow only Alpha numeric values only to be entered ");
			System.out.println("System should allow only Alpha numeric values only to be entered ");

		}
	}

	public void verifyfullnametextbox1() {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys("123456789");
		// Retrieve typed value
		String typedValue = UserFullNameTextBox.getAttribute("value");
		// Get the length of typed value
		int size = typedValue.length();
		System.out.println("Size Of Attribute" + size);
		if (size == 0) {
			Reporter.log("Numbers are not allowed.");
			System.out.println("Numbers are not allowed.");
		} else {
			Reporter.log("should allow only Alpha numeric values ");
			System.out.println(" should allow only Alpha numeric values");

		}

	}

	public void userFullNameTextBox(String userFullName) {
		UserFullNameTextBox.clear();
		UserFullNameTextBox.sendKeys(userFullName);

	}

	public void passTextBox(String Password) {
		PassTextBox.clear();
		PassTextBox.sendKeys(Password);
	}

	public void emailTextBox(String Email) {
		EmailTextBox.clear();
		EmailTextBox.sendKeys(Email);
	}

		
	
	@FindBy(how = How.XPATH, using = "//*[@id='create_user_panel']/div/div[5]/div/span/span[1]/span")
	WebElement DepartmentDropDown;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	// List Of Element
	@FindBy(how = How.ID, using = "select2-departmentName-results")
	List<WebElement> autoSuggest;
	//COMMAN ALL SERCH ROLE BOX
		@FindBy(how = How.XPATH, using = "//ul[@role='listbox']/li")
		List<WebElement> AllSearch;
		
		public void departmentDropDown() {
			DepartmentDropDown.click();

		}

		public void searchDropDown() {
			loadpropertiesfile();
			DropdownSearchBox.click();
			String fromproperties = prop.readProperties("department");
			System.out.println("Department Name" + fromproperties);
			DropdownSearchBox.sendKeys(fromproperties);

		}

	public void dropdownvalue() throws Exception {
		
		Thread.sleep(3000);
		loadpropertiesfile();
		String fromproperties = prop.readProperties("department");
		Thread.sleep(3000);
		System.out.println("Total Auto Suggestion:-" + AllSearch.size());
		// print the auto suggest
		
		for (int i = 0; i < AllSearch.size(); i++) {
			String Allsuggestionlist = AllSearch.get(i).getText();
			System.out.println("dep" + Allsuggestionlist);
			String finalresult = prop.readProperties("department");
			if (Allsuggestionlist.equalsIgnoreCase(finalresult)) {
				AllSearch.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void clickonNextButton() {
		NextButton.click();
	}

	public void clickonAllCheckBox() {
		AllCheckBox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,440)", "");
	}

	public void clickonSaveButton() {

		SaveButton.click();
	}

	public void Assertion() {
		System.out.println("Validation Started");
		String ExpectedResult = "Created Successfully";
		String ExpectedResult0 = "Record already exists !";
		String ActualResut0 = Alerttitle.getText();
		System.out.println("Expected Result Is=" + " " + ExpectedResult);
		String ActualResult = AlertText.getText().substring(14, 34);
		System.out.println("ActualResult Is =" + "  " + ActualResult);
		String ActualResultAlert = AlertText.getText();
		System.out.println("Actual Alert Result is=" + " " + ActualResultAlert);

		if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
			Assert.assertEquals(ActualResult, ExpectedResult);
			Reporter.log(ActualResultAlert);
			OkButton.click();
			Assert.assertTrue(true);
		} else if (ExpectedResult0.equalsIgnoreCase(ActualResut0)) {
			Reporter.log(ActualResultAlert);
			Nobutton.click();
			Assert.assertTrue(true);
		} else {
			Reporter.log(ActualResut0);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(false);
		}

	}

}
