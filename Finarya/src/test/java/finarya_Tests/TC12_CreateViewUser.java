package finarya_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC12_CreateViewUserPage;

public class TC12_CreateViewUser extends TestBase {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC12_UserCreate.xlsx";
	@Test(priority=1)
	public void createuserlist() throws Exception{
		FinaryaTC12_CreateViewUserPage createuserpage =new FinaryaTC12_CreateViewUserPage(driver);
		createuserpage.clickoncreateuser();
	}
	
	
	
	@Test(priority = 2, dataProvider = "UserCreateScenario")
	public void loginusercreate(String NameLoginId, String FullName, String Pass, String EmailId)
			throws Exception {
		FinaryaTC12_CreateViewUserPage createUser = new FinaryaTC12_CreateViewUserPage(driver);
		Thread.sleep(1000);
		createUser.loginIDTextBox(NameLoginId);
		Thread.sleep(1000);
		createUser.verifyfullnametextbox();
		Thread.sleep(1500);
		createUser.verifyfullnametextbox1();
		Thread.sleep(1000);
		createUser.userFullNameTextBox(FullName);
		Thread.sleep(1000);
		createUser.passTextBox(Pass);
		Thread.sleep(1000);
		createUser.emailTextBox(EmailId);
		Thread.sleep(1000);
		createUser.departmentDropDown();
		Thread.sleep(1000);
		createUser.searchDropDown();
		Thread.sleep(1000);
		createUser.dropdownvalue();
		Thread.sleep(2000);
		createUser.clickonNextButton();
		Thread.sleep(1000);
	}
	@Test(priority=3)
	public void assignrole() throws Exception{
		FinaryaTC12_CreateViewUserPage createuserpage =new FinaryaTC12_CreateViewUserPage(driver);
		createuserpage.clickonAllCheckBox();
		Thread.sleep(1000);
		createuserpage.clickonSaveButton();
		try {
			createuserpage.Assertion();
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@DataProvider(name="UserCreateScenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(Path, "createuser");
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
		       System.out.println(totalrowcout);
		       System.out.println(totalcolcount);
			arrayExcelData = new String[totalrowcout-1][totalcolcount];
			
			for (int i=1 ; i <totalrowcout; i++) {

				for (int j=1; j <=totalcolcount; j++) {
					arrayExcelData[i-1][j-1] = sheet.getRow(i).getCell(j).getStringCellValue();
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
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
