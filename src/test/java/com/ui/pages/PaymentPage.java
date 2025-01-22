package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;


public class PaymentPage extends BrowserUtility{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR= By.xpath("//a[@class='bankwire']");
	private static final By CONFIRM_MY_ORDER_BUTTON_LOCATOR= By.xpath("//p/button[contains(@class,'btn-default')]");
	private static final By ALERT_SUCCESS_MESSAGE_LOCATOR=By.xpath("//p[contains(@class,'alert-success')]");
	
	public String makePaymentByWire() {
		clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_MY_ORDER_BUTTON_LOCATOR);
		String successMessage=getStringValue(ALERT_SUCCESS_MESSAGE_LOCATOR);
		return successMessage;
	}
}
