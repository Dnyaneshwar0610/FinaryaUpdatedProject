package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_AdministrationModule {
	
	WebDriver driver;
	
	public Finarya_AdministrationModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindAll({
	@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div/div/a/img[@class='profile-image rounded-circle']"),
	@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/a/img"),
	@FindBy(how =How.CSS,using="#header > header > div.ml-auto.d-flex > div:nth-child(3) > a")
	})WebElement Profile;
	//Administration Main Module
	@FindAll({
	@FindBy(how = How.XPATH, using = "//span[text()='Administration']"),
	@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/a//*[text()='Administration']"),
	})WebElement Administration;
	// NAV Link 
	
	//Department WorkBench
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li[3]/a[@title='Admin Workbench']"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[3]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li:nth-child(2) > a")
		})WebElement DepartmentWorkbench;
	
	//create department
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Create Department']"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[3]/ul/li[3]/ul/li[1]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(1) > a > span")
		})WebElement CreateDepartment ;
	//list department
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='List Department']"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[3]/ul/li[2]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(2) > a > span")
	})WebElement ListDepartment;
	
	//upload department
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Upload Department Master']"),
		@FindBy(how=How.CSS,using="##js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(3) > a"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[3]/ul/li[3]/a")
	})WebElement UploadDepartment;
	
	// User Managment
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a[@title='User Management']"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > a"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[4]/a/span")
		
	})WebElement UserManagement;
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Create Users']"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(1) > a > span"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[4]/ul/li[1]/a/span")
		
	})WebElement CreateUser;
	
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='LIST users screen']"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a/span[text()='List User']"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(2) > a")
	})WebElement ListUser;
	
	
	//Product Library
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a[@title='Product Library']"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[5]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li:nth-child(5) > a")
	})WebElement ProductLibrary;
	
	//List Of Product
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='List Product']"),
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[3]/ul/li[5]/ul/li[2]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(2) > a")
	})WebElement ProductList;
	
}
