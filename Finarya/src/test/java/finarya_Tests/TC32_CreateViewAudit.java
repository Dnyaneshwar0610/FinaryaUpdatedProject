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
import finarya_Pages.FinaryaTC32_CreateViewAuditPage;
import finarya_Pages.FinaryaTC32_ViewAuditPage;

public class TC32_CreateViewAudit extends TestBase {
	public String Path =System.getProperty("user.dir")+"/src/test/java/com/csipl/finarya/testdata/TC32_CreateViewAudit.xlsx";
	
	@Test(priority = 1, dataProvider = "auditcreate")
	public void createaudit(String auditnum, String auditbreach, String audittype, String AuditSubtype,
			String AuditDesc, String Auditlifecycle, String Depatmentname, String Branchname,String samplingmethdology, String Samplecount,String username1,
			String userroal1, String username2, String userroal2) throws Exception {
		FinaryaTC32_CreateViewAuditPage auditcreate = new FinaryaTC32_CreateViewAuditPage(driver);
		// auditcreate.clickonprofile();
		Thread.sleep(1500);
		auditcreate.clickonforwordarrow();
		Thread.sleep(1500);
		auditcreate.clickonaudit();
		logger.info("Expected Result is System opens" + "  " + "Audit");
		auditcreate.clickonauditmanagment();
		logger.info("Expected Result is System opens" + "  " + "Audit Managment");
		auditcreate.clickonauditworkbench();
		logger.info("Expected Result is System opens" + "  " + "Audit Workbench");
		auditcreate.clickoncreateaudit();
		logger.info("Expected Result is System opens" + "  " + "Create Audit Panel");
		auditcreate.verifyCreateAuditPanel();
		logger.info("Expected Result is System opens page Create Audit Panel with Tabs Is" + "    " + "Audit");
		logger.info("Expected Result is System opens page Create Audit Panel with Tabs Is" + "    " + "Stakeholders");
		logger.info("Expected Result is System opens page Create Audit Panel with Tabs Is" + "    " + "Checklist");
		auditcreate.clickonAudNumTextbox(auditnum);
		logger.info("Internal Audit Number Is" + "  " + "1200");
		auditcreate.clickonAuditbreachtype(auditbreach);
		logger.info("Audit Breach Type Is" + "  " + "Internal");
		auditcreate.clickonCommaninputSearchboxall();
		auditcreate.clickonAudittype(audittype);
		auditcreate.clickonaudittype();
		auditcreate.clickonAuditsubtype(AuditSubtype);
		auditcreate.clickonauditsubtype();
		auditcreate.auditDescription(AuditDesc);
		auditcreate.clickonapStartDate();
		logger.info("Audit Current date Is Selected");
		auditcreate.clickonapEndDate();
		auditcreate.scrolldown();
		Thread.sleep(1000);
		auditcreate.clickonAudittestinglife(Auditlifecycle);
		auditcreate.clickonaudittestinglifecycle();
		auditcreate.clickonstartDate();
		Thread.sleep(1000);
		auditcreate.clickonendDate();
		Thread.sleep(1000);
		//auditcreate.
		auditcreate.clickondepartmentName(Depatmentname);
		auditcreate.clickondepartmentNamesearch();
		auditcreate.clickonBranchname(Branchname);
		auditcreate.clickonBranchnamesearch();
		auditcreate.getcostcode();
		logger.info("Branch Code Is Automaticaly Created Is");
		logger.info("Cost Center Name Is Automaticaly Created Is");
		auditcreate.scrollup();
		auditcreate.clickonadditionalfields();
		auditcreate.scrolldown();
		auditcreate.clickonsamplingmethdology(samplingmethdology);
		auditcreate.clickonsamplingmethdologysearchbox();
		auditcreate.clickonsamplecount(Samplecount);
		auditcreate.clickonnextbutton();
		auditcreate.clickonusername1(username1);
		auditcreate.clickonusernamesearchbox1();
		auditcreate.clickonuserroal1(userroal1);
		auditcreate.clickonuserroalsearchbox1();
		auditcreate.clickonaddbutton();
		auditcreate.clickonusername2(username2);
		auditcreate.clickonusernamesearchbox1();
		auditcreate.clickonuserroal2(userroal2);
		auditcreate.clickonuserroalsearchbox1();
		auditcreate.clickonnextbutton();
		auditcreate.gettexthiderisk();
        logger.info("System opens up Assign Process, Risk & Control to Auditor tab  showing Process, Risk & Control Mapping Panel table with  Search Functionality.");
        auditcreate.clickonchechbox();
        logger.info("Select the existing matching record");
        auditcreate.scrolldown();
        Thread.sleep(1500);
        auditcreate.selectedcontrolrecord();
        logger.info("Select Record is display on selected control panel Process, Risk and Control record selected for Audit");
        //  auditcreate.scrollup();
       // auditcreate.clickonbrowsefile(driver);
       // logger.info("System Open Local Disk And Browse File From Local System To Web");
        auditcreate.scrolldown();
        auditcreate.clickonnextbutton();
    	 
    	auditcreate.clickonsubmitbutton();
    	logger.info("System will open up Checklist tab ");
    	Thread.sleep(1500);
    	auditcreate.verifycreateaudit();
    	logger.info("Create audit Successfully ");
    
        
	}
   
	
	@DataProvider(name = "auditcreate")
	public Object[][] auditData() {

		Object[][] arrayObject = getExcelData(Path, "audit");
		return arrayObject;
	}

	public Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			Sheet sheet = workbook.getSheet(sheetName);

			int totalrowcout = sheet.getPhysicalNumberOfRows();
			int totalcolcount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(totalrowcout);
			System.out.println(totalcolcount);
			arrayExcelData = new Object[totalrowcout - 1][totalcolcount];

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

