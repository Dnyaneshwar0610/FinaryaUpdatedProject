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

public class FinaryaTC13_UpdateViewUserPage {

	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "TC13_UpdateViewUser.properties";
	

	public FinaryaTC13_UpdateViewUserPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateUser']")
	WebElement updatebutton;

	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement AlertText;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement Alerttitle;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='No']")
	WebElement Nobutton;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='Yes']")
	WebElement yesbutton;

	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
	WebElement OkButton;

	public void clickonupdateuser() throws Exception {
		mainmodule = new Finarya_AdministrationModule(driver);
		Thread.sleep(1400);
		mainmodule.Administration.click();
		mainmodule.UserManagement.click();
		mainmodule.ListUser.click();
		Reporter.log("System will open List Users table with Search Functionality" + " " + driver.getCurrentUrl());
	}

	// LIST SEARCH FIELDS
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit_filter']/label/input")
	WebElement searchbox;

	// UPDATE CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td[2]")
	WebElement tablerecordvalidate;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td[1]/a[3]")
	WebElement updateicon;

	public void searchrecord() {
		try {
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("searchusername");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("searchusername"));
			
			Thread.sleep(3000);
			String Actual = tablerecordvalidate.getText();
			Thread.sleep(3000);
			if (searctext.equalsIgnoreCase(Actual)) {
				Thread.sleep(1000);
				Reporter.log("The corresponding record will be displayed");
				updateicon.click();
				Reporter.log("System will open Update User Panel " + driver.getCurrentUrl());
			} else {
				Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
				Logout();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickonuserid() {
		String typevalue = LoginIDTextBox.getAttribute("value");
		Reporter.log("Login ID Is:=" + typevalue);
		Reporter.log("Login ID IS Enabled:=" + LoginIDTextBox.isEnabled());
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
		try {
			String ExpectedResult = "Invalid Email ID!";
			String ActualResult = AlertText.getText();
			if (ExpectedResult.equalsIgnoreCase(ActualResult)) {
				OkButton.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		EmailTextBox.sendKeys(Email);
	}

	@FindBy(how = How.XPATH, using = " //*[@id='select2-departmentName-container']")
	WebElement DepartmentDropDown;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	WebElement DropdownSearchBox;
	// List Of Element
	@FindBy(how = How.ID, using = "select2-departmentName-results")
	List<WebElement> autoSuggest;
	// COMMAN ALL SERCH ROLE BOX
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
		
	}
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[@data-original-title='Fullscreen']")
	WebElement fullscreen;
	
	
	public void clickonupdatebutton() {
		fullscreen.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,440)", "");
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView();", updatebutton);
		updatebutton.click();
	}
	
	
	
	public void assertion() {
		System.out.println("Validation Started");
		String ExpectedResult = "Updated Successfully.";
		String ExpectedResult0 = "Record already exists !";
		String ActualResut0 = Alerttitle.getText();
		System.out.println("Expected Result Is=" + " " + ExpectedResult);
		String ActualResult = AlertText.getText().substring(14, 35);
		System.out.println("ActualResult Is =" + "  " + ActualResult);
		String ActualResultAlert = AlertText.getText();
		System.out.println("Actual Alert Result is=" + " " + ActualResultAlert);

		if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
			Assert.assertEquals(ActualResult, ExpectedResult);
			Reporter.log(ActualResultAlert);
			OkButton.click();
			Assert.assertTrue(true);
			Reporter.log("System opens List Users page and the record Updated  is listed below.:="+driver.getCurrentUrl());
	
		} else {
			Reporter.log(ActualResut0);
			Reporter.log(ActualResultAlert);
			Assert.assertTrue(false);
		}

	}
	
	public void viewuserupdeted() throws Exception {
		clickonupdateuser();
		
		}
	
	//NO DATA Table Xpath
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td")
	WebElement tabledata;
	
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td[1]/a[2]")
	WebElement viewicon;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tabs']/ul/li/a[text()='Roles']")
	WebElement roletab;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tabs']/ul/li/a[text()='Departments']")
	WebElement departmenttab;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td[3]")
	WebElement usernamevalidate;
	
	public void searchrecordupdeted() throws Exception {
		
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("serchuserupdeted");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("serchuserupdeted"));
			Thread.sleep(3000);
			try {
			String Actual = usernamevalidate.getText();
			System.out.println(Actual);
			Thread.sleep(3000);
			if (searctext.equalsIgnoreCase(Actual )) {
				Reporter.log("The corresponding record will be displayed");
				Thread.sleep(1000);
				Reporter.log("System will display the matching record in the table");
				viewicon.click();
				Reporter.log("System will open View tabs:="+driver.getCurrentUrl());
				Thread.sleep(1000);
				roletab.click();
				Reporter.log("System will display Roles of that user.");
				Thread.sleep(1000);
				departmenttab.click();
				Reporter.log("System will display Department ID and Name of the User ");
				
				
			} else {
				
				Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
				Reporter.log("No Search Record Found:="+tabledata.getText());
			}
		
			} catch (Exception e) {
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
