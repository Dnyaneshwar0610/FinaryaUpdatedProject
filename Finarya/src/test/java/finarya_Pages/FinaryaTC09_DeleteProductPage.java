package finarya_Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC09_DeleteProductPage {
	public propertiesHandler prop = new propertiesHandler();
	WebDriver driver;
	Finarya_AdministrationModule mainmodule;
	public static final String PROPERTY_FILE = "TC09_DeleteProduct.properties";

	public FinaryaTC09_DeleteProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-product']/tbody/tr[1]/td[1]/a[3]")
	WebElement deleteicon;

	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='btnDeleteProducts']")
	WebElement Deletebutton;

	// Alert Content
	@FindBy(how = How.XPATH, using = "//div[@class='swal2-content']")
	WebElement alertmassage;
	@FindBy(how = How.XPATH, using = "//div[@class='swal2-actions']/button[text()='OK']")
	WebElement OkButton;

   //ROLE
		@FindBy(how = How.XPATH, using = "//*[@class='panel-content']/select[@id='rolesMulti']")
		WebElement Relepanellist;
		@FindBy(how = How.XPATH, using = "//*[@class='auxiliary']/input")
		WebElement inputsearchonrole;
	
	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	public void clickondeleteproduct() throws Exception {
		FinaryaTC08_UpdateViewProductPage updatepage = new FinaryaTC08_UpdateViewProductPage(driver);
		loadpropertiesfile();
		updatepage.ListProductSearchBox.clear();
		updatepage.ListProductSearchBox.sendKeys(prop.readProperties("updateinputproductname"));

		String expected = prop.readProperties("updateinputproductname");
		System.out.println("Expected" + expected);
		Thread.sleep(1500);
		String Actual = updatepage.perticularseachrecord.getText();
		System.out.println("Actual" + Actual);
		try {
			if (expected.equalsIgnoreCase(Actual)) {
				Thread.sleep(1500);
				boolean icon =deleteicon.isDisplayed();
				System.out.println("delete icon is display"+icon);
				if(icon==true) {
					deleteicon.click();
				}else {
					Reporter.log("Removal Of Role check Verification");
					RemovalofRoleCheck();
				}
				
				Reporter.log("System will open page Delete Product." + "   " + driver.getCurrentUrl());

			} else {
				Reporter.log("The Updated record will not matching");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonNextbutton() {
		Nextbutton.click();
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// scroll down
		jse.executeScript("window.scrollBy(0,850)", "");
	}

	public void clickondeletebutton() throws Exception {
		Deletebutton.click();
		String expectedStr = new String("You cannot delete this Product as it is linked with other entities.");
		System.out.println("Expected String" + expectedStr);
		Thread.sleep(1000);
		String Actual = new String(alertmassage.getText());
		System.out.println("Actual Alert Massages" + Actual);
		Thread.sleep(1000);
		boolean results = expectedStr.equalsIgnoreCase(Actual);
		System.out.println(results);
		if (results == true) {
			Thread.sleep(1000);
			OkButton.click();
			
		} else {
			Reporter.log(expectedStr);
		}

	}
	

	//ROLE

	public void RemovalofRoleCheck() throws Exception {
		Finarya_RemovalofRoleCheck removalofrole =new Finarya_RemovalofRoleCheck(driver);
		removalofrole.clickonuserlist();
		removalofrole.clickonseachloginID();
		Thread.sleep(1500);
		removalofrole.clickonupdateicon();
		removalofrole.clickonNextbutton();
		String inputrole=prop.readProperties("Removalroleassign");
		inputsearchonrole.sendKeys(inputrole);
		Thread.sleep(1500);
		Select select = new Select(Relepanellist);
		List<WebElement> options =select.getOptions();
		for(WebElement p: options) {
			if (p.getText().equals(inputrole)) {
			Thread.sleep(3000);
			 select.deselectByVisibleText(inputrole);
		}else {
			select.selectByVisibleText(inputrole);
			}
		}
		removalofrole.scrolldown();
		removalofrole.clickonupdate();
	}
}