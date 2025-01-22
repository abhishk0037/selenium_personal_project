package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ShoppingCartSummaryPage  extends BrowserUtility {

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
	}
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//p/a[@title='Proceed to checkout']");
	
	public ShoppingConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingConfirmAddressPage confirmAddressPage= new ShoppingConfirmAddressPage(getDriver());
		return confirmAddressPage;
	}

}
