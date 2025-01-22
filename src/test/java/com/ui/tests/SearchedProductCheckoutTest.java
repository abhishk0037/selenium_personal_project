package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class SearchedProductCheckoutTest extends TestBase{
	private static final String SEARCH_TERM="Printed Summer Dress";
	private SearchResultPage searchResultPage=null;
	
	@BeforeMethod(description="")
	public void validUserLoginInTheApplicationAndSearchedAproduct() {
		searchResultPage=hp.goToLoginPage().doingLoginWith("metod46664@anypng.com","123456789").searchForAProduct(SEARCH_TERM);
	}
	
	@Test
	(description="Verify if the logged in user is able to buy a dress", groups= {"e2e","sanity"})
	public void checkoutTest() {
		String result=searchResultPage.clickOnTheProductAtIndex(0).changeSize(M).addToCart().proceedToCheckout().goToConfirmAddressPage()
		.goToShippingPage().goToPaymentPage().makePaymentByWire();
		Assert.assertEquals(result, "Your order on My Shop is complete.");
		Assert.assertTrue(result.contains("complete"));
		
	}

}
