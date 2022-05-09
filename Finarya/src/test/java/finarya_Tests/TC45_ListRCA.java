package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC41_ListIssuePage;
import finarya_Pages.FinaryaTC45_ListRCAPage;

public class TC45_ListRCA extends TestBase{
	
	@Test(priority = 1)
	public void listRCA() throws Exception {
		FinaryaTC45_ListRCAPage list = new FinaryaTC45_ListRCAPage(driver);
		Thread.sleep(1500);
		list.clickonMyRCA();
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



