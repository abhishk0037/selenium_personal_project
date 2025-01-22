package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']");
	private static final By SEARCH_TEXT_BOX_LOCATOR=By.xpath("//input[@id='search_query_top']");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR=By.xpath("//a[contains(@title,'first address')]");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String verifyUserName() {
		return getStringValue(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchForAProduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR,productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR,Keys.ENTER);
		SearchResultPage searchResultPage=new SearchResultPage(getDriver());
		return searchResultPage;
	}
	
	public MyAddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		MyAddressPage addressPage= new MyAddressPage(getDriver());
		return addressPage;
	}

}
