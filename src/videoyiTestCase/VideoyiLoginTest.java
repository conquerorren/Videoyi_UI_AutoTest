/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @author Ren Qiang
 * 
 * Copyright (C) 2017 YingPu Corporation.
 * 
 */
package videoyiTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import common.DriverConstant;
import common.DriverUtility;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class VideoyiLoginTest {
	private static Logger logger= LogManager.getLogger(VideoyiLoginTest.class.getName());
	private static WebDriver driver;
	
    /**
     * Init webDriver.
     */
	public static void setWebDriver(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /**
     * videoyi Login.
     */
	@Test
	public void testVideoyiLogin() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {			
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 输入用户名
			driver.findElement(By.id("video_email")).clear();
			driver.findElement(By.id("video_password")).clear();
			driver.findElement(By.id("video_email")).sendKeys("renqiang@zhiruyi.com");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 输入用户名 OK.-----");			

			// 输入密码
			driver.findElement(By.id("video_password")).sendKeys("moviebook");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 输入密码 OK.-----");
			
			// 点击登录
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击登录 OK.-----");

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/workorder/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		} catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
}
