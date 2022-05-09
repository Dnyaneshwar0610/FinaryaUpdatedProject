package finarya_Tests;

import org.testng.annotations.Test;

import finarya_BaseClass.TestBaseForUserLogin;

import finarya_DataProvider.UserLogin;
import finarya_Pages.FinaryaTC01_LoginPage;

public class TC_LoginNoOfUser extends TestBaseForUserLogin {

	@Test(priority = 1, dataProvider = "userloginscenario", dataProviderClass = UserLogin.class)
	public void loginfromexcel(String USERNAME, String PASSWORD) throws Exception {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.usernamesend(USERNAME);
		loginpage.passwordSend(PASSWORD);
		loginpage.clickOnLoginButton();
		loginpage.loginsucsessfull();
	
	}
	

}
