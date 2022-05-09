package finarya_Tests;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC37_AuditorWorkbenchPage;

public class TC37_AuditorWorkbench extends TestBase {
	
	@Test(priority=1)
	public void auditeeworkbench() throws Exception{
		
		FinaryaTC37_AuditorWorkbenchPage auditeeworkbench = new FinaryaTC37_AuditorWorkbenchPage(driver);
		auditeeworkbench.clickonauditeeworkbench();
		logger.info("System will List Audit page and populates the List Of the Audits .");
		auditeeworkbench.clickonAuditorWorkbenchserachlist();
		logger.info("System will display the matching record in the table");
		auditeeworkbench.expectedtab();
		logger.info("System will open Auditor Workbench page with tabs");
		auditeeworkbench.clickchecklisttab();
		Thread.sleep(1000);
		auditeeworkbench.clickoncommentstab();
		logger.info("System will open a window to input Auditor Comment");
		auditeeworkbench.clickoninputcommenttextbox();
		
		
	
	}
	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}


}
