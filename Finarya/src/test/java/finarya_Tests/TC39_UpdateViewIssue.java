package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC39_UpdateViewIssuePage;


public class TC39_UpdateViewIssue extends TestBase{
	public FinaryaTC39_UpdateViewIssuePage list;
	@Test(priority = 1)
	public void listIssue() throws Exception {
	    list = new FinaryaTC39_UpdateViewIssuePage(driver);
		Thread.sleep(1500);
		list.clickonlistofissue();
		list.searchrecord();
	}

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
	
	
}
