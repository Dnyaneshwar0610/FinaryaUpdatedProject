package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC14_DeleteUserPage;

public class TC14_DeleteUser extends TestBase{
	
	public FinaryaTC14_DeleteUserPage deleteuser;
	@Test(priority=1)
	public void deleteuserlist() throws Exception{
		deleteuser =new FinaryaTC14_DeleteUserPage(driver);
		deleteuser.clickonlistuser();
		deleteuser.searchrecord();
		
	}
	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
