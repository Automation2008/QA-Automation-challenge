package com.ValtechTest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ValtechTest.driver.DriverManager;
import com.ValtechTest.pageObjects.LandingPageObjects;
import com.ValtechTest.utility.GenericFunctions;


public class LandingActionPage{
	
	LandingPageObjects laningPgOR;
	private WebDriver driver;
	
	
	public LandingActionPage(){
	
		laningPgOR=new LandingPageObjects();
		this.driver = DriverManager.getDriver();
	}
	
	
	
	public void acceptCookie(){	
		GenericFunctions.click(laningPgOR.getCookieBtn());
	}
	
		
	public void ClickPgLink(String pgLink){
		GenericFunctions.clickLinkText(pgLink);
	//	driver.findElement(By.xpath("//*[text()='"+pgLink+"']")).click();
	}
	
	
	public void clickMenuToggleBtn(){
		GenericFunctions.click(laningPgOR.getMenuToggleBtn());
	}
	
	public void clickContactUsToggleBtn(){
		GenericFunctions.click(laningPgOR.getContactUsToggleBtn());
	}
	
	public boolean isTextPresent(String exptText){
		if(exptText.equals("LATEST NEWS")){
			return GenericFunctions.isTextPresent(laningPgOR.getaLtestNewsText(), exptText);
		}else{
			return GenericFunctions.isTextPresent(laningPgOR.getPgHeaderText(), exptText);
		}
	}
	
	public void clickLogo(){
		GenericFunctions.click(laningPgOR.getLogo());
	}
	
	
	public int findNumOffices(){
		int numOffices=GenericFunctions.getListSize(laningPgOR.getFindUsOffices());
		return numOffices;
	}
	
	
	
}
