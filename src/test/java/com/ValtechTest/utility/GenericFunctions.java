package com.ValtechTest.utility;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ValtechTest.driver.DriverManager;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class GenericFunctions{

	 static Logger log = Logger.getLogger(GenericFunctions.class);
	 static Long maxWaitTimeToFindElement = 20L;
	

	
	// finding element and returning it
	public static WebElement getElement(By locator){
		log.info("Going to get element for locator --> "+locator);
		WebElement e=null;
		try{
			//e = DriverManager.getDriver().findElement(locator);
			e = new WebDriverWait(DriverManager.getDriver(), maxWaitTimeToFindElement)
					.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail("Not able to find the element by locator - "+locator);
			//System.out.println("ERROR-Not able to find the element by locator - "+locator);
		}
			return e;
	}
	
	public static void clickLinkText(String linkText) {
			getElement(By.xpath("//*[text()='"+linkText+"']")).click();
	}
	
	
	public static List<WebElement> getElementList(By locator){
		log.info("Going to get element List for locator --> "+locator);
		List<WebElement> e=null;
		try{
			e = new WebDriverWait(DriverManager.getDriver(), maxWaitTimeToFindElement).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		//	e = DriverManager.getDriver().findElements(locator);
		}catch(Exception ex){
			ex.printStackTrace();
			Assert.fail("Not able to find the element by locator - "+ex.getMessage());
		}
			return e;
	}
	

	
	public static int getListSize(By locator){
		log.info("Getting list size of "+locator);
		return getElementList(locator).size();
	}
	

	public static boolean isElementPresent(By locator){
		if(getElementList(locator).size()==0)
			return false;	
		else
			return true;
	}
	
	
	public static String getText(By locator){
		log.info("Getting text from "+locator);
		return getElement(locator).getText();
	}
	

	public static void click(By locator){
			log.info("Clicking on "+locator);
			getElement(locator).click();
			log.info("Clicked successfully on "+locator);
		
	}
	
	public static void type(By locator,String data){
		log.info("Tying in "+locator+". Data - "+data);
		getElement(locator).sendKeys(data);
		log.info("Typed successfully in "+locator);
	}
	
	
	public static boolean isTextPresent(By locator,String expectedTextKey){
		String actualText=getElement(locator).getText().trim();
		String expectedText=(expectedTextKey);
		if(actualText.equals(expectedText))
			return true;
		else 
			return false;
	}
	

	public static void goToSiteUrl(String url) {
		DriverManager.getDriver().navigate().to(url);
		
	}
	 

	 
}
	


