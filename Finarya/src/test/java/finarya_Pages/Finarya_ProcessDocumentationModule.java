package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_ProcessDocumentationModule {
WebDriver driver;
	public Finarya_ProcessDocumentationModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Process Documentation Main Module
	@FindAll({
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[5]/a/span"),
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[5]/a/b"),
	@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(5) > a > span")
	})WebElement ProcessDocumentation;
	
	//Process Library
	@FindAll({
	@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[5]/ul/li[1]/a/span"),
	@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a[@title='Process Library']"),
	@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(5) > ul > li:nth-child(1) > a > span")
	})WebElement ProcessLibrary;

	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[5]/ul/li[1]/ul/li[1]/a"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/ul/li/a[@title='Create Process']"),
		@FindBy(how =How.CSS,using="#js-nav-menu > li:nth-child(5) > ul > li:nth-child(1) > a > span")
		})WebElement CreateProcess;
	//list process
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='js-nav-menu']/li[5]/ul/li[1]/ul/li[2]/a"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li[1]//ul/li/a[@title='List Process']"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(3) > ul > li.open > ul > li:nth-child(2) > a > span")
	})WebElement ListProcess;
	
	
}
