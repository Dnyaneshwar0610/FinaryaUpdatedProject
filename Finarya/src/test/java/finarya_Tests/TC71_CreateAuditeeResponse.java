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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC03_UpdateViewDepartmentPage;
import finarya_Pages.FinaryaTC71_CreateAuditeeResponsePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TC71_CreateAuditeeResponse {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC71_CreateAuditeeResponse.xlsx";
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
	public void auditeelogincreadential(){
		FinaryaTC71_CreateAuditeeResponsePage auditeelogin= new FinaryaTC71_CreateAuditeeResponsePage(driver);
		auditeelogin.auditeelogin();
	}
	@Test(priority=3,dataProvider="resposeauditee")
	public void createauditeeresponse(String issuesresponse,String DelayReason,String RCARequiredFields,String AuditeeResponsible,String AuditeeAccountable,String AuditeeConsulted,String AuditeeInformed) throws Exception{
		FinaryaTC71_CreateAuditeeResponsePage auditeelogin= new FinaryaTC71_CreateAuditeeResponsePage(driver);
		auditeelogin.clickoncreateauditeeresponse();
		auditeelogin.clickonauditeeresponsebutton();
		Thread.sleep(1000);
		auditeelogin.scrolldown();
		auditeelogin.senddataissueresponse(issuesresponse);
		Thread.sleep(1500);
		auditeelogin.scrolldown();
		try {
			auditeelogin.senddatareasonfordelay(DelayReason);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auditeelogin.scrolldown();
		Thread.sleep(1500);
		auditeelogin.clickonexpecteddateclosure();
	
		//auditeelogin.clickonresponseevidancebutton();
		//auditeelogin.clickonresponseevidanceattacment();
		Thread.sleep(1000);
		auditeelogin.clickonRCARequired(RCARequiredFields);
		Thread.sleep(1000);
		auditeelogin.clickonCommaninputSearchboxall();
		auditeelogin.scrolldown();
		Thread.sleep(1000);
		auditeelogin.clickonResponsible(AuditeeResponsible);
		auditeelogin.clickonsearchResposible();
		Thread.sleep(1000);
		auditeelogin.clickonAccountable(AuditeeAccountable);
		auditeelogin.clickonsearchboxAuditeeAccountable();
		Thread.sleep(1000);
		auditeelogin.clickonConsulted(AuditeeConsulted);
		auditeelogin.clickonSerachAuditeeConsulted();
		Thread.sleep(1000);
		auditeelogin.clickonInformed(AuditeeInformed);
		auditeelogin.clickonSerchInformed();
		
		auditeelogin.clickonSubmitAuditeeResponseButton();
	}

	
	

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

	
	@DataProvider(name = "resposeauditee")
	public Object[][] auditData() {

		Object[][] arrayObject = getExcelData(Path, "createauditeeresponse");
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
