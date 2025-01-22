package com.ui.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public  abstract class BrowserUtility {
	
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;
	
	
	private static ThreadLocal<WebDriver> driverThread=new ThreadLocal<WebDriver>();
	
	public BrowserUtility(WebDriver driver){
		super();
		driverThread.set(driver);
		wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
	}
	
	
	public WebDriver getDriver() {
		return driverThread.get();
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if(browserName==Browser.CHROME){
			if(isHeadless) {
				ChromeOptions options= new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				logger.info("launching chrome browser in headless mode");
				driverThread.set(new ChromeDriver(options));
				wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
			}
			else {
			logger.info("launching chrome browser");
			driverThread.set(new ChromeDriver());
			wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
		}
		}
		if(browserName==Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options= new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu"); 
			    driverThread.set(new EdgeDriver(options));
			    wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
		}
			else {
				driverThread.set(new EdgeDriver());
			    wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
			}
		}
		if(browserName==Browser.FIREFOX){
			if(isHeadless) {
				FirefoxOptions options= new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
			    driverThread.set(new FirefoxDriver(options));
			    wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
		}
			else {
				driverThread.set(new FirefoxDriver());
			    wait=new WebDriverWait(driverThread.get(),Duration.ofSeconds(30L));
			}
	}
	}
	
	public void goToWebsite(String url) {
		logger.info("visiting the website");
		driverThread.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("maximizing the browser window");
		driverThread.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(element));
		logger.info("element found and now performing click");
		element1.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found and now performing click");
		element.click();
	}
	
	public void clickOn(WebElement element) {
		logger.info("performing click");
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found and now enter text"+textToEnter);
		element.sendKeys(textToEnter);
	}
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("element found and now enter key" +keyToEnter);
		element.sendKeys(keyToEnter);
	}
	
	public String getStringValue(By locator) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found and now returning the visible text");
		return element.getText();	
	}
	
	public String getStringValue(WebElement element) {
		logger.info("returning the visible text");
		return element.getText();	
	}
	

	public List<String> getAllStringValues(By locator) {
		logger.info("finding element with the locator"+locator);
		List<WebElement> elementList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("element found and now returning the visible text");
		List<String> visibleTextList= new ArrayList<String>();
		logger.info("returning the visible text List");
		for(WebElement element:elementList) {
			visibleTextList.add(getStringValue(element));
		}
		return visibleTextList;	
	}
	
	public List<WebElement> getAllElements(By locator) {
		logger.info("finding element with the locator"+locator);
		List<WebElement> elementList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;	
	}
	
	public void selectFromDropdown(By dropDownLocator, String textToSelect) {
		logger.info("Finding element with the locator"+ dropDownLocator);
		WebElement element =driverThread.get().findElement(dropDownLocator);
		Select select=new Select(element);
		logger.info("Selecting the option "+ textToSelect);
		select.selectByVisibleText(textToSelect);
		
	}
	
	public void clearText(By locator) {
		logger.info("finding element with the locator"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("element found and now clearing the text");
		element.clear();	
	}
	
	
	public void closeBrowser() {
        driverThread.get().quit();
    }
	
	public static String takeScreenShot(String testCaseName) {
		TakesScreenshot screenshot=(TakesScreenshot) driverThread.get();
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		SimpleDateFormat format= new SimpleDateFormat("HH-mm-ss");
		String timestamp=format.format(date);
		String path= System.getProperty("user.dir")+"//screenshots//"+testCaseName+"-"+timestamp+".png";
		File screenshotFile= new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
	

}
