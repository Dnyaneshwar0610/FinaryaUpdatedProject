package finarya_Tests;

import org.testng.annotations.Test;

import finarya_BaseClass.TestBase;
import finarya_Pages.FinaryaTC18_UpdateViewProcessPage;

public class TC18_UpdateViewProcess extends TestBase {
	FinaryaTC18_UpdateViewProcessPage updateprocess;
	
	
	@Test(priority=1)
	public void listprocess(){
		updateprocess=new FinaryaTC18_UpdateViewProcessPage(driver);
		updateprocess.clickonlistprocess();
	}
	
	
	@Test(priority=2)
	public void listsearchrecord() throws Exception{
		updateprocess=new FinaryaTC18_UpdateViewProcessPage(driver);
		updateprocess.clickonserchlist();
	}
	
	@Test(priority=3)
	public void updaterecord() throws Exception{
		updateprocess=new FinaryaTC18_UpdateViewProcessPage(driver);
		updateprocess.clickonprocess();
		updateprocess.clickonprocessflowid();
		
	}
	
}
