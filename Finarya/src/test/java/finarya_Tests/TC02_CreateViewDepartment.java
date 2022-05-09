package finarya_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC02_CreateViewDepartmentPage;

public class TC02_CreateViewDepartment extends TestBase {

	
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC02_CreateViewDepartment.xlsx";
	
	@Test(priority = 1, dataProvider = "DepartmentScenario")
	public void createdepartment(String DName, String ParentDep, String Product, String Process, String Risk,
			String Control) throws Exception {
		FinaryaTC02_CreateViewDepartmentPage createpage = new FinaryaTC02_CreateViewDepartmentPage(driver);
		createpage.clickOndepartmentworkbench();
		
		createpage.expected();
		Thread.sleep(1000);
		createpage.departmentName(DName);
		createpage.parentdep(ParentDep);
		Thread.sleep(1000);
		createpage.dropdownvalue();
		createpage.clickonNextButton();
		createpage.clickonproduct(Product);
		createpage.dropdownproduct();
		createpage.clickonprocess(Process);
		createpage.dropdownprocess();
		createpage.clickonrisk(Risk);
		createpage.dropdownrisk();
		createpage.clickoncontrol(Control);
		createpage.dropdowncontrol();
		createpage.clickonAddButton();
		Thread.sleep(1000);
		createpage.clickonSubmitButton();
		createpage.clickonOkButton();

	}

	@Test(priority = 2)
	public void viewdepartment() {
		FinaryaTC02_CreateViewDepartmentPage createpage = new FinaryaTC02_CreateViewDepartmentPage(driver);
		createpage.clickonviewdep();
	}

	@DataProvider(name = "DepartmentScenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(Path, "dep");
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

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
