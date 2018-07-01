package com.ValtechTest.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LocalDriverFactory {
    public static WebDriver createInstance(String browserName) {
        WebDriver driver;
        browserName = (browserName != null) ? browserName : "firefox";

        switch (Browser.valueOf(browserName.toUpperCase())) {
            case FIREFOX:
            		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckoDriver//geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            	/*case CHROME:
            		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromeDriver//chromedriver.exe");
                driver = new ChromeDriver();
                break;*/
            default:
                driver = new FirefoxDriver();
                break;
        }
        
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// maximize browser's window on start
        driver.manage().window().maximize();
        return driver;
    }

    private static enum Browser {
        FIREFOX,
        CHROME
    }
}