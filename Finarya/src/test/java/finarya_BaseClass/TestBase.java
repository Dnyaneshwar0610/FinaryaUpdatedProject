package finarya_BaseClass;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import finarya_DataProvider.ValidLogin;
import finarya_Pages.FinaryaTC01_LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static  Logger logger;

	@BeforeClass
	@Parameters({"CrossBrowserTesting","application_url"})
	public void LaunchBrowser(String CrossBrowserTesting,String application_url ) throws Exception {

		if (CrossBrowserTesting.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(application_url);

		} else if (CrossBrowserTesting.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(application_url);
			driver.findElement(By.xpath("//*[@id='details-button']")).click();
			driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		} else if (CrossBrowserTesting.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(application_url);

		} else if (CrossBrowserTesting.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(application_url);
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");

		}
             logger =Logger.getLogger("FINARYA");
             PropertyConfigurator.configure("log4j.properties");
	}
	

	@Test(dataProvider = "Login",dataProviderClass=ValidLogin.class)
	public void validLogin(String Username, String Password) throws Exception {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.usernamesend(Username);
		loginpage.passwordSend(Password);
		loginpage.clickOnLoginButton();
	}


	
	
	
}