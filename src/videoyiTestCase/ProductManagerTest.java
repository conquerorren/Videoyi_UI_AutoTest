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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.DriverConstant;
import common.DriverUtility;
import org.apache.log4j.Logger;

import org.apache.log4j.LogManager;

public class ProductManagerTest {
	private static Logger logger= LogManager.getLogger(ProductManagerTest.class.getName());
	private static WebDriver driver;
	
	public static void setWebDriver(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /**
     * Jump Into Create Product Page.
     */
	@Test
	public void testProductManager() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			driver.findElement(By.id("rightbg00000090")).click();
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
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
		
    /**
     * Create Baike Product.
     */
	@Test
	public void testCreateBaikeProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 百科信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 百科信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 百科Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【百科信息】用于创建百科知识类智点，内容可以是人物、地点、品牌、话题等。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_百科物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮文案");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案 OK.-----");

			// 跳转链接
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.moviebook.com.cn");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接 OK.-----");
			
			// 详细描述
			driver.findElement(By.id("product_description_text")).clear();
			driver.findElement(By.id("product_description_text")).sendKeys("AutoTest详细描述内容@#*&%包含各种信息");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 详细描述 OK.-----");
			
			// 展示图片
			DriverUtility.uploadImageForPopup(driver, "show_img_div_1", "baike.png");
			logger.info("-----" + strMethodName + " 展示图片 OK.-----");
		    
		    // 选择图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[28]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标 OK.-----");
			
		    // 选择地点
		    driver.findElement(By.id("icon_id61")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择地点 OK.-----");
			
		    // 选择颜色
		    driver.findElement(By.xpath("//*[@id='style']/div[3]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色 OK.-----");
			
		    // 选择边框
			DriverUtility.uploadImageForFile(driver, "img_val_border", "border.png");
			logger.info("-----" + strMethodName + " 选择边框 OK.-----");
	        
	        // logo位置
			driver.findElement(By.xpath("//*[@id='style']/div[7]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " logo位置 OK.-----");
			
			// logo图片
			DriverUtility.uploadImageForPopup(driver, "logo_img_border", "logo.png");
			logger.info("-----" + strMethodName + " logo图片 OK.-----");

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");			

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

    /**
     * Edit Baike Product.
     */
	@Test
	public void testEditBaikeProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击编辑百科物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑百科物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_百科名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改按钮文案 OK.-----");

			// 跳转链接
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.videoyi.com");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改跳转链接 OK.-----");
			
			// 详细描述
			driver.findElement(By.id("product_description_text")).clear();
			driver.findElement(By.id("product_description_text")).sendKeys("AutoTest详细描述内容内容修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改详细描述 OK.-----");

			// 隐藏展示效果面板 
			driver.findElement(By.xpath("//*[@id='baike_l2']/div[1]/span")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			
			// 显示删除图片
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("$('.sc_c').css('display', 'block');");  
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);			
	
			// 删除展示图片
			driver.findElement(By.xpath("//*[@id='show_img_add']/div[1]/div[1]")).click();
			logger.info("-----" + strMethodName + " 删除展示图片 OK.-----");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);			

			// 上传展示图片1
			DriverUtility.uploadImageForPopup(driver, "show_img_div_0", "baike0.png");
			logger.info("-----" + strMethodName + " 展示图片1 OK.-----");
			
			// 上传展示图片2~5
			for (int i = 1; i <= 4; i++){
				String strOtherId = "show_img_div_" + (i + 1);
				String strOtherImageId = "baike" + i + ".png";
				DriverUtility.uploadImageForPopup(driver, strOtherId, strOtherImageId);
				logger.info("-----" + strMethodName + " 展示图片" + (i + 1) + " OK.-----");
			}

			// 显示展示效果面板
			driver.findElement(By.id("baike_l1")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			
		    // 选择图标：自定义图标				
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[12]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择自定义图标 OK.-----");

		    // 选择自定义图标
			DriverUtility.uploadImageForPopup(driver, "customize_div", "baike_customize.png");
			logger.info("-----" + strMethodName + " 选择自定义图标 OK.-----");			
			
		    // 选择颜色 
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:默认 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:蓝色 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色：紫色 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/label[4]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色：自定义颜色 OK.-----");
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[1]")).sendKeys("255");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[2]")).sendKeys("100");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[17]/div/div/input[3]")).sendKeys("150");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:RGB输入 OK.-----");
			
			// 显示删除图片
			jse.executeScript("$('.sc_cshu').css('display', 'block');");  
		    // 选择边框:删除边框
			driver.findElement(By.xpath("//*[@id='img_val_border']/div")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 删除边框 OK.-----");
	        
	        // logo位置
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[21]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " logo位置:位置一 OK.-----");
			
			// logo图片
			DriverUtility.uploadImageForPopup(driver, "logo_img_border", "logo_h.png");
			logger.info("-----" + strMethodName + " logo图片 OK.-----");

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定删除
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

    /**
     * Create Gouwu Product.
     */
	@Test
	public void testCreateGouwuProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 购物信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 购物信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");	
			
			// Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【购物】用于创建商品购买类智点，目的是让观众点击购买链接，从而引流转化。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_购物物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto点击购买");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案 OK.-----");

			// 跳转链接
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.moviebook.com.cn");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接 OK.-----");
			
			// 价格
			driver.findElement(By.name("product_min_price")).clear();
			driver.findElement(By.name("product_min_price")).sendKeys("123");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 价格 OK.-----");
			
			// 详细描述
			driver.findElement(By.id("product_description_text")).clear();
			driver.findElement(By.id("product_description_text")).sendKeys("AutoTest购物详细描述内容@#*&%包含各种信息");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 详细描述 OK.-----");
			
			// 展示图片
			DriverUtility.uploadImageForPopup(driver, "show_img_div_1", "gouwu.png");
			logger.info("-----" + strMethodName + " 展示图片 OK.-----");
		    
		    // 选择图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[28]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标 OK.-----");
			
		    // 选择购物
		    driver.findElement(By.id("icon_id71")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择地点 OK.-----");
			
		    // 选择颜色:紫色
		    driver.findElement(By.xpath("//*[@id='style']/div[3]/div/label[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色 OK.-----");
			
		    // 选择边框
			DriverUtility.uploadImageForFile(driver, "img_val_border", "border.png");
			logger.info("-----" + strMethodName + " 选择边框 OK.-----");
	        
	        // logo位置
			driver.findElement(By.xpath("//*[@id='style']/div[7]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " logo位置 OK.-----");
			
			// logo图片
			DriverUtility.uploadImageForPopup(driver, "logo_img_border", "logo_h.png");
			logger.info("-----" + strMethodName + " logo图片 OK.-----");

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");			

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

    /**
     * Edit Gouwu Product.
     */
	@Test
	public void testEditGouwuProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击编辑购物物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑购物物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_购物名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改按钮文案 OK.-----");

			// 跳转链接
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.videoyi.com");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改跳转链接 OK.-----");
			
			// 详细描述
			driver.findElement(By.id("product_description_text")).clear();
			driver.findElement(By.id("product_description_text")).sendKeys("AutoTest详细描述内容内容修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 修改详细描述 OK.-----");
			
			// 价格
			driver.findElement(By.name("product_min_price")).clear();
			driver.findElement(By.name("product_min_price")).sendKeys("350");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 价格 OK.-----");
			
			// 隐藏展示效果面板 Gouwu_2
			driver.findElement(By.xpath("//*[@id='Gouwu2']/div[1]/span")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 隐藏展示效果面板 OK.-----");
			
			// 显示删除图片
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("$('.sc_c').css('display', 'block');");  
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);		
			logger.info("-----" + strMethodName + " 显示删除图片 OK.-----");	
	
			// 删除展示图片
			driver.findElement(By.xpath("//*[@id='show_img_add']/div[1]/div[1]")).click();
			logger.info("-----" + strMethodName + " 删除展示图片 OK.-----");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);			

			// 上传展示图片1
			DriverUtility.uploadImageForPopup(driver, "show_img_div_0", "gouwu0.png");
			logger.info("-----" + strMethodName + " 展示图片1 OK.-----");
			
			// 上传展示图片2~5
			for (int i = 1; i <= 4; i++){
				String strOtherId = "show_img_div_" + (i + 1);
				String strOtherImageId = "gouwu" + i + ".png";
				DriverUtility.uploadImageForPopup(driver, strOtherId, strOtherImageId);
				logger.info("-----" + strMethodName + " 展示图片" + (i + 1) + " OK.-----");
			}

			// 显示展示效果面板 Gouwu_1
			driver.findElement(By.id("Gouwu12")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 显示展示效果面板  OK.-----");	
			
		    // 选择图标：自定义图标				
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[13]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择自定义图标 OK.-----");

		    // 选择自定义图标
			DriverUtility.uploadImageForPopup(driver, "customize_div", "gouwu_customize.png");
			logger.info("-----" + strMethodName + " 选择自定义图标 OK.-----");			
			
		    // 选择颜色 
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:默认 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:蓝色 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色：紫色 OK.-----");
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/label[4]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色：自定义颜色 OK.-----");
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[1]")).sendKeys("155");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[2]")).sendKeys("200");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[18]/div/div/input[3]")).sendKeys("50");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择颜色:RGB输入 OK.-----");
			
			// 显示删除图片
			jse.executeScript("$('.sc_cshu').css('display', 'block');");  
		    // 选择边框:删除边框
			driver.findElement(By.xpath("//*[@id='img_val_border']/div")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 删除边框 OK.-----");
	        
	        // logo位置
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[22]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " logo位置:位置二 OK.-----");
			
			// logo图片
			DriverUtility.uploadImageForPopup(driver, "logo_img_border", "logo.png");
			logger.info("-----" + strMethodName + " logo图片 OK.-----");

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定删除
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Hongbao Product.
     */
	@Test
	public void testCreateHongbaoProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 红包信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 红包信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 红包Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【红包】目前只支持支付宝口令红包，通过红包发放来提高曝光。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_红包物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮文案");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案 OK.-----");
			
			// 活动说明
			driver.findElement(By.name("activity_description")).clear();
			driver.findElement(By.name("activity_description")).sendKeys("Auto活动说明");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 活动说明 OK.-----");			

			// 红包口令
			driver.findElement(By.name("red_packet")).clear();
			driver.findElement(By.name("red_packet")).sendKeys("Auto红包口令");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 红包口令 OK.-----");
			
			// 兑换说明
			driver.findElement(By.name("convert_description")).clear();
			driver.findElement(By.name("convert_description")).sendKeys("请复制口令并保存");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 兑换说明 OK.-----");
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "hongbao_custom.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "hongbao_footer.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			// 选择图标:Video易默认图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[28]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:Video易默认图标 OK.-----");

			// 点击红包图标
    		driver.findElement(By.id("icon_id81")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击红包图标 OK.-----");	

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");			

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Edit Hongbao Product.
     */
	@Test
	public void testEditHongbaoProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击编辑红包物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑红包物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
						
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_红包名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称修改 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案 修改OK.-----");
			
			// 活动说明
			driver.findElement(By.name("activity_description")).clear();
			driver.findElement(By.name("activity_description")).sendKeys("Auto活动说明修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 活动说明修改 OK.-----");			

			// 红包口令
			driver.findElement(By.name("red_packet")).clear();
			driver.findElement(By.name("red_packet")).sendKeys("Auto红包口令修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 红包口令修改 OK.-----");
			
			// 兑换说明
			driver.findElement(By.name("convert_description")).clear();
			driver.findElement(By.name("convert_description")).sendKeys("请复制口令并保存修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 兑换说明修改 OK.-----");
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "hongbao_footer.png");
			logger.info("-----" + strMethodName + " 客户LOGO修改 OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "hongbao_custom.png");
			logger.info("-----" + strMethodName + " 广告图片修改 OK.-----");			

			// 选择图标:自定义图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[15]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:自定义图标 OK.-----");

			// 选择图标:自定义图标
			DriverUtility.uploadImageForPopup(driver, "customize_div", "hongbao_logo.png");
			logger.info("-----" + strMethodName + " 自定义图标:图片修改 OK.-----");	

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Youhuima Product.
     */
	@Test
	public void testCreateYouhuimaProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 优惠码信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[4]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 优惠码信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 优惠码Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【优惠码】用于营销活动发放优惠码，提高购买。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_优惠码物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮文案");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案 OK.-----");
			
			// 活动说明
			driver.findElement(By.name("activity_description")).clear();
			driver.findElement(By.name("activity_description")).sendKeys("Auto活动说明");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 活动说明 OK.-----");			

			// 优惠码口令
			driver.findElement(By.name("convert_code")).clear();
			driver.findElement(By.name("convert_code")).sendKeys("Al1eX49HQjhelmd\r\nFr4A5jdDmeoWPd50");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 优惠码口令 OK.-----");
			
			// 兑换说明
			driver.findElement(By.name("convert_description")).clear();
			driver.findElement(By.name("convert_description")).sendKeys("请复制优惠码并保存");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 兑换说明 OK.-----");
			
			// 结束说明
			driver.findElement(By.name("end_description")).clear();
			driver.findElement(By.name("end_description")).sendKeys("优惠码被领光啦!!");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 结束说明 OK.-----");
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "youhuima_logo.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "youhuima_img.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			// 选择图标:Video易默认图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[28]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:Video易默认图标 OK.-----");

			// 点击优惠码图标
    		driver.findElement(By.id("icon_id91")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击优惠码图标 OK.-----");	

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
	/**
     * Edit Youhuima Product.
     */
	@Test
	public void testEditYouhuimaProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击编辑优惠码物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑优惠码物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_优惠码名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称修改 OK.-----");
			
			// 按钮文案
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto按钮修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 按钮文案修改 OK.-----");
			
			// 活动说明
			driver.findElement(By.name("activity_description")).clear();
			driver.findElement(By.name("activity_description")).sendKeys("Auto活动说明修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 活动说明修改 OK.-----");			

			// 优惠码追加按钮
			driver.findElement(By.id("addition")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击优惠码追加按钮 OK.-----");			
			
			// 优惠码口令增加
			driver.findElement(By.name("convert_code")).clear();
			driver.findElement(By.name("convert_code")).sendKeys("Op3rkf9F30rGmtn");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 优惠码口令增加 OK.-----");
			
			// 兑换说明
			driver.findElement(By.name("convert_description")).clear();
			driver.findElement(By.name("convert_description")).sendKeys("请复制优惠码并保存修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 兑换说明修改OK.-----");
			
			// 结束说明
			driver.findElement(By.name("end_description")).clear();
			driver.findElement(By.name("end_description")).sendKeys("优惠码被领光啦!!内容修改!");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 结束说明修改 OK.-----");
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "youhuima_img.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "youhuima_logo.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			// 选择图标:自定义图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[16]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:自定义图标 OK.-----");

			// 选择优惠码自定义图标
			DriverUtility.uploadImageForPopup(driver, "customize_div", "youhuima_costomize.png");
			logger.info("-----" + strMethodName + " 自定义图标:图片修改 OK.-----");

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");			

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Toupiao Product.
     */
	@Test
	public void testCreateToupiaoProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 投票信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[5]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 投票信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 投票Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【投票】用于创建投票互动类智点，有提问及选项，观众可以参与投票。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_投票物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 选择版式:上下版式
			driver.findElement(By.xpath("//*[@id='format_border']/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:上下版式 OK.-----");
					
			// 投票提问
			driver.findElement(By.name("vote_problem")).clear();
			driver.findElement(By.name("vote_problem")).sendKeys("Auto_投票提问的问题是什么？");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票提问 OK.-----");
			
			// 投票选项1
			driver.findElement(By.xpath("//*[@id='option_val']/div[1]/input")).clear();
			driver.findElement(By.xpath("//*[@id='option_val']/div[1]/input")).sendKeys("Auto投票选项1");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票选项1 OK.-----");
			// 投票选项2
			driver.findElement(By.xpath("//*[@id='option_val']/div[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id='option_val']/div[2]/input")).sendKeys("Auto投票选项2");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票选项2 OK.-----");
			// 添加选项
			driver.findElement(By.id("add_option")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 添加选项 OK.-----");
			// 投票选项3
			driver.findElement(By.xpath("//*[@id='option_val']/div[3]/input")).clear();
			driver.findElement(By.xpath("//*[@id='option_val']/div[3]/input")).sendKeys("Auto投票选项3");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票选项3 OK.-----");
			// 删除选项3
			driver.findElement(By.xpath("//*[@id='option_val']/div[3]/button")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 删除选项3 OK.-----");
			
			for (int i = 3; i <=7; i++)	{
				// 添加选项
				driver.findElement(By.id("add_option")).click();
				Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
				logger.info("-----" + strMethodName + " 添加选项" + i +" OK.-----");
				// 投票选项3
				String strElement = "//*[@id='option_val']/div[" + i + "]/input";
				driver.findElement(By.xpath(strElement)).clear();
				driver.findElement(By.xpath(strElement)).sendKeys("Auto投票选项" + i);
				Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
				logger.info("-----" + strMethodName + " 投票选项" + i +" OK.-----");
			}
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "toupiao_logo.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "toupiao_img.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		

			// 选择图标:Video易默认图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[28]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:Video易默认图标 OK.-----");

			// 点击投票图标
    		driver.findElement(By.id("icon_id101")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击投票图标 OK.-----");	
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

	/**
     * Edit Toupiao Product.
     */
	@Test
	public void testEditToupiaoProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击编辑投票物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑投票物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");			
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_投票物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 选择版式:左右版式
			driver.findElement(By.xpath("//*[@id='format_border']/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:左右版式 OK.-----");
					
			// 投票提问
			driver.findElement(By.name("vote_problem")).clear();
			driver.findElement(By.name("vote_problem")).sendKeys("Auto_投票提问的修改！");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票提问修改 OK.-----");
			
			// 投票选项1
			driver.findElement(By.xpath("//*[@id='option_val']/div[1]/input[1]")).clear();
			driver.findElement(By.xpath("//*[@id='option_val']/div[1]/input[1]")).sendKeys("Auto投票选项1修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票选项1修改 OK.-----");
			// 投票选项2
			driver.findElement(By.xpath("//*[@id='option_val']/div[2]/input[1]")).clear();
			driver.findElement(By.xpath("//*[@id='option_val']/div[2]/input[1]")).sendKeys("Auto投票选项2修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 投票选项2修改 OK.-----");

			// 删除选项3~7
			for (int i = 7; i >= 3; i--)	{
				driver.findElement(By.xpath("//*[@id='option_val']/div[" + i + "]/button")).click();
				Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
				logger.info("-----" + strMethodName + " 删除选项" + i + " OK.-----");
			}
			
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "toupiao_img.png");
			logger.info("-----" + strMethodName + " 客户LOGO修改 OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "toupiao_logo.png");
			logger.info("-----" + strMethodName + " 广告图片修改 OK.-----");		

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");			

			// 选择图标:自定义图标
		    driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div/div[14]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择图标:自定义图标  OK.-----");

			// 选择图标:自定义图标
			DriverUtility.uploadImageForPopup(driver, "customize_div", "toupiao_customize.png");
			logger.info("-----" + strMethodName + " 自定义图片修改 OK.-----");		
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Shenzimu Product.
     */
	@Test
	public void testCreateShenzimuProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 神字幕信息
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[6]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 神字幕信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 神字幕Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【神字幕】用于创建趣味字体形式的动态贴片，并且可以关联浮层、跳转外链。");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_神字幕物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 选择版式:基础类
			new Select(driver.findElement(By.id("format_id"))).selectByVisibleText("基础类");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:基础类  OK.-----");

			// 选择版式:样式一
			new Select(driver.findElement(By.id("style_id"))).selectByVisibleText("样式一");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:样式一  OK.-----");
			
			// 文字内容
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto_文字内容");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 文字内容 OK.-----");
						
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "shenzimu_logo.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "shenzimu_img.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		

			// 点击效果：选择无
		    driver.findElement(By.xpath("//*[@id='click_effect']/div[1]/div[2]/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击效果：选择无 OK.-----");
			
			// 点击效果：外链
		    driver.findElement(By.xpath("//*[@id='click_effect']/div[1]/div[2]/label[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击效果：外链 OK.-----");

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");		

			// 提示外链未输入
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 提示外链未输入 OK.-----");
			
			// 跳转链接
			driver.findElement(By.name("jump_link")).clear();
			driver.findElement(By.name("jump_link")).sendKeys("www.baidu.com");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接 OK.-----");			

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

    /**
     * Edit Shenzimu Product.
     */
	@Test
	public void testEditShenzimuProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击编辑神字幕物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑神字幕物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");			
						
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_神字幕物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 选择版式:食品类
			new Select(driver.findElement(By.id("format_id"))).selectByVisibleText("食品类");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:食品类  OK.-----");

			// 选择版式:缤纷彩带
			new Select(driver.findElement(By.id("style_id"))).selectByVisibleText("缤纷彩带");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择版式:缤纷彩带  OK.-----");
			
			// 文字内容
			driver.findElement(By.name("product_text")).clear();
			driver.findElement(By.name("product_text")).sendKeys("Auto_文字内容修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 文字内容修改 OK.-----");
						
			// 客户LOGO
			DriverUtility.uploadImageForPopup(driver, "client_logo_border", "shenzimu_img.png");
			logger.info("-----" + strMethodName + " 客户LOGO OK.-----");
		    
		    // 广告图片
			DriverUtility.uploadImageForPopup(driver, "template_img_border", "shenzimu_logo.png");
			logger.info("-----" + strMethodName + " 广告图片 OK.-----");			

			//将页面滚动条拖到底部 
			JavascriptExecutor jse = (JavascriptExecutor)driver; 
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 滚动条拖到底部  OK.-----");		

			// 点击效果：浮层
		    driver.findElement(By.xpath("//*[@id='click_effect']/div[1]/div[2]/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击效果：浮层 OK.-----");			

			// 点击选择浮层物料
    		driver.findElement(By.id("sel_float_pro_but")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击选择浮层物料 OK.-----");	

			// 弹出框选择浮层物料：第一条
    		driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 弹出框选择浮层物料：第一条 OK.-----");				

			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Yishantie Product.
     */
	@Test
	public void testCreateYishantieProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 易植贴信息（由于其他模块注释掉了）
//			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[7]")).click();
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 易植贴信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 易植贴Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【易植贴】用于创建动态易植贴，可以跳转外链。");

		    // 团队归属
			new Select(driver.findElement(By.id("team_id"))).selectByVisibleText("影谱内部测试");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 团队归属 OK.-----");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");

		    // 归属平台
			new Select(driver.findElement(By.id("platform"))).selectByVisibleText("芒果TV");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 归属平台 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_易植贴物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 物料分类
			new Select(driver.findElement(By.id("category"))).selectByVisibleText("家用电器");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料分类 OK.-----");
			
			// 跳转链接:空
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接:空 OK.-----");
						
			// 添加易植贴
			DriverUtility.uploadImageForFile(driver, "img_val_corner", "yishantie1.png");
			logger.info("-----" + strMethodName + " 添加易植贴 OK.-----");
		    
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Edit Yishantie Product.
     */
	@Test
	public void testEditYishantieProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击编辑易植贴物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑易植贴物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_易植贴名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称修改 OK.-----");
			
			// 跳转链接:空
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.moviebook.com.cn");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接:修改 OK.-----");
						
			// 添加易植贴
			DriverUtility.uploadImageForFile(driver, "img_val_corner", "yishantie2.png");
			logger.info("-----" + strMethodName + " 添加易植贴修改 OK.-----");
		    
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");			

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Create Yishichuang Product.
     */
	@Test
	public void testCreateYishichuangProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击创建物料
			driver.findElement(By.xpath("//*[@id='right_main_height']/div[2]/div[6]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----testCreateGouwuProduct 创建物料页显示 OK.-----");
			
			// Change to 动态视窗信息(其他类型删除的原因)
//			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[8]")).click();
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div/label[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----testCreateGouwuProduct 动态视窗信息页显示 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 动态视窗Tip
			String strBaikeTip = driver.findElement(By.id("case_tip")).getText();
		    Assert.assertEquals(strBaikeTip, "【动态视窗】用于创建根植于剧情的动态视窗贴片广告。");

		    // 团队归属
			new Select(driver.findElement(By.id("team_id"))).selectByVisibleText("影谱内部测试");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 团队归属 OK.-----");

		    // 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");

		    // 归属平台
			new Select(driver.findElement(By.id("platform"))).selectByVisibleText("芒果TV");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 归属平台 OK.-----");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_动态视窗物料名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称 OK.-----");
			
			// 物料分类
			new Select(driver.findElement(By.id("category"))).selectByVisibleText("家用电器");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料分类 OK.-----");
		
			// 跳转链接:空
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接:空 OK.-----");
						
			// 动态视窗素材上传
			driver.findElement(By.xpath("//*[@id='video_up_form']/div/div[2]/a")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			DriverUtility.uploadImageFile("yishichuang1.mp4");
	        Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 动态视窗素材上传 OK.-----");
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}
	
    /**
     * Edit Yishichuang Product.
     */
	@Test
	public void testEditYishichuangProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击编辑易植贴物料
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[7]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 编辑易植贴物料 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Page");
			
		    // 物料名称
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.name("product_name")).sendKeys("AutoTest_动态视窗修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 物料名称修改 OK.-----");
			
			// 跳转链接:空
			driver.findElement(By.name("click_link")).clear();
			driver.findElement(By.name("click_link")).sendKeys("www.moviebook.com.cn");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 跳转链接:修改 OK.-----");
						
			// 动态视窗素材上传
			driver.findElement(By.xpath("//*[@id='video_up_form']/div/div[2]/a")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			DriverUtility.uploadImageFile("yishichuang2.flv");
	        Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 动态视窗素材上传修改 OK.-----");
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			
			// 确定
    		driver.findElement(By.id("submit")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");

			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/product/index", strURL);
			logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		}
		catch (Exception e1) {
			// Add a message to your Log File to capture the error
			logger.error("-----" + strMethodName + " failed.-----");
			logger.error(e1);
			// Take a screenshot which will be helpful for analysis.
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
			throw (e1);
		}
	}

	/**
     * Delete Product： Click Cancel.
     */
	@Test
	public void testDeleteProductCancel() throws Exception {		
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击删除
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[8]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			
			// 点击取消删除
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_DISMISS);
			logger.info("-----" + strMethodName + " 点击删除取消 OK.-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		} catch (UnhandledAlertException e1) {
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_DISMISS);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			logger.info("-----Handle UnhandledAlertException-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception_Success");
			logger.info("-----" + strMethodName + " Exception Success.-----");
		}
	}
	
    /**
     * Delete Product： Click OK.
     */
	@Test
	public void testDeleteProductOK() throws Exception {		
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击删除
			driver.findElement(By.xpath("//*[@id='product_list']/table/tbody/tr[2]/td[8]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);

			// 点击删除确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			logger.info("-----" + strMethodName + " 点击删除确定OK.-----");
			
			// 点击删除：二次确定
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			logger.info("-----" + strMethodName + " 点击删除：二次确定 OK.-----");

			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
			logger.info("-----" + strMethodName + " Success.-----");
		} catch (UnhandledAlertException e1) {
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_DISMISS);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			logger.info("-----Handle UnhandledAlertException-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception_Success");
			logger.info("-----" + strMethodName + " Exception Success.-----");
		}
	}
		
    /**
     * Search Product.
     */	
	@Test
	public void testSearchProduct() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");			

			// 选择团队过滤
			new Select(driver.findElement(By.name("team_id"))).selectByVisibleText("影谱内部测试");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择团队过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectTeam_SearchResult");	

			// 选择客户过滤
			new Select(driver.findElement(By.name("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择客户过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectCustomer_SearchResult");	
			
			// 取消选择客户过滤
			new Select(driver.findElement(By.name("member_id"))).selectByVisibleText("全部客户");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消客户过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_CancelSelectCustom_SearchResult");
			
			// 取消选择团队过滤
			new Select(driver.findElement(By.name("team_id"))).selectByVisibleText("全部团队");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消团队过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_CancelSelectTeam_SearchResult");	
			
			// 选择状态过滤:生成中
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("生成中");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：生成中 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_1_SearchResult");	

			// 选择状态过滤:生成失败
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("生成失败");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：生成失败 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_2_SearchResult");

			// 选择状态过滤:待审核
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("待审核");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：审核中 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_3_SearchResult");	
			
			// 选择状态过滤:审核中
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("审核中");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：审核中 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_4_SearchResult");		
			
			// 选择状态过滤:未通过
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("未通过");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：未通过 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_5_SearchResult");		

			// 选择状态过滤:已通过
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("已通过");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：已通过 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_6_SearchResult");		

			// 取消选择状态过滤:全部状态
			new Select(driver.findElement(By.name("state"))).selectByVisibleText("全部状态");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消选择状态：全部状态 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_Default_SearchResult");
			
//			// 选择类型过滤:百科信息
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("百科信息");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：百科信息 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_1_SearchResult");
//
//			// 选择类型过滤:购物
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("购物");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：购物 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_2_SearchResult");
//			
//			// 选择类型过滤:红包
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("红包");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：红包 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_3_SearchResult");
//
//			// 选择类型过滤:优惠码
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("优惠码");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：优惠码 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_4_SearchResult");
//			
//			// 选择类型过滤:投票
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("投票");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：投票 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_5_SearchResult");
//
//			// 选择类型过滤:神字幕
//			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("神字幕");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择类型：神字幕 OK.-----");	
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_6_SearchResult");
			
			// 选择类型过滤:易植贴
			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("易植贴");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择类型：易植贴 OK.-----");	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_7_SearchResult");
			
			// 选择类型过滤:动态视窗
			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("动态视窗");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择类型：动态视窗 OK.-----");	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_8_SearchResult");
			
			// 取消选择类型过滤:全部类型
			new Select(driver.findElement(By.name("product_type"))).selectByVisibleText("全部类型");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择类型：全部类型 OK.-----");	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectType_Default_SearchResult");			

			// 名称搜索
			driver.findElement(By.name("product_name")).sendKeys("Auto");
			driver.findElement(By.id("search")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 名称搜索 OK.-----");	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SearchResult");

			// 取消名称搜索
			driver.findElement(By.name("product_name")).clear();
			driver.findElement(By.id("search")).click();
			logger.info("-----" + strMethodName + " 取消名称搜索 OK.-----");	
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SearchResult");
			
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
