/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @author Ren Qiang
 * 
 * Copyright (C) 2017 YingPu Corporation.
 * 
 */
package common;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
	private static StringBuffer verificationErrors = new StringBuffer();
	private static Logger logger= LogManager.getLogger(DriverManager.class.getName());
	private static WebDriver s_driver;
	
	public static WebDriver launchBrowser(String browser) {
		if (null == browser)
		{
			return null;
		}
		
		if (browser.equalsIgnoreCase("Firefox")) {
			logger.info("# # # # # # # # #Executing on FireFox# # # # # # # # #");
			
			s_driver = initFirefoxDriver();			
		} else if (browser.equalsIgnoreCase("Chrome")) {
			logger.info("# # # # # # # # #Executing on CHROME# # # # # # # # #");
			
			s_driver = initChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			logger.info("# # # # # # # # #Executing on IE# # # # # # # # #");
			
			s_driver = initInternetExlplorerDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		return s_driver;
	}
	
	public static void closeBrowser() throws Exception {
		s_driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private static WebDriver initFirefoxDriver() {
		System.setProperty("webdriver.firefox.bin", DriverConstant.FIREFOX_DRIVER_SERVER);		
		s_driver = new FirefoxDriver();
		s_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the browser
		s_driver.manage().window().maximize();
		return s_driver;
	}

	private static WebDriver initInternetExlplorerDriver() {
		// IE Driver
		System.setProperty("webdriver.ie.driver", DriverConstant.IE_DRIVER_SERVER);
		
		// set IE port
		InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
		InternetExplorerDriverService internetExplorerService = builder.usingPort(5678).withHost("127.0.0.1").build();
		
		// set IE protect Mode to Clean the dirty data of browser
		DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
		capab.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);	
		capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		s_driver = new InternetExplorerDriver(internetExplorerService, capab);
		s_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the browser
		s_driver.manage().window().maximize();
		return s_driver;
	}

	private static WebDriver initChromeDriver() {
		try
		{
			// Chrome Driver
			System.setProperty("webdriver.chrome.driver", DriverConstant.Chrome_DRIVER_SERVER);				
			ChromeOptions options = new ChromeOptions();
			// set agruments not to display"data;"
			options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/UserData/Default");

			// Add Chrome Port
//			ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
//			ChromeDriverService chromeService = builder.usingPort(3333).build();		
			
			// create Chrome Driver
			s_driver = new ChromeDriver();
			s_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Maximize the browser
			s_driver.manage().window().maximize();
			return s_driver;		
		}
		catch(Exception e1) {
			logger.error(e1);
			throw (e1);
		}
	}
	
	/**
     * Get browser type, for execute JavaScript by Selenium
     * 
     * @author Aaron.ffp
     * @version V1.0.0: autoSeleniumDemo main.aaron.sele.core SeleniumCore.java getBrowerType, 2015-7-26 12:17:12 Exp $
     * 
     * @return browser type {Chrome|Firefox|InternetExplorer|Safari}
     */
    public static String getBrowserType(){
        String browser = "";
        
        switch (s_driver.toString().split(":")[0]) {
            case "ChromeDriver":
                browser = "Chrome";
                break;
                
            case "FirefoxDriver":
                browser = "Firefox";
                break;
                
            case "InternetExplorerDriver":
                browser = "InternetExplorer";
                break;
                
            case "SafariDriver":
                browser = "Safari";
                break;
                
            default:
                browser = "Chrome";
                break;
        }
        
        return browser;
    }
}