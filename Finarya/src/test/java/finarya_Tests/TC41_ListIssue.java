package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC35_ListAuditPage;
import finarya_Pages.FinaryaTC41_ListIssuePage;

public class TC41_ListIssue extends TestBase {
	
	@Test(priority = 1)
	public void listIssue() throws Exception {
		FinaryaTC41_ListIssuePage list = new FinaryaTC41_ListIssuePage(driver);
		Thread.sleep(1500);
		list.clickonlistofissue();
		Thread.sleep(1500);
		list.scrolldown();
		Thread.sleep(1500);
		// listdep.showentriesfromlist();
		list.listselectentries();
	}

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
