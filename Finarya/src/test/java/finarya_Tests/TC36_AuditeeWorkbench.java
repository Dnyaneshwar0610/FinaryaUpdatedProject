package finarya_Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC36_AuditeeWorkbenchPage;
import finarya_Pages.FinaryaTC03_UpdateViewDepartmentPage;

public class TC36_AuditeeWorkbench extends TestBase {
	
	
	@Test(priority=1)
	public void auditeeworkbench() throws Exception{
		
		FinaryaTC36_AuditeeWorkbenchPage auditeeworkbench = new FinaryaTC36_AuditeeWorkbenchPage(driver);
		auditeeworkbench.clickonauditeeworkbench();
		logger.info("System will List Audit page and populates the List Of the Audits .");
		auditeeworkbench.clickonauditeeworkbenchserachlist();
		logger.info("System will display the matching record in the table");
		auditeeworkbench.expectedtab();
		logger.info("System will open Auditee Workbench page with tabs");
		auditeeworkbench.clickonuploadtab();
		Thread.sleep(1000);
		auditeeworkbench.clickonuploadsample();
		logger.info("Screen will open a functionality for the User to Add files");
	    auditeeworkbench.clickonaddfilebutton();
		logger.info("System will open the path for file selection ");
	    auditeeworkbench.addfile();
		logger.info("System will provide option to the Start or Cancel Upload ");
	    auditeeworkbench.clickonstartbutton();
		logger.info("System will display option to Delete the uploaded file");
		try {
			auditeeworkbench.geterror();
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auditeeworkbench.totaldownscroll();
		Thread.sleep(3000);
		auditeeworkbench.clickonclosebutton();
		logger.info("System will take the User back to Auditee Workbench");
		Thread.sleep(3000);
		auditeeworkbench.clickonreasonupload();
		//auditeeworkbench.clickonReasonfornotuploadfile();
		//auditeeworkbench.clickonaddbutton();
		logger.info("System will pop-up a message Reason Added Successfully");
		//auditeeworkbench.clickoncommentbutton();
		logger.info("System will open a menu table Sample Audit Control Comments with following columns with data values:\r\n"
				+ "\r\n"
				+ "ID\r\n"
				+ "Created\r\n"
				+ "User ID\r\n"
				+ "User Name\r\n"
				+ "Comment");
		
		//auditeeworkbench.totaldownscroll();
		Thread.sleep(1000);
		//auditeeworkbench.verificationofcomment();
		//auditeeworkbench.clickonsampalauditcontclose();
		logger.info("System will take the User back to Auditee Workbench");
		
	}
	

	
	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}


}
