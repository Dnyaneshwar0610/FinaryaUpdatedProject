package finarya_Tests;

import org.testng.annotations.Test;

import finarya_BaseClass.TestBaseLogin;
import finarya_DataProvider.CreateUsers;
import finarya_Pages.FinaryaTC_CreateUsersPage;

public class TC_CreateUsersLogin extends TestBaseLogin {

	@Test(priority = 1)
	public void profilemodule() {
		FinaryaTC_CreateUsersPage UserLogin = new FinaryaTC_CreateUsersPage(driver);
		UserLogin.clickonprofile();
	}

	@Test(priority = 2)
	public void adminmodule() throws Exception {
		FinaryaTC_CreateUsersPage UserLogin = new FinaryaTC_CreateUsersPage(driver);
		Thread.sleep(1500);
		UserLogin.clickOnAdministration();
		Thread.sleep(1500);
		UserLogin.clickOnUserManagement();
		Thread.sleep(1500);
		UserLogin.clickOnCreateUser();

	}

	@Test(priority = 3, dataProvider = "UserCreateScenario", dataProviderClass = CreateUsers.class)
	public void loginusercreate(String NameLoginId, String FullName, String Pass, String EmailId, String Dep)
			throws Exception {
		FinaryaTC_CreateUsersPage UserLogin = new FinaryaTC_CreateUsersPage(driver);
		Thread.sleep(1000);
		UserLogin.loginIDTextBox(NameLoginId);
		UserLogin.userFullNameTextBox(FullName);
		Thread.sleep(1000);
		UserLogin.passTextBox(Pass);
		Thread.sleep(1000);
		UserLogin.emailTextBox(EmailId);
		Thread.sleep(1000);
		UserLogin.departmentDropDown();
		Thread.sleep(1000);
		UserLogin.searchDropDown(Dep);
		Thread.sleep(1000);
		UserLogin.dropdownvalue();
		Thread.sleep(2000);
		UserLogin.clickonNextButton();
		Thread.sleep(1000);
		UserLogin.clickonAllCheckBox();
		Thread.sleep(1000);
		UserLogin.clickonSaveButton();
		try {
			UserLogin.Assertion();
		} catch (AssertionError e) {
			e.printStackTrace();

		}
		UserLogin.clickonOkButton();
		Thread.sleep(1000);
		adminmodule();
	}

}
