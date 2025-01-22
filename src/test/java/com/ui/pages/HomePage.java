package com.ui.pages;

import static com.constants.Environment.QA;
import static com.ui.utilities.PropertiesUtil.readProperty;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.LoggerUtility;

public final class HomePage extends BrowserUtility{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
     public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(readProperty(QA, "URL"));
	}
     
     public HomePage(WebDriver lambdaDriver) {
 		super(lambdaDriver);
 	}
          
	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@title='Log in to your customer account']");
   
     public LogInPage goToLoginPage() {
    	 logger.info("trying to perform click to go to sign in page");
    	 clickOn(SIGN_IN_LINK_LOCATOR);
    	 LogInPage loginPage= new LogInPage(getDriver());
    	 return loginPage;
     }


   
}
