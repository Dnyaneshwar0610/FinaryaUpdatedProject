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
import finarya_Pages.FinaryaTC08_UpdateViewProductPage;

public class TC08_UpdateViewProduct extends TestBase {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC08_UpdateViewProduct.xlsx";

	@Test(priority=1)
	public void productlist() throws Exception{
		FinaryaTC08_UpdateViewProductPage proupdate =new FinaryaTC08_UpdateViewProductPage(driver);
		proupdate.clickonlistproduct();
	}
	
	@Test(priority=2,dataProvider="updateviewproductscenario")
	public void listofproduct(String ProductName,String department,String departmentselect,String process,String risk,String control) throws Exception{
		FinaryaTC08_UpdateViewProductPage proupdate =new FinaryaTC08_UpdateViewProductPage(driver);
		proupdate.clickonsearch();
		proupdate.captureproductid();
		proupdate.clickonProductNameTextBox(ProductName);
		proupdate.clickonNextbutton();
		proupdate.clickonprimarybutton();
		proupdate.clickondepartmentname(department);
		proupdate.clickonCommaninputSearchboxall();
		proupdate.addbutton();
		proupdate.minusbutton();
		proupdate.clickonNextbutton();
		proupdate.clickondepartment(departmentselect);
		Thread.sleep(1000);
		proupdate.dropdowndepartment();
		proupdate.clickonprocess(process);
		proupdate.dropdownprocess();
		proupdate.clickonrisk(risk);
		proupdate.dropdownrisk();
		proupdate.clickoncontrol(control);
		proupdate.dropdowncontrol();
		proupdate.clickonAddButton();
		proupdate.clickonUpdateButton();
		proupdate.clickonviewproductupdated();
		 
		 
	}
	
	@DataProvider(name="updateviewproductscenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(Path, "updateviewproduct");
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
