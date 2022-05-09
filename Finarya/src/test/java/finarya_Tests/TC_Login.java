package finarya_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;

public class TC_Login extends TestBase {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/LoginTest.xlsx";
	
		@Test(priority=1)
		public void logout(){
		FinaryaTC01_LoginPage loginpage=PageFactory.initElements(driver,FinaryaTC01_LoginPage.class);
	    loginpage.clickOnprofile();
	    loginpage.clickOnLogoutButton();
	   
		}
		@Test(priority=2,dataProvider = "LoginScenario")
		public void InvaliddLogin(String Username, String Password){
		FinaryaTC01_LoginPage loginpage=PageFactory.initElements(driver,FinaryaTC01_LoginPage.class);
		
		loginpage.usernamesend(Username);
		loginpage.passwordSend(Password);
		
		loginpage.clickOnLoginButton();
		try {
		loginpage.clickOnOKButton();
		}catch(Exception e) {
			e.printStackTrace();
		}
		loginpage.clickOnprofile();
	    loginpage.clickOnLogoutButton();
	  
		}
		
		
		@Test(priority=3,dataProvider="empLogin")
		public void InvalidLoginfromexcel(String USERNAME, String PASSWORD){
		FinaryaTC01_LoginPage loginpage=PageFactory.initElements(driver,FinaryaTC01_LoginPage.class);
		
		loginpage.usernamesend(USERNAME);
		loginpage.passwordSend(PASSWORD);
		loginpage.clickOnLoginButton();
		try {
			loginpage.clickOnOKButton();
			}catch(Exception e) {
				e.printStackTrace();
			}
		loginpage.clickOnprofile();
	    loginpage.clickOnLogoutButton();
		
	 
		}
		

		@DataProvider(name = "LoginScenario")

		public Object[][] getDataforLoginDifferentScenarios() {

			return new Object[][] {

					{ "admin", ""  },

					{ "", "Admin@1234" },

					{ "admin", "Admin@12" },

					{ "Admin@1234", "admin" },

					{ "admin", "Admin@134"} 
					};			
		
		}



		@DataProvider(name="empLogin")
		public Object[][] loginData() {
			Object[][] arrayObject = getExcelData(Path, "LoginScinario");
			return arrayObject;
		}
		
		
		
		public String[][] getExcelData(String fileName, String sheetName) {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				XSSFWorkbook workbook = new XSSFWorkbook(fs);
				Sheet sheet  = workbook.getSheet(sheetName);

				int totalrowcout = sheet.getPhysicalNumberOfRows();
			       int totalcolcount =sheet.getRow(0).getPhysicalNumberOfCells();
			       
				arrayExcelData = new String[totalrowcout-1][totalcolcount];
				
				for (int i= 1 ; i < totalrowcout; i++) {

					for (int j=0; j < totalcolcount; j++) {
						arrayExcelData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			return arrayExcelData;
		}

		
		@AfterClass
		public void CloseBrowser() {
			driver.close();
		}
		
}

		
		
		
