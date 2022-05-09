package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC05_ListDepartmentPage;

public class TC05_ListDepartment extends TestBase {
	@Test(priority=1)
	public void listdepartment() throws Exception {
		FinaryaTC05_ListDepartmentPage listdep= new FinaryaTC05_ListDepartmentPage(driver);
		listdep.clickonlistdepartment();
		Thread.sleep(1000);
		listdep.scrolldown();
		Thread.sleep(1000);
		//listdep.showentriesfromlist();
		listdep.listselectentries();
	}

	@AfterClass
	public void Logout(){
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
