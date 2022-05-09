package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC25_ListRiskPage;
import finarya_Pages.FinaryaTC35_ListAuditPage;

public class TC35_ListAudit extends TestBase {
	@Test(priority = 1)
	public void listaudit() throws Exception {
		FinaryaTC35_ListAuditPage list = new FinaryaTC35_ListAuditPage(driver);
		Thread.sleep(1500);
		list.clickonlistofcreateaudit();
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
