package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC04_DeleteDepartmentPage;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC03_UpdateViewDepartmentPage;

public class TC04_DeleteDepartment extends TestBase{
	@Test(priority=1)
	public void deletedepartment() throws Exception{
		FinaryaTC04_DeleteDepartmentPage deletedep =new FinaryaTC04_DeleteDepartmentPage(driver);
		deletedep.clickOnlistdepartment();
		deletedep.clickonsearch();
		deletedep.clickondelete();
		deletedep.clickonnext();
		Thread.sleep(1000);
		deletedep.scrolldown();
		deletedep.clickondeletebutton();
		deletedep.deletealert();
	}

	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
