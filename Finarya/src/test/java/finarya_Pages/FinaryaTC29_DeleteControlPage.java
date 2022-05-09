package finarya_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC29_DeleteControlPage {

	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC29_DeleteControl.properties";
	private static final String Actual = null;
	WebDriver driver;
	public Finarya_RiskManagementModule riskmodule;

	public FinaryaTC29_DeleteControlPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	// COMMAN NEXT BUTTON
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement nextbutton;
	// comman fullscreen button
	@FindBy(how = How.XPATH, using = "//*[@id='panel-1']/div/div/button[2]")
	WebElement fullscreen;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td")
	WebElement deleterecordserchtext;

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

	// LIST SEARCH FIELDS
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control_filter']/label/input")
	WebElement searchbox;

	// DELETE CONTROL
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[2]")
	WebElement tablerecordvalidate;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-control']/tbody/tr/td[1]/a[3]")
	WebElement deleteicon;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul")
	WebElement updatetab;
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/div/ul/li/a[text()='Delete Control']")
	WebElement deletecontroltab;

	public void searchrecord() throws Exception {

		loadpropertiesfile();
		searchbox.clear();
		searchbox.click();
		String searctext = prop.readProperties("searchdeleterecord");
		System.out.println(searctext);
		searchbox.sendKeys(prop.readProperties("searchdeleterecord"));
		Thread.sleep(3000);
		try {
			String Actual = tablerecordvalidate.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
		if (searctext.equalsIgnoreCase(Actual)) {
			Thread.sleep(1000);
			deleteicon.click();
			Reporter.log("System will open Delete Control Panel " + driver.getCurrentUrl());
			Thread.sleep(3000);
			Reporter.log("DELETE Tab Is:-" + updatetab.getText());

		} else {
			Reporter.log("Record Not Found OR Search Record Is May Be Updated Please Check");
			Reporter.log("Record Is Deleted:-" + deleterecordserchtext.getText());
			Logout();
		}

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

//Delete Button
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateControl']")
	WebElement deletebutton;
	// COMMAN ALERT CONTENT
	// ALERT CONTENT
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement alertmassegge;
	@FindBy(how = How.XPATH, using = "//*[@class='swal2-actions']/button[text()='OK']")
	WebElement okbuttonalert;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-title']")
	WebElement alerttitle;
//You are permanently deleting a Record.
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

	public void searchrecordafterdelete() {
		try {
			loadpropertiesfile();
			searchbox.clear();
			searchbox.click();
			String searctext = prop.readProperties("searchdeleterecord");
			System.out.println(searctext);
			searchbox.sendKeys(prop.readProperties("searchdeleterecord"));
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
