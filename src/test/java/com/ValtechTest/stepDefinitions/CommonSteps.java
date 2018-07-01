package com.ValtechTest.stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.ValtechTest.pages.LandingActionPage;
import com.ValtechTest.utility.GenericFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class CommonSteps{
	

	static Logger log = Logger.getLogger(CommonSteps.class);
	private LandingActionPage landingPg=new LandingActionPage();
	
	@Given("^I go to Test Url \"([^\"]*)\"$")
	public void i_go_to_Test_Url(String url){
		GenericFunctions.goToSiteUrl(url);
	}
	
	@And("^I click \"([^\"]*)\" page link$")
	public void i_click_page_link(String linkText){
		landingPg.ClickPgLink(linkText);
	}
	
	@And("^I click on valtech logo$")
	public void i_click_on_valtech_logo(){
		landingPg.clickLogo();
	}
	
	@Then("^I verify \"([^\"]*)\" page is present$")
	public void i_verify_text_is_present(String exptText) throws InterruptedException{
		try{
			Assert.assertEquals(landingPg.isTextPresent(exptText), true);
		}catch(AssertionError e){
			Assert.fail(exptText +" - expected Page is not displayed");
			//System.err.println(exptText +" - expected Page is not displayed");
		}
	}

																									
	

	
}
