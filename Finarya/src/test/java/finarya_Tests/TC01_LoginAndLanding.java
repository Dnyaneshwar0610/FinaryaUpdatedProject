package finarya_Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import finarya_BaseClass.TestBaseLogin;
import finarya_DataProvider.ValidLogin;
import finarya_Pages.FinaryaTC01_LoginPage;

public class TC01_LoginAndLanding extends TestBaseLogin {

	@Test(priority = 1, dataProvider = "Login",dataProviderClass=ValidLogin.class)
	public void validLogin(String Username, String Password) throws Exception {
		FinaryaTC01_LoginPage loginpage = new FinaryaTC01_LoginPage(driver);
		loginpage.usernamesend(Username);
		loginpage.passwordSend(Password);
		loginpage.clickOnLoginButton();
		loginpage.loginsucsessfull();
		
		
	}

	
}
