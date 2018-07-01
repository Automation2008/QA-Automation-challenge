package com.ValtechTest.stepDefinitions;

import org.apache.log4j.Logger;
import com.ValtechTest.pages.LandingActionPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;



public class LandingPgSteps{
	

	private LandingActionPage landingPg=new LandingActionPage();
	static Logger log = Logger.getLogger(LandingPgSteps.class);
	
	
	
	
	@And("^I accept the cookie$")
	public void acceptCookie(){
		landingPg.acceptCookie();
	}
	
	@And("^I click on toggle button$")
	public void i_click_on_toggle_button(){
		landingPg.clickMenuToggleBtn();
	}
	
	@And("^I click on contactUs toggle button$")
	public void click_contactUs_toggle_button(){
		landingPg.clickContactUsToggleBtn();
	}
	
	@Then("^I find number of offices$")
	public void findNumOffices(){
		System.out.println("Number of total Voltech offices is "+landingPg.findNumOffices());
	}

}
