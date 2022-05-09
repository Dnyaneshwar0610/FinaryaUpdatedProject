package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_AuditModulePage {
	

	WebDriver driver;

	public Finarya_AuditModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu-wrapper-right-btn']/i"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu-wrapper-right-btn']"),
		@FindBy(how=How.CSS,using="#js-nav-menu-wrapper-right-btn > i")
	})WebElement ForwordArrow;
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[7]/a/span"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/a//*[text()='Audit']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/a[@title='Audit']")
	})WebElement AuditMain;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a[@title='Audit Audit Management']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li:nth-child(1) > a > span"),
	})
	WebElement AuditManagment;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Create Audit']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[1]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > a > span"),
	})
	WebElement AuditWorkbench;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='Create Audit']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[1]/ul/li[1]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > ul > li:nth-child(1) > a > span"),
	})
	WebElement Createaudit;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='List Audit']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[1]/ul/li[2]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > ul > li:nth-child(2) > a"),
	})
	WebElement ListofCreateaudit;
	
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='Auditee Workbench']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[1]/ul/li[4]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > ul > li:nth-child(4) > a"),
	})
	WebElement AuditeeWorkbench;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='Auditor Workbench']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[1]/ul/li[5]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > ul > li:nth-child(5) > a"),
	})
	WebElement AuditorWorkbench;
	
	
	//TC_71CreateAuditeeResponse And TC72_CreateAuditorResponse
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Interim Audit Response']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[4]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li.open > ul > li.open > ul > li.open > a"),
	})
	WebElement AuditResponse;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='Create Audit Response']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[4]/ul/li[1]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li.open > ul > li.open > ul > li.open > ul > li:nth-child(1) > a"),
	})
	WebElement CreateAuditResponse;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/ul/li/a[@title='Auditee Response']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[4]/ul/li[1]/ul/li[1]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li.open > ul > li.open > ul > li.open > ul > li.open > ul > li:nth-child(1) > a"),
	})
	WebElement AuditeeResponse;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/ul/li/a[@title='Auditor Response']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[4]/ul/li[1]/ul/li[2]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li.open > ul > li.open > ul > li.open > ul > li.open > ul > li:nth-child(2) > a"),
	})
	WebElement AuditorResponse;
	
//Issue Managment
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Issue Management']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[2]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li:nth-child(2) > a > span"),
	})
	WebElement IssuesManagement;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='List Issues']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[7]/ul/li[1]/ul/li[2]/ul/li[1]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(7) > ul > li.open > ul > li.open > ul > li:nth-child(1) > a"),
	})
	WebElement ListIssues;
	
	
}
