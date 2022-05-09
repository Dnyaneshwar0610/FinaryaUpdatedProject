package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC30_ListControlPage;

public class TC30_ListControl extends TestBase {

	
	@Test(priority = 1)
	public void listcontrol() throws Exception {
		FinaryaTC30_ListControlPage list = new FinaryaTC30_ListControlPage(driver);
		list.clickonlistcontrol();
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
