package com.ui.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pojos.UserTestData;

@Listeners({com.ui.listeners.TestListner.class})
public class LoginTest extends TestBase{
	
	
	@Test(description = "Verify valid user is able to login into the application", groups = { "e2e","sanity" }, 
			dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, 
			dataProvider = "LoginTestCSVDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginCSVTest(UserTestData user) {
		assertEquals(hp.goToLoginPage().doingLoginWith(user.getEmailAddress(), user.getPassword()).verifyUserName(),
				"Abhishek Yadav");

	}

}