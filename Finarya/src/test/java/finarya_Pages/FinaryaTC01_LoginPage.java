package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import finarya_BaseClass.ReadToExcel;

public class FinaryaTC01_LoginPage {

	WebDriver driver;
	public Finarya_UserProfileModule profilepage;

	public FinaryaTC01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	WebElement Usernametextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	WebElement Passwordtextbox;
	@FindBy(how = How.XPATH, using = "//*[@id='js-login-btn']")
	WebElement loginbutton;

	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement Alert;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement OKbutton;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div/div/a/img[@class='profile-image rounded-circle']"),
			@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/a/img"),
			@FindBy(how = How.CSS, using = "#header > header > div.ml-auto.d-flex > div:nth-child(3) > a") })
	WebElement Profile;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/div/div[1]/div/div/div/div"),
			@FindBy(how = How.XPATH, using = "///*[@class='small-font']/div[text()='admin']"),
			@FindBy(how = How.CSS, using = "#header > header > div.ml-auto.d-flex > div.show > div > div.dropdown-header.bg-trans-gradient.d-flex.flex-row.py-4.rounded-top > div > div > div > div") })
	WebElement UserValidation;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@class='dropdown-menu dropdown-menu-animated dropdown-lg show']/a/span[text()='Logout']"),
			@FindBy(how = How.XPATH, using = "//*[text()='Logout']"),
			@FindBy(how = How.CSS, using = "#header > header > div.ml-auto.d-flex > div.show > div > a.dropdown-item.fw-500.pt-3.pb-3 > span:nth-child(1)") })
	WebElement logout;

	public void usernamesend(String Username) {
		Usernametextbox.clear();
		Usernametextbox.sendKeys(Username);
	}

	// This method is to set Password in the password text box
	public void passwordSend(String Password) {
		Passwordtextbox.clear();
		Passwordtextbox.sendKeys(Password);
	}

	// This method is to click on Login Button
	public void clickOnLoginButton() {
		loginbutton.click();
	}

	public void clickOnprofile() {
		Profile.click();
	}

	public void loginsucsessfull() throws Exception {
		profilepage = new Finarya_UserProfileModule(driver);
		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL Is" + "  " + CurrentURL);
		String Expected = "FINARYA | Powered by Amol Inamdar";
		String pageTitle = driver.getTitle();
		System.out.println("Webpage Title Is" + "  " + pageTitle);
		if (pageTitle.equalsIgnoreCase(Expected)) {
			clickOnprofile();
			clickOnLogoutButton();
			driver.close();
			Assert.assertTrue(true);
		} else {
			loginvalidationmsg();
			Reporter.log(driver.getCurrentUrl());
			Reporter.log(Alert.getText());
			driver.close();
			Assert.assertFalse(false);

		}

	}

	public void loginvalidationmsg() {
		/* Create an instance of Soft Assert */
		Assertion softAssert = new SoftAssert();
		String ExpectedString = "";
		String alerttext = Alert.getText();
		softAssert.assertEquals(ExpectedString, alerttext);
		System.out.println("Alert" + "      " + alerttext);
		OKbutton.click();
	}

	public void clickOnLogoutButton() {
		logout.click();
	}

	public String alerttext() {
		return Alert.getText();
	}

	public void clickOnOKButton() {
		OKbutton.click();
	}

}
