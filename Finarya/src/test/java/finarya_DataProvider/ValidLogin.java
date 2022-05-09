package finarya_DataProvider;

import org.testng.annotations.DataProvider;

public class ValidLogin {
	
	@DataProvider(name = "Login")

	public Object[][] getDataforLogin() {
		return new Object[][] {

				{ "admin", "Admin@1234" }

		};

	}

}
