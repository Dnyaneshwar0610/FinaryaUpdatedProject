package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC14_DeleteUserPage {

	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "TC14_DeleteUser.properties";

	public FinaryaTC14_DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// comman fullscreen button
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[2]")
	WebElement fullscreen;

	public void clickonlistuser() throws Exception {
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
	List<WebElement> tablerecordvalidate;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td")
	WebElement nodataavailabletable;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr/td/a[4]")
	List<WebElement> deleteicon;

	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement NextButton;

	public void searchrecord() throws Exception {

		loadpropertiesfile();
		searchbox.clear();
		searchbox.click();
		String searctext = prop.readProperties("deletesearchusername");
		System.out.println(searctext);
		searchbox.sendKeys(prop.readProperties("deletesearchusername"));
		try {
			Thread.sleep(3000);
			System.out.println("Total List Of Record Is:-" + tablerecordvalidate.size());
			for (int i = 0; i < tablerecordvalidate.size(); i++) {
				String ActualResult = tablerecordvalidate.get(i).getText();
				String expectedresult = prop.readProperties("deletesearchusername");
				if (ActualResult.equals(expectedresult)) {
					Reporter.log("The corresponding record will be displayed");
					deleteicon.get(i).click();
					Reporter.log("System will open Delete User Panel " + driver.getCurrentUrl());
					NextButton.click();
					fullscreen.click();
					scrolldown();
					clickondeletebutton();
					searchrecordafterdelete();
					break;
				} else {
					nodatavailable();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void nodatavailable() throws Exception {
		try {
			String searctext = prop.readProperties("deletesearchusername");
			LoginID.sendKeys(searctext);
			Thread.sleep(3000);
			String Actualresult = nodataavailabletable.getText();
			System.out.println("No Data Actual Result" + "  :-    " + Actualresult);
			String Expectedresult = "No data available in table";
			Thread.sleep(3000);
			if (Expectedresult.equalsIgnoreCase(Actualresult)) {
				Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
				Reporter.log("Record Is Deleted:-" + nodataavailabletable.getText());
			} else {
				System.out.println("Search Record Invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
	}

	// Delete Button
	@FindBy(how = How.XPATH, using = "//*[@id='btnDeleteUser']")
	WebElement deletebutton;
	// COMMAN ALERT CONTENT
	// ALERT CONTENT
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement alertmassegge;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
	WebElement okbuttonalert;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement alerttitle;
	// You are permanently deleting a Record.
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='Yes, Delete Record.']")
	WebElement yesdeletebutton;

	public void clickondeletebutton() {
		deletebutton.click();
		String ActualResult = alertmassegge.getText();
		System.out.println("Actual result delete record is:-" + ActualResult);
		String ExpectedResult = "You are permanently deleting a Record.";
		if (ActualResult.equalsIgnoreCase(ExpectedResult)) {
			yesdeletebutton.click();
			Reporter.log("Yes Delete Record permanently :-" + ActualResult);
			Reporter.log("User will be taken to List Control Master table with search functionality. :-"
					+ driver.getCurrentUrl());
			okbuttonalert.click();
		} else {
			Reporter.log("Record can not be deleted as it is linked with other Entities");
		}
	}

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td")
	WebElement deleterecordserchtext;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tfoot/tr/th[2]/input")
	WebElement LoginID;

	public void searchrecordafterdelete() {
		try {
			Thread.sleep(3000);
			loadpropertiesfile();
			searchbox.clear();
			Thread.sleep(3000);
			searchbox.click();
			String searctext = prop.readProperties("deletesearchusername");
			System.out.println(searctext);
			Thread.sleep(3000);
			searchbox.sendKeys(searctext);
			LoginID.sendKeys(searctext);
			Thread.sleep(3000);
			Reporter.log("Record Is Deleted:-" + deleterecordserchtext.getText());

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
