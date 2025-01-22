package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.ui.utilities.BrowserUtility;


public class ProductDetailPage extends BrowserUtility{

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	private static final By SIZE_DROPDOWN_LOCATOR= By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR=By.xpath("//p//button[@class='exclusive']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailPage changeSize(Size size) {
		selectFromDropdown(SIZE_DROPDOWN_LOCATOR,size.toString());
		return new ProductDetailPage(getDriver());
		
	}
	
	public ProductDetailPage addToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}
	public ShoppingCartSummaryPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartSummaryPage shoppingCartSummary=new ShoppingCartSummaryPage(getDriver());
		return shoppingCartSummary;
	}

}
