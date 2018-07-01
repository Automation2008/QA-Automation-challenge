package com.ValtechTest.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.ValtechTest.driver.DriverManager;
import com.ValtechTest.driver.LocalDriverFactory;


public class Hooks {

    static Logger log;

    static {
        log = Logger.getLogger(Hooks.class);
    }

 
    @Before
    public void beforeHook() {
	    	WebDriver driver = null;
	    	if(DriverManager.scope.equals("local")) {
	            driver = LocalDriverFactory.createInstance(DriverManager.getBrower());
	    	} else {
	    		//driver = LocalDriverFactory.createInstance(DriverManager.getBrower());
	    		// driver = RemoteDriverFactory.createInstance(DriverManager.getBrower());
	    	}
	            DriverManager.setWebDriver(driver);
	            
    }

    /*
     * Embed a screenshot in test report if test is marked as failed
     */
    
    @After
    public static void embedScreenshot(Scenario scenario) {
    	
        if ( scenario.isFailed() ) {
            log.error("Scenario failed! Browser: " + DriverManager.getBrowserInfo() + " Taking screenshot...");
            scenario.write("Current Page URL is: " + DriverManager.getDriver().getCurrentUrl());
            scenario.write("Scenario Failed in: " + DriverManager.getBrowserInfo());
            try {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                log.error(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        DriverManager.getDriver().quit(); 
    }
}