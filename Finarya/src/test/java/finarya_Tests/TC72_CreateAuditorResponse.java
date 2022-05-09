package finarya_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC71_CreateAuditeeResponsePage;
import finarya_Pages.FinaryaTC72_CreateAuditorResponsePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC72_CreateAuditorResponse {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC72_CreateAuditorResponse.xlsx";
		WebDriver driver;
		@Test(priority=1)
			@Parameters({"application_url"})
			public void LaunchBrowser(String application_url) throws Exception{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(application_url);
				driver.findElement(By.xpath("//*[@id='details-button']")).click();
				driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
				Thread.sleep(1500);
				
			}
			
			@Test(priority=2)
			public void auditorlogincreadential(){
				FinaryaTC72_CreateAuditorResponsePage auditeelogin= new FinaryaTC72_CreateAuditorResponsePage(driver);
				auditeelogin.auditorlogin();
			}
			@Test(priority=3,dataProvider="resposeauditor")
			public void createauditeeresponse(String auditorresponse,String issuesstatusfiled) throws Exception{
				FinaryaTC72_CreateAuditorResponsePage auditorcreate= new FinaryaTC72_CreateAuditorResponsePage(driver);
				auditorcreate.clickoncreateauditorresponse();
				auditorcreate.clickonauditorresponsebutton();
				auditorcreate.clickonfullscreenbutton();
				Thread.sleep(3000);
				auditorcreate.scrolldown();
				auditorcreate.senddataauditorresponse(auditorresponse);
				Thread.sleep(1000);
				
				//auditorcreate.clickonresponseauditorbrowsbutton();
				//auditorcreate.clickonresponseevidanceattacment();
				Thread.sleep(1000);
				auditorcreate.clickonissuescurrentstatus();
				Thread.sleep(1000);
				auditorcreate.clickonissuesstatus(issuesstatusfiled);
				Thread.sleep(1000);
				auditorcreate.clickonCommaninputSearchboxall();
				auditorcreate.clickonissuesclouserdate();
				auditorcreate.normalscrolldown();
				auditorcreate.clickonSubmitAuditorResponseButton();
				Thread.sleep(1000);
				auditorcreate.clickonfullscreenbutton();
		
			}

			

			@AfterClass
			public void Logout() {
				FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
				loginpage.clickOnprofile();
				loginpage.clickOnLogoutButton();
				driver.close();
			}

			
			@DataProvider(name = "resposeauditor")
			public Object[][] auditData() {

				Object[][] arrayObject = getExcelData(Path, "createauditresponse");
				return arrayObject;
			}

			public Object[][] getExcelData(String fileName, String sheetName) {
				Object[][] arrayExcelData = null;
				try {
					FileInputStream fs = new FileInputStream(fileName);
					XSSFWorkbook workbook = new XSSFWorkbook(fs);
					Sheet sheet = workbook.getSheet(sheetName);

					int totalrowcout = sheet.getPhysicalNumberOfRows();
					int totalcolcount = sheet.getRow(0).getPhysicalNumberOfCells();
					System.out.println(totalrowcout);
					System.out.println(totalcolcount);
					arrayExcelData = new Object[totalrowcout - 1][totalcolcount];

					for (int i = 1; i < totalrowcout; i++) {

						for (int j = 0; j < totalcolcount; j++) {
							arrayExcelData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
						}

					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return arrayExcelData;
			}

}
