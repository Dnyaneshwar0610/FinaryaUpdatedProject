package finarya_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Finarya_UserProfileModule {
	WebDriver driver;
   public Finarya_UserProfileModule(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	   
   }
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div/div/a/img[@class='profile-image rounded-circle']"),
		@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/a/img"),
		@FindBy(how =How.CSS,using="#header > header > div.ml-auto.d-flex > div:nth-child(3) > a")
		})WebElement Profile;
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@id='header']/header/div[4]/div[3]/div/div[1]/div/div/div/div"),
		@FindBy(how = How.XPATH, using = "///*[@class='small-font']/div[text()='admin']"),
		@FindBy(how =How.CSS,using="#header > header > div.ml-auto.d-flex > div.show > div > div.dropdown-header.bg-trans-gradient.d-flex.flex-row.py-4.rounded-top > div > div > div > div")
		})WebElement UserValidation;
	
	@FindAll({
		@FindBy(how = How.XPATH, using = "//*[@class='dropdown-menu dropdown-menu-animated dropdown-lg show']/a/span[text()='Logout']"),
		@FindBy(how = How.XPATH, using = "//*[text()='Logout']"),
		@FindBy(how =How.CSS,using="#header > header > div.ml-auto.d-flex > div.show > div > a.dropdown-item.fw-500.pt-3.pb-3 > span:nth-child(1)")
		})WebElement logout;
	
}
