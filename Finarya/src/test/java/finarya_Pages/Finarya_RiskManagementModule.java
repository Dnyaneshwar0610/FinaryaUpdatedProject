package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_RiskManagementModule {
	
	WebDriver driver;
	
	public Finarya_RiskManagementModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//Risk Management Main Module
	@FindAll({
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/a/span"),
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/a/b"),
	@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(6) > a > span")
	})WebElement riskmanagement;
	
//Risk And Library
	@FindAll({
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/ul/li[1]/a/span"),
	@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a[@title='Risk & Control Library']"),
	@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li:nth-child(1) > a > span")
	}) WebElement riskandcontrollibrary;
//Risk Library
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[1]/a/span"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Risk Library']"),
		@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li.open > ul > li:nth-child(1) > a > span")
		})WebElement risklibrary;

	
//List Risk
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[1]/ul/li[2]/a/span"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[1]/ul/li[2]/a[@title='List Risk']"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li.open > ul > li.open > ul > li:nth-child(2) > a > span")
	})WebElement listrisk;
	
	
	
//Control Library
		@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[2]/a/span"),
			@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Control Library']"),
			@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li.open > ul > li.open > a > span")
			}) WebElement controllibrary;
		
//Create Control 
		@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li/ul/li/ul/li/ul/li/a[@title='Create Control'] "),
			@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[2]/ul/li[1]/a/span"),
			@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li.open > ul > li.open > ul > li:nth-child(1) > a > span")
			})WebElement createcontrol;
		
//List Control
		@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[2]/ul/li[2]/a/span"),
			@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[6]/ul/li[1]/ul/li[2]/ul/li[2]/a[@title='List Control']"),
			@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(6) > ul > li.open > ul > li.open > ul > li:nth-child(2) > a > span")
		}) WebElement listcontrol;
		
	
	

}
