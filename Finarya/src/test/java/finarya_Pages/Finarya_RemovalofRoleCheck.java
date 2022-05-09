package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class Finarya_RemovalofRoleCheck {
	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "RemovalofRoleCheck.properties";

	public Finarya_RemovalofRoleCheck(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tfoot/tr/th[2]/input"),
			@FindBy(how = How.CSS, using = "#csi-dt-audit > tfoot > tr > th:nth-child(2) > input") })
	WebElement searchloginid;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr[1]/td[1]/a[3]"),
			@FindBy(how = How.CSS, using = "#csi-dt-audit > tbody > tr:nth-child(1) > td.sorting_1.dtr-control > a:nth-child(3)") })
	WebElement updateicon;

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-audit']/tbody/tr[1]/td[2]")
	WebElement verifyloginid;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;

	//ROLE
	@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/select[@id='rolesMulti']")
	WebElement Relepanellist;
	@FindBy(how = How.XPATH, using = "//*[@class='auxiliary']/input")
	WebElement inputsearchonrole;
	//Update Button
	@FindBy(how = How.XPATH, using = "//*[@id='btnUpdateUser']")
	WebElement updatebutton;
	
	// Alert Content
		@FindBy(how = How.XPATH, using = "//div[@class='swal2-content']")
		WebElement alertmassage;
		@FindBy(how = How.XPATH, using = "//div[@class='swal2-actions']/button[text()='OK']")
		WebElement OkButton;
	
	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	public void clickonuserlist() {
		mainmodule = new Finarya_AdministrationModule(driver);
		mainmodule.Administration.click();
		mainmodule.UserManagement.click();
		mainmodule.ListUser.click();
		Reporter.log("System will open List Users table with Search Functionality" + "" + driver.getCurrentUrl());

	}

	public void clickonseachloginID() {
		loadpropertiesfile();
		searchloginid.clear();
		searchloginid.click();
		searchloginid.sendKeys(prop.readProperties("LoginIDSearch"));
	}

	public void clickonupdateicon() {
		String Expected = prop.readProperties("LoginIDSearch");
		String Actual = verifyloginid.getText();
		if (Expected.equalsIgnoreCase(Actual)) {
			updateicon.click();
			Reporter.log("Removal Of Role Check");
			Reporter.log("System will open Update User page" + "" + driver.getCurrentUrl());
		} else {
			Reporter.log("User Login ID Not Match");
		}

	};

	public void clickonNextbutton() {
		Nextbutton.click();
	}
	
	
	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,440)", "");
	}
	
	public void  clickonupdate() {
	    updatebutton.click();
		Reporter.log("Update User "+alertmassage.getText());
	    OkButton.click();
	}
	
}