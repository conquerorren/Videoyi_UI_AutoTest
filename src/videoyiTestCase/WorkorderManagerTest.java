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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.DriverConstant;
import common.DriverUtility;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;

public class WorkorderManagerTest {
	private static Logger logger= LogManager.getLogger(WorkorderManagerTest.class.getName());
	private static WebDriver driver;
//	@FindBy( how = How.XPATH, xpath = "//*[@id='mainzsy']/tbody/tr/td[2]/div[1]/div[2]/div[7]/input" )
//	WebElement newWorkorder;
	
    /**
     * Init webDriver.
     */
	public static void setWebDriver(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /**
     * Jump Into Workorder Manager.
     */
	@Test
	public void testWorkorderManager() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击导航：投放管理
			driver.findElement(By.id("rightbg00000070")).click();
			logger.info("-----" + strMethodName + " 导航：投放管理 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");

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
	
    /**
     * Create Workorder.
     */
	@Test
	public void testCreateWorkorder() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
				
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击新建投放计划
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[1]/div[2]/div[9]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击新建投放计划 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 计划名称
			driver.findElement(By.name("work_video_name")).clear();
			driver.findElement(By.name("work_video_name")).sendKeys("AutoTest_计划名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 计划名称 OK.-----");
			
		    // 团队归属
			new Select(driver.findElement(By.id("team_id"))).selectByVisibleText("影谱内部测试");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 团队归属 OK.-----");
			
			// 客户归属
			new Select(driver.findElement(By.id("member_id"))).selectByVisibleText("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户归属 OK.-----");

			// 费用
			driver.findElement(By.name("budget")).clear();
			driver.findElement(By.name("budget")).sendKeys("2345");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 费用 OK.-----");

			// 时间：开始时间
//			driver.findElement(By.id("d4311")).clear();
//			Date now = new Date(); 
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			String strTimeStampFileName = dateFormat.format(now);
//			driver.findElement(By.id("d4311")).sendKeys(strTimeStampFileName);
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 时间：开始时间 OK.-----");

			// 时间：结束时间
//			driver.findElement(By.id("d4311")).clear();
//			driver.findElement(By.id("d4311")).sendKeys("");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 时间：结束时间 OK.-----");

			// 不需要关联操作时
//			// 点击更多按钮
//			driver.findElement(By.id("more_button")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 时间：点击更多按钮 OK.-----");
//			
//			// 关联植入易计划
//			new Select(driver.findElement(By.id("assoc_work_id"))).selectByVisibleText("rq芒果SDK性能测试计划");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 关联植入易计划 OK.-----");
//
//			// 刊例单价
//			driver.findElement(By.name("unit_price")).clear();
//			driver.findElement(By.name("unit_price")).sendKeys("122");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 刊例单价 OK.-----");
//
//			// 折扣比例
//			driver.findElement(By.name("discount_ratio")).clear();
//			driver.findElement(By.name("discount_ratio")).sendKeys("10");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 折扣比例 OK.-----");
//
//			// 折让单价
//			driver.findElement(By.name("discount_price")).clear();
//			driver.findElement(By.name("discount_price")).sendKeys("142");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
//			logger.info("-----" + strMethodName + " 折让单价 OK.-----");	
//			
//			// 时长
//			driver.findElement(By.name("duration")).clear();
//			driver.findElement(By.name("duration")).sendKeys("2390");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
//			logger.info("-----" + strMethodName + " 时长 OK.-----");	
//			
//			// 周期
//			driver.findElement(By.name("cycle")).clear();
//			driver.findElement(By.name("cycle")).sendKeys("3月");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
//			logger.info("-----" + strMethodName + " 周期 OK.-----");	
			
			// 点击确定
			driver.findElement(By.id("submit")).click();
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");	

			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
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
     * Search Workorder.
     */
	@Test
	public void testSearchWorkorder() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击导航：投放管理
			driver.findElement(By.id("rightbg00000070")).click();
			logger.info("-----" + strMethodName + " 导航：投放管理 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");

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

			// 选择状态过滤:已完成
			new Select(driver.findElement(By.name("work_state"))).selectByVisibleText("已完成");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：已完成 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_1_SearchResult");	

			// 选择状态过滤:投放中
			new Select(driver.findElement(By.name("work_state"))).selectByVisibleText("投放中");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择状态：投放中 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_2_SearchResult");

			// 取消选择状态过滤:全部状态
			new Select(driver.findElement(By.name("work_state"))).selectByVisibleText("全部状态");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消选择状态：全部状态 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectStatus_Default_SearchResult");

			// 选择平台过滤
			new Select(driver.findElement(By.name("platform"))).selectByVisibleText("芒果TV");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择平台过滤：芒果TV OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectPlatform_mgtv_SearchResult");

			// 取消选择平台过滤
			new Select(driver.findElement(By.name("platform"))).selectByVisibleText("全部平台");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择平台过滤：全部平台 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SelectPlatform_All_SearchResult");
			
			// 开始时间
			driver.findElement(By.name("start_time_val")).clear();
			driver.findElement(By.name("start_time_val")).sendKeys("2017-07-21");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 开始时间过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_StartTime_SearchResult");

			// 结束时间
			driver.findElement(By.name("end_time_val")).clear();
			driver.findElement(By.name("end_time_val")).sendKeys("");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 结束时间过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_EndTime_SearchResult");
			
			// 取消开始时间过滤
			driver.findElement(By.name("start_time_val")).clear();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消开始时间过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_CancelStartTime_SearchResult");
			
			// 关键字过滤
			driver.findElement(By.name("search_key")).clear();
			driver.findElement(By.name("search_key")).sendKeys("Auto");
			driver.findElement(By.id("search")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 关键字过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Keyword_SearchResult");

			// 取消关键字过滤
			driver.findElement(By.name("search_key")).clear();
			driver.findElement(By.id("search")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 取消关键字过滤 OK.-----");	
			
			// 点击导出按钮
			driver.findElement(By.id("export_work")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击导出按钮 OK.-----");			

			Thread.sleep(DriverConstant.THREAD_SLEEP_DOWNLOAD_TIME);
			// 关闭下载窗口
			DriverUtility.closeSubWindow(driver);	
			
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
     * Edit Workorder Manager.
     */
	@Test
	public void testEditWorkorder() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击投放计划编辑按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[15]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击投放计划编辑按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 计划名称
			driver.findElement(By.name("work_video_name_val")).clear();
			driver.findElement(By.name("work_video_name_val")).sendKeys("AutoTest_计划名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 计划名称修改 OK.-----");
			
			// 创建时间
			driver.findElement(By.name("create_time")).clear();
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strTimeStampFileName = dateFormat.format(now);
			driver.findElement(By.name("create_time")).sendKeys(strTimeStampFileName);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 时间：创建时间 OK.-----");
			
			// 关联计划修改
			new Select(driver.findElement(By.id("assoc_work_id"))).selectByVisibleText("不关联");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 关联计划修改 OK.-----");
			
			// 确定
    		driver.findElement(By.id("MonSubmitBtn")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 确定 OK.-----");	
			
			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");			
			
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
     * Abort Workorder.
     */
	@Test
	public void testAbortWorkorderCancel() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击计划完成按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[16]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击计划完成按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击取消
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_DISMISS);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击取消 OK.-----");
			
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
     * Abort Workorder.
     */
	@Test
	public void testAbortWorkorderOK() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击计划完成按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[16]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击计划完成按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
						
			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");
			
			// 点击确定：二次确定
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			logger.info("-----" + strMethodName + " 点击完成：二次确定 OK.-----");
			
			boolean isAbortExist = DriverUtility.isElementPresent(driver, By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[12]/span/img"));
			logger.info("-----" + strMethodName + " 完成按钮的显示状态："+ isAbortExist + ".-----");
			
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
     * Delete Workorder Cancel.
     */
	@Test
	public void testDeleteWorkorderCancel() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击计划删除按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[17]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击计划删除按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击取消
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_DISMISS);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击取消 OK.-----");
			
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
     * Delete Workorder OK.
     */
	@Test
	public void testDeleteWorkorderOK() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击计划删除按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[17]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击计划删除按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击确定
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击确定 OK.-----");
			
			// 点击确定：二次确定
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			logger.info("-----" + strMethodName + " 点击完成：二次确定 OK.-----");
			
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
     * Monitor Workorder OK.
     */
	@Test
	public void testMonitorWorkorder() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击监控按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[19]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击监控按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");

			// 点击返回按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[8]/div/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + "点击返回按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");			

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
	
    /**
     * Assocation Workorder OK.
     */
	@Test
	public void testAssocWorkorder() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击关联按钮
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[20]/span/img")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击关联按钮 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 查看是否跳转到关联，点击返回按钮
			if (!driver.getCurrentUrl().equals(DriverConstant.TEST_BASE_URL + "/workorder/index")){
				driver.navigate().back();
				Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
				
				// 验证：跳转后URL
			    String strURL = driver.getCurrentUrl();	
				Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/workorder/index", strURL);
				logger.info("-----" + strMethodName + " verify url：" + strURL + "-----");
			}
			
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
     * Drama List Page.
     */
	@Test
	public void testWorkorderDramaList() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击投放计划名称
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div[2]/table/tbody/tr[2]/td[1]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 投放计划名称 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
						
			// 验证：跳转后URL
		    String strURL = driver.getCurrentUrl();	
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
     * Drama List Page.
     */
	@Test
	public void testCreateDrama() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击选择媒资
			driver.findElement(By.xpath("//*[@id='app']/div[6]/button")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " 点击选择媒资 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_DramaList");						
			
//			// 选择平台：芒果
//			driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div[2]/div[1]/div[1]/div[1]/input")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择平台：下拉菜单 OK.-----");
//			
//			driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/ul/li[2]")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择平台：影谱 OK.-----");				

			// 测试剧目：芒果TV2016招商片			
//			driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[2]/div[1]/div[3]/input")).clear();
//			driver.findElement(By.xpath("//*[@id=’app']/div[1]/div/div[2]/div[1]/div[3]/input")).sendKeys("芒果TV2016招商片");
//			driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[2]/div[1]/div[3]/i")).click();			
			driver.findElement(By.cssSelector("div.el-input:nth-child(3) > input:nth-child(2)")).clear();
			driver.findElement(By.cssSelector("div.el-input:nth-child(3) > input:nth-child(2)")).sendKeys("芒果TV2016招商片");
			driver.findElement(By.cssSelector("div.el-input:nth-child(3) > i:nth-child(1)")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择平台：影谱剧 OK.-----");		

			// 选择芒果测试剧目
			driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/label/span[1]/span")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择芒果测试剧目 OK.-----");			
			
			// 点击选择集按钮
			driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[3]/div/button[3]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击选择集按钮 OK.-----");

			// 选择集画面：选择复选框
			driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/label/span")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 选择集画面：选择复选框 OK.-----");
			
			// 点击选择集确定按钮
			driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[3]/div/button[2]")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击选择集确定按钮 OK.-----");
		
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
		
//    /**
//     * Create Point.
//     */
//	@Test
//	public void testCreatePoint() throws Exception {
//		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
//		
//		try {
//			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
//			logger.info("-----" + strMethodName + " Start.-----");
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
//			
//			// 点击添加智点
//			driver.findElement(By.cssSelector("#app > div.el-table.el-table--fit.el-table--border.el-table--enable-row-hover.el-table--enable-row-transition > div.el-table__body-wrapper > table > tbody > tr > td.el-table_1_column_10.is-center > div > button:nth-child(1)")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
//			logger.info("-----" + strMethodName + " 点击添加智点 OK.-----");
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_DramaList");					
//			
//			// 选择类型：易植贴			
////			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(1) > div > div > div > div.el-input > input")).click();
////			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
////			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
////			logger.info("-----" + strMethodName + " 选择类型：易植贴OK.-----");
//			
//			// 选择模式:次数模式
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(1) > div > div > label:nth-child(1) > span.el-radio__input.is-checked")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择模式:次数模式.-----");
//			
//			// 开始时间:分
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(2) > div > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(2) > div > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("1");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 开始时间:分.-----");
//			
//			// 开始时间:秒 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(2) > div > div:nth-child(2) > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(2) > div > div:nth-child(2) > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("0");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 开始时间:秒.-----");			
//			
//			// 结束时间:分 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(3) > div > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(3) > div > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("1");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 结束时间:分.-----");
//			
//			// 结束时间:秒 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(3) > div > div:nth-child(2) > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(3) > div > div:nth-child(2) > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("10");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 结束时间:秒.-----");
//			
//			// 展现时长 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div.el-form-item.is-error.is-required > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("10");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 展现时长 .-----");
//			
//			// 展现次数 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(5) > div > div.el-input.el-input-group.el-input-group--append > input")).clear();
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(5) > div > div.el-input.el-input-group.el-input-group--append > input")).sendKeys("1");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 展现次数.-----");			
//			
//			// 选择物料
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(6) > div > div > div.el-input > input")).clear();
//			new Select(driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(6) > div > div > div.el-input > input"))).selectByVisibleText("AutoTest_易植贴物料名");
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 选择物料.-----");
//			
//			// 动效:无
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-10 > div:nth-child(8) > div > div > label:nth-child(1) > span.el-radio__input.is-checked")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 动效:无.-----");
//			
//			// 坐标:左下 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > form:nth-child(4) > div > div.el-col.el-col-14 > div > div > div > label:nth-child(1) > span.el-radio__input > span")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 坐标:左下.-----");		
//			
//			// 点击确定按钮 
//			driver.findElement(By.cssSelector("#app > div:nth-child(1) > div > div.el-dialog__body > div > button.el-button.el-button--primary")).click();
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
//			logger.info("-----" + strMethodName + " 点击添加智点确定按钮 OK.-----");
//		
//			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);			
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_Success");
//			logger.info("-----" + strMethodName + " Success.-----");
//		} catch (Exception e1) {
//			// Add a message to your Log File to capture the error
//			logger.error("-----" + strMethodName + " failed.-----");
//			logger.error(e1);
//			// Take a screenshot which will be helpful for analysis.
//			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception");
//			throw (e1);
//		}
//	}
}
