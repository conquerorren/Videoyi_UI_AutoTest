/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @author Ren Qiang
 * 
 * Copyright (C) 2017 YingPu Corporation.
 * 
 */
package videoyiAutoTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.LogManager;
import common.DriverConstant;
import common.DriverManager;
import common.DriverUtility;
import videoyiTestCase.MemberManagerTest;
import videoyiTestCase.ProductManagerTest;
import videoyiTestCase.VideoyiLoginTest;
import videoyiTestCase.WorkorderManagerTest;

public class videoyiTestNGMain {
	private static WebDriver driver;
	private static String baseUrl;
	private static Logger logger = LogManager.getLogger(videoyiTestNGMain.class.getName());
	
	public static WebDriver DriverInstance(){
		return driver;
	}
	
	//http://www.yiibai.com/selenium/selenium_multi_browser_testing.html
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String strBrowser) throws IOException, AWTException {
		DOMConfigurator.configure("log4j.xml");
		
		logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
		logger.info("# # # # # # # # # #TEST Has Started# # # # # # # # # #");
		// init Screen Recorder
		DriverUtility.InitScreenRecorder();
		// Start Screen Recorder
		DriverUtility.startScreenRecorder();
		
	    // *******Test Start*******
		// init the Web Driver
		driver = DriverManager.launchBrowser(strBrowser);
		
		baseUrl = DriverConstant.TEST_BASE_URL;
	    driver.get(baseUrl + "/");
		logger.info("# # # # # # # # #Open Test Application# # # # # # # #");		
		
		VideoyiLoginTest.setWebDriver(driver);		
		MemberManagerTest.setWebDriver(driver);
		ProductManagerTest.setWebDriver(driver);
		WorkorderManagerTest.setWebDriver(driver);
	}
		
	@AfterTest
	public static void closeBrowser() throws Exception {
		// Stop Screen Recorder
		// Output Path:C:\Users\Administrator\Videos
		DriverUtility.stopScreenRecorder();
	    // *******Test End*******
	    Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
		DriverManager.closeBrowser();
		logger.info("# # # # # # # #Close Test Application# # # # # # # #");
		logger.info("# # # # # # # # # #TEST Has Ended# # # # # # # # # #");
		logger.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
	}
}
