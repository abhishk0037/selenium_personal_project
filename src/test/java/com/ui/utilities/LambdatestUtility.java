package com.ui.utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdatestUtility {
	/*This class will be responsible to run my test on Lambda Test
	 * Job of this class is- 
	 * 1.to have thread local desired capabilities
	 * 2.to have thread local webDriver for each of the test
	 * 3.instantiating driver 
	 * */
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
	private static  ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initializeLambdatestSession(String browser,String testName) {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName",browser );
	        capabilities.setCapability("browserVersion", "127");
	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user", System.getenv("abhishekydv9099"));
	        ltOptions.put("accessKey", System.getenv("suKmJKnxMzXZ5a0AqZSzc85Dow8lYUKw9nw4fUYJPxMvB1hUXu"));
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", testName);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "4.23.0");
	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitiesLocal.set(capabilities);
	        WebDriver driver=null;
	        try {
				driver= new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}

	        driverLocal.set(driver); 
	        /*return the driver instance*/
	        return driverLocal.get();
	}
	
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}

}
