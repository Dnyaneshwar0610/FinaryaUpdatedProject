package finarya_BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.csipl.finarya.properties.propertiesHandler;

import finarya_Pages.FinaryaTC01_LoginPage;

public class ReadToExcel {
	public propertiesHandler prop = new propertiesHandler();
	public static final String PROPERTY_FILE = "config.properties";
	public void loadpropertiesfile() {
		prop.loadProperties(PROPERTY_FILE);
	}
	
	@DataProvider(name="updateDepartmentScenario")
	public Object[][] loginData() {
		loadpropertiesfile();
		Object[][] arrayObject = getExcelData(prop.readProperties("ExcelFilePath"), prop.readProperties("SheetName"));
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
}
