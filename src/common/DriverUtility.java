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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class DriverUtility {
	private static ScreenRecorder screenRecorder;
	private static Logger logger= LogManager.getLogger(DriverUtility.class.getName());

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static void closeAlertAndGetItsText(WebDriver driver, int nAcceptFlag) {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (DriverConstant.ALERT_ACCEPT == nAcceptFlag) {
			alert.accept();
		} else if (DriverConstant.ALERT_DISMISS == nAcceptFlag){
			alert.dismiss();
		}
		
		logger.info("----- Alert Text: " + alertText + "-----");
	}
	
	public static void TakeScreenShot(WebDriver driver, String strFileName) throws IOException{
		if (DriverConstant.SCREEN_SHORT_FLAG){
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// get local system time
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String strTimeStampFileName = dateFormat.format(now) + "_" + strFileName;
			// Use timestamp file name
			String strFilePath = DriverConstant.SCREENSHOT_PATH + strTimeStampFileName +".jpg";
			FileUtils.copyFile(screenshot, new File(strFilePath));
		}
	}
	
	public static void InitScreenRecorder() throws IOException, AWTException{
		if (DriverConstant.SCREEN_RECORDER_FLAG){
			// video Save Path:C:users<<UserName>>Videos
			GraphicsConfiguration gconfig = GraphicsEnvironment
					  .getLocalGraphicsEnvironment()
					  .getDefaultScreenDevice()
					  .getDefaultConfiguration();
			org.monte.media.Format fileFormat = new org.monte.media.Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI);
			org.monte.media.Format screenFormat = new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
					  ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
					  CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
					  DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
					  QualityKey, 1.0f,
					  KeyFrameIntervalKey, (int) (15 * 60));
			org.monte.media.Format mouseFormat = new org.monte.media.Format(MediaTypeKey, MediaType.VIDEO,
					  EncodingKey,"black",
					  FrameRateKey, Rational.valueOf(30));
			screenRecorder = new ScreenRecorder(gconfig, fileFormat, screenFormat, mouseFormat, null);
		}
	}
	
	public static void 	startScreenRecorder() throws IOException{
		if (DriverConstant.SCREEN_RECORDER_FLAG){
			// Start Capturing the Video
			screenRecorder.start();
		}
	}
	
	public static void 	stopScreenRecorder() throws IOException{
		if (DriverConstant.SCREEN_RECORDER_FLAG){
		    // Stop the ScreenRecorder
		    screenRecorder.stop();
		}
	}
	
	public static void uploadImageFile(String strImageFile) throws IOException{
		String strUploadExePath = DriverConstant.UPLOAD_FILE_EXE_PATH;
		if ("Firefox" == DriverManager.getBrowserType()) {
			strUploadExePath= DriverConstant.UPLOAD_FILE_EXE_PATH_FIREFOX;
		}
		String strDisplayImgPath = DriverConstant.WORKSPACE_DIR_PATH + "\\resource\\" + strImageFile;
        Runtime.getRuntime().exec(strUploadExePath + " " + strDisplayImgPath);
	}
	
	public static void uploadImageForFile(WebDriver driver, String strElement, String strImageFile) throws IOException, InterruptedException{
		driver.findElement(By.id(strElement)).click();
		Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
		uploadImageFile(strImageFile);
        Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
	}
	
	public static void uploadImageForPopup(WebDriver driver, String strElement, String strImageFile) throws IOException, InterruptedException{
		driver.findElement(By.id(strElement)).click();
		Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
		uploadImageFile(strImageFile);
        Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
	    driver.findElement(By.id("confirm_crop")).click();
		Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
	}
	
	public static void closeSubWindow(WebDriver driver){
		// Get all window handles
		Set<String> handles = driver.getWindowHandles();
		// Save main Window
		String mainWindowhandle = driver.getWindowHandle();
		// sub window hanlde
		String subWindowHandle = null;
		// Get sub window hanlde
		Iterator<String> iterator = handles.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			if (mainWindowhandle.equals(key)){
				continue;
			}
			subWindowHandle = key;
		}
		// Find subWindow and close
		WebDriver subWindow = driver.switchTo().window(subWindowHandle);
		subWindow.close();
		handles.remove(subWindowHandle);
		// switch to main window
		driver = driver.switchTo().window(mainWindowhandle);
	}
}
