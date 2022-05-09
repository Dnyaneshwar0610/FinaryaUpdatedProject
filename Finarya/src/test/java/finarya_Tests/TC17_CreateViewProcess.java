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
import finarya_Pages.FinaryaTC17_CreateViewProcessPage;

public class TC17_CreateViewProcess extends TestBase {
   public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC17_CreateViewProcess.xlsx";

	@Test(priority = 1, dataProvider = "process scenario")
	public void createprocess(String IntrnalID, String pName, String Processdescription, String docustatus,
			String rolledid) throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(2000);
		processcreate.clickonprocessdocumentation();
		Thread.sleep(2000);
		processcreate.clickonprocess();
		processcreate.clickonprocessflowid();
		processcreate.verifyprocessInternalID();
		processcreate.clickonprocessinternalid(IntrnalID);
		processcreate.verifyprocessname();
		processcreate.clickonprocessname(pName);
		// processcreate.parentprocessname();
		processcreate.clickonparentprocessname();
		processcreate.parentprocessdropdown();
		processcreate.parentprocessID();
		processcreate.clickonprocessdescription(Processdescription);
		processcreate.scrolldown();
		processcreate.clickonparentprocessjourny();
		processcreate.clickontempprocess();
		processcreate.clickonprocessfre();
		processcreate.clickondocumentstatus(docustatus);
		processcreate.clickonrolledupid(rolledid);
		processcreate.clickonnextbutton();

	}

	@Test(priority = 2)
	public void ownertab() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clickondepartmentname();
		Thread.sleep(1000);
		processcreate.departmentnamedropdown();
		Thread.sleep(1000);
		processcreate.clickonnextbutton();
		Thread.sleep(1000);
		processcreate.scrollup();
		Thread.sleep(1000);
		processcreate.clickonfullscreen();
		Thread.sleep(1000);
		processcreate.assinprocessdoc();
		processcreate.scrolldowntarget();
		Thread.sleep(1000);
		processcreate.clickonnextbutton();

	}

	@Test(priority = 3)
	public void linkprocess() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		processcreate.clickonfullscreen();
		Thread.sleep(1000);
		processcreate.clickondepartment();
		Thread.sleep(1000);
		processcreate.departmentdropdown();
		Thread.sleep(1000);
		processcreate.clickonproduct();
		Thread.sleep(1000);
		processcreate.productdropdown();
		Thread.sleep(1000);
		processcreate.clickonrisk();
		Thread.sleep(1000);
		processcreate.riskdropdown();
		Thread.sleep(1000);
		processcreate.clickoncontrol();
		Thread.sleep(1000);
		processcreate.controldropdown();
		Thread.sleep(1000);
		processcreate.clickonaddbutton();

	}

	@Test(priority = 4)
	public void processflowdiagram() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clikonprocessflowdiagramtab();
		Thread.sleep(1000);
		processcreate.clikonbrowse();
		Thread.sleep(1000);
		processcreate.Uploadfile();
		processcreate.clickonuploadbutton();
		Thread.sleep(1000);
		processcreate.scrolldown();
		Thread.sleep(1000);
		processcreate.scrollup();

	}

	@Test(priority = 5)
	public void sop() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clickonsop();
		Thread.sleep(1000);
		processcreate.clickonsopsearchbox();
		Thread.sleep(1000);
		processcreate.scrolldown();
		Thread.sleep(1000);
		processcreate.scrollup();

	}

	@Test(priority = 6)
	public void internalexternalcircular() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clickoninternalexternalcircular();
		Thread.sleep(1000);
		processcreate.clickonsearchinternalexternalcircular();
		Thread.sleep(1000);
		processcreate.scrolldown();
		Thread.sleep(1000);
		processcreate.scrollup();

	}

	@Test(priority = 7)
	public void submitbutton() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clickonsubmitbutton();
	}

	@Test(priority = 8)
	public void viewprocess() throws Exception {
		FinaryaTC17_CreateViewProcessPage processcreate = new FinaryaTC17_CreateViewProcessPage(driver);
		Thread.sleep(1000);
		processcreate.clickonviewprocess();
		processcreate.clickonserchlist();
	}

	@DataProvider(name = "process scenario")
	public Object[][] processData() {
		Object[][] arrayObject = getExcelData(Path, "createprocess");
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
