package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC01_LoginPage;
import finarya_Pages.FinaryaTC08_UpdateViewProductPage;
import finarya_Pages.FinaryaTC09_DeleteProductPage;

public class TC09_DeleteProduct extends TestBase{
	FinaryaTC08_UpdateViewProductPage proupdate;
	FinaryaTC09_DeleteProductPage deleteproduct;
	@Test(priority=1)
	public void productlist() throws Exception{
	    proupdate =new FinaryaTC08_UpdateViewProductPage(driver);
		proupdate.clickonlistproduct();
	
	}
	
	@Test(priority=2)
	public void deleteproduct() throws Exception{
		deleteproduct =new FinaryaTC09_DeleteProductPage(driver);
		deleteproduct.clickondeleteproduct();	
		deleteproduct.clickonNextbutton();
		deleteproduct.clickonNextbutton();
		Thread.sleep(1500);
		deleteproduct.scrolldown();
		Thread.sleep(1500);
		deleteproduct.clickondeletebutton();
		Thread.sleep(1500);
		
	}
	
	@AfterClass
	public void Logout() {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.clickOnprofile();
		loginpage.clickOnLogoutButton();
		driver.close();
	}
}
