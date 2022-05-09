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

public class FinaryaTC41_ListIssuePage {
	
	WebDriver driver;
	public Finarya_AuditModulePage Audit;

	public FinaryaTC41_ListIssuePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues_length']/label/select"),
			@FindBy(how = How.CSS, using = "#csi-dt-issues_length > label > select") })
	WebElement selectshowentries;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues_length']/label/select"),
			@FindBy(how = How.CSS, using = "#csi-dt-issues_length > label > select") })
	List<WebElement> entriesselect;

	@FindAll({ @FindBy(how = How.XPATH, using = "//*[@id='csi-dt-issues_info']"),
			@FindBy(how = How.CSS, using = "#csi-dt-issues_info") })
	WebElement ListEntriesInfo;

	public void clickonlistofissue() throws Exception {
		Audit = new Finarya_AuditModulePage(driver);
		Thread.sleep(1500);
		Audit.ForwordArrow.click();
		Thread.sleep(1500);
		Audit.AuditMain.click();
		Thread.sleep(1500);
		Audit.AuditManagment.click();
		Thread.sleep(1500); 
		Audit.IssuesManagement.click();
		Thread.sleep(1500);
		Audit.ListIssues.click();
	}

	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", selectshowentries);

	}

	public void showentriesfromlist() throws Exception {

		Select select = new Select(selectshowentries);
		Thread.sleep(1000);
		select.selectByValue("5");
		Thread.sleep(1000);
		Reporter.log("List Value Select 5" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("10");
		Thread.sleep(1000);
		Reporter.log("List Value Select 10" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("25");
		Thread.sleep(1000);
		Reporter.log("List Value Select 25" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("50");
		Thread.sleep(1000);
		Reporter.log("List Value Select 50" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("100");
		Thread.sleep(1000);
		Reporter.log("List Value Select 100" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("10000");
		Thread.sleep(1000);
		Reporter.log("List Value Select 10,000" + ":-" + ListEntriesInfo.getText());
		scrolldown();
		Thread.sleep(1000);
		select.selectByValue("100000");
		Thread.sleep(1000);
		Reporter.log("List Value Select 100000" + ":-" + ListEntriesInfo.getText());

	}

	public void listselectentries() throws Exception {
		// webelement
		Select select = new Select(selectshowentries);
		// list of webelement
		entriesselect = select.getOptions();
		System.out.println(entriesselect.size());

		for (int i = 0; i < entriesselect.size(); i++) {
			scrolldown();
			Thread.sleep(3000);
			select.selectByIndex(i);
			WebElement option = select.getFirstSelectedOption();
			String Selectedvalues = option.getText();
			Thread.sleep(3000);
			Reporter.log("List Value Select:-" + Selectedvalues + "List Info Massage:-" + ListEntriesInfo.getText());
			Thread.sleep(1500);
		}
	}

	
	

}
