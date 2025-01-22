package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ShoppingConfirmAddressPage extends BrowserUtility {

	public ShoppingConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//button[@name='processAddress']");
	 
	public ShippingPage goToShippingPage() {
		 clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		 ShippingPage shippingPage= new ShippingPage(getDriver());
		 return shippingPage;
	 }

}
