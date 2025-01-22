package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojos.MyAddressPOJO;
import com.ui.utilities.FakeDataGenerateUtility;

public class PostLoginAddFirstAddressTest extends TestBase {
	private MyAccountPage myAccountPage;
	MyAddressPOJO address;
	@BeforeMethod(description="valid First time user logs into the application")
	public void validUserLoginInTheApplication() {
		myAccountPage=hp.goToLoginPage().doingLoginWith("metod46664@anypng.com","123456789");
		address=FakeDataGenerateUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
		String firstaddress=myAccountPage.goToAddAddressPage().saveAddressWithVariablesForFaker(address);	
		Assert.assertEquals(firstaddress, address.getAddressAlias().toUpperCase());
	}
}