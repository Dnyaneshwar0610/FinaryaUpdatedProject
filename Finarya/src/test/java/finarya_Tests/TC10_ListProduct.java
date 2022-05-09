package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC10_ListProductPage;

public class TC10_ListProduct extends TestBase {

	@Test(priority = 1)
	public void listproduct() throws Exception {
		FinaryaTC10_ListProductPage listproduct = new FinaryaTC10_ListProductPage(driver);
		listproduct.clickonlistproduct();
		Thread.sleep(1000);
		listproduct.scrolldown();
		Thread.sleep(1000);
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
