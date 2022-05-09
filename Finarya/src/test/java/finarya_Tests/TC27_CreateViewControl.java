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
import finarya_Pages.FinaryaTC27_CreateViewControlPage;

public class TC27_CreateViewControl extends TestBase {
	public final String path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC27_CreateViewControl.xlsx";
	public FinaryaTC27_CreateViewControlPage createcontrol ;
@Test(priority=1)
public void createcontrolflow() throws Exception{
	createcontrol=new FinaryaTC27_CreateViewControlPage (driver);
	createcontrol.clikoncreatecontrol();
}
@Test(priority=2,dataProvider="controlscenario")
public void createcontrolmodule(String refno,String Title,String Controldescription) throws Exception{
	createcontrol=new FinaryaTC27_CreateViewControlPage (driver);
	createcontrol.clickonadditionalfield();
	createcontrol.clickoncontrolrefno(refno);
	createcontrol.clickoncontroltitle(Title);
	createcontrol.clickonparentcontrolname();
	createcontrol.parentcontroldropdown();
	createcontrol.verifyparentcontrolid();
	createcontrol.clickoncontroldescription(Controldescription);
	Thread.sleep(1500);
	//createcontrol.clickonfullscreen();
	createcontrol.scrolldown();
	Thread.sleep(1000);
	createcontrol.clickonopratinglevelcontrol();
	Thread.sleep(1000);
	createcontrol.opratingcontrolleveldropdown();
	createcontrol.clickoncontrolmode();
	createcontrol.controlmodedropdown();
	createcontrol.clickonreasonformanualcontrol1();
	createcontrol.reasonformanualcontrolmodedropdown1();
	createcontrol.clickonreasonformanualcontrol2();
	createcontrol.reasonformanualcontrolmodedropdown2();
	createcontrol.clickonreasonformanualcontrol3();
	createcontrol.reasonformanualcontrolmodedropdown3();
	createcontrol.clickoncontrolnature();
	createcontrol.controlnaturedropdown();
	createcontrol.clickonfraudpreventive();
	createcontrol.fraudpreventivedropdown();
	createcontrol.clickoncopensatingcontrol();
	createcontrol.copensatingcontroldropdown();
	createcontrol.clickoncontrolfre();
	createcontrol.controlfredropdown();
	createcontrol.clickonkeycontrol() ;
	createcontrol.keycontroldropdown();
	createcontrol.clickoncontroltype();
	createcontrol.controltypedropdown();
	createcontrol.scrolldown();
	createcontrol.clickonnextbutton();
	
}

@Test(priority=3)
public void ownertab() throws Exception{
	createcontrol=new FinaryaTC27_CreateViewControlPage (driver);
	createcontrol.clickondepartmentname();
	createcontrol.departmentnamedropdown();
	createcontrol.clickonnextbutton();
}

@Test(priority=4)
public void linkcontrol() throws Exception{
	createcontrol=new FinaryaTC27_CreateViewControlPage (driver);
	createcontrol.clickonlinkdepartmentname();
	createcontrol.linkdepartmentnamedropdown();
	createcontrol.clickonlinkproduct();
	createcontrol.linkproductnamedropdown();
	createcontrol.clickonlinkprocess();
	createcontrol.linkprocessdropdown();
	createcontrol.clickonlinkriskname();
	createcontrol.linkriskdropdown();
	createcontrol.clickonaddbutton();
	createcontrol.scrolldown();
	createcontrol.clickonsubmitbutton();
}
@Test(priority=5)
public void viewcontrol() throws Exception{
	createcontrol=new FinaryaTC27_CreateViewControlPage (driver);
	createcontrol.controllist();
	createcontrol.viewcontrolrecord();
}


@DataProvider(name="controlscenario")
 public Object[][] controldata()  {
	Object[][] arrayObject= getExcelData(path,"control");
	return arrayObject;
	
	
	}
public String[][] getExcelData(String fileName, String sheetName) {
	String[][] arrayExcelData=null;
	try {
		FileInputStream fs=new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		Sheet sheet=workbook.getSheet(sheetName);
		
		int totalrowcout=sheet.getPhysicalNumberOfRows();
		int totalcolcount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total number Of row:-"+totalrowcout);
		System.out.println("Total number Of colum:-"+totalcolcount);
		arrayExcelData=new String[totalrowcout-1][totalcolcount];
		for(int i=1;i<totalrowcout;i++) {
			for(int j=0;j<totalcolcount;j++) {
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

@AfterClass
public void Logout() {
	FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
	loginpage.clickOnprofile();
	loginpage.clickOnLogoutButton();
	driver.close();
}

}
