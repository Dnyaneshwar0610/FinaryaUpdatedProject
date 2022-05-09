package finarya_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.csipl.finarya.properties.propertiesHandler;

public class FinaryaTC04_DeleteDepartmentPage {
	WebDriver driver;
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "TC04_DeleteDepartment.properties";
	public Finarya_AdministrationModule main;

	

	public FinaryaTC04_DeleteDepartmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department_filter']/label/input")
	WebElement ListDepartmentSearch;
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department']/tbody/tr[1]/td[1]/a[3]")
	WebElement Deleteicon;
	@FindBy(how = How.XPATH, using = "//*[@id='smartwizard']/div[2]/div/button[2]")
	WebElement Nextbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='step-02']/div[2]/button")
	WebElement Deletebutton;
	@FindBy(how = How.XPATH, using = "//*[@id='btnDeleteDepartment']")
	WebElement ChildDeletebutton;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes, Delete Record.']")
	WebElement Alertbutton;
	@FindBy(how = How.XPATH, using = "//*[@id='swal2-content']")
	WebElement Validation;
	//after delete search and find data
	@FindBy(how = How.XPATH, using = "//*[@id='csi-dt-department']/tbody/tr/td")
	WebElement listmessage;
	@FindBy(how = How.XPATH, using = "//button[text()='OK'] ")
	WebElement OkButton;
	//button[text()='OK'] 
	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}

	public void clickOnlistdepartment() {
		main=new Finarya_AdministrationModule(driver);
		main.Administration.click();
		main.DepartmentWorkbench.click();
		main.ListDepartment.click();
	}


	public void clickonsearch() {
		loadpropertiesfile();
		ListDepartmentSearch.clear();
		ListDepartmentSearch.sendKeys(prop.readProperties("ListDepartmentsearch"));
	}

	public void clickondelete() throws Exception {
		Thread.sleep(1000);
		Deleteicon.click();
		Thread.sleep(1000);
		String DeleteURL = driver.getCurrentUrl();
		Reporter.log("System will open page Delete Department." + "\n" +DeleteURL);
	}

	public void clickonnext() throws Exception {
		Thread.sleep(1000);
	    Nextbutton.click();
	}
	
	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//scroll down
		 jse.executeScript("window.scrollBy(0,950)","");
	}

	public void clickondeletebutton() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Deletebutton));
		Deletebutton.click();
	}

	public void deletealert() throws Exception {
		
		String ExpectedResult = "Department cannot be deleted as it has other records such as Issue, Audit, Risks, Controls etc. linked to it.";
	    String ExpectedResult1 = "You are permanently deleting a Record.";
		try {
			scrolldown();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ChildDeletebutton));
			ChildDeletebutton.click();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			Thread.sleep(1500);
			if (ExpectedResult1.equalsIgnoreCase(Validation.getText())) {
				String Alertmassege1 = Validation.getText();
				Reporter.log("System gives message" + "\n" + Alertmassege1);
				WebDriverWait waits = new WebDriverWait(driver, 10);
				waits.until(ExpectedConditions.elementToBeClickable(Alertbutton));
	          	Alertbutton.click();
	          	Thread.sleep(1500);
	          	String ClickonYes = Validation.getText();
	          	Reporter.log("Click On Yes Permentantly Delete Recored massegae" + "\n" + ClickonYes);
	          	OkButton.click();
				String Url = driver.getCurrentUrl();
				Reporter.log("Delete Record System openes" + "\n" + Url);
				Thread.sleep(1500);
				clickonsearch();
				try{
					String massageonlist =listmessage.getText();
					Reporter.log("Screen will not display this record under Department Column as the same was Deleted by the Tester"+"\n"+massageonlist);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				}
			else if (ExpectedResult.equalsIgnoreCase(Validation.getText())) {
				String Alertmassege = Validation.getText();
				Reporter.log("System opens a Modal" + "\n" +Alertmassege);
				Thread.sleep(1000);
				OkButton.click();
				String URL=driver.getCurrentUrl();
				Reporter.log("System opens a Modal" + "\n" +URL);
				
			}
			else {
				System.out.println("Validation Error");
				OkButton.click();
			
			}
		}
	
	
	}

