package finarya_Tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC25_ListRiskPage;
public class TC25_ListRisk extends TestBase {

	@Test(priority = 1)
	public void listrisk() throws Exception {
		FinaryaTC25_ListRiskPage list = new FinaryaTC25_ListRiskPage(driver);
		list.clickonlistrisk();
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
	
	

