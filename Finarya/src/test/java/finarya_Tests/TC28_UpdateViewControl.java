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
import finarya_Pages.FinaryaTC28_UpdateViewControlPage;

public class TC28_UpdateViewControl extends TestBase{
	public final String path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC28_UpdateViewControl.xlsx";
	public FinaryaTC28_UpdateViewControlPage updatecontrol ;
	@Test(priority=1)
	public void updateflow() throws Exception{
		updatecontrol=new FinaryaTC28_UpdateViewControlPage (driver);
		updatecontrol.clickonlistcontrol();
		updatecontrol.searchrecord();
	}
	
	
	@Test(priority=2,dataProvider="Updatecontrolscenario")
	public void updatecontrolmodule(String refno,String Title,String Controldescription) throws Exception{
		updatecontrol=new FinaryaTC28_UpdateViewControlPage (driver);
		updatecontrol.clickoncontrolrefno(refno);
		Thread.sleep(1000);
		updatecontrol.clickoncontroltitle(Title);
		Thread.sleep(1000);
		updatecontrol.clickoncontroldescription(Controldescription);
		Thread.sleep(1000);
		updatecontrol.verifyparentcontrolid();
		updatecontrol.clickonfullscreen();
		updatecontrol.scrolldown();
		Thread.sleep(1000);
		updatecontrol.clickonnextbutton();
		Thread.sleep(1000);
		updatecontrol.clickonfullscreen();
		updatecontrol.clickondepartmentname();
		Thread.sleep(1000);
		updatecontrol.departmentnamedropdown();
		updatecontrol.clickonnextbutton();
	}
	
	@Test(priority=3)
	public void linkcontrol() throws Exception {
		updatecontrol=new FinaryaTC28_UpdateViewControlPage (driver);
		updatecontrol.clickonlinkdepartmentname();
		updatecontrol.linkdepartmentnamedropdown();
		updatecontrol.clickonlinkproduct();
		updatecontrol.linkproductnamedropdown();
		updatecontrol.clickonlinkprocess();
		updatecontrol.linkprocessdropdown();
		updatecontrol.clickonlinkriskname();
		updatecontrol.linkriskdropdown();
		updatecontrol.clickonaddbutton();
		updatecontrol.scrolldown();
		Thread.sleep(1000);
		updatecontrol.clickonremovebutton();
		Thread.sleep(1000);
		updatecontrol.clickonupdatebutton();
	}
	
	@Test(priority=4)
	public void view() throws Exception {
		updatecontrol=new FinaryaTC28_UpdateViewControlPage (driver);
		updatecontrol.clickonlistcontrol();
		updatecontrol.viewcontrolrecord();
	}
	
	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
	
	
	@DataProvider(name="Updatecontrolscenario")
	public Object[][] updatedata(){
		Object[][] arrayObject= getExcelData(path,"update");
		return arrayObject;
		
	}

	public String[][] getExcelData(String fileName,String sheetName){
		String[][] arrayExcelData=null;
		try {
			FileInputStream fs=new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			Sheet sheet =workbook.getSheet(sheetName);
			int totalrowcount=sheet.getPhysicalNumberOfRows();
			int totalcolumcoun = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total number Of row:-"+totalrowcount);
			System.out.println("Total number Of colum:-"+totalcolumcoun);
			arrayExcelData=new String[totalrowcount-1][totalcolumcoun];
			for(int i=1;i<totalrowcount;i++) {
				for(int j=0;j<totalcolumcoun;j++) {
					arrayExcelData[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	
}
