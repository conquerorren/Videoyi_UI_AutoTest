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

/**
 * Command constants.This class defines all types of the command.
 * 
 * @author Ren Qiang
 * 
 * @date 2017/07/14
 */
public class DriverConstant {
    /**
     * Current workspace path.
     */
    public static final String WORKSPACE_DIR_PATH = System.getProperty("user.dir");
    
    /**
     * File Screen Shot Path.
     */
    public static final String SCREENSHOT_PATH = WORKSPACE_DIR_PATH + "\\screenshot\\";
    		//"E:\\Yingpu\\000.SVNYP\\01.个人文件夹\\Renqiang\\04.AutoTest\\videoyiAutoTest\\screenshot\\";

    /**
     * IE Driver Server Path.
     */
    public static final String IE_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\lib\\IEDriverServer.exe";
    		//"E:\\Yingpu\\000.SVNYP\\01.个人文件夹\\Renqiang\\04.AutoTest\\videoyiAutoTest\\lib\\IEDriverServer.exe";

    /**
     * Chrome Driver Server Path.
     */
    public static final String Chrome_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\lib\\chromedriver.exe";
        		//"E:\\Yingpu\\000.SVNYP\\01.个人文件夹\\Renqiang\\04.AutoTest\\videoyiAutoTest\\lib\\chromedriver.exe";

    /**
     * Upload Image File Exe Path.
     */
    public static final String UPLOAD_FILE_EXE_PATH = DriverConstant.WORKSPACE_DIR_PATH + "\\lib\\uploadFile.exe";

    /**
     * Upload Image File Exe Path For Firefox.
     */
    public static final String UPLOAD_FILE_EXE_PATH_FIREFOX = DriverConstant.WORKSPACE_DIR_PATH + "\\lib\\uploadFile_FireFox.exe";
    
    /**
     * Firefox Driver Server Path.
     */
    public static final String FIREFOX_DRIVER_SERVER = WORKSPACE_DIR_PATH + "\\lib\\firefox43\\firefox.exe";
    
    /**
     * Thread Sleep Time.
     */    
    public static final int THREAD_SLEEP_SHORT_TIME = 1000;    

    /**
     * Thread Sleep Time.
     */    
    public static final int THREAD_SLEEP_LONG_TIME = 3000; 
    
    /**
     * Thread Sleep Time.
     */    
    public static final int THREAD_SLEEP_DOWNLOAD_TIME = 10000;      
    
    /**
     * TEST Base URL Path.
     */
    public static final String TEST_BASE_URL = "http://test.videoyi.cn";

    /**
     * Screen shot Flag on/off.
     */    
    public static final boolean SCREEN_SHORT_FLAG = false; 
    
    /**
     * Screen recorder Flag on/off.
     */    
    public static final boolean SCREEN_RECORDER_FLAG = false;    
    
    /**
     * Alert Accept.
     */    
    public static final int ALERT_ACCEPT = 1;   
    
    /**
     * Alert Dismiss.
     */    
    public static final int ALERT_DISMISS = 2;       
    
}
