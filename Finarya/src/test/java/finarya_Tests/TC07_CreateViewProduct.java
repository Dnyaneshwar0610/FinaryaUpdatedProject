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
import finarya_Pages.FinaryaTC07_CreateViewProductPage;

public class TC07_CreateViewProduct extends TestBase {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC_CreateProduct.xlsx";

	
	
	@Test(priority=1)
	public void CreateProClick() {
		FinaryaTC07_CreateViewProductPage CreateProductRef =new FinaryaTC07_CreateViewProductPage(driver);
		CreateProductRef.clickOnadministration();
		CreateProductRef.clickOnProductLibrary();
		CreateProductRef.clickonCreateProduct();
	
	}
	
	@Test(priority=2,dataProvider="ProductScenario")
	public void Department(String ProName,String SearchName) throws InterruptedException {
		FinaryaTC07_CreateViewProductPage CreateProductRef =new FinaryaTC07_CreateViewProductPage(driver);
		Thread.sleep(1000);
		CreateProductRef.ClickonProductNameTextBox(ProName);
		CreateProductRef.clickonParentProductName();
		CreateProductRef.clickonSearchBox(SearchName);
		CreateProductRef.parentproductid();
		CreateProductRef.clickonNextbutton();
		CreateProductRef.clickonNextbutton();
		CreateProductRef.clickonSubmitButton();
		CreateProductRef.ClickonOkButton();
		CreateProClick();
		
		
	
	}
	
	
	@DataProvider(name="ProductScenario")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(Path, "Product");
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
