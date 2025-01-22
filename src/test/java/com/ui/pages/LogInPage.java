package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public final class LogInPage extends BrowserUtility {
	
	private static final By EMAIL_LOCATOR=By.xpath("//input[@id='email']");
	private static final By PASSWORD_LOCATOR=By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BUTTON_LOCATOR= By.xpath("//button[@id='SubmitLogin']");
	private static final By ERROR_MESSAGE_LOCATOR= By.xpath("//div[contains(@class,'alert-danger')]//ol//li");

	public LogInPage(WebDriver driver) {
		super(driver);
			}

	public MyAccountPage doingLoginWith(String emailAddress, String password) {
		enterText(EMAIL_LOCATOR,emailAddress);
		enterText(PASSWORD_LOCATOR,password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
		
	}
	public LogInPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		enterText(EMAIL_LOCATOR,emailAddress);
		enterText(PASSWORD_LOCATOR,password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LogInPage loginPage=new LogInPage(getDriver());
		return loginPage;
		
	}
	
	public String getErrorMessage() {
		return getStringValue(ERROR_MESSAGE_LOCATOR);
	}
}
