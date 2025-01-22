package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listeners.TestListner.class})
public class ProductSearchTest extends TestBase {
	MyAccountPage myAccountPage;
	private static final String SEARCH_TERM= "Printed Summer Dress";
	
	@BeforeMethod(description="valid user logs into the application")
	public void validUserLogin() {
		myAccountPage=hp.goToLoginPage().doingLoginWith("metod46664@anypng.com","123456789");
	}
	
	@Test(description="verify if the user is able to search the product and correct products search resultsare displayed",
	groups={"e2e","sanity"})
	public void verifyProductSearchTest() {
		boolean actualResult=myAccountPage.searchForAProduct(SEARCH_TERM).isSearchtermPresentInProductsList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
		
		
	}

}