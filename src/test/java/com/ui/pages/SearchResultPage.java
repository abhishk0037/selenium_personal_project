package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utilities.BrowserUtility;


public final class SearchResultPage extends BrowserUtility{
	
	public SearchResultPage(WebDriver driver) {
		super(driver);	
	}
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR=By.xpath("//span[contains(@class,'lighter')]");
	private static final By PRODUCT_LISTS_SEARCHED_NAME= By.xpath("//h5[@itemprop='name']//a");
	
	public String getTitle() {
		return getStringValue(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchtermPresentInProductsList(String searchTerm) {
		List<String> keywords=Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList=getAllStringValues(PRODUCT_LISTS_SEARCHED_NAME);
		

		boolean result = false;
		for (String name : productNamesList) {
		    for (String keyword : keywords) {
		        if (name.toLowerCase().contains(keyword)) {
		            result = true;
		            break;
		        }
		    }
		    if (result) {
		        break;
		    }
		}
		return result;
	}
	
	public ProductDetailPage clickOnTheProductAtIndex(int index) {
		clickOn(getAllElements(PRODUCT_LISTS_SEARCHED_NAME).get(index));
		ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}
	
}
