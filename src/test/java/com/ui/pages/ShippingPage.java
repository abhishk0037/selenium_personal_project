package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	public static final By ACCEPT_TERMS_CHECKBOX_LOCATOR= By.xpath("//div[@id='uniform-cgv']");
	public static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//button[@name='processCarrier']");
	
	public PaymentPage goToPaymentPage() {
		clickOnCheckbox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		PaymentPage paymentPage=new PaymentPage(getDriver());
		return paymentPage;
	}

}
