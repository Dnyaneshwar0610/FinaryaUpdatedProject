package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_RCASolutionModule {

	WebDriver driver;
	public Finarya_RCASolutionModule(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu-wrapper-right-btn']/i"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu-wrapper-right-btn']"),
		@FindBy(how=How.CSS,using="#js-nav-menu-wrapper-right-btn > i")
	})WebElement ForwordArrow;
	
	@FindAll({
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li[8]/a/span"),
		@FindBy(how =How.XPATH,using="//*[@id='js-nav-menu']/li/a[@title='RCA and Solution']/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(8) > a > span")
	})WebElement RCASolution ;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li/ul/li/a/span[text()='RCA']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[8]/ul/li[1]/a/span"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(8) > ul > li.open > a > span"),
	})
	WebElement RCA;
	
	@FindAll({
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[8]/ul/li[1]/ul/li[3]/a/span[text()='My RCA']"),
		@FindBy(how=How.XPATH,using="//*[@id='js-nav-menu']/li[8]/ul/li[1]/ul/li[3]/a"),
		@FindBy(how=How.CSS,using="#js-nav-menu > li:nth-child(8) > ul > li.open > ul > li:nth-child(3) > a > span"),
	})
	WebElement MyRCA;
	
}
