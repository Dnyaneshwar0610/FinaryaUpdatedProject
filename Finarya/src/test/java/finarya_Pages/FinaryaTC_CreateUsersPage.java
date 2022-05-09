package finarya_Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FinaryaTC_CreateUsersPage {
	WebDriver driver;

	public FinaryaTC_CreateUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[5]/div[3]/a/img")
	WebElement Profile;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/a/span")
	WebElement Administration;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[4]/a/span")
	WebElement UserManagement;
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[4]/ul/li[1]/a/span")
	WebElement CreateUser;
	// Create User Page
	@FindBy(how = How.XPATH, using = "//*[@id='myUserId']")
	WebElement LoginIDTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='userFullName']")
	WebElement UserFullNameTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement PassTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement EmailTextBox;
	@FindBy(how = How.XPATH, using = "//*[@id='create_user_panel']/div/div[5]/div/span/span[1]/span")
	WebElement DepartmentDropDown;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	// List Of Element
	@FindBy(how = How.ID, using = "select2-departmentName-results")
	List<WebElement> autoSuggest;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement NextButton;
	// check box All
	@FindBy(how = How.XPATH, using = "//*[@id=\"panel-1\"]/div[2]/div/div/div[1]/div[2]/div[1]/input")
	WebElement AllCheckBox;
	@FindBy(how = How.XPATH, using = "//*[@id='btnSaveUser']")
	WebElement SaveButton;

	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement AlertText;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement Alerttitle;
	@FindBy(how = How.XPATH, using = "/html/body/div[6]/div/div[3]/button[1]")
	WebElement OkButton;

	public void clickonprofile() {
		Profile.click();
	}

	public void clickOnAdministration() {
		Administration.click();
	}

	public void clickOnUserManagement() {
		UserManagement.click();
	}

	public void clickOnCreateUser() {
		CreateUser.click();
	}

	public void loginIDTextBox(String LoginID) {
		LoginIDTextBox.clear();
		LoginIDTextBox.sendKeys(LoginID);
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

	public void departmentDropDown() {
		DepartmentDropDown.click();

	}

	public void searchDropDown(String Department) {
		DropdownSearchBox.click();
		DropdownSearchBox.sendKeys(Department);

	}

	public void dropdownvalue() throws Exception {
		Thread.sleep(3000);
		// print the auto suggest
		for (WebElement a : autoSuggest) {
			System.out.println("Values are = " + a.getText());
			if (a.getText().equalsIgnoreCase("CSI Software Testing"))
				;
			a.click();
			Thread.sleep(3000);
			break;
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
		String ExpectedResult0 = "Record already exists and Active in System !";
		String ActualResut0 = Alerttitle.getText();
		System.out.println("Expected Result Is=" + " " + ExpectedResult);
		String ActualResult = AlertText.getText().substring(14, 33);
		System.out.println("ActualResult Is =" + "  " + ActualResult);
		String ActualResultAlert = AlertText.getText();
		System.out.println("Actual Alert Result is=" + " " + ActualResultAlert);

		if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
			Assert.assertEquals(ActualResult, ExpectedResult);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(true);
		} else {
			Reporter.log(ActualResut0);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(false);
		}

	}

	public void clickonOkButton() {
		OkButton.click();

	}

}
