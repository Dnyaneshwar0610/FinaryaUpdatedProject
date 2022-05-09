package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC20_ListProcessPage;

public class TC20_ListProcess extends TestBase {

	@Test(priority = 1)
	public void listprocess() throws Exception {
		FinaryaTC20_ListProcessPage listproduct = new FinaryaTC20_ListProcessPage(driver);
		listproduct.clickonlistprocess();
		Thread.sleep(1500);
		listproduct.scrolldown();
		Thread.sleep(1500);
		// listdep.showentriesfromlist();
		listproduct.listselectentries();
	}

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
