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
import finarya_Pages.FinaryaTC02_CreateViewDepartmentPage;
import finarya_Pages.FinaryaTC03_UpdateViewDepartmentPage;

public class TC03_UpdateViewDepartment extends TestBase{
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC03_UpdateViewDepartment.xlsx";
	@Test(priority=1,dataProvider="updateDepartmentScenario")
	public void update(String ParentDep,String Product,String Process,String Risk,String Control) throws Exception{
		FinaryaTC03_UpdateViewDepartmentPage updatepage = new FinaryaTC03_UpdateViewDepartmentPage(driver);
		Thread.sleep(1000);
		updatepage.clickOnlistdepartment();
		updatepage.clickonsearch();
		Thread.sleep(1000);
		updatepage.clickonupdate();
		//updatepage.departmentName(DName);
		updatepage.parentdep(ParentDep);
		Thread.sleep(1000);
		updatepage.dropdownvalue();
		Thread.sleep(1000);
		updatepage.clickonNextButton();
		
		updatepage.clickonproduct(Product);
		Thread.sleep(1000);
		updatepage.dropdownproduct();
		updatepage.clickonprocess(Process);
		Thread.sleep(1000);
		updatepage.dropdownprocess();
		updatepage.clickonrisk(Risk);
		updatepage.dropdownrisk();
		Thread.sleep(1000);
		updatepage.clickoncontrol(Control);
		updatepage.dropdowncontrol();
		updatepage.clickonAddButton();
		updatepage.scrolldown();
		updatepage.clickonupdatebutton();
		updatepage.clickonokbutton();
	}
	
	@Test(priority=2)
	public void viewupdate() throws Exception{
		FinaryaTC03_UpdateViewDepartmentPage updatepage = new FinaryaTC03_UpdateViewDepartmentPage(driver);
		updatepage.clickOnlistdepartment();
		updatepage.clickonviewdep();
		
	}



	
	
	@DataProvider(name="updateDepartmentScenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(Path, "updateview");
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
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
