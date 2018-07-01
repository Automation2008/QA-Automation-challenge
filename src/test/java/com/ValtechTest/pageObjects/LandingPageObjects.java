package com.ValtechTest.pageObjects;

import org.openqa.selenium.By;


public class LandingPageObjects {

   
	
	private By cookieBtn=By.id("CybotCookiebotDialogBodyLevelButtonAccept");
	private By menuToggleBtn=By.id("menu-toggle-button");
	private By contactUsToggleBtn=By.id("contacticon");
	private By pageHeaderText=By.tagName("h1");
	private By latestNewsText=By.xpath("//*[@class='block-header__heading' and text()='Latest news']");
	private By valtechLogo=By.cssSelector("a[class=header__logo]");
	private By findUsOffices=By.xpath("//*[@class='contactcountry']/ul/li");
 
	
	public By getCookieBtn(){
		return cookieBtn;
	}
	
	public By getMenuToggleBtn(){
		return menuToggleBtn;
	}
	
	public By getContactUsToggleBtn(){
		return contactUsToggleBtn;
	}
   
	public By getPgHeaderText(){
		return pageHeaderText;
	}
	
	public By getaLtestNewsText(){
		return latestNewsText;
	}
   
	public By getLogo(){
		return valtechLogo;
	}
	
	public By getFindUsOffices(){
		return findUsOffices;
	}
}
