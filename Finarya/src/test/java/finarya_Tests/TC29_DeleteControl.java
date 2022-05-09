package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC29_DeleteControlPage;

public class TC29_DeleteControl extends TestBase {
	
	public FinaryaTC29_DeleteControlPage deletecontrol ;
	@Test(priority=1)
	public void deletecontrolflow() throws Exception{
		deletecontrol=new FinaryaTC29_DeleteControlPage (driver);
		deletecontrol.clickonlistcontrol();
		deletecontrol.searchrecord();
		deletecontrol.clickonfullscreen();
		Thread.sleep(1000);
		deletecontrol.scrolldown();
		Thread.sleep(1000);
		deletecontrol.clickonnextbutton();
		Thread.sleep(1000);
		deletecontrol.clickonfullscreen();
		Thread.sleep(1000);
		deletecontrol.clickonnextbutton();
		Thread.sleep(2000);
		deletecontrol.clickonfullscreen();
		deletecontrol.scrolldown();
		
	}
	@Test(priority=2)
	public void deletecontrol() {
		deletecontrol=new FinaryaTC29_DeleteControlPage (driver);
		deletecontrol.clickondeletebutton();
	}

	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
