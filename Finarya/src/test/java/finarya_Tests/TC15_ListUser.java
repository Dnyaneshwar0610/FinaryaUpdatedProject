package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC10_ListProductPage;
import finarya_Pages.FinaryaTC15_ListUserPage;

public class TC15_ListUser extends TestBase {
	
	
	@Test(priority = 1)
	public void listusers() throws Exception {
		FinaryaTC15_ListUserPage listuser = new FinaryaTC15_ListUserPage(driver);
		listuser.clickonlistuser();
		Thread.sleep(1000);
		listuser.scrolldown();
		Thread.sleep(1000);
		// listdep.showentriesfromlist();
		listuser.listselectentries();
	}

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}

}
