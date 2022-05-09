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
import finarya_Pages.FinaryaTC13_UpdateViewUserPage;

public class TC13_UpdateViewUser extends TestBase {
	public FinaryaTC13_UpdateViewUserPage updateuser;

	@Test(priority = 1)
	public void userslist() throws Exception {
		updateuser = new FinaryaTC13_UpdateViewUserPage(driver);
		updateuser.clickonupdateuser();
		updateuser.searchrecord();
	}

	@Test(priority = 2, dataProvider = "UpdateUserScenario")
	public void loginuserupdate(String FullName, String Pass, String EmailId) throws Exception {
		updateuser = new FinaryaTC13_UpdateViewUserPage(driver);
		Thread.sleep(1000);
		updateuser.clickonuserid();
		Thread.sleep(1000);
		updateuser.userFullNameTextBox(FullName);
		Thread.sleep(1000);
		updateuser.passTextBox(Pass);
		Thread.sleep(1000);
		updateuser.emailTextBox(EmailId);
		Thread.sleep(1000);
		updateuser.departmentDropDown();
		Thread.sleep(1000);
		updateuser.searchDropDown();
		Thread.sleep(1000);
		updateuser.dropdownvalue();
		Thread.sleep(2000);
		updateuser.clickonNextButton();
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void assignrole() throws Exception {
		updateuser = new FinaryaTC13_UpdateViewUserPage(driver);
		updateuser.clickonAllCheckBox();
		updateuser.clickonupdatebutton();
		try {
			updateuser.assertion();
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 4)
	public void viewupdatedrecord() throws Exception {
		updateuser = new FinaryaTC13_UpdateViewUserPage(driver);
		updateuser.viewuserupdeted();
		updateuser.searchrecordupdeted();

	}

	@DataProvider(name = "UpdateUserScenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("X:\\Test Case Excel\\TC13_UpdateViewUser.xlsx", "updateuser");
		return arrayObject;
	}

	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			Sheet sheet = workbook.getSheet(sheetName);

			int totalrowcout = sheet.getPhysicalNumberOfRows();
			int totalcolcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(totalrowcout);
			System.out.println(totalcolcount);
			arrayExcelData = new String[totalrowcout - 1][totalcolcount];

			for (int i = 1; i < totalrowcout; i++) {

				for (int j = 1; j <= totalcolcount; j++) {
					arrayExcelData[i - 1][j - 1] = sheet.getRow(i).getCell(j).getStringCellValue();
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
