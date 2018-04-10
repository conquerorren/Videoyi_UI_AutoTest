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
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.DriverConstant;
import common.DriverUtility;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class MemberManagerTest {
	private static Logger logger= LogManager.getLogger(MemberManagerTest.class.getName());
	private static WebDriver driver;
	
    /**
     * Init webDriver.
     */
	public static void setWebDriver(WebDriver webDriver)
	{
		driver = webDriver;
	}
	
    /**
     * Jump Into Member Manager.
     */
	@Test
	public void testMemberManager() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			
			// 点击导航：客户管理
			driver.findElement(By.id("rightbg00000100")).click();
			logger.info("-----" + strMethodName + " 导航：客户管理 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");

			// 验证：跳转后URL
			String strURL = driver.getCurrentUrl();	
			Assert.assertEquals(DriverConstant.TEST_BASE_URL + "/member/index", strURL);
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
     * Create Member.
     */
	@Test
	public void testCreateMember() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
				
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 点击新建客户
			driver.findElement(By.xpath("//*[@id='mainzsy']/tbody/tr/td[2]/div/div[2]/div[3]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击新建客户 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 客户名称
			driver.findElement(By.id("username")).sendKeys("AutoTest客户");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户名称 OK.-----");
			
			// 归属团队
			driver.findElement(By.id("team_id")).sendKeys("影谱内部测试");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 归属团队 OK.-----");

			// 公司名称
			driver.findElement(By.id("member_company_name")).sendKeys("AutoTest公司");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 公司名称 OK.-----");

			// 公司行业
			new Select(driver.findElement(By.id("member_trade"))).selectByVisibleText("广告传媒");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 公司行业 OK.-----");

			// 公司地区
			new Select(driver.findElement(By.id("member_area"))).selectByVisibleText("中国");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 公司地区 OK.-----");

			// 城市
			new Select(driver.findElement(By.id("member_area_city"))).selectByVisibleText("北京");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 城市 OK.-----");

			// 区县
			new Select(driver.findElement(By.id("member_area_section"))).selectByVisibleText("海淀");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 区县 OK.-----");

			// 客户姓名
			driver.findElement(By.id("member_contacts_name")).sendKeys("AutoTest名称");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户姓名 OK.-----");

			// 客户电话
			driver.findElement(By.id("member_contacts_mobile")).sendKeys("13013112121");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 客户电话 OK.-----");

			// 客户职务
			driver.findElement(By.id("member_contacts_position")).sendKeys("AutoTest职位");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			logger.info("-----" + strMethodName + " 客户职务 OK.-----");	

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
     * Search Member.
     */
	@Test
	public void testSearchMember() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");

			// 关键字过滤
			driver.findElement(By.id("username")).sendKeys("Auto");
			driver.findElement(By.id("search")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 关键字过滤 OK.-----");		
			DriverUtility.TakeScreenShot(driver, strMethodName + "_SearchResult");

			// 取消关键字过滤
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("search")).click();
			logger.info("-----" + strMethodName + " 取消关键字过滤 OK.-----");	
			
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
     * Edit Member.
     */
	@Test
	public void testEditMember() throws Exception {
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击编辑客户
			driver.findElement(By.xpath("//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[9]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 点击编辑客户 OK.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Edit");
			
			// 客户名称
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("AutoTest客户修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑客户名称 OK.-----");
			
			// 公司名称
			driver.findElement(By.id("member_company_name")).clear();
			driver.findElement(By.id("member_company_name")).sendKeys("AutoTest公司修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑公司名称 OK.-----");

			// 公司行业
			new Select(driver.findElement(By.id("member_trade"))).selectByVisibleText("纸媒");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑公司行业 OK.-----");

			// 公司地区
			new Select(driver.findElement(By.id("member_area"))).selectByVisibleText("中国");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑公司地区 OK.-----");

			// 城市
			new Select(driver.findElement(By.id("member_area_city"))).selectByVisibleText("天津");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑城市 OK.-----");

			// 区县
			new Select(driver.findElement(By.id("member_area_section"))).selectByVisibleText("河东");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑区县 OK.-----");

			// 客户姓名
			driver.findElement(By.id("member_contacts_name")).clear();
			driver.findElement(By.id("member_contacts_name")).sendKeys("AutoTest名称修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑客户姓名 OK.-----");

			// 客户电话
			driver.findElement(By.id("member_contacts_mobile")).clear();
			driver.findElement(By.id("member_contacts_mobile")).sendKeys("18612191213");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " 编辑客户电话 OK.-----");

			// 客户职务
			driver.findElement(By.id("member_contacts_position")).clear();
			driver.findElement(By.id("member_contacts_position")).sendKeys("AutoTest职位修改");
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			logger.info("-----" + strMethodName + " 编辑客户职务 OK.-----");	

			// 点击确定
			driver.findElement(By.id("submit")).click();
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
     * Delete Member： Click Cancel.
     */
	@Test
	public void testDeleteMemberCancel() throws Exception {		
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击删除
			driver.findElement(By.xpath("//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[10]/input")).click();
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
     * Delete Member： Click OK.
     */
	@Test
	public void testDeleteMemberOK() throws Exception {		 
		String strMethodName = new Exception().getStackTrace()[0].getMethodName();
		
		try {
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
			logger.info("-----" + strMethodName + " Start.-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Init");
			
			// 点击删除：确定
			driver.findElement(By.xpath("//*[@id='right_middle_a']/div[1]/table/tbody/tr[2]/td[10]/input")).click();
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);
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
			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);

			DriverUtility.closeAlertAndGetItsText(driver, DriverConstant.ALERT_ACCEPT);
			Thread.sleep(DriverConstant.THREAD_SLEEP_SHORT_TIME);	
			
			Thread.sleep(DriverConstant.THREAD_SLEEP_LONG_TIME);	
			logger.info("-----Handle UnhandledAlertException-----");
			DriverUtility.TakeScreenShot(driver, strMethodName + "_Exception_Success");
			logger.info("-----" + strMethodName + " Exception Success.-----");
		}
	}	
}
