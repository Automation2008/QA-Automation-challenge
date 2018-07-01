package com.ValtechTest.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;


public class DriverManager {
	
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<String> browser = new ThreadLocal<String>();
    static Logger log;
    public static String scope;

    static {
        log = Logger.getLogger(DriverManager.class);
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            // this is needed when running tests from IDE
            log.info("Thread has no WedDriver, creating new one");
            if(DriverManager.scope == "local") {
            	setWebDriver(LocalDriverFactory.createInstance(DriverManager.getBrower()));
            } else {
            	setWebDriver(LocalDriverFactory.createInstance(DriverManager.getBrower()));
            }
        }
        log.debug("Getting instance of remote driver" + driver.get().getClass());
        return driver.get();
    }
    
    //Below setter and getter for browser to facilitate browser for each scenario
    public static String getBrower() {
        if (browser.get() == null) {
            DriverManager.browser.set("firefox");
        }
        return browser.get();
    }

    public static void setBrowser(String brwsr) {
    	 DriverManager.browser.set(brwsr);
    }

    public static void setWebDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        DriverManager.driver.set(driver);
    }

    /**
     * Returns a string containing current browser name, its version and OS name.
     * This method is used in the the *WebDriverListeners to change the test name.
     * */
    public static String getBrowserInfo(){
        log.debug("Getting browser info");
        // we have to cast WebDriver object to RemoteWebDriver here, because the first one does not have a method
        // that would tell you which browser it is driving.
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        String b = cap.getBrowserName();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion();
        return String.format("%s v:%s %s", b, v, os);
    }
}